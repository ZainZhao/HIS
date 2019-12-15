package com.neu.his.cloud.service.sms.dto.sms;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class SmsPermissionParam  implements Serializable {
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "父权限Id")
    private Long pid;
    @ApiModelProperty(value = "权限名")
    private String name;
    @ApiModelProperty(value = "值")
    private String value;
    @ApiModelProperty(value = "权限url")
    private String url;
    @ApiModelProperty(value = "权限状态")
    private Integer status;
//    @ApiModelProperty(value = "权限创建时间")
//    private Date createTime;
    @ApiModelProperty(value = "排序号")
    private Integer sort;
    @ApiModelProperty(value = "权限类别")
    private Integer type;

}
