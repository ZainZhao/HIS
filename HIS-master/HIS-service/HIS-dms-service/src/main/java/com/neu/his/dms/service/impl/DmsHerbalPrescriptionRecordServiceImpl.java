package com.neu.his.dms.service.impl;

import com.neu.his.common.dto.dms.*;
import com.neu.his.dms.service.DmsHerbalPrescriptionRecordService;
import com.neu.his.mbg.mapper.DmsDrugMapper;
import com.neu.his.mbg.mapper.DmsHerbalItemRecordMapper;
import com.neu.his.mbg.mapper.DmsHerbalPrescriptionRecordMapper;
import com.neu.his.mbg.mapper.SmsStaffMapper;
import com.neu.his.mbg.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DmsHerbalPrescriptionRecordServiceImpl implements DmsHerbalPrescriptionRecordService {

    @Autowired
    private DmsHerbalPrescriptionRecordMapper dmsHerbalPrescriptionRecordMapper;

    @Autowired
    private DmsHerbalItemRecordMapper dmsHerbalItemRecordMapper;

    @Autowired
    private SmsStaffMapper smsStaffMapper;
    @Autowired
    private DmsDrugMapper dmsDrugMapper;


    @Override
    public Long apply(DmsHerbalPrescriptionRecordParam dmsHerbalPrescriptionRecordParam){
        DmsHerbalPrescriptionRecord record = new DmsHerbalPrescriptionRecord();
        BeanUtils.copyProperties(dmsHerbalPrescriptionRecordParam,record);
        record.setStatus(1);
        record.setCreateTime(new Date());
        int insertCount = dmsHerbalPrescriptionRecordMapper.insertSelective(record);
        if(insertCount <=0){
            return new Long(0);
        }

        DmsHerbalPrescriptionRecordExample recordExample = new DmsHerbalPrescriptionRecordExample();
        recordExample.createCriteria().andRegistrationIdEqualTo(dmsHerbalPrescriptionRecordParam.getRegistrationId());
        recordExample.setOrderByClause("create_time desc");
        Long currentId = dmsHerbalPrescriptionRecordMapper.selectByExample(recordExample).get(0).getId();

        List<DmsHerbalItemRecord> dmsHerbalItemRecordList = dmsHerbalPrescriptionRecordParam.getDmsHerbalItemRecordList();
        for(DmsHerbalItemRecord dmsHerbalItemRecord : dmsHerbalItemRecordList){
            if(dmsHerbalItemRecord.getUsageNum() != null){
                dmsHerbalItemRecord.setTotalNum(record.getPairNum() * dmsHerbalItemRecord.getUsageNum());
            }
            dmsHerbalItemRecord.setId(null);
            dmsHerbalItemRecord.setStatus(1);
            dmsHerbalItemRecord.setCurrentNum(dmsHerbalItemRecord.getTotalNum());
            dmsHerbalItemRecord.setPrescriptionId(currentId);
            insertCount += dmsHerbalItemRecordMapper.insert(dmsHerbalItemRecord);
        }
        return currentId;
    }

    @Override
    public int invalid(List<Long> ids){
        DmsHerbalPrescriptionRecordExample example = new DmsHerbalPrescriptionRecordExample();
        example.createCriteria().andIdIn(ids).andStatusEqualTo(1);
        DmsHerbalPrescriptionRecord record = new DmsHerbalPrescriptionRecord();
        record.setStatus(0);
        int updateCount = dmsHerbalPrescriptionRecordMapper.updateByExampleSelective(record,example);

        DmsHerbalItemRecordExample itemRecordExample = new DmsHerbalItemRecordExample();
        itemRecordExample.createCriteria().andPrescriptionIdIn(ids);
        DmsHerbalItemRecord itemRecord = new DmsHerbalItemRecord();
        itemRecord.setStatus(0);
        updateCount += dmsHerbalItemRecordMapper.updateByExampleSelective(itemRecord,itemRecordExample);

        return updateCount;
    }


    /**
     * 描述:1.调用DmsDrugDao根据ids修改status为0（无效）
     * <p>author: ma
     * <p>20190614 赵煜 modify:DmsHerbalItemRecord->DmsHerbalItemRecordResult
     */
    @Override
    public List<DmsHerbalPrescriptionRecordResult>  listByReg(Long registrationId){
        DmsHerbalPrescriptionRecordExample example = new DmsHerbalPrescriptionRecordExample();
        example.createCriteria().andRegistrationIdEqualTo(registrationId).andStatusNotEqualTo(0);
        List<DmsHerbalPrescriptionRecord> recordList= dmsHerbalPrescriptionRecordMapper.selectByExample(example);
        List<DmsHerbalPrescriptionRecordResult> recordResultList = new ArrayList<>();
        for(DmsHerbalPrescriptionRecord record : recordList){
            DmsHerbalPrescriptionRecordResult recordResult = new DmsHerbalPrescriptionRecordResult();
            BeanUtils.copyProperties(record,recordResult);

            DmsHerbalItemRecordExample itemRecordExample = new DmsHerbalItemRecordExample();
            itemRecordExample.createCriteria().andPrescriptionIdEqualTo(record.getId()).andStatusNotEqualTo(0);
            List<DmsHerbalItemRecord> itemRecordList = dmsHerbalItemRecordMapper.selectByExample(itemRecordExample);

            //将DmsHerbalItemRecord封装为DmsHerbalItemRecordResult
            List<DmsHerbalItemRecordResult> dmsHerbalItemRecordResultList=new ArrayList<>();

            for(DmsHerbalItemRecord dmsHerbalItemRecord:itemRecordList){
                DmsHerbalItemRecordResult dmsHerbalItemRecordResult=new DmsHerbalItemRecordResult();
                BeanUtils.copyProperties(dmsHerbalItemRecord,dmsHerbalItemRecordResult);
                BigDecimal price = dmsDrugMapper.selectByPrimaryKey(dmsHerbalItemRecordResult.getDrugId()).getPrice();
                String drugName=dmsDrugMapper.selectByPrimaryKey(dmsHerbalItemRecordResult.getDrugId()).getName();

                dmsHerbalItemRecordResultList.add(dmsHerbalItemRecordResult);

            }
            recordResult.setDmsHerbalItemRecordResultList(dmsHerbalItemRecordResultList);

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
    public List<DmsHerbalPrescriptionRecordResult> listByIds(List<Long> ids) {
        List<DmsHerbalPrescriptionRecord> dmsHerbalPrescriptionRecordList=new ArrayList<>();
        List<DmsHerbalPrescriptionRecordResult> dmsHerbalPrescriptionRecordResultList=new ArrayList<>();

        DmsHerbalPrescriptionRecordExample dmsHerbalPrescriptionRecordExample = new DmsHerbalPrescriptionRecordExample();
        dmsHerbalPrescriptionRecordExample.createCriteria().andIdIn(ids);
        dmsHerbalPrescriptionRecordList = dmsHerbalPrescriptionRecordMapper.selectByExample(dmsHerbalPrescriptionRecordExample);

        //封装处方单
        for(DmsHerbalPrescriptionRecord dmsHerbalPrescriptionRecord:dmsHerbalPrescriptionRecordList){
            DmsHerbalPrescriptionRecordResult dmsHerbalPrescriptionRecordResult=new DmsHerbalPrescriptionRecordResult();
            BeanUtils.copyProperties(dmsHerbalPrescriptionRecord,dmsHerbalPrescriptionRecordResult);
            //需要单独封装createStaffName
            SmsStaff smsStaff =smsStaffMapper.selectByPrimaryKey(dmsHerbalPrescriptionRecord.getCreateStaffId());
            if(null!=smsStaff){
                dmsHerbalPrescriptionRecordResult.setCreateStaffName(smsStaff.getName());
            }
            //封装处方项
            //将DmsHerbalItemRecord封装为DmsHerbalItemRecordResult
            List<DmsHerbalItemRecordResult> dmsMedicineItemRecordResultList=new ArrayList<>();

            DmsHerbalItemRecordExample itemRecordExample = new DmsHerbalItemRecordExample();
            itemRecordExample.createCriteria().andPrescriptionIdEqualTo(dmsHerbalPrescriptionRecord.getId());
            List<DmsHerbalItemRecord> itemRecordList = dmsHerbalItemRecordMapper.selectByExample(itemRecordExample);

            for(DmsHerbalItemRecord dmsHerbalItemRecord:itemRecordList){
                DmsHerbalItemRecordResult dmsHerbalItemRecordResult=new DmsHerbalItemRecordResult();
                BeanUtils.copyProperties(dmsHerbalItemRecord,dmsHerbalItemRecordResult);
                BigDecimal price = dmsDrugMapper.selectByPrimaryKey(dmsHerbalItemRecord.getDrugId()).getPrice();
                String drugName=dmsDrugMapper.selectByPrimaryKey(dmsHerbalItemRecord.getDrugId()).getName();
                dmsHerbalItemRecordResult.setDrugName(drugName);
                dmsHerbalItemRecordResult.setPrice(price);
                dmsMedicineItemRecordResultList.add(dmsHerbalItemRecordResult);
            }

            dmsHerbalPrescriptionRecordResult.setDmsHerbalItemRecordResultList(dmsMedicineItemRecordResultList);//向处方中加入处方项列表
            dmsHerbalPrescriptionRecordResultList.add(dmsHerbalPrescriptionRecordResult); // 向处方列表中加入处方
        }
        return dmsHerbalPrescriptionRecordResultList;
    }

}
