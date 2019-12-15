package com.neu.his.common.dto.app;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class AppDrugItemResult {

    @ApiModelProperty(value = "药品名称")
    String drugName;
    @ApiModelProperty(value = "规格")
    String format;
    @ApiModelProperty(value = "当前数量")
    Long currentNum;
    @ApiModelProperty(value = "单价")
    BigDecimal price;
    @ApiModelProperty(value = "状态 0作废（删除）1未发药 2已发药 3退药")
    Integer status;

}
