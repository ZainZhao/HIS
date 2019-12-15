package com.neu.his.cloud.service.dms.controller;

import com.neu.his.cloud.service.dms.common.CommonResult;
import com.neu.his.cloud.service.dms.dto.app.AppRegistrationParam;
import com.neu.his.cloud.service.dms.dto.dms.DmsRegHistoryResult;
import com.neu.his.cloud.service.dms.dto.dms.DmsRegistrationParam;
import com.neu.his.cloud.service.dms.service.DmsRegistrationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "DmsRegistrationController", description = "挂号信息管理")
@RequestMapping("/registration")
@CrossOrigin(allowCredentials = "true")
public class DmsRegistrationController {

    @Autowired
    DmsRegistrationService dmsRegistrationService;


    @ApiOperation("查询历史挂号信息")
    @RequestMapping(value = "/listAllRegistration", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsRegHistoryResult>> listAllRegistration(@RequestParam("identificationNo") String identificationNo){
        List<DmsRegHistoryResult> list = dmsRegistrationService.listRegHistory(identificationNo);
        return CommonResult.success(list);
    }



    //挂号
    //1.调用DmsRegistrationService的createRegistration
    @ApiOperation(value = "挂号")
    @RequestMapping(value = "/createRegistration", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createRegistration(@RequestBody DmsRegistrationParam dmsRegistrationParam , BindingResult result){
        int returnResult = dmsRegistrationService.createRegistration(dmsRegistrationParam);
        if (returnResult == 1){
            return CommonResult.success(returnResult);
        }
        else{
            return CommonResult.failed();
        }
    }


    @ApiOperation("挂号")
    @RequestMapping(value = "/appReg", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult registration(@RequestBody AppRegistrationParam appRegistrationParam, BindingResult result){
        System.err.println(appRegistrationParam.toString());
        int count = dmsRegistrationService.appRegistration(appRegistrationParam);
        if(count > 0){
            return CommonResult.success(count, "挂号成功");
        }
        return CommonResult.failed("挂号失败");
    }


}
