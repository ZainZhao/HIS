package com.neu.his.pms.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.neu.his.common.dto.dms.DmsCaseHistoryResult;

import com.neu.his.common.dto.pms.PmsDiagnosisPatientListResult;
import com.neu.his.common.dto.pms.PmsDiagnosisPatientResult;
import com.neu.his.common.dto.pms.PmsPatientResult;

import com.neu.his.common.util.AgeStrUtil;
import com.neu.his.common.util.DateUtil;
import com.neu.his.mbg.mapper.*;
import com.neu.his.mbg.model.*;

import com.neu.his.pms.service.PmsPatientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PmsPatientServiceImpl implements PmsPatientService {
    @Autowired
    private PmsPatientMapper pmsPatientMapper;
    @Autowired
    private SmsStaffMapper smsStaffMapper;
    @Autowired
    private DmsRegistrationMapper dmsRegistrationMapper;
    @Autowired
    private SmsSkdMapper smsSkdMapper;
    @Autowired
    private DmsCaseHistoryMapper dmsCaseHistoryMapper;
    //1.调用PmsPatientDao根据身份证号查询病人信息，并封装
    //2. 如果病人信息不存在，则直接返回


    @Override
    public PmsPatientResult selectPatientByIdNo(String identificationNo) {
        int count;//用于记录是否存在该病人
        PmsPatientExample example = new PmsPatientExample();
        example.createCriteria().andIdentificationNoEqualTo(identificationNo);
        List<PmsPatient> pmsPatientList = pmsPatientMapper.selectByExample(example);
        if(pmsPatientList.size()>0){//如果存在该病人
            PmsPatientResult pmsPatientResult = new PmsPatientResult();
            pmsPatientResult.setName(pmsPatientList.get(0).getName());

            //处理年龄
            Date dateOfBirth = pmsPatientList.get(0).getDateOfBirth();
            String age = AgeStrUtil.getAgeStr(dateOfBirth);
            pmsPatientResult.setAge(age);

            pmsPatientResult.setDateOfBirth(pmsPatientList.get(0).getDateOfBirth());
            pmsPatientResult.setGender(pmsPatientList.get(0).getGender());
            pmsPatientResult.setHomeAddress(pmsPatientList.get(0).getHomeAddress());
            pmsPatientResult.setPhoneNo(pmsPatientList.get(0).getPhoneNo());
            pmsPatientResult.setMedicalRecordNo(pmsPatientList.get(0).getMedicalRecordNo());
            return pmsPatientResult;
        }
        return null;
    }
    //1.传入医生id
    // 2.先根据医生id查找部门id,再从dms_registration中根据bind_status（0）、attendance_date、dept_id、status(1)查找出科室待诊患者
    // 3.
    //	3.1先通过午别、时间、医生id在表sms_skd中查找出sms_skd的id
    //	3.1.从dms_registration中根据bind_status（1）、attendance_date、skd_id查找出分配了的患者信息，并根据status分类（1，2，3）
    /**
     * 描述：
     * <p>author:王思阳
     * <p>author:赵煜  修改mysql5.7中比较时间错误
     *                 修改空指针异常
     *                 修改通过无别筛选列表错误
     */
    @Override
    public PmsDiagnosisPatientListResult refreshPatient(Long staffId) {
        //根据医生id查找部门id
        SmsStaffExample smsStaffExample = new SmsStaffExample();
        smsStaffExample.createCriteria().andIdEqualTo(staffId);
        List<SmsStaff> smsStaffList = smsStaffMapper.selectByExample(smsStaffExample);
        Long deptId = smsStaffList.get(0).getDeptId();

        //从dms_registration中根据bind_status（0）、attendance_date、dept_id、status(1)查找出科室待诊患者
        DmsRegistrationExample dmsRegistrationExample = new DmsRegistrationExample();
        Date date = new Date();//注意：这里的时间判断可能有问题

        //时间  对于科室等待患者，列出今天和昨天的（防止12点出故障）

        Date beforeAday=DateUtil.getDateBefore(date,1);

        dmsRegistrationExample.createCriteria().andBindStatusEqualTo(0).andDeptIdEqualTo(deptId).andStatusEqualTo(1).andAttendanceDateBetween(beforeAday,date);
        List<DmsRegistration> dmsRegistrationList = dmsRegistrationMapper.selectByExample(dmsRegistrationExample);

        System.err.println("deptWaitList.size: " + dmsRegistrationList.size());

        //映射List<DmsRegistration>到List<PmsDiagnosisPatientResult>
        List<PmsDiagnosisPatientResult> deptWaitList = new ArrayList<>();//科室待诊列表
        for (DmsRegistration dmsRegistration : dmsRegistrationList) {
            PmsDiagnosisPatientResult pmsDiagnosisPatientResult = new PmsDiagnosisPatientResult();
            pmsDiagnosisPatientResult.setPatientId(dmsRegistration.getPatientId());
            pmsDiagnosisPatientResult.setPatientAge(dmsRegistration.getPatientAgeStr());
            pmsDiagnosisPatientResult.setRegistrationId(dmsRegistration.getId());
            pmsDiagnosisPatientResult.setRegistrationStatus(dmsRegistration.getStatus());
            //从PmsPatient中查询其他字段并封装
            PmsPatientExample pmsPatientExample = new PmsPatientExample();
            pmsPatientExample.createCriteria().andIdEqualTo(dmsRegistration.getPatientId());
            List<PmsPatient> pmsPatientList = pmsPatientMapper.selectByExample(pmsPatientExample);
            pmsDiagnosisPatientResult.setPatientName(pmsPatientList.get(0).getName());
            pmsDiagnosisPatientResult.setPatientHomeAdress(pmsPatientList.get(0).getHomeAddress());
            pmsDiagnosisPatientResult.setPatientGender(pmsPatientList.get(0).getGender());
            pmsDiagnosisPatientResult.setPatientMedicalRecordNo(pmsPatientList.get(0).getMedicalRecordNo());
            deptWaitList.add(pmsDiagnosisPatientResult);//加入List<PmsDiagnosisPatientResult>
        }
        //获取当前午别
        SimpleDateFormat df = new SimpleDateFormat("HH");
        String hourStr = df.format(date);
//        int hour = Integer.parseInt(hourStr);
//        Integer noon;//午别
//        if (hour <= 12){
//            noon = 0;//上午
//        }
//        else {
//            noon = 1;//下午
//        }

        //通过午别、时间、医生id在表sms_skd中查找出sms_skd的id
        SmsSkdExample smsSkdExample = new SmsSkdExample();
       // smsSkdExample.createCriteria().andNoonEqualTo(noon).andStaffIdEqualTo(staffId).andDateEqualTo(DateUtil.getDate(DateUtil.setMilliSecond(date,0)));
        smsSkdExample.createCriteria().andStaffIdEqualTo(staffId).andDateEqualTo(DateUtil.getDate(DateUtil.setMilliSecond(date,0)));
        /*
        时间判断问题
         */
        //smsSkdExample.createCriteria().andNoonEqualTo(noon).andStaffIdEqualTo(staffId);


        List<SmsSkd> smsSkdList = smsSkdMapper.selectByExample(smsSkdExample);
        if(CollectionUtil.isEmpty(smsSkdList)){
            return null;
        }



        List<Long> idList = new ArrayList<>();
        for(SmsSkd skd : smsSkdList){
            idList.add(skd.getId());
        }




        //从dms_registration中根据bind_status（1）、attendance_date、skd_id查找出分配了的患者信息，并根据status分类（1，2，3）
        DmsRegistrationExample dmsRegistrationExample1 = new DmsRegistrationExample();
        //使用DateUtil只截取日期部分

        dmsRegistrationExample1.createCriteria().andBindStatusEqualTo(1).andAttendanceDateEqualTo(DateUtil.getDate(DateUtil.setMilliSecond(date,0))).andSkdIdIn(idList);;
        /*
        时间判断问题
         */
        //dmsRegistrationExample1.createCriteria().andBindStatusEqualTo(1).andSkdIdEqualTo(skdId);
        List<DmsRegistration> dmsRegistrationList1 = dmsRegistrationMapper.selectByExample(dmsRegistrationExample1);

        List<PmsDiagnosisPatientResult> personalWaitList = new ArrayList<>();//个人待诊
        List<PmsDiagnosisPatientResult> personalDuringList = new ArrayList<>();//个人诊中
        List<PmsDiagnosisPatientResult> personalEndList = new ArrayList<>();//个人已诊
        for (DmsRegistration dmsRegistration:dmsRegistrationList1) {
            PmsDiagnosisPatientResult pmsDiagnosisPatientResult = new PmsDiagnosisPatientResult();
            pmsDiagnosisPatientResult.setPatientId(dmsRegistration.getPatientId());
            pmsDiagnosisPatientResult.setPatientAge(dmsRegistration.getPatientAgeStr());
            pmsDiagnosisPatientResult.setRegistrationId(dmsRegistration.getId());
            pmsDiagnosisPatientResult.setRegistrationStatus(dmsRegistration.getStatus());
            //从PmsPatient中查询其他字段并封装
            PmsPatientExample pmsPatientExample = new PmsPatientExample();
            pmsPatientExample.createCriteria().andIdEqualTo(dmsRegistration.getPatientId());
            List<PmsPatient> pmsPatientList = pmsPatientMapper.selectByExample(pmsPatientExample);
            pmsDiagnosisPatientResult.setPatientName(pmsPatientList.get(0).getName());
            pmsDiagnosisPatientResult.setPatientHomeAdress(pmsPatientList.get(0).getHomeAddress());
            pmsDiagnosisPatientResult.setPatientGender(pmsPatientList.get(0).getGender());
            pmsDiagnosisPatientResult.setPatientMedicalRecordNo(pmsPatientList.get(0).getMedicalRecordNo());
            if (pmsDiagnosisPatientResult.getRegistrationStatus() == 1){//待诊
                personalWaitList.add(pmsDiagnosisPatientResult);
            }
            else if (pmsDiagnosisPatientResult.getRegistrationStatus() == 2){//诊中
                personalDuringList.add(pmsDiagnosisPatientResult);
            }
            else if (pmsDiagnosisPatientResult.getRegistrationStatus() == 3){//诊毕
                personalEndList.add(pmsDiagnosisPatientResult);
            }
        }
        //封装PmsDiagnosisPatientListResult对象并返回
        PmsDiagnosisPatientListResult pmsDiagnosisPatientListResult = new PmsDiagnosisPatientListResult();
        pmsDiagnosisPatientListResult.setDeptWaitList(deptWaitList);
        pmsDiagnosisPatientListResult.setPersonalWaitList(personalWaitList);
        pmsDiagnosisPatientListResult.setPersonalDuringList(personalDuringList);
        pmsDiagnosisPatientListResult.setPersonalEndList(personalEndList);
        return pmsDiagnosisPatientListResult;
    }
    //1. 传入dms_registration的id和医生id
    //2. 先根据医生id、时间、午别查找sms_skd的id
    //3.根据dms_registration的id修改dms_registration中bind_status为1,并添加skd_id
    @Override
    public int bindPatient(Long registrationId, Long staffId) {
        //根据医生id、时间、午别查找sms_skd的id
            //获取当前午别
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("HH");
        String hourStr = df.format(date);
        int hour = Integer.parseInt(hourStr);
        Integer noon;//午别
        if (hour <= 12){
            noon = 0;//上午
        }
        else {
            noon = 1;//下午
        }
        SmsSkdExample smsSkdExample = new SmsSkdExample();
        smsSkdExample.createCriteria().andStaffIdEqualTo(staffId).andDateEqualTo(DateUtil.getDate(DateUtil.setMilliSecond(date,0))).andNoonEqualTo(noon);
        /*
        时间判断问题
         */
        //smsSkdExample.createCriteria().andStaffIdEqualTo(staffId).andNoonEqualTo(noon);
        List<SmsSkd> smsSkdList = smsSkdMapper.selectByExample(smsSkdExample);
        Long skdId = smsSkdList.get(0).getId();
        if (skdId == null){
            return 0;
        }
        //根据dms_registration的id修改dms_registration中bind_status为1,并添加skd_id
        DmsRegistrationExample dmsRegistrationExample = new DmsRegistrationExample();
        dmsRegistrationExample.createCriteria().andIdEqualTo(registrationId);
        DmsRegistration dmsRegistration = new DmsRegistration();
        dmsRegistration.setBindStatus(1);
        dmsRegistration.setSkdId(skdId);
        dmsRegistrationMapper.updateByExampleSelective(dmsRegistration,dmsRegistrationExample);
        return 1;
    }
    //1.调用PmsPatientService的updateDiagnosisSatus 根据挂号id修改status状态为2
    //2.调用PmsPatientService的selectCaseHistoryByPatient()
    @Override
    public DmsCaseHistoryResult startDiagnosis(Long registrationId) {
        updateDiagnosisStatus(registrationId,2);
        DmsCaseHistoryResult dmsCaseHistoryResult = selectCaseHistoryByPatient(registrationId);
        return dmsCaseHistoryResult;
    }
    //修改状态通用方法
    @Override
    public int updateDiagnosisStatus(Long registrationId, Integer status) {
        DmsRegistration dmsRegistration = new DmsRegistration();
        dmsRegistration.setId(registrationId);
        dmsRegistration.setStatus(status);
        dmsRegistrationMapper.updateByPrimaryKeySelective(dmsRegistration);
        return 1;
    }
    //1.根据registrationId查找出patientId
    //2.根据patientId查询历史病历(status为2)
    @Override
    public DmsCaseHistoryResult selectCaseHistoryByPatient(Long registrationId) {
        DmsRegistration dmsRegistration =  dmsRegistrationMapper.selectByPrimaryKey(registrationId);
        Long patientId = dmsRegistration.getPatientId();
        //List<DmsCaseHistory> dmsCaseHistoryList = new ArrayList<>();
        DmsCaseHistoryExample dmsCaseHistoryExample = new DmsCaseHistoryExample();
        dmsCaseHistoryExample.createCriteria().andPatientIdEqualTo(patientId).andStatusEqualTo(2);
        dmsCaseHistoryExample.setOrderByClause("create_time desc");//按创建时间降序
        List<DmsCaseHistory> dmsCaseHistoryList = dmsCaseHistoryMapper.selectByExample(dmsCaseHistoryExample);
        DmsCaseHistoryResult dmsCaseHistoryResult = new DmsCaseHistoryResult();
        dmsCaseHistoryResult.setDmsCaseHistoryList(dmsCaseHistoryList);
        return dmsCaseHistoryResult;
    }

    @Override
    public PmsPatientResult patientLogin(String identificationNo, String medicalRecordNo) {
       PmsPatientExample pmsPatientExample=new PmsPatientExample();
       pmsPatientExample.createCriteria().andIdentificationNoEqualTo(identificationNo).andMedicalRecordNoEqualTo(medicalRecordNo);
       List<PmsPatient> pmsPatientList = pmsPatientMapper.selectByExample(pmsPatientExample);
        if(CollectionUtil.isEmpty(pmsPatientList)||pmsPatientList.size()>1){
            return null;
        }

        //数据正常的情况下，只会返回一个病人
        PmsPatientResult pmsPatientResult=new PmsPatientResult();
        BeanUtils.copyProperties(pmsPatientList.get(0),pmsPatientResult);

        return pmsPatientResult;

    }
}
