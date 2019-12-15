package com.neu.his.cloud.zuul.controller.sms;



import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.distribution.api.pc.sms.ApiPcSmsEchartsDistributionService;
import com.neu.his.cloud.zuul.dto.sms.SmsDeptAmountStatisticsResult;
import com.neu.his.cloud.zuul.dto.sms.SmsPatientsStatisticsResult;
import com.neu.his.cloud.zuul.dto.sms.SmsStaffAmountStatisticsResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "SmsEchartsDistributionController", description = "图表统计")
@RequestMapping("/charts")
@CrossOrigin(allowCredentials = "true")
public class SmsEchartsDistributionController {
    @Autowired
    private ApiPcSmsEchartsDistributionService apiPcSmsEchartsDistributionService;

    @HystrixCommand(fallbackMethod = "staffPatientsFallbackInfo")
    @ApiOperation(value = "统计个人每日接待患者人数（近7日）")
    @RequestMapping(value = "/staffPatients", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<SmsPatientsStatisticsResult> staffPatients(@RequestParam Long staffId) {
       return apiPcSmsEchartsDistributionService.staffPatients(staffId);
    }
    private CommonResult<SmsPatientsStatisticsResult> staffPatientsFallbackInfo(Long staffId) {
        return CommonResult.success(null,"请检查您的网络") ;
    }


    @HystrixCommand(fallbackMethod = "staffClassifyStatisticsFallbackInfo")
    @ApiOperation(value = "统计个人每日分类收费信息（近7日）")
    @RequestMapping(value = "/staffClassifyStatistics", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<SmsStaffAmountStatisticsResult> staffClassifyStatistics(@RequestParam Long staffId) {
        return  apiPcSmsEchartsDistributionService.staffClassifyStatistics(staffId);
    }
    private CommonResult<SmsStaffAmountStatisticsResult> staffClassifyStatisticsFallbackInfo(Long staffId) {
        return CommonResult.success(null,"请检查您的网络") ;
    }


    @HystrixCommand(fallbackMethod = "deptPatientsFallbackInfo")
    @ApiOperation(value = "统计各科室每日接待患者人数（近7日）")
    @RequestMapping(value = "/deptPatients", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<SmsPatientsStatisticsResult> deptPatients(@RequestParam Long deptId) {
       return  apiPcSmsEchartsDistributionService.deptPatients(deptId);
    }
    private CommonResult<SmsPatientsStatisticsResult> deptPatientsFallbackInfo(Long deptId) {
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "deptClassifyStatisticsFallbackInfo")
    @ApiOperation(value = "统计各科室每日分类收费信息（近7日）")
    @RequestMapping(value = "/deptClassifyStatistics", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<SmsDeptAmountStatisticsResult> deptClassifyStatistics(@RequestParam Long deptId) {
        return  apiPcSmsEchartsDistributionService.deptClassifyStatistics(deptId);
    }
    private CommonResult<SmsDeptAmountStatisticsResult> deptClassifyStatisticsFallbackInfo(Long deptId) {
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "deptClassifyStatisticsFallbackInfo")
    @ApiOperation(value = "统计全院每日接待患者人数（近7日）")
    @RequestMapping(value = "/totalClassifyStatistics", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<SmsDeptAmountStatisticsResult> totalClassifyStatistics() {
       return  apiPcSmsEchartsDistributionService.totalClassifyStatistics();
    }
    private CommonResult<SmsDeptAmountStatisticsResult> deptClassifyStatisticsFallbackInfo() {
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "totalPatientsFallbackInfo")
    @ApiOperation(value = "统计全院每日分类收费信息（近7日）")
    @RequestMapping(value = "/totalPatients", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<SmsPatientsStatisticsResult> totalPatients() {
      return apiPcSmsEchartsDistributionService.totalPatients();
    }
    private CommonResult<SmsPatientsStatisticsResult> totalPatientsFallbackInfo() {
        return CommonResult.success(null,"请检查您的网络") ;
    }
}
