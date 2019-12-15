package com.neu.his.cloud.api.pc.service.dms;


import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsMedicinePrescriptionRecordParam;
import com.neu.his.cloud.api.pc.dto.dms.DmsMedicinePrescriptionRecordResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient(value = "his-cloud-service-dms")
public interface DmsMedicinePrescriptionRecordService {



    @RequestMapping(value = "/DmsMedicinePrescriptionRecord/apply", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult apply(@RequestBody DmsMedicinePrescriptionRecordParam dmsMedicinePrescriptionRecordParam);


    @RequestMapping(value = "/DmsMedicinePrescriptionRecord/invalid", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult invalid(@RequestParam("ids") List<Long> ids);


    @RequestMapping(value = "/DmsMedicinePrescriptionRecord/listByReg", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsMedicinePrescriptionRecordResult>> listByReg(@RequestParam("registrationId") Long registrationId);


    @RequestMapping(value = "/DmsMedicinePrescriptionRecord/listByIds", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsMedicinePrescriptionRecordResult>> listByIds(@RequestParam("ids") List<Long> ids);
}
