package com.neu.his.cloud.api.pc.service.dms;

import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsRegistrationParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "his-cloud-service-dms")
public interface DmsRegistrationService {



    @RequestMapping(value = "/registration/createRegistration", method = RequestMethod.POST)
    CommonResult createRegistration(@RequestBody DmsRegistrationParam dmsRegistrationParam);

}
