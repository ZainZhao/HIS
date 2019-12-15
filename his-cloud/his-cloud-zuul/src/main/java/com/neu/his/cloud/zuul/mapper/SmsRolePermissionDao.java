package com.neu.his.cloud.zuul.mapper;


import com.neu.his.cloud.zuul.model.SmsPermission;
import com.neu.his.cloud.zuul.model.SmsRolePermissionRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: SmsRolePermissionDao
 * @description: TODO
 * @author Zain
 * @date 2019/5/30 14:22
 */

@Mapper
public interface SmsRolePermissionDao {
    /**
     * 根据角色获取权限
     * <p>author:赵煜
     */
    List<SmsPermission> getPermissionList(@Param("roleId") Long roleId);

    /**
     * 批量插入角色和权限关系
     * <p>author:赵煜
     */
    int insertList(@Param("list") List<SmsRolePermissionRelation> list);



}
