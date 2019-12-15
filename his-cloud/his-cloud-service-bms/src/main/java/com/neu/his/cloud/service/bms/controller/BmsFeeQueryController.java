package com.neu.his.cloud.service.bms.controller;


import com.neu.his.cloud.service.bms.common.CommonResult;
import com.neu.his.cloud.service.bms.dto.app.AppDrugItemResult;
import com.neu.his.cloud.service.bms.dto.app.AppHistoryRegResult;
import com.neu.his.cloud.service.bms.dto.bms.BmsDoctorPatientFeeResult;
import com.neu.his.cloud.service.bms.service.BmsFeeQueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "BmsFeeQueryController", description = "费用查询")
@RequestMapping("/feeQuery")
@CrossOrigin(allowCredentials = "true")
public class BmsFeeQueryController {

    @Autowired
    private BmsFeeQueryService bmsFeeQueryService;

    /**
     * 描述:根据挂号id查询患者费用
     * <p>author: ma
     */
    @ApiOperation("根据挂号id查询患者费用")
    @RequestMapping(value = "/listByRegistration", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<BmsDoctorPatientFeeResult>>  listFeeByRegistrationId(@RequestParam("registrationId") Long registrationId){
        List<BmsDoctorPatientFeeResult> list = bmsFeeQueryService.listFeeByRegistrationId(registrationId);
        return CommonResult.success(list);
    }

    /**
     * 描述:查看某次挂号费用大项
     * <p>author: ma
     */
    @ApiOperation("查询某次挂号费用（大项）")
    @RequestMapping(value = "/listFee", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<AppHistoryRegResult>> listFee(@RequestParam("registrationId") Long registrationId){
        List<AppHistoryRegResult> feeResultList = bmsFeeQueryService.listFeePrescription(registrationId);
        return CommonResult.success(feeResultList);
    }

    /**
     * 描述:查看某次挂号费用小项
     * <p>author: ma
     */
    @ApiOperation("查询某次挂号费用（小项）")
    @RequestMapping(value = "/listDetail", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<AppDrugItemResult>> listFeeDetail(@RequestParam("prescriptionId") Long prescriptionId ,
                                                               @RequestParam("type") int type){
        List<AppDrugItemResult> itemResultList = bmsFeeQueryService.listFeeItem(prescriptionId,type);
        return CommonResult.success(itemResultList);
    }


}
