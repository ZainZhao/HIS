package com.neu.his.api.controller.dms;

import com.neu.his.common.api.CommonResult;
import com.neu.his.common.dto.dms.DmsRegistrationParam;
import com.neu.his.common.dto.pms.PmsPatientResult;
import com.neu.his.common.dto.sms.SmsSkdDocParam;
import com.neu.his.common.dto.sms.SmsSkdDocResult;
import com.neu.his.dms.service.DmsRegistrationService;
import com.neu.his.pms.service.PmsPatientService;

import com.neu.his.sms.SmsSkdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "DmsRegistrationController", description = "挂号管理")
@RequestMapping("/registration")
@CrossOrigin(allowCredentials = "true")
public class DmsRegistrationController {

    @Autowired
    DmsRegistrationService dmsRegistrationService;



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

}
