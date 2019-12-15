package com.neu.his.cloud.service.bms.dto.bms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class BmsSettleListItemResult  implements Serializable {

    @ApiModelProperty(value="收费员id")
    Long cashierId;
    @ApiModelProperty(value="收费员name")
   String  operatorName;
    @ApiModelProperty(value="日结日期")
    Date createDatetme;
    @ApiModelProperty(value="日结id")
    Long settleRecordId;
    @ApiModelProperty(value="对账状态 0 未对账 1 已对账")
    Integer verifyStatus;

}
