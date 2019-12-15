package com.neu.his.cloud.service.bms.dto.app;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AppStaffDescriptionResult {

    @ApiModelProperty(value = "staffId")
    private Long id;
    @ApiModelProperty(value = "staff头像")
    private String url;
    @ApiModelProperty(value = "姓名")
    private String name;

}
