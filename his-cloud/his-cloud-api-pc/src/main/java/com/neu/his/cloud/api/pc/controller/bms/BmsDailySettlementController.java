package com.neu.his.cloud.api.pc.controller.bms;

import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.bms.BmsDailySettleRecordResult;
import com.neu.his.cloud.api.pc.dto.bms.BmsSettleListItemResult;
import com.neu.his.cloud.api.pc.service.bms.BmsDailySettlementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Api(tags = "BmsDailySettlementController", description = "日结管理")
@RequestMapping("/dailySettlement")
@CrossOrigin(allowCredentials = "true")
public class BmsDailySettlementController {
    @Autowired
    BmsDailySettlementService bmsDailySettlementService;

    @ApiOperation(value = "根据收费员Id在日结记录表中查询最近的end_datetime")
    @RequestMapping(value = "/queryRecentEndDatetime", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult queryRecentEndDatetime(@RequestBody Long cashierId){
        System.err.println(cashierId);
        CommonResult commonResult=bmsDailySettlementService.queryRecentEndDatetime(cashierId);
        return commonResult;
    }

    @ApiOperation(value = "根据起始、结束时间和收费员Id日结信息")
    @RequestMapping(value = "/statisticDailySettlement", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<BmsDailySettleRecordResult>  statisticDailySettlement(@RequestParam("cashierId") Long cashierId, @RequestParam("startDatetime") String startDatetime, @RequestParam("endDatetime") String endDatetime){
       return bmsDailySettlementService.statisticDailySettlement(cashierId, startDatetime, endDatetime);
    }

    @ApiOperation(value = "根据起始、结束时间和收费员Id列出日结历史")
    @RequestMapping(value = "/listDailySettleListRecord", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<BmsSettleListItemResult>>  listDailySettleListRecord(@RequestParam("cashierId") Long cashierId, @RequestParam("startDatetime") String startDatetime, @RequestParam("endDatetime") String endDatetime){
      return bmsDailySettlementService.listDailySettleListRecord(cashierId, startDatetime, endDatetime);
    }

    @ApiOperation(value = "根据日结记录id查询日结详细信息")
    @RequestMapping(value = "/querySettleDetailById", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<BmsDailySettleRecordResult>  querySettleDetailById(@RequestParam("id") Long id){
         return bmsDailySettlementService.querySettleDetailById(id);
    }

    @ApiOperation(value = "根据起始、结束时间和收费员id统计日结信息并日结")
    @RequestMapping(value = "/dailySettle", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult dailySettle(@RequestParam("cashierId") Long cashierId, @RequestParam("startDatetime") String startDatetime, @RequestParam("endDatetime") String endDatetime){
        return bmsDailySettlementService.dailySettle(cashierId, startDatetime, endDatetime);
    }

    @ApiOperation(value = "对账")
    @RequestMapping(value = "/verifySettle", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult  verifySettle(@RequestParam("verifyOperatorId") Long verifyOperatorId, @RequestParam("settleRecordId") Long settleRecordId){
       return bmsDailySettlementService.verifySettle(verifyOperatorId, settleRecordId);
    }
}
