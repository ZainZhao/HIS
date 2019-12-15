package com.neu.his.common.dto.pms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
public class PmsDrugStorePatientListResult  implements Serializable {
    @ApiModelProperty(value = "未发药患者")
    List<PmsDrugStorePatientResult> undoPatientList ;
    @ApiModelProperty(value = "已发药患者")
    List<PmsDrugStorePatientResult> donePatientList ;



}
