package com.neu.his.cloud.zuul.controller.dms;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.distribution.api.pc.dms.ApiOssServiceDistributionService;
import com.neu.his.cloud.zuul.dto.oss.OssCallbackResult;
import com.neu.his.cloud.zuul.dto.oss.OssPolicyResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Oss相关操作接口
 */
@RestController
@Api(tags = "OssController", description = "Oss管理")
@RequestMapping("/aliyun/oss")
public class OssDistributionController {
    @Autowired
    private ApiOssServiceDistributionService apiOssServiceDistributionService;

    @HystrixCommand(fallbackMethod = "policyFallbackInfo")
    @ApiOperation(value = "oss上传签名生成")
    @RequestMapping(value = "/policy", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<OssPolicyResult> policy() {
        return apiOssServiceDistributionService.policy();
    }
    private CommonResult<OssPolicyResult> policyFallbackInfo() {
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @ApiOperation(value = "oss上传成功回调")
    @RequestMapping(value = "/callback", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<OssCallbackResult> callback(HttpServletRequest request) {
        return apiOssServiceDistributionService.callback(request);
    }
}
