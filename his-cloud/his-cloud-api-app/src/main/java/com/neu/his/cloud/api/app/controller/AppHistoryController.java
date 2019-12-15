package com.neu.his.cloud.api.app.controller;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.api.app.common.CommonResult;
import com.neu.his.cloud.api.app.dto.app.AppCheckTestResult;
import com.neu.his.cloud.api.app.dto.app.AppDeptDescriptionResult;
import com.neu.his.cloud.api.app.dto.app.AppDrugItemResult;
import com.neu.his.cloud.api.app.dto.app.AppHistoryRegResult;
import com.neu.his.cloud.api.app.dto.dms.DmsRegHistoryResult;
import com.neu.his.cloud.api.app.service.bms.BmsFeeQueryService;
import com.neu.his.cloud.api.app.service.dms.DmsNonDrugItemRecordService;
import com.neu.his.cloud.api.app.service.dms.DmsRegistrationService;
import com.neu.his.cloud.api.app.service.sms.SmsDescriptionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@Api(tags = "AppHistoryController", description = "APP 挂号历史信息管理")
@RequestMapping("/appRegHistory")
//@CrossOrigin(allowCredentials = "true")
public class AppHistoryController {

    @Autowired
    private DmsRegistrationService dmsRegistrationService;

    @Autowired
    private BmsFeeQueryService bmsFeeQueryService;

    @Autowired
    private DmsNonDrugItemRecordService dmsNonDrugItemRecordService;

    @Autowired
    private SmsDescriptionService smsDescriptionService;


    @HystrixCommand(fallbackMethod = "listAllRegistrationFallbackInfo")
    @ApiOperation("查询历史挂号信息")
    @RequestMapping(value = "/listAllRegistration", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsRegHistoryResult>> listAllRegistration(@RequestParam("identificationNo") String identificationNo){
        return  dmsRegistrationService.listAllRegistration(identificationNo);
    }
    private CommonResult<List<DmsRegHistoryResult>> listAllRegistrationFallbackInfo( String identificationNo){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listFeeFallbackInfo")
    @ApiOperation("查询某次挂号费用（大项）")
    @RequestMapping(value = "/listFee", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<AppHistoryRegResult>> listFee(@RequestParam("registrationId") Long registrationId){
        return bmsFeeQueryService.listFee(registrationId);
    }
    private CommonResult<List<AppHistoryRegResult>> listFeeFallbackInfo(Long registrationId){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listFeeDetailFallbackInfo")
    @ApiOperation("查询某次挂号费用（小项）")
    @RequestMapping(value = "/listDetail", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<AppDrugItemResult>> listFeeDetail(@RequestParam("prescriptionId") Long prescriptionId ,
                                                               @RequestParam("type") int type){
       return bmsFeeQueryService.listFeeDetail(prescriptionId,type);
    }
    private CommonResult<List<AppDrugItemResult>> listFeeDetailFallbackInfo(Long prescriptionId ,int type){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "getResultFallbackInfo")
    @ApiOperation("查询检查检验结果")
    @RequestMapping(value = "/getResult", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<AppCheckTestResult> getResult(@RequestParam("id") Long id){
       return dmsNonDrugItemRecordService.getResult(id);
    }
    private CommonResult<AppCheckTestResult> getResultFallbackInfo(Long id){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "getDeptDescriptionFallbackInfo")
    @ApiOperation("查询所有科室描述")
    @RequestMapping(value = "/getDeptDescription", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<AppDeptDescriptionResult>> getDeptDescription(){
        return smsDescriptionService.getDeptDescription();
    }
    private CommonResult<List<AppDeptDescriptionResult>> getDeptDescriptionFallbackInfo(){
        return CommonResult.success(null,"请检查您的网络") ;
    }

}
