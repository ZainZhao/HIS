package com.neu.his.mbg.mapper;

import com.neu.his.mbg.model.SmsRolePermissionRelation;
import com.neu.his.mbg.model.SmsRolePermissionRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsRolePermissionRelationMapper {
    int countByExample(SmsRolePermissionRelationExample example);

    int deleteByExample(SmsRolePermissionRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsRolePermissionRelation record);

    int insertSelective(SmsRolePermissionRelation record);

    List<SmsRolePermissionRelation> selectByExample(SmsRolePermissionRelationExample example);

    SmsRolePermissionRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsRolePermissionRelation record, @Param("example") SmsRolePermissionRelationExample example);

    int updateByExample(@Param("record") SmsRolePermissionRelation record, @Param("example") SmsRolePermissionRelationExample example);

    int updateByPrimaryKeySelective(SmsRolePermissionRelation record);

    int updateByPrimaryKey(SmsRolePermissionRelation record);
}