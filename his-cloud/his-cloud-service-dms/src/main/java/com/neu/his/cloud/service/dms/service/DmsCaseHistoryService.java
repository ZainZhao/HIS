package com.neu.his.cloud.service.dms.service;

import com.neu.his.cloud.service.dms.dto.dms.DmsCaseHistoryParam;
import com.neu.his.cloud.service.dms.dto.dms.DmsCaseHistoryResult;


/**
 * 历史病例
 */
public interface DmsCaseHistoryService {
    /**
     * 描述：插入初诊信息
     */
    int insertPriliminaryDise(DmsCaseHistoryParam dmsCaseHistoryParam);
    /**
     * 描述：根据门诊号查询历史病历
     */
    DmsCaseHistoryResult selectCaseHistoryByReg(Long registrationId, Integer status);
    /**
     * 描述：提交门诊确诊信息
     */
    int submitDefiniteDise(DmsCaseHistoryParam dmsCaseHistoryParam);
    /**
     * 描述：诊毕
     */
    int endDiagnosis(DmsCaseHistoryParam dmsCaseHistoryParam);
}
