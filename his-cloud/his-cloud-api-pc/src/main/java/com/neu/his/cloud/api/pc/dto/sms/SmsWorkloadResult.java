package com.neu.his.cloud.api.pc.dto.sms;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@ToString
public class SmsWorkloadResult  implements Serializable {
    @ApiModelProperty(value = "工作量记录id")
    Long workloadId;
    @ApiModelProperty(value = "创建时间")
    Date createTime;
    @ApiModelProperty(value = "统计哪天的工作量")
    Date date;
    @ApiModelProperty(value = "员工id")
    Long   staffId;
    @ApiModelProperty(value = "科室id")
    Long   deptId;
    @ApiModelProperty(value = "员工name")
   String   staffName;
    @ApiModelProperty(value = "科室name")
    String   deptName;

    @ApiModelProperty(value = "开立成药总钱数")
    BigDecimal medicineAmount;
    @ApiModelProperty(value = "开立草药总钱数")
    BigDecimal herbalAmount;
    @ApiModelProperty(value = "开立检查总钱数")
    BigDecimal checkAmount;
    @ApiModelProperty(value = "开立处置总钱数")
    BigDecimal  dispositionAmount;
    @ApiModelProperty(value = "挂号总钱数")
    BigDecimal  registrationAmount;
    @ApiModelProperty(value = "开立检验总钱数")
    BigDecimal  testAmount;
    @ApiModelProperty(value = "总钱数")
    BigDecimal  amount;

    @ApiModelProperty(value = "状态")
    Integer status;
    @ApiModelProperty(value = "挂号总数")
    Long registrationNum;
    @ApiModelProperty(value = "执行检查总钱数")
    BigDecimal excuteCheckAmount;
    @ApiModelProperty(value = "执行测验总钱数")
    BigDecimal excuteTestAmount;
    @ApiModelProperty(value = "执行处置总钱数")
    BigDecimal excuteDispositionAmount;
    @ApiModelProperty(value = "type : 0 个人 1 科室")
    Integer type;  //  dept_id
    @ApiModelProperty(value = "执行总人数")
    Long excuteNum;


}
