package com.neu.his.dms.service.impl;

import com.neu.his.dms.service.DmsFeeRabbitMQService;
import com.neu.his.mbg.mapper.DmsHerbalPrescriptionRecordMapper;
import com.neu.his.mbg.mapper.DmsMedicinePrescriptionRecordMapper;
import com.neu.his.mbg.mapper.DmsNonDrugItemRecordMapper;
import com.neu.his.mbg.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DmsFeeRabbitMQServiceImpl implements DmsFeeRabbitMQService {

    @Autowired
    private DmsHerbalPrescriptionRecordMapper dmsHerbalPrescriptionRecordMapper;

    @Autowired
    private DmsMedicinePrescriptionRecordMapper dmsMedicinePrescriptionRecordMapper;

    @Autowired
    private DmsNonDrugItemRecordMapper dmsNonDrugItemRecordMapper;

    @Override
    public int herbalOutOfTime(Long prescriptionId){
        int count = 0;
        //草药处方超时未缴费处理（设置状态为4已过期）
        DmsHerbalPrescriptionRecord herbalRecord = new DmsHerbalPrescriptionRecord();
        herbalRecord.setStatus(4);
        DmsHerbalPrescriptionRecordExample example = new DmsHerbalPrescriptionRecordExample();
        example.createCriteria().andIdEqualTo(prescriptionId).andStatusEqualTo(1);
        count += dmsHerbalPrescriptionRecordMapper.updateByExampleSelective(herbalRecord,example);
        return count;
    }

    @Override
    public int medicineOutOfTime(Long prescriptionId){
        int count = 0;
        //成药处方超时未缴费处理（设置状态为4已过期）
        DmsMedicinePrescriptionRecord medicineRecord = new DmsMedicinePrescriptionRecord();
        medicineRecord.setStatus(4);
        DmsMedicinePrescriptionRecordExample example = new DmsMedicinePrescriptionRecordExample();
        example.createCriteria().andIdEqualTo(prescriptionId).andStatusEqualTo(1);
        count += dmsMedicinePrescriptionRecordMapper.updateByExampleSelective(medicineRecord,example);

        return count;
    }

    @Override
    public int nonDrugOutOfTime(Long prescriptionId){
        int count = 0;
        //非药品超时未缴费处理（设置状态为6已过期）
        DmsNonDrugItemRecord nonDrugRecord = new DmsNonDrugItemRecord();
        nonDrugRecord.setStatus(6);
        DmsNonDrugItemRecordExample example = new DmsNonDrugItemRecordExample();
        example.createCriteria().andIdEqualTo(prescriptionId).andStatusEqualTo(1);
        count += dmsNonDrugItemRecordMapper.updateByExampleSelective(nonDrugRecord,example);

        return count;
    }
}
