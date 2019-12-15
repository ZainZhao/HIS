package com.neu.his.cloud.zuul.service.sms;

import com.neu.his.cloud.zuul.model.SmsPermission;
import com.neu.his.cloud.zuul.model.SmsStaff;

import java.util.List;

/**
 * @author Zain
 * @title: SmsRoleService
 * @projectName his-cloud
 * @description: TODO
 * @date 2019/6/17 14:20
 */
public interface SmsRoleService {

    /**
     * 描述:根据角色Id查询角色的权限
     * <p>author: 赵煜
     */
    List<SmsPermission> getPermissionList(Long roleId);
}
