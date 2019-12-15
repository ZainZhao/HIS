package com.neu.his.cloud.service.bms.controller;


import com.neu.his.cloud.service.bms.common.CommonResult;
import com.neu.his.cloud.service.bms.dto.bms.BmsDailySettleRecordResult;
import com.neu.his.cloud.service.bms.dto.bms.BmsSettleListItemResult;
import com.neu.his.cloud.service.bms.service.BmsDailySettlementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@Api(tags = "BmsDailySettlementController", description = "日结管理")
@RequestMapping("/dailySettlement")
@CrossOrigin(allowCredentials = "true")
public class BmsDailySettlementController {
    @Autowired
    BmsDailySettlementService bmsDailySettlementService;

    @ApiOperation(value = "根据收费员Id在日结记录表中查询最近的end_datetime")
    @RequestMapping(value = "/queryRecentEndDatetime", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult queryRecentEndDatetime(@RequestParam("cashierId") Long cashierId){
        Date date = bmsDailySettlementService.queryRecentEndDatetime(cashierId);
        return CommonResult.success(date);
    }

    @ApiOperation(value = "根据起始、结束时间和收费员Id日结信息")
    @RequestMapping(value = "/statisticDailySettlement", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<BmsDailySettleRecordResult>  statisticDailySettlement(@RequestParam("cashierId") Long cashierId,
                                                                              @RequestParam("startDatetime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDatetime,
                                                                              @RequestParam("endDatetime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDatetime){
        BmsDailySettleRecordResult bmsDailySettleRecordResult = bmsDailySettlementService.statisticDailySettlement(cashierId, startDatetime, endDatetime);
        return CommonResult.success(bmsDailySettleRecordResult);
    }

    @ApiOperation(value = "根据起始、结束时间和收费员Id列出日结历史")
    @RequestMapping(value = "/listDailySettleListRecord", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<BmsSettleListItemResult>>  listDailySettleListRecord(@RequestParam("cashierId") Long cashierId,
                                                                                  @RequestParam("startDatetime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDatetime,
                                                                                  @RequestParam("endDatetime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDatetime){
        List<BmsSettleListItemResult> bmsSettleListItemResultList = bmsDailySettlementService.listDailySettleListRecord(cashierId, startDatetime, endDatetime);
        return CommonResult.success(bmsSettleListItemResultList);
    }

    @ApiOperation(value = "根据日结记录id查询日结详细信息")
    @RequestMapping(value = "/querySettleDetailById", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<BmsDailySettleRecordResult>  querySettleDetailById(@RequestParam("id") Long id){
        BmsDailySettleRecordResult bmsDailySettleRecordResult = bmsDailySettlementService.querySettleDetailById(id);
        return CommonResult.success(bmsDailySettleRecordResult);
    }

    @ApiOperation(value = "根据起始、结束时间和收费员id统计日结信息并日结")
    @RequestMapping(value = "/dailySettle", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult dailySettle(@RequestParam("cashierId") Long cashierId,
                                    @RequestParam("startDatetime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDatetime,
                                    @RequestParam("endDatetime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDatetime){
        Long result = bmsDailySettlementService.dailySettle(cashierId, startDatetime, endDatetime);
        if (result != null){
            return CommonResult.success(result);
        }
        else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "对账")
    @RequestMapping(value = "/verifySettle", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult  verifySettle(@RequestParam("verifyOperatorId") Long verifyOperatorId,@RequestParam("settleRecordId") Long settleRecordId){
        int result = bmsDailySettlementService.verifySettle(verifyOperatorId, settleRecordId);
        if (result == 1){
            return CommonResult.success(result);
        }
        else {
            return CommonResult.failed();
        }
    }
}
