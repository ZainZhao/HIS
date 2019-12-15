package com.neu.his.cloud.service.sms.service;

import com.neu.his.cloud.service.sms.dto.sms.SmsWorkloadResult;

import java.util.Date;
import java.util.List;

/**
 * 工作量
 */
public interface SmsWorkloadService {

    /**
     * 描述：个人工作量统计
     */
    SmsWorkloadResult workloadPersonalStatistic(Long staffId, Date date);

    /**
     * 描述：个人工作量时间段查询
     */
    SmsWorkloadResult queryPersonalWorkloadPeriod(Long staffId, Date startDatetime, Date endDatetime);

    /**
     * 描述：统计某个科室某一天工作量（根据date直接判断是否存在）
     */
    SmsWorkloadResult workloadDeptStatistic(Long deptId, Date date);

    /**
     * 描述：统计某个科室工作量时间段的工作量（只有date，最后一天如果是今天则没有）
     */
    SmsWorkloadResult queryDeptWorkloadPeriod(Long deptId, Date startDatetime, Date endDatetime);

    /**
     * 描述：所有科室工作量分时间段统计
     */
    List<SmsWorkloadResult> queryDeptWorkloadList(Date startDatetime, Date endDatetime);

    /**
     * 描述：某个科室所有员工工作量分时间段统计
     */
    List<SmsWorkloadResult> queryDeptPersonalWorkloadList(Long deptId, Date startDatetime, Date endDatetime);

    /**
     * 描述：工作量插入
     */
    int insertWorkload(SmsWorkloadResult smsWorkLoadResult);

    /**
     * 描述：每日个人工作量统计插入
     */
    int dailyPersonalStatistic(Date date);

    /**
     * 描述：每日科室工作量统计插入
     */
    int dailyDeptStatistic(Date date);

    /**
     * 描述：每日统计插入
     */
    int statistic(Date date);


}
