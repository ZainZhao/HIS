package com.neu.his.cloud.zuul.distribution.api.pc.dms;

import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.dto.dms.DmsMechanicItemRecordResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "his-cloud-api-pc")
public interface ApiPcDmsMechanicItemRecordDistributionService {

    @RequestMapping(value = "/DmsMechanicItemRecord/listByDept", method = RequestMethod.POST)
    CommonResult<List<DmsMechanicItemRecordResult>> listByDept(@RequestParam("deptId") Long deptId);

    @RequestMapping(value = "/DmsMechanicItemRecord/log", method = RequestMethod.POST)
    CommonResult log(@RequestParam("itemRecordId") Long itemRecordId, @RequestParam("logStaffId") Long logStaffId);

    @RequestMapping(value = "/DmsMechanicItemRecord/uploadResult", method = RequestMethod.POST)
    CommonResult uploadResult(@RequestParam("id") Long id,
                                     @RequestParam("executeStaffId") Long excuteStaffId,
                                     @RequestParam("checkResult") String checkResult,
                                     @RequestParam("resultImgUrlList") String resultImgUrlList);

}
