package com.neu.his.cloud.zuul.distribution.api.pc.bms;



import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.dto.bms.BmsDoctorPatientFeeResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "his-cloud-api-pc")
public interface ApiPcBmsFeeQueryDistributionService {

    @RequestMapping(value = "/feeQuery/listByRegistration", method = RequestMethod.POST)
    CommonResult<List<BmsDoctorPatientFeeResult>> listFeeByRegistrationId(@RequestParam("registrationId") Long registrationId);

}
