package com.neu.his.cloud.service.dms.dto.dms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
public class DmsMedicinePrescriptionRecordResult  implements Serializable {

    @ApiModelProperty(value = "处方项")
    List<DmsMedicineItemRecordResult> dmsMedicineItemRecordResultList;

    @ApiModelProperty(value = "成药处方状态：status  0作废 1未缴费 2已缴费 3已过期")
    private Integer status;

    @ApiModelProperty(value = "总金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "处方名")
    private String name;

    @ApiModelProperty(value = "门诊Id(挂号号id)")
    private Long registrationId;

    @ApiModelProperty(value = "退款状态！！")
    private Long refundStatus;

    @ApiModelProperty(value = "类型（普诊）")
    private Integer type;

    @ApiModelProperty(value = "开立人name")
    private String createStaffName;
    @ApiModelProperty(value = "开立时间")
    private Date createTime;

    @ApiModelProperty(value = "处方Id")
    private Long id;

}
