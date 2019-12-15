package com.neu.his.cloud.api.pc.controller.bms;

import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.bms.BmsDoctorPatientFeeResult;
import com.neu.his.cloud.api.pc.service.bms.BmsFeeQueryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "BmsFeeQueryController", description = "费用查询")
@RequestMapping("/feeQuery")
@CrossOrigin(allowCredentials = "true")
public class BmsFeeQueryController {

    @Autowired
    private BmsFeeQueryService bmsFeeQueryService;

    @ApiOperation("根据挂号Id查询患者费用")
    @RequestMapping(value = "/listByRegistration", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<BmsDoctorPatientFeeResult>> listFeeByRegistrationId(@RequestParam("registrationId") Long registrationId){
       return  bmsFeeQueryService.listFeeByRegistrationId(registrationId);
    }

}
