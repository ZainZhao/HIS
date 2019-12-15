package com.neu.his.cloud.zuul.distribution.api.pc.pms;


import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.dto.dms.DmsCaseHistoryResult;
import com.neu.his.cloud.zuul.dto.pms.PmsDiagnosisPatientListResult;
import com.neu.his.cloud.zuul.dto.pms.PmsPatientResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@FeignClient(value = "his-cloud-api-pc")
public interface ApiPcPmsDiagnosisPatientDistributionService {


    @RequestMapping(value = "/diagnosisPatient/selectPatientByIdNo", method = RequestMethod.POST)
    CommonResult<PmsPatientResult> selectPatientByIdNo(@RequestParam("identificationNo") String identificationNo);

    @RequestMapping(value = "/diagnosisPatient/refreshPatient", method = RequestMethod.POST)
    CommonResult<PmsDiagnosisPatientListResult> refreshPatient(@RequestParam("staffId") Long staffId);


    @RequestMapping(value = "/diagnosisPatient/bindPatient", method = RequestMethod.GET)
    CommonResult bindPatient(@RequestParam("registrationId") Long registrationId, @RequestParam("staffId") Long staffId);

    @RequestMapping(value = "/diagnosisPatient/startDiagnosis", method = RequestMethod.GET)
    CommonResult<DmsCaseHistoryResult> startDiagnosis(@RequestParam("registrationId") Long registrationId);
}
