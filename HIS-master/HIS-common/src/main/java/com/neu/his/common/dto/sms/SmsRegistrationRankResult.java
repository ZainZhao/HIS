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
public class SmsRegistrationRankResult  implements Serializable {
    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "号别编码")
    private String code;
    @ApiModelProperty(value = "号别名称")
    private String name;
    @ApiModelProperty(value = "挂号费")
    private BigDecimal price;
    @ApiModelProperty(value = "显示顺序号")
    private Long seqNo;
    @ApiModelProperty(value = "状态：0->无效;1->有效")
    private Integer status;
}
