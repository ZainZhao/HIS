package com.neu.his.bms.service;

import com.neu.his.common.dto.bms.BmsSettlementCatParam;
import com.neu.his.common.dto.bms.BmsSettlementCatResult;

import java.util.List;

/**
 * 结算类型
 */
public interface BmsSettlementCatService {

    /**
     * 描述：新增结算类型
     */
    int create(BmsSettlementCatParam bmsSettlementCatParam);

    /**
     * 描述：删除结算类型
     */
    int delete(List<Long> ids);

    /**
     * 描述：更新结算类型
     */
    int update(Long id, BmsSettlementCatParam bmsSettlementCatParam);

    /**
     * 描述：查询结算类型
     */
    List<BmsSettlementCatResult> select(BmsSettlementCatParam bmsSettlementCatParam);

    /**
     * 描述：列出所有结算类型
     */
    List<BmsSettlementCatResult> selectAll();
}
