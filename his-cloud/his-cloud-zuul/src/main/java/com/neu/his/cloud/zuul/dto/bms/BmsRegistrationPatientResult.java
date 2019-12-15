package com.neu.his.cloud.zuul.dto.bms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
public class BmsRegistrationPatientResult  implements Serializable {
    @ApiModelProperty(value = "门诊（挂号）状态 0删除 1待诊  2诊中  3诊毕  4退号 5过期")
    Integer registrationStatus;
    @ApiModelProperty(value = "病人姓名")
    String patientName;
    @ApiModelProperty(value = "病人性别")
    Integer patientGender;
    @ApiModelProperty(value = "病人生日")
    Date patientDateOfBirth;
    @ApiModelProperty(value = "就诊日期")
    Date attendanceDate;
    @ApiModelProperty(value = "挂号日期")
    Date registrationCreateDate;
    @ApiModelProperty(value = "挂号级别name")
    String registrationRankName;
    @ApiModelProperty(value = "是否收取病历本")
    Integer needBook;
    @ApiModelProperty(value = "看诊科室")
    String deptName;
    @ApiModelProperty(value = "看诊医生")
    String bindDoctorName;
    @ApiModelProperty(value = "病历号")
    String medicalRecordNo;
    @ApiModelProperty(value = "门诊号，挂号号")
    Long registrationId;


}
