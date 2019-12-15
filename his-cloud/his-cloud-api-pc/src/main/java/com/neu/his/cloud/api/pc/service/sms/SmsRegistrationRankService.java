package com.neu.his.cloud.api.pc.service.sms;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.cloud.api.pc.common.CommonPage;
import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.sms.SmsRegistrationRankParam;
import com.neu.his.cloud.api.pc.dto.sms.SmsRegistrationRankResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient(value = "his-cloud-service-sms")
public interface SmsRegistrationRankService {

    @RequestMapping(value = "/registerRank/create", method = RequestMethod.POST)
     CommonResult create(@RequestBody SmsRegistrationRankParam smsRegistrationRankParam);


    @RequestMapping(value = "/registerRank/delete", method = RequestMethod.POST)
     CommonResult delete(@RequestParam("ids") List<Long> ids);


    @RequestMapping(value = "/registerRank/update/{id}", method = RequestMethod.POST)
     CommonResult update(@PathVariable("id") Long id,@RequestBody SmsRegistrationRankParam smsRegistrationRankParam);


    @RequestMapping(value = "/registerRank/select", method = RequestMethod.POST)
    @ResponseBody
     CommonResult<CommonPage<SmsRegistrationRankResult>> list(@RequestBody SmsRegistrationRankParam queryParam,
                                                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum);

    @RequestMapping(value = "/registerRank/selectAll", method = RequestMethod.GET)
     CommonResult<List<SmsRegistrationRankResult>> listAll();


}
