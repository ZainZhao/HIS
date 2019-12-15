package com.neu.his.cloud.api.app.dto.sms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SmsDeptResult {
    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "科室编码")
    private String code;
    @ApiModelProperty(value = "科室分类")
    private Integer catId;
    @ApiModelProperty(value = "科室名称")
    private String name;
    @ApiModelProperty(value = "科室类型")
    private Integer type;
    @ApiModelProperty(value = "状态：0->无效;1->有效")
    private Integer status;
}
