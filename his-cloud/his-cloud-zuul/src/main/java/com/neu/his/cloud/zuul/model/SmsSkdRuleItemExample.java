package com.neu.his.cloud.zuul.model;

import java.util.ArrayList;
import java.util.List;

public class SmsSkdRuleItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SmsSkdRuleItemExample() {
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

        public Criteria andStaffIdIsNull() {
            addCriterion("staff_id is null");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNotNull() {
            addCriterion("staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andStaffIdEqualTo(Long value) {
            addCriterion("staff_id =", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotEqualTo(Long value) {
            addCriterion("staff_id <>", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThan(Long value) {
            addCriterion("staff_id >", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThanOrEqualTo(Long value) {
            addCriterion("staff_id >=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThan(Long value) {
            addCriterion("staff_id <", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThanOrEqualTo(Long value) {
            addCriterion("staff_id <=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdIn(List<Long> values) {
            addCriterion("staff_id in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotIn(List<Long> values) {
            addCriterion("staff_id not in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdBetween(Long value1, Long value2) {
            addCriterion("staff_id between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotBetween(Long value1, Long value2) {
            addCriterion("staff_id not between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andDaysOfWeekIsNull() {
            addCriterion("days_of_week is null");
            return (Criteria) this;
        }

        public Criteria andDaysOfWeekIsNotNull() {
            addCriterion("days_of_week is not null");
            return (Criteria) this;
        }

        public Criteria andDaysOfWeekEqualTo(String value) {
            addCriterion("days_of_week =", value, "daysOfWeek");
            return (Criteria) this;
        }

        public Criteria andDaysOfWeekNotEqualTo(String value) {
            addCriterion("days_of_week <>", value, "daysOfWeek");
            return (Criteria) this;
        }

        public Criteria andDaysOfWeekGreaterThan(String value) {
            addCriterion("days_of_week >", value, "daysOfWeek");
            return (Criteria) this;
        }

        public Criteria andDaysOfWeekGreaterThanOrEqualTo(String value) {
            addCriterion("days_of_week >=", value, "daysOfWeek");
            return (Criteria) this;
        }

        public Criteria andDaysOfWeekLessThan(String value) {
            addCriterion("days_of_week <", value, "daysOfWeek");
            return (Criteria) this;
        }

        public Criteria andDaysOfWeekLessThanOrEqualTo(String value) {
            addCriterion("days_of_week <=", value, "daysOfWeek");
            return (Criteria) this;
        }

        public Criteria andDaysOfWeekLike(String value) {
            addCriterion("days_of_week like", value, "daysOfWeek");
            return (Criteria) this;
        }

        public Criteria andDaysOfWeekNotLike(String value) {
            addCriterion("days_of_week not like", value, "daysOfWeek");
            return (Criteria) this;
        }

        public Criteria andDaysOfWeekIn(List<String> values) {
            addCriterion("days_of_week in", values, "daysOfWeek");
            return (Criteria) this;
        }

        public Criteria andDaysOfWeekNotIn(List<String> values) {
            addCriterion("days_of_week not in", values, "daysOfWeek");
            return (Criteria) this;
        }

        public Criteria andDaysOfWeekBetween(String value1, String value2) {
            addCriterion("days_of_week between", value1, value2, "daysOfWeek");
            return (Criteria) this;
        }

        public Criteria andDaysOfWeekNotBetween(String value1, String value2) {
            addCriterion("days_of_week not between", value1, value2, "daysOfWeek");
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

        public Criteria andSkLimitIsNull() {
            addCriterion("sk_limit is null");
            return (Criteria) this;
        }

        public Criteria andSkLimitIsNotNull() {
            addCriterion("sk_limit is not null");
            return (Criteria) this;
        }

        public Criteria andSkLimitEqualTo(Long value) {
            addCriterion("sk_limit =", value, "skLimit");
            return (Criteria) this;
        }

        public Criteria andSkLimitNotEqualTo(Long value) {
            addCriterion("sk_limit <>", value, "skLimit");
            return (Criteria) this;
        }

        public Criteria andSkLimitGreaterThan(Long value) {
            addCriterion("sk_limit >", value, "skLimit");
            return (Criteria) this;
        }

        public Criteria andSkLimitGreaterThanOrEqualTo(Long value) {
            addCriterion("sk_limit >=", value, "skLimit");
            return (Criteria) this;
        }

        public Criteria andSkLimitLessThan(Long value) {
            addCriterion("sk_limit <", value, "skLimit");
            return (Criteria) this;
        }

        public Criteria andSkLimitLessThanOrEqualTo(Long value) {
            addCriterion("sk_limit <=", value, "skLimit");
            return (Criteria) this;
        }

        public Criteria andSkLimitIn(List<Long> values) {
            addCriterion("sk_limit in", values, "skLimit");
            return (Criteria) this;
        }

        public Criteria andSkLimitNotIn(List<Long> values) {
            addCriterion("sk_limit not in", values, "skLimit");
            return (Criteria) this;
        }

        public Criteria andSkLimitBetween(Long value1, Long value2) {
            addCriterion("sk_limit between", value1, value2, "skLimit");
            return (Criteria) this;
        }

        public Criteria andSkLimitNotBetween(Long value1, Long value2) {
            addCriterion("sk_limit not between", value1, value2, "skLimit");
            return (Criteria) this;
        }

        public Criteria andSkRuleIdIsNull() {
            addCriterion("sk_rule_id is null");
            return (Criteria) this;
        }

        public Criteria andSkRuleIdIsNotNull() {
            addCriterion("sk_rule_id is not null");
            return (Criteria) this;
        }

        public Criteria andSkRuleIdEqualTo(Long value) {
            addCriterion("sk_rule_id =", value, "skRuleId");
            return (Criteria) this;
        }

        public Criteria andSkRuleIdNotEqualTo(Long value) {
            addCriterion("sk_rule_id <>", value, "skRuleId");
            return (Criteria) this;
        }

        public Criteria andSkRuleIdGreaterThan(Long value) {
            addCriterion("sk_rule_id >", value, "skRuleId");
            return (Criteria) this;
        }

        public Criteria andSkRuleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sk_rule_id >=", value, "skRuleId");
            return (Criteria) this;
        }

        public Criteria andSkRuleIdLessThan(Long value) {
            addCriterion("sk_rule_id <", value, "skRuleId");
            return (Criteria) this;
        }

        public Criteria andSkRuleIdLessThanOrEqualTo(Long value) {
            addCriterion("sk_rule_id <=", value, "skRuleId");
            return (Criteria) this;
        }

        public Criteria andSkRuleIdIn(List<Long> values) {
            addCriterion("sk_rule_id in", values, "skRuleId");
            return (Criteria) this;
        }

        public Criteria andSkRuleIdNotIn(List<Long> values) {
            addCriterion("sk_rule_id not in", values, "skRuleId");
            return (Criteria) this;
        }

        public Criteria andSkRuleIdBetween(Long value1, Long value2) {
            addCriterion("sk_rule_id between", value1, value2, "skRuleId");
            return (Criteria) this;
        }

        public Criteria andSkRuleIdNotBetween(Long value1, Long value2) {
            addCriterion("sk_rule_id not between", value1, value2, "skRuleId");
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