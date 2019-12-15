package com.neu.his.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class DmsMedicineModelItem implements Serializable {
    private Long id;

    private Long modelId;

    private Integer status;

    private Long drugId;

    private Integer medicineUsage;

    private Integer frequency;

    private Long days;

    private Long num;

    private String medicalAdvice;

    private Long usageNum;

    private Integer usageMeans;

    private Integer usageNumUnit;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getDrugId() {
        return drugId;
    }

    public void setDrugId(Long drugId) {
        this.drugId = drugId;
    }

    public Integer getMedicineUsage() {
        return medicineUsage;
    }

    public void setMedicineUsage(Integer medicineUsage) {
        this.medicineUsage = medicineUsage;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Long getDays() {
        return days;
    }

    public void setDays(Long days) {
        this.days = days;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getMedicalAdvice() {
        return medicalAdvice;
    }

    public void setMedicalAdvice(String medicalAdvice) {
        this.medicalAdvice = medicalAdvice;
    }

    public Long getUsageNum() {
        return usageNum;
    }

    public void setUsageNum(Long usageNum) {
        this.usageNum = usageNum;
    }

    public Integer getUsageMeans() {
        return usageMeans;
    }

    public void setUsageMeans(Integer usageMeans) {
        this.usageMeans = usageMeans;
    }

    public Integer getUsageNumUnit() {
        return usageNumUnit;
    }

    public void setUsageNumUnit(Integer usageNumUnit) {
        this.usageNumUnit = usageNumUnit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", modelId=").append(modelId);
        sb.append(", status=").append(status);
        sb.append(", drugId=").append(drugId);
        sb.append(", medicineUsage=").append(medicineUsage);
        sb.append(", frequency=").append(frequency);
        sb.append(", days=").append(days);
        sb.append(", num=").append(num);
        sb.append(", medicalAdvice=").append(medicalAdvice);
        sb.append(", usageNum=").append(usageNum);
        sb.append(", usageMeans=").append(usageMeans);
        sb.append(", usageNumUnit=").append(usageNumUnit);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}