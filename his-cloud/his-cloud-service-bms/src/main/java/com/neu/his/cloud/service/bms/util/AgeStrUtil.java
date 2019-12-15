package com.neu.his.cloud.service.bms.util;

import java.util.Calendar;
import java.util.Date;

public class AgeStrUtil {
    public static String getAgeStr(Date dateOfBirth){
        Calendar calendar = Calendar.getInstance();//传入时间
        calendar.setTime(dateOfBirth);
        //System.out.println("calendar.getTime():"+calendar.getTime());
        Long time = calendar.getTimeInMillis();
        //System.out.println("time:"+time);
        Calendar calendar1 = Calendar.getInstance();//当前时间
        Long time1 = calendar1.getTimeInMillis();
        //System.out.println("time1:"+time1);
        Long betweenDays = (time1-time)/(1000*60*60*24);
        //System.out.println("betweenDays:"+betweenDays);
        if ((betweenDays/365) >=3 ){//如果大于等于3，返回例如5岁
            Long age = betweenDays/365;
            return age + "岁";
        }
        else if(betweenDays > 100 && (betweenDays/365) < 3){//如果大于100天，小于三岁，返回例如2岁3个月{
            Long year = betweenDays/365;//年
            Long restDays = betweenDays%365;//模365剩余的天数
            Long month = restDays/30 + 1;
            return year + "岁" + month + "个月";
        }
        else {
            return betweenDays + "天";
        }
    }

    public static void main(String[] args) {
        System.out.println(getAgeStr(new Date()));
        Date date = new Date(119,0,1);//year是从1990开始算的
        System.out.println(getAgeStr(date));
}
}
