package com.neu.his.cloud.service.dms.service.impl;

import com.neu.his.cloud.service.dms.dto.app.AppRegistrationParam;
import com.neu.his.cloud.service.dms.dto.dms.DmsRegHistoryResult;
import com.neu.his.cloud.service.dms.dto.dms.DmsRegistrationParam;
import com.neu.his.cloud.service.dms.mapper.*;
import com.neu.his.cloud.service.dms.model.*;
import com.neu.his.cloud.service.dms.service.DmsRegistrationService;
import com.neu.his.cloud.service.dms.util.AgeStrUtil;
import com.neu.his.cloud.service.dms.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DmsRegistrationServiceImpl implements DmsRegistrationService {
    @Autowired
    private PmsPatientMapper pmsPatientMapper;
    @Autowired
    private SmsSkdMapper smsSkdMapper;
    @Autowired
    private SmsStaffMapper smsStaffMapper;
    @Autowired
    private SmsRegistrationRankMapper smsRegistrationRankMapper;
    @Autowired
    private DmsRegistrationMapper dmsRegistrationMapper;
    @Autowired
    private BmsBillsRecordMapper bmsBillsRecordMapper;
    @Autowired
    private BmsInvoiceRecordMapper bmsInvoiceRecordMapper;
    @Autowired
    private  SmsDeptMapper smsDeptMapper;

    //1.调用PmsPatientDao根据身份证号查询是否存在
    //2.1如果不存在，则向PmsPatient表中插入数据，返回id
    //3.判断是否为专家号
    //3.1 如果为专家号，则先根据skd_id判断remain是否>0，如果大于0，则向dms_registration插入信息，并且绑定医生（skd_id、bind_status=1）,并修改sms_skd中的排班限额（-1），否则挂号失败
    //3.2 如果为非专家号，则向dms_registration插入信息，bin_status=0
    //4.向bms_bills_record中插入账单记录
    //5. 通过门诊号和最近时间返回账单id
    //6.插入发票记录
    @Override
    public int createRegistration(DmsRegistrationParam dmsRegistrationParam) {
        PmsPatientExample example = new PmsPatientExample();
        example.createCriteria().andIdentificationNoEqualTo(dmsRegistrationParam.getIdentificationNo());
        List<PmsPatient> pmsPatientList = pmsPatientMapper.selectByExample(example);
        if (pmsPatientList.size() == 0) {//如果不存在，则向PmsPatient表中插入数据
            PmsPatient pmsPatient = new PmsPatient();
            BeanUtils.copyProperties(dmsRegistrationParam, pmsPatient);
            //生成病历号
            String medicalRecordNo = generateMedicalRecordNo(dmsRegistrationParam.getIdentificationNo());
            pmsPatient.setMedicalRecordNo(medicalRecordNo);
            pmsPatientMapper.insertSelective(pmsPatient);
        }
        //通过身份证号查询并返回病人id
        PmsPatientExample example1 = new PmsPatientExample();
        example1.createCriteria().andIdentificationNoEqualTo(dmsRegistrationParam.getIdentificationNo());
        List<PmsPatient> pmsPatientList1 = pmsPatientMapper.selectByExample(example1);
        if(!pmsPatientList1.isEmpty()){
            Long patientId = pmsPatientList1.get(0).getId();

            //创建要插入的DmsRegistration对象
            DmsRegistration dmsRegistration = new DmsRegistration();
            BeanUtils.copyProperties(dmsRegistrationParam, dmsRegistration);
            dmsRegistration.setPatientId(patientId);
            Date createDate = new Date();//获取当前时间，并在之后通过该时间与病人id获取挂号id
            dmsRegistration.setCreateTime(createDate);
            dmsRegistration.setStatus(1);//挂号状态为待诊1

            //处理年龄
            Date dateOfBirth = dmsRegistrationParam.getDateOfBirth();
            String age = AgeStrUtil.getAgeStr(dateOfBirth);
            dmsRegistration.setPatientAgeStr(age);

            Long registrationId;//用于存储插入的挂号信息的id

            if (dmsRegistrationParam.getSkdId() == null){//非专家号
                dmsRegistration.setBindStatus(0);//非专家号绑定状态为0
                dmsRegistrationMapper.insertSelective(dmsRegistration);//向dms_registration插入信息

                registrationId = dmsRegistration.getId();
            }
            else{//专家号
                SmsSkdExample example2 = new SmsSkdExample();
                example2.createCriteria().andIdEqualTo(dmsRegistrationParam.getSkdId());
                List<SmsSkd> smsSkdList = smsSkdMapper.selectByExample(example2);
                if (!smsSkdList.isEmpty()){
                    if (smsSkdList.get(0).getRemain() > 0) {//如果还有挂号限额
                        dmsRegistration.setBindStatus(1);//专家号绑定状态为1
                        dmsRegistrationMapper.insertSelective(dmsRegistration);//向dms_registration插入信息
                        registrationId = dmsRegistration.getId();

                        SmsSkd smsSkd = smsSkdList.get(0);
                        smsSkd.setRemain(smsSkdList.get(0).getRemain() - 1);
                        //smsSkdList.get(0).setRemain(smsSkdList.get(0).getRemain()-1);
                        smsSkdMapper.updateByPrimaryKey(smsSkd);//修改sms_skd中的排班限额（-1）
                        //return 1;
                    } else {//挂号限额已用完，挂号失败
                        return 0;
                    }
                }
                else {
                    return 0;//无该排班信息,挂号失败
                }

            }
            BmsBillsRecord bmsBillsRecord = new BmsBillsRecord();//保存除了发票号以外的所有属性

            //生成账单号
            String billNo = generateBillNo(registrationId);
            bmsBillsRecord.setBillNo(billNo);
            Date billCreateDate = new Date();//获取当前时间，并在之后通过该时间与病人id获取账单id
            bmsBillsRecord.setCreateTime(billCreateDate);
            bmsBillsRecord.setStatus(1);//1为正常
            bmsBillsRecord.setInvoiceNum(1);//挂号只有一张发票
            bmsBillsRecord.setRegistrationId(registrationId);
            bmsBillsRecord.setRecordList(registrationId + "," + 0 + "><");//recordList怎么用字符串表示,例如挂号id,0><草药id,4><成药,3
            bmsBillsRecordMapper.insertSelective(bmsBillsRecord);//向bms_bills_record中插入账单记录
            //通过挂号id和最近时间返回账单id
            BmsBillsRecordExample example5 = new BmsBillsRecordExample();
            example5.createCriteria().andRegistrationIdEqualTo(registrationId).andBillNoEqualTo(billNo);////通过挂号id和账单号查询刚插入账单的id
            List<BmsBillsRecord> bmsBillsRecordList = bmsBillsRecordMapper.selectByExample(example5);
            Long billId = bmsBillsRecordList.get(0).getId();//账单id

            //插入发票记录
            BmsInvoiceRecord bmsInvoiceRecord = new BmsInvoiceRecord();
            bmsInvoiceRecord.setType(1);//1表示挂号
            Date invoiceCreateTime = new Date();
            bmsInvoiceRecord.setCreateTime(invoiceCreateTime);
            bmsInvoiceRecord.setInvoiceNo(dmsRegistrationParam.getInvoiceNo());
            bmsInvoiceRecord.setBillId(billId);
            bmsInvoiceRecord.setAmount(dmsRegistrationParam.getAmount());
           // bmsInvoiceRecord.setFreezeStatus(1);//冻结状态为1正常
            bmsInvoiceRecord.setOperatorId(dmsRegistrationParam.getOpratorId());
            bmsInvoiceRecord.setSettlementCatId(dmsRegistrationParam.getSettlementCatId());
            bmsInvoiceRecord.setItemList(registrationId + "," + 0 + "," + dmsRegistrationParam.getAmount() + "><");//挂号id,0,amount><
            bmsInvoiceRecordMapper.insertSelective(bmsInvoiceRecord);
            return 1;
        }
        return 0;
    }


    @Override
    public List<DmsRegHistoryResult> listRegHistory(String identificationNo) {
        List<DmsRegHistoryResult> dmsRegHistoryResultList = new ArrayList<>();
        PmsPatientExample pmsPatientExample = new PmsPatientExample();
        pmsPatientExample.createCriteria().andIdentificationNoEqualTo(identificationNo);
        List<PmsPatient> pmsPatientList = pmsPatientMapper.selectByExample(pmsPatientExample);
        if (!pmsPatientList.isEmpty()) {//如果有对应的患者记录
            PmsPatient pmsPatient = pmsPatientList.get(0);
            DmsRegistrationExample dmsRegistrationExample = new DmsRegistrationExample();
            dmsRegistrationExample.createCriteria().andPatientIdEqualTo(pmsPatient.getId());
            dmsRegistrationExample.setOrderByClause("create_time desc");
            List<DmsRegistration> dmsRegistrationList = dmsRegistrationMapper.selectByExample(dmsRegistrationExample);
            for (DmsRegistration dmsRegistration : dmsRegistrationList) {
                DmsRegHistoryResult dmsRegHistoryResult = new DmsRegHistoryResult();
                BeanUtils.copyProperties(dmsRegistration,dmsRegHistoryResult);
                //挂号（门诊）id
                dmsRegHistoryResult.setRegistrationId(dmsRegistration.getId());
                //科室名
                SmsDept smsDept = smsDeptMapper.selectByPrimaryKey(dmsRegistration.getDeptId());
                if (smsDept != null){
                    dmsRegHistoryResult.setDeptName(smsDept.getName());
                }
                //医生姓名,挂号级别名
                SmsSkd smsSkd = smsSkdMapper.selectByPrimaryKey(dmsRegistration.getSkdId());
                if (smsSkd != null){
                    SmsStaff smsStaff = smsStaffMapper.selectByPrimaryKey(smsSkd.getStaffId());
                    dmsRegHistoryResult.setDoctorName(smsStaff.getName());
                    SmsRegistrationRank smsRegistrationRank = smsRegistrationRankMapper.selectByPrimaryKey(smsStaff.getRegistrationRankId());
                    dmsRegHistoryResult.setRegistrationName(smsRegistrationRank.getName());
                }
                dmsRegHistoryResultList.add(dmsRegHistoryResult);
            }
            return dmsRegHistoryResultList;
        }
            return null;
    }


    //先根据skd_id判断remain是否>0，如果大于0，则向dms_registration插入信息，并且绑定医生（skd_id、bind_status=1）,并修改sms_skd中的排班限额（-1），否则挂号失败
    //向bms_bills_record中插入账单记录
    @Override
    public int appRegistration(AppRegistrationParam appRegistrationParam){
        PmsPatient patient = pmsPatientMapper.selectByPrimaryKey(appRegistrationParam.getPatientId());
        if(patient == null){
            return 0;
        }
        SmsSkd skd = smsSkdMapper.selectByPrimaryKey(appRegistrationParam.getSkdId());
        if(skd == null){
            return 0;
        }
        //先根据skd_id判断remain是否>0
        if(skd.getRemain() <= 0){
            return  0;
        }

        //如果大于0，绑定医生（skd_id、bind_status=1）,并修改sms_skd中的排班限额（-1）
        SmsSkd skdRecord = new SmsSkd();
        skdRecord.setRemain(skd.getRemain() - 1);
        SmsSkdExample example = new SmsSkdExample();
        example.createCriteria().andIdEqualTo(skd.getId()).andRemainGreaterThan(new Long(0));
        int count = smsSkdMapper.updateByExampleSelective(skdRecord,example);
        if(count <= 0){
            return 0;
        }

        //向dms_registration插入信息
        DmsRegistration registration = new DmsRegistration();
        registration.setPatientId(appRegistrationParam.getPatientId());
        registration.setCreateTime(new Date());
        registration.setStatus(1);
        registration.setSkdId(skd.getId());
        registration.setNeedBook(0);    //默认不需要病历本
        registration.setBindStatus(1);
        registration.setDeptId(appRegistrationParam.getDeptId());
        registration.setAttendanceDate(appRegistrationParam.getAttendanceDate());
        if(patient.getDateOfBirth() != null){
            registration.setPatientAgeStr(AgeStrUtil.getAgeStr(patient.getDateOfBirth()));
        }
        int regCount = dmsRegistrationMapper.insertSelective(registration);

        //得到刚插入的挂号记录的registrationId
        DmsRegistrationExample registrationExample = new DmsRegistrationExample();
        registrationExample.createCriteria()
                .andPatientIdEqualTo(appRegistrationParam.getPatientId())
                .andSkdIdEqualTo(appRegistrationParam.getSkdId());//通过病人id和skdId查询刚插入挂号记录的id
        registrationExample.setOrderByClause("create_time desc");   //获取最新一次的
        List<DmsRegistration> dmsRegistrationList = dmsRegistrationMapper.selectByExample(registrationExample);
        if(dmsRegistrationList.size() <= 0){
            return 0;
        }
        Long registrationId = dmsRegistrationList.get(0).getId();

        //向bms_bills_record中插入账单记录
        BmsBillsRecord billsRecord = new BmsBillsRecord();
        //生成账单号
        String billNo = generateBillNo(registrationId);
        billsRecord.setBillNo(billNo);
        billsRecord.setCreateTime(new Date());
        billsRecord.setStatus(1);
        billsRecord.setInvoiceNum(0);   //免费挂号，不产生发票
        billsRecord.setRegistrationId(registrationId);
        billsRecord.setRecordList(registrationId + "," + 0 + "><");//recordList怎么用字符串表示,例如挂号id,0><草药id,4><成药,3
        int billCount = bmsBillsRecordMapper.insertSelective(billsRecord);//向bms_bills_record中插入账单记录

        return billCount;
    }


    //生成病历号
    public String generateMedicalRecordNo(String identificationNo) {
        Date date = new Date();
        String yyyymmdd = DateUtil.getDateStr(date);//年月日字符串
        String hhmm = DateUtil.getTimeStr(date, 4);//时分字符串
        int length = identificationNo.length();
        String lastFour;
        if (length > 4) {
            lastFour = identificationNo.substring(length - 4, length);
            return yyyymmdd + hhmm + lastFour;
        }
        return null;
    }

    //生成账单号
    public String generateBillNo(Long registrationId) {
        Date date = new Date();
        String yyyymmdd = DateUtil.getDateStr(date);//年月日字符串
        String hhmm = DateUtil.getTimeStr(date, 4);//时分字符串
        int length = registrationId.toString().length();
        String lastFour;
        if (length >= 4) {
            Long lastFourNo = registrationId % 10000;
            lastFour = lastFourNo.toString();
        } else if (length == 3) {
            lastFour = "0" + registrationId.toString();
        } else if (length == 2) {
            lastFour = "00" + registrationId.toString();
        } else {
            lastFour = "000" + registrationId.toString();
        }
        return yyyymmdd + hhmm + lastFour;
    }
}
