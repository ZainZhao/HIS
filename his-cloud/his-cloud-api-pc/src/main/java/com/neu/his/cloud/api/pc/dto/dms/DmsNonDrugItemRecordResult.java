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
public class DmsNonDrugItemRecordResult  implements Serializable {

    @ApiModelProperty(value = "非药品项id")
    Long id;
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
    @ApiModelProperty(value = "执行科室name")
    String  excuteDeptName;
    @ApiModelProperty(value = "状态：0 作废（删除）1未缴费 2未登记（已缴费） 3已登记 4已执行 5已退费 6已过期")
    Integer  status;
    @ApiModelProperty(value = "类型： 0检查 1检验  2处置")
    Integer type;
    @ApiModelProperty(value = "结果")
    String checkResult;
    @ApiModelProperty(value = "结果图片链接")
    String resultImgUrlList;
    @ApiModelProperty(value = "创建（开立）时间")
    Date createTime;
    @ApiModelProperty(value = "执行医生name")
    String excuteStaffName;
    @ApiModelProperty(value = "开立医生name")
    String createStaffName;
    @ApiModelProperty(value = "登记医生name")
    String logStaffName;












}
