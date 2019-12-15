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
public class BmsRefundChargeParam  implements Serializable {
    @ApiModelProperty(value = "退费项目id")
    Long chargeItemId;
    @ApiModelProperty(value = "退费项目类型")
    Integer type;
    @ApiModelProperty(value = "发票号")
    Long invoiceNo;
    @ApiModelProperty(value = "操作人id")
    Long operatorId;
    @ApiModelProperty(value = "退款金额")
    BigDecimal refundAmount;
    /*
    wang
     */
    @ApiModelProperty(value = "冲红发票号")
    Long redInvoiceNo;
    @ApiModelProperty(value = "新发票号")
    Long newInvoiceNo;
    @ApiModelProperty(value = "结算类型")
    Long settlementCatId;
}
