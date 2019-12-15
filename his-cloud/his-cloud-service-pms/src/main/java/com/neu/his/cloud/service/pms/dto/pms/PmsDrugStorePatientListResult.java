package com.neu.his.cloud.service.pms.dto.pms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class PmsDrugStorePatientListResult {
    @ApiModelProperty(value = "未发药患者")
    List<PmsDrugStorePatientResult> undoPatientList ;
    @ApiModelProperty(value = "已发药患者")
    List<PmsDrugStorePatientResult> donePatientList ;



}
