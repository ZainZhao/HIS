package com.neu.his.bms.service;

import com.neu.his.common.dto.app.AppDrugItemResult;
import com.neu.his.common.dto.app.AppHistoryRegResult;
import com.neu.his.common.dto.bms.BmsDoctorPatientFeeResult;

import java.util.List;

/**
 * 费用查询
 */
public interface BmsFeeQueryService {

    /**
     * 描述：医生查患者费用（列出本次就诊所有小项目）：
     */
    List<BmsDoctorPatientFeeResult> listFeeByRegistrationId(Long registrationId);

    /**
     * 描述：根据患者id查大项
     */
    List<AppHistoryRegResult> listFeePrescription(Long registrationId);

    /**
     * 描述：根据处方单号和type（草药4，成药5）查小项
     */
    List<AppDrugItemResult> listFeeItem(Long prescriptionId , int type);
}
