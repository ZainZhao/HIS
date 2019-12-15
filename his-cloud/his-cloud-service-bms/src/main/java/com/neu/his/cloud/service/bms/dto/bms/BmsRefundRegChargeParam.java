package com.neu.his.cloud.service.bms.dto.bms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class BmsRefundRegChargeParam  implements Serializable {
    @ApiModelProperty(value = "挂号id")
    Long registrationId;
    @ApiModelProperty(value = "原发票号")
    Long oldInvoiceNo;
    @ApiModelProperty(value = "冲红发票号")
    Long redInvoiceNo;
    @ApiModelProperty(value = "操作人id")
    Long operatorId;
}
