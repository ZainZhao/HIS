package com.neu.his.mbg.mapper;

import com.neu.his.mbg.model.SmsSkdRuleItem;
import com.neu.his.mbg.model.SmsSkdRuleItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsSkdRuleItemMapper {
    int countByExample(SmsSkdRuleItemExample example);

    int deleteByExample(SmsSkdRuleItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsSkdRuleItem record);

    int insertSelective(SmsSkdRuleItem record);

    List<SmsSkdRuleItem> selectByExample(SmsSkdRuleItemExample example);

    SmsSkdRuleItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsSkdRuleItem record, @Param("example") SmsSkdRuleItemExample example);

    int updateByExample(@Param("record") SmsSkdRuleItem record, @Param("example") SmsSkdRuleItemExample example);

    int updateByPrimaryKeySelective(SmsSkdRuleItem record);

    int updateByPrimaryKey(SmsSkdRuleItem record);
}