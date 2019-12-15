package com.neu.his.cloud.api.pc.controller.pms;


import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsCaseHistoryResult;
import com.neu.his.cloud.api.pc.dto.pms.PmsDiagnosisPatientListResult;
import com.neu.his.cloud.api.pc.dto.pms.PmsPatientResult;
import com.neu.his.cloud.api.pc.service.pms.PmsPatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "PmsDiagnosisPatientController", description = "诊断病人管理")
@RequestMapping("/diagnosisPatient")
@CrossOrigin(allowCredentials = "true")
public class PmsDiagnosisPatientController {
    @Autowired
    PmsPatientService pmsPatientService;


    @ApiOperation(value = "根据身份证号查询患者基本信息")
    @RequestMapping(value = "/selectPatientByIdNo", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<PmsPatientResult> selectPatientByIdNo(@RequestParam("identificationNo") String identificationNo){
        return  pmsPatientService.selectPatientByIdNo(identificationNo);
    }



    @RequestMapping(value = "/refreshPatient", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<PmsDiagnosisPatientListResult> refreshPatient(@RequestParam("staffId") Long staffId){
       return pmsPatientService.refreshPatient(staffId);

    }


    @RequestMapping(value = "/bindPatient", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult bindPatient(@RequestParam("registrationId") Long registrationId, @RequestParam("staffId") Long staffId){
         return pmsPatientService.bindPatient(registrationId,staffId);
    }


    @RequestMapping(value = "/startDiagnosis", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<DmsCaseHistoryResult> startDiagnosis(@RequestParam("registrationId") Long registrationId){
       return pmsPatientService.startDiagnosis(registrationId);
    }




}
