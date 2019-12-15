package com.neu.his.cloud.zuul.dto.sms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString

public class SmsSkdRuleResult  implements Serializable {
    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "状态")
    private Integer status;
    @ApiModelProperty(value = "操作人id")
    private Long operatorId;

    @ApiModelProperty(value = "操作时间")
    private Date operateTime;
    @ApiModelProperty(value = "规则名")
    private String ruleName;
    @ApiModelProperty(value = "描述")
    private String description;
    @ApiModelProperty(value = "科室id")
    private Long deptId;
    @ApiModelProperty(value = "科室name")
    private String deptName;
    @ApiModelProperty(value = "排班项")
    private List<SmsSkdRuleItemResult> smsSkdRuleItemResultList;

    @ApiModelProperty(value = "操作员姓名")
    private String operatorName;


}
