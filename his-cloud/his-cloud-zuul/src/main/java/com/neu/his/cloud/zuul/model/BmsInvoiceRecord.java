package com.neu.his.cloud.zuul.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BmsInvoiceRecord implements Serializable {
    private Long id;

    private Date createTime;

    private Long invoiceNo;

    private Long billId;

    private BigDecimal amount;

    private Integer freezeStatus;

    private Long associateId;

    private Long operatorId;

    private Long settlementCatId;

    private Long settleRecordId;

    private String itemList;

    private Integer type;

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

    public Long getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(Long invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getFreezeStatus() {
        return freezeStatus;
    }

    public void setFreezeStatus(Integer freezeStatus) {
        this.freezeStatus = freezeStatus;
    }

    public Long getAssociateId() {
        return associateId;
    }

    public void setAssociateId(Long associateId) {
        this.associateId = associateId;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Long getSettlementCatId() {
        return settlementCatId;
    }

    public void setSettlementCatId(Long settlementCatId) {
        this.settlementCatId = settlementCatId;
    }

    public Long getSettleRecordId() {
        return settleRecordId;
    }

    public void setSettleRecordId(Long settleRecordId) {
        this.settleRecordId = settleRecordId;
    }

    public String getItemList() {
        return itemList;
    }

    public void setItemList(String itemList) {
        this.itemList = itemList;
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
        sb.append(", createTime=").append(createTime);
        sb.append(", invoiceNo=").append(invoiceNo);
        sb.append(", billId=").append(billId);
        sb.append(", amount=").append(amount);
        sb.append(", freezeStatus=").append(freezeStatus);
        sb.append(", associateId=").append(associateId);
        sb.append(", operatorId=").append(operatorId);
        sb.append(", settlementCatId=").append(settlementCatId);
        sb.append(", settleRecordId=").append(settleRecordId);
        sb.append(", itemList=").append(itemList);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}