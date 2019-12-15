package com.neu.his.cloud.service.sms.mapper;

import com.neu.his.cloud.service.sms.model.SmsWorkloadRecord;
import com.neu.his.cloud.service.sms.model.SmsWorkloadRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsWorkloadRecordMapper {
    int countByExample(SmsWorkloadRecordExample example);

    int deleteByExample(SmsWorkloadRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsWorkloadRecord record);

    int insertSelective(SmsWorkloadRecord record);

    List<SmsWorkloadRecord> selectByExample(SmsWorkloadRecordExample example);

    SmsWorkloadRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsWorkloadRecord record, @Param("example") SmsWorkloadRecordExample example);

    int updateByExample(@Param("record") SmsWorkloadRecord record, @Param("example") SmsWorkloadRecordExample example);

    int updateByPrimaryKeySelective(SmsWorkloadRecord record);

    int updateByPrimaryKey(SmsWorkloadRecord record);
}