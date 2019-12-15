package com.neu.his.cloud.service.dms.mapper;

import com.neu.his.cloud.service.dms.model.SmsFrequentUsed;
import com.neu.his.cloud.service.dms.model.SmsFrequentUsedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsFrequentUsedMapper {
    int countByExample(SmsFrequentUsedExample example);

    int deleteByExample(SmsFrequentUsedExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsFrequentUsed record);

    int insertSelective(SmsFrequentUsed record);

    List<SmsFrequentUsed> selectByExample(SmsFrequentUsedExample example);

    SmsFrequentUsed selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsFrequentUsed record, @Param("example") SmsFrequentUsedExample example);

    int updateByExample(@Param("record") SmsFrequentUsed record, @Param("example") SmsFrequentUsedExample example);

    int updateByPrimaryKeySelective(SmsFrequentUsed record);

    int updateByPrimaryKey(SmsFrequentUsed record);
}