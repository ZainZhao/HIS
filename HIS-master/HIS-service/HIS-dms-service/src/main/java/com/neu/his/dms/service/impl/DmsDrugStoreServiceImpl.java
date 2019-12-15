package com.neu.his.dms.service.impl;

import com.neu.his.common.dto.dms.DmsRefundDrugListParam;
import com.neu.his.common.dto.dms.DmsRefundDrugParam;
import com.neu.his.common.dto.pms.PmsDrugStorePatientListResult;
import com.neu.his.common.dto.pms.PmsDrugStorePatientResult;
import com.neu.his.dms.service.DmsDrugStoreService;
import com.neu.his.mbg.mapper.*;
import com.neu.his.mbg.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.*;

@Service
public class DmsDrugStoreServiceImpl implements DmsDrugStoreService {

    @Autowired
    private DmsHerbalPrescriptionRecordMapper dmsHerbalPrescriptionRecordMapper;

    @Autowired
    private DmsHerbalItemRecordMapper dmsHerbalItemRecordMapper;

    @Autowired
    private DmsMedicinePrescriptionRecordMapper dmsMedicinePrescriptionRecordMapper;

    @Autowired
    private DmsMedicineItemRecordMapper dmsMedicineItemRecordMapper;

    @Autowired
    private DmsRegistrationMapper dmsRegistrationMapper;

    @Autowired
    private PmsPatientMapper pmsPatientMapper;

    @Autowired
    private DmsDrugMapper dmsDrugMapper;

    @Autowired
    private DmsDrugRefundItemRecordMapper dmsDrugRefundItemRecordMapper;

    @Override
    public PmsDrugStorePatientListResult listPatient(Date date, String medicalRecordNo, Integer type){
        //根据type(4 草药，5 成药)判断处方类型
        if(type == 4 ){
            return listWhenHerbal(date,medicalRecordNo);
        }else if(type == 5){
            return listWhenMedicine(date,medicalRecordNo);
        }
        return null;
    }

    //type=4时查草药处方
    public PmsDrugStorePatientListResult listWhenHerbal(Date date, String medicalRecordNo){
        System.err.println("正在查询草药处方");
        List<PmsDrugStorePatientResult> undoPatientList = new ArrayList<>();
        List<PmsDrugStorePatientResult> donePatientList = new ArrayList<>();
        //在处方表中根据时间查询
        List<Date> dateList = createDate(date);
        DmsHerbalPrescriptionRecordExample recordExample = new DmsHerbalPrescriptionRecordExample();
        recordExample.createCriteria().andCreateTimeBetween(dateList.get(0),dateList.get(1)); // 今天之内
        List<DmsHerbalPrescriptionRecord> recordList = dmsHerbalPrescriptionRecordMapper.selectByExample(recordExample);

        //判断处方项状态为2(未领药)\3（已领药）分类，查询挂号Id并去重
        Map<Long, List<Long>> undoPatientToRecord = new Hashtable();
        Map<Long, List<Long>> donePatientToRecord = new Hashtable();
        for(DmsHerbalPrescriptionRecord record : recordList){
            if(record.getStatus() == 2){
                if(undoPatientToRecord.get(record.getRegistrationId()) == null){
                    List<Long> longList = new ArrayList<>();
                    longList.add(record.getId());
                    undoPatientToRecord.put(record.getRegistrationId(),longList);
                }else{
                    List<Long> longList = undoPatientToRecord.get(record.getRegistrationId());
                    longList.add(record.getId());
                    undoPatientToRecord.put(record.getRegistrationId(),longList);
                }
            }else if(record.getStatus() == 3){
                if(donePatientToRecord.get(record.getRegistrationId()) == null){
                    List<Long> longList = new ArrayList<>();
                    longList.add(record.getId());
                    donePatientToRecord.put(record.getRegistrationId(),longList);
                }else{
                    List<Long> longList = donePatientToRecord.get(record.getRegistrationId());
                    longList.add(record.getId());
                    donePatientToRecord.put(record.getRegistrationId(),longList);
                }
            }
        }

        //根据病人id再在患者表中封装病人信息，如果传入患者病历号，则筛选患者
        for(Long key : undoPatientToRecord.keySet()){
            PmsDrugStorePatientResult result = new PmsDrugStorePatientResult();
            //查挂号表
            DmsRegistration registration = dmsRegistrationMapper.selectByPrimaryKey(key);
            if(registration == null){
                continue;
            }
            //查患者表，封装信息
            PmsPatient patient = pmsPatientMapper.selectByPrimaryKey(registration.getPatientId());
            if(patient == null){
                continue;
            }
            if(medicalRecordNo != null){
                if(!patient.getMedicalRecordNo().equals(medicalRecordNo)){
                    continue;
                }
            }
            result.setPatientId(patient.getId());
            result.setPatientName(patient.getName());
            result.setMedicalRecordNo(patient.getMedicalRecordNo());
            result.setPrescriptionIdList(undoPatientToRecord.get(key));
            undoPatientList.add(result);
        }
        for(Long key : donePatientToRecord.keySet()){
            PmsDrugStorePatientResult result = new PmsDrugStorePatientResult();
            //查挂号表
            DmsRegistration registration = dmsRegistrationMapper.selectByPrimaryKey(key);
            if(registration == null){
                continue;
            }
            //查患者表，封装信息
            PmsPatient patient = pmsPatientMapper.selectByPrimaryKey(registration.getPatientId());
            if(patient == null){
                continue;
            }
            if(medicalRecordNo != null){
                if(!patient.getMedicalRecordNo().equals(medicalRecordNo)){
                    continue;
                }
            }
            result.setPatientId(patient.getId());
            result.setPatientName(patient.getName());
            result.setMedicalRecordNo(patient.getMedicalRecordNo());
            result.setPrescriptionIdList(donePatientToRecord.get(key));
            donePatientList.add(result);
        }

        PmsDrugStorePatientListResult result = new PmsDrugStorePatientListResult();
        result.setUndoPatientList(undoPatientList);
        result.setDonePatientList(donePatientList);
        return result;
    }
    //type=5时查成药处方
    public PmsDrugStorePatientListResult listWhenMedicine(Date date, String medicalRecordNo){
        System.err.println("正在查询西药处方");
        List<PmsDrugStorePatientResult> undoPatientList = new ArrayList<>();
        List<PmsDrugStorePatientResult> donePatientList = new ArrayList<>();
        //在处方表中根据时间查询
        List<Date> dateList = createDate(date);
        DmsMedicinePrescriptionRecordExample recordExample = new DmsMedicinePrescriptionRecordExample();
        recordExample.createCriteria().andCreateTimeBetween(dateList.get(0),dateList.get(1));
        List<DmsMedicinePrescriptionRecord> recordList = dmsMedicinePrescriptionRecordMapper.selectByExample(recordExample);
        System.err.println("在时间范围内的西药处方条数："+recordList.size());


        //判断处方项状态为2(未领药)\3（已领药）分类，查询挂号Id并去重
        Map<Long, List<Long>> undoPatientToRecord = new Hashtable();
        Map<Long, List<Long>> donePatientToRecord = new Hashtable();
        for(DmsMedicinePrescriptionRecord record : recordList){
            if(record.getStatus() == 2){  //未领药
                if(undoPatientToRecord.get(record.getRegistrationId()) == null){
                    List<Long> longList = new ArrayList<>();
                    longList.add(record.getId());
                    undoPatientToRecord.put(record.getRegistrationId(),longList);
                }else{
                    List<Long> longList = undoPatientToRecord.get(record.getRegistrationId());
                    longList.add(record.getId());
                    undoPatientToRecord.put(record.getRegistrationId(),longList);
                }
            }else if(record.getStatus() == 3){ //已领药
                if(donePatientToRecord.get(record.getRegistrationId()) == null){
                    List<Long> longList = new ArrayList<>();
                    longList.add(record.getId());
                    donePatientToRecord.put(record.getRegistrationId(),longList);
                }else{
                    List<Long> longList = donePatientToRecord.get(record.getRegistrationId());
                    longList.add(record.getId());
                    donePatientToRecord.put(record.getRegistrationId(),longList);
                }
            }
        }

        //根据病人id再在患者表中封装病人信息，如果传入患者病历号，则筛选患者
        for(Long key : undoPatientToRecord.keySet()){
            PmsDrugStorePatientResult result = new PmsDrugStorePatientResult();
            //查挂号表
            DmsRegistration registration = dmsRegistrationMapper.selectByPrimaryKey(key);
            if(registration == null){
                continue;
            }
            //查患者表，封装信息
            PmsPatient patient = pmsPatientMapper.selectByPrimaryKey(registration.getPatientId());
            if(patient == null){
                continue;
            }
            if(medicalRecordNo != null){
                if(!patient.getMedicalRecordNo().equals(medicalRecordNo)){
                    continue;
                }
            }
            result.setPatientId(patient.getId());
            result.setPatientName(patient.getName());
            result.setMedicalRecordNo(patient.getMedicalRecordNo());
            result.setPrescriptionIdList(undoPatientToRecord.get(key));
            undoPatientList.add(result);
        }
        for(Long key : donePatientToRecord.keySet()){
            PmsDrugStorePatientResult result = new PmsDrugStorePatientResult();
            //查挂号表
            DmsRegistration registration = dmsRegistrationMapper.selectByPrimaryKey(key);
            if(registration == null){
                continue;
            }
            //查患者表，封装信息
            PmsPatient patient = pmsPatientMapper.selectByPrimaryKey(registration.getPatientId());
            if(patient == null){
                continue;
            }
            if(medicalRecordNo != null){
                if(!patient.getMedicalRecordNo().equals(medicalRecordNo)){
                    continue;
                }
            }
            result.setPatientId(patient.getId());
            result.setPatientName(patient.getName());
            result.setMedicalRecordNo(patient.getMedicalRecordNo());
            result.setPrescriptionIdList(donePatientToRecord.get(key));
            donePatientList.add(result);
        }



        PmsDrugStorePatientListResult result = new PmsDrugStorePatientListResult();
        result.setUndoPatientList(undoPatientList);
        result.setDonePatientList(donePatientList);
        return result;
    }


    @Override
    public int releaseDrug(Long prescriptionId,Integer type){
        //根据处方id判断处方状态为2修改为3
        int count = 0;
        if(type == 4){
            DmsHerbalPrescriptionRecord record = new DmsHerbalPrescriptionRecord();
            record.setStatus(3);
            DmsHerbalPrescriptionRecordExample example = new DmsHerbalPrescriptionRecordExample();
            example.createCriteria().andIdEqualTo(prescriptionId).andStatusEqualTo(2);
            count += dmsHerbalPrescriptionRecordMapper.updateByExampleSelective(record,example);
            if(count == 0){
                return count;
            }

            //根据处方id修改处方项status 1的 为 2
            DmsHerbalItemRecordExample itemExample = new DmsHerbalItemRecordExample();
            itemExample.createCriteria().andPrescriptionIdEqualTo(prescriptionId).andStatusEqualTo(1);
            DmsHerbalItemRecord itemRecord = new DmsHerbalItemRecord();
            itemRecord.setStatus(2);
            count += dmsHerbalItemRecordMapper.updateByExampleSelective(itemRecord,itemExample);
        }else if(type == 5){
            DmsMedicinePrescriptionRecord record = new DmsMedicinePrescriptionRecord();
            record.setStatus(3);
            DmsMedicinePrescriptionRecordExample example = new DmsMedicinePrescriptionRecordExample();
            example.createCriteria().andIdEqualTo(prescriptionId).andStatusEqualTo(2);
            count += dmsMedicinePrescriptionRecordMapper.updateByExampleSelective(record,example);
            if(count == 0){
                return count;
            }

            //根据处方id修改处方项status 1的 为 2
            DmsMedicineItemRecordExample itemExample = new DmsMedicineItemRecordExample();
            itemExample.createCriteria().andPrescriptionIdEqualTo(prescriptionId).andStatusEqualTo(1);
            DmsMedicineItemRecord itemRecord = new DmsMedicineItemRecord();
            itemRecord.setStatus(2);
            count += dmsMedicineItemRecordMapper.updateByExampleSelective(itemRecord,itemExample);
        }

        return count;
    }

    @Override
    public int refundDrug(DmsRefundDrugListParam dmsRefundDrugListParam) {
        int count = 0;

        //一个处方项一个处方项退
        for (DmsRefundDrugParam refundItem : dmsRefundDrugListParam.getRefundItemList()) {
            //草药退药
            if (refundItem.getType() == 4) {
                DmsHerbalItemRecord item = dmsHerbalItemRecordMapper.selectByPrimaryKey(refundItem.getRefundPrescriptionItemId());
                if (item == null) {
                    return count;
                }
                //检查是否符合退药条件：状态为 2已发药 或 3退药，退药数量<=当前数量
                if ((item.getStatus() != 2 && item.getStatus() != 3) || item.getCurrentNum() < refundItem.getRefundNum()) {
                   return count;
                }
                //修改状态为3(退药)，并修改current_num
                DmsHerbalItemRecord record = new DmsHerbalItemRecord();
                record.setId(refundItem.getRefundPrescriptionItemId());
                record.setStatus(3);
                record.setCurrentNum(item.getCurrentNum() - refundItem.getRefundNum());
                count += dmsHerbalItemRecordMapper.updateByPrimaryKeySelective(record);

                //修改库存
                DmsDrug drug = dmsDrugMapper.selectByPrimaryKey(item.getDrugId());
                if (drug == null) {
                    return count;
                }
                DmsDrug newDrug = new DmsDrug();
                newDrug.setId(item.getDrugId());
                newDrug.setStock(drug.getStock() + refundItem.getRefundNum());
                count += dmsDrugMapper.updateByPrimaryKeySelective(newDrug);

                //获取草药处方单
                DmsHerbalPrescriptionRecord prescriptionRecord = dmsHerbalPrescriptionRecordMapper.selectByPrimaryKey(item.getPrescriptionId());

                //添加退药记录
                DmsDrugRefundItemRecord refundItemRecord = new DmsDrugRefundItemRecord();
                refundItemRecord.setStatus(1);
                refundItemRecord.setType(4);
                refundItemRecord.setRegistrationId(prescriptionRecord.getRegistrationId());
                refundItemRecord.setDrugId(item.getDrugId());
                refundItemRecord.setRefundNumUnit(item.getUsageNumUnit());
                refundItemRecord.setRefundNum(refundItem.getRefundNum());
                refundItemRecord.setRefundTime(new Date());
                refundItemRecord.setExcutorId(dmsRefundDrugListParam.getExcutorId());
                refundItemRecord.setRefundItemRecordId(item.getId());
                count += dmsDrugRefundItemRecordMapper.insert(refundItemRecord);
            }//草药退药
            else if (refundItem.getType() == 5) { //西药退药
                DmsMedicineItemRecord item = dmsMedicineItemRecordMapper.selectByPrimaryKey(refundItem.getRefundPrescriptionItemId());
                if (item == null) {
                    return count;
                }
                //检查是否符合退药条件：状态为 2已发药 或 3退药，退药数量<=当前数量
                if ((item.getStatus() != 2 && item.getStatus() != 3) || item.getCurrentNum() < refundItem.getRefundNum()) {
                    //不符合条件抛出异常，事务回退
                    return count;
                }
                //修改状态为3(退药)，并修改current_num
                DmsMedicineItemRecord record = new DmsMedicineItemRecord();
                record.setId(refundItem.getRefundPrescriptionItemId());
                record.setStatus(3);
                record.setCurrentNum(item.getCurrentNum() - refundItem.getRefundNum());
                record.setRefundNum(item.getRefundNum()+refundItem.getRefundNum());
                count += dmsMedicineItemRecordMapper.updateByPrimaryKeySelective(record);

                //修改库存
                DmsDrug drug = dmsDrugMapper.selectByPrimaryKey(item.getDrugId());
                if (drug == null) {
                    return count;
                }
                DmsDrug newDrug = new DmsDrug();
                newDrug.setId(item.getDrugId());
                newDrug.setStock(drug.getStock() + refundItem.getRefundNum());
                count += dmsDrugMapper.updateByPrimaryKeySelective(newDrug);

                //获取成药处方单
                DmsMedicinePrescriptionRecord prescriptionRecord = dmsMedicinePrescriptionRecordMapper.selectByPrimaryKey(item.getPrescriptionId());

                //添加退药记录
                DmsDrugRefundItemRecord refundItemRecord = new DmsDrugRefundItemRecord();
                refundItemRecord.setStatus(1);
                refundItemRecord.setType(5);
                refundItemRecord.setRegistrationId(prescriptionRecord.getRegistrationId());
                refundItemRecord.setDrugId(item.getDrugId());
                refundItemRecord.setRefundNumUnit(item.getUsageNumUnit());
                refundItemRecord.setRefundNum(refundItem.getRefundNum());
                refundItemRecord.setRefundTime(new Date());
                refundItemRecord.setExcutorId(dmsRefundDrugListParam.getExcutorId());
                refundItemRecord.setRefundItemRecordId(item.getId());
                count += dmsDrugRefundItemRecordMapper.insert(refundItemRecord);
            } else {
                //不是草药也不是成药，事务回退
                return count;
            }
        }
        return count;
    }


    //获取给定时间的时间段
    public List<Date> createDate(Date date){
        List<Date> dateList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // 设置时分秒毫秒为0:0:0
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        dateList.add(calendar.getTime());

        // 设置时分秒毫秒为23:59:59:999
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        dateList.add(calendar.getTime());

        return dateList;
    }


}
