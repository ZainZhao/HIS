package com.neu.his.bms.service;

import com.neu.his.common.dto.bms.BmsDailySettleRecordResult;
import com.neu.his.common.dto.bms.BmsSettleListItemResult;

import java.util.Date;
import java.util.List;

/**
 * 日结
 */
public interface BmsDailySettlementService {
    /**
     * 描述：根据收费员id在日结记录表中查询最近的end_datetime
     */
    Date queryRecentEndDatetime(Long staffId);
    /**
     * 描述：根据起始、结束时间和收费员id统计日结信息
     */
    BmsDailySettleRecordResult statisticDailySettlement(Long cashierId, Date startDatetime, Date endDatetime);
    /**
     * 描述：根据起始、结束时间和收费员id列出日结历史
     */
    List<BmsSettleListItemResult> listDailySettleListRecord(Long cashierId, Date startDatetime, Date endDatetime);
    /**
     * 描述：根据日结记录id查询日结详细信息
     */
    BmsDailySettleRecordResult querySettleDetailById(Long id);
    /**
     * 描述：根据起始、结束时间和收费员id统计日结信息并日结
     */
    Long dailySettle(Long cashierId, Date startDatetime, Date endDatetime);

    /**
     * 描述：对账
     */
    int verifySettle(Long verifyOperatorId, Long settleRecordId);
}
