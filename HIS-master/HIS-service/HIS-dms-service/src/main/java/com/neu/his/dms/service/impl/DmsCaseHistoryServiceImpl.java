package com.neu.his.dms.service.impl;

import com.neu.his.common.dto.dms.DmsCaseHistoryParam;
import com.neu.his.common.dto.dms.DmsCaseHistoryResult;
import com.neu.his.dms.service.DmsCaseHistoryService;
import com.neu.his.mbg.mapper.*;
import com.neu.his.mbg.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DmsCaseHistoryServiceImpl implements DmsCaseHistoryService {
    @Autowired
    DmsCaseHistoryMapper dmsCaseHistoryMapper;
    @Autowired
    DmsRegistrationMapper dmsRegistrationMapper;
    @Autowired
    DmsNonDrugItemRecordMapper dmsNonDrugItemRecordMapper;
    @Autowired
    DmsNonDrugMapper dmsNonDrugMapper;
    @Autowired
    DmsHerbalPrescriptionRecordMapper dmsHerbalPrescriptionRecordMapper;
    @Autowired
    DmsHerbalItemRecordMapper dmsHerbalItemRecordMapper;
    @Autowired
    DmsMedicinePrescriptionRecordMapper dmsMedicinePrescriptionRecordMapper;
    @Autowired
    DmsMedicineItemRecordMapper dmsMedicineItemRecordMapper;
    @Autowired
    DmsDrugMapper dmsDrugMapper;
    @Autowired
    PmsPatientMapper pmsPatientMapper;

    //chiefComplaint
    //historyOfPresentIllness
    //historyOfTreatment
    //pastHistory
    //allergies
    //healthCheckup
    //registrationId
    //priliminaryDiseStrList
    //priliminaryDiseIdList
    //startDate
    //name
    //gender
    //age
    //封装status(1)\createTime
    /**
     * 描述：初诊
     * <p>author:王思阳
     * <p>author: 赵煜 修改status为1 初诊结束
     * <p>author: 赵煜 必须根据提交上来的registerId来封装patientId,在调用病人病历时，才能进行查询得到
     */
    @Override
    public int insertPriliminaryDise(DmsCaseHistoryParam dmsCaseHistoryParam) {
        if (dmsCaseHistoryParam == null){
            return 0;
        }
        DmsCaseHistory dmsCaseHistory = new DmsCaseHistory();
        dmsCaseHistory.setChiefComplaint(dmsCaseHistoryParam.getChiefComplaint());
        dmsCaseHistory.setHistoryOfPresentIllness(dmsCaseHistoryParam.getHistoryOfPresentIllness());
        dmsCaseHistory.setHistoryOfTreatment(dmsCaseHistoryParam.getHistoryOfTreatment());
        dmsCaseHistory.setPastHistory(dmsCaseHistoryParam.getPastHistory());
        dmsCaseHistory.setAllergies(dmsCaseHistoryParam.getAllergies());
        dmsCaseHistory.setHealthCheckup(dmsCaseHistoryParam.getHealthCheckup());
        dmsCaseHistory.setRegistrationId(dmsCaseHistoryParam.getRegistrationId());
        dmsCaseHistory.setPriliminaryDiseStrList(dmsCaseHistoryParam.getPriliminaryDiseStrList());
        dmsCaseHistory.setPriliminaryDiseIdList(dmsCaseHistoryParam.getPriliminaryDiseIdList());
        dmsCaseHistory.setStartDate(dmsCaseHistoryParam.getStartDate());
        dmsCaseHistory.setName(dmsCaseHistoryParam.getName());
        dmsCaseHistory.setGender(dmsCaseHistoryParam.getGender());
        dmsCaseHistory.setAgeStr(dmsCaseHistoryParam.getAgeStr());
        dmsCaseHistory.setStatus(1);
        dmsCaseHistory.setRegistrationId(dmsCaseHistoryParam.getRegistrationId());
        dmsCaseHistory.setPatientId(dmsRegistrationMapper.selectByPrimaryKey(dmsCaseHistoryParam.getRegistrationId()).getPatientId());//必须设置
        dmsCaseHistory.setCreateTime(new Date());
        dmsCaseHistoryMapper.insertSelective(dmsCaseHistory);
        return 1;
    }
    //根据registrationId查询1 初诊结束 2确诊结束 3 诊毕

    @Override
    public DmsCaseHistoryResult selectCaseHistoryByReg(Long registrationId,Integer status) {
        DmsRegistration dmsRegistration =  dmsRegistrationMapper.selectByPrimaryKey(registrationId);
        if(dmsRegistration==null){
            return null;
        }

        Long patientId = dmsRegistration.getPatientId();
//        System.err.println("status:"+status);
        DmsCaseHistoryExample dmsCaseHistoryExample = new DmsCaseHistoryExample();
        dmsCaseHistoryExample.createCriteria().andPatientIdEqualTo(patientId).andStatusEqualTo(status);
        dmsCaseHistoryExample.setOrderByClause("create_time desc");//按创建时间降序
        List<DmsCaseHistory> dmsCaseHistoryList = dmsCaseHistoryMapper.selectByExample(dmsCaseHistoryExample);
//        System.err.println("dmsCaseHistoryList.size():"+dmsCaseHistoryList.size());
        DmsCaseHistoryResult dmsCaseHistoryResult = new DmsCaseHistoryResult();
        dmsCaseHistoryResult.setDmsCaseHistoryList(dmsCaseHistoryList);
        return dmsCaseHistoryResult;
    }
    //通过门诊号更新记录
    //check_result
    //test_result
    //definite_dise_str_list
    //checkIdList
    //testIdList
    /**
     * 描述：确诊
     * <p>author:王思阳
     * <p>author: 赵煜 修改status为2 确诊结束
     */
    @Override
    public int submitDefiniteDise(DmsCaseHistoryParam dmsCaseHistoryParam) {
        if (dmsCaseHistoryParam == null){
            return 0;
        }
        DmsCaseHistoryExample dmsCaseHistoryExample = new DmsCaseHistoryExample();
        dmsCaseHistoryExample.createCriteria().andRegistrationIdEqualTo(dmsCaseHistoryParam.getRegistrationId());
        DmsCaseHistory dmsCaseHistory = new DmsCaseHistory();
        dmsCaseHistory.setCheckResult(dmsCaseHistoryParam.getCheckResult());
        dmsCaseHistory.setTestResult(dmsCaseHistoryParam.getTestResult());
        dmsCaseHistory.setDefiniteDiseStrList(dmsCaseHistoryParam.getDefiniteDiseStrList());
        //解析checkIdList为checkStrList
        String checkStrList = resolveNonDrugItemRecord(dmsCaseHistoryParam.getRegistrationId() , 0);
        dmsCaseHistory.setCheckStrList(checkStrList);
        //解析testIdList为testStrList
        String testStrList = resolveNonDrugItemRecord(dmsCaseHistoryParam.getRegistrationId() , 1);
        dmsCaseHistory.setTestStrList(testStrList);
        dmsCaseHistory.setStatus(2);//确诊结束
        dmsCaseHistoryMapper.updateByExampleSelective(dmsCaseHistory,dmsCaseHistoryExample);
        return 1;
    }
    //1. 通过门诊号更新记录dispositionIdList\herbalPrescriptionIdList\medicinePrescriptionIdList
    //2.更新挂号表中的end_attendance为3诊毕
    /**
     * 描述：诊毕
     * <p>author:王思阳
     * <p>author: 赵煜 修改status为3 看诊结束（诊毕），则下次就诊可查出病历记录
     */
    @Override
    public int endDiagnosis(DmsCaseHistoryParam dmsCaseHistoryParam) {
        if (dmsCaseHistoryParam == null){
            return 0;
        }
        DmsCaseHistoryExample dmsCaseHistoryExample = new DmsCaseHistoryExample();
        dmsCaseHistoryExample.createCriteria().andRegistrationIdEqualTo(dmsCaseHistoryParam.getRegistrationId());

        DmsCaseHistory dmsCaseHistory = new DmsCaseHistory();
        //解析dispositionIdList到dispositionStrList
        String dispositionStrList = resolveNonDrugItemRecord(dmsCaseHistoryParam.getRegistrationId() , 2);
        dmsCaseHistory.setDispositionStrList(dispositionStrList);
        //解析herbalPrescriptionIdList到HerbalPrescriptionStrList
        String herbalPrescriptionStrList = resolveHerbalPrescription(dmsCaseHistoryParam.getRegistrationId());
        dmsCaseHistory.setHerbalPrescriptionStrList(herbalPrescriptionStrList);
        //解析medicinePrescriptionIdList到MedicinePrescriptionStrList
        String medicinePrescriptionStrList = resolveMedicinePrescription(dmsCaseHistoryParam.getRegistrationId());
        dmsCaseHistory.setMedicinePrescriptionStrList(medicinePrescriptionStrList);
        dmsCaseHistory.setStatus(3); //诊毕
        dmsCaseHistoryMapper.updateByExampleSelective(dmsCaseHistory,dmsCaseHistoryExample);

        //修改registration表中status为3
        DmsRegistration registration = new DmsRegistration();
        registration.setId(dmsCaseHistoryParam.getRegistrationId());
        registration.setStatus(3);
        dmsRegistrationMapper.updateByPrimaryKeySelective(registration);

        return 1;
    }


    public String resolveNonDrugItemRecord(Long registrationId , Integer type){
//        String[] ids = idStr.split(",");
//        DmsNonDrugItemRecordExample dmsNonDrugItemRecordExample = new DmsNonDrugItemRecordExample();
//        String nonDrugStrList;
//        for (int i = 0 ; i < ids.length ; i++){
//            Long id = Long.valueOf(ids[i]);
//            dmsNonDrugItemRecordExample.clear();
//            dmsNonDrugItemRecordExample.createCriteria().andNoDrugIdEqualTo(id).andTypeEqualTo(type);
//            dmsNonDrugItemRecordMapper.selectByExample(dmsNonDrugItemRecordExample);
//        }
        String nonDrugStrList = "";
        DmsNonDrugItemRecordExample dmsNonDrugItemRecordExample = new DmsNonDrugItemRecordExample();
        dmsNonDrugItemRecordExample.createCriteria().andRegistrationIdEqualTo(registrationId).andTypeEqualTo(type);
        List<DmsNonDrugItemRecord> dmsNonDrugItemRecordList = dmsNonDrugItemRecordMapper.selectByExample(dmsNonDrugItemRecordExample);
        for (DmsNonDrugItemRecord dmsNonDrugItemRecord: dmsNonDrugItemRecordList) {
            Long nonDrugId = dmsNonDrugItemRecord.getNoDrugId();
            DmsNonDrug dmsNonDrug = dmsNonDrugMapper.selectByPrimaryKey(nonDrugId);
            String nonDrugName = dmsNonDrug.getName();
            String oneRecord = "";
            if (type == 0 || type ==1){//检查，检验
                String chechParts = dmsNonDrugItemRecord.getCheckParts();
                String result = dmsNonDrugItemRecord.getCheckResult();
                String resultImgUrlList = dmsNonDrugItemRecord.getResultImgUrlList();
                oneRecord = nonDrugName + "<>" + chechParts + "<>" + result + "<>" + resultImgUrlList + "><";
            }
            else if (type == 2){//处置
                oneRecord = nonDrugName + "><";
            }
            nonDrugStrList = nonDrugStrList + oneRecord;
        }
        return nonDrugStrList;
    }

    public String resolveHerbalPrescription(Long registrationId){
        String herbalPrescriptionStrList = "";//记录整个列表
        DmsHerbalPrescriptionRecordExample dmsHerbalPrescriptionRecordExample = new DmsHerbalPrescriptionRecordExample();
        dmsHerbalPrescriptionRecordExample.createCriteria().andRegistrationIdEqualTo(registrationId);
        List<DmsHerbalPrescriptionRecord> dmsHerbalPrescriptionRecordList =dmsHerbalPrescriptionRecordMapper.selectByExample(dmsHerbalPrescriptionRecordExample);
        DmsHerbalItemRecordExample dmsHerbalItemRecordExample = new DmsHerbalItemRecordExample();
        String onePrescription = "";//用于记录一个处方
        for (DmsHerbalPrescriptionRecord dmsHerbalPrescriptionRecord: dmsHerbalPrescriptionRecordList) {
            Long prescriptionId = dmsHerbalPrescriptionRecord.getId();
            dmsHerbalItemRecordExample.clear();
            dmsHerbalItemRecordExample.createCriteria().andPrescriptionIdEqualTo(prescriptionId);
            List<DmsHerbalItemRecord> dmsHerbalItemRecordList = dmsHerbalItemRecordMapper.selectByExample(dmsHerbalItemRecordExample);
            String prescriptionName = dmsHerbalPrescriptionRecord.getName();
            onePrescription = onePrescription + prescriptionName + "[";
            String oneItemRecord = "";//用于记录一个处方项（即一种药）
            for (DmsHerbalItemRecord dmsHerbalItemRecord: dmsHerbalItemRecordList) {
                Long itemId = dmsHerbalItemRecord.getDrugId();
                DmsDrug dmsDrug = dmsDrugMapper.selectByPrimaryKey(itemId);
                String itemName = dmsDrug.getName();
                Long num = dmsHerbalItemRecord.getTotalNum();
                oneItemRecord = oneItemRecord + itemName + "<<>>" + num + "><";
            }
            onePrescription = onePrescription + oneItemRecord + "]";
            herbalPrescriptionStrList = herbalPrescriptionStrList + onePrescription + "<>";
        }
        return herbalPrescriptionStrList;
    }

    public String resolveMedicinePrescription(Long registrationId){
        String medicinePrescriptionStrList = "";//用于记录整个列表
        DmsMedicinePrescriptionRecordExample dmsMedicinePrescriptionRecordExample = new DmsMedicinePrescriptionRecordExample();
        dmsMedicinePrescriptionRecordExample.createCriteria().andRegistrationIdEqualTo(registrationId);
        List<DmsMedicinePrescriptionRecord> dmsMedicinePrescriptionRecordList = dmsMedicinePrescriptionRecordMapper.selectByExample(dmsMedicinePrescriptionRecordExample);
        DmsMedicineItemRecordExample dmsMedicineItemRecordExample = new DmsMedicineItemRecordExample();
        String onePrescription = "";//用于记录一个处方
        for (DmsMedicinePrescriptionRecord dmsMedicinePrescriptionRecord: dmsMedicinePrescriptionRecordList) {
            Long prescriptionId = dmsMedicinePrescriptionRecord.getId();
            dmsMedicineItemRecordExample.clear();
            dmsMedicineItemRecordExample.createCriteria().andPrescriptionIdEqualTo(prescriptionId);
            List<DmsMedicineItemRecord> dmsMedicineItemRecordList = dmsMedicineItemRecordMapper.selectByExample(dmsMedicineItemRecordExample);
            String prescriptionName = dmsMedicinePrescriptionRecord.getName();
            onePrescription = onePrescription + prescriptionName + "[";
            String oneItemRecord = "";//用于记录一个处方项（即一种药）
            for(DmsMedicineItemRecord dmsMedicineItemRecord: dmsMedicineItemRecordList){
                Long itemId = dmsMedicineItemRecord.getDrugId();
                DmsDrug dmsDrug = dmsDrugMapper.selectByPrimaryKey(itemId);
                String itemName = dmsDrug.getName();
                Long num = dmsMedicineItemRecord.getNum();
                oneItemRecord = oneItemRecord + itemName + "<<>>" + num + "><";
            }
            onePrescription = onePrescription + oneItemRecord + "]";
            medicinePrescriptionStrList = medicinePrescriptionStrList + onePrescription + "<>";
        }
        return medicinePrescriptionStrList;
    }
}
