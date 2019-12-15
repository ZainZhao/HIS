package com.neu.his.cloud.service.dms.dto.dms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
public class DmsCaseHistoryParam  implements Serializable {


    @ApiModelProperty(value = "主诉" )
    private String chiefComplaint;
    @ApiModelProperty(value = "现病史" )
    private String historyOfPresentIllness;
    @ApiModelProperty(value = "现治疗情况" )
    private String historyOfTreatment;
    @ApiModelProperty(value = "既往史" )
    private String pastHistory;
    @ApiModelProperty(value = "过敏史" )
    private String allergies;
    @ApiModelProperty(value = "体格检查" )
    private String healthCheckup;
    @ApiModelProperty(value = "门诊号(挂号号)" )
    private Long registrationId;
    @ApiModelProperty(value = "初诊结果str串" )
    private String priliminaryDiseStrList;
    @ApiModelProperty(value = "初诊结果Id串" )
    private String priliminaryDiseIdList;
    @ApiModelProperty(value = "发病时间" )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @ApiModelProperty(value = "病人姓名" )
    private String name;
    @ApiModelProperty(value = "病人性别" )
    private Integer gender;
    @ApiModelProperty(value = "病人年龄" )
    private String ageStr;


    @ApiModelProperty(value = "检查:  name<>部位<>result<>url ><" )
    private String checkIdList;
    @ApiModelProperty(value = "检验:  name<>部位<>result<>url ><" )
    private String testIdList;

    @ApiModelProperty(value = "检查结果（门诊医生填写）")
    private String  checkResult;

    @ApiModelProperty(value = "检验结果（门诊医生填写）")
    private String  testResult;

    @ApiModelProperty(value = "确诊诊断串" )
    private String definiteDiseStrList;




    @ApiModelProperty(value = "处置：name><" )
    private String dispositionIdList;
    @ApiModelProperty(value = "草药处方: 处方名[处方项名 <<>> 数量 >< 处方项名 | 数量] <> " )
    private String herbalPrescriptionIdList;
    @ApiModelProperty(value = "西药处方: 处方名[处方项名 <<>> 数量 >< 处方项名 | 数量] <>" )
    private String medicinePrescriptionIdList;


}
