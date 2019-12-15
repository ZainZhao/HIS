package com.neu.his.mbg.mapper;

import com.neu.his.mbg.model.SmsSkd;
import com.neu.his.mbg.model.SmsSkdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsSkdMapper {
    int countByExample(SmsSkdExample example);

    int deleteByExample(SmsSkdExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsSkd record);

    int insertSelective(SmsSkd record);

    List<SmsSkd> selectByExample(SmsSkdExample example);

    SmsSkd selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsSkd record, @Param("example") SmsSkdExample example);

    int updateByExample(@Param("record") SmsSkd record, @Param("example") SmsSkdExample example);

    int updateByPrimaryKeySelective(SmsSkd record);

    int updateByPrimaryKey(SmsSkd record);
}