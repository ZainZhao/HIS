package com.neu.his.cloud.zuul.dto.pms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
public class PmsDrugStorePatientResult  implements Serializable {
    @ApiModelProperty(value = "处方Ids")
    List<Long> prescriptionIdList;
    @ApiModelProperty(value = "患者名")
    String patientName;
    @ApiModelProperty(value = "患者Id")
    Long patientId;
    @ApiModelProperty(value = "患者病历号")
    String medicalRecordNo;

}
