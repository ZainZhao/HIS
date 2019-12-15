package com.neu.his.cloud.zuul.distribution.api.pc.dms;

import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.dto.dms.DmsNonDrugItemRecordListParam;
import com.neu.his.cloud.zuul.dto.dms.DmsNonDrugItemRecordResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "his-cloud-api-pc")
public interface ApiPcDmsNonDrugItemRecordDistributionService {

    @RequestMapping(value = "/nonDrugItemRecord/apply", method = RequestMethod.POST)
    CommonResult apply(@RequestBody DmsNonDrugItemRecordListParam dmsNonDrugItemRecordListParam);

    @RequestMapping(value = "/nonDrugItemRecord/invalid", method = RequestMethod.POST)
    CommonResult invalid(@RequestParam("ids") List<Long> ids);

    @RequestMapping(value = "/nonDrugItemRecord/listByRegAndType", method = RequestMethod.POST)
    CommonResult<List<DmsNonDrugItemRecordResult>> listByRegAndType(@RequestParam("registrationId") Long registrationId, @RequestParam("type") Integer type);
}
