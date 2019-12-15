package com.neu.his.cloud.api.pc.controller.bms;

import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.bms.BmsInvoiceResult;
import com.neu.his.cloud.api.pc.service.bms.BmsInvoiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Api(tags = "BmsInvoiceController", description = "发票管理")
@RequestMapping("/invoice")
@CrossOrigin(allowCredentials = "true")
public class BmsInvoiceController {
    @Autowired
    BmsInvoiceService bmsInvoiceService;

    @ApiOperation(value = "补打发票")
    @RequestMapping(value = "/supplementPrintInvoice", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult supplementPrintInvoice(@RequestParam("newInvoiceNo") Long newInvoiceNo, @RequestParam("registrationId") Long registrationId){
        return bmsInvoiceService.supplementPrintInvoice(newInvoiceNo, registrationId);
    }

    @ApiOperation(value = "重打发票")
    @RequestMapping(value = "/reprintInvoice", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult  reprintInvoice(@RequestParam("newInvoiceNo") Long newInvoiceNo, @RequestParam("oldInvoiceNo") Long oldInvoiceNo){
        return bmsInvoiceService.reprintInvoice(newInvoiceNo, oldInvoiceNo);
    }

    @ApiOperation(value = "根据时间和收费员Id查询发票信息")
    @RequestMapping(value = "/queryInvoiceInfo", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<BmsInvoiceResult>>  queryInvoiceInfo(@RequestParam("cashierId") Long cashierId, @RequestParam("startDatetime")String startDatetime, @RequestParam("endDatetime")String endDatetime){
        return bmsInvoiceService.queryInvoiceInfo(cashierId, startDatetime, endDatetime);
    }

    @ApiOperation(value = "根据日结记录Id查询发票信息")
    @RequestMapping(value = "/queryInvoiceInfoBySettleId", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<BmsInvoiceResult>>  queryInvoiceInfoBySettleId(@RequestParam("settleRecordId") Long settleRecordId){
        return bmsInvoiceService.queryInvoiceInfoBySettleId(settleRecordId);
    }
}
