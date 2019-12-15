package com.neu.his.cloud.zuul.distribution.api.pc.dms;



import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.dto.dms.DmsMedicinePrescriptionRecordParam;
import com.neu.his.cloud.zuul.dto.dms.DmsMedicinePrescriptionRecordResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(value = "his-cloud-api-pc")
public interface ApiPcDmsMedicinePrescriptionRecordDistributionService {

    @RequestMapping(value = "/DmsMedicinePrescriptionRecord/apply", method = RequestMethod.POST)
    CommonResult apply(@RequestBody DmsMedicinePrescriptionRecordParam dmsMedicinePrescriptionRecordParam);


    @RequestMapping(value = "/DmsMedicinePrescriptionRecord/invalid", method = RequestMethod.POST)
    CommonResult invalid(@RequestParam("ids") List<Long> ids);


    @RequestMapping(value = "/DmsMedicinePrescriptionRecord/listByReg", method = RequestMethod.POST)
    CommonResult<List<DmsMedicinePrescriptionRecordResult>> listByReg(@RequestParam("registrationId") Long registrationId);

    @RequestMapping(value = "/DmsMedicinePrescriptionRecord/listByIds", method = RequestMethod.POST)
    CommonResult<List<DmsMedicinePrescriptionRecordResult>> listByIds(@RequestParam("ids") List<Long> ids);

}
