package com.neu.his.cloud.api.pc.dto.sms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class SmsDeptParam  implements Serializable {
    @ApiModelProperty(value = "科室编码")
    private String code;
    @ApiModelProperty(value = "科室名称")
    private String name;
    @ApiModelProperty(value = "科室分类")
    private Integer catId;
    @ApiModelProperty(value = "科室类型")
    private Integer type;
    @ApiModelProperty(value = "状态：0->无效;1->有效")
    private Integer status;
}
