package com.neu.his.cloud.zuul.controller.sms;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.distribution.api.pc.sms.ApiPcSmsFrequentUsedDistributionService;
import com.neu.his.cloud.zuul.dto.sms.SmsFrequentUsedResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "SmsFrequentUsedDistributionController", description = "常用项管理")
@RequestMapping("/frequentUsed")
@CrossOrigin(allowCredentials = "true")
public class SmsFrequentUsedDistributionController {

    @Autowired
    private ApiPcSmsFrequentUsedDistributionService apiPcSmsFrequentUsedDistributionService;

    @HystrixCommand(fallbackMethod = "addFrequentFallbackInfo")
    @ApiOperation("新增常用项")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult addFrequent(@RequestParam("staffId") Long staffId,
                                    @RequestParam("addType") int addType,
                                    @RequestParam("addId") Long addId){
       return  apiPcSmsFrequentUsedDistributionService.addFrequent(staffId,addType,addId);
    }
    private CommonResult addFrequentFallbackInfo(Long staffId, int addType, Long addId){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "deleteFrequentFallbackInfo")
    @ApiOperation("删除常用项")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteFrequent(@RequestParam("staffId") Long staffId,
                               @RequestParam("deleteType") int deleteType,
                               @RequestParam("deleteId") Long deleteId){
       return  apiPcSmsFrequentUsedDistributionService.deleteFrequent(staffId,deleteType,deleteId);
    }
    private CommonResult deleteFrequentFallbackInfo(Long staffId, int deleteType, Long deleteId){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "selectFrequentFallbackInfo")
    @ApiOperation("查询指定常用项")
    @RequestMapping(value = "/selectByType", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<SmsFrequentUsedResult> selectFrequent(@RequestParam("staffId") Long staffId,
                                                              @RequestParam("selectType") int selectType){
       return  apiPcSmsFrequentUsedDistributionService.selectFrequent(staffId,selectType);
    }
    private CommonResult<SmsFrequentUsedResult> selectFrequentFallbackInfo( Long staffId, int selectType){
        return CommonResult.success(null,"请检查您的网络") ;
    }

}
