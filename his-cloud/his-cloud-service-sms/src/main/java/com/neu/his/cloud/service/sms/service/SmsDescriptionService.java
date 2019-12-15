package com.neu.his.cloud.service.sms.service;

import com.neu.his.cloud.service.sms.dto.app.AppDeptDescriptionResult;
import com.neu.his.cloud.service.sms.dto.app.AppDocSkdResult;
import com.neu.his.cloud.service.sms.dto.app.AppStaffDescriptionResult;

import java.util.List;

/**
 *  科室、医生描述信息
 */

public interface SmsDescriptionService {


    /**
     * 描述：查询员工描述信息
     */
    AppDocSkdResult getDetailById(Long theId);


    /**
     *  描述：根据id查询描述信息
     */
    List<AppStaffDescriptionResult> getDetailListByDept(Long id);


    /**
     * 描述：查询科室描述信息
     */
    List<AppDeptDescriptionResult> getDeptDescription();

}
