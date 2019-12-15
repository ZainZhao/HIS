package com.neu.his.cloud.zuul.distribution.api.pc.dms;


import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.dto.dms.DmsRefundDrugListParam;
import com.neu.his.cloud.zuul.dto.pms.PmsDrugStorePatientListResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@FeignClient(value = "his-cloud-api-pc")
public interface ApiPcDmsDrugStoreDistributionService {

    @RequestMapping(value = "/drugStore/listPatient", method = RequestMethod.POST)
    CommonResult<PmsDrugStorePatientListResult> listPatient(@RequestParam(value = "medicalRecordNo",required = false) String medicalRecordNo,
                                                                   @RequestParam("queryDate") String queryDate,
                                                                   @RequestParam("type") Integer type);


    @RequestMapping(value = "/drugStore/releaseDrug", method = RequestMethod.POST)
    CommonResult releaseDrug(@RequestParam("prescriptionId") Long prescriptionId,
                                    @RequestParam("type") Integer type);

    @RequestMapping(value = "/drugStore/refundDrug", method = RequestMethod.POST)
    public CommonResult refundDrug(@RequestBody DmsRefundDrugListParam dmsRefundDrugListParam);

}
