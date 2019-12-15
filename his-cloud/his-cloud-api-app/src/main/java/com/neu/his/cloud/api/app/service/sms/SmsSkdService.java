package com.neu.his.cloud.api.app.service.sms;


import com.neu.his.cloud.api.app.common.CommonResult;
import com.neu.his.cloud.api.app.dto.sms.SmsSkdParam;
import com.neu.his.cloud.api.app.dto.sms.SmsSkdResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "his-cloud-service-sms")
public interface SmsSkdService {

    @RequestMapping(value = "/skd/querySkd", method = RequestMethod.POST)
    CommonResult<List<SmsSkdResult>> listSkd(SmsSkdParam queryParam);

}
