package com.neu.his.cloud.api.pc.service.dms;

import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsRefundDrugListParam;
import com.neu.his.cloud.api.pc.dto.pms.PmsDrugStorePatientListResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@FeignClient(value = "his-cloud-service-dms")
public interface DmsDrugStoreService {


    @RequestMapping(value = "/drugStore/listPatient", method = RequestMethod.POST)
    CommonResult<PmsDrugStorePatientListResult> listPatient(@RequestParam(value = "medicalRecordNo",required = false) String medicalRecordNo,
                                                            @RequestParam("queryDate")  String  queryDate,
                                                                   @RequestParam("type") Integer type);


    @RequestMapping(value = "/drugStore/releaseDrug", method = RequestMethod.POST)
    public CommonResult releaseDrug(@RequestParam("prescriptionId") Long prescriptionId,
                                    @RequestParam("type") Integer type);


    @RequestMapping(value = "/drugStore/refundDrug", method = RequestMethod.POST)

    public CommonResult refundDrug(@RequestBody DmsRefundDrugListParam dmsRefundDrugListParam);

}
