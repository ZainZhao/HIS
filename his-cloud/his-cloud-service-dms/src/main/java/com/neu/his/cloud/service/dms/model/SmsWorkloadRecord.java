package com.neu.his.cloud.service.dms.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SmsWorkloadRecord implements Serializable {
    private Long id;

    private Date createTime;

    private Long staffId;

    private BigDecimal medicineAmount;

    private BigDecimal herbalAmount;

    private BigDecimal checkAmount;

    private BigDecimal dispositionAmount;

    private BigDecimal registrationAmount;

    private BigDecimal testAmount;

    private BigDecimal amount;

    private Date date;

    private Integer status;

    private Long registrationNum;

    private BigDecimal excuteCheckAmount;

    private BigDecimal excuteTestAmount;

    private BigDecimal excuteDispositionAmount;

    private Integer type;

    private Long deptId;

    private Long excuteNum;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public BigDecimal getMedicineAmount() {
        return medicineAmount;
    }

    public void setMedicineAmount(BigDecimal medicineAmount) {
        this.medicineAmount = medicineAmount;
    }

    public BigDecimal getHerbalAmount() {
        return herbalAmount;
    }

    public void setHerbalAmount(BigDecimal herbalAmount) {
        this.herbalAmount = herbalAmount;
    }

    public BigDecimal getCheckAmount() {
        return checkAmount;
    }

    public void setCheckAmount(BigDecimal checkAmount) {
        this.checkAmount = checkAmount;
    }

    public BigDecimal getDispositionAmount() {
        return dispositionAmount;
    }

    public void setDispositionAmount(BigDecimal dispositionAmount) {
        this.dispositionAmount = dispositionAmount;
    }

    public BigDecimal getRegistrationAmount() {
        return registrationAmount;
    }

    public void setRegistrationAmount(BigDecimal registrationAmount) {
        this.registrationAmount = registrationAmount;
    }

    public BigDecimal getTestAmount() {
        return testAmount;
    }

    public void setTestAmount(BigDecimal testAmount) {
        this.testAmount = testAmount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    public Long getRegistrationNum() {
        return registrationNum;
    }

    public void setRegistrationNum(Long registrationNum) {
        this.registrationNum = registrationNum;
    }

    public BigDecimal getExcuteCheckAmount() {
        return excuteCheckAmount;
    }

    public void setExcuteCheckAmount(BigDecimal excuteCheckAmount) {
        this.excuteCheckAmount = excuteCheckAmount;
    }

    public BigDecimal getExcuteTestAmount() {
        return excuteTestAmount;
    }

    public void setExcuteTestAmount(BigDecimal excuteTestAmount) {
        this.excuteTestAmount = excuteTestAmount;
    }

    public BigDecimal getExcuteDispositionAmount() {
        return excuteDispositionAmount;
    }

    public void setExcuteDispositionAmount(BigDecimal excuteDispositionAmount) {
        this.excuteDispositionAmount = excuteDispositionAmount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getExcuteNum() {
        return excuteNum;
    }

    public void setExcuteNum(Long excuteNum) {
        this.excuteNum = excuteNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", staffId=").append(staffId);
        sb.append(", medicineAmount=").append(medicineAmount);
        sb.append(", herbalAmount=").append(herbalAmount);
        sb.append(", checkAmount=").append(checkAmount);
        sb.append(", dispositionAmount=").append(dispositionAmount);
        sb.append(", registrationAmount=").append(registrationAmount);
        sb.append(", testAmount=").append(testAmount);
        sb.append(", amount=").append(amount);
        sb.append(", date=").append(date);
        sb.append(", status=").append(status);
        sb.append(", registrationNum=").append(registrationNum);
        sb.append(", excuteCheckAmount=").append(excuteCheckAmount);
        sb.append(", excuteTestAmount=").append(excuteTestAmount);
        sb.append(", excuteDispositionAmount=").append(excuteDispositionAmount);
        sb.append(", type=").append(type);
        sb.append(", deptId=").append(deptId);
        sb.append(", excuteNum=").append(excuteNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}