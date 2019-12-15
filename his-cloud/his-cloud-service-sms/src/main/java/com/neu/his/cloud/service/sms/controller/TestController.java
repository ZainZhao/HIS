package com.neu.his.cloud.service.sms.controller;

import com.neu.his.cloud.service.sms.service.SmsDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SmsSkdController", description = "排班管理")
@RequestMapping("/skd")
@RestController
public class TestController {
    @Value("${server.port}")
    private String port;

    @Autowired
    private SmsDeptService smsDeptService;
    @ApiOperation("sayHI")
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    @ResponseBody
    public String sayHi(@RequestParam(value = "message") String message) {
        return String.format("Hi，your message is : %s i am from port : %s", message, port);
    }

//    @ApiOperation("科室查询测试")
//    @RequestMapping(value = "selectDept", method = RequestMethod.GET)
//    @ResponseBody
//    public List<SmsDeptResult> selectDept(@RequestParam(value = "message") String  test) {
//        SmsDeptParam smsDeptParam=new SmsDeptParam();
//        smsDeptParam.setCode("zk");
//        return smsDeptService.select(smsDeptParam,3,4);
//    }
}
