package com.neu.his.cloud.service.pms.dto.pms;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class PmsDrugStorePatientResult {
    @ApiModelProperty(value = "处方Ids")
    List<Long> prescriptionIdList;
    @ApiModelProperty(value = "患者名")
    String patientName;
    @ApiModelProperty(value = "患者Id")
    Long patientId;
    @ApiModelProperty(value = "患者病历号")
    String medicalRecordNo;

}
