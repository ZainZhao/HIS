package com.neu.his.cloud.service.dms.service.impl;

import com.neu.his.cloud.service.dms.dto.app.AppCheckTestResult;
import com.neu.his.cloud.service.dms.dto.dms.DmsNonDrugItemRecordListParam;
import com.neu.his.cloud.service.dms.dto.dms.DmsNonDrugItemRecordParam;
import com.neu.his.cloud.service.dms.dto.dms.DmsNonDrugItemRecordResult;
import com.neu.his.cloud.service.dms.mapper.DmsNonDrugItemRecordMapper;
import com.neu.his.cloud.service.dms.mapper.SmsDeptMapper;
import com.neu.his.cloud.service.dms.mapper.SmsStaffMapper;
import com.neu.his.cloud.service.dms.model.DmsNonDrugItemRecord;
import com.neu.his.cloud.service.dms.model.DmsNonDrugItemRecordExample;
import com.neu.his.cloud.service.dms.model.SmsDept;
import com.neu.his.cloud.service.dms.model.SmsStaff;
import com.neu.his.cloud.service.dms.service.DmsNonDrugItemRecordService;
import com.neu.his.cloud.service.dms.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class DmsNonDrugItemRecordServiceImpl implements DmsNonDrugItemRecordService {
    @Autowired
    DmsNonDrugItemRecordMapper dmsNonDrugItemRecordMapper;
    @Autowired
    SmsDeptMapper smsDeptMapper;
    @Autowired
    SmsStaffMapper smsStaffMapper;

    //1.封装多条dms_non_drug_item_record信息并插入
    @Override
    public  List<Long> apply(DmsNonDrugItemRecordListParam dmsNonDrugItemRecordListParam) {

        Date startDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.SECOND, -1);  //设置时间减一秒
        startDate = calendar.getTime();
        if (dmsNonDrugItemRecordListParam == null){
            return null;
        }
        List<Long> idList = new ArrayList<>();
        List<DmsNonDrugItemRecordParam> dmsNonDrugItemRecordParamList = dmsNonDrugItemRecordListParam.getDmsNonDrugItemRecordParamList();
        Date date = DateUtil.setMilliSecond(new Date(),0);

        for (DmsNonDrugItemRecordParam dmsNonDrugItemRecordParam:dmsNonDrugItemRecordParamList) {
            DmsNonDrugItemRecord dmsNonDrugItemRecord = new DmsNonDrugItemRecord();

            BeanUtils.copyProperties(dmsNonDrugItemRecordParam,dmsNonDrugItemRecord);

            dmsNonDrugItemRecord.setRegistrationId(dmsNonDrugItemRecordListParam.getRegistrationId());
            dmsNonDrugItemRecord.setCreateStaffId(dmsNonDrugItemRecordListParam.getCreateStaffId());
            dmsNonDrugItemRecord.setType(dmsNonDrugItemRecordListParam.getType());
            dmsNonDrugItemRecord.setStatus(1);
            dmsNonDrugItemRecord.setCreateTime(date);
            dmsNonDrugItemRecordMapper.insertSelective(dmsNonDrugItemRecord);
        }
        Date endDate = new Date();
        calendar.setTime(endDate);
        calendar.add(Calendar.SECOND, 1);   //设置时间加一秒
        endDate = calendar.getTime();

        //获取刚才插入的所有非药品项id
        DmsNonDrugItemRecordExample recordExample = new DmsNonDrugItemRecordExample();
        recordExample.createCriteria().andCreateStaffIdEqualTo(dmsNonDrugItemRecordListParam.getCreateStaffId())
                .andCreateTimeBetween(startDate,endDate);
        List<DmsNonDrugItemRecord> recordList = dmsNonDrugItemRecordMapper.selectByExample(recordExample);
        for(DmsNonDrugItemRecord record : recordList){
            idList.add(record.getId());
        }

        return idList;

    }
    //1.如果status为1,则修改为0
    @Override
    public int invalid(List<Long> ids) {
        if (ids.isEmpty()){
            return 0;
        }
        DmsNonDrugItemRecordExample dmsNonDrugItemRecordExample = new DmsNonDrugItemRecordExample();
        DmsNonDrugItemRecord dmsNonDrugItemRecord = new DmsNonDrugItemRecord();
        dmsNonDrugItemRecord.setStatus(0);
        for (Long id:ids) {
            dmsNonDrugItemRecordExample.clear();
            dmsNonDrugItemRecordExample.createCriteria().andStatusEqualTo(1).andIdEqualTo(id);
            dmsNonDrugItemRecordMapper.updateByExampleSelective(dmsNonDrugItemRecord,dmsNonDrugItemRecordExample);
        }
        return 1;
    }

    /**
     * 描述：刷新项目
     * <p>author:王思阳
     * <p>author:赵煜 解决封装参数不完全的bug
     */
    //1.封装非药品记录
    //自己找这几个属性excuteDeptName/excuteStaffName/createStaffName/logStaffName
    @Override
    public List<DmsNonDrugItemRecordResult> listByRegAndType(Long registrationId, Integer type) {
        DmsNonDrugItemRecordExample dmsNonDrugItemRecordExample = new DmsNonDrugItemRecordExample();
        dmsNonDrugItemRecordExample.createCriteria().andRegistrationIdEqualTo(registrationId).andTypeEqualTo(type);
        List<DmsNonDrugItemRecord> dmsNonDrugItemRecordList = dmsNonDrugItemRecordMapper.selectByExample(dmsNonDrugItemRecordExample);

        List<DmsNonDrugItemRecordResult> dmsNonDrugItemRecordResultList = new ArrayList<>();



        for (DmsNonDrugItemRecord dmsNonDrugItemRecord:dmsNonDrugItemRecordList) {
            DmsNonDrugItemRecordResult dmsNonDrugItemRecordResult = new DmsNonDrugItemRecordResult();
            dmsNonDrugItemRecordResult.setId(dmsNonDrugItemRecord.getId());
            dmsNonDrugItemRecordResult.setAim(dmsNonDrugItemRecord.getAim());
          //  System.out.println("Aim: "+dmsNonDrugItemRecordResult.getAim());
            dmsNonDrugItemRecordResult.setDemand(dmsNonDrugItemRecord.getDemand());
            dmsNonDrugItemRecordResult.setClinicalImpression(dmsNonDrugItemRecord.getClinicalImpression());
            dmsNonDrugItemRecordResult.setClinicalDiagnosis(dmsNonDrugItemRecord.getClinicalDiagnosis());
            dmsNonDrugItemRecordResult.setNoDrugId(dmsNonDrugItemRecord.getNoDrugId());
            dmsNonDrugItemRecordResult.setCheckParts(dmsNonDrugItemRecord.getCheckParts());
            dmsNonDrugItemRecordResult.setExcuteDeptId(dmsNonDrugItemRecord.getExcuteDeptId());
            //excuteDeptName
            if (dmsNonDrugItemRecord.getExcuteDeptId() != null){
                SmsDept smsDept = smsDeptMapper.selectByPrimaryKey(dmsNonDrugItemRecord.getExcuteDeptId());
                dmsNonDrugItemRecordResult.setExcuteDeptName(smsDept.getName());
            }
            dmsNonDrugItemRecordResult.setStatus(dmsNonDrugItemRecord.getStatus());
            dmsNonDrugItemRecordResult.setType(dmsNonDrugItemRecord.getType());
            dmsNonDrugItemRecordResult.setCheckResult(dmsNonDrugItemRecord.getCheckResult());
            dmsNonDrugItemRecordResult.setResultImgUrlList(dmsNonDrugItemRecord.getResultImgUrlList());
            dmsNonDrugItemRecordResult.setCreateTime(dmsNonDrugItemRecord.getCreateTime());
            //excuteStaffName
            if (dmsNonDrugItemRecord.getExcuteStaffId() !=  null){
                SmsStaff smsStaff = smsStaffMapper.selectByPrimaryKey(dmsNonDrugItemRecord.getExcuteStaffId());
                dmsNonDrugItemRecordResult.setExcuteStaffName(smsStaff.getName());
            }

            //createStaffName
            if (dmsNonDrugItemRecord.getCreateStaffId() != null){
                SmsStaff smsStaff1 = smsStaffMapper.selectByPrimaryKey(dmsNonDrugItemRecord.getCreateStaffId());
                dmsNonDrugItemRecordResult.setCreateStaffName(smsStaff1.getName());
            }

            //logStaffName
            if (dmsNonDrugItemRecord.getLogStaffId() != null){
                SmsStaff smsStaff2 = smsStaffMapper.selectByPrimaryKey(dmsNonDrugItemRecord.getLogStaffId());
                dmsNonDrugItemRecordResult.setLogStaffName(smsStaff2.getName());
            }
            dmsNonDrugItemRecordResultList.add(dmsNonDrugItemRecordResult);
        }
        return dmsNonDrugItemRecordResultList;
    }

    @Override
    public AppCheckTestResult appGetResult(Long id){
        AppCheckTestResult result = new AppCheckTestResult();
        DmsNonDrugItemRecord record = dmsNonDrugItemRecordMapper.selectByPrimaryKey(id);
        if(record == null){
            return result;
        }
        result.setCheckParts(record.getCheckParts());
        result.setCheckResult(record.getCheckResult());
        result.setResultImgUrlList(record.getResultImgUrlList());

        return result;
    }

}
