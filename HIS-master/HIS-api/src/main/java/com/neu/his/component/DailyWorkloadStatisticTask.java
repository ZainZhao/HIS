package com.neu.his.component;

import com.neu.his.sms.SmsWorkloadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

/**
 * 定时统计工作量
 */
@Component
public class DailyWorkloadStatisticTask {

    private Logger LOGGER = LoggerFactory.getLogger(DailyWorkloadStatisticTask.class);

    @Autowired
    private SmsWorkloadService smsWorkloadService;

    /**
     * 描述:每天00:05:00开始执行，统计前一天所有员工、科室工作量并插入数据库
     * <p>author: ma
     */
    @Scheduled(cron = "0 5 0 ? * *")
    private void dailyWorkloadStatistic(){
        LOGGER.info("开始每日统计：");
        //获取当前时间前一天
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        LOGGER.info("插入数据：" + smsWorkloadService.statistic(calendar.getTime()));
        LOGGER.info("统计结束---------------");
    }


}
