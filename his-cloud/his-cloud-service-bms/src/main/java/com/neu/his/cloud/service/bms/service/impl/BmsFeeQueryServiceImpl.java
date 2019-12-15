package com.neu.his.cloud.service.bms.service.impl;


import com.neu.his.cloud.service.bms.dto.app.AppDrugItemResult;
import com.neu.his.cloud.service.bms.dto.app.AppHistoryRegResult;
import com.neu.his.cloud.service.bms.dto.bms.BmsDoctorPatientFeeResult;
import com.neu.his.cloud.service.bms.mapper.*;
import com.neu.his.cloud.service.bms.model.*;
import com.neu.his.cloud.service.bms.service.BmsFeeQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BmsFeeQueryServiceImpl implements BmsFeeQueryService {

    @Autowired
    private DmsNonDrugItemRecordMapper dmsNonDrugItemRecordMapper;

    @Autowired
    private DmsNonDrugMapper dmsNonDrugMapper;

    @Autowired
    private DmsHerbalPrescriptionRecordMapper dmsHerbalPrescriptionRecordMapper;

    @Autowired
    private DmsHerbalItemRecordMapper dmsHerbalItemRecordMapper;

    @Autowired
    private DmsMedicinePrescriptionRecordMapper dmsMedicinePrescriptionRecordMapper;

    @Autowired
    private DmsMedicineItemRecordMapper dmsMedicineItemRecordMapper;

    @Autowired
    private DmsDrugMapper dmsDrugMapper;

    @Override
    public List<BmsDoctorPatientFeeResult> listFeeByRegistrationId(Long registrationId){
        List<BmsDoctorPatientFeeResult> resultList = new ArrayList<>();
        //查询非药品
        DmsNonDrugItemRecordExample nonDrugExample = new DmsNonDrugItemRecordExample();
        nonDrugExample.createCriteria().andRegistrationIdEqualTo(registrationId);
        List<DmsNonDrugItemRecord> nonDrugList = dmsNonDrugItemRecordMapper.selectByExample(nonDrugExample);
        for(DmsNonDrugItemRecord item : nonDrugList){
            //封装非药品
            DmsNonDrug nonDrug = dmsNonDrugMapper.selectByPrimaryKey(item.getNoDrugId());
            if(nonDrug == null){
                continue;
            }
            BmsDoctorPatientFeeResult result = new BmsDoctorPatientFeeResult();
            result.setItemName(nonDrug.getName());
            result.setFormat(nonDrug.getFormat());
            result.setPrice(nonDrug.getPrice());
            result.setCurrentNum(new Long(1));
            result.setType(item.getType());
            result.setStatus(item.getStatus());
            //添加收费状态
            if(item.getStatus() == 2 || item.getStatus() == 3 || item.getStatus() == 4){
                result.setChargeStatus(1);
            }else{
                result.setChargeStatus(0);
            }
            resultList.add(result);
        }

        //查询草药
        DmsHerbalPrescriptionRecordExample herbalExample = new DmsHerbalPrescriptionRecordExample();
        herbalExample.createCriteria().andRegistrationIdEqualTo(registrationId);
        List<DmsHerbalPrescriptionRecord> herbalList = dmsHerbalPrescriptionRecordMapper.selectByExample(herbalExample);
        //遍历多个处方单
        for(DmsHerbalPrescriptionRecord item : herbalList){
            DmsHerbalItemRecordExample herbalItemExample = new DmsHerbalItemRecordExample();
            herbalItemExample.createCriteria().andPrescriptionIdEqualTo(item.getId());
            List<DmsHerbalItemRecord> drugList = dmsHerbalItemRecordMapper.selectByExample(herbalItemExample);
            //遍历一个处方单多个处方项
            for(DmsHerbalItemRecord itemRecord : drugList){
                //封装药品
                DmsDrug drug = dmsDrugMapper.selectByPrimaryKey(itemRecord.getDrugId());
                if(drug == null){
                    continue;
                }
                BmsDoctorPatientFeeResult result = new BmsDoctorPatientFeeResult();
                result.setItemName(drug.getName());
                result.setFormat(drug.getFormat());
                result.setPrice(drug.getPrice());
                result.setCurrentNum(itemRecord.getCurrentNum());
                result.setType(4);
                result.setStatus(itemRecord.getStatus());
                //添加收费状态
                if(item.getStatus() == 2){
                    result.setChargeStatus(1);
                }else{
                    result.setChargeStatus(0);
                }
                resultList.add(result);
            }
        }

        //查询成药
        DmsMedicinePrescriptionRecordExample medicineExample = new DmsMedicinePrescriptionRecordExample();
        medicineExample.createCriteria().andRegistrationIdEqualTo(registrationId);
        List<DmsMedicinePrescriptionRecord> medicineList = dmsMedicinePrescriptionRecordMapper.selectByExample(medicineExample);
        //遍历多个处方单
        for(DmsMedicinePrescriptionRecord item : medicineList){
            DmsMedicineItemRecordExample medicineItemExample = new DmsMedicineItemRecordExample();
            medicineItemExample.createCriteria().andPrescriptionIdEqualTo(item.getId());
            List<DmsMedicineItemRecord> drugList = dmsMedicineItemRecordMapper.selectByExample(medicineItemExample);
            //遍历一个处方单多个处方项
            for(DmsMedicineItemRecord itemRecord : drugList){
                //封装药品
                DmsDrug drug = dmsDrugMapper.selectByPrimaryKey(itemRecord.getDrugId());
                if(drug == null){
                    continue;
                }
                BmsDoctorPatientFeeResult result = new BmsDoctorPatientFeeResult();
                result.setItemName(drug.getName());
                result.setFormat(drug.getFormat());
                result.setPrice(drug.getPrice());
                result.setCurrentNum(itemRecord.getCurrentNum());
                result.setType(5);
                result.setStatus(itemRecord.getStatus());
                //添加收费状态
                if(item.getStatus() == 2){
                    result.setChargeStatus(1);
                }else{
                    result.setChargeStatus(0);
                }
                resultList.add(result);
            }
        }

        return resultList;
    }


    @Override
    public List<AppHistoryRegResult> listFeePrescription(Long registrationId){
        List<AppHistoryRegResult> resultList = new ArrayList<>();
        //查询非药品
        DmsNonDrugItemRecordExample nonDrugExample = new DmsNonDrugItemRecordExample();
        nonDrugExample.createCriteria().andRegistrationIdEqualTo(registrationId);
        List<DmsNonDrugItemRecord> nonDrugList = dmsNonDrugItemRecordMapper.selectByExample(nonDrugExample);
        for(DmsNonDrugItemRecord item : nonDrugList){
            //封装非药品
            DmsNonDrug nonDrug = dmsNonDrugMapper.selectByPrimaryKey(item.getNoDrugId());
            if(nonDrug == null){
                continue;
            }
            AppHistoryRegResult result = new AppHistoryRegResult();
            result.setId(item.getId());
            result.setItemName(nonDrug.getName());
            result.setPrice(nonDrug.getPrice());
            result.setCurrentNum(new Long(1));
            result.setType(item.getType());
            result.setStatus(item.getStatus());
            resultList.add(result);
        }

        //查询草药
        DmsHerbalPrescriptionRecordExample herbalExample = new DmsHerbalPrescriptionRecordExample();
        herbalExample.createCriteria().andRegistrationIdEqualTo(registrationId);
        List<DmsHerbalPrescriptionRecord> herbalList = dmsHerbalPrescriptionRecordMapper.selectByExample(herbalExample);
        //遍历多个处方单
        for(DmsHerbalPrescriptionRecord item : herbalList){
            AppHistoryRegResult result = new AppHistoryRegResult();
            result.setId(item.getId());
            result.setItemName(item.getName());
            result.setPrice(item.getAmount());
            result.setCurrentNum(item.getPairNum());
            result.setType(4);
            result.setStatus(item.getStatus());
            resultList.add(result);
        }

        //查询成药
        DmsMedicinePrescriptionRecordExample medicineExample = new DmsMedicinePrescriptionRecordExample();
        medicineExample.createCriteria().andRegistrationIdEqualTo(registrationId);
        List<DmsMedicinePrescriptionRecord> medicineList = dmsMedicinePrescriptionRecordMapper.selectByExample(medicineExample);
        //遍历多个处方单
        for(DmsMedicinePrescriptionRecord item : medicineList){
            AppHistoryRegResult result = new AppHistoryRegResult();
            result.setId(item.getId());
            result.setItemName(item.getName());
            result.setPrice(item.getAmount());
            result.setCurrentNum(new Long(1));    //成药处方默认为一副
            result.setType(5);
            result.setStatus(item.getStatus());
            resultList.add(result);
        }

        return resultList;
    }

    @Override
    public List<AppDrugItemResult> listFeeItem(Long prescriptionId, int type){
        List<AppDrugItemResult> resultList = new ArrayList<>();
        if(type == 4){
            DmsHerbalItemRecordExample herbalItemExample = new DmsHerbalItemRecordExample();
            herbalItemExample.createCriteria().andPrescriptionIdEqualTo(prescriptionId);
            List<DmsHerbalItemRecord> drugList = dmsHerbalItemRecordMapper.selectByExample(herbalItemExample);
            //遍历一个处方单多个处方项
            for(DmsHerbalItemRecord itemRecord : drugList){
                //封装药品
                DmsDrug drug = dmsDrugMapper.selectByPrimaryKey(itemRecord.getDrugId());
                if(drug == null){
                    continue;
                }
                AppDrugItemResult result = new AppDrugItemResult();
                result.setDrugName(drug.getName());
                result.setFormat(drug.getFormat());
                result.setPrice(drug.getPrice());
                result.setCurrentNum(itemRecord.getCurrentNum());
                result.setStatus(itemRecord.getStatus());
                resultList.add(result);
            }
        }else if(type == 5){
            DmsMedicineItemRecordExample medicineItemExample = new DmsMedicineItemRecordExample();
            medicineItemExample.createCriteria().andPrescriptionIdEqualTo(prescriptionId);
            List<DmsMedicineItemRecord> drugList = dmsMedicineItemRecordMapper.selectByExample(medicineItemExample);
            //遍历一个处方单多个处方项
            for(DmsMedicineItemRecord itemRecord : drugList){
                //封装药品
                DmsDrug drug = dmsDrugMapper.selectByPrimaryKey(itemRecord.getDrugId());
                if(drug == null){
                    continue;
                }
                AppDrugItemResult result = new AppDrugItemResult();
                result.setDrugName(drug.getName());
                result.setFormat(drug.getFormat());
                result.setPrice(drug.getPrice());
                result.setCurrentNum(itemRecord.getCurrentNum());
                result.setStatus(itemRecord.getStatus());
                resultList.add(result);
            }
        }

        return resultList;
    }


}
