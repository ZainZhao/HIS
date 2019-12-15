package com.neu.his.cloud.api.pc.controller.dms;


import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsMedicinePrescriptionRecordParam;
import com.neu.his.cloud.api.pc.dto.dms.DmsMedicinePrescriptionRecordResult;
import com.neu.his.cloud.api.pc.service.dms.DmsMedicinePrescriptionRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "DmsMedicinePrescriptionRecordController", description = "成药处方管理")
@RequestMapping("/DmsMedicinePrescriptionRecord")
@CrossOrigin(allowCredentials = "true")
public class DmsMedicinePrescriptionRecordController {

    @Autowired
    private DmsMedicinePrescriptionRecordService dmsMedicinePrescriptionRecordService;


    @ApiOperation(value = "开立处方")
    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult apply(@RequestBody DmsMedicinePrescriptionRecordParam dmsMedicinePrescriptionRecordParam, BindingResult result){
       return dmsMedicinePrescriptionRecordService.apply(dmsMedicinePrescriptionRecordParam);

    }


    @ApiOperation(value = "作废处方")
    @RequestMapping(value = "/invalid", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult invalid(@RequestParam("ids") List<Long> ids){
       return dmsMedicinePrescriptionRecordService.invalid(ids);
    }


    @ApiOperation(value = "根据挂号Id查询处方")
    @RequestMapping(value = "/listByReg", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsMedicinePrescriptionRecordResult>> listByReg(@RequestParam("registrationId") Long registrationId){
       return dmsMedicinePrescriptionRecordService.listByReg(registrationId);
    }


    @ApiOperation(value = "根据ids查询成药处方")
    @RequestMapping(value = "/listByIds", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsMedicinePrescriptionRecordResult>> listByIds(@RequestParam("ids") List<Long> ids){
       return dmsMedicinePrescriptionRecordService.listByIds(ids);
    }

}
