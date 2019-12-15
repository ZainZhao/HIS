package com.neu.his.cloud.zuul.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class SmsSkdRuleItem implements Serializable {
    private Long id;

    private Long staffId;

    private String daysOfWeek;

    private Integer status;

    private Long skLimit;

    private Long skRuleId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(String daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getSkLimit() {
        return skLimit;
    }

    public void setSkLimit(Long skLimit) {
        this.skLimit = skLimit;
    }

    public Long getSkRuleId() {
        return skRuleId;
    }

    public void setSkRuleId(Long skRuleId) {
        this.skRuleId = skRuleId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", staffId=").append(staffId);
        sb.append(", daysOfWeek=").append(daysOfWeek);
        sb.append(", status=").append(status);
        sb.append(", skLimit=").append(skLimit);
        sb.append(", skRuleId=").append(skRuleId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}