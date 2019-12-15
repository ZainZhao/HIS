package com.neu.his.cloud.api.pc.service.sms;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.cloud.api.pc.common.CommonPage;
import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.sms.SmsSkdDocParam;
import com.neu.his.cloud.api.pc.dto.sms.SmsSkdDocResult;
import com.neu.his.cloud.api.pc.dto.sms.SmsStaffParam;
import com.neu.his.cloud.api.pc.dto.sms.SmsStaffResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "his-cloud-service-sms")
public interface SmsStaffService {



    @RequestMapping(value = "/staff/listDocBySkd", method = RequestMethod.POST)
    CommonResult<List<SmsSkdDocResult>> listDocBySkd(@RequestBody SmsSkdDocParam smsSkdDocPara);



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
