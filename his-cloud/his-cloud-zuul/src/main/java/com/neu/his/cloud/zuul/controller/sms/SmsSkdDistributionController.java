package com.neu.his.cloud.zuul.controller.sms;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonPage;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.distribution.api.pc.sms.ApiPcSmsSkdDistributionService;
import com.neu.his.cloud.zuul.dto.sms.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Api(tags = "SmsSkdDistributionController", description = "排班管理")
@RequestMapping("/skd")
@CrossOrigin(allowCredentials = "true")
public class SmsSkdDistributionController {

    @Autowired
    private ApiPcSmsSkdDistributionService apiPcSmsSkdDistributionService;

    @HystrixCommand(fallbackMethod = "createRuleFallbackInfo")
    @ApiOperation("新增排班规则")
    @RequestMapping(value = "/createRule", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createRule(@RequestBody SmsSkdRuleParam smsSkdRuleParam, BindingResult result){
       return apiPcSmsSkdDistributionService.createRule(smsSkdRuleParam);
    }
    private CommonResult createRuleFallbackInfo( SmsSkdRuleParam smsSkdRuleParam, BindingResult result){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "deleteRuleFallbackInfo")
    @ApiOperation("删除排班规则")
    @RequestMapping(value = "/deleteRule", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteRule(@RequestParam("ids") List<Long> ids){
        return apiPcSmsSkdDistributionService.deleteRule(ids);
    }
    private CommonResult deleteRuleFallbackInfo(List<Long> ids){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "updateRuleFallbackInfo")
    @ApiOperation("更新排班规则")
    @RequestMapping(value = "/updateRule/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateRule(@PathVariable Long id, @RequestBody SmsSkdRuleParam smsSkdRuleParam , BindingResult result){
     return  apiPcSmsSkdDistributionService.updateRule(id,smsSkdRuleParam);
    }
    private CommonResult updateRuleFallbackInfo( Long id, SmsSkdRuleParam smsSkdRuleParam , BindingResult result){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listRuleFallbackInfo")
    @ApiOperation("根据部门id筛选排版规则基本信息、分页")
    @RequestMapping(value = "/listRule", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<SmsSkdRuleResult>> listRule(@RequestParam("deptId")  Long deptId,
                                                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){

     return apiPcSmsSkdDistributionService.listRule(deptId,pageSize,pageNum);
    }
    private CommonResult<CommonPage<SmsSkdRuleResult>> listRuleFallbackInfo( Long deptId, Integer pageSize, Integer pageNum){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "getRuleDetailFallbackInfo")
    @ApiOperation("根据规则id查询一条规则详情")
    @RequestMapping(value = "/getRuleDetail", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<SmsSkdRuleResult> getRuleDetail(@RequestParam("ruleId") Long ruleId){
       return apiPcSmsSkdDistributionService.getRuleDetail(ruleId);
    }
    private CommonResult<SmsSkdRuleResult> getRuleDetailFallbackInfo(Long ruleId){
        return CommonResult.success(null,"请检查您的网络") ;
    }


    @HystrixCommand(fallbackMethod = "generateSkdFallbackInfo")
    @ApiOperation("根据多条排班规则生成skd")
    @RequestMapping(value = "/generateSkd", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult generateSkd(@RequestParam("ruleIds") List<Long> ruleIds, @RequestParam("startDate")String startDate, @RequestParam("endDate") String endDate){
        return apiPcSmsSkdDistributionService.generateSkd(ruleIds,startDate,endDate);
    }
    private CommonResult generateSkdFallbackInfo( List<Long> ruleIds,String startDate, String endDate){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listSkdFallbackInfo")
    @ApiOperation("查找排班记录、分页")
    @RequestMapping(value = "/listSkd", method = RequestMethod.POST)
    @ResponseBody
    public  CommonResult<CommonPage<SmsSkdResult>> listSkd(SmsSkdParam queryParam,
                                                           @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){

        return apiPcSmsSkdDistributionService.listSkd(queryParam,pageSize,pageNum);
    }
    private  CommonResult<CommonPage<SmsSkdResult>> listSkdFallbackInfo(SmsSkdParam queryParam,Integer pageSize, Integer pageNum){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listCanSkdStaffFallbackInfo")
    @ApiOperation("新增时候列出的科室下员工信息")
    @RequestMapping(value = "/listCanSkdStaff/{deptId}", method = RequestMethod.POST)
    @ResponseBody
    public  CommonResult<List<SmsSkdRuleItemResult>> listCanSkdStaff(@PathVariable Long deptId){
       return apiPcSmsSkdDistributionService.listCanSkdStaff(deptId);
    }
    private  CommonResult<List<SmsSkdRuleItemResult>> listCanSkdStaffFallbackInfo(Long deptId){
        return CommonResult.success(null,"请检查您的网络") ;
    }

}
