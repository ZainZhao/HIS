package com.neu.his.sms;


import com.neu.his.common.dto.sms.SmsDeptAmountStatisticsResult;
import com.neu.his.common.dto.sms.SmsStaffAmountStatisticsResult;
import com.neu.his.common.dto.sms.SmsPatientsStatisticsResult;


/**
 * echarts数据统计
 */
public interface SmsEchartsService {
    /**
     * 描述：统计个人每日接待患者人数（近7日）
     */
    SmsPatientsStatisticsResult staffPatients(Long staffId);
    /**
     * 描述：统计各人每日分类收费信息（近7日）
     */
    SmsStaffAmountStatisticsResult staffClassifyStatistics(Long staffId);
    /**
     * 描述：统计各科室每日接待患者人数（近7日）
     */
    SmsPatientsStatisticsResult deptPatients(Long deptId);
    /**
     * 描述：统计各科室每日分类收费信息（近7日）
     */
    SmsDeptAmountStatisticsResult deptClassifyStatistics(Long deptId);
    /**
     * 描述：统计全院每日接待患者人数（近7日）
     */
    SmsDeptAmountStatisticsResult totalClassifyStatistics();
    /**
     * 描述：统计全院每日分类收费信息（近7日）
     */
    SmsPatientsStatisticsResult totalPatients();
}
