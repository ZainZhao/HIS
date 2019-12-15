package com.neu.his.cloud.zuul.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class SmsSkd implements Serializable {
    private Long id;

    private Date date;

    private Integer status;

    private Long remain;

    private Integer noon;

    private Long staffId;

    private Long deptId;

    private Long skLimit;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getRemain() {
        return remain;
    }

    public void setRemain(Long remain) {
        this.remain = remain;
    }

    public Integer getNoon() {
        return noon;
    }

    public void setNoon(Integer noon) {
        this.noon = noon;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getSkLimit() {
        return skLimit;
    }

    public void setSkLimit(Long skLimit) {
        this.skLimit = skLimit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", date=").append(date);
        sb.append(", status=").append(status);
        sb.append(", remain=").append(remain);
        sb.append(", noon=").append(noon);
        sb.append(", staffId=").append(staffId);
        sb.append(", deptId=").append(deptId);
        sb.append(", skLimit=").append(skLimit);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}