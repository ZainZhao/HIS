package com.neu.his.cloud.service.sms.mapper;

import com.neu.his.cloud.service.sms.model.BmsBillsRecord;
import com.neu.his.cloud.service.sms.model.BmsBillsRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BmsBillsRecordMapper {
    int countByExample(BmsBillsRecordExample example);

    int deleteByExample(BmsBillsRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BmsBillsRecord record);

    int insertSelective(BmsBillsRecord record);

    List<BmsBillsRecord> selectByExample(BmsBillsRecordExample example);

    BmsBillsRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BmsBillsRecord record, @Param("example") BmsBillsRecordExample example);

    int updateByExample(@Param("record") BmsBillsRecord record, @Param("example") BmsBillsRecordExample example);

    int updateByPrimaryKeySelective(BmsBillsRecord record);

    int updateByPrimaryKey(BmsBillsRecord record);
}