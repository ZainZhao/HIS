package com.neu.his.mbg.mapper;

import com.neu.his.mbg.model.SmsLoginLog;
import com.neu.his.mbg.model.SmsLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsLoginLogMapper {
    int countByExample(SmsLoginLogExample example);

    int deleteByExample(SmsLoginLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsLoginLog record);

    int insertSelective(SmsLoginLog record);

    List<SmsLoginLog> selectByExample(SmsLoginLogExample example);

    SmsLoginLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsLoginLog record, @Param("example") SmsLoginLogExample example);

    int updateByExample(@Param("record") SmsLoginLog record, @Param("example") SmsLoginLogExample example);

    int updateByPrimaryKeySelective(SmsLoginLog record);

    int updateByPrimaryKey(SmsLoginLog record);
}