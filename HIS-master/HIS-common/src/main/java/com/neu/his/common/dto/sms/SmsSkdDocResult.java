package com.neu.his.common.dto.sms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class SmsSkdDocResult  implements Serializable {

    @ApiModelProperty(value = "医生姓名")
    private String name;
    @ApiModelProperty(value = "排班id")
    private Long skdId;
    @ApiModelProperty(value = "挂号费")
    private BigDecimal amount;


}
