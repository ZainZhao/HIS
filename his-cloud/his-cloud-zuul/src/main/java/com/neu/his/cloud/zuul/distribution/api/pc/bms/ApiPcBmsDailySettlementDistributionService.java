package com.neu.his.cloud.zuul.distribution.api.pc.bms;


import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.dto.bms.BmsDailySettleRecordResult;
import com.neu.his.cloud.zuul.dto.bms.BmsSettleListItemResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@FeignClient(value = "his-cloud-api-pc" )
public interface ApiPcBmsDailySettlementDistributionService {


    @RequestMapping(value = "/dailySettlement/queryRecentEndDatetime", method = RequestMethod.POST)
    CommonResult queryRecentEndDatetime(@RequestBody Long cashierId);


    @RequestMapping(value = "/dailySettlement/statisticDailySettlement", method = RequestMethod.GET)
    CommonResult<BmsDailySettleRecordResult>  statisticDailySettlement(@RequestParam("cashierId") Long cashierId, @RequestParam("startDatetime") String startDatetime, @RequestParam("endDatetime") String endDatetime);


    @RequestMapping(value = "/dailySettlement/listDailySettleListRecord", method = RequestMethod.GET)
    CommonResult<List<BmsSettleListItemResult>>  listDailySettleListRecord(@RequestParam("cashierId") Long cashierId, @RequestParam("startDatetime") String startDatetime, @RequestParam("endDatetime") String endDatetime);


    @RequestMapping(value = "/dailySettlement/querySettleDetailById", method = RequestMethod.GET)
    CommonResult<BmsDailySettleRecordResult>  querySettleDetailById(@RequestParam("id") Long id);

    @RequestMapping(value = "/dailySettlement/dailySettle", method = RequestMethod.GET)
    CommonResult dailySettle(@RequestParam("cashierId") Long cashierId, @RequestParam("startDatetime") String startDatetime, @RequestParam("endDatetime") String endDatetime);

    @RequestMapping(value = "/dailySettlement/verifySettle", method = RequestMethod.GET)
    public CommonResult  verifySettle(@RequestParam("verifyOperatorId") Long verifyOperatorId, @RequestParam("settleRecordId") Long settleRecordId);
}
