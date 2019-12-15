package com.neu.his.cloud.zuul.controller.bms;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.distribution.api.pc.bms.ApiPcBmsInvoiceDistributionService;
import com.neu.his.cloud.zuul.dto.bms.BmsInvoiceResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Api(tags = "BmsInvoiceDistributionController", description = "发票管理")
@RequestMapping("/invoice")
@CrossOrigin(allowCredentials = "true")
public class BmsInvoiceDistributionController {
    @Autowired
    ApiPcBmsInvoiceDistributionService apiPcBmsInvoiceDistributionService;

    @HystrixCommand(fallbackMethod = "supplementPrintInvoiceFallbackInfo")
    @ApiOperation(value = "补打发票")
    @RequestMapping(value = "/supplementPrintInvoice", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult supplementPrintInvoice(@RequestParam("newInvoiceNo") Long newInvoiceNo, @RequestParam("registrationId") Long registrationId){
        return apiPcBmsInvoiceDistributionService.supplementPrintInvoice(newInvoiceNo, registrationId);
    }
    private CommonResult supplementPrintInvoiceFallbackInfo( Long newInvoiceNo, Long registrationId){
        return CommonResult.success(null,"请检查您的网络") ;
    }


    @HystrixCommand(fallbackMethod = "reprintInvoiceFallbackInfo")
    @ApiOperation(value = "重打发票")
    @RequestMapping(value = "/reprintInvoice", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult  reprintInvoice(@RequestParam("newInvoiceNo") Long newInvoiceNo, @RequestParam("oldInvoiceNo") Long oldInvoiceNo){
        return apiPcBmsInvoiceDistributionService.reprintInvoice(newInvoiceNo, oldInvoiceNo);
    }
    private CommonResult  reprintInvoiceFallbackInfo(Long newInvoiceNo,Long oldInvoiceNo){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "queryInvoiceInfoFallbackInfo")
    @ApiOperation(value = "根据时间和收费员Id查询发票信息")
    @RequestMapping(value = "/queryInvoiceInfo", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<BmsInvoiceResult>>  queryInvoiceInfo(@RequestParam("cashierId") Long cashierId, @RequestParam("startDatetime")String startDatetime, @RequestParam("endDatetime")String endDatetime){
        return apiPcBmsInvoiceDistributionService.queryInvoiceInfo(cashierId, startDatetime, endDatetime);
    }
    private CommonResult<List<BmsInvoiceResult>>  queryInvoiceInfoFallbackInfo(Long cashierId,  String startDatetime, String endDatetime){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "queryInvoiceInfoBySettleIdFallbackInfo")
    @ApiOperation(value = "根据日结记录Id查询发票信息")
    @RequestMapping(value = "/queryInvoiceInfoBySettleId", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<BmsInvoiceResult>>  queryInvoiceInfoBySettleId(@RequestParam("settleRecordId") Long settleRecordId){
        return apiPcBmsInvoiceDistributionService.queryInvoiceInfoBySettleId(settleRecordId);
    }
    private CommonResult<List<BmsInvoiceResult>>  queryInvoiceInfoBySettleIdFallbackInfo( Long settleRecordId){
        return CommonResult.success(null,"请检查您的网络") ;
    }
}
