package com.neu.his.api.controller.bms;

import com.neu.his.bms.service.BmsInvoiceService;
import com.neu.his.common.api.CommonResult;
import com.neu.his.common.dto.bms.BmsInvoiceResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
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
        int result = bmsInvoiceService.supplementPrintInvoice(newInvoiceNo, registrationId);
        if (result == 1){
            return CommonResult.success(result);
        }
        else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "重打发票")
    @RequestMapping(value = "/reprintInvoice", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult  reprintInvoice(@RequestParam("newInvoiceNo") Long newInvoiceNo,@RequestParam("oldInvoiceNo") Long oldInvoiceNo){
        int result = bmsInvoiceService.reprintInvoice(newInvoiceNo, oldInvoiceNo);
        if (result == 1){
            return CommonResult.success(result);
        }
        else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "根据时间和收费员Id查询发票信息")
    @RequestMapping(value = "/queryInvoiceInfo", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<BmsInvoiceResult>>  queryInvoiceInfo(@RequestParam("cashierId") Long cashierId, @RequestParam("startDatetime")@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDatetime, @RequestParam("endDatetime")@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDatetime){
        List<BmsInvoiceResult> bmsInvoiceResultList = bmsInvoiceService.queryInvoiceInfo(cashierId, startDatetime, endDatetime);
        return CommonResult.success(bmsInvoiceResultList);
    }

    @ApiOperation(value = "根据日结记录Id查询发票信息")
    @RequestMapping(value = "/queryInvoiceInfoBySettleId", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<BmsInvoiceResult>>  queryInvoiceInfoBySettleId(@RequestParam("settleRecordId") Long settleRecordId){
        List<BmsInvoiceResult> bmsInvoiceResultList = bmsInvoiceService.queryInvoiceInfoBySettleId(settleRecordId);
        return CommonResult.success(bmsInvoiceResultList);
    }
}
