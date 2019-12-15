package com.neu.his.cloud.api.pc.controller.dms;

import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsRegistrationParam;
import com.neu.his.cloud.api.pc.service.dms.DmsRegistrationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "DmsRegistrationController", description = "挂号管理")
@RequestMapping("/registration")
@CrossOrigin(allowCredentials = "true")
public class DmsRegistrationController {

    @Autowired
    DmsRegistrationService dmsRegistrationService;

    @ApiOperation(value = "挂号")
    @RequestMapping(value = "/createRegistration", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createRegistration(@RequestBody DmsRegistrationParam dmsRegistrationParam , BindingResult result){
       return dmsRegistrationService.createRegistration(dmsRegistrationParam);

    }

}
