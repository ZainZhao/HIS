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
public class PmsDiagnosisPatientListResult  implements Serializable {
    @ApiModelProperty(value = "科室待诊")
    List<PmsDiagnosisPatientResult> deptWaitList;
    @ApiModelProperty(value = "个人待诊")
    List<PmsDiagnosisPatientResult> personalWaitList;
    @ApiModelProperty(value = "个人诊中")
    List<PmsDiagnosisPatientResult> personalDuringList;
    @ApiModelProperty(value = "个人已诊")
    List<PmsDiagnosisPatientResult> personalEndList;
}
