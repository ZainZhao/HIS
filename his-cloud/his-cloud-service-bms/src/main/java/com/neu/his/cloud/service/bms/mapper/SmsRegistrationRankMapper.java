package com.neu.his.cloud.service.bms.mapper;

import com.neu.his.cloud.service.bms.model.SmsRegistrationRank;
import com.neu.his.cloud.service.bms.model.SmsRegistrationRankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsRegistrationRankMapper {
    int countByExample(SmsRegistrationRankExample example);

    int deleteByExample(SmsRegistrationRankExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsRegistrationRank record);

    int insertSelective(SmsRegistrationRank record);

    List<SmsRegistrationRank> selectByExample(SmsRegistrationRankExample example);

    SmsRegistrationRank selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsRegistrationRank record, @Param("example") SmsRegistrationRankExample example);

    int updateByExample(@Param("record") SmsRegistrationRank record, @Param("example") SmsRegistrationRankExample example);

    int updateByPrimaryKeySelective(SmsRegistrationRank record);

    int updateByPrimaryKey(SmsRegistrationRank record);
}