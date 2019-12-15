package com.neu.his.cloud.zuul.distribution.api.pc.sms;


import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.dto.sms.SmsWorkloadResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@FeignClient(value = "his-cloud-api-pc")
public interface ApiPcSmsWorkloadDistributionService {

    @RequestMapping(value = "/workload/queryPersonal", method = RequestMethod.POST)
    CommonResult<SmsWorkloadResult> queryPersonalWorkload(@RequestParam("staffId") Long staffId,
                                                                 @RequestParam("startDatetime")String startDatetime,
                                                                 @RequestParam("endDatetime")String  endDatetime);

    @RequestMapping(value = "/workload/queryDept", method = RequestMethod.POST)
    CommonResult<SmsWorkloadResult>  queryDeptWorkload(@RequestParam("deptId") Long deptId,
                                                              @RequestParam("startDatetime")String startDatetime,
                                                              @RequestParam("endDatetime")String endDatetime);

    @RequestMapping(value = "/workload/queryDeptWorkloadList", method = RequestMethod.POST)
    CommonResult<List<SmsWorkloadResult>> queryDeptWorkloadList(@RequestParam("startDatetime")String startDatetime,
                                                                        @RequestParam("endDatetime")String endDatetime);

    @RequestMapping(value = "/workload/queryDeptPersonalWorkloadList", method = RequestMethod.POST)
    CommonResult<List<SmsWorkloadResult>>  queryDeptPersonalWorkloadList(@RequestParam("deptId") Long deptId,
                                                                                @RequestParam("startDatetime")String startDatetime,
                                                                                @RequestParam("endDatetime") String endDatetime);
}
