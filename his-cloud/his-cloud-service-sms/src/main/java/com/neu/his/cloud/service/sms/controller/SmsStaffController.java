package com.neu.his.cloud.service.sms.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.cloud.service.sms.common.CommonPage;
import com.neu.his.cloud.service.sms.common.CommonResult;
import com.neu.his.cloud.service.sms.dto.sms.*;
import com.neu.his.cloud.service.sms.model.SmsStaff;
import com.neu.his.cloud.service.sms.service.SmsSkdService;
import com.neu.his.cloud.service.sms.service.SmsStaffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "SmsStaffController", description = "用户管理")
@RequestMapping("/staff")
@CrossOrigin(allowCredentials = "true")
public class SmsStaffController {

    @Autowired
    private SmsStaffService smsStaffService;
//    @Value("${jwt.tokenHeader}")  //自动装载jwt
//    private String tokenHeader;
//    @Value("${jwt.tokenHead}")
//    private String tokenHead;
    @Autowired
    private SmsSkdService smsSkdService;

    //查询上班医生
    //1.调用SmsSkdService的listDocBySkd
    @ApiOperation(value = "查询上班医生")
    @RequestMapping(value = "/listDocBySkd", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<SmsSkdDocResult>> listDocBySkd(@RequestBody SmsSkdDocParam smsSkdDocParam, BindingResult result){
        List<SmsSkdDocResult> smsSkdDocResultList;
        smsSkdDocResultList = smsSkdService.listDocBySkd(smsSkdDocParam);
        return CommonResult.success(smsSkdDocResultList);
    }


//    /**
//     * 描述:新增一个用户
//     * <p>author:赵煜
//     */
//    @ApiOperation("新增一个用户（调用注册接口）")
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    @ResponseBody
//    public CommonResult create(@RequestBody SmsStaffParam smsStaffParam, BindingResult result){
//        SmsStaff smsStaff= smsStaffService.register(smsStaffParam);
//
//        return CommonResult.success(smsStaff);
//    }

    /**
     * 描述:根据ids删除用户
     * <p>author: ma
     */
    @ApiOperation("根据ids删除用户")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = smsStaffService.delete(ids);
        if(count > 0){
            return CommonResult.success(count,"删除成功");
        }
        return CommonResult.failed("删除失败");
    }

    /**
     * 描述:更新一个用户的全部信息
     * <p>author: ma
     */
    @ApiOperation("更新一个用户的全部信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody SmsStaffParam smsStaffParam, BindingResult result){
        int count = smsStaffService.update(id,smsStaffParam);
        if(id > 0){
            return CommonResult.success(count,"更新成功");
        }
        return CommonResult.failed("更新失败");
    }

    /**
     * 描述:模糊查询用户、且分页
     * <p>author: ma
     */
    @ApiOperation("模糊查询用户、且分页")
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<SmsStaffResult>> list(@RequestBody SmsStaffParam queryParam,
                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        Page page =PageHelper.startPage(pageNum, pageSize);
        List<SmsStaffResult> list = smsStaffService.select(queryParam,pageSize,pageNum);
        Long pageTotal=page.getTotal();
        return CommonResult.success(CommonPage.restPage(list,pageTotal));
    }

    /**
     * 描述:查询所有用户
     * <p>author: ma
     */
    @ApiOperation("查询所有用户")
    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<SmsStaffResult>> listAll(){
        List<SmsStaffResult> list = smsStaffService.selectAll();
        return CommonResult.success(list);
    }


//    /**
//     * 描述:登录
//     * <p>author: 赵煜
//     */
//    @ApiOperation(value = "登录以后返回token")
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    @ResponseBody
//    public CommonResult login(@RequestBody SmsStaffLoginParam smsStaffLoginParam, BindingResult result) {
//        String token = smsStaffService.login(smsStaffLoginParam.getUsername(), smsStaffLoginParam.getPassword());
//        if (token == null) {
//            return CommonResult.validateFailed("用户名或密码错误");
//        }
//        //如果 token不等于 null
//        Map<String, String> tokenMap = new HashMap<>();
//        tokenMap.put("token", token);
//        tokenMap.put("tokenHead", tokenHead);
//        return CommonResult.success(tokenMap); //为什么要用HashMap进行返回，难道是为了减少实体类？
//    }

//    /**
//     * 描述:登录
//     * <p>author: 赵煜
//     *
//     */
//    @ApiOperation(value = "登录以后返回token")
//    @RequestMapping(value = "/getStaffByPwd", method = RequestMethod.POST)
//    @ResponseBody
//    public CommonResult getStaffByPwd(@RequestBody SmsStaffLoginParam smsStaffLoginParam, BindingResult result) {
//        SmsStaff smsStaff = smsStaffService.getStaffByPwd(smsStaffLoginParam.getUsername(), smsStaffLoginParam.getPassword());
//        if (smsStaff == null) {
//            return CommonResult.validateFailed("用户名或密码错误");
//        }
//        return CommonResult.success(smsStaff);
//    }


//    @ApiOperation(value = "获取当前登录用户信息")
//    @RequestMapping(value = "/info", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonResult getAdminInfo(Principal principal) {
//        String username = principal.getName();
//        SmsStaff smsStaff = smsStaffService.selectByUserName(username);
//        Map<String, Object> data = new HashMap<>();
//        data.put("username", smsStaff.getUsername());
//        data.put("id", smsStaff.getId());
//        data.put("name", smsStaff.getName());
//        data.put("deptId", smsStaff.getDeptId());
//        return CommonResult.success(data);
//    }

}
