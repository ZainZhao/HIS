package com.neu.his.cloud.zuul.controller.bms;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.distribution.api.pc.bms.ApiPcBmsFeeQueryDistributionService;
import com.neu.his.cloud.zuul.dto.bms.BmsDoctorPatientFeeResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "BmsFeeQueryDistributionController", description = "费用查询")
@RequestMapping("/feeQuery")
@CrossOrigin(allowCredentials = "true")
public class BmsFeeQueryDistributionController {

    @Autowired
    private ApiPcBmsFeeQueryDistributionService apiPcBmsFeeQueryDistributionService;


    @HystrixCommand(fallbackMethod = "listFeeByRegistrationIdFallbackInfo")
    @ApiOperation("根据挂号Id查询患者费用")
    @RequestMapping(value = "/listByRegistration", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<BmsDoctorPatientFeeResult>> listFeeByRegistrationId(@RequestParam("registrationId") Long registrationId){
       return  apiPcBmsFeeQueryDistributionService.listFeeByRegistrationId(registrationId);
    }
    private CommonResult<List<BmsDoctorPatientFeeResult>> listFeeByRegistrationIdFallbackInfo( Long registrationId){
        return CommonResult.success(null,"请检查您的网络") ;
    }



}
