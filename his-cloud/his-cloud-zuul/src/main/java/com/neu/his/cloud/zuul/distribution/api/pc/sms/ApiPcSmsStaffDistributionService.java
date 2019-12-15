package com.neu.his.cloud.zuul.distribution.api.pc.sms;

import com.neu.his.cloud.zuul.common.CommonPage;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.dto.sms.SmsSkdDocParam;
import com.neu.his.cloud.zuul.dto.sms.SmsSkdDocResult;
import com.neu.his.cloud.zuul.dto.sms.SmsStaffParam;
import com.neu.his.cloud.zuul.dto.sms.SmsStaffResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "his-cloud-api-pc")
public interface ApiPcSmsStaffDistributionService {


    @RequestMapping(value = "/staff/listDocBySkd", method = RequestMethod.POST)
    CommonResult<List<SmsSkdDocResult>> listDocBySkd(@RequestBody SmsSkdDocParam smsSkdDocParam);

    @RequestMapping(value = "/staff/delete", method = RequestMethod.POST)
    CommonResult delete(@RequestParam("ids") List<Long> ids);


    @RequestMapping(value = "/staff/update/{id}", method = RequestMethod.POST)
    CommonResult update(@PathVariable Long id, @RequestBody SmsStaffParam smsStaffParam);


    @RequestMapping(value = "/staff/select", method = RequestMethod.POST)
    CommonResult<CommonPage<SmsStaffResult>> list(@RequestBody SmsStaffParam queryParam,
                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum);

    @RequestMapping(value = "/staff/selectAll", method = RequestMethod.GET)
    CommonResult<List<SmsStaffResult>> listAll();

}
