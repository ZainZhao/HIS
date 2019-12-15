package com.neu.his.cloud.api.pc.controller.dms;

import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsNonDrugItemRecordListParam;
import com.neu.his.cloud.api.pc.dto.dms.DmsNonDrugItemRecordResult;
import com.neu.his.cloud.api.pc.service.dms.DmsNonDrugItemRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "DmsNonDrugItemRecordController", description = "非药品收费项目管理")
@RequestMapping("/nonDrugItemRecord")
@CrossOrigin(allowCredentials = "true")
public class DmsNonDrugItemRecordController {
    @Autowired
    DmsNonDrugItemRecordService dmsNonDrugItemRecordService;


    @ApiOperation(value = "开立项目")
    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult apply(@RequestBody DmsNonDrugItemRecordListParam dmsNonDrugItemRecordListParam, BindingResult result){
        return dmsNonDrugItemRecordService.apply(dmsNonDrugItemRecordListParam);
    }

    @ApiOperation(value = "作废项目")
    @RequestMapping(value = "/invalid", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult invalid(@RequestParam("ids") List<Long> ids){
        return dmsNonDrugItemRecordService.invalid(ids);
    }


    @ApiOperation(value = "刷新项目")
    @RequestMapping(value = "/listByRegAndType", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsNonDrugItemRecordResult>> listByRegAndType(@RequestParam("registrationId") Long registrationId, @RequestParam("type") Integer type){
       return dmsNonDrugItemRecordService.listByRegAndType(registrationId,type);
    }
}
