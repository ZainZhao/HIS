package com.neu.his.cloud.zuul.dto.pms;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class PmsDiagnosisPatientResult  implements Serializable {
    @ApiModelProperty(value = "病人Id")
    Long patientId;
    @ApiModelProperty(value = "病人姓名")
    String patientName;
    @ApiModelProperty(value = "病人年龄")
    String patientAge;
    @ApiModelProperty(value = "病人家庭住址")
    String patientHomeAdress;
    @ApiModelProperty(value = "病人性别")
    Integer patientGender;
    @ApiModelProperty(value = "病人病历号")
    String patientMedicalRecordNo;
    @ApiModelProperty(value = "就诊号(挂号号)")
    Long registrationId;
    @ApiModelProperty(value = "就诊状态")
    Integer registrationStatus;
}
