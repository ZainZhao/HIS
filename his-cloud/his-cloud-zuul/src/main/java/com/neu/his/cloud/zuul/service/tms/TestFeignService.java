package com.neu.his.cloud.zuul.service.tms;


import com.neu.his.cloud.zuul.dto.sms.SmsDeptResult;
import com.neu.his.cloud.zuul.service.tms.hystrix.TestFeignServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
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
    public String hiTest(@RequestParam(value = "message") String message);

    @RequestMapping(value = "selectDept", method = RequestMethod.GET)
    public List<SmsDeptResult> selectDept(@RequestParam(value = "message") String message);
}
