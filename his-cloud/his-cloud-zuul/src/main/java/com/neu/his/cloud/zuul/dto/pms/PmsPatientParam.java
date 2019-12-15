package com.neu.his.cloud.zuul.dto.pms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
public class PmsPatientParam  implements Serializable {
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "出生日期")
    private Date dateOfBirth;
    @ApiModelProperty(value = "身份证号")
    private String identificationNo;
    @ApiModelProperty(value = "家庭住址")
    private String homeAddress;
    @ApiModelProperty(value = "电话号码")
    private String phoneNo;
    @ApiModelProperty(value = "性别")
    private Integer gender;
    @ApiModelProperty(value = "病历号")
    private String medicalRecordNo;
}
