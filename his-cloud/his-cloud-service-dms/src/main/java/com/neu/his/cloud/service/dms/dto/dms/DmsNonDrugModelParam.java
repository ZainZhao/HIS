package com.neu.his.cloud.service.dms.dto.dms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 非药品模版
 */

@Setter
@Getter
@ToString
public class DmsNonDrugModelParam  implements Serializable {

    @ApiModelProperty(value = "模版Id")
    private Long id;
    @ApiModelProperty(value = "模版状态 0删除 1 正常")
    private Integer status;
    @ApiModelProperty(value = "模版名称")
    private String name;
    @ApiModelProperty(value = "模版所包括非药品的id")
    private List<Long> nonDrugIdList;
    @ApiModelProperty(value = "模版范围 scope 0个人 1科室 2全院")
    private Integer scope;
    @ApiModelProperty(value = "所属人Id")
    private Long ownId;
    @ApiModelProperty(value = "目的")
    private String aim;
//    @ApiModelProperty(value = "创建时间")
//    private Date createTime;
    @ApiModelProperty(value = "模版编码")
    private String code;
    @ApiModelProperty(value = "模版类型 type 0检查 1检验  2处置 ")
    private Integer type;

}
