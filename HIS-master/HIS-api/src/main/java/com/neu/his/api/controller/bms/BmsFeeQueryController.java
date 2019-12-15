package com.neu.his.api.controller.bms;

import com.neu.his.bms.service.BmsFeeQueryService;
import com.neu.his.common.api.CommonResult;
import com.neu.his.common.dto.bms.BmsDoctorPatientFeeResult;
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
    @ApiOperation("根据挂号Id查询患者费用")
    @RequestMapping(value = "/listByRegistration", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<BmsDoctorPatientFeeResult>>  listFeeByRegistrationId(@RequestParam("registrationId") Long registrationId){
        List<BmsDoctorPatientFeeResult> list = bmsFeeQueryService.listFeeByRegistrationId(registrationId);
        return CommonResult.success(list);
    }

}
