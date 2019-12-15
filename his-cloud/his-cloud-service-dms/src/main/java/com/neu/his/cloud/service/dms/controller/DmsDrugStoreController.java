package com.neu.his.cloud.service.dms.controller;

import com.neu.his.cloud.service.dms.common.CommonResult;
import com.neu.his.cloud.service.dms.dto.dms.DmsRefundDrugListParam;
import com.neu.his.cloud.service.dms.dto.pms.PmsDrugStorePatientListResult;
import com.neu.his.cloud.service.dms.service.DmsDrugStoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@Api(tags = "DmsDrugStoreController", description = "药方工作台")
@RequestMapping("/drugStore")
@CrossOrigin(allowCredentials = "true")
public class DmsDrugStoreController {

    @Autowired
    private DmsDrugStoreService dmsDrugStoreService;

    /**
     * 描述:刷新发药患者
     * <p>author: ma
     */
    @ApiOperation("刷新发药患者")
    @RequestMapping(value = "/listPatient", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<PmsDrugStorePatientListResult> listPatient(@RequestParam(value = "medicalRecordNo",required = false) String medicalRecordNo,
                                                                   @RequestParam("queryDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date queryDate,
                                                                   @RequestParam("type") Integer type){
        PmsDrugStorePatientListResult result = dmsDrugStoreService.listPatient(queryDate,medicalRecordNo,type);
        return CommonResult.success(result);
    }

    /**
     * 描述:发药
     * <p>author: ma
     */
    @ApiOperation("发药")
    @RequestMapping(value = "/releaseDrug", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult releaseDrug(@RequestParam("prescriptionId") Long prescriptionId,
                                    @RequestParam("type") Integer type){
        int count = dmsDrugStoreService.releaseDrug(prescriptionId,type);
        if(count > 0){
            return CommonResult.success(count, "发药成功");
        }
        return CommonResult.failed("发药失败");
    }

    /**
     * 描述:退药
     * <p>author: ma
     */
    @ApiOperation("退药")
    @RequestMapping(value = "/refundDrug", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult refundDrug(@RequestBody DmsRefundDrugListParam dmsRefundDrugListParam){
        int count = dmsDrugStoreService.refundDrug(dmsRefundDrugListParam);
        if(count > 0){
            return CommonResult.success(count, "退药成功");
        }
        return CommonResult.failed("退药失败");
    }

}
