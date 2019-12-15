package com.neu.his.cloud.zuul.distribution.api.pc.bms;


import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.dto.bms.BmsInvoiceResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@FeignClient(value = "his-cloud-api-pc")
public interface ApiPcBmsInvoiceDistributionService {


    @RequestMapping(value = "/invoice/supplementPrintInvoice", method = RequestMethod.GET)
    CommonResult supplementPrintInvoice(@RequestParam("newInvoiceNo") Long newInvoiceNo, @RequestParam("registrationId") Long registrationId);

    @RequestMapping(value = "/invoice/reprintInvoice", method = RequestMethod.GET)
    CommonResult  reprintInvoice(@RequestParam("newInvoiceNo") Long newInvoiceNo, @RequestParam("oldInvoiceNo") Long oldInvoiceNo);

    @RequestMapping(value = "/invoice/queryInvoiceInfo", method = RequestMethod.GET)
    CommonResult<List<BmsInvoiceResult>>  queryInvoiceInfo(@RequestParam("cashierId") Long cashierId, @RequestParam("startDatetime")String startDatetime, @RequestParam("endDatetime")String endDatetime);

    @RequestMapping(value = "/invoice/queryInvoiceInfoBySettleId", method = RequestMethod.GET)
    CommonResult<List<BmsInvoiceResult>>  queryInvoiceInfoBySettleId(@RequestParam("settleRecordId") Long settleRecordId);
}
