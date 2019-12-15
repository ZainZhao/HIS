package com.neu.his.cloud.api.app.service.bms;

import com.neu.his.cloud.api.app.common.CommonResult;
import com.neu.his.cloud.api.app.dto.app.AppDrugItemResult;
import com.neu.his.cloud.api.app.dto.app.AppHistoryRegResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "his-cloud-service-bms")
public interface BmsFeeQueryService {

    @RequestMapping(value = "/feeQuery/listFee", method = RequestMethod.POST)
    public CommonResult<List<AppHistoryRegResult>> listFee(@RequestParam("registrationId") Long registrationId);

    @RequestMapping(value = "/feeQuery/listDetail", method = RequestMethod.POST)
    public CommonResult<List<AppDrugItemResult>> listFeeDetail(@RequestParam("prescriptionId") Long prescriptionId ,
                                                               @RequestParam("type") int type);

}
