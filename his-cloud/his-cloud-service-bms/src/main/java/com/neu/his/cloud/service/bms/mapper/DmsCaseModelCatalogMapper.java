package com.neu.his.cloud.service.bms.mapper;

import com.neu.his.cloud.service.bms.model.DmsCaseModelCatalog;
import com.neu.his.cloud.service.bms.model.DmsCaseModelCatalogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DmsCaseModelCatalogMapper {
    int countByExample(DmsCaseModelCatalogExample example);

    int deleteByExample(DmsCaseModelCatalogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DmsCaseModelCatalog record);

    int insertSelective(DmsCaseModelCatalog record);

    List<DmsCaseModelCatalog> selectByExample(DmsCaseModelCatalogExample example);

    DmsCaseModelCatalog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DmsCaseModelCatalog record, @Param("example") DmsCaseModelCatalogExample example);

    int updateByExample(@Param("record") DmsCaseModelCatalog record, @Param("example") DmsCaseModelCatalogExample example);

    int updateByPrimaryKeySelective(DmsCaseModelCatalog record);

    int updateByPrimaryKey(DmsCaseModelCatalog record);
}