package com.neu.his.cloud.api.pc.dto.dms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@Setter
@Getter
@ToString
public class DmsDiseResult  implements Serializable {
    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "目录id")
    private Long catId;
    @ApiModelProperty(value = "疾病编码")
    private String code;
    @ApiModelProperty(value = "疾病名称")
    private String name;
    @ApiModelProperty(value = "ICD编码")
    private String icd;
    @ApiModelProperty(value = "状态")
    private Integer status;
}
