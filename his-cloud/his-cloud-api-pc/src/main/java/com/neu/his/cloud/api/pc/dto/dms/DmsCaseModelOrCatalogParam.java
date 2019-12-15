package com.neu.his.cloud.api.pc.dto.dms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
public class DmsCaseModelOrCatalogParam  implements Serializable {

    @ApiModelProperty (value = "父模板（目录）Id")
    private Long parentId;
    @ApiModelProperty (value = "层级（增加时不需传入）")
    private Integer level;
    @ApiModelProperty (value = "类型 ： 2 模板 1 目录")
    private Integer type;
    @ApiModelProperty (value = "状态： 1 正常（增加时不需传入）")
    private Integer status;
    @ApiModelProperty (value = "范围:0个人 1科室 2全院")
    private Integer scope;
    @ApiModelProperty (value = "所属人Id")
    private Long ownId;
    @ApiModelProperty (value = "创建时间（增加时不需传入）")
    private Date createTime;
    @ApiModelProperty (value = "目录或模板名")
    private String name;
    //如果是模板一下信息还需要包含
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
    @ApiModelProperty (value = "初诊Id list--->    1,2,3,4,5")
    private String priliminaryDiseIdList;
    @ApiModelProperty (value = "初诊name list---> 胃酸,胃胀气,")
    private String priliminaryDiseStrList;

}
