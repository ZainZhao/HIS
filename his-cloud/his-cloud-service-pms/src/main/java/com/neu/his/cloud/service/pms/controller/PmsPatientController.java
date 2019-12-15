package com.neu.his.cloud.service.pms.controller;

import com.neu.his.cloud.service.pms.common.CommonResult;
import com.neu.his.cloud.service.pms.dto.pms.PmsPatientResult;
import com.neu.his.cloud.service.pms.service.PmsPatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(tags = "PmsPatientController", description = "病人管理")
@RequestMapping("/pmsPatient")
@CrossOrigin(allowCredentials = "true")
public class PmsPatientController {

    @Autowired
    private PmsPatientService pmsPatientService;
    /**
     * 描述:患者手机端登录
     * <p>author: ma
     */
    @ApiOperation("患者 手机端登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<PmsPatientResult> login(@RequestParam("identificationNo") String identificationNo,
                                                @RequestParam("medicalRecordNo") String medicalRecordNo){
        PmsPatientResult result = pmsPatientService.patientLogin(identificationNo ,medicalRecordNo);
        System.err.println("result:"+result);
        if(result == null){
            return  CommonResult.failed("登录失败");
        }else {
            return CommonResult.success(result,"登录成功");
        }
    }

}
