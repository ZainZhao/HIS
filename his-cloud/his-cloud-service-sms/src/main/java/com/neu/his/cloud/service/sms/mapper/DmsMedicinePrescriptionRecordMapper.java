package com.neu.his.cloud.service.sms.mapper;

import com.neu.his.cloud.service.sms.model.DmsMedicinePrescriptionRecord;
import com.neu.his.cloud.service.sms.model.DmsMedicinePrescriptionRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DmsMedicinePrescriptionRecordMapper {
    int countByExample(DmsMedicinePrescriptionRecordExample example);

    int deleteByExample(DmsMedicinePrescriptionRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DmsMedicinePrescriptionRecord record);

    int insertSelective(DmsMedicinePrescriptionRecord record);

    List<DmsMedicinePrescriptionRecord> selectByExample(DmsMedicinePrescriptionRecordExample example);

    DmsMedicinePrescriptionRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DmsMedicinePrescriptionRecord record, @Param("example") DmsMedicinePrescriptionRecordExample example);

    int updateByExample(@Param("record") DmsMedicinePrescriptionRecord record, @Param("example") DmsMedicinePrescriptionRecordExample example);

    int updateByPrimaryKeySelective(DmsMedicinePrescriptionRecord record);

    int updateByPrimaryKey(DmsMedicinePrescriptionRecord record);
}