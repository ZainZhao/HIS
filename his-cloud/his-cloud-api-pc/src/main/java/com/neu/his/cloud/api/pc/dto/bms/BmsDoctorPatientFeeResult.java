package com.neu.his.cloud.api.pc.dto.bms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class BmsDoctorPatientFeeResult  implements Serializable {

    @ApiModelProperty(value = "项目名称")
    String itemName;
    @ApiModelProperty(value = "规格")
    String format;
    @ApiModelProperty(value = "当前数量")
    Long currentNum;
    @ApiModelProperty(value = "单价")
    BigDecimal price;
    @ApiModelProperty(value = "收费状态 0 未缴费 1已缴费")
    Integer chargeStatus;
    @ApiModelProperty(value = "状态 0作废（删除）1未缴费 2未登记（已缴费） 3已登记 4已执行 5已退费 6已过期")
    Integer status;
    @ApiModelProperty(value = "类型 0 挂号 1检查 2检验 3处置 4草药 5成药")
    Integer type;

}
