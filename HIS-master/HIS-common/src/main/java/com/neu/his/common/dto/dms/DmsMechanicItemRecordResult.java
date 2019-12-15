package com.neu.his.common.dto.dms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
public class DmsMechanicItemRecordResult  implements Serializable {
         @ApiModelProperty(value = "项目记录Id")
         Long itemRecordId;
        @ApiModelProperty(value = "项目名")
        String itemName;
        @ApiModelProperty(value = "项目类型")
        String itemType;
        @ApiModelProperty(value = "门诊号")
        Long registrationId;
        @ApiModelProperty(value = "状态")
        Integer status;
        @ApiModelProperty(value = "检查检验要求")
        String demand;
        @ApiModelProperty(value = "登记状态")
        Integer logStatus;
        @ApiModelProperty(value = "检查检验结果")
        String checkResult;
        @ApiModelProperty(value = "检查检验结果img")
        List<String> resultImgUrlList;
       @ApiModelProperty(value = "病人姓名")
        String patientName;
        @ApiModelProperty(value = "病人年龄")
        String patientAgeStr;
        @ApiModelProperty(value = "病人性别")
        Integer patientGender;

        @ApiModelProperty(value = "目的")
        String aim;
        @ApiModelProperty(value = "检查部位")
        String checkParts;

        @ApiModelProperty(value = "临床印象")
        String clinicalImpression;
        @ApiModelProperty(value = "临床诊断")
        String clinicalDiagnosis;
        //20190621添加属性
        @ApiModelProperty(value = "登记医生姓名")
        String logStaffName;
        @ApiModelProperty(value = "开立时间")
        Date createTime;


}
