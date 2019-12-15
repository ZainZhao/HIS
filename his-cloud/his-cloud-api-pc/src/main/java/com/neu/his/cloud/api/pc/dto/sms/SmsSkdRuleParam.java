package com.neu.his.cloud.api.pc.dto.sms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
public class SmsSkdRuleParam  implements Serializable {
    @ApiModelProperty(value = "操作人id")
    private Long operatorId;
    @ApiModelProperty(value = "规则名")
    private String ruleName;
    @ApiModelProperty(value = "描述")
    private String description;
    @ApiModelProperty(value = "科室id")
    private Long deptId;
    @ApiModelProperty(value = "排班项")
    private List<SmsSkdRuleItemParam> smsSkdRuleItemParamList;


}
