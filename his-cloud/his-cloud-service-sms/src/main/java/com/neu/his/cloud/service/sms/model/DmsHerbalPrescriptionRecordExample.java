package com.neu.his.cloud.service.sms.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DmsHerbalPrescriptionRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DmsHerbalPrescriptionRecordExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTherapyIsNull() {
            addCriterion("therapy is null");
            return (Criteria) this;
        }

        public Criteria andTherapyIsNotNull() {
            addCriterion("therapy is not null");
            return (Criteria) this;
        }

        public Criteria andTherapyEqualTo(String value) {
            addCriterion("therapy =", value, "therapy");
            return (Criteria) this;
        }

        public Criteria andTherapyNotEqualTo(String value) {
            addCriterion("therapy <>", value, "therapy");
            return (Criteria) this;
        }

        public Criteria andTherapyGreaterThan(String value) {
            addCriterion("therapy >", value, "therapy");
            return (Criteria) this;
        }

        public Criteria andTherapyGreaterThanOrEqualTo(String value) {
            addCriterion("therapy >=", value, "therapy");
            return (Criteria) this;
        }

        public Criteria andTherapyLessThan(String value) {
            addCriterion("therapy <", value, "therapy");
            return (Criteria) this;
        }

        public Criteria andTherapyLessThanOrEqualTo(String value) {
            addCriterion("therapy <=", value, "therapy");
            return (Criteria) this;
        }

        public Criteria andTherapyLike(String value) {
            addCriterion("therapy like", value, "therapy");
            return (Criteria) this;
        }

        public Criteria andTherapyNotLike(String value) {
            addCriterion("therapy not like", value, "therapy");
            return (Criteria) this;
        }

        public Criteria andTherapyIn(List<String> values) {
            addCriterion("therapy in", values, "therapy");
            return (Criteria) this;
        }

        public Criteria andTherapyNotIn(List<String> values) {
            addCriterion("therapy not in", values, "therapy");
            return (Criteria) this;
        }

        public Criteria andTherapyBetween(String value1, String value2) {
            addCriterion("therapy between", value1, value2, "therapy");
            return (Criteria) this;
        }

        public Criteria andTherapyNotBetween(String value1, String value2) {
            addCriterion("therapy not between", value1, value2, "therapy");
            return (Criteria) this;
        }

        public Criteria andTherapyDetailsIsNull() {
            addCriterion("therapy_details is null");
            return (Criteria) this;
        }

        public Criteria andTherapyDetailsIsNotNull() {
            addCriterion("therapy_details is not null");
            return (Criteria) this;
        }

        public Criteria andTherapyDetailsEqualTo(String value) {
            addCriterion("therapy_details =", value, "therapyDetails");
            return (Criteria) this;
        }

        public Criteria andTherapyDetailsNotEqualTo(String value) {
            addCriterion("therapy_details <>", value, "therapyDetails");
            return (Criteria) this;
        }

        public Criteria andTherapyDetailsGreaterThan(String value) {
            addCriterion("therapy_details >", value, "therapyDetails");
            return (Criteria) this;
        }

        public Criteria andTherapyDetailsGreaterThanOrEqualTo(String value) {
            addCriterion("therapy_details >=", value, "therapyDetails");
            return (Criteria) this;
        }

        public Criteria andTherapyDetailsLessThan(String value) {
            addCriterion("therapy_details <", value, "therapyDetails");
            return (Criteria) this;
        }

        public Criteria andTherapyDetailsLessThanOrEqualTo(String value) {
            addCriterion("therapy_details <=", value, "therapyDetails");
            return (Criteria) this;
        }

        public Criteria andTherapyDetailsLike(String value) {
            addCriterion("therapy_details like", value, "therapyDetails");
            return (Criteria) this;
        }

        public Criteria andTherapyDetailsNotLike(String value) {
            addCriterion("therapy_details not like", value, "therapyDetails");
            return (Criteria) this;
        }

        public Criteria andTherapyDetailsIn(List<String> values) {
            addCriterion("therapy_details in", values, "therapyDetails");
            return (Criteria) this;
        }

        public Criteria andTherapyDetailsNotIn(List<String> values) {
            addCriterion("therapy_details not in", values, "therapyDetails");
            return (Criteria) this;
        }

        public Criteria andTherapyDetailsBetween(String value1, String value2) {
            addCriterion("therapy_details between", value1, value2, "therapyDetails");
            return (Criteria) this;
        }

        public Criteria andTherapyDetailsNotBetween(String value1, String value2) {
            addCriterion("therapy_details not between", value1, value2, "therapyDetails");
            return (Criteria) this;
        }

        public Criteria andMedicalAdviceIsNull() {
            addCriterion("medical_advice is null");
            return (Criteria) this;
        }

        public Criteria andMedicalAdviceIsNotNull() {
            addCriterion("medical_advice is not null");
            return (Criteria) this;
        }

        public Criteria andMedicalAdviceEqualTo(String value) {
            addCriterion("medical_advice =", value, "medicalAdvice");
            return (Criteria) this;
        }

        public Criteria andMedicalAdviceNotEqualTo(String value) {
            addCriterion("medical_advice <>", value, "medicalAdvice");
            return (Criteria) this;
        }

        public Criteria andMedicalAdviceGreaterThan(String value) {
            addCriterion("medical_advice >", value, "medicalAdvice");
            return (Criteria) this;
        }

        public Criteria andMedicalAdviceGreaterThanOrEqualTo(String value) {
            addCriterion("medical_advice >=", value, "medicalAdvice");
            return (Criteria) this;
        }

        public Criteria andMedicalAdviceLessThan(String value) {
            addCriterion("medical_advice <", value, "medicalAdvice");
            return (Criteria) this;
        }

        public Criteria andMedicalAdviceLessThanOrEqualTo(String value) {
            addCriterion("medical_advice <=", value, "medicalAdvice");
            return (Criteria) this;
        }

        public Criteria andMedicalAdviceLike(String value) {
            addCriterion("medical_advice like", value, "medicalAdvice");
            return (Criteria) this;
        }

        public Criteria andMedicalAdviceNotLike(String value) {
            addCriterion("medical_advice not like", value, "medicalAdvice");
            return (Criteria) this;
        }

        public Criteria andMedicalAdviceIn(List<String> values) {
            addCriterion("medical_advice in", values, "medicalAdvice");
            return (Criteria) this;
        }

        public Criteria andMedicalAdviceNotIn(List<String> values) {
            addCriterion("medical_advice not in", values, "medicalAdvice");
            return (Criteria) this;
        }

        public Criteria andMedicalAdviceBetween(String value1, String value2) {
            addCriterion("medical_advice between", value1, value2, "medicalAdvice");
            return (Criteria) this;
        }

        public Criteria andMedicalAdviceNotBetween(String value1, String value2) {
            addCriterion("medical_advice not between", value1, value2, "medicalAdvice");
            return (Criteria) this;
        }

        public Criteria andPairNumIsNull() {
            addCriterion("pair_num is null");
            return (Criteria) this;
        }

        public Criteria andPairNumIsNotNull() {
            addCriterion("pair_num is not null");
            return (Criteria) this;
        }

        public Criteria andPairNumEqualTo(Long value) {
            addCriterion("pair_num =", value, "pairNum");
            return (Criteria) this;
        }

        public Criteria andPairNumNotEqualTo(Long value) {
            addCriterion("pair_num <>", value, "pairNum");
            return (Criteria) this;
        }

        public Criteria andPairNumGreaterThan(Long value) {
            addCriterion("pair_num >", value, "pairNum");
            return (Criteria) this;
        }

        public Criteria andPairNumGreaterThanOrEqualTo(Long value) {
            addCriterion("pair_num >=", value, "pairNum");
            return (Criteria) this;
        }

        public Criteria andPairNumLessThan(Long value) {
            addCriterion("pair_num <", value, "pairNum");
            return (Criteria) this;
        }

        public Criteria andPairNumLessThanOrEqualTo(Long value) {
            addCriterion("pair_num <=", value, "pairNum");
            return (Criteria) this;
        }

        public Criteria andPairNumIn(List<Long> values) {
            addCriterion("pair_num in", values, "pairNum");
            return (Criteria) this;
        }

        public Criteria andPairNumNotIn(List<Long> values) {
            addCriterion("pair_num not in", values, "pairNum");
            return (Criteria) this;
        }

        public Criteria andPairNumBetween(Long value1, Long value2) {
            addCriterion("pair_num between", value1, value2, "pairNum");
            return (Criteria) this;
        }

        public Criteria andPairNumNotBetween(Long value1, Long value2) {
            addCriterion("pair_num not between", value1, value2, "pairNum");
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

        public Criteria andFrequencyIsNull() {
            addCriterion("frequency is null");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNotNull() {
            addCriterion("frequency is not null");
            return (Criteria) this;
        }

        public Criteria andFrequencyEqualTo(Integer value) {
            addCriterion("frequency =", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotEqualTo(Integer value) {
            addCriterion("frequency <>", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThan(Integer value) {
            addCriterion("frequency >", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("frequency >=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThan(Integer value) {
            addCriterion("frequency <", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThanOrEqualTo(Integer value) {
            addCriterion("frequency <=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyIn(List<Integer> values) {
            addCriterion("frequency in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotIn(List<Integer> values) {
            addCriterion("frequency not in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyBetween(Integer value1, Integer value2) {
            addCriterion("frequency between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotBetween(Integer value1, Integer value2) {
            addCriterion("frequency not between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andUsageMeansIsNull() {
            addCriterion("usage_means is null");
            return (Criteria) this;
        }

        public Criteria andUsageMeansIsNotNull() {
            addCriterion("usage_means is not null");
            return (Criteria) this;
        }

        public Criteria andUsageMeansEqualTo(Integer value) {
            addCriterion("usage_means =", value, "usageMeans");
            return (Criteria) this;
        }

        public Criteria andUsageMeansNotEqualTo(Integer value) {
            addCriterion("usage_means <>", value, "usageMeans");
            return (Criteria) this;
        }

        public Criteria andUsageMeansGreaterThan(Integer value) {
            addCriterion("usage_means >", value, "usageMeans");
            return (Criteria) this;
        }

        public Criteria andUsageMeansGreaterThanOrEqualTo(Integer value) {
            addCriterion("usage_means >=", value, "usageMeans");
            return (Criteria) this;
        }

        public Criteria andUsageMeansLessThan(Integer value) {
            addCriterion("usage_means <", value, "usageMeans");
            return (Criteria) this;
        }

        public Criteria andUsageMeansLessThanOrEqualTo(Integer value) {
            addCriterion("usage_means <=", value, "usageMeans");
            return (Criteria) this;
        }

        public Criteria andUsageMeansIn(List<Integer> values) {
            addCriterion("usage_means in", values, "usageMeans");
            return (Criteria) this;
        }

        public Criteria andUsageMeansNotIn(List<Integer> values) {
            addCriterion("usage_means not in", values, "usageMeans");
            return (Criteria) this;
        }

        public Criteria andUsageMeansBetween(Integer value1, Integer value2) {
            addCriterion("usage_means between", value1, value2, "usageMeans");
            return (Criteria) this;
        }

        public Criteria andUsageMeansNotBetween(Integer value1, Integer value2) {
            addCriterion("usage_means not between", value1, value2, "usageMeans");
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

        public Criteria andCreateStaffIdIsNull() {
            addCriterion("create_staff_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdIsNotNull() {
            addCriterion("create_staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdEqualTo(Long value) {
            addCriterion("create_staff_id =", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdNotEqualTo(Long value) {
            addCriterion("create_staff_id <>", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdGreaterThan(Long value) {
            addCriterion("create_staff_id >", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdGreaterThanOrEqualTo(Long value) {
            addCriterion("create_staff_id >=", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdLessThan(Long value) {
            addCriterion("create_staff_id <", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdLessThanOrEqualTo(Long value) {
            addCriterion("create_staff_id <=", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdIn(List<Long> values) {
            addCriterion("create_staff_id in", values, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdNotIn(List<Long> values) {
            addCriterion("create_staff_id not in", values, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdBetween(Long value1, Long value2) {
            addCriterion("create_staff_id between", value1, value2, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdNotBetween(Long value1, Long value2) {
            addCriterion("create_staff_id not between", value1, value2, "createStaffId");
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