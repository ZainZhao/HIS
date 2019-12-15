package com.neu.his.cloud.zuul.distribution.api.pc.dms;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.dto.dms.DmsCaseHistoryParam;
import com.neu.his.cloud.zuul.dto.dms.DmsCaseHistoryResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "his-cloud-api-pc")
public interface ApiPcDmsCaseHistoryDistributionService {


    @RequestMapping(value = "/caseHistory/submitPriliminaryDise", method = RequestMethod.POST)
    CommonResult submitPriliminaryDise(@RequestBody DmsCaseHistoryParam dmsCaseHistoryParam);


    @RequestMapping(value = "/caseHistory/selectNotEndCaseHistoryByReg/{registrationId}", method = RequestMethod.GET)
    CommonResult<DmsCaseHistoryResult> selectNotEndCaseHistoryByReg(@PathVariable("registrationId") Long registrationId);


    @RequestMapping(value = "/caseHistory/selectEndCaseHistoryByReg/{registrationId}", method = RequestMethod.GET)
    CommonResult<DmsCaseHistoryResult> selectEndCaseHistoryByReg(@PathVariable("registrationId") Long registrationId);


    @RequestMapping(value = "/caseHistory/submitDefiniteDise", method = RequestMethod.POST)
    CommonResult submitDefiniteDise(DmsCaseHistoryParam dmsCaseHistoryParam);


    @RequestMapping(value = "/caseHistory/endDiagnosis", method = RequestMethod.POST)
    CommonResult endDiagnosis(DmsCaseHistoryParam dmsCaseHistoryParam);
}
