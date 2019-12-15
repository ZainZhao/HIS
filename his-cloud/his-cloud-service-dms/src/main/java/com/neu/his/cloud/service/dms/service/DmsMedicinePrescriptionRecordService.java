package com.neu.his.cloud.service.dms.service;

import com.neu.his.cloud.service.dms.dto.dms.DmsMedicinePrescriptionRecordParam;
import com.neu.his.cloud.service.dms.dto.dms.DmsMedicinePrescriptionRecordResult;

import java.util.List;

/**
 * 成药处方
 */
public interface DmsMedicinePrescriptionRecordService {

    /**
     * 描述：开立处方
     */
    Long apply(DmsMedicinePrescriptionRecordParam dmsMedicinePrescriptionRecordParam);

    /**
     * 描述：作废处方
     */
    int invalid(List<Long> ids);

    /**
     * 描述：根据门诊号查询处方
     */
    List<DmsMedicinePrescriptionRecordResult>  listByReg(Long registrationId);


    /**
     * 描述：根据处方ids查询处方详情
     */
    List<DmsMedicinePrescriptionRecordResult> listByIds(List<Long> ids);
}
