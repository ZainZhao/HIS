//package com.neu.his.cloud.zuul.service.sms.impl;
//
//import com.neu.his.cloud.zuul.ZuulApplication;
//import com.neu.his.cloud.zuul.dto.sms.SmsStaffParam;
//import com.neu.his.cloud.zuul.service.sms.SmsStaffService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Date;
//
///**
// * @author Zain
// * @title: SmsStaffServiceImplTest
// * @projectName his-cloud
// * @description: TODO
// * @date 2019/6/1714:57
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ZuulApplication.class)
//public class SmsStaffServiceImplTest {
//
//    @Autowired
//    SmsStaffService smsStaffService;
//
//    @Test
//    public void login() {
//        System.out.println(smsStaffService.login("test","test"));
//    }
//
//    @Test
//    public void register() {
//        SmsStaffParam smsStaffParam=new SmsStaffParam();
//        smsStaffParam.setName("zhaoyu");
//        smsStaffParam.setPassword("zhaoyu");
//        smsStaffParam.setCreateTime(new Date());
//        smsStaffService.register(smsStaffParam);
//    }
//}