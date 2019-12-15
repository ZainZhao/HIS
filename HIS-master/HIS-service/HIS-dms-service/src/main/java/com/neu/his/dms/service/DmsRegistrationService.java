package com.neu.his.dms.service;

import com.neu.his.common.dto.app.AppRegistrationParam;
import com.neu.his.common.dto.dms.DmsRegHistoryResult;
import com.neu.his.common.dto.dms.DmsRegistrationParam;

import java.util.List;

/**
 * 挂号
 */
public interface DmsRegistrationService {
    /**
     * 描述：挂号
     */
    int createRegistration(DmsRegistrationParam dmsRegistrationParam);
    /**
     * 描述：根据身份证号查询历史挂号记录
     */
    List<DmsRegHistoryResult> listRegHistory(String identificationNo);

    /**
     * 描述:app挂号
     * 1.先根据skd_id判断remain是否>0
     * 2.如果大于0，绑定医生（skd_id、bind_status=1）,并修改sms_skd中的排班限额（-1）
     * 3.向dms_registration插入信息
     * 4.向bms_bills_record中插入账单记录
     */
    int appRegistration(AppRegistrationParam appRegistrationParam);
}
