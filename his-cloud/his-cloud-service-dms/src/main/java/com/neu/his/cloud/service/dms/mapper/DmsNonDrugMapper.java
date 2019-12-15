package com.neu.his.cloud.service.dms.mapper;

import com.neu.his.cloud.service.dms.model.DmsNonDrug;
import com.neu.his.cloud.service.dms.model.DmsNonDrugExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DmsNonDrugMapper {
    int countByExample(DmsNonDrugExample example);

    int deleteByExample(DmsNonDrugExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DmsNonDrug record);

    int insertSelective(DmsNonDrug record);

    List<DmsNonDrug> selectByExample(DmsNonDrugExample example);

    DmsNonDrug selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DmsNonDrug record, @Param("example") DmsNonDrugExample example);

    int updateByExample(@Param("record") DmsNonDrug record, @Param("example") DmsNonDrugExample example);

    int updateByPrimaryKeySelective(DmsNonDrug record);

    int updateByPrimaryKey(DmsNonDrug record);
}