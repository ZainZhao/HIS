package com.neu.his.cloud.service.sms.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BmsInvoiceRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BmsInvoiceRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoIsNull() {
            addCriterion("invoice_no is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoIsNotNull() {
            addCriterion("invoice_no is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoEqualTo(Long value) {
            addCriterion("invoice_no =", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoNotEqualTo(Long value) {
            addCriterion("invoice_no <>", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoGreaterThan(Long value) {
            addCriterion("invoice_no >", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoGreaterThanOrEqualTo(Long value) {
            addCriterion("invoice_no >=", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoLessThan(Long value) {
            addCriterion("invoice_no <", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoLessThanOrEqualTo(Long value) {
            addCriterion("invoice_no <=", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoIn(List<Long> values) {
            addCriterion("invoice_no in", values, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoNotIn(List<Long> values) {
            addCriterion("invoice_no not in", values, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoBetween(Long value1, Long value2) {
            addCriterion("invoice_no between", value1, value2, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoNotBetween(Long value1, Long value2) {
            addCriterion("invoice_no not between", value1, value2, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNull() {
            addCriterion("bill_id is null");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNotNull() {
            addCriterion("bill_id is not null");
            return (Criteria) this;
        }

        public Criteria andBillIdEqualTo(Long value) {
            addCriterion("bill_id =", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotEqualTo(Long value) {
            addCriterion("bill_id <>", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThan(Long value) {
            addCriterion("bill_id >", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThanOrEqualTo(Long value) {
            addCriterion("bill_id >=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThan(Long value) {
            addCriterion("bill_id <", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThanOrEqualTo(Long value) {
            addCriterion("bill_id <=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdIn(List<Long> values) {
            addCriterion("bill_id in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotIn(List<Long> values) {
            addCriterion("bill_id not in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdBetween(Long value1, Long value2) {
            addCriterion("bill_id between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotBetween(Long value1, Long value2) {
            addCriterion("bill_id not between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusIsNull() {
            addCriterion("freeze_status is null");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusIsNotNull() {
            addCriterion("freeze_status is not null");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusEqualTo(Integer value) {
            addCriterion("freeze_status =", value, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusNotEqualTo(Integer value) {
            addCriterion("freeze_status <>", value, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusGreaterThan(Integer value) {
            addCriterion("freeze_status >", value, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("freeze_status >=", value, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusLessThan(Integer value) {
            addCriterion("freeze_status <", value, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusLessThanOrEqualTo(Integer value) {
            addCriterion("freeze_status <=", value, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusIn(List<Integer> values) {
            addCriterion("freeze_status in", values, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusNotIn(List<Integer> values) {
            addCriterion("freeze_status not in", values, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusBetween(Integer value1, Integer value2) {
            addCriterion("freeze_status between", value1, value2, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("freeze_status not between", value1, value2, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andAssociateIdIsNull() {
            addCriterion("associate_id is null");
            return (Criteria) this;
        }

        public Criteria andAssociateIdIsNotNull() {
            addCriterion("associate_id is not null");
            return (Criteria) this;
        }

        public Criteria andAssociateIdEqualTo(Long value) {
            addCriterion("associate_id =", value, "associateId");
            return (Criteria) this;
        }

        public Criteria andAssociateIdNotEqualTo(Long value) {
            addCriterion("associate_id <>", value, "associateId");
            return (Criteria) this;
        }

        public Criteria andAssociateIdGreaterThan(Long value) {
            addCriterion("associate_id >", value, "associateId");
            return (Criteria) this;
        }

        public Criteria andAssociateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("associate_id >=", value, "associateId");
            return (Criteria) this;
        }

        public Criteria andAssociateIdLessThan(Long value) {
            addCriterion("associate_id <", value, "associateId");
            return (Criteria) this;
        }

        public Criteria andAssociateIdLessThanOrEqualTo(Long value) {
            addCriterion("associate_id <=", value, "associateId");
            return (Criteria) this;
        }

        public Criteria andAssociateIdIn(List<Long> values) {
            addCriterion("associate_id in", values, "associateId");
            return (Criteria) this;
        }

        public Criteria andAssociateIdNotIn(List<Long> values) {
            addCriterion("associate_id not in", values, "associateId");
            return (Criteria) this;
        }

        public Criteria andAssociateIdBetween(Long value1, Long value2) {
            addCriterion("associate_id between", value1, value2, "associateId");
            return (Criteria) this;
        }

        public Criteria andAssociateIdNotBetween(Long value1, Long value2) {
            addCriterion("associate_id not between", value1, value2, "associateId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNull() {
            addCriterion("operator_id is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNotNull() {
            addCriterion("operator_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdEqualTo(Long value) {
            addCriterion("operator_id =", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotEqualTo(Long value) {
            addCriterion("operator_id <>", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThan(Long value) {
            addCriterion("operator_id >", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("operator_id >=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThan(Long value) {
            addCriterion("operator_id <", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThanOrEqualTo(Long value) {
            addCriterion("operator_id <=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIn(List<Long> values) {
            addCriterion("operator_id in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotIn(List<Long> values) {
            addCriterion("operator_id not in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdBetween(Long value1, Long value2) {
            addCriterion("operator_id between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotBetween(Long value1, Long value2) {
            addCriterion("operator_id not between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andSettlementCatIdIsNull() {
            addCriterion("settlement_cat_id is null");
            return (Criteria) this;
        }

        public Criteria andSettlementCatIdIsNotNull() {
            addCriterion("settlement_cat_id is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementCatIdEqualTo(Long value) {
            addCriterion("settlement_cat_id =", value, "settlementCatId");
            return (Criteria) this;
        }

        public Criteria andSettlementCatIdNotEqualTo(Long value) {
            addCriterion("settlement_cat_id <>", value, "settlementCatId");
            return (Criteria) this;
        }

        public Criteria andSettlementCatIdGreaterThan(Long value) {
            addCriterion("settlement_cat_id >", value, "settlementCatId");
            return (Criteria) this;
        }

        public Criteria andSettlementCatIdGreaterThanOrEqualTo(Long value) {
            addCriterion("settlement_cat_id >=", value, "settlementCatId");
            return (Criteria) this;
        }

        public Criteria andSettlementCatIdLessThan(Long value) {
            addCriterion("settlement_cat_id <", value, "settlementCatId");
            return (Criteria) this;
        }

        public Criteria andSettlementCatIdLessThanOrEqualTo(Long value) {
            addCriterion("settlement_cat_id <=", value, "settlementCatId");
            return (Criteria) this;
        }

        public Criteria andSettlementCatIdIn(List<Long> values) {
            addCriterion("settlement_cat_id in", values, "settlementCatId");
            return (Criteria) this;
        }

        public Criteria andSettlementCatIdNotIn(List<Long> values) {
            addCriterion("settlement_cat_id not in", values, "settlementCatId");
            return (Criteria) this;
        }

        public Criteria andSettlementCatIdBetween(Long value1, Long value2) {
            addCriterion("settlement_cat_id between", value1, value2, "settlementCatId");
            return (Criteria) this;
        }

        public Criteria andSettlementCatIdNotBetween(Long value1, Long value2) {
            addCriterion("settlement_cat_id not between", value1, value2, "settlementCatId");
            return (Criteria) this;
        }

        public Criteria andSettleRecordIdIsNull() {
            addCriterion("settle_record_id is null");
            return (Criteria) this;
        }

        public Criteria andSettleRecordIdIsNotNull() {
            addCriterion("settle_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andSettleRecordIdEqualTo(Long value) {
            addCriterion("settle_record_id =", value, "settleRecordId");
            return (Criteria) this;
        }

        public Criteria andSettleRecordIdNotEqualTo(Long value) {
            addCriterion("settle_record_id <>", value, "settleRecordId");
            return (Criteria) this;
        }

        public Criteria andSettleRecordIdGreaterThan(Long value) {
            addCriterion("settle_record_id >", value, "settleRecordId");
            return (Criteria) this;
        }

        public Criteria andSettleRecordIdGreaterThanOrEqualTo(Long value) {
            addCriterion("settle_record_id >=", value, "settleRecordId");
            return (Criteria) this;
        }

        public Criteria andSettleRecordIdLessThan(Long value) {
            addCriterion("settle_record_id <", value, "settleRecordId");
            return (Criteria) this;
        }

        public Criteria andSettleRecordIdLessThanOrEqualTo(Long value) {
            addCriterion("settle_record_id <=", value, "settleRecordId");
            return (Criteria) this;
        }

        public Criteria andSettleRecordIdIn(List<Long> values) {
            addCriterion("settle_record_id in", values, "settleRecordId");
            return (Criteria) this;
        }

        public Criteria andSettleRecordIdNotIn(List<Long> values) {
            addCriterion("settle_record_id not in", values, "settleRecordId");
            return (Criteria) this;
        }

        public Criteria andSettleRecordIdBetween(Long value1, Long value2) {
            addCriterion("settle_record_id between", value1, value2, "settleRecordId");
            return (Criteria) this;
        }

        public Criteria andSettleRecordIdNotBetween(Long value1, Long value2) {
            addCriterion("settle_record_id not between", value1, value2, "settleRecordId");
            return (Criteria) this;
        }

        public Criteria andItemListIsNull() {
            addCriterion("item_list is null");
            return (Criteria) this;
        }

        public Criteria andItemListIsNotNull() {
            addCriterion("item_list is not null");
            return (Criteria) this;
        }

        public Criteria andItemListEqualTo(String value) {
            addCriterion("item_list =", value, "itemList");
            return (Criteria) this;
        }

        public Criteria andItemListNotEqualTo(String value) {
            addCriterion("item_list <>", value, "itemList");
            return (Criteria) this;
        }

        public Criteria andItemListGreaterThan(String value) {
            addCriterion("item_list >", value, "itemList");
            return (Criteria) this;
        }

        public Criteria andItemListGreaterThanOrEqualTo(String value) {
            addCriterion("item_list >=", value, "itemList");
            return (Criteria) this;
        }

        public Criteria andItemListLessThan(String value) {
            addCriterion("item_list <", value, "itemList");
            return (Criteria) this;
        }

        public Criteria andItemListLessThanOrEqualTo(String value) {
            addCriterion("item_list <=", value, "itemList");
            return (Criteria) this;
        }

        public Criteria andItemListLike(String value) {
            addCriterion("item_list like", value, "itemList");
            return (Criteria) this;
        }

        public Criteria andItemListNotLike(String value) {
            addCriterion("item_list not like", value, "itemList");
            return (Criteria) this;
        }

        public Criteria andItemListIn(List<String> values) {
            addCriterion("item_list in", values, "itemList");
            return (Criteria) this;
        }

        public Criteria andItemListNotIn(List<String> values) {
            addCriterion("item_list not in", values, "itemList");
            return (Criteria) this;
        }

        public Criteria andItemListBetween(String value1, String value2) {
            addCriterion("item_list between", value1, value2, "itemList");
            return (Criteria) this;
        }

        public Criteria andItemListNotBetween(String value1, String value2) {
            addCriterion("item_list not between", value1, value2, "itemList");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}