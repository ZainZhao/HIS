package com.neu.his.cloud.service.pms.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期工具类
 */
public class DateUtil {
    /**
     * 修改Date类型的时间中毫秒
     */
    public static Date setMilliSecond(Date date,Integer milliSecond) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MILLISECOND,milliSecond);
        return calendar.getTime();
    }
    /**
     * 得到几天前的时间
     */
    public static Date getDateBefore(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - day);
        return calendar.getTime();
    }
    /**
     * 计算日期差
     */
    public static Integer getDateSubtraction(Date startDate, Date endDate) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(startDate);
        calendar2.setTime(endDate);
        int start = calendar1.get(Calendar.DATE);
        int end = calendar2.get(Calendar.DATE);
        return (end - start);
    }
    /**
     * 将Date类型的时间中设置为今天23.59.59
     */
    public static Date getEndOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 从Date类型的时间中提取日期部分
     */
    public static Date getDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 从Date类型的时间中提取时间部分
     * <p>author:赵煜
     */
    public static Date getTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.YEAR, 1970);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 从Date类型的时间中提取日期串
     * 8位
     * <p>author:赵煜
     */
    public static String getDateStr(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String year = calendar.get(calendar.YEAR)+"";
        String  month = calendar.get(calendar.MONTH)+1>9 ? calendar.get(calendar.MONTH)+1+"" :"0"+(calendar.get(calendar.MONTH)+1);
        String  day =  calendar.get(calendar.DAY_OF_MONTH)>9 ?  calendar.get(calendar.DAY_OF_MONTH)+"" :"0"+ calendar.get(calendar.DAY_OF_MONTH);
        String dateStr = year+month+day;
        return dateStr;
    }

    /**
     * 从Date类型的时间中提取时间串
     * 6位
     * <p>author:赵煜
     *
     */
    public static String getTimeStr(Date date,int length) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String hour = calendar.get(calendar.HOUR_OF_DAY)>9?calendar.get(calendar.HOUR_OF_DAY)+"":"0"+calendar.get(calendar.HOUR_OF_DAY);
        String  minute = calendar.get(calendar.MINUTE)>9?calendar.get(calendar.MINUTE)+"":"0"+calendar.get(calendar.MINUTE);
        String  second =  calendar.get(calendar.SECOND)>9?calendar.get(calendar.SECOND)+"":"0"+calendar.get(calendar.SECOND);
        String timeStr = hour+minute+second;

        //长度大于串的长度，则默认返回整个串
        return timeStr.substring(0,length>timeStr.length()?timeStr.length():length);
    }


    public static void main(String[] args) {
        //System.out.println( getTimeStr(new Date(),100));
        List<Integer> integers = new ArrayList<>(3);
        for (int i = 0 ;i<3;i++){
            integers.add(i);
        }
        integers.set(0,100);
        integers.set(1,null);
        System.out.println(integers.get(0));
        System.out.println(integers.get(1) == null);
        System.out.println(getDateSubtraction(DateUtil.getDateBefore(new Date(),7),new Date()));
    }


}
