package com.neu.his.cloud.api.app.controller;

import com.neu.his.cloud.api.app.common.CommonResult;
import com.neu.his.cloud.api.app.dto.sms.SmsDeptResult;
import com.neu.his.cloud.api.app.service.TestFeignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: TestFeignController
 * @description: TODO
 * @author Zain
 * @date 2019/6/15 14:43
 */
@RefreshScope
@RestController
@Api(tags = "TestFeignController", description = "APP 挂号管理")
@RequestMapping("/test")
@CrossOrigin(allowCredentials = "true")
public class TestFeignController {
    @Autowired
    TestFeignService testFeignService;
//
//    @Value("${test.test}")
//    private String testMQandRefresh;

    @ApiOperation("hi")
    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String message) {
        return testFeignService.sayHi(message);
    }

//    @RequestMapping(value = "testMQ", method = RequestMethod.GET)
//    public String testMQ(@RequestParam String message) {
//        return testMQandRefresh;
//    }
    @ApiOperation("selectAllDept")
    @RequestMapping(value = "selectAllDept", method = RequestMethod.GET)
    public CommonResult<List<SmsDeptResult>> selectAllDept() {
        return testFeignService.listAll();
    }



}
