package com.neu.his.cloud.api.pc.service.bms;

import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.bms.BmsDoctorPatientFeeResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient(value = "his-cloud-service-bms")
public interface BmsFeeQueryService {

    @RequestMapping(value = "/feeQuery/listByRegistration", method = RequestMethod.POST)
    CommonResult<List<BmsDoctorPatientFeeResult>> listFeeByRegistrationId(@RequestParam("registrationId") Long registrationId);

}
