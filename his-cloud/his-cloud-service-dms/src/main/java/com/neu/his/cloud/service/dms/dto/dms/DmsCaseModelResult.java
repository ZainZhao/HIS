package com.neu.his.cloud.service.dms.dto.dms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
public class DmsCaseModelResult  implements Serializable {

    @ApiModelProperty (value = "模板Id")
    private Long id;

    @ApiModelProperty (value = "主诉")
    private String chiefComplaint;

    @ApiModelProperty (value = "症状")
    private String historyOfPresentIllness;

    @ApiModelProperty (value = "历史治疗")
    private String historyOfTreatment;

    @ApiModelProperty (value = "既往史")
    private String pastHistory;

    @ApiModelProperty (value = "过敏史")
    private String allergies;

    @ApiModelProperty (value = "健康检查")
    private String healthCheckup;

    @ApiModelProperty (value = "初步诊断Id串")
    private List<Long> priliminaryDiseIdList;

    @ApiModelProperty (value = "初诊诊断id串对应诊断名字串")
    private List<String> priliminaryDiseStrList;

    @ApiModelProperty (value = "病历模板名")
    private String name;

    @ApiModelProperty (value = "状态")
    private Integer status;
}
