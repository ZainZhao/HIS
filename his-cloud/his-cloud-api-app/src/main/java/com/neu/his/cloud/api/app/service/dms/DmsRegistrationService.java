package com.neu.his.cloud.api.app.service.dms;


import com.neu.his.cloud.api.app.common.CommonResult;
import com.neu.his.cloud.api.app.dto.app.AppRegistrationParam;
import com.neu.his.cloud.api.app.dto.dms.DmsRegHistoryResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient(value = "his-cloud-service-dms")
public interface DmsRegistrationService {
    @RequestMapping(value = "/registration/listAllRegistration", method = RequestMethod.POST)
     CommonResult<List<DmsRegHistoryResult>> listAllRegistration(@RequestParam("identificationNo") String identificationNo);

    @RequestMapping(value = "/registration/appReg", method = RequestMethod.POST)
     CommonResult appRegistration(@RequestBody AppRegistrationParam appRegistrationParam);
}
