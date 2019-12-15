package com.neu.his.cloud.zuul.dto.dms;

import com.neu.his.cloud.zuul.model.DmsHerbalItemRecord;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@ToString

public class DmsHerbalPrescriptionRecordParam  implements Serializable {

    @ApiModelProperty(value = "处方项")
    List<DmsHerbalItemRecord> dmsHerbalItemRecordList;
    @ApiModelProperty(value = "草药处方状态：status  0作废 1未缴费 2已缴费 3已过期")
    private Integer status;
    @ApiModelProperty(value = "总金额")
    private BigDecimal amount;
    @ApiModelProperty(value = "处方名")
    private String name;
    @ApiModelProperty(value = "治法")
    private String therapy;
    @ApiModelProperty(value = "治法详情")
    private String therapyDetails;
    @ApiModelProperty(value = "医嘱")
    private String medicalAdvice;
    @ApiModelProperty(value = "付数")
    private Long pairNum;
    @ApiModelProperty(value = "门诊Id(挂号号id)")
    private Long registrationId;
    @ApiModelProperty(value = "频次")
    private Integer frequency;
    @ApiModelProperty(value = "用法")
    private Integer usageMeans;
    @ApiModelProperty(value = "类型（普诊）")
    private Integer type;
    @ApiModelProperty(value = "开立人")
    private Long createStaffId;


}
