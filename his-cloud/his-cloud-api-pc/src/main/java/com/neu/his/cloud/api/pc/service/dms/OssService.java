package com.neu.his.cloud.api.pc.service.dms;

import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.oss.OssCallbackResult;
import com.neu.his.cloud.api.pc.dto.oss.OssPolicyResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@FeignClient(value = "his-cloud-service-dms")
public interface OssService {

    @RequestMapping(value = "/aliyun/oss/policy", method = RequestMethod.GET)
    public CommonResult<OssPolicyResult> policy();


    @RequestMapping(value = "/aliyun/oss/callback", method = RequestMethod.POST)
    public CommonResult<OssCallbackResult> callback(HttpServletRequest request);
}
