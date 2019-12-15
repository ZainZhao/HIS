package com.neu.his.mbg.mapper;

import com.neu.his.mbg.model.DmsHerbalModelItem;
import com.neu.his.mbg.model.DmsHerbalModelItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DmsHerbalModelItemMapper {
    int countByExample(DmsHerbalModelItemExample example);

    int deleteByExample(DmsHerbalModelItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DmsHerbalModelItem record);

    int insertSelective(DmsHerbalModelItem record);

    List<DmsHerbalModelItem> selectByExample(DmsHerbalModelItemExample example);

    DmsHerbalModelItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DmsHerbalModelItem record, @Param("example") DmsHerbalModelItemExample example);

    int updateByExample(@Param("record") DmsHerbalModelItem record, @Param("example") DmsHerbalModelItemExample example);

    int updateByPrimaryKeySelective(DmsHerbalModelItem record);

    int updateByPrimaryKey(DmsHerbalModelItem record);
}