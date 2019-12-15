package com.neu.his.cloud.api.pc.controller.sms;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.cloud.api.pc.common.CommonPage;
import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.sms.SmsRegistrationRankParam;
import com.neu.his.cloud.api.pc.dto.sms.SmsRegistrationRankResult;
import com.neu.his.cloud.api.pc.service.sms.SmsRegistrationRankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "SmsRegistrationRankController", description = "挂号级别管理")
@RequestMapping("/registerRank")
@CrossOrigin(allowCredentials = "true")
public class SmsRegistrationRankController {

    @Autowired
    private SmsRegistrationRankService smsRegistrationRankService;

    @ApiOperation("新增挂号级别")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody SmsRegistrationRankParam smsRegistrationRankParam, BindingResult result){
       return smsRegistrationRankService.create(smsRegistrationRankParam);
    }

    @ApiOperation("根据ids删除挂号级别")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids){
      return  smsRegistrationRankService.delete(ids);
    }


    @ApiOperation("更新挂号级别信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id, @RequestBody SmsRegistrationRankParam smsRegistrationRankParam, BindingResult result){
      return smsRegistrationRankService.update(id,smsRegistrationRankParam);
    }

    @ApiOperation("模糊查询挂号级别、且分页")
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<SmsRegistrationRankResult>> list(@RequestBody SmsRegistrationRankParam queryParam,
                                                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
       return  smsRegistrationRankService.list(queryParam,pageSize,pageNum);
    }

    @ApiOperation("查询所有挂号级别")
    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<SmsRegistrationRankResult>> listAll(){
       return smsRegistrationRankService.listAll();
    }
}
