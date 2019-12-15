package com.neu.his.cloud.service.dms.dto.dms;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class DmsRegistrationResult  implements Serializable {
    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "患者id")
    private Long patientId;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "诊断状态")
    private Integer endAttendance;
    @ApiModelProperty(value = "状态")
    private Integer status;
    @ApiModelProperty(value = "排班id")
    private Long skdId;
    @ApiModelProperty(value = "是否需要病历本")
    private Integer needBook;
    @ApiModelProperty(value = "师生绑定状态")
    private Integer bindStatus;
    @ApiModelProperty(value = "科室id")
    private Long deptId;
    @ApiModelProperty(value = "就诊日期")
    private Date attendanceDate;

}
