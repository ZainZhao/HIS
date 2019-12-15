package com.neu.his.cloud.zuul.controller.dms;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.distribution.api.pc.dms.ApiPcDmsDrugStoreDistributionService;
import com.neu.his.cloud.zuul.dto.dms.DmsRefundDrugListParam;
import com.neu.his.cloud.zuul.dto.pms.PmsDrugStorePatientListResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@Api(tags = "DmsDrugStoreDistributionController", description = "药房工作台")
@RequestMapping("/drugStore")
@CrossOrigin(allowCredentials = "true")
public class DmsDrugStoreDistributionController {

    @Autowired
    private ApiPcDmsDrugStoreDistributionService apiPcDmsDrugStoreDistributionService;

    @HystrixCommand(fallbackMethod = "listPatientFallbackInfo")
    @ApiOperation("刷新发药患者")
    @RequestMapping(value = "/listPatient", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<PmsDrugStorePatientListResult> listPatient(@RequestParam(value = "medicalRecordNo",required = false) String medicalRecordNo,
                                                                   @RequestParam("queryDate") String queryDate,
                                                                   @RequestParam("type") Integer type){
        return  apiPcDmsDrugStoreDistributionService.listPatient(medicalRecordNo,queryDate,type);
    }
    private CommonResult<PmsDrugStorePatientListResult> listPatientFallbackInfo(String medicalRecordNo, String queryDate,Integer type){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "releaseDrugFallbackInfo")
    @ApiOperation("发药")
    @RequestMapping(value = "/releaseDrug", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult releaseDrug(@RequestParam("prescriptionId") Long prescriptionId,
                                    @RequestParam("type") Integer type){
       return apiPcDmsDrugStoreDistributionService.releaseDrug(prescriptionId,type);
    }
    private CommonResult releaseDrugFallbackInfo(Long prescriptionId,Integer type){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "refundDrugFallbackInfo")
    @ApiOperation("退药")
    @RequestMapping(value = "/refundDrug", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult refundDrug(@RequestBody DmsRefundDrugListParam dmsRefundDrugListParam){
        return apiPcDmsDrugStoreDistributionService.refundDrug(dmsRefundDrugListParam);
    }
    private CommonResult refundDrugFallbackInfo(DmsRefundDrugListParam dmsRefundDrugListParam){
        return CommonResult.success(null,"请检查您的网络") ;
    }

}
