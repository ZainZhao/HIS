package com.neu.his.cloud.service.sms.controller;

import com.neu.his.cloud.service.sms.common.CommonResult;
import com.neu.his.cloud.service.sms.dto.app.AppDeptDescriptionResult;
import com.neu.his.cloud.service.sms.dto.app.AppDocSkdResult;
import com.neu.his.cloud.service.sms.dto.app.AppStaffDescriptionResult;
import com.neu.his.cloud.service.sms.service.SmsDescriptionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "SmsDescriptionController", description = "科室、员工描述")
@RequestMapping("/description")
@CrossOrigin(allowCredentials = "true")
public class SmsDescriptionController {

    @Autowired
    private SmsDescriptionService smsDescriptionService;

    @ApiOperation("查询所有科室描述")
    @RequestMapping(value = "/getDeptDescription", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<AppDeptDescriptionResult>> getDeptDescription(){
        return CommonResult.success(smsDescriptionService.getDeptDescription());
    }

    /**
     * 描述:查询对应科室所有专家
     * <p>author: ma
     */
    @ApiOperation("查询某个科室所有专家")
    @RequestMapping(value = "/listDeptDoctor", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<AppStaffDescriptionResult>> listDeptDoctor(@RequestParam("deptId") Long deptId){
        List<AppStaffDescriptionResult> list = smsDescriptionService.getDetailListByDept(deptId);
        return CommonResult.success(list);
    }


    /**
     * 描述:查询员工描述信息
     */
    @ApiOperation("查询员工描述信息")
    @RequestMapping(value = "/getStaffDetailById", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<AppDocSkdResult> getStaffDetailById(@RequestParam("theId")Long theId){
       return CommonResult.success(smsDescriptionService.getDetailById(theId));
    }




}
