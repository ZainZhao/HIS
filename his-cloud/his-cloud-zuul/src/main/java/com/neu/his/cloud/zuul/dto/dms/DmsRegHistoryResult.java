package com.neu.his.cloud.zuul.dto.dms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
public class DmsRegHistoryResult  implements Serializable {
    @ApiModelProperty(value = "挂号时间：哪天挂的号")
    Date createTime;
    @ApiModelProperty(value = "就诊时间：挂的哪天号")
    Date attendanceDate;
    @ApiModelProperty(value = "挂号（门诊）id")
    Long registrationId;
    @ApiModelProperty(value = "status 0删除 1待诊  2诊中  3诊毕  4退号 5过期  ")
    Integer status;
    @ApiModelProperty(value = "科室名称")
    String deptName;
    @ApiModelProperty(value = "就诊年龄")
    String patientAgeStr;
    @ApiModelProperty(value = "绑定状态")
    Integer bindStatus;
    @ApiModelProperty(value = "看诊医生")
    String doctorName;
    @ApiModelProperty(value = "挂号级别name")
    String registrationName;


}
