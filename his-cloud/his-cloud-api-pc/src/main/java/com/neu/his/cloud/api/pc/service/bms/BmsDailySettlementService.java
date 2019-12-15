package com.neu.his.cloud.api.pc.service.bms;

import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.bms.BmsDailySettleRecordResult;
import com.neu.his.cloud.api.pc.dto.bms.BmsSettleListItemResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@FeignClient(value = "his-cloud-service-bms")
public interface BmsDailySettlementService {


    @RequestMapping(value = "/dailySettlement/queryRecentEndDatetime", method = RequestMethod.GET)
    CommonResult queryRecentEndDatetime(@RequestParam("cashierId") Long cashierId);


    @RequestMapping(value = "/dailySettlement/statisticDailySettlement", method = RequestMethod.GET)
    CommonResult<BmsDailySettleRecordResult>  statisticDailySettlement(@RequestParam("cashierId") Long cashierId, @RequestParam("startDatetime") String startDatetime, @RequestParam("endDatetime") String endDatetime);


    @RequestMapping(value = "/dailySettlement/listDailySettleListRecord", method = RequestMethod.GET)
    CommonResult<List<BmsSettleListItemResult>>  listDailySettleListRecord(@RequestParam("cashierId") Long cashierId, @RequestParam("startDatetime") String startDatetime, @RequestParam("endDatetime") String endDatetime);


    @RequestMapping(value = "/dailySettlement/querySettleDetailById", method = RequestMethod.GET)
    CommonResult<BmsDailySettleRecordResult>  querySettleDetailById(@RequestParam("id") Long id);


    @RequestMapping(value = "/dailySettlement/dailySettle", method = RequestMethod.GET)
    CommonResult dailySettle(@RequestParam("cashierId") Long cashierId, @RequestParam("startDatetime") String startDatetime, @RequestParam("endDatetime") String endDatetime);


    @RequestMapping(value = "/dailySettlement/verifySettle", method = RequestMethod.GET)
    CommonResult  verifySettle(@RequestParam("verifyOperatorId") Long verifyOperatorId, @RequestParam("settleRecordId") Long settleRecordId);
}
