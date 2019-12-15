package com.neu.his.mbg.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SmsWorkloadRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SmsWorkloadRecordExample() {
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

        public Criteria andRegistrationNumIsNull() {
            addCriterion("registration_num is null");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumIsNotNull() {
            addCriterion("registration_num is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumEqualTo(Long value) {
            addCriterion("registration_num =", value, "registrationNum");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumNotEqualTo(Long value) {
            addCriterion("registration_num <>", value, "registrationNum");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumGreaterThan(Long value) {
            addCriterion("registration_num >", value, "registrationNum");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumGreaterThanOrEqualTo(Long value) {
            addCriterion("registration_num >=", value, "registrationNum");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumLessThan(Long value) {
            addCriterion("registration_num <", value, "registrationNum");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumLessThanOrEqualTo(Long value) {
            addCriterion("registration_num <=", value, "registrationNum");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumIn(List<Long> values) {
            addCriterion("registration_num in", values, "registrationNum");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumNotIn(List<Long> values) {
            addCriterion("registration_num not in", values, "registrationNum");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumBetween(Long value1, Long value2) {
            addCriterion("registration_num between", value1, value2, "registrationNum");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumNotBetween(Long value1, Long value2) {
            addCriterion("registration_num not between", value1, value2, "registrationNum");
            return (Criteria) this;
        }

        public Criteria andExcuteCheckAmountIsNull() {
            addCriterion("excute_check_amount is null");
            return (Criteria) this;
        }

        public Criteria andExcuteCheckAmountIsNotNull() {
            addCriterion("excute_check_amount is not null");
            return (Criteria) this;
        }

        public Criteria andExcuteCheckAmountEqualTo(BigDecimal value) {
            addCriterion("excute_check_amount =", value, "excuteCheckAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteCheckAmountNotEqualTo(BigDecimal value) {
            addCriterion("excute_check_amount <>", value, "excuteCheckAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteCheckAmountGreaterThan(BigDecimal value) {
            addCriterion("excute_check_amount >", value, "excuteCheckAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteCheckAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("excute_check_amount >=", value, "excuteCheckAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteCheckAmountLessThan(BigDecimal value) {
            addCriterion("excute_check_amount <", value, "excuteCheckAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteCheckAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("excute_check_amount <=", value, "excuteCheckAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteCheckAmountIn(List<BigDecimal> values) {
            addCriterion("excute_check_amount in", values, "excuteCheckAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteCheckAmountNotIn(List<BigDecimal> values) {
            addCriterion("excute_check_amount not in", values, "excuteCheckAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteCheckAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("excute_check_amount between", value1, value2, "excuteCheckAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteCheckAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("excute_check_amount not between", value1, value2, "excuteCheckAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteTestAmountIsNull() {
            addCriterion("excute_test_amount is null");
            return (Criteria) this;
        }

        public Criteria andExcuteTestAmountIsNotNull() {
            addCriterion("excute_test_amount is not null");
            return (Criteria) this;
        }

        public Criteria andExcuteTestAmountEqualTo(BigDecimal value) {
            addCriterion("excute_test_amount =", value, "excuteTestAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteTestAmountNotEqualTo(BigDecimal value) {
            addCriterion("excute_test_amount <>", value, "excuteTestAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteTestAmountGreaterThan(BigDecimal value) {
            addCriterion("excute_test_amount >", value, "excuteTestAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteTestAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("excute_test_amount >=", value, "excuteTestAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteTestAmountLessThan(BigDecimal value) {
            addCriterion("excute_test_amount <", value, "excuteTestAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteTestAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("excute_test_amount <=", value, "excuteTestAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteTestAmountIn(List<BigDecimal> values) {
            addCriterion("excute_test_amount in", values, "excuteTestAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteTestAmountNotIn(List<BigDecimal> values) {
            addCriterion("excute_test_amount not in", values, "excuteTestAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteTestAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("excute_test_amount between", value1, value2, "excuteTestAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteTestAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("excute_test_amount not between", value1, value2, "excuteTestAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteDispositionAmountIsNull() {
            addCriterion("excute_disposition_amount is null");
            return (Criteria) this;
        }

        public Criteria andExcuteDispositionAmountIsNotNull() {
            addCriterion("excute_disposition_amount is not null");
            return (Criteria) this;
        }

        public Criteria andExcuteDispositionAmountEqualTo(BigDecimal value) {
            addCriterion("excute_disposition_amount =", value, "excuteDispositionAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteDispositionAmountNotEqualTo(BigDecimal value) {
            addCriterion("excute_disposition_amount <>", value, "excuteDispositionAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteDispositionAmountGreaterThan(BigDecimal value) {
            addCriterion("excute_disposition_amount >", value, "excuteDispositionAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteDispositionAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("excute_disposition_amount >=", value, "excuteDispositionAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteDispositionAmountLessThan(BigDecimal value) {
            addCriterion("excute_disposition_amount <", value, "excuteDispositionAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteDispositionAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("excute_disposition_amount <=", value, "excuteDispositionAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteDispositionAmountIn(List<BigDecimal> values) {
            addCriterion("excute_disposition_amount in", values, "excuteDispositionAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteDispositionAmountNotIn(List<BigDecimal> values) {
            addCriterion("excute_disposition_amount not in", values, "excuteDispositionAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteDispositionAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("excute_disposition_amount between", value1, value2, "excuteDispositionAmount");
            return (Criteria) this;
        }

        public Criteria andExcuteDispositionAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("excute_disposition_amount not between", value1, value2, "excuteDispositionAmount");
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

        public Criteria andExcuteNumIsNull() {
            addCriterion("excute_num is null");
            return (Criteria) this;
        }

        public Criteria andExcuteNumIsNotNull() {
            addCriterion("excute_num is not null");
            return (Criteria) this;
        }

        public Criteria andExcuteNumEqualTo(Long value) {
            addCriterion("excute_num =", value, "excuteNum");
            return (Criteria) this;
        }

        public Criteria andExcuteNumNotEqualTo(Long value) {
            addCriterion("excute_num <>", value, "excuteNum");
            return (Criteria) this;
        }

        public Criteria andExcuteNumGreaterThan(Long value) {
            addCriterion("excute_num >", value, "excuteNum");
            return (Criteria) this;
        }

        public Criteria andExcuteNumGreaterThanOrEqualTo(Long value) {
            addCriterion("excute_num >=", value, "excuteNum");
            return (Criteria) this;
        }

        public Criteria andExcuteNumLessThan(Long value) {
            addCriterion("excute_num <", value, "excuteNum");
            return (Criteria) this;
        }

        public Criteria andExcuteNumLessThanOrEqualTo(Long value) {
            addCriterion("excute_num <=", value, "excuteNum");
            return (Criteria) this;
        }

        public Criteria andExcuteNumIn(List<Long> values) {
            addCriterion("excute_num in", values, "excuteNum");
            return (Criteria) this;
        }

        public Criteria andExcuteNumNotIn(List<Long> values) {
            addCriterion("excute_num not in", values, "excuteNum");
            return (Criteria) this;
        }

        public Criteria andExcuteNumBetween(Long value1, Long value2) {
            addCriterion("excute_num between", value1, value2, "excuteNum");
            return (Criteria) this;
        }

        public Criteria andExcuteNumNotBetween(Long value1, Long value2) {
            addCriterion("excute_num not between", value1, value2, "excuteNum");
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