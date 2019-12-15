package com.neu.his.cloud.zuul.mapper;

import com.neu.his.cloud.zuul.model.DmsDrug;
import com.neu.his.cloud.zuul.model.DmsDrugExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DmsDrugMapper {
    int countByExample(DmsDrugExample example);

    int deleteByExample(DmsDrugExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DmsDrug record);

    int insertSelective(DmsDrug record);

    List<DmsDrug> selectByExample(DmsDrugExample example);

    DmsDrug selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DmsDrug record, @Param("example") DmsDrugExample example);

    int updateByExample(@Param("record") DmsDrug record, @Param("example") DmsDrugExample example);

    int updateByPrimaryKeySelective(DmsDrug record);

    int updateByPrimaryKey(DmsDrug record);
}