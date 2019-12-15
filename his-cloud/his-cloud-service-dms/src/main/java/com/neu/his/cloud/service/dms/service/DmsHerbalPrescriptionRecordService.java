package com.neu.his.cloud.service.dms.service;

import com.neu.his.cloud.service.dms.dto.dms.DmsHerbalPrescriptionRecordParam;
import com.neu.his.cloud.service.dms.dto.dms.DmsHerbalPrescriptionRecordResult;


import java.util.List;

/**
 * 草药处方
 */
public interface DmsHerbalPrescriptionRecordService {

    /**
     * 描述：开立处方
     */
    Long apply(DmsHerbalPrescriptionRecordParam dmsHerbalPrescriptionRecordParam);

    /**
     * 描述：作废处方
     */
    int invalid(List<Long> ids);

    /**
     * 描述：根据门诊号查询处方
     */
    List<DmsHerbalPrescriptionRecordResult>  listByReg(Long registrationId);


    /**
     * 描述：根据处方ids查询处方详情
     */
    List<DmsHerbalPrescriptionRecordResult> listByIds(List<Long> ids);
}
