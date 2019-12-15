package com.neu.his.cloud.service.dms.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DmsHerbalPrescriptionRecord implements Serializable {
    private Long id;

    private Integer status;

    private Date createTime;

    private BigDecimal amount;

    private String name;

    private String therapy;

    private String therapyDetails;

    private String medicalAdvice;

    private Long pairNum;

    private Long registrationId;

    private Integer frequency;

    private Integer usageMeans;

    private Integer type;

    private Long createStaffId;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTherapy() {
        return therapy;
    }

    public void setTherapy(String therapy) {
        this.therapy = therapy;
    }

    public String getTherapyDetails() {
        return therapyDetails;
    }

    public void setTherapyDetails(String therapyDetails) {
        this.therapyDetails = therapyDetails;
    }

    public String getMedicalAdvice() {
        return medicalAdvice;
    }

    public void setMedicalAdvice(String medicalAdvice) {
        this.medicalAdvice = medicalAdvice;
    }

    public Long getPairNum() {
        return pairNum;
    }

    public void setPairNum(Long pairNum) {
        this.pairNum = pairNum;
    }

    public Long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Integer getUsageMeans() {
        return usageMeans;
    }

    public void setUsageMeans(Integer usageMeans) {
        this.usageMeans = usageMeans;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getCreateStaffId() {
        return createStaffId;
    }

    public void setCreateStaffId(Long createStaffId) {
        this.createStaffId = createStaffId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", amount=").append(amount);
        sb.append(", name=").append(name);
        sb.append(", therapy=").append(therapy);
        sb.append(", therapyDetails=").append(therapyDetails);
        sb.append(", medicalAdvice=").append(medicalAdvice);
        sb.append(", pairNum=").append(pairNum);
        sb.append(", registrationId=").append(registrationId);
        sb.append(", frequency=").append(frequency);
        sb.append(", usageMeans=").append(usageMeans);
        sb.append(", type=").append(type);
        sb.append(", createStaffId=").append(createStaffId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}