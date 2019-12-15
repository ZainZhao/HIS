package com.neu.his.cloud.api.pc.controller.dms;

import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsHerbalPrescriptionRecordParam;
import com.neu.his.cloud.api.pc.dto.dms.DmsHerbalPrescriptionRecordResult;
import com.neu.his.cloud.api.pc.service.dms.DmsHerbalPrescriptionRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "DmsHerbalPrescriptionRecordController", description = "草药处方管理")
@RequestMapping("/DmsHerbalPrescriptionRecord")
@CrossOrigin(allowCredentials = "true")
public class DmsHerbalPrescriptionRecordController {

    @Autowired
    private DmsHerbalPrescriptionRecordService dmsHerbalPrescriptionRecordService;

    @ApiOperation(value = "开立处方")
    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult apply(@RequestBody DmsHerbalPrescriptionRecordParam dmsHerbalPrescriptionRecordParam, BindingResult result){
      return dmsHerbalPrescriptionRecordService.apply(dmsHerbalPrescriptionRecordParam);
    }


    @ApiOperation(value = "作废处方")
    @RequestMapping(value = "/invalid", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult invalid(@RequestParam("ids") List<Long> ids){
       return dmsHerbalPrescriptionRecordService.invalid(ids);
    }


    @ApiOperation(value = "根据挂号Id查询处方")
    @RequestMapping(value = "/listByReg", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsHerbalPrescriptionRecordResult>>  listByReg(@RequestParam("registrationId") Long registrationId){
        return dmsHerbalPrescriptionRecordService.listByReg(registrationId);
    }


    @ApiOperation(value = "根据ids查询草药处方")
    @RequestMapping(value = "/listByIds", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsHerbalPrescriptionRecordResult>>  listByIds(@RequestParam("ids") List<Long> ids){
        return dmsHerbalPrescriptionRecordService.listByIds(ids);
    }

}
