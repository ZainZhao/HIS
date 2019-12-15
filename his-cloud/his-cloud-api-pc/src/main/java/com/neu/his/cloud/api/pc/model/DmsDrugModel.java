package com.neu.his.cloud.api.pc.model;

import java.io.Serializable;
import java.util.Date;

public class DmsDrugModel implements Serializable {
    private Long id;

    private Integer status;

    private String name;

    private Integer scope;

    private Long ownId;

    private Long aim;

    private Date createTime;

    private String code;

    private Integer type;

    private Long pairNum;

    private Integer frequency;

    private String therapy;

    private String therapyDetails;

    private String medicalAdvice;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScope() {
        return scope;
    }

    public void setScope(Integer scope) {
        this.scope = scope;
    }

    public Long getOwnId() {
        return ownId;
    }

    public void setOwnId(Long ownId) {
        this.ownId = ownId;
    }

    public Long getAim() {
        return aim;
    }

    public void setAim(Long aim) {
        this.aim = aim;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getPairNum() {
        return pairNum;
    }

    public void setPairNum(Long pairNum) {
        this.pairNum = pairNum;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", status=").append(status);
        sb.append(", name=").append(name);
        sb.append(", scope=").append(scope);
        sb.append(", ownId=").append(ownId);
        sb.append(", aim=").append(aim);
        sb.append(", createTime=").append(createTime);
        sb.append(", code=").append(code);
        sb.append(", type=").append(type);
        sb.append(", pairNum=").append(pairNum);
        sb.append(", frequency=").append(frequency);
        sb.append(", therapy=").append(therapy);
        sb.append(", therapyDetails=").append(therapyDetails);
        sb.append(", medicalAdvice=").append(medicalAdvice);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}