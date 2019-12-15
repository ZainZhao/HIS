package com.neu.his.cloud.zuul.distribution.api.pc.sms;



import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.dto.sms.SmsDeptAmountStatisticsResult;
import com.neu.his.cloud.zuul.dto.sms.SmsPatientsStatisticsResult;
import com.neu.his.cloud.zuul.dto.sms.SmsStaffAmountStatisticsResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "his-cloud-api-pc")
public interface ApiPcSmsEchartsDistributionService {
    @RequestMapping(value = "/charts/staffPatients", method = RequestMethod.GET)
    CommonResult<SmsPatientsStatisticsResult> staffPatients(@RequestParam Long staffId);


    @RequestMapping(value = "/charts/staffClassifyStatistics", method = RequestMethod.GET)
    CommonResult<SmsStaffAmountStatisticsResult> staffClassifyStatistics(@RequestParam Long staffId) ;


    @RequestMapping(value = "/charts/deptPatients", method = RequestMethod.GET)
    CommonResult<SmsPatientsStatisticsResult> deptPatients(@RequestParam Long deptId);

    @RequestMapping(value = "/charts/deptClassifyStatistics", method = RequestMethod.GET)
    CommonResult<SmsDeptAmountStatisticsResult> deptClassifyStatistics(@RequestParam Long deptId);


    @RequestMapping(value = "/charts/totalClassifyStatistics", method = RequestMethod.GET)
    CommonResult<SmsDeptAmountStatisticsResult> totalClassifyStatistics();


    @RequestMapping(value = "/charts/totalPatients", method = RequestMethod.GET)
    CommonResult<SmsPatientsStatisticsResult> totalPatients() ;
}
