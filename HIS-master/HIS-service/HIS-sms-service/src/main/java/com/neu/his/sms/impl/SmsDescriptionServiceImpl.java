package com.neu.his.sms.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.neu.his.common.dto.app.AppDeptDescriptionResult;
import com.neu.his.common.dto.app.AppDocSkdResult;
import com.neu.his.common.dto.app.AppStaffDescriptionResult;
import com.neu.his.mbg.mapper.SmsDeptMapper;
import com.neu.his.mbg.mapper.SmsDescriptionMapper;
import com.neu.his.mbg.mapper.SmsStaffMapper;
import com.neu.his.mbg.model.*;
import com.neu.his.sms.SmsDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 科室、医生描述信息
 */
@Service
public class SmsDescriptionServiceImpl implements SmsDescriptionService {

    @Autowired
    SmsDescriptionMapper smsDescriptionMapper;

    @Autowired
    SmsStaffMapper smsStaffMapper;

    @Autowired
    SmsDeptMapper smsDeptMapper;

    @Override
    public AppDocSkdResult getDetailById(Long id){
        SmsDescriptionExample smsDescriptionExample=new SmsDescriptionExample();
        smsDescriptionExample.createCriteria().andTheIdEqualTo(id).andTypeEqualTo(2);

        List<SmsDescription> smsDescriptionList= smsDescriptionMapper.selectByExample(smsDescriptionExample);
        //数据正常的情况下 只会查找除一条记录
        if(CollectionUtil.isEmpty(smsDescriptionList)||smsDescriptionList.size()>1){
            return null;
        }

        AppDocSkdResult result = new AppDocSkdResult();
        result.setUrl(smsDescriptionList.get(0).getUrl());
        result.setStar(smsDescriptionList.get(0).getStar());
        result.setDescription(smsDescriptionList.get(0).getDescription());

        SmsStaff staff = smsStaffMapper.selectByPrimaryKey(id);
        if(staff == null){
            return null;
        }
        SmsDept dept = smsDeptMapper.selectByPrimaryKey(staff.getDeptId());
        if(dept == null){
            return null;
        }

        result.setDeptId(dept.getId());
        result.setDeptName(dept.getName());

        return result;
    }

    @Override
    public List<AppStaffDescriptionResult> getDetailListByDept(Long id) {
        List<AppStaffDescriptionResult> resultList = new ArrayList<>();
        //先查科室下所有专家
        SmsStaffExample staffExample = new SmsStaffExample();
        staffExample.createCriteria().andDeptIdEqualTo(id)
                .andRegistrationRankIdEqualTo(new Long(2))
                .andStatusEqualTo(1);
        List<SmsStaff> staffList = smsStaffMapper.selectByExample(staffExample);
        if(staffList.isEmpty()){
            return resultList;
        }
        List<Long> idList = new ArrayList<>();
        for(SmsStaff staff : staffList){
            idList.add(staff.getId());
        }

        SmsDescriptionExample smsDescriptionExample = new SmsDescriptionExample();
        smsDescriptionExample.createCriteria().andTheIdIn(idList).andTypeEqualTo(2).andStatusEqualTo(1);//type 2 人
        List<SmsDescription> smsDescriptionList= smsDescriptionMapper.selectByExample(smsDescriptionExample);

        for(SmsStaff staff : staffList){
            for(SmsDescription description : smsDescriptionList){
                if(staff.getId() == description.getTheId()){
                    AppStaffDescriptionResult result = new AppStaffDescriptionResult();
                    result.setId(staff.getId());
                    result.setName(staff.getName());
                    result.setUrl(description.getUrl());
                    resultList.add(result);
                }
            }
        }

        return resultList;
    }

    @Override
    public List<AppDeptDescriptionResult> getDeptDescription(){
        List<AppDeptDescriptionResult> resultList = new ArrayList<>();
        SmsDescriptionExample smsDescriptionExample=new SmsDescriptionExample();
        smsDescriptionExample.createCriteria().andStatusEqualTo(1).andTypeEqualTo(1);

        List<SmsDescription> smsDescriptionList= smsDescriptionMapper.selectByExample(smsDescriptionExample);
        if(smsDescriptionList.size() <= 0){
            return resultList;
        }

        for(SmsDescription description : smsDescriptionList){
            AppDeptDescriptionResult result = new AppDeptDescriptionResult();
            result.setDeptId(description.getTheId());
            SmsDept dept = smsDeptMapper.selectByPrimaryKey(description.getTheId());
            if(dept == null){
                continue;
            }
            result.setDeptName(dept.getName());
            result.setDescription(description.getDescription());
            result.setUrl(description.getUrl());
            resultList.add(result);
        }
        return resultList;
    }
}
