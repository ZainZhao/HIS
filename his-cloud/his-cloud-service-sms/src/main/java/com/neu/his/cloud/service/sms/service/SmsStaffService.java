package com.neu.his.cloud.service.sms.service;


import com.neu.his.cloud.service.sms.dto.sms.SmsStaffParam;
import com.neu.his.cloud.service.sms.dto.sms.SmsStaffResult;
import com.neu.his.cloud.service.sms.model.SmsStaff;

import java.util.List;

/**
 * 员工
 */
public interface SmsStaffService {

//    /**
//     * 描述：新增员工（弃用）
//     */
//    int create(SmsStaffParam smsStaffParam);

    /**
     * 描述：删除员工
     */
    int delete(List<Long> ids);

    /**
     * 描述：更新员工
     */
    int update(Long id, SmsStaffParam smsStaffParam);

    /**
     * 描述：查询员工
     */
    List<SmsStaffResult> select(SmsStaffParam smsStaffQueryParam, Integer pageSize, Integer pageNum);

    /**
     * 描述：列出所有员工
     */
    List<SmsStaffResult> selectAll();

    /**
     * 描述: 根据username查询员工(名字精确查询)
     */
    SmsStaff selectByUserName(String username);


//    /**
//     * 描述：登录
//     */
//    String login(String username, String password);


//    /**
//     * 描述：根据用户名和密码返回员工基础信息
//
//     */
//    SmsStaff getStaffByPwd(String username, String password);


    /**
     * 描述：根据部门选择员工
     */
    List<SmsStaffResult> getStaffByDept(Long deptId);


//    /**
//     * 描述：注册（替换create）
//     *
//     */
//    SmsStaff register(SmsStaffParam smsStaffParam);


    /**
     * 描述：根据科室id和挂号级别id查询员工
     */
    public List<SmsStaff> selectSkdStaff(Long deptId, Long registrationRankId);


}
