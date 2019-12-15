package com.neu.his.cloud.zuul.service.sms.impl;


import com.neu.his.cloud.zuul.mapper.SmsRolePermissionDao;
import com.neu.his.cloud.zuul.model.SmsPermission;
import com.neu.his.cloud.zuul.service.sms.SmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsRoleServiceImpl implements SmsRoleService {


    @Autowired
    private SmsRolePermissionDao rolePermissionDao;


    @Override
    public List<SmsPermission> getPermissionList(Long roleId) {

      return rolePermissionDao.getPermissionList(roleId);
    }


}
