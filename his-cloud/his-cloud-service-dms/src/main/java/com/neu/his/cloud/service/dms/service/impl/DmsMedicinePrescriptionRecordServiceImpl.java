package com.neu.his.cloud.service.dms.service.impl;

import com.neu.his.cloud.service.dms.dto.dms.DmsMedicineItemRecordResult;
import com.neu.his.cloud.service.dms.dto.dms.DmsMedicinePrescriptionRecordParam;
import com.neu.his.cloud.service.dms.dto.dms.DmsMedicinePrescriptionRecordResult;
import com.neu.his.cloud.service.dms.mapper.DmsDrugMapper;
import com.neu.his.cloud.service.dms.mapper.DmsMedicineItemRecordMapper;
import com.neu.his.cloud.service.dms.mapper.DmsMedicinePrescriptionRecordMapper;
import com.neu.his.cloud.service.dms.mapper.SmsStaffMapper;
import com.neu.his.cloud.service.dms.model.*;
import com.neu.his.cloud.service.dms.service.DmsMedicinePrescriptionRecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DmsMedicinePrescriptionRecordServiceImpl implements DmsMedicinePrescriptionRecordService {

    @Autowired
    private DmsMedicinePrescriptionRecordMapper dmsMedicinePrescriptionRecordMapper;

    @Autowired
    private DmsMedicineItemRecordMapper dmsMedicineItemRecordMapper;

    @Autowired
    private SmsStaffMapper smsStaffMapper;
    @Autowired
    private DmsDrugMapper dmsDrugMapper;

    @Override
    public Long apply(DmsMedicinePrescriptionRecordParam dmsMedicinePrescriptionRecordParam){
        DmsMedicinePrescriptionRecord dmsMedicinePrescriptionRecord = new DmsMedicinePrescriptionRecord();
        BeanUtils.copyProperties(dmsMedicinePrescriptionRecordParam,dmsMedicinePrescriptionRecord);
        dmsMedicinePrescriptionRecord.setStatus(1);
        dmsMedicinePrescriptionRecord.setCreateTime(new Date());
        int insertCount = dmsMedicinePrescriptionRecordMapper.insert(dmsMedicinePrescriptionRecord);
        if(insertCount <=0){
            new Long(0);
        }

        DmsMedicinePrescriptionRecordExample recordExample = new DmsMedicinePrescriptionRecordExample();
        recordExample.createCriteria().andRegistrationIdEqualTo(dmsMedicinePrescriptionRecordParam.getRegistrationId());
        recordExample.setOrderByClause("create_time desc");
        Long currentId = dmsMedicinePrescriptionRecordMapper.selectByExample(recordExample).get(0).getId();

        List<DmsMedicineItemRecord> dmsMedicineItemRecordList = dmsMedicinePrescriptionRecordParam.getDmsMedicineItemRecordList();
        for(DmsMedicineItemRecord dmsMedicineItemRecord : dmsMedicineItemRecordList){
            dmsMedicineItemRecord.setId(null);
            dmsMedicineItemRecord.setStatus(1);
            dmsMedicineItemRecord.setPrescriptionId(currentId);
            dmsMedicineItemRecord.setCurrentNum(dmsMedicineItemRecord.getNum());
            dmsMedicineItemRecord.setRefundNum(new Long(0));
            insertCount += dmsMedicineItemRecordMapper.insert(dmsMedicineItemRecord);
        }
        return currentId;
    }

    @Override
    public int invalid(List<Long> ids){
        DmsMedicinePrescriptionRecordExample example = new DmsMedicinePrescriptionRecordExample();
        example.createCriteria().andIdIn(ids).andStatusEqualTo(1);
        DmsMedicinePrescriptionRecord record = new DmsMedicinePrescriptionRecord();
        record.setStatus(0);
        int updateCount = dmsMedicinePrescriptionRecordMapper.updateByExampleSelective(record,example);

        DmsMedicineItemRecordExample itemRecordExample = new DmsMedicineItemRecordExample();
        itemRecordExample.createCriteria().andPrescriptionIdIn(ids);
        DmsMedicineItemRecord itemRecord = new DmsMedicineItemRecord();
        itemRecord.setStatus(0);
        updateCount += dmsMedicineItemRecordMapper.updateByExampleSelective(itemRecord,itemRecordExample);

        return updateCount;
    }


    /**
     * 描述:1.根据挂号id查询状态不为0的处方
     * <p>author: ma
     * <p>20190614 赵煜 modify:DmsMedicineItemRecord->DmsMedicineItemRecordResult
     */
    @Override
    public List<DmsMedicinePrescriptionRecordResult> listByReg(Long registrationId){
        DmsMedicinePrescriptionRecordExample example = new DmsMedicinePrescriptionRecordExample();
        example.createCriteria().andRegistrationIdEqualTo(registrationId).andStatusNotEqualTo(0);
        List<DmsMedicinePrescriptionRecord> recordList= dmsMedicinePrescriptionRecordMapper.selectByExample(example);

        List<DmsMedicinePrescriptionRecordResult> recordResultList = new ArrayList<>();
        for(DmsMedicinePrescriptionRecord record : recordList){
            DmsMedicinePrescriptionRecordResult recordResult = new DmsMedicinePrescriptionRecordResult();
            BeanUtils.copyProperties(record,recordResult);

            DmsMedicineItemRecordExample itemRecordExample = new DmsMedicineItemRecordExample();
            itemRecordExample.createCriteria().andPrescriptionIdEqualTo(record.getId()).andStatusNotEqualTo(0);
            List<DmsMedicineItemRecord> itemRecordList = dmsMedicineItemRecordMapper.selectByExample(itemRecordExample);


            //将DmsMedicineItemRecord封装为DmsMedicineItemRecordResult
            List<DmsMedicineItemRecordResult> dmsMedicineItemRecordResultList=new ArrayList<>();

            for(DmsMedicineItemRecord dmsMedicineItemRecord:itemRecordList){

                DmsMedicineItemRecordResult dmsMedicineItemRecordResult=new DmsMedicineItemRecordResult();
                BeanUtils.copyProperties(dmsMedicineItemRecord,dmsMedicineItemRecordResult);
                BigDecimal price = dmsDrugMapper.selectByPrimaryKey(dmsMedicineItemRecordResult.getDrugId()).getPrice();
                String drugName=dmsDrugMapper.selectByPrimaryKey(dmsMedicineItemRecordResult.getDrugId()).getName();
                dmsMedicineItemRecordResult.setDrugName(drugName);
                dmsMedicineItemRecordResult.setPrice(price);
                dmsMedicineItemRecordResultList.add(dmsMedicineItemRecordResult);

            }

            recordResult.setDmsMedicineItemRecordResultList(dmsMedicineItemRecordResultList);

            SmsStaff smsStaff = smsStaffMapper.selectByPrimaryKey(record.getCreateStaffId());
            if(smsStaff == null){
                return null;
            }
            recordResult.setCreateStaffName(smsStaff.getName());
            recordResultList.add(recordResult);
        }
        return recordResultList;
    }


    @Override
    public List<DmsMedicinePrescriptionRecordResult> listByIds(List<Long> ids) {

        List<DmsMedicinePrescriptionRecord> dmsMedicinePrescriptionRecordList=new ArrayList<>();
        List<DmsMedicinePrescriptionRecordResult> dmsMedicinePrescriptionRecordResultList=new ArrayList<>();
        DmsMedicinePrescriptionRecordExample dmsMedicinePrescriptionRecordExample = new DmsMedicinePrescriptionRecordExample();
        dmsMedicinePrescriptionRecordExample.createCriteria().andIdIn(ids);
        dmsMedicinePrescriptionRecordList = dmsMedicinePrescriptionRecordMapper.selectByExample(dmsMedicinePrescriptionRecordExample);

        //封装订单
        for(DmsMedicinePrescriptionRecord dmsMedicinePrescriptionRecord:dmsMedicinePrescriptionRecordList){
            DmsMedicinePrescriptionRecordResult dmsMedicinePrescriptionRecordResult=new DmsMedicinePrescriptionRecordResult();
            BeanUtils.copyProperties(dmsMedicinePrescriptionRecord,dmsMedicinePrescriptionRecordResult);
            //需要单独封装createStaffName
            SmsStaff smsStaff =smsStaffMapper.selectByPrimaryKey(dmsMedicinePrescriptionRecord.getCreateStaffId());
            if(null!=smsStaff){
                dmsMedicinePrescriptionRecordResult.setCreateStaffName(smsStaff.getName());
            }
            //封装处方项
            //将DmsMedicineItemRecord封装为DmsMedicineItemRecordResult
            List<DmsMedicineItemRecordResult> dmsMedicineItemRecordResultList=new ArrayList<>();

            DmsMedicineItemRecordExample itemRecordExample = new DmsMedicineItemRecordExample();
            itemRecordExample.createCriteria().andPrescriptionIdEqualTo(dmsMedicinePrescriptionRecord.getId());
            List<DmsMedicineItemRecord> itemRecordList = dmsMedicineItemRecordMapper.selectByExample(itemRecordExample);

            for(DmsMedicineItemRecord dmsMedicineItemRecord:itemRecordList){
                DmsMedicineItemRecordResult dmsMedicineItemRecordResult=new DmsMedicineItemRecordResult();
                BeanUtils.copyProperties(dmsMedicineItemRecord,dmsMedicineItemRecordResult);
                BigDecimal price = dmsDrugMapper.selectByPrimaryKey(dmsMedicineItemRecord.getDrugId()).getPrice();
                String drugName=dmsDrugMapper.selectByPrimaryKey(dmsMedicineItemRecord.getDrugId()).getName();
                dmsMedicineItemRecordResult.setDrugName(drugName);
                dmsMedicineItemRecordResult.setPrice(price);
                dmsMedicineItemRecordResultList.add(dmsMedicineItemRecordResult);
            }

            dmsMedicinePrescriptionRecordResult.setDmsMedicineItemRecordResultList(dmsMedicineItemRecordResultList);//向处方中加入处方项列表

            dmsMedicinePrescriptionRecordResultList.add(dmsMedicinePrescriptionRecordResult); // 向处方列表中加入处方
        }

            return dmsMedicinePrescriptionRecordResultList;
    }





}
