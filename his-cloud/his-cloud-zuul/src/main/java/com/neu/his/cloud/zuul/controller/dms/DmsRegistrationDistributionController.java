package com.neu.his.cloud.zuul.controller.dms;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.distribution.api.pc.dms.ApiPcDmsRegistrationDistributionService;
import com.neu.his.cloud.zuul.dto.dms.DmsRegistrationParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "DmsRegistrationDistributionController", description = "挂号管理")
@RequestMapping("/registration")
@CrossOrigin(allowCredentials = "true")
public class DmsRegistrationDistributionController {

    @Autowired
    ApiPcDmsRegistrationDistributionService apiPcDmsRegistrationDistributionService;

    @HystrixCommand(fallbackMethod = "createRegistrationFallbackInfo")
    @ApiOperation(value = "挂号")
    @RequestMapping(value = "/createRegistration", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createRegistration(@RequestBody DmsRegistrationParam dmsRegistrationParam , BindingResult result){
       return apiPcDmsRegistrationDistributionService.createRegistration(dmsRegistrationParam);

    }
    private CommonResult createRegistrationFallbackInfo( DmsRegistrationParam dmsRegistrationParam , BindingResult result){
        return CommonResult.success(null,"请检查您的网络") ;
    }
}
