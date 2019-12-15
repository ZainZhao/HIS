package com.neu.his.cloud.api.app.dto.app;

import com.neu.his.cloud.api.app.dto.sms.SmsSkdResult;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@ToString
public class AppDocSkdResult {
    @ApiModelProperty(value = "医生排班信息")
    private List<SmsSkdResult> skdResultList;

    @ApiModelProperty(value = "科室Id")
    private Long deptId;
    @ApiModelProperty(value = "科室名")
    private String deptName;
    @ApiModelProperty(value = "医生描述")
    private String description;
    @ApiModelProperty(value = "医生头像url")
    private String url;
    @ApiModelProperty(value = "医生评级")
    private BigDecimal star;
}
