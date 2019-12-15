package com.neu.his.common.dto.dms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class DmsDosageResult   implements Serializable {
    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "编码")
    private String code;
    @ApiModelProperty(value = "名字")
    private String name;
    @ApiModelProperty(value = "状态")
    private Integer status;

    @Override
    public String toString() {
        return "DmsDosageResult{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
