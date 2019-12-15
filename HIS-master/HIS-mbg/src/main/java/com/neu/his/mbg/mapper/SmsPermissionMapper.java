package com.neu.his.mbg.mapper;

import com.neu.his.mbg.model.SmsPermission;
import com.neu.his.mbg.model.SmsPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsPermissionMapper {
    int countByExample(SmsPermissionExample example);

    int deleteByExample(SmsPermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsPermission record);

    int insertSelective(SmsPermission record);

    List<SmsPermission> selectByExample(SmsPermissionExample example);

    SmsPermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsPermission record, @Param("example") SmsPermissionExample example);

    int updateByExample(@Param("record") SmsPermission record, @Param("example") SmsPermissionExample example);

    int updateByPrimaryKeySelective(SmsPermission record);

    int updateByPrimaryKey(SmsPermission record);
}