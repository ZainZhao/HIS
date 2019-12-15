package com.neu.his.cloud.zuul.dto.sms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
public class SmsStaffParam  implements Serializable {
    @ApiModelProperty(value = "登录名")
    private String username;
    @ApiModelProperty(value = "登录名")
    private String password;

    @ApiModelProperty(value = "真实姓名")
    private String name;
    @ApiModelProperty(value = "所在科室")
    private Long deptId;
    @ApiModelProperty(value = "状态：0->有效;1->无效")
    private Integer status;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "性别")
    private Integer gender;
    @ApiModelProperty(value = "是否参与排班：0->否;1->是")
    private Integer skdFlag;
    @ApiModelProperty(value = "职称")
    private String title;
    @ApiModelProperty(value = "角色")
    private Long roleId;
    @ApiModelProperty(value = "挂号级别id")
    private Long registrationRankId;
}
