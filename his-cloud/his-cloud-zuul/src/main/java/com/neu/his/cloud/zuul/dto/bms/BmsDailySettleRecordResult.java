package com.neu.his.cloud.zuul.dto.bms;

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
public class BmsDailySettleRecordResult  implements Serializable {

    @ApiModelProperty(value = "开始时间")
    Date startDatetime;
    @ApiModelProperty(value = "截止时间")
    Date endDatetime;
    @ApiModelProperty(value = "日结时间")
    Date createDatetime;
    @ApiModelProperty(value = "收银员（日结员）id")
    Long cashierId;
    @ApiModelProperty(value = "发票总数量")
    Long  invoiceNum;
    @ApiModelProperty(value = "冲红发票数量")
    Long rushInvoiceNum;
    @ApiModelProperty(value = "重打发票数量")
    Long reprintInvoiceNum;
    @ApiModelProperty(value = "起始结束发票id串")
    String startEndInvoiceIdStr;
    @ApiModelProperty(value = "冲红发票id list")
    String rushInvoiceIdListStr;
    @ApiModelProperty(value = "重打发票id list")
    String reprintInvoiceIdListStr;

    @ApiModelProperty(value = "成药总金额")
    BigDecimal medicineAmount;
    @ApiModelProperty(value = "草药总金额")
    BigDecimal herbalAmount;
    @ApiModelProperty(value = "检查总金额")
    BigDecimal checkAmount;
    @ApiModelProperty(value = "挂号总金额")
    BigDecimal registrationAmount;
    @ApiModelProperty(value = "处置总金额")
    BigDecimal dispositionAmount;
    @ApiModelProperty(value = "检验总金额")
    BigDecimal testAmount;
    @ApiModelProperty(value = "现金总金额")
    BigDecimal cashAmount;
    @ApiModelProperty(value = "总金额")
    BigDecimal amount;

    @ApiModelProperty(value = "医保总金额")
    BigDecimal insuranceAmount;
    @ApiModelProperty(value = "银行卡总金额")
    BigDecimal bankCardAmount;
    @ApiModelProperty(value = "支付宝总金额")
    BigDecimal  alipayAmount;
    @ApiModelProperty(value = "微信总金额")
    BigDecimal  wechatAmount;
    @ApiModelProperty(value = "银行卡总金额")
    BigDecimal  creditCardAmount;
    @ApiModelProperty(value = "其他总金额")
    BigDecimal otherAmount;

    @ApiModelProperty(value = "对账人id")
    Long  verifyOperatorId;
    @ApiModelProperty(value = "对账时间")
    Date verifyDatetime;
    @ApiModelProperty(value = "对账状态")
    Integer  verifyStatus;

}
