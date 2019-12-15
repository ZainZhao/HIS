package com.neu.his.cloud.api.pc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BmsOperatorSettleRecord implements Serializable {
    private Long id;

    private Date startDatetime;

    private Date endDatetime;

    private Date createDatetime;

    private Long cashierId;

    private Long invoiceNum;

    private Long rushInvoiceNum;

    private Long reprintInvoiceNum;

    private String startEndInvoiceIdStr;

    private String rushInvoiceIdListStr;

    private String reprintInvoiceIdListStr;

    private BigDecimal medicineAmount;

    private BigDecimal herbalAmount;

    private BigDecimal checkAmount;

    private BigDecimal dispositionAmount;

    private BigDecimal registrationAmount;

    private BigDecimal testAmount;

    private BigDecimal amount;

    private BigDecimal cashAmount;

    private BigDecimal insuranceAmount;

    private BigDecimal bankCardAmount;

    private BigDecimal alipayAmount;

    private BigDecimal wechatAmount;

    private BigDecimal creditCardAmount;

    private BigDecimal otherAmount;

    private Long verifyOperatorId;

    private Date verifyDatetime;

    private Integer verifyStatus;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
    }

    public Date getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Date endDatetime) {
        this.endDatetime = endDatetime;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Long getCashierId() {
        return cashierId;
    }

    public void setCashierId(Long cashierId) {
        this.cashierId = cashierId;
    }

    public Long getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(Long invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public Long getRushInvoiceNum() {
        return rushInvoiceNum;
    }

    public void setRushInvoiceNum(Long rushInvoiceNum) {
        this.rushInvoiceNum = rushInvoiceNum;
    }

    public Long getReprintInvoiceNum() {
        return reprintInvoiceNum;
    }

    public void setReprintInvoiceNum(Long reprintInvoiceNum) {
        this.reprintInvoiceNum = reprintInvoiceNum;
    }

    public String getStartEndInvoiceIdStr() {
        return startEndInvoiceIdStr;
    }

    public void setStartEndInvoiceIdStr(String startEndInvoiceIdStr) {
        this.startEndInvoiceIdStr = startEndInvoiceIdStr;
    }

    public String getRushInvoiceIdListStr() {
        return rushInvoiceIdListStr;
    }

    public void setRushInvoiceIdListStr(String rushInvoiceIdListStr) {
        this.rushInvoiceIdListStr = rushInvoiceIdListStr;
    }

    public String getReprintInvoiceIdListStr() {
        return reprintInvoiceIdListStr;
    }

    public void setReprintInvoiceIdListStr(String reprintInvoiceIdListStr) {
        this.reprintInvoiceIdListStr = reprintInvoiceIdListStr;
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

    public BigDecimal getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(BigDecimal cashAmount) {
        this.cashAmount = cashAmount;
    }

    public BigDecimal getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(BigDecimal insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public BigDecimal getBankCardAmount() {
        return bankCardAmount;
    }

    public void setBankCardAmount(BigDecimal bankCardAmount) {
        this.bankCardAmount = bankCardAmount;
    }

    public BigDecimal getAlipayAmount() {
        return alipayAmount;
    }

    public void setAlipayAmount(BigDecimal alipayAmount) {
        this.alipayAmount = alipayAmount;
    }

    public BigDecimal getWechatAmount() {
        return wechatAmount;
    }

    public void setWechatAmount(BigDecimal wechatAmount) {
        this.wechatAmount = wechatAmount;
    }

    public BigDecimal getCreditCardAmount() {
        return creditCardAmount;
    }

    public void setCreditCardAmount(BigDecimal creditCardAmount) {
        this.creditCardAmount = creditCardAmount;
    }

    public BigDecimal getOtherAmount() {
        return otherAmount;
    }

    public void setOtherAmount(BigDecimal otherAmount) {
        this.otherAmount = otherAmount;
    }

    public Long getVerifyOperatorId() {
        return verifyOperatorId;
    }

    public void setVerifyOperatorId(Long verifyOperatorId) {
        this.verifyOperatorId = verifyOperatorId;
    }

    public Date getVerifyDatetime() {
        return verifyDatetime;
    }

    public void setVerifyDatetime(Date verifyDatetime) {
        this.verifyDatetime = verifyDatetime;
    }

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", startDatetime=").append(startDatetime);
        sb.append(", endDatetime=").append(endDatetime);
        sb.append(", createDatetime=").append(createDatetime);
        sb.append(", cashierId=").append(cashierId);
        sb.append(", invoiceNum=").append(invoiceNum);
        sb.append(", rushInvoiceNum=").append(rushInvoiceNum);
        sb.append(", reprintInvoiceNum=").append(reprintInvoiceNum);
        sb.append(", startEndInvoiceIdStr=").append(startEndInvoiceIdStr);
        sb.append(", rushInvoiceIdListStr=").append(rushInvoiceIdListStr);
        sb.append(", reprintInvoiceIdListStr=").append(reprintInvoiceIdListStr);
        sb.append(", medicineAmount=").append(medicineAmount);
        sb.append(", herbalAmount=").append(herbalAmount);
        sb.append(", checkAmount=").append(checkAmount);
        sb.append(", dispositionAmount=").append(dispositionAmount);
        sb.append(", registrationAmount=").append(registrationAmount);
        sb.append(", testAmount=").append(testAmount);
        sb.append(", amount=").append(amount);
        sb.append(", cashAmount=").append(cashAmount);
        sb.append(", insuranceAmount=").append(insuranceAmount);
        sb.append(", bankCardAmount=").append(bankCardAmount);
        sb.append(", alipayAmount=").append(alipayAmount);
        sb.append(", wechatAmount=").append(wechatAmount);
        sb.append(", creditCardAmount=").append(creditCardAmount);
        sb.append(", otherAmount=").append(otherAmount);
        sb.append(", verifyOperatorId=").append(verifyOperatorId);
        sb.append(", verifyDatetime=").append(verifyDatetime);
        sb.append(", verifyStatus=").append(verifyStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}