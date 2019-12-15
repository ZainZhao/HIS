package com.neu.his.cloud.api.pc.service.sms;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.cloud.api.pc.common.CommonPage;
import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.sms.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@FeignClient(value = "his-cloud-service-sms")
public interface SmsSkdService {

    @RequestMapping(value = "/skd/createRule", method = RequestMethod.POST)
    CommonResult createRule(@RequestBody SmsSkdRuleParam smsSkdRuleParam);


    @RequestMapping(value = "/skd/deleteRule", method = RequestMethod.POST)
    CommonResult deleteRule(@RequestParam("ids") List<Long> ids);



    @RequestMapping(value = "/skd/updateRule/{id}", method = RequestMethod.POST)
    CommonResult updateRule(@PathVariable Long id,@RequestBody SmsSkdRuleParam smsSkdRuleParam );


    @RequestMapping(value = "/skd/listRule", method = RequestMethod.POST)
    CommonResult<CommonPage<SmsSkdRuleResult>> listRule(@RequestParam("deptId")  Long deptId,
                                                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum);

    @RequestMapping(value = "/skd/getRuleDetail", method = RequestMethod.POST)
    CommonResult<SmsSkdRuleResult> getRuleDetail(@RequestParam("ruleId") Long ruleId);


    @RequestMapping(value = "/skd/generateSkd", method = RequestMethod.POST)
    CommonResult generateSkd(@RequestParam("ruleIds") List<Long> ruleIds, @RequestParam("startDate")String startDate, @RequestParam("endDate") String endDate);


    @RequestMapping(value = "/skd/listSkd", method = RequestMethod.POST)
    CommonResult<CommonPage<SmsSkdResult>> listSkd(@RequestBody SmsSkdParam queryParam,
                                                           @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum);


    @RequestMapping(value = "/skd/listDocBySkd", method = RequestMethod.POST)
    CommonResult<List<SmsSkdDocResult>> listDocBySkd(@RequestBody SmsSkdDocParam smsSkdDocParam);

    @RequestMapping(value = "/skd/listCanSkdStaff/{deptId}", method = RequestMethod.POST)
    CommonResult<List<SmsSkdRuleItemResult>> listCanSkdStaff(@PathVariable Long deptId);
}
