package com.neu.his.cloud.service.sms.dto.sms;

import com.neu.his.cloud.service.sms.dto.dms.DmsDrugResult;
import com.neu.his.cloud.service.sms.dto.dms.DmsNonDrugResult;
import com.neu.his.cloud.service.sms.model.DmsDise;
import com.neu.his.cloud.service.sms.model.DmsDrug;
import com.neu.his.cloud.service.sms.model.DmsNonDrug;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
public class SmsFrequentUsedResult  implements Serializable {

    @ApiModelProperty(value = "常用项id")
    private Long id;
    @ApiModelProperty(value = "所属用户id")
    private Long staffId;

    @ApiModelProperty(value = "检查项列表")
    private List<DmsNonDrugResult> checkList;
    @ApiModelProperty(value = "处置项列表")
    private List<DmsNonDrugResult> dispositionList;
    @ApiModelProperty(value = "检验项列表")
    private List<DmsNonDrugResult> testList;
    @ApiModelProperty(value = "西医诊断列表")
    private List<DmsDise> medicineDiseList;
    @ApiModelProperty(value = "中医诊断列表")
    private List<DmsDise> herbalDiseList;
    @ApiModelProperty(value = "药品列表")
    private List<DmsDrugResult> drugList;


    @ApiModelProperty(value = "检查模板id列表")
    private List<Long> checkModelIdList;
    @ApiModelProperty(value = "处置模板id列表")
    private List<Long> dispositionModelIdList;
    @ApiModelProperty(value = "检验模板id列表")
    private List<Long> testModelIdList;
    @ApiModelProperty(value = "药品模板id列表")
    private List<Long> drugModelIdList;






}
