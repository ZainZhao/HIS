package com.neu.his.cloud.zuul.controller.dms;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.distribution.api.pc.dms.ApiPcDmsMedicinePrescriptionRecordDistributionService;
import com.neu.his.cloud.zuul.dto.dms.DmsMedicinePrescriptionRecordParam;
import com.neu.his.cloud.zuul.dto.dms.DmsMedicinePrescriptionRecordResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "DmsMedicinePrescriptionRecordDistributionController", description = "成药处方管理")
@RequestMapping("/DmsMedicinePrescriptionRecord")
@CrossOrigin(allowCredentials = "true")
public class DmsMedicinePrescriptionRecordDistributionController {

    @Autowired
    private ApiPcDmsMedicinePrescriptionRecordDistributionService apiPcDmsMedicinePrescriptionRecordDistributionService;

    @HystrixCommand(fallbackMethod = "applyFallbackInfo")
    @ApiOperation(value = "开立处方")
    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult apply(@RequestBody DmsMedicinePrescriptionRecordParam dmsMedicinePrescriptionRecordParam, BindingResult result){
       return apiPcDmsMedicinePrescriptionRecordDistributionService.apply(dmsMedicinePrescriptionRecordParam);
    }
    private CommonResult applyFallbackInfo( DmsMedicinePrescriptionRecordParam dmsMedicinePrescriptionRecordParam, BindingResult result){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "invalidFallbackInfo")
    @ApiOperation(value = "作废处方")
    @RequestMapping(value = "/invalid", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult invalid(@RequestParam("ids") List<Long> ids){
       return apiPcDmsMedicinePrescriptionRecordDistributionService.invalid(ids);
    }
    private CommonResult invalidFallbackInfo(List<Long> ids){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listByRegFallbackInfo")
    @ApiOperation(value = "根据挂号Id查询处方")
    @RequestMapping(value = "/listByReg", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsMedicinePrescriptionRecordResult>> listByReg(@RequestParam("registrationId") Long registrationId){
       return apiPcDmsMedicinePrescriptionRecordDistributionService.listByReg(registrationId);
    }
    private CommonResult<List<DmsMedicinePrescriptionRecordResult>> listByRegFallbackInfo( Long registrationId){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listByIdsFallbackInfo")
    @ApiOperation(value = "根据ids查询成药处方")
    @RequestMapping(value = "/listByIds", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsMedicinePrescriptionRecordResult>> listByIds(@RequestParam("ids") List<Long> ids){
       return apiPcDmsMedicinePrescriptionRecordDistributionService.listByIds(ids);
    }
    private CommonResult<List<DmsMedicinePrescriptionRecordResult>> listByIdsFallbackInfo(List<Long> ids){
        return CommonResult.success(null,"请检查您的网络") ;
    }
}
