package com.neu.his.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class DmsHerbalItemRecord implements Serializable {
    private Long id;

    private Integer status;

    private Long prescriptionId;

    private String medicalAdvice;

    private String footnote;

    private Long drugId;

    private Long usageNum;

    private Integer usageNumUnit;

    private Long totalNum;

    private Long currentNum;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getMedicalAdvice() {
        return medicalAdvice;
    }

    public void setMedicalAdvice(String medicalAdvice) {
        this.medicalAdvice = medicalAdvice;
    }

    public String getFootnote() {
        return footnote;
    }

    public void setFootnote(String footnote) {
        this.footnote = footnote;
    }

    public Long getDrugId() {
        return drugId;
    }

    public void setDrugId(Long drugId) {
        this.drugId = drugId;
    }

    public Long getUsageNum() {
        return usageNum;
    }

    public void setUsageNum(Long usageNum) {
        this.usageNum = usageNum;
    }

    public Integer getUsageNumUnit() {
        return usageNumUnit;
    }

    public void setUsageNumUnit(Integer usageNumUnit) {
        this.usageNumUnit = usageNumUnit;
    }

    public Long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Long totalNum) {
        this.totalNum = totalNum;
    }

    public Long getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(Long currentNum) {
        this.currentNum = currentNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", status=").append(status);
        sb.append(", prescriptionId=").append(prescriptionId);
        sb.append(", medicalAdvice=").append(medicalAdvice);
        sb.append(", footnote=").append(footnote);
        sb.append(", drugId=").append(drugId);
        sb.append(", usageNum=").append(usageNum);
        sb.append(", usageNumUnit=").append(usageNumUnit);
        sb.append(", totalNum=").append(totalNum);
        sb.append(", currentNum=").append(currentNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}