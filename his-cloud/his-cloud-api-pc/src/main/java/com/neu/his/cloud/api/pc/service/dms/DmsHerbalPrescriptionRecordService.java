package com.neu.his.cloud.api.pc.service.dms;


import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsHerbalPrescriptionRecordParam;
import com.neu.his.cloud.api.pc.dto.dms.DmsHerbalPrescriptionRecordResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient(value = "his-cloud-service-dms")
public interface DmsHerbalPrescriptionRecordService {



    @RequestMapping(value = "/DmsHerbalPrescriptionRecord/apply", method = RequestMethod.POST)
     CommonResult apply(@RequestBody DmsHerbalPrescriptionRecordParam dmsHerbalPrescriptionRecordParam);


    @RequestMapping(value = "/DmsHerbalPrescriptionRecord/invalid", method = RequestMethod.POST)
     CommonResult invalid(@RequestParam("ids") List<Long> ids);


    @RequestMapping(value = "/DmsHerbalPrescriptionRecord/listByReg", method = RequestMethod.POST)
     CommonResult<List<DmsHerbalPrescriptionRecordResult>>  listByReg(@RequestParam("registrationId") Long registrationId);


    @RequestMapping(value = "/DmsHerbalPrescriptionRecord/listByIds", method = RequestMethod.POST)
     CommonResult<List<DmsHerbalPrescriptionRecordResult>>  listByIds(@RequestParam("ids") List<Long> ids);
}
