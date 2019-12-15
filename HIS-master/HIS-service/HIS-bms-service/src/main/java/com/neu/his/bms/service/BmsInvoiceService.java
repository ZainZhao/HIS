package com.neu.his.bms.service;

import com.neu.his.common.dto.bms.BmsInvoiceResult;

import java.util.Date;
import java.util.List;

/**
 * 发票
 */
public interface BmsInvoiceService {
    /**
     * 描述：发票补打
     */
    int supplementPrintInvoice(Long newInvoiceNo, Long registrationId);
    /**
     * 描述：发票重打
     */
    int reprintInvoice(Long newInvoiceNo, Long oldInvoiceNo);
    /**
     * 描述：根据新的start_datetime和end_datetime和收费员id，查询发票信息
     */
    List<BmsInvoiceResult> queryInvoiceInfo(Long cashierId, Date startDatetime, Date endDatetime);
    /**
     * 描述：根据日结记录id查询发票
     */
    List<BmsInvoiceResult> queryInvoiceInfoBySettleId(Long settleRecordId);

}
