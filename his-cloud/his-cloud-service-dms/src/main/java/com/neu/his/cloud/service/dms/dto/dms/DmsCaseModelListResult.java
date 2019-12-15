package com.neu.his.cloud.service.dms.dto.dms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class DmsCaseModelListResult {

    @ApiModelProperty(value = "个人病历模板列表")
    List<DmsCaseModelResult> staffList;

    @ApiModelProperty(value = "科室病历模板列表")
    List<DmsCaseModelResult> deptList;

    @ApiModelProperty(value = "全院病历模板列表")
    List<DmsCaseModelResult> hospitalList;

}
