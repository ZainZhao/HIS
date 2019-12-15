package com.neu.his.cloud.api.pc.service.dms;


import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsCaseHistoryParam;
import com.neu.his.cloud.api.pc.dto.dms.DmsCaseHistoryResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "his-cloud-service-dms")
public interface DmsCaseHistoryService {

    @RequestMapping(value = "/caseHistory/submitPriliminaryDise", method = RequestMethod.POST)
    CommonResult submitPriliminaryDise(@RequestBody DmsCaseHistoryParam dmsCaseHistoryParam);

    @RequestMapping(value = "/caseHistory/selectNotEndCaseHistoryByReg/{registrationId}", method = RequestMethod.GET)
    CommonResult<DmsCaseHistoryResult> selectNotEndCaseHistoryByReg(@PathVariable("registrationId") Long registrationId);


    @RequestMapping(value = "/caseHistory/selectEndCaseHistoryByReg/{registrationId}", method = RequestMethod.GET)
    CommonResult<DmsCaseHistoryResult> selectEndCaseHistoryByReg(@PathVariable("registrationId") Long registrationId);


    @RequestMapping(value = "/caseHistory/submitDefiniteDise", method = RequestMethod.POST)
    CommonResult submitDefiniteDise(@RequestBody DmsCaseHistoryParam dmsCaseHistoryParam);

    @RequestMapping(value = "/caseHistory/endDiagnosis", method = RequestMethod.POST)
    CommonResult endDiagnosis(@RequestBody DmsCaseHistoryParam dmsCaseHistoryParam);
}
