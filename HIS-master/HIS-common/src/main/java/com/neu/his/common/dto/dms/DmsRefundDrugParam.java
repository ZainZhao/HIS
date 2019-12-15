package com.neu.his.common.dto.dms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString

public class DmsRefundDrugParam  implements Serializable {

    @ApiModelProperty(value = "退药处方项Id")
    Long refundPrescriptionItemId;
    @ApiModelProperty(value = "退药数量")
    Long refundNum;
    @ApiModelProperty(value = "退药处方项类型")
    Integer type;

}
