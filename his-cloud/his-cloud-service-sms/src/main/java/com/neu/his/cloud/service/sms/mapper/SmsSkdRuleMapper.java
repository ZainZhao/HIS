package com.neu.his.cloud.service.sms.mapper;

import com.neu.his.cloud.service.sms.model.SmsSkdRule;
import com.neu.his.cloud.service.sms.model.SmsSkdRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsSkdRuleMapper {
    int countByExample(SmsSkdRuleExample example);

    int deleteByExample(SmsSkdRuleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsSkdRule record);

    int insertSelective(SmsSkdRule record);

    List<SmsSkdRule> selectByExample(SmsSkdRuleExample example);

    SmsSkdRule selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsSkdRule record, @Param("example") SmsSkdRuleExample example);

    int updateByExample(@Param("record") SmsSkdRule record, @Param("example") SmsSkdRuleExample example);

    int updateByPrimaryKeySelective(SmsSkdRule record);

    int updateByPrimaryKey(SmsSkdRule record);
}