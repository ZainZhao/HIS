package com.neu.his.cloud.zuul.dto.dms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
public class DmsNonDrugRedisParam implements Serializable {

    @ApiModelProperty(value = "非药品项列表" )
    private List<DmsNonDrugItem> dmsNonDrugItemRecordParamList;
    @ApiModelProperty(value = "创建人id" )
    private Long createStaffId;
    @ApiModelProperty(value = "挂号号" )
    private Long registrationId;
    @ApiModelProperty(value = "非药品类型" )
    private Integer type;
}
