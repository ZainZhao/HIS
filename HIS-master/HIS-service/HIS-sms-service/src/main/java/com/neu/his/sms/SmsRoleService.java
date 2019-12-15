package com.neu.his.sms;


import com.neu.his.common.dto.sms.SmsRoleParam;
import com.neu.his.mbg.model.SmsPermission;
import com.neu.his.mbg.model.SmsRole;

import java.util.List;

/**
 * 角色
 */
public interface SmsRoleService {
    /**
     * 描述：新增角色
     */
    int create(SmsRoleParam smsRoleParam);

    /**
     * 描述：更新角色
     */
    int update(Long id, SmsRoleParam smsRoleParam);

    /**
     * 描述：删除角色
     */
    int delete(List<Long> ids);

    /**
     * 描述：列出所有角色
     */
    List<SmsRole> selectAll();


    /**
     * 描述：查询角色
     */
    List<SmsRole> select(SmsRoleParam smsRoleParam, Integer pageSize, Integer pageNum);


    /**
     * 描述：根据角色Id查询角色的权限
     */
    List<SmsPermission> getPermissionList(Long roleId);

    /**
     * 描述：根据角色ID修改指定角色的权限
     */
    int updatePermission(Long roleId, List<Long> permissionIds);




}
