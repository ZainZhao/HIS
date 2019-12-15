package com.neu.his.dms.service;

import com.neu.his.common.dto.app.AppCheckTestResult;
import com.neu.his.common.dto.dms.DmsNonDrugItemRecordListParam;
import com.neu.his.common.dto.dms.DmsNonDrugItemRecordResult;

import java.util.List;

/**
 * 非药品项
 */
public interface DmsNonDrugItemRecordService {
    /**
     * 描述：开立项目
     */
    List<Long> apply(DmsNonDrugItemRecordListParam dmsNonDrugItemRecordListParam);
    /**
     * 描述：作废项目
     */
    int invalid(List<Long> ids);
    /**
     * 描述：刷新项目
     */
    List<DmsNonDrugItemRecordResult>  listByRegAndType(Long registrationId, Integer type);

    /**
     * 描述：app端根据检查检验id查询结果
     */
    AppCheckTestResult appGetResult(Long id);
}
