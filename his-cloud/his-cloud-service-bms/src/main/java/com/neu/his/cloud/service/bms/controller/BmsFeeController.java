package com.neu.his.cloud.service.bms.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.cloud.service.bms.common.CommonPage;
import com.neu.his.cloud.service.bms.common.CommonResult;
import com.neu.his.cloud.service.bms.dto.bms.*;
import com.neu.his.cloud.service.bms.dto.dms.DmsHerbalPrescriptionRecordResult;
import com.neu.his.cloud.service.bms.service.BmsFeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
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


        Page page = PageHelper.startPage(pageNum, pageSize);
        List<BmsRegistrationPatientResult> list = bmsFeeService.listRegisteredPatient(medicalRecordNo,queryDate);
        Long pageTotal=page.getTotal();
        return CommonResult.success(CommonPage.restPage(list,pageTotal));
    }

    @ApiOperation(value = "收费")
    @RequestMapping(value = "/charge", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult charge(@RequestBody List<BmsChargeParam> bmsChargeParamList){
        int result = bmsFeeService.charge(bmsChargeParamList);
        if (result == 1){
            return CommonResult.success(result);
        }
        else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "根据挂号id列出未缴费项目")
    @RequestMapping(value = "/listRefundByRegistrationId", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<BmsRefundChargeResult>>  listRefundByRegistrationId(@RequestParam("registrationId") Long registrationId){
        List<BmsRefundChargeResult> bmsRefundChargeResultList = bmsFeeService.listRefundByRegistrationId(registrationId);
        if (bmsRefundChargeResultList.isEmpty()){
            return CommonResult.success(null);
        }else {
            return CommonResult.success(bmsRefundChargeResultList);
        }
    }

    @ApiOperation(value = "非药品、药品退费")
    @RequestMapping(value = "/refundCharge", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult refundCharge(@RequestBody List<BmsRefundChargeParam> bmsRefundChargeParamList){
        int result = bmsFeeService.refundCharge(bmsRefundChargeParamList);
        if (result == 1){
            return CommonResult.success(result);
        }else {
            return CommonResult.failed();
        }
    }


    @ApiOperation(value = "挂号退费")
    @RequestMapping(value = "/refundRegistrationCharge", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult refundRegistrationCharge(@RequestBody BmsRefundRegChargeParam bmsRefundRegChargeParam){
        int result = bmsFeeService.refundRegistrationCharge(bmsRefundRegChargeParam);
        if (result == 1){
            return CommonResult.success(result);
        }
        else {
            return CommonResult.failed();
        }
    }



    @ApiOperation(value = "根据门诊号查询所有未交费项目")
    @RequestMapping(value = "/listChargeByRegistrationId", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<BmsChargeResult>>  listChargeByRegistrationId(@RequestParam("registrationId") Long registrationId){
        List<BmsChargeResult> bmsChargeResultList = bmsFeeService.listChargeByRegistrationId(registrationId);
        if (bmsChargeResultList.isEmpty()){
            return CommonResult.success(null);
        }
        else {
            return CommonResult.success(bmsChargeResultList);
        }
    }
}
