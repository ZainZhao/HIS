package com.neu.his.cloud.api.pc.service.dms;

import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsMechanicItemRecordResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient(value = "his-cloud-service-dms")
public interface DmsMechanicItemRecordService {


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
