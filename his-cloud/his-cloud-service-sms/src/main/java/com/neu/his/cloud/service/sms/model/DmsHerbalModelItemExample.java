package com.neu.his.cloud.service.sms.model;

import java.util.ArrayList;
import java.util.List;

public class DmsHerbalModelItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DmsHerbalModelItemExample() {
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

        public Criteria andFootnoteIsNull() {
            addCriterion("footnote is null");
            return (Criteria) this;
        }

        public Criteria andFootnoteIsNotNull() {
            addCriterion("footnote is not null");
            return (Criteria) this;
        }

        public Criteria andFootnoteEqualTo(String value) {
            addCriterion("footnote =", value, "footnote");
            return (Criteria) this;
        }

        public Criteria andFootnoteNotEqualTo(String value) {
            addCriterion("footnote <>", value, "footnote");
            return (Criteria) this;
        }

        public Criteria andFootnoteGreaterThan(String value) {
            addCriterion("footnote >", value, "footnote");
            return (Criteria) this;
        }

        public Criteria andFootnoteGreaterThanOrEqualTo(String value) {
            addCriterion("footnote >=", value, "footnote");
            return (Criteria) this;
        }

        public Criteria andFootnoteLessThan(String value) {
            addCriterion("footnote <", value, "footnote");
            return (Criteria) this;
        }

        public Criteria andFootnoteLessThanOrEqualTo(String value) {
            addCriterion("footnote <=", value, "footnote");
            return (Criteria) this;
        }

        public Criteria andFootnoteLike(String value) {
            addCriterion("footnote like", value, "footnote");
            return (Criteria) this;
        }

        public Criteria andFootnoteNotLike(String value) {
            addCriterion("footnote not like", value, "footnote");
            return (Criteria) this;
        }

        public Criteria andFootnoteIn(List<String> values) {
            addCriterion("footnote in", values, "footnote");
            return (Criteria) this;
        }

        public Criteria andFootnoteNotIn(List<String> values) {
            addCriterion("footnote not in", values, "footnote");
            return (Criteria) this;
        }

        public Criteria andFootnoteBetween(String value1, String value2) {
            addCriterion("footnote between", value1, value2, "footnote");
            return (Criteria) this;
        }

        public Criteria andFootnoteNotBetween(String value1, String value2) {
            addCriterion("footnote not between", value1, value2, "footnote");
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

        public Criteria andUsageNumIsNull() {
            addCriterion("usage_num is null");
            return (Criteria) this;
        }

        public Criteria andUsageNumIsNotNull() {
            addCriterion("usage_num is not null");
            return (Criteria) this;
        }

        public Criteria andUsageNumEqualTo(Long value) {
            addCriterion("usage_num =", value, "usageNum");
            return (Criteria) this;
        }

        public Criteria andUsageNumNotEqualTo(Long value) {
            addCriterion("usage_num <>", value, "usageNum");
            return (Criteria) this;
        }

        public Criteria andUsageNumGreaterThan(Long value) {
            addCriterion("usage_num >", value, "usageNum");
            return (Criteria) this;
        }

        public Criteria andUsageNumGreaterThanOrEqualTo(Long value) {
            addCriterion("usage_num >=", value, "usageNum");
            return (Criteria) this;
        }

        public Criteria andUsageNumLessThan(Long value) {
            addCriterion("usage_num <", value, "usageNum");
            return (Criteria) this;
        }

        public Criteria andUsageNumLessThanOrEqualTo(Long value) {
            addCriterion("usage_num <=", value, "usageNum");
            return (Criteria) this;
        }

        public Criteria andUsageNumIn(List<Long> values) {
            addCriterion("usage_num in", values, "usageNum");
            return (Criteria) this;
        }

        public Criteria andUsageNumNotIn(List<Long> values) {
            addCriterion("usage_num not in", values, "usageNum");
            return (Criteria) this;
        }

        public Criteria andUsageNumBetween(Long value1, Long value2) {
            addCriterion("usage_num between", value1, value2, "usageNum");
            return (Criteria) this;
        }

        public Criteria andUsageNumNotBetween(Long value1, Long value2) {
            addCriterion("usage_num not between", value1, value2, "usageNum");
            return (Criteria) this;
        }

        public Criteria andUsageNumUnitIsNull() {
            addCriterion("usage_num_unit is null");
            return (Criteria) this;
        }

        public Criteria andUsageNumUnitIsNotNull() {
            addCriterion("usage_num_unit is not null");
            return (Criteria) this;
        }

        public Criteria andUsageNumUnitEqualTo(Integer value) {
            addCriterion("usage_num_unit =", value, "usageNumUnit");
            return (Criteria) this;
        }

        public Criteria andUsageNumUnitNotEqualTo(Integer value) {
            addCriterion("usage_num_unit <>", value, "usageNumUnit");
            return (Criteria) this;
        }

        public Criteria andUsageNumUnitGreaterThan(Integer value) {
            addCriterion("usage_num_unit >", value, "usageNumUnit");
            return (Criteria) this;
        }

        public Criteria andUsageNumUnitGreaterThanOrEqualTo(Integer value) {
            addCriterion("usage_num_unit >=", value, "usageNumUnit");
            return (Criteria) this;
        }

        public Criteria andUsageNumUnitLessThan(Integer value) {
            addCriterion("usage_num_unit <", value, "usageNumUnit");
            return (Criteria) this;
        }

        public Criteria andUsageNumUnitLessThanOrEqualTo(Integer value) {
            addCriterion("usage_num_unit <=", value, "usageNumUnit");
            return (Criteria) this;
        }

        public Criteria andUsageNumUnitIn(List<Integer> values) {
            addCriterion("usage_num_unit in", values, "usageNumUnit");
            return (Criteria) this;
        }

        public Criteria andUsageNumUnitNotIn(List<Integer> values) {
            addCriterion("usage_num_unit not in", values, "usageNumUnit");
            return (Criteria) this;
        }

        public Criteria andUsageNumUnitBetween(Integer value1, Integer value2) {
            addCriterion("usage_num_unit between", value1, value2, "usageNumUnit");
            return (Criteria) this;
        }

        public Criteria andUsageNumUnitNotBetween(Integer value1, Integer value2) {
            addCriterion("usage_num_unit not between", value1, value2, "usageNumUnit");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNull() {
            addCriterion("model_id is null");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNotNull() {
            addCriterion("model_id is not null");
            return (Criteria) this;
        }

        public Criteria andModelIdEqualTo(Long value) {
            addCriterion("model_id =", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotEqualTo(Long value) {
            addCriterion("model_id <>", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThan(Long value) {
            addCriterion("model_id >", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("model_id >=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThan(Long value) {
            addCriterion("model_id <", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThanOrEqualTo(Long value) {
            addCriterion("model_id <=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdIn(List<Long> values) {
            addCriterion("model_id in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotIn(List<Long> values) {
            addCriterion("model_id not in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdBetween(Long value1, Long value2) {
            addCriterion("model_id between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotBetween(Long value1, Long value2) {
            addCriterion("model_id not between", value1, value2, "modelId");
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