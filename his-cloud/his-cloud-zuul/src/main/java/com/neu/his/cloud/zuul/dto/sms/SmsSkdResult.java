package com.neu.his.cloud.zuul.dto.sms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
public class SmsSkdResult  implements Serializable {
    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "医生name")
    private String staffName;
//    @ApiModelProperty(value = "起始时间")
//    private Date startDate;
//    @ApiModelProperty(value = "截止时间")
//    private Date endDate;
@ApiModelProperty(value = "时间")
    private Date date;

    @ApiModelProperty(value = "午别")
    private Integer noon;
    @ApiModelProperty(value = "科室名")
    private String deptName;
    @ApiModelProperty(value = "排班限额")
    private Long skLimit;
    @ApiModelProperty(value = "挂号级别")
    private String registrationRank;

    //20190625 马
    @ApiModelProperty(value = "剩余号数")
    private Long remain;
}
