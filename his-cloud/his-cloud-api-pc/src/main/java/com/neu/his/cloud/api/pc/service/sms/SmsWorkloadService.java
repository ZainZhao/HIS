package com.neu.his.cloud.api.pc.service.sms;

import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.sms.SmsWorkloadResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * 工作量
 */
@FeignClient(value = "his-cloud-service-sms")
public interface SmsWorkloadService {

    @RequestMapping(value = "/workload/queryPersonal", method = RequestMethod.POST)
    CommonResult<SmsWorkloadResult> queryPersonalWorkload(@RequestParam("staffId") Long staffId,
                                                                 @RequestParam("startDatetime") String startDatetime,
                                                                 @RequestParam("endDatetime")String endDatetime);


    @RequestMapping(value = "/workload/queryDept", method = RequestMethod.POST)
    CommonResult<SmsWorkloadResult>  queryDeptWorkload(@RequestParam("deptId") Long deptId,
                                                              @RequestParam("startDatetime")String startDatetime,
                                                              @RequestParam("endDatetime") String endDatetime);



    @RequestMapping(value = "/workload/queryDeptWorkloadList", method = RequestMethod.POST)
    CommonResult<List<SmsWorkloadResult>> queryDeptWorkloadList(@RequestParam("startDatetime") String startDatetime,
                                                                       @RequestParam("endDatetime")String endDatetime);



    @RequestMapping(value = "/workload/queryDeptPersonalWorkloadList", method = RequestMethod.POST)
    CommonResult<List<SmsWorkloadResult>>  queryDeptPersonalWorkloadList(@RequestParam("deptId") Long deptId,
                                                                                @RequestParam("startDatetime") String startDatetime,
                                                                                @RequestParam("endDatetime")String endDatetime);
}
