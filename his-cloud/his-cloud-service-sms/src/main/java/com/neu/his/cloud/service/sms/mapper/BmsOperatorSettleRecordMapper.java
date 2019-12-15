package com.neu.his.cloud.service.sms.mapper;

import com.neu.his.cloud.service.sms.model.BmsOperatorSettleRecord;
import com.neu.his.cloud.service.sms.model.BmsOperatorSettleRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BmsOperatorSettleRecordMapper {
    int countByExample(BmsOperatorSettleRecordExample example);

    int deleteByExample(BmsOperatorSettleRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BmsOperatorSettleRecord record);

    int insertSelective(BmsOperatorSettleRecord record);

    List<BmsOperatorSettleRecord> selectByExample(BmsOperatorSettleRecordExample example);

    BmsOperatorSettleRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BmsOperatorSettleRecord record, @Param("example") BmsOperatorSettleRecordExample example);

    int updateByExample(@Param("record") BmsOperatorSettleRecord record, @Param("example") BmsOperatorSettleRecordExample example);

    int updateByPrimaryKeySelective(BmsOperatorSettleRecord record);

    int updateByPrimaryKey(BmsOperatorSettleRecord record);
}