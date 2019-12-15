package com.neu.his.cloud.service.pms.service;


import com.neu.his.cloud.service.pms.dto.dms.DmsCaseHistoryResult;
import com.neu.his.cloud.service.pms.dto.pms.PmsDiagnosisPatientListResult;
import com.neu.his.cloud.service.pms.dto.pms.PmsPatientResult;

/**
 * 病人
 */
public interface PmsPatientService {
    /**
     * 描述：根据身份证号查询患者基本信息
     */
    PmsPatientResult selectPatientByIdNo(String identificationNo);
    /**
     * 描述：刷新患者信息
     */
    PmsDiagnosisPatientListResult refreshPatient(Long staffId);
    /**
     * 描述：绑定医生
     */
    int bindPatient(Long registrationId, Long staffId);
    /**
     * 描述：开始诊断
     */
    DmsCaseHistoryResult startDiagnosis(Long registrationId);
    /**
     * 描述：更新诊断状态
     */
    int updateDiagnosisStatus(Long registrationId, Integer status);
    /**
     * 描述：根据门诊号查询历史病历
     */
    DmsCaseHistoryResult selectCaseHistoryByPatient(Long registrationId);

    /**
     * 描述：病人app登录
     */
    PmsPatientResult patientLogin(String identificationNo, String medicalRecordNo);
}
