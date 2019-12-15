package com.neu.his.cloud.zuul.distribution.api.pc.dms;


import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.dto.oss.OssCallbackResult;
import com.neu.his.cloud.zuul.dto.oss.OssPolicyResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
@FeignClient(value = "his-cloud-api-pc")
public interface ApiOssServiceDistributionService {
    @RequestMapping(value = "/aliyun/oss/policy", method = RequestMethod.GET)
     CommonResult<OssPolicyResult> policy();


    @RequestMapping(value = "/aliyun/oss/callback", method = RequestMethod.POST)
     CommonResult<OssCallbackResult> callback(HttpServletRequest request);
}
