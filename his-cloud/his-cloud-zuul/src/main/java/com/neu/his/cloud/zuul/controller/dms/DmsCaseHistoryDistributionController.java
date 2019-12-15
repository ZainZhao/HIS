package com.neu.his.cloud.zuul.controller.dms;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.distribution.api.pc.dms.ApiPcDmsCaseHistoryDistributionService;
import com.neu.his.cloud.zuul.dto.dms.DmsCaseHistoryParam;
import com.neu.his.cloud.zuul.dto.dms.DmsCaseHistoryResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "DmsCaseHistoryDistributionController", description = "病历管理")
@RequestMapping("/caseHistory")
@CrossOrigin(allowCredentials = "true")
public class DmsCaseHistoryDistributionController {
    @Autowired
    ApiPcDmsCaseHistoryDistributionService apiPcDmsCaseHistoryDistributionService;

    @HystrixCommand(fallbackMethod = "submitPriliminaryDiseFallbackInfo")
    @ApiOperation(value = "提交初诊信息")
    @RequestMapping(value = "/submitPriliminaryDise", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult submitPriliminaryDise(DmsCaseHistoryParam dmsCaseHistoryParam){
       return apiPcDmsCaseHistoryDistributionService.submitPriliminaryDise(dmsCaseHistoryParam);
    }

    private CommonResult submitPriliminaryDiseFallbackInfo(DmsCaseHistoryParam dmsCaseHistoryParam){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "selectNotEndCaseHistoryByRegFallbackInfo")
    @ApiOperation(value = "根据挂号Id查询未结束就诊的历史病历（只含有初诊信息）")
    @RequestMapping(value = "/selectNotEndCaseHistoryByReg/{registrationId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<DmsCaseHistoryResult> selectNotEndCaseHistoryByReg(@PathVariable("registrationId") Long registrationId){
        return apiPcDmsCaseHistoryDistributionService.selectNotEndCaseHistoryByReg(registrationId);
    }
    private CommonResult<DmsCaseHistoryResult> selectNotEndCaseHistoryByRegFallbackInfo(Long registrationId){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "selectEndCaseHistoryByRegFallbackInfo")
    @ApiOperation(value = "根据挂号id查询已结束就诊的历史病历（病历首页显示各种串）")
    @RequestMapping(value = "/selectEndCaseHistoryByReg/{registrationId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<DmsCaseHistoryResult> selectEndCaseHistoryByReg(@PathVariable("registrationId") Long registrationId){

        return apiPcDmsCaseHistoryDistributionService.selectEndCaseHistoryByReg(registrationId);
    }
    private CommonResult<DmsCaseHistoryResult> selectEndCaseHistoryByRegFallbackInfo(Long registrationId){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "submitDefiniteDiseFallbackInfo")
    @ApiOperation(value = "确诊")
    @RequestMapping(value = "/submitDefiniteDise", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult submitDefiniteDise( DmsCaseHistoryParam dmsCaseHistoryParam){

       return  apiPcDmsCaseHistoryDistributionService.submitDefiniteDise(dmsCaseHistoryParam);
    }
    private CommonResult submitDefiniteDiseFallbackInfo(DmsCaseHistoryParam dmsCaseHistoryParam){
        return CommonResult.success(null,"请检查您的网络") ;
    }


    @HystrixCommand(fallbackMethod = "endDiagnosisFallbackInfo")
    @ApiOperation(value = "诊毕")
    @RequestMapping(value = "/endDiagnosis", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult endDiagnosis(DmsCaseHistoryParam dmsCaseHistoryParam){
        return apiPcDmsCaseHistoryDistributionService.endDiagnosis(dmsCaseHistoryParam);
    }
    private CommonResult endDiagnosisFallbackInfo(DmsCaseHistoryParam dmsCaseHistoryParam){
        return CommonResult.success(null,"请检查您的网络") ;
    }
}
