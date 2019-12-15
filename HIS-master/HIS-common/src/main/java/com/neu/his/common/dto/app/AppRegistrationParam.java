package com.neu.his.common.dto.app;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class AppRegistrationParam {

    @ApiModelProperty(value = "排班id")
    private Long skdId;
    @ApiModelProperty(value = "科室id")
    private Long deptId;
    @ApiModelProperty(value = "就诊日期")
    private Date attendanceDate;

    @ApiModelProperty(value = "患者ID")
    private Long patientId;

}
