package com.neu.his.cloud.api.app.service.dms;


import com.neu.his.cloud.api.app.common.CommonResult;
import com.neu.his.cloud.api.app.dto.app.AppCheckTestResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(value = "his-cloud-service-dms")
public interface DmsNonDrugItemRecordService {
    @RequestMapping(value = "/nonDrugItemRecord/getResult", method = RequestMethod.POST)
    CommonResult<AppCheckTestResult> getResult(@RequestParam("id") Long id);

}
