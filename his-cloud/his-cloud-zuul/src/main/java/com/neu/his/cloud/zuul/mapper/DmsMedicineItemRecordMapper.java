package com.neu.his.cloud.zuul.mapper;

import com.neu.his.cloud.zuul.model.DmsMedicineItemRecord;
import com.neu.his.cloud.zuul.model.DmsMedicineItemRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DmsMedicineItemRecordMapper {
    int countByExample(DmsMedicineItemRecordExample example);

    int deleteByExample(DmsMedicineItemRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DmsMedicineItemRecord record);

    int insertSelective(DmsMedicineItemRecord record);

    List<DmsMedicineItemRecord> selectByExample(DmsMedicineItemRecordExample example);

    DmsMedicineItemRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DmsMedicineItemRecord record, @Param("example") DmsMedicineItemRecordExample example);

    int updateByExample(@Param("record") DmsMedicineItemRecord record, @Param("example") DmsMedicineItemRecordExample example);

    int updateByPrimaryKeySelective(DmsMedicineItemRecord record);

    int updateByPrimaryKey(DmsMedicineItemRecord record);
}