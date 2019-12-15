package com.neu.his.cloud.api.pc.controller.dms;

import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsRefundDrugListParam;
import com.neu.his.cloud.api.pc.dto.pms.PmsDrugStorePatientListResult;
import com.neu.his.cloud.api.pc.service.dms.DmsDrugStoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@Api(tags = "DmsDrugStoreController", description = "药房工作台")
@RequestMapping("/drugStore")
@CrossOrigin(allowCredentials = "true")
public class DmsDrugStoreController {

    @Autowired
    private DmsDrugStoreService dmsDrugStoreService;


    @ApiOperation("刷新发药患者")
    @RequestMapping(value = "/listPatient", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<PmsDrugStorePatientListResult> listPatient(@RequestParam(value = "medicalRecordNo",required = false) String medicalRecordNo,
                                                                   @RequestParam("queryDate") String queryDate,
                                                                   @RequestParam("type") Integer type){
        return  dmsDrugStoreService.listPatient(medicalRecordNo,queryDate,type);
    }


    @ApiOperation("发药")
    @RequestMapping(value = "/releaseDrug", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult releaseDrug(@RequestParam("prescriptionId") Long prescriptionId,
                                    @RequestParam("type") Integer type){
       return dmsDrugStoreService.releaseDrug(prescriptionId,type);
    }

    @ApiOperation("退药")
    @RequestMapping(value = "/refundDrug", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult refundDrug(@RequestBody DmsRefundDrugListParam dmsRefundDrugListParam){
        return dmsDrugStoreService.refundDrug(dmsRefundDrugListParam);
    }

}
