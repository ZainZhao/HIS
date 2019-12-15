package com.neu.his.cloud.service.pms.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class SmsStaff implements Serializable {
    private Long id;

    private String username;

    private String password;

    private Integer status;

    private Date createTime;

    private Integer gender;

    private Integer skdFlag;

    private String title;

    private String name;

    private Long deptId;

    private Long roleId;

    private Long registrationRankId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getSkdFlag() {
        return skdFlag;
    }

    public void setSkdFlag(Integer skdFlag) {
        this.skdFlag = skdFlag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getRegistrationRankId() {
        return registrationRankId;
    }

    public void setRegistrationRankId(Long registrationRankId) {
        this.registrationRankId = registrationRankId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", gender=").append(gender);
        sb.append(", skdFlag=").append(skdFlag);
        sb.append(", title=").append(title);
        sb.append(", name=").append(name);
        sb.append(", deptId=").append(deptId);
        sb.append(", roleId=").append(roleId);
        sb.append(", registrationRankId=").append(registrationRankId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}