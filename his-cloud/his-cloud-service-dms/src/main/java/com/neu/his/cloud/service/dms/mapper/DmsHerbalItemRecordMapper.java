package com.neu.his.cloud.service.dms.mapper;

import com.neu.his.cloud.service.dms.model.DmsHerbalItemRecord;
import com.neu.his.cloud.service.dms.model.DmsHerbalItemRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DmsHerbalItemRecordMapper {
    int countByExample(DmsHerbalItemRecordExample example);

    int deleteByExample(DmsHerbalItemRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DmsHerbalItemRecord record);

    int insertSelective(DmsHerbalItemRecord record);

    List<DmsHerbalItemRecord> selectByExample(DmsHerbalItemRecordExample example);

    DmsHerbalItemRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DmsHerbalItemRecord record, @Param("example") DmsHerbalItemRecordExample example);

    int updateByExample(@Param("record") DmsHerbalItemRecord record, @Param("example") DmsHerbalItemRecordExample example);

    int updateByPrimaryKeySelective(DmsHerbalItemRecord record);

    int updateByPrimaryKey(DmsHerbalItemRecord record);
}