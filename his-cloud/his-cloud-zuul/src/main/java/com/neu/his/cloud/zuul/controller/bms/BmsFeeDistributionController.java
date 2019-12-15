package com.neu.his.cloud.zuul.controller.bms;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonPage;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.distribution.api.pc.bms.ApiPcBmsFeeDistributionService;
import com.neu.his.cloud.zuul.dto.bms.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Api(tags = "BmsFeeDistributionController", description = "收退费管理")
@RequestMapping("/fee")
@CrossOrigin(allowCredentials = "true")
public class BmsFeeDistributionController {

    @Autowired
    ApiPcBmsFeeDistributionService apiPcBmsFeeDistributionService;


    @HystrixCommand(fallbackMethod = "listRegisteredPatientFallbackInfo")
    @ApiOperation(value = "查询挂号人")
    @RequestMapping(value = "/listRegisteredPatient", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<BmsRegistrationPatientResult>> listRegisteredPatient(@RequestParam(required=false,name = "medicalRecordNo") String  medicalRecordNo,
                                                                                        @RequestParam(required=false,name="queryDate")@DateTimeFormat(pattern = "yyyy-MM-dd") Date queryDate,
                                                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
       return apiPcBmsFeeDistributionService.listRegisteredPatient(medicalRecordNo,queryDate,pageSize,pageNum);
    }
    private CommonResult<CommonPage<BmsRegistrationPatientResult>> listRegisteredPatientFallbackInfo(String  medicalRecordNo, Date queryDate,Integer pageSize, Integer pageNum){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "chargeFallbackInfo")
    @ApiOperation(value = "收费")
    @RequestMapping(value = "/charge", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult charge(@RequestBody List<BmsChargeParam> bmsChargeParamList){
        return apiPcBmsFeeDistributionService.charge(bmsChargeParamList);
    }
    private CommonResult chargeFallbackInfo(List<BmsChargeParam> bmsChargeParamList){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listRefundByRegistrationIdFallbackInfo")
    @ApiOperation(value = "根据挂号id查询未缴费项目")
    @RequestMapping(value = "/listRefundByRegistrationId", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<BmsRefundChargeResult>>  listRefundByRegistrationId(@RequestParam("registrationId") Long registrationId){
       return apiPcBmsFeeDistributionService.listRefundByRegistrationId(registrationId);
    }
    private CommonResult<List<BmsRefundChargeResult>>  listRefundByRegistrationIdFallbackInfo(Long registrationId){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "refundChargeFallbackInfo")
    @ApiOperation(value = "非药品、药品退费")
    @RequestMapping(value = "/refundCharge", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult refundCharge(@RequestBody List<BmsRefundChargeParam> bmsRefundChargeParamList){
       return apiPcBmsFeeDistributionService.refundCharge(bmsRefundChargeParamList);
    }
    private CommonResult refundChargeFallbackInfo(List<BmsRefundChargeParam> bmsRefundChargeParamList){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "refundRegistrationChargeFallbackInfo")
    @ApiOperation(value = "挂号退费")
    @RequestMapping(value = "/refundRegistrationCharge", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult refundRegistrationCharge(@RequestBody BmsRefundRegChargeParam bmsRefundRegChargeParam){
       return apiPcBmsFeeDistributionService.refundRegistrationCharge(bmsRefundRegChargeParam);
    }
    private CommonResult refundRegistrationChargeFallbackInfo(BmsRefundRegChargeParam bmsRefundRegChargeParam){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listChargeByRegistrationIdFallbackInfo")
    @ApiOperation(value = "根据挂号Id查询所有未交费项目")
    @RequestMapping(value = "/listChargeByRegistrationId", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<BmsChargeResult>>  listChargeByRegistrationId(@RequestParam("registrationId") Long registrationId){
        return apiPcBmsFeeDistributionService.listChargeByRegistrationId(registrationId);
    }
    private CommonResult<List<BmsChargeResult>>  listChargeByRegistrationIdFallbackInfo( Long registrationId){
        return CommonResult.success(null,"请检查您的网络") ;
    }
}
