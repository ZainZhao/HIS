package com.neu.his.mbg.mapper;

import com.neu.his.mbg.model.SmsRole;
import com.neu.his.mbg.model.SmsRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsRoleMapper {
    int countByExample(SmsRoleExample example);

    int deleteByExample(SmsRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsRole record);

    int insertSelective(SmsRole record);

    List<SmsRole> selectByExample(SmsRoleExample example);

    SmsRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsRole record, @Param("example") SmsRoleExample example);

    int updateByExample(@Param("record") SmsRole record, @Param("example") SmsRoleExample example);

    int updateByPrimaryKeySelective(SmsRole record);

    int updateByPrimaryKey(SmsRole record);
}