package com.neu.his.cloud.api.app.service;

import com.neu.his.cloud.api.app.common.CommonResult;
import com.neu.his.cloud.api.app.dto.sms.SmsDeptResult;
import com.neu.his.cloud.api.app.service.hystrix.TestFeignServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 赵煜
 * @title: TestFeignService
 * @projectName his-cloud
 * @description: TODO
 * @date 2019/6/15 14:46
 */

@FeignClient(value = "his-cloud-service-sms",fallback = TestFeignServiceHystrix.class)
public interface TestFeignService {

    @RequestMapping(value = "hi", method = RequestMethod.GET)
    String sayHi(@RequestParam(value = "message") String message);

    @RequestMapping(value = "/dept/selectAll", method = RequestMethod.GET)
    public CommonResult<List<SmsDeptResult>> listAll();
}
