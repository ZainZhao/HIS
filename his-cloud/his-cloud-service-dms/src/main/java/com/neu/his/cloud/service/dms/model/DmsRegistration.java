package com.neu.his.cloud.service.dms.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class DmsRegistration implements Serializable {
    private Long id;

    private Long patientId;

    private Date createTime;

    private Integer endAttendance;

    private Integer status;

    private Long skdId;

    private Integer needBook;

    private Integer bindStatus;

    private Long deptId;

    private Date attendanceDate;

    private String patientAgeStr;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getEndAttendance() {
        return endAttendance;
    }

    public void setEndAttendance(Integer endAttendance) {
        this.endAttendance = endAttendance;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getSkdId() {
        return skdId;
    }

    public void setSkdId(Long skdId) {
        this.skdId = skdId;
    }

    public Integer getNeedBook() {
        return needBook;
    }

    public void setNeedBook(Integer needBook) {
        this.needBook = needBook;
    }

    public Integer getBindStatus() {
        return bindStatus;
    }

    public void setBindStatus(Integer bindStatus) {
        this.bindStatus = bindStatus;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getPatientAgeStr() {
        return patientAgeStr;
    }

    public void setPatientAgeStr(String patientAgeStr) {
        this.patientAgeStr = patientAgeStr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", patientId=").append(patientId);
        sb.append(", createTime=").append(createTime);
        sb.append(", endAttendance=").append(endAttendance);
        sb.append(", status=").append(status);
        sb.append(", skdId=").append(skdId);
        sb.append(", needBook=").append(needBook);
        sb.append(", bindStatus=").append(bindStatus);
        sb.append(", deptId=").append(deptId);
        sb.append(", attendanceDate=").append(attendanceDate);
        sb.append(", patientAgeStr=").append(patientAgeStr);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}