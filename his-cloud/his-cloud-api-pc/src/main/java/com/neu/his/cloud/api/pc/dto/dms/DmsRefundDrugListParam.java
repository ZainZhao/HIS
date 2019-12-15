package com.neu.his.cloud.api.pc.dto.dms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
public class DmsRefundDrugListParam  implements Serializable {

    @ApiModelProperty("处方项List")
    List<DmsRefundDrugParam> refundItemList;
    @ApiModelProperty("执行人Id")
    Long excutorId;

}
