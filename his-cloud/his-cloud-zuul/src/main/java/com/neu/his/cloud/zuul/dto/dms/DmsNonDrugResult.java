package com.neu.his.cloud.zuul.dto.dms;

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
public class DmsNonDrugResult  implements Serializable {
    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "项目编码")
    private String code;
    @ApiModelProperty(value = "项目名称")
    private String name;
    @ApiModelProperty(value = "规格")
    private String format;
    @ApiModelProperty(value = "价格")
    private BigDecimal price;
    @ApiModelProperty(value = "所属费用科目ID")
    private Long expClassId;
    @ApiModelProperty(value = "执行科室ID")
    private Long  deptId;
    @ApiModelProperty(value = "拼音助记码")
    private String mnemonicCode;
    @ApiModelProperty(value = "项目类型:1->检查检验;2->处置")
    private Integer recordType;
    @ApiModelProperty(value = "创建时间")
    private Date createDate;
    @ApiModelProperty(value = "状态")
    private Integer status;
    @ApiModelProperty(value = "执行科室名")
    private String  deptName;
}
