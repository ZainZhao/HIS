package com.neu.his.cloud.zuul.controller.sms;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonPage;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.distribution.api.pc.sms.ApiPcSmsFrequentUsedDistributionService;
import com.neu.his.cloud.zuul.distribution.api.pc.sms.ApiPcSmsRegistrationRankDistributionService;
import com.neu.his.cloud.zuul.dto.sms.SmsRegistrationRankParam;
import com.neu.his.cloud.zuul.dto.sms.SmsRegistrationRankResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "SmsRegistrationRankDistributionController", description = "挂号级别管理")
@RequestMapping("/registerRank")
@CrossOrigin(allowCredentials = "true")
public class SmsRegistrationRankDistributionController {


    @Autowired
    private ApiPcSmsRegistrationRankDistributionService apiPcSmsRegistrationRankDistributionService;

    @HystrixCommand(fallbackMethod = "createFallbackInfo")
    @ApiOperation("新增挂号级别")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody SmsRegistrationRankParam smsRegistrationRankParam, BindingResult result){
       return apiPcSmsRegistrationRankDistributionService.create(smsRegistrationRankParam);
    }
    private CommonResult createFallbackInfo(SmsRegistrationRankParam smsRegistrationRankParam, BindingResult result){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "deleteFallbackInfo")
    @ApiOperation("根据ids删除挂号级别")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids){
      return  apiPcSmsRegistrationRankDistributionService.delete(ids);
    }
    private CommonResult deleteFallbackInfo(List<Long> ids){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "updateFallbackInfo")
    @ApiOperation("更新挂号级别信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id, @RequestBody SmsRegistrationRankParam smsRegistrationRankParam, BindingResult result){
      return apiPcSmsRegistrationRankDistributionService.update(id,smsRegistrationRankParam);
    }
    private CommonResult updateFallbackInfo(Long id, @RequestBody SmsRegistrationRankParam smsRegistrationRankParam, BindingResult result){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listFallbackInfo")
    @ApiOperation("模糊查询挂号级别、且分页")
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<SmsRegistrationRankResult>> list(SmsRegistrationRankParam queryParam,
                                                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
       return  apiPcSmsRegistrationRankDistributionService.list(queryParam,pageSize,pageNum);
    }
    private CommonResult<CommonPage<SmsRegistrationRankResult>> listFallbackInfo(SmsRegistrationRankParam queryParam, Integer pageSize,
                                                                    Integer pageNum){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listAllFallbackInfo")
    @ApiOperation("查询所有挂号级别")
    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<SmsRegistrationRankResult>> listAll(){
       return apiPcSmsRegistrationRankDistributionService.listAll();
    }
    private CommonResult<List<SmsRegistrationRankResult>> listAllFallbackInfo(){
        return CommonResult.success(null,"请检查您的网络") ;
    }
}
