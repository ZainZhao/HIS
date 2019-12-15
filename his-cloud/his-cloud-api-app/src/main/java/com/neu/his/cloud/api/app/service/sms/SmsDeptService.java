package com.neu.his.cloud.api.app.service.sms;

import com.neu.his.cloud.api.app.common.CommonResult;
import com.neu.his.cloud.api.app.dto.sms.SmsDeptResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient(value = "his-cloud-service-sms")
public interface SmsDeptService {



    @RequestMapping(value = "/dept/selectAll", method = RequestMethod.GET)
    CommonResult<List<SmsDeptResult>> listAll();

}
