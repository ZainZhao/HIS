package com.neu.his.cloud.api.pc.dto.bms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@ToString
public class BmsInvoiceResult implements Serializable {
    @ApiModelProperty(value = "创建时间")
    Date createTime;
    @ApiModelProperty(value = "发票号")
    Long invoiceNo;
    @ApiModelProperty(value = "账单id")
    Long billId;
    @ApiModelProperty(value = "总金额")
    BigDecimal amount;
    @ApiModelProperty(value = "冻结状态")
    Integer freezeStatus;
    @ApiModelProperty(value = "关联发票id")
    Long associateId;
    @ApiModelProperty(value = "结算类型name")
    String settlementCatName;
    @ApiModelProperty(value = "对账人id")
    Long operatorSettleId;
    @ApiModelProperty(value = "日结人id")
    Long operatorId;
    @ApiModelProperty(value = "所属日结记录id")
    Long settleRecordId;


    @ApiModelProperty(value = "类型")
    Integer type;


}
