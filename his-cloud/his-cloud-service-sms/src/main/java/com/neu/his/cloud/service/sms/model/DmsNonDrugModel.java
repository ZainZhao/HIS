package com.neu.his.cloud.service.sms.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class DmsNonDrugModel implements Serializable {
    private Long id;

    private Integer status;

    private String name;

    private String nonDrugIdList;

    private Integer scope;

    private Long ownId;

    private String aim;

    private Date createTime;

    private String code;

    private Integer type;

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

    public String getNonDrugIdList() {
        return nonDrugIdList;
    }

    public void setNonDrugIdList(String nonDrugIdList) {
        this.nonDrugIdList = nonDrugIdList;
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

    public String getAim() {
        return aim;
    }

    public void setAim(String aim) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", status=").append(status);
        sb.append(", name=").append(name);
        sb.append(", nonDrugIdList=").append(nonDrugIdList);
        sb.append(", scope=").append(scope);
        sb.append(", ownId=").append(ownId);
        sb.append(", aim=").append(aim);
        sb.append(", createTime=").append(createTime);
        sb.append(", code=").append(code);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}