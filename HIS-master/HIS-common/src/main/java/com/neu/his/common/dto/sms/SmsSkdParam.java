package com.neu.his.common.dto.sms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
public class SmsSkdParam  implements Serializable {

    @ApiModelProperty(value = "医生id")
    private Long staffId;
    @ApiModelProperty(value = "起始时间")
    private Date startDate;
    @ApiModelProperty(value = "截止时间")
    private Date endDate;
    @ApiModelProperty(value = "午别")
    private Integer noon;
    @ApiModelProperty(value = "科室id")
    private Long deptId;
    @ApiModelProperty(value = "挂号级别id")
    private Long registrationRankId;
}
