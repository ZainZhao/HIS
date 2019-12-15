package com.neu.his.cloud.zuul.controller.dms;




import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.distribution.api.pc.dms.ApiPcDmsRedisSaveDistributionService;
import com.neu.his.cloud.zuul.dto.dms.DmsCaseHistoryParam;
import com.neu.his.cloud.zuul.dto.dms.DmsDrugRedisParam;
import com.neu.his.cloud.zuul.dto.dms.DmsNonDrugRedisParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "DmsRedisSaveController", description = "redis暂存管理")
@RequestMapping("/redisSave")
@CrossOrigin(allowCredentials = "true")
public class DmsRedisSaveDistributionController {

    @Autowired
    ApiPcDmsRedisSaveDistributionService apiPcDmsRedisSaveDistributionService;

    @HystrixCommand(fallbackMethod = "saveCasePageFallbackInfo")
    @ApiOperation(value = "暂存病历首页（根据挂号号）")
    @RequestMapping(value = "/saveCasePage", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult saveCasePage(@RequestBody DmsCaseHistoryParam dmsCaseHistoryParam,
                                     @RequestParam("registrationId") Long registrationId){

        return apiPcDmsRedisSaveDistributionService.saveCasePage(dmsCaseHistoryParam,registrationId);
    }
    private CommonResult saveCasePageFallbackInfo(DmsCaseHistoryParam dmsCaseHistoryParam, Long registrationId){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "getCasePageFallbackInfo")
    @ApiOperation(value = "取出病历首页（根据挂号号）")
    @RequestMapping(value = "/getCasePage", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<DmsCaseHistoryParam> getCasePage(@RequestParam("registrationId") Long registrationId){

        return apiPcDmsRedisSaveDistributionService.getCasePage(registrationId);
    }
    private CommonResult<DmsCaseHistoryParam> getCasePageFallbackInfo(Long registrationId){
        return CommonResult.success(null,"请检查您的网络") ;
    }


    @HystrixCommand(fallbackMethod = "saveDrugPrescriptionFallbackInfo")
    @ApiOperation(value = "暂存药方（根据挂号号和类型（4成药、5草药））")
    @RequestMapping(value = "/saveDrugPrescription", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult saveDrugPrescription(@RequestBody List<DmsDrugRedisParam> dmsDrugRedisParam,
                                             @RequestParam("registrationId") Long registrationId,
                                             @RequestParam("type") int type){
        return apiPcDmsRedisSaveDistributionService.saveDrugPrescription(dmsDrugRedisParam,registrationId,type);
    }
    private CommonResult saveDrugPrescriptionFallbackInfo( List<DmsDrugRedisParam> dmsDrugRedisParam, Long registrationId,int type){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "getDrugPrescriptionFallbackInfo")
    @ApiOperation(value = "取出药方（根据挂号号和类型（4成药、5草药））")
    @RequestMapping(value = "/getDrugPrescription", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsDrugRedisParam>> getDrugPrescription(@RequestParam("registrationId") Long registrationId,
                                                                     @RequestParam("type") int type){
        return apiPcDmsRedisSaveDistributionService.getDrugPrescription(registrationId,type);
    }
    private CommonResult<List<DmsDrugRedisParam>> getDrugPrescriptionFallbackInfo(Long registrationId, int type){
        return CommonResult.success(null,"请检查您的网络") ;
    }


    @HystrixCommand(fallbackMethod = "saveNonDrugFallbackInfo")
    @ApiOperation(value = "暂存开立非药品项目（根据挂号号和类型（0检查、1检验、2处置））")
    @RequestMapping(value = "/saveNonDrug", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult saveNonDrug(@RequestBody DmsNonDrugRedisParam dmsNonDrugRedisParam,
                                    @RequestParam("registrationId") Long registrationId,
                                    @RequestParam("type") int type){
        return apiPcDmsRedisSaveDistributionService.saveNonDrug(dmsNonDrugRedisParam,registrationId,type);
    }
    private CommonResult saveNonDrugFallbackInfo(DmsNonDrugRedisParam dmsNonDrugRedisParam,Long registrationId,int type){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "getNonDrugFallbackInfo")
    @ApiOperation(value = "取出开立非药品项目（根据挂号号和类型（0检查、1检验、2处置））")
    @RequestMapping(value = "/getNonDrug", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<DmsNonDrugRedisParam> getNonDrug(@RequestParam("registrationId") Long registrationId,
                                                           @RequestParam("type") int type){
        return apiPcDmsRedisSaveDistributionService.getNonDrug(registrationId,type);
    }
    private CommonResult<DmsNonDrugRedisParam> getNonDrugFallbackInfo( Long registrationId,int type){
        return CommonResult.success(null,"请检查您的网络") ;
    }
}
