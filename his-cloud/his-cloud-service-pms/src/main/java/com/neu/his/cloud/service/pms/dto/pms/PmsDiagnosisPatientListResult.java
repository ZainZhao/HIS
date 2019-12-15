package com.neu.his.cloud.service.pms.dto.pms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class PmsDiagnosisPatientListResult {
    @ApiModelProperty(value = "科室待诊")
    List<PmsDiagnosisPatientResult> deptWaitList;
    @ApiModelProperty(value = "个人待诊")
    List<PmsDiagnosisPatientResult> personalWaitList;
    @ApiModelProperty(value = "个人诊中")
    List<PmsDiagnosisPatientResult> personalDuringList;
    @ApiModelProperty(value = "个人已诊")
    List<PmsDiagnosisPatientResult> personalEndList;
}
