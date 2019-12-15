package com.neu.his.sms;

import com.neu.his.common.dto.app.AppDeptDescriptionResult;
import com.neu.his.common.dto.app.AppDocSkdResult;
import com.neu.his.common.dto.app.AppStaffDescriptionResult;
import com.neu.his.mbg.model.SmsDescription;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

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
    List<AppStaffDescriptionResult> getDetailListByDept(Long id );


    /**
     * 描述：查询科室描述信息
     */
    List<AppDeptDescriptionResult> getDeptDescription();

}
