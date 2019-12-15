package com.neu.his.cloud.service.sms.service;


import com.neu.his.cloud.service.sms.dto.sms.SmsRegistrationRankParam;
import com.neu.his.cloud.service.sms.dto.sms.SmsRegistrationRankResult;

import java.util.List;

/**
 * 挂号级别
 */
public interface SmsRegistrationRankService {

    /**
     * 描述：新增挂号级别
     */
    int create(SmsRegistrationRankParam smsRegistrationRankParam);

    /**
     * 描述：删除挂号级别（批量）
     */
    public int delete(List<Long> ids);

    /**
     * 描述：更新挂号级别
     */
    int update(Long id, SmsRegistrationRankParam smsRegistrationRankParam);

    /**
     * 描述：查询挂号级别
     */
    List<SmsRegistrationRankResult> select(SmsRegistrationRankParam smsRegistrationRankParam);

    /**
     * 描述：列出所有挂号级别
     */
    List<SmsRegistrationRankResult> selectAll();
}
