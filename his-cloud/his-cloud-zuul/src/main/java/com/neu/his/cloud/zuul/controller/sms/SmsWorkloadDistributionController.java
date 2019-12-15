package com.neu.his.cloud.zuul.controller.sms;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.distribution.api.pc.sms.ApiPcSmsWorkloadDistributionService;
import com.neu.his.cloud.zuul.dto.sms.SmsWorkloadResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Api(tags = "SmsWorkloadDistributionController", description = "工作量统计")
@RequestMapping("/workload")
@CrossOrigin(allowCredentials = "true")
public class SmsWorkloadDistributionController {

    @Autowired
    private ApiPcSmsWorkloadDistributionService apiPcSmsWorkloadDistributionService;

    @HystrixCommand(fallbackMethod = "queryPersonalWorkloadFallbackInfo")
    @ApiOperation("根据时间段查询某个人工作量")
    @RequestMapping(value = "/queryPersonal", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<SmsWorkloadResult> queryPersonalWorkload(@RequestParam("staffId") Long staffId,
                                                                 @RequestParam("startDatetime")String startDatetime,
                                                                 @RequestParam("endDatetime") String endDatetime){
        return apiPcSmsWorkloadDistributionService.queryPersonalWorkload(staffId,startDatetime,endDatetime);
    }
    private CommonResult<SmsWorkloadResult> queryPersonalWorkloadFallbackInfo( Long staffId,String startDatetime,String endDatetime){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "queryDeptWorkloadFallbackInfo")
    @ApiOperation("根据时间段统计某个科室工作量")
    @RequestMapping(value = "/queryDept", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<SmsWorkloadResult>  queryDeptWorkload(@RequestParam("deptId") Long deptId,
                                                              @RequestParam("startDatetime")String  startDatetime,
                                                              @RequestParam("endDatetime")String endDatetime){
        return apiPcSmsWorkloadDistributionService.queryDeptWorkload(deptId,startDatetime,endDatetime);
    }
    private CommonResult<SmsWorkloadResult> queryDeptWorkloadFallbackInfo( Long deptId,String startDatetime,String endDatetime){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "queryDeptWorkloadListFallbackInfo")
    @ApiOperation("根据时间段统计所有科室工作量")
    @RequestMapping(value = "/queryDeptWorkloadList", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<SmsWorkloadResult>> queryDeptWorkloadList(@RequestParam("startDatetime")String startDatetime,
                                                                        @RequestParam("endDatetime")String endDatetime){
        return apiPcSmsWorkloadDistributionService.queryDeptWorkloadList(startDatetime,endDatetime);
    }
    private CommonResult<List<SmsWorkloadResult>> queryDeptWorkloadListFallbackInfo( String startDatetime,String endDatetime){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "queryDeptPersonalWorkloadListFallbackInfo")
    @ApiOperation("根据时间段统计科室所有人工作量(一个科室所有人)")
    @RequestMapping(value = "/queryDeptPersonalWorkloadList", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<SmsWorkloadResult>>  queryDeptPersonalWorkloadList(@RequestParam("deptId") Long deptId,
                                                                                @RequestParam("startDatetime")String startDatetime,
                                                                                @RequestParam("endDatetime")String endDatetime){
        return apiPcSmsWorkloadDistributionService.queryDeptPersonalWorkloadList(deptId,startDatetime,endDatetime);
    }
    private CommonResult<List<SmsWorkloadResult>>  queryDeptPersonalWorkloadListFallbackInfo(Long deptId,String startDatetime,String endDatetime){
        return CommonResult.success(null,"请检查您的网络") ;
    }

}
