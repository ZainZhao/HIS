package com.neu.his.cloud.zuul.mapper;

import com.neu.his.cloud.zuul.model.DmsDiseCatalog;
import com.neu.his.cloud.zuul.model.DmsDiseCatalogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DmsDiseCatalogMapper {
    int countByExample(DmsDiseCatalogExample example);

    int deleteByExample(DmsDiseCatalogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DmsDiseCatalog record);

    int insertSelective(DmsDiseCatalog record);

    List<DmsDiseCatalog> selectByExample(DmsDiseCatalogExample example);

    DmsDiseCatalog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DmsDiseCatalog record, @Param("example") DmsDiseCatalogExample example);

    int updateByExample(@Param("record") DmsDiseCatalog record, @Param("example") DmsDiseCatalogExample example);

    int updateByPrimaryKeySelective(DmsDiseCatalog record);

    int updateByPrimaryKey(DmsDiseCatalog record);
}