package com.neu.his.cloud.service.dms.mapper;

import com.neu.his.cloud.service.dms.model.BmsSettlementCat;
import com.neu.his.cloud.service.dms.model.BmsSettlementCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BmsSettlementCatMapper {
    int countByExample(BmsSettlementCatExample example);

    int deleteByExample(BmsSettlementCatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BmsSettlementCat record);

    int insertSelective(BmsSettlementCat record);

    List<BmsSettlementCat> selectByExample(BmsSettlementCatExample example);

    BmsSettlementCat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BmsSettlementCat record, @Param("example") BmsSettlementCatExample example);

    int updateByExample(@Param("record") BmsSettlementCat record, @Param("example") BmsSettlementCatExample example);

    int updateByPrimaryKeySelective(BmsSettlementCat record);

    int updateByPrimaryKey(BmsSettlementCat record);
}