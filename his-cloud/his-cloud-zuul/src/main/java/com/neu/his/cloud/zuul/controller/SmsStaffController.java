package com.neu.his.cloud.zuul.controller;


import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.dto.sms.SmsStaffLoginParam;
import com.neu.his.cloud.zuul.dto.sms.SmsStaffParam;
import com.neu.his.cloud.zuul.model.SmsStaff;
import com.neu.his.cloud.zuul.service.sms.SmsStaffService;

import com.neu.his.cloud.zuul.service.tms.TestFeignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Controller
@Api(tags = "SmsStaffController", description = "用户管理")
@RequestMapping("/staff")
@CrossOrigin(allowCredentials = "true")
public class SmsStaffController {

    @Autowired
    private SmsStaffService smsStaffService;

    @Autowired
    private TestFeignService testFeignService;

    @Value("${jwt.tokenHeader}")  //自动装载jwt
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;


    /**
     * 描述:登录
     * <p>author: 赵煜
     */
    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody SmsStaffLoginParam smsStaffLoginParam, BindingResult result) {
        String token = smsStaffService.login(smsStaffLoginParam.getUsername(), smsStaffLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        //如果 token不等于 null
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap); //为什么要用HashMap进行返回，难道是为了减少实体类？
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAdminInfo(Principal principal) {
        String username = principal.getName();
        SmsStaff smsStaff = smsStaffService.selectByUserName(username);
        Map<String, Object> data = new HashMap<>();
        data.put("username", smsStaff.getUsername());
        data.put("id", smsStaff.getId());
        data.put("name", smsStaff.getName());
        data.put("deptId", smsStaff.getDeptId());
        data.put("roleId",smsStaff.getRoleId());
        return CommonResult.success(data);
    }

    /**
     * 描述:新增一个用户
     * <p>author:赵煜
     */
    @ApiOperation("新增用户（调用注册接口）")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody SmsStaffParam smsStaffParam, BindingResult result){
        SmsStaff smsStaff= smsStaffService.register(smsStaffParam);

        return CommonResult.success(smsStaff);
    }


//
//    /**
//     * 描述:登录
//     * <p>author: 赵煜
//     */
//    @ApiOperation(value = "test")
//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    @ResponseBody
//    @PreAuthorize("hasAuthority('dept:zzz')")
//    public CommonResult test() {
//        return CommonResult.success("success");
//    }


//    /**
//     * 描述:登录
//     * <p>author: 赵煜
//     */
//    @ApiOperation(value = "testHi")
//    @RequestMapping(value = "/testHi", method = RequestMethod.GET)
//    @ResponseBody
////    @PreAuthorize("hasAuthority('dept:create')")
//    public CommonResult testHi(@RequestParam("message") String message) {
//        return CommonResult.success(testFeignService.hiTest(message));
//    }


}
