package com.neu.his.cloud.zuul.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BmsOperatorSettleRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BmsOperatorSettleRecordExample() {
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

        public Criteria andStartDatetimeIsNull() {
            addCriterion("start_datetime is null");
            return (Criteria) this;
        }

        public Criteria andStartDatetimeIsNotNull() {
            addCriterion("start_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andStartDatetimeEqualTo(Date value) {
            addCriterion("start_datetime =", value, "startDatetime");
            return (Criteria) this;
        }

        public Criteria andStartDatetimeNotEqualTo(Date value) {
            addCriterion("start_datetime <>", value, "startDatetime");
            return (Criteria) this;
        }

        public Criteria andStartDatetimeGreaterThan(Date value) {
            addCriterion("start_datetime >", value, "startDatetime");
            return (Criteria) this;
        }

        public Criteria andStartDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_datetime >=", value, "startDatetime");
            return (Criteria) this;
        }

        public Criteria andStartDatetimeLessThan(Date value) {
            addCriterion("start_datetime <", value, "startDatetime");
            return (Criteria) this;
        }

        public Criteria andStartDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("start_datetime <=", value, "startDatetime");
            return (Criteria) this;
        }

        public Criteria andStartDatetimeIn(List<Date> values) {
            addCriterion("start_datetime in", values, "startDatetime");
            return (Criteria) this;
        }

        public Criteria andStartDatetimeNotIn(List<Date> values) {
            addCriterion("start_datetime not in", values, "startDatetime");
            return (Criteria) this;
        }

        public Criteria andStartDatetimeBetween(Date value1, Date value2) {
            addCriterion("start_datetime between", value1, value2, "startDatetime");
            return (Criteria) this;
        }

        public Criteria andStartDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("start_datetime not between", value1, value2, "startDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeIsNull() {
            addCriterion("end_datetime is null");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeIsNotNull() {
            addCriterion("end_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeEqualTo(Date value) {
            addCriterion("end_datetime =", value, "endDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeNotEqualTo(Date value) {
            addCriterion("end_datetime <>", value, "endDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeGreaterThan(Date value) {
            addCriterion("end_datetime >", value, "endDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_datetime >=", value, "endDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeLessThan(Date value) {
            addCriterion("end_datetime <", value, "endDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("end_datetime <=", value, "endDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeIn(List<Date> values) {
            addCriterion("end_datetime in", values, "endDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeNotIn(List<Date> values) {
            addCriterion("end_datetime not in", values, "endDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeBetween(Date value1, Date value2) {
            addCriterion("end_datetime between", value1, value2, "endDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("end_datetime not between", value1, value2, "endDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIsNull() {
            addCriterion("create_datetime is null");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIsNotNull() {
            addCriterion("create_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeEqualTo(Date value) {
            addCriterion("create_datetime =", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotEqualTo(Date value) {
            addCriterion("create_datetime <>", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeGreaterThan(Date value) {
            addCriterion("create_datetime >", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_datetime >=", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeLessThan(Date value) {
            addCriterion("create_datetime <", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("create_datetime <=", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIn(List<Date> values) {
            addCriterion("create_datetime in", values, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotIn(List<Date> values) {
            addCriterion("create_datetime not in", values, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeBetween(Date value1, Date value2) {
            addCriterion("create_datetime between", value1, value2, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("create_datetime not between", value1, value2, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCashierIdIsNull() {
            addCriterion("cashier_id is null");
            return (Criteria) this;
        }

        public Criteria andCashierIdIsNotNull() {
            addCriterion("cashier_id is not null");
            return (Criteria) this;
        }

        public Criteria andCashierIdEqualTo(Long value) {
            addCriterion("cashier_id =", value, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdNotEqualTo(Long value) {
            addCriterion("cashier_id <>", value, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdGreaterThan(Long value) {
            addCriterion("cashier_id >", value, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cashier_id >=", value, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdLessThan(Long value) {
            addCriterion("cashier_id <", value, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdLessThanOrEqualTo(Long value) {
            addCriterion("cashier_id <=", value, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdIn(List<Long> values) {
            addCriterion("cashier_id in", values, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdNotIn(List<Long> values) {
            addCriterion("cashier_id not in", values, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdBetween(Long value1, Long value2) {
            addCriterion("cashier_id between", value1, value2, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdNotBetween(Long value1, Long value2) {
            addCriterion("cashier_id not between", value1, value2, "cashierId");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumIsNull() {
            addCriterion("invoice_num is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumIsNotNull() {
            addCriterion("invoice_num is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumEqualTo(Long value) {
            addCriterion("invoice_num =", value, "invoiceNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumNotEqualTo(Long value) {
            addCriterion("invoice_num <>", value, "invoiceNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumGreaterThan(Long value) {
            addCriterion("invoice_num >", value, "invoiceNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumGreaterThanOrEqualTo(Long value) {
            addCriterion("invoice_num >=", value, "invoiceNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumLessThan(Long value) {
            addCriterion("invoice_num <", value, "invoiceNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumLessThanOrEqualTo(Long value) {
            addCriterion("invoice_num <=", value, "invoiceNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumIn(List<Long> values) {
            addCriterion("invoice_num in", values, "invoiceNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumNotIn(List<Long> values) {
            addCriterion("invoice_num not in", values, "invoiceNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumBetween(Long value1, Long value2) {
            addCriterion("invoice_num between", value1, value2, "invoiceNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumNotBetween(Long value1, Long value2) {
            addCriterion("invoice_num not between", value1, value2, "invoiceNum");
            return (Criteria) this;
        }

        public Criteria andRushInvoiceNumIsNull() {
            addCriterion("rush_invoice_num is null");
            return (Criteria) this;
        }

        public Criteria andRushInvoiceNumIsNotNull() {
            addCriterion("rush_invoice_num is not null");
            return (Criteria) this;
        }

        public Criteria andRushInvoiceNumEqualTo(Long value) {
            addCriterion("rush_invoice_num =", value, "rushInvoiceNum");
            return (Criteria) this;
        }

        public Criteria andRushInvoiceNumNotEqualTo(Long value) {
            addCriterion("rush_invoice_num <>", value, "rushInvoiceNum");
            return (Criteria) this;
        }

        public Criteria andRushInvoiceNumGreaterThan(Long value) {
            addCriterion("rush_invoice_num >", value, "rushInvoiceNum");
            return (Criteria) this;
        }

        public Criteria andRushInvoiceNumGreaterThanOrEqualTo(Long value) {
            addCriterion("rush_invoice_num >=", value, "rushInvoiceNum");
            return (Criteria) this;
        }

        public Criteria andRushInvoiceNumLessThan(Long value) {
            addCriterion("rush_invoice_num <", value, "rushInvoiceNum");
            return (Criteria) this;
        }

        public Criteria andRushInvoiceNumLessThanOrEqualTo(Long value) {
            addCriterion("rush_invoice_num <=", value, "rushInvoiceNum");
            return (Criteria) this;
        }

        public Criteria andRushInvoiceNumIn(List<Long> values) {
            addCriterion("rush_invoice_num in", values, "rushInvoiceNum");
            return (Criteria) this;
        }

        public Criteria andRushInvoiceNumNotIn(List<Long> values) {
            addCriterion("rush_invoice_num not in", values, "rushInvoiceNum");
            return (Criteria) this;
        }

        public Criteria andRushInvoiceNumBetween(Long value1, Long value2) {
            addCriterion("rush_invoice_num between", value1, value2, "rushInvoiceNum");
            return (Criteria) this;
        }

        public Criteria andRushInvoiceNumNotBetween(Long value1, Long value2) {
            addCriterion("rush_invoice_num not between", value1, value2, "rushInvoiceNum");
            return (Criteria) this;
        }

        public Criteria andReprintInvoiceNumIsNull() {
            addCriterion("reprint_invoice_num is null");
            return (Criteria) this;
        }

        public Criteria andReprintInvoiceNumIsNotNull() {
            addCriterion("reprint_invoice_num is not null");
            return (Criteria) this;
        }

        public Criteria andReprintInvoiceNumEqualTo(Long value) {
            addCriterion("reprint_invoice_num =", value, "reprintInvoiceNum");
            return (Criteria) this;
        }

        public Criteria andReprintInvoiceNumNotEqualTo(Long value) {
            addCriterion("reprint_invoice_num <>", value, "reprintInvoiceNum");
            return (Criteria) this;
        }

        public Criteria andReprintInvoiceNumGreaterThan(Long value) {
            addCriterion("reprint_invoice_num >", value, "reprintInvoiceNum");
            return (Criteria) this;
        }

        public Criteria andReprintInvoiceNumGreaterThanOrEqualTo(Long value) {
            addCriterion("reprint_invoice_num >=", value, "reprintInvoiceNum");
            return (Criteria) this;
        }

        public Criteria andReprintInvoiceNumLessThan(Long value) {
            addCriterion("reprint_invoice_num <", value, "reprintInvoiceNum");
            return (Criteria) this;
        }

        public Criteria andReprintInvoiceNumLessThanOrEqualTo(Long value) {
            addCriterion("reprint_invoice_num <=", value, "reprintInvoiceNum");
            return (Criteria) this;
        }

        public Criteria andReprintInvoiceNumIn(List<Long> values) {
            addCriterion("reprint_invoice_num in", values, "reprintInvoiceNum");
            return (Criteria) this;
        }

        public Criteria andReprintInvoiceNumNotIn(List<Long> values) {
            addCriterion("reprint_invoice_num not in", values, "reprintInvoiceNum");
            return (Criteria) this;
        }

        public Criteria andReprintInvoiceNumBetween(Long value1, Long value2) {
            addCriterion("reprint_invoice_num between", value1, value2, "reprintInvoiceNum");
            return (Criteria) this;
        }

        public Criteria andReprintInvoiceNumNotBetween(Long value1, Long value2) {
            addCriterion("reprint_invoice_num not between", value1, value2, "reprintInvoiceNum");
            return (Criteria) this;
        }

        public Criteria andStartEndInvoiceIdStrIsNull() {
            addCriterion("start_end_invoice_id_str is null");
            return (Criteria) this;
        }

        public Criteria andStartEndInvoiceIdStrIsNotNull() {
            addCriterion("start_end_invoice_id_str is not null");
            return (Criteria) this;
        }

        public Criteria andStartEndInvoiceIdStrEqualTo(String value) {
            addCriterion("start_end_invoice_id_str =", value, "startEndInvoiceIdStr");
            return (Criteria) this;
        }

        public Criteria andStartEndInvoiceIdStrNotEqualTo(String value) {
            addCriterion("start_end_invoice_id_str <>", value, "startEndInvoiceIdStr");
            return (Criteria) this;
        }

        public Criteria andStartEndInvoiceIdStrGreaterThan(String value) {
            addCriterion("start_end_invoice_id_str >", value, "startEndInvoiceIdStr");
            return (Criteria) this;
        }

        public Criteria andStartEndInvoiceIdStrGreaterThanOrEqualTo(String value) {
            addCriterion("start_end_invoice_id_str >=", value, "startEndInvoiceIdStr");
            return (Criteria) this;
        }

        public Criteria andStartEndInvoiceIdStrLessThan(String value) {
            addCriterion("start_end_invoice_id_str <", value, "startEndInvoiceIdStr");
            return (Criteria) this;
        }

        public Criteria andStartEndInvoiceIdStrLessThanOrEqualTo(String value) {
            addCriterion("start_end_invoice_id_str <=", value, "startEndInvoiceIdStr");
            return (Criteria) this;
        }

        public Criteria andStartEndInvoiceIdStrLike(String value) {
            addCriterion("start_end_invoice_id_str like", value, "startEndInvoiceIdStr");
            return (Criteria) this;
        }

        public Criteria andStartEndInvoiceIdStrNotLike(String value) {
            addCriterion("start_end_invoice_id_str not like", value, "startEndInvoiceIdStr");
            return (Criteria) this;
        }

        public Criteria andStartEndInvoiceIdStrIn(List<String> values) {
            addCriterion("start_end_invoice_id_str in", values, "startEndInvoiceIdStr");
            return (Criteria) this;
        }

        public Criteria andStartEndInvoiceIdStrNotIn(List<String> values) {
            addCriterion("start_end_invoice_id_str not in", values, "startEndInvoiceIdStr");
            return (Criteria) this;
        }

        public Criteria andStartEndInvoiceIdStrBetween(String value1, String value2) {
            addCriterion("start_end_invoice_id_str between", value1, value2, "startEndInvoiceIdStr");
            return (Criteria) this;
        }

        public Criteria andStartEndInvoiceIdStrNotBetween(String value1, String value2) {
            addCriterion("start_end_invoice_id_str not between", value1, value2, "startEndInvoiceIdStr");
            return (Criteria) this;
        }

        public Criteria andRushInvoiceIdListStrIsNull() {
            addCriterion("rush_invoice_id_list_str is null");
            return (Criteria) this;
        }

        public Criteria andRushInvoiceIdListStrIsNotNull() {
            addCriterion("rush_invoice_id_list_str is not null");
            return (Criteria) this;
        }

        public Criteria andRushInvoiceIdListStrEqualTo(String value) {
            addCriterion("rush_invoice_id_list_str =", value, "rushInvoiceIdListStr");
            return (Criteria) this;
        }

        public Criteria andRushInvoiceIdListStrNotEqualTo(String value) {
            addCriterion("rush_invoice_id_list_str <>", value, "rushInvoiceIdListStr");
            return (Criteria) this;
        }

        public Criteria andRushInvoiceIdListStrGreaterThan(String value) {
            addCriterion("rush_invoice_id_list_str >", value, "rushInvoiceIdListStr");
            return (Criteria) this;
        }

        public Criteria andRushInvoiceIdListStrGreaterThanOrEqualTo(String value) {
            addCriterion("rush_invoice_id_list_str >=", value, "rushInvoiceIdListStr");
            return (Criteria) this;
        }

        public Criteria andRushInvoiceIdListStrLessThan(String value) {
            addCriterion("rush_invoice_id_list_str <", value, "rushInvoiceIdListStr");
            return (Criteria) this;
        }

        public Criteria andRushInvoiceIdListStrLessThanOrEqualTo(String value) {
            addCriterion("rush_invoice_id_list_str <=", value, "rushInvoiceIdListStr");
            return (Criteria) this;
        }

        public Criteria andRushInvoiceIdListStrLike(String value) {
            addCriterion("rush_invoice_id_list_str like", value, "rushInvoiceIdListStr");
            return (Criteria) this;
        }

        public Criteria andRushInvoiceIdListStrNotLike(String value) {
            addCriterion("rush_invoice_id_list_str not like", value, "rushInvoiceIdListStr");
            return (Criteria) this;
        }

        public Criteria andRushInvoiceIdListStrIn(List<String> values) {
            addCriterion("rush_invoice_id_list_str in", values, "rushInvoiceIdListStr");
            return (Criteria) this;
        }

        public Criteria andRushInvoiceIdListStrNotIn(List<String> values) {
            addCriterion("rush_invoice_id_list_str not in", values, "rushInvoiceIdListStr");
            return (Criteria) this;
        }

        public Criteria andRushInvoiceIdListStrBetween(String value1, String value2) {
            addCriterion("rush_invoice_id_list_str between", value1, value2, "rushInvoiceIdListStr");
            return (Criteria) this;
        }

        public Criteria andRushInvoiceIdListStrNotBetween(String value1, String value2) {
            addCriterion("rush_invoice_id_list_str not between", value1, value2, "rushInvoiceIdListStr");
            return (Criteria) this;
        }

        public Criteria andReprintInvoiceIdListStrIsNull() {
            addCriterion("reprint_invoice_id_list_str is null");
            return (Criteria) this;
        }

        public Criteria andReprintInvoiceIdListStrIsNotNull() {
            addCriterion("reprint_invoice_id_list_str is not null");
            return (Criteria) this;
        }

        public Criteria andReprintInvoiceIdListStrEqualTo(String value) {
            addCriterion("reprint_invoice_id_list_str =", value, "reprintInvoiceIdListStr");
            return (Criteria) this;
        }

        public Criteria andReprintInvoiceIdListStrNotEqualTo(String value) {
            addCriterion("reprint_invoice_id_list_str <>", value, "reprintInvoiceIdListStr");
            return (Criteria) this;
        }

        public Criteria andReprintInvoiceIdListStrGreaterThan(String value) {
            addCriterion("reprint_invoice_id_list_str >", value, "reprintInvoiceIdListStr");
            return (Criteria) this;
        }

        public Criteria andReprintInvoiceIdListStrGreaterThanOrEqualTo(String value) {
            addCriterion("reprint_invoice_id_list_str >=", value, "reprintInvoiceIdListStr");
            return (Criteria) this;
        }

        public Criteria andReprintInvoiceIdListStrLessThan(String value) {
            addCriterion("reprint_invoice_id_list_str <", value, "reprintInvoiceIdListStr");
            return (Criteria) this;
        }

        public Criteria andReprintInvoiceIdListStrLessThanOrEqualTo(String value) {
            addCriterion("reprint_invoice_id_list_str <=", value, "reprintInvoiceIdListStr");
            return (Criteria) this;
        }

        public Criteria andReprintInvoiceIdListStrLike(String value) {
            addCriterion("reprint_invoice_id_list_str like", value, "reprintInvoiceIdListStr");
            return (Criteria) this;
        }

        public Criteria andReprintInvoiceIdListStrNotLike(String value) {
            addCriterion("reprint_invoice_id_list_str not like", value, "reprintInvoiceIdListStr");
            return (Criteria) this;
        }

        public Criteria andReprintInvoiceIdListStrIn(List<String> values) {
            addCriterion("reprint_invoice_id_list_str in", values, "reprintInvoiceIdListStr");
            return (Criteria) this;
        }

        public Criteria andReprintInvoiceIdListStrNotIn(List<String> values) {
            addCriterion("reprint_invoice_id_list_str not in", values, "reprintInvoiceIdListStr");
            return (Criteria) this;
        }

        public Criteria andReprintInvoiceIdListStrBetween(String value1, String value2) {
            addCriterion("reprint_invoice_id_list_str between", value1, value2, "reprintInvoiceIdListStr");
            return (Criteria) this;
        }

        public Criteria andReprintInvoiceIdListStrNotBetween(String value1, String value2) {
            addCriterion("reprint_invoice_id_list_str not between", value1, value2, "reprintInvoiceIdListStr");
            return (Criteria) this;
        }

        public Criteria andMedicineAmountIsNull() {
            addCriterion("medicine_amount is null");
            return (Criteria) this;
        }

        public Criteria andMedicineAmountIsNotNull() {
            addCriterion("medicine_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineAmountEqualTo(BigDecimal value) {
            addCriterion("medicine_amount =", value, "medicineAmount");
            return (Criteria) this;
        }

        public Criteria andMedicineAmountNotEqualTo(BigDecimal value) {
            addCriterion("medicine_amount <>", value, "medicineAmount");
            return (Criteria) this;
        }

        public Criteria andMedicineAmountGreaterThan(BigDecimal value) {
            addCriterion("medicine_amount >", value, "medicineAmount");
            return (Criteria) this;
        }

        public Criteria andMedicineAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("medicine_amount >=", value, "medicineAmount");
            return (Criteria) this;
        }

        public Criteria andMedicineAmountLessThan(BigDecimal value) {
            addCriterion("medicine_amount <", value, "medicineAmount");
            return (Criteria) this;
        }

        public Criteria andMedicineAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("medicine_amount <=", value, "medicineAmount");
            return (Criteria) this;
        }

        public Criteria andMedicineAmountIn(List<BigDecimal> values) {
            addCriterion("medicine_amount in", values, "medicineAmount");
            return (Criteria) this;
        }

        public Criteria andMedicineAmountNotIn(List<BigDecimal> values) {
            addCriterion("medicine_amount not in", values, "medicineAmount");
            return (Criteria) this;
        }

        public Criteria andMedicineAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("medicine_amount between", value1, value2, "medicineAmount");
            return (Criteria) this;
        }

        public Criteria andMedicineAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("medicine_amount not between", value1, value2, "medicineAmount");
            return (Criteria) this;
        }

        public Criteria andHerbalAmountIsNull() {
            addCriterion("herbal_amount is null");
            return (Criteria) this;
        }

        public Criteria andHerbalAmountIsNotNull() {
            addCriterion("herbal_amount is not null");
            return (Criteria) this;
        }

        public Criteria andHerbalAmountEqualTo(BigDecimal value) {
            addCriterion("herbal_amount =", value, "herbalAmount");
            return (Criteria) this;
        }

        public Criteria andHerbalAmountNotEqualTo(BigDecimal value) {
            addCriterion("herbal_amount <>", value, "herbalAmount");
            return (Criteria) this;
        }

        public Criteria andHerbalAmountGreaterThan(BigDecimal value) {
            addCriterion("herbal_amount >", value, "herbalAmount");
            return (Criteria) this;
        }

        public Criteria andHerbalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("herbal_amount >=", value, "herbalAmount");
            return (Criteria) this;
        }

        public Criteria andHerbalAmountLessThan(BigDecimal value) {
            addCriterion("herbal_amount <", value, "herbalAmount");
            return (Criteria) this;
        }

        public Criteria andHerbalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("herbal_amount <=", value, "herbalAmount");
            return (Criteria) this;
        }

        public Criteria andHerbalAmountIn(List<BigDecimal> values) {
            addCriterion("herbal_amount in", values, "herbalAmount");
            return (Criteria) this;
        }

        public Criteria andHerbalAmountNotIn(List<BigDecimal> values) {
            addCriterion("herbal_amount not in", values, "herbalAmount");
            return (Criteria) this;
        }

        public Criteria andHerbalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("herbal_amount between", value1, value2, "herbalAmount");
            return (Criteria) this;
        }

        public Criteria andHerbalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("herbal_amount not between", value1, value2, "herbalAmount");
            return (Criteria) this;
        }

        public Criteria andCheckAmountIsNull() {
            addCriterion("check_amount is null");
            return (Criteria) this;
        }

        public Criteria andCheckAmountIsNotNull() {
            addCriterion("check_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCheckAmountEqualTo(BigDecimal value) {
            addCriterion("check_amount =", value, "checkAmount");
            return (Criteria) this;
        }

        public Criteria andCheckAmountNotEqualTo(BigDecimal value) {
            addCriterion("check_amount <>", value, "checkAmount");
            return (Criteria) this;
        }

        public Criteria andCheckAmountGreaterThan(BigDecimal value) {
            addCriterion("check_amount >", value, "checkAmount");
            return (Criteria) this;
        }

        public Criteria andCheckAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("check_amount >=", value, "checkAmount");
            return (Criteria) this;
        }

        public Criteria andCheckAmountLessThan(BigDecimal value) {
            addCriterion("check_amount <", value, "checkAmount");
            return (Criteria) this;
        }

        public Criteria andCheckAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("check_amount <=", value, "checkAmount");
            return (Criteria) this;
        }

        public Criteria andCheckAmountIn(List<BigDecimal> values) {
            addCriterion("check_amount in", values, "checkAmount");
            return (Criteria) this;
        }

        public Criteria andCheckAmountNotIn(List<BigDecimal> values) {
            addCriterion("check_amount not in", values, "checkAmount");
            return (Criteria) this;
        }

        public Criteria andCheckAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("check_amount between", value1, value2, "checkAmount");
            return (Criteria) this;
        }

        public Criteria andCheckAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("check_amount not between", value1, value2, "checkAmount");
            return (Criteria) this;
        }

        public Criteria andDispositionAmountIsNull() {
            addCriterion("disposition_amount is null");
            return (Criteria) this;
        }

        public Criteria andDispositionAmountIsNotNull() {
            addCriterion("disposition_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDispositionAmountEqualTo(BigDecimal value) {
            addCriterion("disposition_amount =", value, "dispositionAmount");
            return (Criteria) this;
        }

        public Criteria andDispositionAmountNotEqualTo(BigDecimal value) {
            addCriterion("disposition_amount <>", value, "dispositionAmount");
            return (Criteria) this;
        }

        public Criteria andDispositionAmountGreaterThan(BigDecimal value) {
            addCriterion("disposition_amount >", value, "dispositionAmount");
            return (Criteria) this;
        }

        public Criteria andDispositionAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("disposition_amount >=", value, "dispositionAmount");
            return (Criteria) this;
        }

        public Criteria andDispositionAmountLessThan(BigDecimal value) {
            addCriterion("disposition_amount <", value, "dispositionAmount");
            return (Criteria) this;
        }

        public Criteria andDispositionAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("disposition_amount <=", value, "dispositionAmount");
            return (Criteria) this;
        }

        public Criteria andDispositionAmountIn(List<BigDecimal> values) {
            addCriterion("disposition_amount in", values, "dispositionAmount");
            return (Criteria) this;
        }

        public Criteria andDispositionAmountNotIn(List<BigDecimal> values) {
            addCriterion("disposition_amount not in", values, "dispositionAmount");
            return (Criteria) this;
        }

        public Criteria andDispositionAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("disposition_amount between", value1, value2, "dispositionAmount");
            return (Criteria) this;
        }

        public Criteria andDispositionAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("disposition_amount not between", value1, value2, "dispositionAmount");
            return (Criteria) this;
        }

        public Criteria andRegistrationAmountIsNull() {
            addCriterion("registration_amount is null");
            return (Criteria) this;
        }

        public Criteria andRegistrationAmountIsNotNull() {
            addCriterion("registration_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrationAmountEqualTo(BigDecimal value) {
            addCriterion("registration_amount =", value, "registrationAmount");
            return (Criteria) this;
        }

        public Criteria andRegistrationAmountNotEqualTo(BigDecimal value) {
            addCriterion("registration_amount <>", value, "registrationAmount");
            return (Criteria) this;
        }

        public Criteria andRegistrationAmountGreaterThan(BigDecimal value) {
            addCriterion("registration_amount >", value, "registrationAmount");
            return (Criteria) this;
        }

        public Criteria andRegistrationAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("registration_amount >=", value, "registrationAmount");
            return (Criteria) this;
        }

        public Criteria andRegistrationAmountLessThan(BigDecimal value) {
            addCriterion("registration_amount <", value, "registrationAmount");
            return (Criteria) this;
        }

        public Criteria andRegistrationAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("registration_amount <=", value, "registrationAmount");
            return (Criteria) this;
        }

        public Criteria andRegistrationAmountIn(List<BigDecimal> values) {
            addCriterion("registration_amount in", values, "registrationAmount");
            return (Criteria) this;
        }

        public Criteria andRegistrationAmountNotIn(List<BigDecimal> values) {
            addCriterion("registration_amount not in", values, "registrationAmount");
            return (Criteria) this;
        }

        public Criteria andRegistrationAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("registration_amount between", value1, value2, "registrationAmount");
            return (Criteria) this;
        }

        public Criteria andRegistrationAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("registration_amount not between", value1, value2, "registrationAmount");
            return (Criteria) this;
        }

        public Criteria andTestAmountIsNull() {
            addCriterion("test_amount is null");
            return (Criteria) this;
        }

        public Criteria andTestAmountIsNotNull() {
            addCriterion("test_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTestAmountEqualTo(BigDecimal value) {
            addCriterion("test_amount =", value, "testAmount");
            return (Criteria) this;
        }

        public Criteria andTestAmountNotEqualTo(BigDecimal value) {
            addCriterion("test_amount <>", value, "testAmount");
            return (Criteria) this;
        }

        public Criteria andTestAmountGreaterThan(BigDecimal value) {
            addCriterion("test_amount >", value, "testAmount");
            return (Criteria) this;
        }

        public Criteria andTestAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("test_amount >=", value, "testAmount");
            return (Criteria) this;
        }

        public Criteria andTestAmountLessThan(BigDecimal value) {
            addCriterion("test_amount <", value, "testAmount");
            return (Criteria) this;
        }

        public Criteria andTestAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("test_amount <=", value, "testAmount");
            return (Criteria) this;
        }

        public Criteria andTestAmountIn(List<BigDecimal> values) {
            addCriterion("test_amount in", values, "testAmount");
            return (Criteria) this;
        }

        public Criteria andTestAmountNotIn(List<BigDecimal> values) {
            addCriterion("test_amount not in", values, "testAmount");
            return (Criteria) this;
        }

        public Criteria andTestAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("test_amount between", value1, value2, "testAmount");
            return (Criteria) this;
        }

        public Criteria andTestAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("test_amount not between", value1, value2, "testAmount");
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

        public Criteria andCashAmountIsNull() {
            addCriterion("cash_amount is null");
            return (Criteria) this;
        }

        public Criteria andCashAmountIsNotNull() {
            addCriterion("cash_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCashAmountEqualTo(BigDecimal value) {
            addCriterion("cash_amount =", value, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountNotEqualTo(BigDecimal value) {
            addCriterion("cash_amount <>", value, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountGreaterThan(BigDecimal value) {
            addCriterion("cash_amount >", value, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cash_amount >=", value, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountLessThan(BigDecimal value) {
            addCriterion("cash_amount <", value, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cash_amount <=", value, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountIn(List<BigDecimal> values) {
            addCriterion("cash_amount in", values, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountNotIn(List<BigDecimal> values) {
            addCriterion("cash_amount not in", values, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash_amount between", value1, value2, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash_amount not between", value1, value2, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmountIsNull() {
            addCriterion("insurance_amount is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmountIsNotNull() {
            addCriterion("insurance_amount is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmountEqualTo(BigDecimal value) {
            addCriterion("insurance_amount =", value, "insuranceAmount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmountNotEqualTo(BigDecimal value) {
            addCriterion("insurance_amount <>", value, "insuranceAmount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmountGreaterThan(BigDecimal value) {
            addCriterion("insurance_amount >", value, "insuranceAmount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("insurance_amount >=", value, "insuranceAmount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmountLessThan(BigDecimal value) {
            addCriterion("insurance_amount <", value, "insuranceAmount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("insurance_amount <=", value, "insuranceAmount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmountIn(List<BigDecimal> values) {
            addCriterion("insurance_amount in", values, "insuranceAmount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmountNotIn(List<BigDecimal> values) {
            addCriterion("insurance_amount not in", values, "insuranceAmount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("insurance_amount between", value1, value2, "insuranceAmount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("insurance_amount not between", value1, value2, "insuranceAmount");
            return (Criteria) this;
        }

        public Criteria andBankCardAmountIsNull() {
            addCriterion("bank_card_amount is null");
            return (Criteria) this;
        }

        public Criteria andBankCardAmountIsNotNull() {
            addCriterion("bank_card_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBankCardAmountEqualTo(BigDecimal value) {
            addCriterion("bank_card_amount =", value, "bankCardAmount");
            return (Criteria) this;
        }

        public Criteria andBankCardAmountNotEqualTo(BigDecimal value) {
            addCriterion("bank_card_amount <>", value, "bankCardAmount");
            return (Criteria) this;
        }

        public Criteria andBankCardAmountGreaterThan(BigDecimal value) {
            addCriterion("bank_card_amount >", value, "bankCardAmount");
            return (Criteria) this;
        }

        public Criteria andBankCardAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bank_card_amount >=", value, "bankCardAmount");
            return (Criteria) this;
        }

        public Criteria andBankCardAmountLessThan(BigDecimal value) {
            addCriterion("bank_card_amount <", value, "bankCardAmount");
            return (Criteria) this;
        }

        public Criteria andBankCardAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bank_card_amount <=", value, "bankCardAmount");
            return (Criteria) this;
        }

        public Criteria andBankCardAmountIn(List<BigDecimal> values) {
            addCriterion("bank_card_amount in", values, "bankCardAmount");
            return (Criteria) this;
        }

        public Criteria andBankCardAmountNotIn(List<BigDecimal> values) {
            addCriterion("bank_card_amount not in", values, "bankCardAmount");
            return (Criteria) this;
        }

        public Criteria andBankCardAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bank_card_amount between", value1, value2, "bankCardAmount");
            return (Criteria) this;
        }

        public Criteria andBankCardAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bank_card_amount not between", value1, value2, "bankCardAmount");
            return (Criteria) this;
        }

        public Criteria andAlipayAmountIsNull() {
            addCriterion("alipay_amount is null");
            return (Criteria) this;
        }

        public Criteria andAlipayAmountIsNotNull() {
            addCriterion("alipay_amount is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayAmountEqualTo(BigDecimal value) {
            addCriterion("alipay_amount =", value, "alipayAmount");
            return (Criteria) this;
        }

        public Criteria andAlipayAmountNotEqualTo(BigDecimal value) {
            addCriterion("alipay_amount <>", value, "alipayAmount");
            return (Criteria) this;
        }

        public Criteria andAlipayAmountGreaterThan(BigDecimal value) {
            addCriterion("alipay_amount >", value, "alipayAmount");
            return (Criteria) this;
        }

        public Criteria andAlipayAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("alipay_amount >=", value, "alipayAmount");
            return (Criteria) this;
        }

        public Criteria andAlipayAmountLessThan(BigDecimal value) {
            addCriterion("alipay_amount <", value, "alipayAmount");
            return (Criteria) this;
        }

        public Criteria andAlipayAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("alipay_amount <=", value, "alipayAmount");
            return (Criteria) this;
        }

        public Criteria andAlipayAmountIn(List<BigDecimal> values) {
            addCriterion("alipay_amount in", values, "alipayAmount");
            return (Criteria) this;
        }

        public Criteria andAlipayAmountNotIn(List<BigDecimal> values) {
            addCriterion("alipay_amount not in", values, "alipayAmount");
            return (Criteria) this;
        }

        public Criteria andAlipayAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("alipay_amount between", value1, value2, "alipayAmount");
            return (Criteria) this;
        }

        public Criteria andAlipayAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("alipay_amount not between", value1, value2, "alipayAmount");
            return (Criteria) this;
        }

        public Criteria andWechatAmountIsNull() {
            addCriterion("wechat_amount is null");
            return (Criteria) this;
        }

        public Criteria andWechatAmountIsNotNull() {
            addCriterion("wechat_amount is not null");
            return (Criteria) this;
        }

        public Criteria andWechatAmountEqualTo(BigDecimal value) {
            addCriterion("wechat_amount =", value, "wechatAmount");
            return (Criteria) this;
        }

        public Criteria andWechatAmountNotEqualTo(BigDecimal value) {
            addCriterion("wechat_amount <>", value, "wechatAmount");
            return (Criteria) this;
        }

        public Criteria andWechatAmountGreaterThan(BigDecimal value) {
            addCriterion("wechat_amount >", value, "wechatAmount");
            return (Criteria) this;
        }

        public Criteria andWechatAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("wechat_amount >=", value, "wechatAmount");
            return (Criteria) this;
        }

        public Criteria andWechatAmountLessThan(BigDecimal value) {
            addCriterion("wechat_amount <", value, "wechatAmount");
            return (Criteria) this;
        }

        public Criteria andWechatAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("wechat_amount <=", value, "wechatAmount");
            return (Criteria) this;
        }

        public Criteria andWechatAmountIn(List<BigDecimal> values) {
            addCriterion("wechat_amount in", values, "wechatAmount");
            return (Criteria) this;
        }

        public Criteria andWechatAmountNotIn(List<BigDecimal> values) {
            addCriterion("wechat_amount not in", values, "wechatAmount");
            return (Criteria) this;
        }

        public Criteria andWechatAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("wechat_amount between", value1, value2, "wechatAmount");
            return (Criteria) this;
        }

        public Criteria andWechatAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("wechat_amount not between", value1, value2, "wechatAmount");
            return (Criteria) this;
        }

        public Criteria andCreditCardAmountIsNull() {
            addCriterion("credit_card_amount is null");
            return (Criteria) this;
        }

        public Criteria andCreditCardAmountIsNotNull() {
            addCriterion("credit_card_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCreditCardAmountEqualTo(BigDecimal value) {
            addCriterion("credit_card_amount =", value, "creditCardAmount");
            return (Criteria) this;
        }

        public Criteria andCreditCardAmountNotEqualTo(BigDecimal value) {
            addCriterion("credit_card_amount <>", value, "creditCardAmount");
            return (Criteria) this;
        }

        public Criteria andCreditCardAmountGreaterThan(BigDecimal value) {
            addCriterion("credit_card_amount >", value, "creditCardAmount");
            return (Criteria) this;
        }

        public Criteria andCreditCardAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("credit_card_amount >=", value, "creditCardAmount");
            return (Criteria) this;
        }

        public Criteria andCreditCardAmountLessThan(BigDecimal value) {
            addCriterion("credit_card_amount <", value, "creditCardAmount");
            return (Criteria) this;
        }

        public Criteria andCreditCardAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("credit_card_amount <=", value, "creditCardAmount");
            return (Criteria) this;
        }

        public Criteria andCreditCardAmountIn(List<BigDecimal> values) {
            addCriterion("credit_card_amount in", values, "creditCardAmount");
            return (Criteria) this;
        }

        public Criteria andCreditCardAmountNotIn(List<BigDecimal> values) {
            addCriterion("credit_card_amount not in", values, "creditCardAmount");
            return (Criteria) this;
        }

        public Criteria andCreditCardAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("credit_card_amount between", value1, value2, "creditCardAmount");
            return (Criteria) this;
        }

        public Criteria andCreditCardAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("credit_card_amount not between", value1, value2, "creditCardAmount");
            return (Criteria) this;
        }

        public Criteria andOtherAmountIsNull() {
            addCriterion("other_amount is null");
            return (Criteria) this;
        }

        public Criteria andOtherAmountIsNotNull() {
            addCriterion("other_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOtherAmountEqualTo(BigDecimal value) {
            addCriterion("other_amount =", value, "otherAmount");
            return (Criteria) this;
        }

        public Criteria andOtherAmountNotEqualTo(BigDecimal value) {
            addCriterion("other_amount <>", value, "otherAmount");
            return (Criteria) this;
        }

        public Criteria andOtherAmountGreaterThan(BigDecimal value) {
            addCriterion("other_amount >", value, "otherAmount");
            return (Criteria) this;
        }

        public Criteria andOtherAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("other_amount >=", value, "otherAmount");
            return (Criteria) this;
        }

        public Criteria andOtherAmountLessThan(BigDecimal value) {
            addCriterion("other_amount <", value, "otherAmount");
            return (Criteria) this;
        }

        public Criteria andOtherAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("other_amount <=", value, "otherAmount");
            return (Criteria) this;
        }

        public Criteria andOtherAmountIn(List<BigDecimal> values) {
            addCriterion("other_amount in", values, "otherAmount");
            return (Criteria) this;
        }

        public Criteria andOtherAmountNotIn(List<BigDecimal> values) {
            addCriterion("other_amount not in", values, "otherAmount");
            return (Criteria) this;
        }

        public Criteria andOtherAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_amount between", value1, value2, "otherAmount");
            return (Criteria) this;
        }

        public Criteria andOtherAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_amount not between", value1, value2, "otherAmount");
            return (Criteria) this;
        }

        public Criteria andVerifyOperatorIdIsNull() {
            addCriterion("verify_operator_id is null");
            return (Criteria) this;
        }

        public Criteria andVerifyOperatorIdIsNotNull() {
            addCriterion("verify_operator_id is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyOperatorIdEqualTo(Long value) {
            addCriterion("verify_operator_id =", value, "verifyOperatorId");
            return (Criteria) this;
        }

        public Criteria andVerifyOperatorIdNotEqualTo(Long value) {
            addCriterion("verify_operator_id <>", value, "verifyOperatorId");
            return (Criteria) this;
        }

        public Criteria andVerifyOperatorIdGreaterThan(Long value) {
            addCriterion("verify_operator_id >", value, "verifyOperatorId");
            return (Criteria) this;
        }

        public Criteria andVerifyOperatorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("verify_operator_id >=", value, "verifyOperatorId");
            return (Criteria) this;
        }

        public Criteria andVerifyOperatorIdLessThan(Long value) {
            addCriterion("verify_operator_id <", value, "verifyOperatorId");
            return (Criteria) this;
        }

        public Criteria andVerifyOperatorIdLessThanOrEqualTo(Long value) {
            addCriterion("verify_operator_id <=", value, "verifyOperatorId");
            return (Criteria) this;
        }

        public Criteria andVerifyOperatorIdIn(List<Long> values) {
            addCriterion("verify_operator_id in", values, "verifyOperatorId");
            return (Criteria) this;
        }

        public Criteria andVerifyOperatorIdNotIn(List<Long> values) {
            addCriterion("verify_operator_id not in", values, "verifyOperatorId");
            return (Criteria) this;
        }

        public Criteria andVerifyOperatorIdBetween(Long value1, Long value2) {
            addCriterion("verify_operator_id between", value1, value2, "verifyOperatorId");
            return (Criteria) this;
        }

        public Criteria andVerifyOperatorIdNotBetween(Long value1, Long value2) {
            addCriterion("verify_operator_id not between", value1, value2, "verifyOperatorId");
            return (Criteria) this;
        }

        public Criteria andVerifyDatetimeIsNull() {
            addCriterion("verify_datetime is null");
            return (Criteria) this;
        }

        public Criteria andVerifyDatetimeIsNotNull() {
            addCriterion("verify_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyDatetimeEqualTo(Date value) {
            addCriterion("verify_datetime =", value, "verifyDatetime");
            return (Criteria) this;
        }

        public Criteria andVerifyDatetimeNotEqualTo(Date value) {
            addCriterion("verify_datetime <>", value, "verifyDatetime");
            return (Criteria) this;
        }

        public Criteria andVerifyDatetimeGreaterThan(Date value) {
            addCriterion("verify_datetime >", value, "verifyDatetime");
            return (Criteria) this;
        }

        public Criteria andVerifyDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("verify_datetime >=", value, "verifyDatetime");
            return (Criteria) this;
        }

        public Criteria andVerifyDatetimeLessThan(Date value) {
            addCriterion("verify_datetime <", value, "verifyDatetime");
            return (Criteria) this;
        }

        public Criteria andVerifyDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("verify_datetime <=", value, "verifyDatetime");
            return (Criteria) this;
        }

        public Criteria andVerifyDatetimeIn(List<Date> values) {
            addCriterion("verify_datetime in", values, "verifyDatetime");
            return (Criteria) this;
        }

        public Criteria andVerifyDatetimeNotIn(List<Date> values) {
            addCriterion("verify_datetime not in", values, "verifyDatetime");
            return (Criteria) this;
        }

        public Criteria andVerifyDatetimeBetween(Date value1, Date value2) {
            addCriterion("verify_datetime between", value1, value2, "verifyDatetime");
            return (Criteria) this;
        }

        public Criteria andVerifyDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("verify_datetime not between", value1, value2, "verifyDatetime");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusIsNull() {
            addCriterion("verify_status is null");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusIsNotNull() {
            addCriterion("verify_status is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusEqualTo(Integer value) {
            addCriterion("verify_status =", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusNotEqualTo(Integer value) {
            addCriterion("verify_status <>", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusGreaterThan(Integer value) {
            addCriterion("verify_status >", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("verify_status >=", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusLessThan(Integer value) {
            addCriterion("verify_status <", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusLessThanOrEqualTo(Integer value) {
            addCriterion("verify_status <=", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusIn(List<Integer> values) {
            addCriterion("verify_status in", values, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusNotIn(List<Integer> values) {
            addCriterion("verify_status not in", values, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusBetween(Integer value1, Integer value2) {
            addCriterion("verify_status between", value1, value2, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("verify_status not between", value1, value2, "verifyStatus");
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