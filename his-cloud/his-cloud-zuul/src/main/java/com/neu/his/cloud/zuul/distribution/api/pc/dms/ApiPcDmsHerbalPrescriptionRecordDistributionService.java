package com.neu.his.cloud.zuul.distribution.api.pc.dms;

import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.dto.dms.DmsHerbalPrescriptionRecordParam;
import com.neu.his.cloud.zuul.dto.dms.DmsHerbalPrescriptionRecordResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(value = "his-cloud-api-pc")
public interface ApiPcDmsHerbalPrescriptionRecordDistributionService {

    @RequestMapping(value = "/DmsHerbalPrescriptionRecord/apply", method = RequestMethod.POST)
    CommonResult apply(@RequestBody DmsHerbalPrescriptionRecordParam dmsHerbalPrescriptionRecordParam);


    @RequestMapping(value = "/DmsHerbalPrescriptionRecord/invalid", method = RequestMethod.POST)
    CommonResult invalid(@RequestParam("ids") List<Long> ids);


    @RequestMapping(value = "/DmsHerbalPrescriptionRecord/listByReg", method = RequestMethod.POST)
    CommonResult<List<DmsHerbalPrescriptionRecordResult>>  listByReg(@RequestParam("registrationId") Long registrationId);


    @RequestMapping(value = "/DmsHerbalPrescriptionRecord/listByIds", method = RequestMethod.POST)
    CommonResult<List<DmsHerbalPrescriptionRecordResult>>  listByIds(@RequestParam("ids") List<Long> ids);

}
