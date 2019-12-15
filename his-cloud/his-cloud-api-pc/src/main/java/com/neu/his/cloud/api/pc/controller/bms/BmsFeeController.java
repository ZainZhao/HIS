package com.neu.his.cloud.api.pc.controller.bms;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.cloud.api.pc.common.CommonPage;
import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.bms.*;
import com.neu.his.cloud.api.pc.service.bms.BmsFeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Api(tags = "BmsFeeController", description = "收退费管理")
@RequestMapping("/fee")
@CrossOrigin(allowCredentials = "true")
public class BmsFeeController {

    @Autowired
    BmsFeeService bmsFeeService;

    @ApiOperation(value = "查询挂号人")
    @RequestMapping(value = "/listRegisteredPatient", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<BmsRegistrationPatientResult>> listRegisteredPatient(@RequestParam(required=false,name = "medicalRecordNo") String  medicalRecordNo,
                                                                                        @RequestParam(required=false,name="queryDate")@DateTimeFormat(pattern = "yyyy-MM-dd") Date queryDate,
                                                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
       return bmsFeeService.listRegisteredPatient(medicalRecordNo,queryDate,pageSize,pageNum);
    }

    @ApiOperation(value = "收费")
    @RequestMapping(value = "/charge", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult charge(@RequestBody List<BmsChargeParam> bmsChargeParamList){
        return bmsFeeService.charge(bmsChargeParamList);
    }

    @ApiOperation(value = "根据挂号id查询未缴费项目")
    @RequestMapping(value = "/listRefundByRegistrationId", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<BmsRefundChargeResult>>  listRefundByRegistrationId(@RequestParam("registrationId") Long registrationId){
       return bmsFeeService.listRefundByRegistrationId(registrationId);
    }

    @ApiOperation(value = "非药品、药品退费")
    @RequestMapping(value = "/refundCharge", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult refundCharge(@RequestBody List<BmsRefundChargeParam> bmsRefundChargeParamList){
       return bmsFeeService.refundCharge(bmsRefundChargeParamList);
    }


    @ApiOperation(value = "挂号退费")
    @RequestMapping(value = "/refundRegistrationCharge", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult refundRegistrationCharge(@RequestBody BmsRefundRegChargeParam bmsRefundRegChargeParam){
       return bmsFeeService.refundRegistrationCharge(bmsRefundRegChargeParam);
    }

    @ApiOperation(value = "根据挂号Id查询所有未交费项目")
    @RequestMapping(value = "/listChargeByRegistrationId", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<BmsChargeResult>>  listChargeByRegistrationId(@RequestParam("registrationId") Long registrationId){
        return bmsFeeService.listChargeByRegistrationId(registrationId);

    }
}
