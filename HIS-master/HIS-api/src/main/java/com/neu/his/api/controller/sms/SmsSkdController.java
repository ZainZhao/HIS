package com.neu.his.api.controller.sms;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.common.api.CommonPage;
import com.neu.his.common.api.CommonResult;
import com.neu.his.common.dto.sms.*;
import com.neu.his.mbg.model.SmsSkd;
import com.neu.his.sms.SmsSkdService;
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

@Controller
@Api(tags = "SmsSkdController", description = "排班管理")
@RequestMapping("/skd")
@CrossOrigin(allowCredentials = "true")
public class SmsSkdController {

    @Autowired
    private SmsSkdService smsSkdService;

    /**
     * 描述:创建排班规则
     * <p>author: ma
     */
    @ApiOperation("新增排班规则")
    @RequestMapping(value = "/createRule", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createRule(@RequestBody SmsSkdRuleParam smsSkdRuleParam, BindingResult result){
        int count = smsSkdService.createRule(smsSkdRuleParam);
        if(count > 0){
            return CommonResult.success(count, "新增排班规则成功");
        }
        return CommonResult.failed("新增排班规则失败");
    }

    /**
     * 描述:删除排班规则
     * <p>author: ma
     */
    @ApiOperation("删除排班规则")
    @RequestMapping(value = "/deleteRule", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteRule(@RequestParam("ids") List<Long> ids){
        int count = smsSkdService.deleteRule(ids);
        if(count > 0){
            return CommonResult.success(count,"删除成功");
        }
        return CommonResult.failed("删除失败");
    }



    @ApiOperation("更新排班规则")
    @RequestMapping(value = "/updateRule/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateRule(@PathVariable Long id,@RequestBody SmsSkdRuleParam smsSkdRuleParam , BindingResult result){
        int count = smsSkdService.updateRule(id,smsSkdRuleParam);
        if(count > 0){
            return CommonResult.success(count,"更新成功");
        }
        return CommonResult.failed("更新失败");
    }

    /**
     * 描述:根据部门id筛选排版规则基本信息、分页
     * <p>author: ma
     * <p>author: 赵煜  修改查询不到科室排班规则500错误,并返回创建人name
     */
    @ApiOperation("根据部门id筛选排版规则基本信息、分页")
    @RequestMapping(value = "/listRule", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<SmsSkdRuleResult>> listRule(@RequestParam("deptId")  Long deptId,
                                                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        Page page =PageHelper.startPage(pageNum, pageSize);
        List<SmsSkdRuleResult> list = smsSkdService.selectRuleByDept(deptId);
       if( CollectionUtils.isEmpty(list)){
            return CommonResult.success(null,"不存在排班规则");
       }
        Long pageTotal=page.getTotal();
        return CommonResult.success(CommonPage.restPage(list,pageTotal));
    }

    /**
     * 描述:根据规则id查询一条规则详情
     * <p>author: ma
     */
    @ApiOperation("根据规则id查询一条规则详情")
    @RequestMapping(value = "/getRuleDetail", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<SmsSkdRuleResult> getRuleDetail(@RequestParam("ruleId") Long ruleId){
        SmsSkdRuleResult smsSkdRuleResult = smsSkdService.getRuleDetail(ruleId);
        return CommonResult.success(smsSkdRuleResult);
    }

    /**
     * 描述:根据多条排班规则生成skd
     * <p>author: ma
     */
    @ApiOperation("根据多条排班规则生成skd")
    @RequestMapping(value = "/generateSkd", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult generateSkd(@RequestParam("ruleIds") List<Long> ruleIds, @RequestParam("startDate")@DateTimeFormat(pattern = "yyyy-MM-dd")Date startDate, @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd")Date endDate){
        int count = smsSkdService.generateSkd(ruleIds,startDate,endDate);
        if(count > 0){
            return CommonResult.success(count,"生成成功");
        }
        return CommonResult.failed("生成失败");
    }

    /**
     * 描述:查找排班记录、分页
     * <p>author: ma
     */
    @ApiOperation("查找排班记录、分页")
    @RequestMapping(value = "/listSkd", method = RequestMethod.POST)
    @ResponseBody
    public  CommonResult<CommonPage<SmsSkdResult>> listSkd(SmsSkdParam queryParam,
                                                           @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        Page page =PageHelper.startPage(pageNum, pageSize);

        List<SmsSkdResult> smsSkdResultList = smsSkdService.listSkd(queryParam);
        Long pageTotal=page.getTotal();
        return CommonResult.success(CommonPage.restPage(smsSkdResultList,pageTotal));
    }

    @ApiOperation("查找排班记录、不分页")
    @RequestMapping(value = "/querySkd", method = RequestMethod.POST)
    @ResponseBody
    public  CommonResult<List<SmsSkdResult>> listSkd(SmsSkdParam queryParam){

        return CommonResult.success(smsSkdService.listSkd(queryParam));
    }


    /**
     * 描述:新增时候列出的科室下员工信息
     * <p>author:赵煜
     */
    @ApiOperation("新增时候列出的科室下员工信息")
    @RequestMapping(value = "/listCanSkdStaff/{deptId}", method = RequestMethod.POST)
    @ResponseBody
    public  CommonResult<List<SmsSkdRuleItemResult>> listCanSkdStaff(@PathVariable Long deptId){
        List<SmsSkdRuleItemResult> smsSkdResultList = smsSkdService.listCanSkdStaffByDept(deptId);
        return CommonResult.success(smsSkdResultList);
    }

}
