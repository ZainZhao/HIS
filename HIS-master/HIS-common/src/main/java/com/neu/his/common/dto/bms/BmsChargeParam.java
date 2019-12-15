package com.neu.his.common.dto.bms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class BmsChargeParam  implements Serializable {
    @ApiModelProperty(value = "收费项目id")
    Long chargeItemId;
    @ApiModelProperty(value = "收费项目类型")
    Integer type;
    @ApiModelProperty(value = "结算类型")
    Long settlementCatId;
    @ApiModelProperty(value = "发票号")
    Long invoiceNo;
    @ApiModelProperty(value = "操作人id")
    Long operatorId;
    @ApiModelProperty(value = "总金额")
    BigDecimal amount;



}
