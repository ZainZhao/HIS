package com.neu.his.cloud.service.bms.dto.app;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AppCheckTestResult {

    @ApiModelProperty(value = "检查部位")
    String  checkParts;
    @ApiModelProperty(value = "结果")
    String checkResult;
    @ApiModelProperty(value = "结果图片链接")
    String resultImgUrlList;

}
