package com.neu.his.cloud.service.sms.dto.sms;

import com.neu.his.cloud.service.sms.model.SmsDept;
import com.neu.his.cloud.service.sms.model.SmsRole;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


@Setter
@Getter
@ToString
public class SmsStaffResult  implements Serializable {
    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "登录名")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "真实姓名")
    private String name;
    @ApiModelProperty(value = "所在科室")
    private SmsDept dept;
    @ApiModelProperty(value = "状态：1->有效;0->无效")
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
    private SmsRole role;
    @ApiModelProperty(value = "挂号级别id")
    private Long registrationRankId;
}
