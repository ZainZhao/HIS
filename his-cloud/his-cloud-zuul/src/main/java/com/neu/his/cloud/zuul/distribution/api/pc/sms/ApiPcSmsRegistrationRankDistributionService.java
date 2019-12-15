package com.neu.his.cloud.zuul.distribution.api.pc.sms;



import com.neu.his.cloud.zuul.common.CommonPage;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.dto.sms.SmsRegistrationRankParam;
import com.neu.his.cloud.zuul.dto.sms.SmsRegistrationRankResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "his-cloud-api-pc")
public interface ApiPcSmsRegistrationRankDistributionService {


    @RequestMapping(value = "/registerRank/create", method = RequestMethod.POST)
    CommonResult create(@RequestBody SmsRegistrationRankParam smsRegistrationRankParam);

    @RequestMapping(value = "/registerRank/delete", method = RequestMethod.POST)
    CommonResult delete(@RequestParam("ids") List<Long> ids);


    @RequestMapping(value = "/registerRank/update/{id}", method = RequestMethod.POST)
    CommonResult update(@PathVariable("id") Long id, @RequestBody SmsRegistrationRankParam smsRegistrationRankParam);


    @RequestMapping(value = "/registerRank/select", method = RequestMethod.POST)
    CommonResult<CommonPage<SmsRegistrationRankResult>> list(@RequestBody SmsRegistrationRankParam queryParam,
                                                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum);

    @RequestMapping(value = "/registerRank/selectAll", method = RequestMethod.GET)
    CommonResult<List<SmsRegistrationRankResult>> listAll();
}
