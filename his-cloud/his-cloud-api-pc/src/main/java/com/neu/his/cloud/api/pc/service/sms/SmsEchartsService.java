package com.neu.his.cloud.api.pc.service.sms;


;
import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.sms.SmsDeptAmountStatisticsResult;
import com.neu.his.cloud.api.pc.dto.sms.SmsPatientsStatisticsResult;
import com.neu.his.cloud.api.pc.dto.sms.SmsStaffAmountStatisticsResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * echarts数据统计
 */
@FeignClient(value = "his-cloud-service-sms")
public interface SmsEchartsService {
    /**
     * 描述：统计个人每日接待患者人数（近7日）
     */
    @RequestMapping(value = "/charts/staffPatients", method = RequestMethod.GET)
     CommonResult<SmsPatientsStatisticsResult> staffPatients(@RequestParam Long staffId) ;
    /**
     * 描述：统计各人每日分类收费信息（近7日）
     */
    @RequestMapping(value = "/charts/staffClassifyStatistics", method = RequestMethod.GET)
     CommonResult<SmsStaffAmountStatisticsResult> staffClassifyStatistics(@RequestParam Long staffId) ;
    /**
     * 描述：统计各科室每日接待患者人数（近7日）
     */
    @RequestMapping(value = "/charts/deptPatients", method = RequestMethod.GET)
     CommonResult<SmsPatientsStatisticsResult> deptPatients(@RequestParam Long deptId);
    /**
     * 描述：统计各科室每日分类收费信息（近7日）
     */
    @RequestMapping(value = "/charts/deptClassifyStatistics", method = RequestMethod.GET)
     CommonResult<SmsDeptAmountStatisticsResult> deptClassifyStatistics(@RequestParam Long deptId);
    /**
     * 描述：统计全院每日接待患者人数（近7日）
     */
    @RequestMapping(value = "/charts/totalClassifyStatistics", method = RequestMethod.GET)
     CommonResult<SmsDeptAmountStatisticsResult> totalClassifyStatistics() ;
    /**
     * 描述：统计全院每日分类收费信息（近7日）
     */
    @RequestMapping(value = "/charts/totalPatients", method = RequestMethod.GET)
     CommonResult<SmsPatientsStatisticsResult> totalPatients();
}
