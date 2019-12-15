package com.neu.his.cloud.api.pc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SmsSkdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SmsSkdExample() {
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

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterion("date not between", value1, value2, "date");
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

        public Criteria andRemainIsNull() {
            addCriterion("remain is null");
            return (Criteria) this;
        }

        public Criteria andRemainIsNotNull() {
            addCriterion("remain is not null");
            return (Criteria) this;
        }

        public Criteria andRemainEqualTo(Long value) {
            addCriterion("remain =", value, "remain");
            return (Criteria) this;
        }

        public Criteria andRemainNotEqualTo(Long value) {
            addCriterion("remain <>", value, "remain");
            return (Criteria) this;
        }

        public Criteria andRemainGreaterThan(Long value) {
            addCriterion("remain >", value, "remain");
            return (Criteria) this;
        }

        public Criteria andRemainGreaterThanOrEqualTo(Long value) {
            addCriterion("remain >=", value, "remain");
            return (Criteria) this;
        }

        public Criteria andRemainLessThan(Long value) {
            addCriterion("remain <", value, "remain");
            return (Criteria) this;
        }

        public Criteria andRemainLessThanOrEqualTo(Long value) {
            addCriterion("remain <=", value, "remain");
            return (Criteria) this;
        }

        public Criteria andRemainIn(List<Long> values) {
            addCriterion("remain in", values, "remain");
            return (Criteria) this;
        }

        public Criteria andRemainNotIn(List<Long> values) {
            addCriterion("remain not in", values, "remain");
            return (Criteria) this;
        }

        public Criteria andRemainBetween(Long value1, Long value2) {
            addCriterion("remain between", value1, value2, "remain");
            return (Criteria) this;
        }

        public Criteria andRemainNotBetween(Long value1, Long value2) {
            addCriterion("remain not between", value1, value2, "remain");
            return (Criteria) this;
        }

        public Criteria andNoonIsNull() {
            addCriterion("noon is null");
            return (Criteria) this;
        }

        public Criteria andNoonIsNotNull() {
            addCriterion("noon is not null");
            return (Criteria) this;
        }

        public Criteria andNoonEqualTo(Integer value) {
            addCriterion("noon =", value, "noon");
            return (Criteria) this;
        }

        public Criteria andNoonNotEqualTo(Integer value) {
            addCriterion("noon <>", value, "noon");
            return (Criteria) this;
        }

        public Criteria andNoonGreaterThan(Integer value) {
            addCriterion("noon >", value, "noon");
            return (Criteria) this;
        }

        public Criteria andNoonGreaterThanOrEqualTo(Integer value) {
            addCriterion("noon >=", value, "noon");
            return (Criteria) this;
        }

        public Criteria andNoonLessThan(Integer value) {
            addCriterion("noon <", value, "noon");
            return (Criteria) this;
        }

        public Criteria andNoonLessThanOrEqualTo(Integer value) {
            addCriterion("noon <=", value, "noon");
            return (Criteria) this;
        }

        public Criteria andNoonIn(List<Integer> values) {
            addCriterion("noon in", values, "noon");
            return (Criteria) this;
        }

        public Criteria andNoonNotIn(List<Integer> values) {
            addCriterion("noon not in", values, "noon");
            return (Criteria) this;
        }

        public Criteria andNoonBetween(Integer value1, Integer value2) {
            addCriterion("noon between", value1, value2, "noon");
            return (Criteria) this;
        }

        public Criteria andNoonNotBetween(Integer value1, Integer value2) {
            addCriterion("noon not between", value1, value2, "noon");
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

        public Criteria andDeptIdIsNull() {
            addCriterion("dept_id is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(Long value) {
            addCriterion("dept_id =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(Long value) {
            addCriterion("dept_id <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(Long value) {
            addCriterion("dept_id >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(Long value) {
            addCriterion("dept_id >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(Long value) {
            addCriterion("dept_id <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(Long value) {
            addCriterion("dept_id <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<Long> values) {
            addCriterion("dept_id in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<Long> values) {
            addCriterion("dept_id not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(Long value1, Long value2) {
            addCriterion("dept_id between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(Long value1, Long value2) {
            addCriterion("dept_id not between", value1, value2, "deptId");
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