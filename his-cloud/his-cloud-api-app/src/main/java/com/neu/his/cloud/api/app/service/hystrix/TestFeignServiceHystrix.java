package com.neu.his.cloud.api.app.service.hystrix;

import com.neu.his.cloud.api.app.common.CommonResult;
import com.neu.his.cloud.api.app.dto.sms.SmsDeptResult;
import com.neu.his.cloud.api.app.service.TestFeignService;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class TestFeignServiceHystrix implements TestFeignService {


    @Override
    public String sayHi(String message) {
        return "Hi，your message is :\"" + message + "\" but request error.";
    }

    @Override
    public CommonResult<List<SmsDeptResult>> listAll() {
        return CommonResult.failed("listAll失败");
    }
}
