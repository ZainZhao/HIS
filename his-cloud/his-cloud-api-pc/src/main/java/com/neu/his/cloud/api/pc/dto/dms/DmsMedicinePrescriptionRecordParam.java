package com.neu.his.cloud.api.pc.dto.dms;

import com.neu.his.cloud.api.pc.model.DmsMedicineItemRecord;
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
public class DmsMedicinePrescriptionRecordParam  implements Serializable {
    @ApiModelProperty(value = "处方项")
    List<DmsMedicineItemRecord> dmsMedicineItemRecordList;

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

    @ApiModelProperty(value = "开立人")
    private Long createStaffId;

}
