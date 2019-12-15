package com.neu.his.cloud.zuul.controller.bms;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.distribution.api.pc.bms.ApiPcBmsDailySettlementDistributionService;
import com.neu.his.cloud.zuul.dto.bms.BmsDailySettleRecordResult;
import com.neu.his.cloud.zuul.dto.bms.BmsSettleListItemResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Api(tags = "BmsDailySettlementDistributionController", description = "日结管理")
@RequestMapping("/dailySettlement")
@CrossOrigin(allowCredentials = "true")
public class BmsDailySettlementDistributionController {


   @Autowired
   ApiPcBmsDailySettlementDistributionService apiPcBmsDailySettlementDistributionService;

    @HystrixCommand(fallbackMethod = "queryRecentEndDatetimeFallbackInfo")
    @ApiOperation(value = "根据收费员Id在日结记录表中查询最近的end_datetime")
    @RequestMapping(value = "/queryRecentEndDatetime", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult queryRecentEndDatetime(@RequestParam("cashierId") Long cashierId){
         System.err.println(cashierId);

        return apiPcBmsDailySettlementDistributionService.queryRecentEndDatetime(cashierId);

    }
    private CommonResult queryRecentEndDatetimeFallbackInfo( Long cashierId){
     return CommonResult.success(null,"请检查您的网络") ;
   }

    @HystrixCommand(fallbackMethod = "statisticDailySettlementFallbackInfo")
    @ApiOperation(value = "根据起始、结束时间和收费员Id日结信息")
    @RequestMapping(value = "/statisticDailySettlement", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<BmsDailySettleRecordResult>  statisticDailySettlement(@RequestParam("cashierId") Long cashierId, @RequestParam("startDatetime")String startDatetime, @RequestParam("endDatetime") String endDatetime){
       return apiPcBmsDailySettlementDistributionService.statisticDailySettlement(cashierId, startDatetime, endDatetime);
    }
    private CommonResult<BmsDailySettleRecordResult>  statisticDailySettlementFallbackInfo( Long cashierId, String startDatetime,  String endDatetime){
      return CommonResult.success(null,"请检查您的网络") ;
    }


    @HystrixCommand(fallbackMethod = "listDailySettleListRecordFallbackInfo")
    @ApiOperation(value = "根据起始、结束时间和收费员Id列出日结历史")
    @RequestMapping(value = "/listDailySettleListRecord", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<BmsSettleListItemResult>>  listDailySettleListRecord(@RequestParam("cashierId") Long cashierId, @RequestParam("startDatetime") String startDatetime, @RequestParam("endDatetime") String endDatetime){
      return apiPcBmsDailySettlementDistributionService.listDailySettleListRecord(cashierId, startDatetime, endDatetime);
    }
   private CommonResult<List<BmsSettleListItemResult>>  listDailySettleListRecordFallbackInfo( Long cashierId, String startDatetime, String endDatetime){
    return CommonResult.success(null,"请检查您的网络") ;
   }


    @HystrixCommand(fallbackMethod = "querySettleDetailByIdFallbackInfo")
    @ApiOperation(value = "根据日结记录id查询日结详细信息")
    @RequestMapping(value = "/querySettleDetailById", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<BmsDailySettleRecordResult>  querySettleDetailById(@RequestParam("id") Long id){
         return apiPcBmsDailySettlementDistributionService.querySettleDetailById(id);
    }
    private CommonResult<BmsDailySettleRecordResult>  querySettleDetailByIdFallbackInfo(Long id){
     return CommonResult.success(null,"请检查您的网络") ;
    }


    @HystrixCommand(fallbackMethod = "dailySettleFallbackInfo")
    @ApiOperation(value = "根据起始、结束时间和收费员id统计日结信息并日结")
    @RequestMapping(value = "/dailySettle", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult dailySettle(@RequestParam("cashierId") Long cashierId, @RequestParam("startDatetime") String startDatetime, @RequestParam("endDatetime") String endDatetime){
        System.err.println("cashierId:"+cashierId);
        System.err.println("startDatetime:"+startDatetime);
        System.err.println("endDatetime:"+endDatetime);

        return apiPcBmsDailySettlementDistributionService.dailySettle(cashierId, startDatetime, endDatetime);
    }
    private CommonResult dailySettleFallbackInfo(Long cashierId,  String startDatetime, String endDatetime){
     return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "verifySettleFallbackInfo")
    @ApiOperation(value = "对账")
    @RequestMapping(value = "/verifySettle", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult  verifySettle(@RequestParam("verifyOperatorId") Long verifyOperatorId, @RequestParam("settleRecordId") Long settleRecordId){
       return apiPcBmsDailySettlementDistributionService.verifySettle(verifyOperatorId, settleRecordId);
    }
 private CommonResult  verifySettleFallbackInfo(Long verifyOperatorId, Long settleRecordId){
  return CommonResult.success(null,"请检查您的网络") ;
 }
}
