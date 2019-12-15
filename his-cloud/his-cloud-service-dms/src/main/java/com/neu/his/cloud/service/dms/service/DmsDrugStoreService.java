package com.neu.his.cloud.service.dms.service;

import com.neu.his.cloud.service.dms.dto.dms.DmsRefundDrugListParam;
import com.neu.his.cloud.service.dms.dto.pms.PmsDrugStorePatientListResult;


import java.util.Date;

/**
 * 药房
 */
public interface DmsDrugStoreService {

    /**
     * 描述：列出患者
     */
    PmsDrugStorePatientListResult listPatient(Date date, String medicalRecordNo, Integer type);

    /**
     * 描述：发药
     */
    int releaseDrug(Long prescriptionId, Integer type);

    /**
     * 描述：退药
     */
    int refundDrug(DmsRefundDrugListParam dmsRefundDrugListParam);

}
