package com.neu.his.cloud.zuul.controller.sms;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonPage;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.distribution.api.pc.sms.ApiPcSmsSkdDistributionService;
import com.neu.his.cloud.zuul.distribution.api.pc.sms.ApiPcSmsStaffDistributionService;
import com.neu.his.cloud.zuul.dto.sms.SmsSkdDocParam;
import com.neu.his.cloud.zuul.dto.sms.SmsSkdDocResult;
import com.neu.his.cloud.zuul.dto.sms.SmsStaffParam;
import com.neu.his.cloud.zuul.dto.sms.SmsStaffResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "SmsStaffDistributionController", description = "用户管理")
@RequestMapping("/staff")
@CrossOrigin(allowCredentials = "true")
public class SmsStaffDistributionController {

    @Autowired
    private ApiPcSmsStaffDistributionService apiPcSmsStaffDistributionService;
    @Autowired
    private ApiPcSmsSkdDistributionService apiPcSmsSkdDistributionService;


    @HystrixCommand(fallbackMethod = "listDocBySkdFallbackInfo")
    @ApiOperation(value = "查询上班医生")
    @RequestMapping(value = "/listDocBySkd", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<SmsSkdDocResult>> listDocBySkd(@RequestBody SmsSkdDocParam smsSkdDocParam, BindingResult result){
       return apiPcSmsStaffDistributionService.listDocBySkd(smsSkdDocParam);
    }
    private CommonResult<List<SmsSkdDocResult>> listDocBySkdFallbackInfo( SmsSkdDocParam smsSkdDocParam, BindingResult result){
        return CommonResult.success(null,"请检查您的网络") ;
    }


    @HystrixCommand(fallbackMethod = "deleteFallbackInfo")
    @ApiOperation("根据ids删除用户")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        return apiPcSmsStaffDistributionService.delete(ids);
    }
    private CommonResult deleteFallbackInfo(List<Long> ids) {
        return CommonResult.success(null,"请检查您的网络") ;
    }


    @HystrixCommand(fallbackMethod = "updateFallbackInfo")
    @ApiOperation("更新用户信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody SmsStaffParam smsStaffParam, BindingResult result){
        return apiPcSmsStaffDistributionService.update(id,smsStaffParam);
    }
    private CommonResult updateFallbackInfo( Long id,  SmsStaffParam smsStaffParam, BindingResult result){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listFallbackInfo")
    @ApiOperation("模糊查询用户、且分页")
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<SmsStaffResult>> list(@RequestBody SmsStaffParam queryParam,
                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
       return apiPcSmsStaffDistributionService.list(queryParam,pageSize,pageNum);
    }
    private CommonResult<CommonPage<SmsStaffResult>> listFallbackInfo(SmsStaffParam queryParam,Integer pageSize, Integer pageNum){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listAllFallbackInfo")
    @ApiOperation("查询所有用户")
    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<SmsStaffResult>> listAll(){
        return  apiPcSmsStaffDistributionService.listAll();
    }
    private CommonResult<List<SmsStaffResult>> listAllFallbackInfo(){
        return CommonResult.success(null,"请检查您的网络") ;
    }




}
