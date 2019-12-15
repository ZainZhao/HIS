package com.neu.his.cloud.api.pc.model;

import java.io.Serializable;
import java.util.Date;

public class DmsDrugRefundItemRecord implements Serializable {
    private Long id;

    private Integer status;

    private Integer type;

    private Long registrationId;

    private Long drugId;

    private Integer refundNumUnit;

    private Long refundNum;

    private Date refundTime;

    private Long excutorId;

    private Long refundItemRecordId;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }

    public Long getDrugId() {
        return drugId;
    }

    public void setDrugId(Long drugId) {
        this.drugId = drugId;
    }

    public Integer getRefundNumUnit() {
        return refundNumUnit;
    }

    public void setRefundNumUnit(Integer refundNumUnit) {
        this.refundNumUnit = refundNumUnit;
    }

    public Long getRefundNum() {
        return refundNum;
    }

    public void setRefundNum(Long refundNum) {
        this.refundNum = refundNum;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    public Long getExcutorId() {
        return excutorId;
    }

    public void setExcutorId(Long excutorId) {
        this.excutorId = excutorId;
    }

    public Long getRefundItemRecordId() {
        return refundItemRecordId;
    }

    public void setRefundItemRecordId(Long refundItemRecordId) {
        this.refundItemRecordId = refundItemRecordId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", status=").append(status);
        sb.append(", type=").append(type);
        sb.append(", registrationId=").append(registrationId);
        sb.append(", drugId=").append(drugId);
        sb.append(", refundNumUnit=").append(refundNumUnit);
        sb.append(", refundNum=").append(refundNum);
        sb.append(", refundTime=").append(refundTime);
        sb.append(", excutorId=").append(excutorId);
        sb.append(", refundItemRecordId=").append(refundItemRecordId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}