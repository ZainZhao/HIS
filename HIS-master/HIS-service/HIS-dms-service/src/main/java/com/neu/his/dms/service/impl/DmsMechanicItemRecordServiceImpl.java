package com.neu.his.dms.service.impl;

import com.neu.his.common.dto.dms.DmsMechanicItemRecordResult;
import com.neu.his.dms.service.DmsMechanicItemRecordService;
import com.neu.his.mbg.mapper.*;
import com.neu.his.mbg.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DmsMechanicItemRecordServiceImpl implements DmsMechanicItemRecordService {

    @Autowired
    private DmsNonDrugItemRecordMapper dmsNonDrugItemRecordMapper;

    @Autowired
    private DmsNonDrugMapper dmsNonDrugMapper;

    @Autowired
    private DmsRegistrationMapper dmsRegistrationMapper;

    @Autowired
    private PmsPatientMapper pmsPatientMapper;
    @Autowired
    private SmsStaffMapper smsStaffMapper;


    /**
     * 描述:1.根据科室id和status为2未登记（已缴费） 3已登记 查询dms_non_drug_item_record
     *      2.封装信息
     * <p>author: ma
     * <p>author: 赵煜  修改type判断空指针异常 封装登记医生姓名 登记时间
     */
    @Override
    public List<DmsMechanicItemRecordResult> listByDept(Long deptId){
        DmsNonDrugItemRecordExample example = new DmsNonDrugItemRecordExample();
        example.createCriteria().andExcuteDeptIdEqualTo(deptId).andStatusBetween(2,3);//2未登记（已缴费） 3已登记
        List<DmsNonDrugItemRecord> recordList = dmsNonDrugItemRecordMapper.selectByExample(example);

        List<DmsMechanicItemRecordResult> resultList = new ArrayList<>();
        for(DmsNonDrugItemRecord record : recordList){
            DmsMechanicItemRecordResult result = new DmsMechanicItemRecordResult();
            BeanUtils.copyProperties(record,result);
            result.setItemRecordId(record.getId());

            //封装项目信息
            DmsNonDrug dmsNonDrug = dmsNonDrugMapper.selectByPrimaryKey(record.getNoDrugId());
            if(dmsNonDrug != null){
                result.setItemName(dmsNonDrug.getName());
            }

            if(record.getType()==null){
                continue;
            }else if(record.getType() == 0){
                result.setItemType("检查");
            }else if(record.getType() == 1){
                result.setItemType("检验");
            }else if(record.getType() == 2){
                result.setItemType("处置");
            }else{
                continue;
            }

            //封装患者信息
            DmsRegistration dmsRegistration = dmsRegistrationMapper.selectByPrimaryKey(record.getRegistrationId());
            if(dmsRegistration != null){
                result.setPatientAgeStr(dmsRegistration.getPatientAgeStr());
                PmsPatient pmsPatient = pmsPatientMapper.selectByPrimaryKey(dmsRegistration.getPatientId());
                if(pmsPatient != null){
                    result.setPatientName(pmsPatient.getName());
                    result.setPatientGender(pmsPatient.getGender());
                }
            }

            //封装医生信息
           SmsStaff smsStaff= smsStaffMapper.selectByPrimaryKey( record.getLogStaffId());
            if(null!=smsStaff)
               result.setLogStaffName(smsStaff.getName());

            //封装开立信息
            result.setCreateTime(record.getCreateTime());

            resultList.add(result);
        }
        return resultList;
    }

    @Override
    public int log(Long itemRecordId, Long logStaffId){
        DmsNonDrugItemRecordExample recordExample = new DmsNonDrugItemRecordExample();
        recordExample.createCriteria().andStatusEqualTo(2).andIdEqualTo(itemRecordId);

        DmsNonDrugItemRecord record = new DmsNonDrugItemRecord();
        record.setStatus(3);
        record.setLogStaffId(logStaffId);
        record.setLogDatetime(new Date());

        return dmsNonDrugItemRecordMapper.updateByExampleSelective(record,recordExample);
    }

    @Override
    public int uploadResult(Long id, Long executeStaffId, String checkResult,String resultImgUrlList){
        DmsNonDrugItemRecordExample recordExample = new DmsNonDrugItemRecordExample();
        recordExample.createCriteria().andStatusEqualTo(3).andIdEqualTo(id);

        DmsNonDrugItemRecord record = new DmsNonDrugItemRecord();
        record.setStatus(4);
        record.setExcuteStaffId(executeStaffId);
        record.setCheckResult(checkResult);
        record.setExcuteTime(new Date());
        record.setResultImgUrlList(resultImgUrlList);

        return dmsNonDrugItemRecordMapper.updateByExampleSelective(record,recordExample);
    }

}
