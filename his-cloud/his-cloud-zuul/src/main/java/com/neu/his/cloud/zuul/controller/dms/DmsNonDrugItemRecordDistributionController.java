package com.neu.his.cloud.zuul.controller.dms;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.distribution.api.pc.dms.ApiPcDmsNonDrugItemRecordDistributionService;
import com.neu.his.cloud.zuul.dto.dms.DmsNonDrugItemRecordListParam;
import com.neu.his.cloud.zuul.dto.dms.DmsNonDrugItemRecordResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "DmsNonDrugItemRecordDistributionController", description = "非药品收费项目管理")
@RequestMapping("/nonDrugItemRecord")
@CrossOrigin(allowCredentials = "true")
public class DmsNonDrugItemRecordDistributionController {
    @Autowired
    ApiPcDmsNonDrugItemRecordDistributionService apiPcDmsNonDrugItemRecordDistributionService;

    @HystrixCommand(fallbackMethod = "applyFallbackInfo")
    @ApiOperation(value = "开立项目")
    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult apply(@RequestBody DmsNonDrugItemRecordListParam dmsNonDrugItemRecordListParam, BindingResult result){
        return apiPcDmsNonDrugItemRecordDistributionService.apply(dmsNonDrugItemRecordListParam);
    }
    public CommonResult applyFallbackInfo( DmsNonDrugItemRecordListParam dmsNonDrugItemRecordListParam, BindingResult result){
        return CommonResult.success(null,"请检查您的网络") ;
    }


    @HystrixCommand(fallbackMethod = "invalidFallbackInfo")
    @ApiOperation(value = "作废项目")
    @RequestMapping(value = "/invalid", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult invalid(@RequestParam("ids") List<Long> ids){
        return apiPcDmsNonDrugItemRecordDistributionService.invalid(ids);
    }
    private CommonResult invalidFallbackInfo(List<Long> ids){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listByRegAndTypeFallbackInfo")
    @ApiOperation(value = "刷新项目")
    @RequestMapping(value = "/listByRegAndType", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsNonDrugItemRecordResult>> listByRegAndType(@RequestParam("registrationId") Long registrationId, @RequestParam("type") Integer type){
       return apiPcDmsNonDrugItemRecordDistributionService.listByRegAndType(registrationId,type);
    }
    private CommonResult<List<DmsNonDrugItemRecordResult>> listByRegAndTypeFallbackInfo(Long registrationId, Integer type){
        return CommonResult.success(null,"请检查您的网络") ;
    }
}
