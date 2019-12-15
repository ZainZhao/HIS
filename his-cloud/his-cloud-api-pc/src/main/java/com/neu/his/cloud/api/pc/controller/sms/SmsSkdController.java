package com.neu.his.cloud.api.pc.controller.sms;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.cloud.api.pc.common.CommonPage;
import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.sms.*;
import com.neu.his.cloud.api.pc.service.sms.SmsSkdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Api(tags = "SmsSkdController", description = "排班管理")
@RequestMapping("/skd")
@CrossOrigin(allowCredentials = "true")
public class SmsSkdController {

    @Autowired
    private SmsSkdService smsSkdService;


    @ApiOperation("新增排班规则")
    @RequestMapping(value = "/createRule", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createRule(@RequestBody SmsSkdRuleParam smsSkdRuleParam, BindingResult result){
       return smsSkdService.createRule(smsSkdRuleParam);
    }


    @ApiOperation("删除排班规则")
    @RequestMapping(value = "/deleteRule", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteRule(@RequestParam("ids") List<Long> ids){
        return smsSkdService.deleteRule(ids);
    }



    @ApiOperation("更新排班规则")
    @RequestMapping(value = "/updateRule/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateRule(@PathVariable Long id, @RequestBody SmsSkdRuleParam smsSkdRuleParam , BindingResult result){
     return  smsSkdService.updateRule(id,smsSkdRuleParam);
    }


    @ApiOperation("根据部门id筛选排版规则基本信息、分页")
    @RequestMapping(value = "/listRule", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<SmsSkdRuleResult>> listRule(@RequestParam("deptId")  Long deptId,
                                                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){



     return smsSkdService.listRule(deptId,pageSize,pageNum);

    }


    @ApiOperation("根据规则id查询一条规则详情")
    @RequestMapping(value = "/getRuleDetail", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<SmsSkdRuleResult> getRuleDetail(@RequestParam("ruleId") Long ruleId){
       return smsSkdService.getRuleDetail(ruleId);
    }


    @ApiOperation("根据多条排班规则生成skd")
    @RequestMapping(value = "/generateSkd", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult generateSkd(@RequestParam("ruleIds") List<Long> ruleIds, @RequestParam("startDate")String startDate, @RequestParam("endDate") String endDate){
        System.err.println("startDate:"+startDate);
        System.err.println("endDate:"+endDate);

        return smsSkdService.generateSkd(ruleIds,startDate,endDate);
    }


    @ApiOperation("查找排班记录、分页")
    @RequestMapping(value = "/listSkd", method = RequestMethod.POST)
    @ResponseBody
    public  CommonResult<CommonPage<SmsSkdResult>> listSkd(@RequestBody SmsSkdParam queryParam,
                                                           @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){

        return smsSkdService.listSkd(queryParam,pageSize,pageNum);
    }


    @ApiOperation("新增时候列出的科室下员工信息")
    @RequestMapping(value = "/listCanSkdStaff/{deptId}", method = RequestMethod.POST)
    @ResponseBody
    public  CommonResult<List<SmsSkdRuleItemResult>> listCanSkdStaff(@PathVariable Long deptId){
       return smsSkdService.listCanSkdStaff(deptId);

    }

}
