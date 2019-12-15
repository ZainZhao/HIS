package com.neu.his.cloud.service.bms.dto.bms;


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
public class BmsChargeResult  implements Serializable {

    @ApiModelProperty(value = "缴费项id")
    Long id;
    @ApiModelProperty(value = "缴费项名称")
    String name;
    @ApiModelProperty(value = "总金额")
    BigDecimal amount;
    @ApiModelProperty(value = "类型：0 挂号 1检查 2检验 3处置 4草药 5 成药")
    Integer type;
    @ApiModelProperty(value = "状态")
    Integer status;
    @ApiModelProperty(value = "开立时间")
    Date createTime;

}
