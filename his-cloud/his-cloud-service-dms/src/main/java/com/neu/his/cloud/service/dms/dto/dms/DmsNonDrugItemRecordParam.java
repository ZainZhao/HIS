package com.neu.his.cloud.service.dms.dto.dms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class DmsNonDrugItemRecordParam  implements Serializable {
   @ApiModelProperty(value = "目的")
   String aim;
    @ApiModelProperty(value = "要求")
    String demand;
    @ApiModelProperty(value = "临床印象")
    String clinicalImpression;
    @ApiModelProperty(value = "临床诊断")
    String clinicalDiagnosis;
    @ApiModelProperty(value = "非药品Id")
    Long  noDrugId;
    @ApiModelProperty(value = "检查部位")
    String  checkParts;
    @ApiModelProperty(value = "执行科室id")
    Long  excuteDeptId;
   @ApiModelProperty(value = "项目金额")
    BigDecimal amount;

}
