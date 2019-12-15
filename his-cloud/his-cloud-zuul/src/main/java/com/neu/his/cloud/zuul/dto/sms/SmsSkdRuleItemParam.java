package com.neu.his.cloud.zuul.dto.sms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class SmsSkdRuleItemParam  implements Serializable {
    @ApiModelProperty(value = "医生id")
    private Long staffId;
    @ApiModelProperty(value = "一周中的排班时间")
    private String daysOfWeek;
    @ApiModelProperty(value = "挂号限额")
    private Long skLimit;
}
