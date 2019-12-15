package com.neu.his.cloud.api.app.service.pms;


import com.neu.his.cloud.api.app.common.CommonResult;
import com.neu.his.cloud.api.app.dto.pms.PmsPatientResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "his-cloud-service-pms")
public interface PmsPatientService {


    @RequestMapping(value = "/pmsPatient/login", method = RequestMethod.POST)
    CommonResult<PmsPatientResult> login(@RequestParam("identificationNo") String identificationNo,
                                                @RequestParam("medicalRecordNo") String medicalRecordNo);
}
