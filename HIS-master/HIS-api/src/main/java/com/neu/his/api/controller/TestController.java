package com.neu.his.api.controller;

import com.neu.his.common.api.CommonResult;
import com.neu.his.common.dto.sms.SmsDeptParam;
import com.neu.his.sms.SmsRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
@CrossOrigin(allowCredentials = "true")
public class TestController {

    @Autowired
    SmsRoleService smsRoleService;

    @ApiOperation("热部署测试")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public  String list(){
        return "dev hot";
    }

//    public CommonResult create(@RequestBody SmsDeptParam smsDeptParam, BindingResult result){
//
//    }


}
