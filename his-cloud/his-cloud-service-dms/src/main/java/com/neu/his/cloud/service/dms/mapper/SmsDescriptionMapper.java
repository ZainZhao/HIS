package com.neu.his.cloud.service.dms.mapper;

import com.neu.his.cloud.service.dms.model.SmsDescription;
import com.neu.his.cloud.service.dms.model.SmsDescriptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsDescriptionMapper {
    int countByExample(SmsDescriptionExample example);

    int deleteByExample(SmsDescriptionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsDescription record);

    int insertSelective(SmsDescription record);

    List<SmsDescription> selectByExample(SmsDescriptionExample example);

    SmsDescription selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsDescription record, @Param("example") SmsDescriptionExample example);

    int updateByExample(@Param("record") SmsDescription record, @Param("example") SmsDescriptionExample example);

    int updateByPrimaryKeySelective(SmsDescription record);

    int updateByPrimaryKey(SmsDescription record);
}