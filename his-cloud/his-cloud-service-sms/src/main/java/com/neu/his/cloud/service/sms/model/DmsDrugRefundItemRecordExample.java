package com.neu.his.cloud.service.sms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DmsDrugRefundItemRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DmsDrugRefundItemRecordExample() {
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andRegistrationIdIsNull() {
            addCriterion("registration_id is null");
            return (Criteria) this;
        }

        public Criteria andRegistrationIdIsNotNull() {
            addCriterion("registration_id is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrationIdEqualTo(Long value) {
            addCriterion("registration_id =", value, "registrationId");
            return (Criteria) this;
        }

        public Criteria andRegistrationIdNotEqualTo(Long value) {
            addCriterion("registration_id <>", value, "registrationId");
            return (Criteria) this;
        }

        public Criteria andRegistrationIdGreaterThan(Long value) {
            addCriterion("registration_id >", value, "registrationId");
            return (Criteria) this;
        }

        public Criteria andRegistrationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("registration_id >=", value, "registrationId");
            return (Criteria) this;
        }

        public Criteria andRegistrationIdLessThan(Long value) {
            addCriterion("registration_id <", value, "registrationId");
            return (Criteria) this;
        }

        public Criteria andRegistrationIdLessThanOrEqualTo(Long value) {
            addCriterion("registration_id <=", value, "registrationId");
            return (Criteria) this;
        }

        public Criteria andRegistrationIdIn(List<Long> values) {
            addCriterion("registration_id in", values, "registrationId");
            return (Criteria) this;
        }

        public Criteria andRegistrationIdNotIn(List<Long> values) {
            addCriterion("registration_id not in", values, "registrationId");
            return (Criteria) this;
        }

        public Criteria andRegistrationIdBetween(Long value1, Long value2) {
            addCriterion("registration_id between", value1, value2, "registrationId");
            return (Criteria) this;
        }

        public Criteria andRegistrationIdNotBetween(Long value1, Long value2) {
            addCriterion("registration_id not between", value1, value2, "registrationId");
            return (Criteria) this;
        }

        public Criteria andDrugIdIsNull() {
            addCriterion("drug_id is null");
            return (Criteria) this;
        }

        public Criteria andDrugIdIsNotNull() {
            addCriterion("drug_id is not null");
            return (Criteria) this;
        }

        public Criteria andDrugIdEqualTo(Long value) {
            addCriterion("drug_id =", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdNotEqualTo(Long value) {
            addCriterion("drug_id <>", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdGreaterThan(Long value) {
            addCriterion("drug_id >", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdGreaterThanOrEqualTo(Long value) {
            addCriterion("drug_id >=", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdLessThan(Long value) {
            addCriterion("drug_id <", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdLessThanOrEqualTo(Long value) {
            addCriterion("drug_id <=", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdIn(List<Long> values) {
            addCriterion("drug_id in", values, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdNotIn(List<Long> values) {
            addCriterion("drug_id not in", values, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdBetween(Long value1, Long value2) {
            addCriterion("drug_id between", value1, value2, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdNotBetween(Long value1, Long value2) {
            addCriterion("drug_id not between", value1, value2, "drugId");
            return (Criteria) this;
        }

        public Criteria andRefundNumUnitIsNull() {
            addCriterion("refund_num_unit is null");
            return (Criteria) this;
        }

        public Criteria andRefundNumUnitIsNotNull() {
            addCriterion("refund_num_unit is not null");
            return (Criteria) this;
        }

        public Criteria andRefundNumUnitEqualTo(Integer value) {
            addCriterion("refund_num_unit =", value, "refundNumUnit");
            return (Criteria) this;
        }

        public Criteria andRefundNumUnitNotEqualTo(Integer value) {
            addCriterion("refund_num_unit <>", value, "refundNumUnit");
            return (Criteria) this;
        }

        public Criteria andRefundNumUnitGreaterThan(Integer value) {
            addCriterion("refund_num_unit >", value, "refundNumUnit");
            return (Criteria) this;
        }

        public Criteria andRefundNumUnitGreaterThanOrEqualTo(Integer value) {
            addCriterion("refund_num_unit >=", value, "refundNumUnit");
            return (Criteria) this;
        }

        public Criteria andRefundNumUnitLessThan(Integer value) {
            addCriterion("refund_num_unit <", value, "refundNumUnit");
            return (Criteria) this;
        }

        public Criteria andRefundNumUnitLessThanOrEqualTo(Integer value) {
            addCriterion("refund_num_unit <=", value, "refundNumUnit");
            return (Criteria) this;
        }

        public Criteria andRefundNumUnitIn(List<Integer> values) {
            addCriterion("refund_num_unit in", values, "refundNumUnit");
            return (Criteria) this;
        }

        public Criteria andRefundNumUnitNotIn(List<Integer> values) {
            addCriterion("refund_num_unit not in", values, "refundNumUnit");
            return (Criteria) this;
        }

        public Criteria andRefundNumUnitBetween(Integer value1, Integer value2) {
            addCriterion("refund_num_unit between", value1, value2, "refundNumUnit");
            return (Criteria) this;
        }

        public Criteria andRefundNumUnitNotBetween(Integer value1, Integer value2) {
            addCriterion("refund_num_unit not between", value1, value2, "refundNumUnit");
            return (Criteria) this;
        }

        public Criteria andRefundNumIsNull() {
            addCriterion("refund_num is null");
            return (Criteria) this;
        }

        public Criteria andRefundNumIsNotNull() {
            addCriterion("refund_num is not null");
            return (Criteria) this;
        }

        public Criteria andRefundNumEqualTo(Long value) {
            addCriterion("refund_num =", value, "refundNum");
            return (Criteria) this;
        }

        public Criteria andRefundNumNotEqualTo(Long value) {
            addCriterion("refund_num <>", value, "refundNum");
            return (Criteria) this;
        }

        public Criteria andRefundNumGreaterThan(Long value) {
            addCriterion("refund_num >", value, "refundNum");
            return (Criteria) this;
        }

        public Criteria andRefundNumGreaterThanOrEqualTo(Long value) {
            addCriterion("refund_num >=", value, "refundNum");
            return (Criteria) this;
        }

        public Criteria andRefundNumLessThan(Long value) {
            addCriterion("refund_num <", value, "refundNum");
            return (Criteria) this;
        }

        public Criteria andRefundNumLessThanOrEqualTo(Long value) {
            addCriterion("refund_num <=", value, "refundNum");
            return (Criteria) this;
        }

        public Criteria andRefundNumIn(List<Long> values) {
            addCriterion("refund_num in", values, "refundNum");
            return (Criteria) this;
        }

        public Criteria andRefundNumNotIn(List<Long> values) {
            addCriterion("refund_num not in", values, "refundNum");
            return (Criteria) this;
        }

        public Criteria andRefundNumBetween(Long value1, Long value2) {
            addCriterion("refund_num between", value1, value2, "refundNum");
            return (Criteria) this;
        }

        public Criteria andRefundNumNotBetween(Long value1, Long value2) {
            addCriterion("refund_num not between", value1, value2, "refundNum");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIsNull() {
            addCriterion("refund_time is null");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIsNotNull() {
            addCriterion("refund_time is not null");
            return (Criteria) this;
        }

        public Criteria andRefundTimeEqualTo(Date value) {
            addCriterion("refund_time =", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotEqualTo(Date value) {
            addCriterion("refund_time <>", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeGreaterThan(Date value) {
            addCriterion("refund_time >", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("refund_time >=", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeLessThan(Date value) {
            addCriterion("refund_time <", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeLessThanOrEqualTo(Date value) {
            addCriterion("refund_time <=", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIn(List<Date> values) {
            addCriterion("refund_time in", values, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotIn(List<Date> values) {
            addCriterion("refund_time not in", values, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeBetween(Date value1, Date value2) {
            addCriterion("refund_time between", value1, value2, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotBetween(Date value1, Date value2) {
            addCriterion("refund_time not between", value1, value2, "refundTime");
            return (Criteria) this;
        }

        public Criteria andExcutorIdIsNull() {
            addCriterion("excutor_id is null");
            return (Criteria) this;
        }

        public Criteria andExcutorIdIsNotNull() {
            addCriterion("excutor_id is not null");
            return (Criteria) this;
        }

        public Criteria andExcutorIdEqualTo(Long value) {
            addCriterion("excutor_id =", value, "excutorId");
            return (Criteria) this;
        }

        public Criteria andExcutorIdNotEqualTo(Long value) {
            addCriterion("excutor_id <>", value, "excutorId");
            return (Criteria) this;
        }

        public Criteria andExcutorIdGreaterThan(Long value) {
            addCriterion("excutor_id >", value, "excutorId");
            return (Criteria) this;
        }

        public Criteria andExcutorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("excutor_id >=", value, "excutorId");
            return (Criteria) this;
        }

        public Criteria andExcutorIdLessThan(Long value) {
            addCriterion("excutor_id <", value, "excutorId");
            return (Criteria) this;
        }

        public Criteria andExcutorIdLessThanOrEqualTo(Long value) {
            addCriterion("excutor_id <=", value, "excutorId");
            return (Criteria) this;
        }

        public Criteria andExcutorIdIn(List<Long> values) {
            addCriterion("excutor_id in", values, "excutorId");
            return (Criteria) this;
        }

        public Criteria andExcutorIdNotIn(List<Long> values) {
            addCriterion("excutor_id not in", values, "excutorId");
            return (Criteria) this;
        }

        public Criteria andExcutorIdBetween(Long value1, Long value2) {
            addCriterion("excutor_id between", value1, value2, "excutorId");
            return (Criteria) this;
        }

        public Criteria andExcutorIdNotBetween(Long value1, Long value2) {
            addCriterion("excutor_id not between", value1, value2, "excutorId");
            return (Criteria) this;
        }

        public Criteria andRefundItemRecordIdIsNull() {
            addCriterion("refund_item_record_id is null");
            return (Criteria) this;
        }

        public Criteria andRefundItemRecordIdIsNotNull() {
            addCriterion("refund_item_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andRefundItemRecordIdEqualTo(Long value) {
            addCriterion("refund_item_record_id =", value, "refundItemRecordId");
            return (Criteria) this;
        }

        public Criteria andRefundItemRecordIdNotEqualTo(Long value) {
            addCriterion("refund_item_record_id <>", value, "refundItemRecordId");
            return (Criteria) this;
        }

        public Criteria andRefundItemRecordIdGreaterThan(Long value) {
            addCriterion("refund_item_record_id >", value, "refundItemRecordId");
            return (Criteria) this;
        }

        public Criteria andRefundItemRecordIdGreaterThanOrEqualTo(Long value) {
            addCriterion("refund_item_record_id >=", value, "refundItemRecordId");
            return (Criteria) this;
        }

        public Criteria andRefundItemRecordIdLessThan(Long value) {
            addCriterion("refund_item_record_id <", value, "refundItemRecordId");
            return (Criteria) this;
        }

        public Criteria andRefundItemRecordIdLessThanOrEqualTo(Long value) {
            addCriterion("refund_item_record_id <=", value, "refundItemRecordId");
            return (Criteria) this;
        }

        public Criteria andRefundItemRecordIdIn(List<Long> values) {
            addCriterion("refund_item_record_id in", values, "refundItemRecordId");
            return (Criteria) this;
        }

        public Criteria andRefundItemRecordIdNotIn(List<Long> values) {
            addCriterion("refund_item_record_id not in", values, "refundItemRecordId");
            return (Criteria) this;
        }

        public Criteria andRefundItemRecordIdBetween(Long value1, Long value2) {
            addCriterion("refund_item_record_id between", value1, value2, "refundItemRecordId");
            return (Criteria) this;
        }

        public Criteria andRefundItemRecordIdNotBetween(Long value1, Long value2) {
            addCriterion("refund_item_record_id not between", value1, value2, "refundItemRecordId");
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