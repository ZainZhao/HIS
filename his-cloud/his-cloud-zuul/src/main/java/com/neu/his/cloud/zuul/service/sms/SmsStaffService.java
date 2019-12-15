package com.neu.his.cloud.zuul.service.sms;

import com.neu.his.cloud.zuul.dto.sms.SmsStaffParam;
import com.neu.his.cloud.zuul.model.SmsStaff;

public interface SmsStaffService {

    /**
     * 描述: 根据username查询员工(名字精确查询)
     * <p>author: 赵煜
     */
    SmsStaff selectByUserName(String username);

    String test();

    /**
     * 描述：登录功能
     * <p>author: 赵煜
     * <p>return 生成的JWT的token
     */
    String login(String username, String password);


    /**
     * 描述：注册功能 ---替换create
     */
    SmsStaff register(SmsStaffParam smsStaffParam);


}
