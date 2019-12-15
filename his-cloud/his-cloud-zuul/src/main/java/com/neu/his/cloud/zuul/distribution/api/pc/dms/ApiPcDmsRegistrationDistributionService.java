package com.neu.his.cloud.zuul.distribution.api.pc.dms;

import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.dto.dms.DmsRegistrationParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "his-cloud-api-pc")
public interface ApiPcDmsRegistrationDistributionService {
    @RequestMapping(value = "/registration/createRegistration", method = RequestMethod.POST)
    CommonResult createRegistration(@RequestBody DmsRegistrationParam dmsRegistrationParam);

}
