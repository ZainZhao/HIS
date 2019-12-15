package com.neu.his.cloud.api.app.service.sms;


import com.neu.his.cloud.api.app.common.CommonResult;
import com.neu.his.cloud.api.app.dto.app.AppDeptDescriptionResult;
import com.neu.his.cloud.api.app.dto.app.AppDocSkdResult;
import com.neu.his.cloud.api.app.dto.app.AppStaffDescriptionResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "his-cloud-service-sms")
public interface SmsDescriptionService {

    @RequestMapping(value = "/description/getDeptDescription", method = RequestMethod.POST)
    CommonResult<List<AppDeptDescriptionResult>> getDeptDescription();

    @RequestMapping(value = "/description/listDeptDoctor", method = RequestMethod.POST)
    CommonResult<List<AppStaffDescriptionResult>> listDeptDoctor(@RequestParam("deptId") Long deptId);

    @RequestMapping(value = "/description/getStaffDetailById", method = RequestMethod.POST)
    CommonResult<AppDocSkdResult> getStaffDetailById(@RequestParam("theId")Long theId);
}
