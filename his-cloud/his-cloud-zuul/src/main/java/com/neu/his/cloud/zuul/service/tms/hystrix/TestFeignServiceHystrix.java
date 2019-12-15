package com.neu.his.cloud.zuul.service.tms.hystrix;


import com.neu.his.cloud.zuul.dto.sms.SmsDeptResult;
import com.neu.his.cloud.zuul.service.tms.TestFeignService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: TestFeignServiceHystrix
 * @description: TODO
 * @author 赵煜
 * @date 2019/6/15 15:16
 */
@Component
public class TestFeignServiceHystrix implements TestFeignService {


    @Override
    public String hiTest(String message) {
        return "Hi，your message is :\"" + message + "\" but request error.";
    }

    @Override
    public List<SmsDeptResult> selectDept(String message) {
        return null;
    }
}
