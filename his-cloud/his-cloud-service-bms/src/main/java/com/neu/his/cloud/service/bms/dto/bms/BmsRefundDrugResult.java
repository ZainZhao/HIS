package com.neu.his.cloud.service.bms.dto.bms;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class BmsRefundDrugResult  implements Serializable {
    @ApiModelProperty(value = "药品名")
    String name;
    @ApiModelProperty(value = "当前药品数量")
    Long currentNum;
    @ApiModelProperty(value = "已退药数量")
    Long refundNum;
    @ApiModelProperty(value = "单位")
    Integer numUnit;
    @ApiModelProperty(value = "单价")
    BigDecimal price;
    @ApiModelProperty(value = "类型 0 成药 1草药")
    Integer type;


}
