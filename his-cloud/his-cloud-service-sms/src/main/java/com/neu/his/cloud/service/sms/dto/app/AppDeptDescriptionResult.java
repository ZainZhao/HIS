package com.neu.his.cloud.service.sms.dto.app;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AppDeptDescriptionResult {

    @ApiModelProperty(value = "科室Id")
    private Long deptId;
    @ApiModelProperty(value = "科室名")
    private String deptName;
    @ApiModelProperty(value = "科室描述")
    private String description;
    @ApiModelProperty(value = "科室图片url")
    private String url;

}
