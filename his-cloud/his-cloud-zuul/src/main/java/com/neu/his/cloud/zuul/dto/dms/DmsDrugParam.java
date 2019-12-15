package com.neu.his.cloud.zuul.dto.dms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class DmsDrugParam implements Serializable {
    @ApiModelProperty(value = "药品编码")
    private String code;
    @ApiModelProperty(value = "药品名称")
    private String name;
    @ApiModelProperty(value = "药品规格")
    private String format;
    @ApiModelProperty(value = "药品单价")
    private BigDecimal price;
    @ApiModelProperty(value = "包装单位")
    private String unit;
    @ApiModelProperty(value = "生产厂家")
    private String manufacturer;
    @ApiModelProperty(value = "药品剂型")
    private Long dosageId;
    @ApiModelProperty(value = "药品类型")
    private Long typeId;
    @ApiModelProperty(value = "拼音助记码")
    private String mnemonicCode;
    @ApiModelProperty(value = "创建时间")
    private Date createDate;
    @ApiModelProperty(value = "库存")
    private Long stock;
    @ApiModelProperty(value = "通用名")
    private String genericName;
    @ApiModelProperty(value = "状态")
    private Integer status;
}
