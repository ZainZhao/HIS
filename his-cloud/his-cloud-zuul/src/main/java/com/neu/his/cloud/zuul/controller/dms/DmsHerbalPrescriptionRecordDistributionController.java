package com.neu.his.cloud.zuul.controller.dms;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.distribution.api.pc.dms.ApiPcDmsHerbalPrescriptionRecordDistributionService;
import com.neu.his.cloud.zuul.dto.dms.DmsHerbalPrescriptionRecordParam;
import com.neu.his.cloud.zuul.dto.dms.DmsHerbalPrescriptionRecordResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "DmsHerbalPrescriptionRecordDistributionController", description = "草药处方管理")
@RequestMapping("/DmsHerbalPrescriptionRecord")
@CrossOrigin(allowCredentials = "true")
public class DmsHerbalPrescriptionRecordDistributionController {

    @Autowired
    private ApiPcDmsHerbalPrescriptionRecordDistributionService apiPcDmsHerbalPrescriptionRecordDistributionService;

    @HystrixCommand(fallbackMethod = "applyFallbackInfo")
    @ApiOperation(value = "开立处方")
    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult apply(@RequestBody DmsHerbalPrescriptionRecordParam dmsHerbalPrescriptionRecordParam, BindingResult result){
      return apiPcDmsHerbalPrescriptionRecordDistributionService.apply(dmsHerbalPrescriptionRecordParam);
    }
    private CommonResult applyFallbackInfo( DmsHerbalPrescriptionRecordParam dmsHerbalPrescriptionRecordParam, BindingResult result){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "invalidFallbackInfo")
    @ApiOperation(value = "作废处方")
    @RequestMapping(value = "/invalid", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult invalid(@RequestParam("ids") List<Long> ids){
       return apiPcDmsHerbalPrescriptionRecordDistributionService.invalid(ids);
    }
    private CommonResult invalidFallbackInfo(List<Long> ids){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listByRegFallbackInfo")
    @ApiOperation(value = "根据挂号Id查询处方")
    @RequestMapping(value = "/listByReg", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsHerbalPrescriptionRecordResult>>  listByReg(@RequestParam("registrationId") Long registrationId){
        return apiPcDmsHerbalPrescriptionRecordDistributionService.listByReg(registrationId);
    }
    private CommonResult<List<DmsHerbalPrescriptionRecordResult>>  listByRegFallbackInfo( Long registrationId){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listByIdsFallbackInfo")
    @ApiOperation(value = "根据ids查询草药处方")
    @RequestMapping(value = "/listByIds", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsHerbalPrescriptionRecordResult>>  listByIds(@RequestParam("ids") List<Long> ids){
        return apiPcDmsHerbalPrescriptionRecordDistributionService.listByIds(ids);
    }
    private CommonResult<List<DmsHerbalPrescriptionRecordResult>>  listByIdsFallbackInfo(List<Long> ids){
        return CommonResult.success(null,"请检查您的网络") ;
    }

}
