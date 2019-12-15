package com.neu.his.cloud.api.pc.service.pms;

import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsCaseHistoryResult;
import com.neu.his.cloud.api.pc.dto.pms.PmsDiagnosisPatientListResult;
import com.neu.his.cloud.api.pc.dto.pms.PmsPatientResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "his-cloud-service-pms")
public interface PmsPatientService {

    @RequestMapping(value = "/diagnosisPatient/selectPatientByIdNo", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<PmsPatientResult> selectPatientByIdNo(@RequestParam("identificationNo") String identificationNo);


    @RequestMapping(value = "/diagnosisPatient/refreshPatient", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<PmsDiagnosisPatientListResult> refreshPatient(@RequestParam("staffId") Long staffId);


    @RequestMapping(value = "/diagnosisPatient/bindPatient", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult bindPatient(@RequestParam("registrationId") Long registrationId, @RequestParam("staffId") Long staffId);

    @RequestMapping(value = "/diagnosisPatient/startDiagnosis", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<DmsCaseHistoryResult> startDiagnosis(@RequestParam("registrationId") Long registrationId);

}
