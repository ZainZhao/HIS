package com.neu.his.sms;

import com.neu.his.common.dto.sms.*;
import com.neu.his.mbg.model.SmsSkdRuleItem;

import java.util.Date;
import java.util.List;

/**
 * 排班
 */
public interface SmsSkdService {

    /**
     * 描述：新增排班规则
     */
    int createRule(SmsSkdRuleParam smsSkdRuleParam);

    /**
     * 描述：删除排班规则
     */
    int deleteRule(List<Long> ids);

    /**
     * 描述：修改排班规则
     */
    int updateRule(Long id, SmsSkdRuleParam smsSkdRuleParam);

    /**
     * 描述：根据deptId查找规则（不包括规则项）
     */
    List<SmsSkdRuleResult> selectRuleByDept(Long deptId);


    /**
     * 描述：查询规则（查询规则项）
     */
    SmsSkdRuleResult getRuleDetail(Long ruleId);

    /**
     * 描述：生成排班
     */
    int generateSkd(List<Long> ruleIds, Date startDate, Date endDate);

    /**
     * 描述：查询排班记录
     */
    List<SmsSkdResult> listSkd(SmsSkdParam smsSkdParam);

    /**
     * 描述：根据skd查询doc
     */
    List<SmsSkdDocResult> listDocBySkd(SmsSkdDocParam smsSkdDocParam);

    /**
     * 描述: 根据科室id列出所有的能排班的员工
     * <p>author: 赵煜
     */
    List<SmsSkdRuleItemResult> listCanSkdStaffByDept(Long deptId);
}
