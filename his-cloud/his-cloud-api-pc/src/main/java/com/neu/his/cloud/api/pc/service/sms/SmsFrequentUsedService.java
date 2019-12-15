package com.neu.his.cloud.api.pc.service.sms;

import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.sms.SmsFrequentUsedResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "his-cloud-service-sms")
public interface SmsFrequentUsedService {
    @RequestMapping(value = "/frequentUsed/add", method = RequestMethod.POST)
    public CommonResult addFrequent(@RequestParam("staffId") Long staffId,
                                    @RequestParam("addType") int addType,
                                    @RequestParam("addId") Long addId);

    @RequestMapping(value = "/frequentUsed/delete", method = RequestMethod.POST)
    public CommonResult deleteFrequent(@RequestParam("staffId") Long staffId,
                                       @RequestParam("deleteType") int deleteType,
                                       @RequestParam("deleteId") Long deleteId);

    @RequestMapping(value = "/frequentUsed/selectByType", method = RequestMethod.POST)
    public CommonResult<SmsFrequentUsedResult> selectFrequent(@RequestParam("staffId") Long staffId,
                                                              @RequestParam("selectType") int selectType);
}
