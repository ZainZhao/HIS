package com.neu.his.cloud.api.pc.service.bms;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.cloud.api.pc.common.CommonPage;
import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.bms.*;
import com.neu.his.cloud.api.pc.dto.dms.DmsHerbalPrescriptionRecordResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@FeignClient(value = "his-cloud-service-bms")
public interface BmsFeeService {

    @RequestMapping(value = "/fee/listRegisteredPatient", method = RequestMethod.GET)
    CommonResult<CommonPage<BmsRegistrationPatientResult>> listRegisteredPatient(@RequestParam(required=false,name = "medicalRecordNo") String  medicalRecordNo,
                                                                                        @RequestParam(required=false,name="queryDate")@DateTimeFormat(pattern = "yyyy-MM-dd") Date queryDate,
                                                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum);


    @RequestMapping(value = "/fee/charge", method = RequestMethod.POST)
    CommonResult charge(@RequestBody List<BmsChargeParam> bmsChargeParamList);


    @RequestMapping(value = "/fee/listRefundByRegistrationId", method = RequestMethod.GET)
     CommonResult<List<BmsRefundChargeResult>>  listRefundByRegistrationId(@RequestParam("registrationId") Long registrationId);


    @RequestMapping(value = "/fee/refundCharge", method = RequestMethod.POST)
     CommonResult refundCharge(@RequestBody List<BmsRefundChargeParam> bmsRefundChargeParamList);


    @RequestMapping(value = "/fee/refundRegistrationCharge", method = RequestMethod.POST)
     CommonResult refundRegistrationCharge(@RequestBody BmsRefundRegChargeParam bmsRefundRegChargeParam);



    @RequestMapping(value = "/fee/listChargeByRegistrationId", method = RequestMethod.GET)
    CommonResult<List<BmsChargeResult>>  listChargeByRegistrationId(@RequestParam("registrationId") Long registrationId);
}
