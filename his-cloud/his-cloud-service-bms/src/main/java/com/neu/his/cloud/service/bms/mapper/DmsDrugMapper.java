package com.neu.his.cloud.service.bms.mapper;

import com.neu.his.cloud.service.bms.model.DmsDrug;
import com.neu.his.cloud.service.bms.model.DmsDrugExample;
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