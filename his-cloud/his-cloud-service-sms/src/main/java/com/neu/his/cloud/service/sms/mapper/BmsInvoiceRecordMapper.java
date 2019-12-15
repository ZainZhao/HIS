package com.neu.his.cloud.service.sms.mapper;

import com.neu.his.cloud.service.sms.model.BmsInvoiceRecord;
import com.neu.his.cloud.service.sms.model.BmsInvoiceRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BmsInvoiceRecordMapper {
    int countByExample(BmsInvoiceRecordExample example);

    int deleteByExample(BmsInvoiceRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BmsInvoiceRecord record);

    int insertSelective(BmsInvoiceRecord record);

    List<BmsInvoiceRecord> selectByExample(BmsInvoiceRecordExample example);

    BmsInvoiceRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BmsInvoiceRecord record, @Param("example") BmsInvoiceRecordExample example);

    int updateByExample(@Param("record") BmsInvoiceRecord record, @Param("example") BmsInvoiceRecordExample example);

    int updateByPrimaryKeySelective(BmsInvoiceRecord record);

    int updateByPrimaryKey(BmsInvoiceRecord record);
}