package com.neu.his.cloud.service.sms.service;

import com.neu.his.cloud.service.sms.dto.sms.SmsFrequentUsedResult;


/**
 * 常用项
 */
public interface SmsFrequentUsedService {

    /**
     * 描述：新增常用项
     */
    int addFrequent(Long staffId, int addType, Long addId);

    /**
     * 描述：删除常用项
     */
    int deleteFrequent(Long staffId, int deleteType, Long deleteId);

    /**
     * 描述：根据staffId和type查询常用项
     */
    SmsFrequentUsedResult selectFrequent(Long staffId, int selectType);




}
