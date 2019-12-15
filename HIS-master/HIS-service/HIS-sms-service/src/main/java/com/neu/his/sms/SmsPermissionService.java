package com.neu.his.sms;

import com.neu.his.common.dto.sms.SmsPermissionNode;
import com.neu.his.common.dto.sms.SmsPermissionParam;
import com.neu.his.common.dto.sms.SmsRoleParam;
import com.neu.his.mbg.model.SmsPermission;
import com.neu.his.mbg.model.SmsRole;

import java.util.List;

/**
 * 权限
 */
public interface SmsPermissionService {

    /**
     * 描述：新增权限
     */
    int create(SmsPermissionParam smsPermissionParam);

    /**
     * 描述：更新权限信息（可能传进控制替换原数据）
     */
    int update(Long id,SmsPermissionParam smsPermissionParam);

    /**
     * 描述：删除权限
     */
     int delete(List<Long> ids);

    /**
     * 描述：查询所有权限
     */
    List<SmsPermission> selectAll();




    /**
     * 描述:权限树
     * <p>author: 赵煜
     */
    List<SmsPermissionNode> treeList();
//
//    /**
//     * 将权限转换为带有子级的权限对象
//     * 当找不到子级权限的时候map操作不会再递归调用covert
//     */
//    private UmsPermissionNode covert(UmsPermission permission,List<UmsPermission> permissionList);
//


}
