package com.neu.his.cloud.service.sms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DmsRegistrationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DmsRegistrationExample() {
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

        public Criteria andPatientIdIsNull() {
            addCriterion("patient_id is null");
            return (Criteria) this;
        }

        public Criteria andPatientIdIsNotNull() {
            addCriterion("patient_id is not null");
            return (Criteria) this;
        }

        public Criteria andPatientIdEqualTo(Long value) {
            addCriterion("patient_id =", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotEqualTo(Long value) {
            addCriterion("patient_id <>", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThan(Long value) {
            addCriterion("patient_id >", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThanOrEqualTo(Long value) {
            addCriterion("patient_id >=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThan(Long value) {
            addCriterion("patient_id <", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThanOrEqualTo(Long value) {
            addCriterion("patient_id <=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdIn(List<Long> values) {
            addCriterion("patient_id in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotIn(List<Long> values) {
            addCriterion("patient_id not in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdBetween(Long value1, Long value2) {
            addCriterion("patient_id between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotBetween(Long value1, Long value2) {
            addCriterion("patient_id not between", value1, value2, "patientId");
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

        public Criteria andEndAttendanceIsNull() {
            addCriterion("end_attendance is null");
            return (Criteria) this;
        }

        public Criteria andEndAttendanceIsNotNull() {
            addCriterion("end_attendance is not null");
            return (Criteria) this;
        }

        public Criteria andEndAttendanceEqualTo(Integer value) {
            addCriterion("end_attendance =", value, "endAttendance");
            return (Criteria) this;
        }

        public Criteria andEndAttendanceNotEqualTo(Integer value) {
            addCriterion("end_attendance <>", value, "endAttendance");
            return (Criteria) this;
        }

        public Criteria andEndAttendanceGreaterThan(Integer value) {
            addCriterion("end_attendance >", value, "endAttendance");
            return (Criteria) this;
        }

        public Criteria andEndAttendanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("end_attendance >=", value, "endAttendance");
            return (Criteria) this;
        }

        public Criteria andEndAttendanceLessThan(Integer value) {
            addCriterion("end_attendance <", value, "endAttendance");
            return (Criteria) this;
        }

        public Criteria andEndAttendanceLessThanOrEqualTo(Integer value) {
            addCriterion("end_attendance <=", value, "endAttendance");
            return (Criteria) this;
        }

        public Criteria andEndAttendanceIn(List<Integer> values) {
            addCriterion("end_attendance in", values, "endAttendance");
            return (Criteria) this;
        }

        public Criteria andEndAttendanceNotIn(List<Integer> values) {
            addCriterion("end_attendance not in", values, "endAttendance");
            return (Criteria) this;
        }

        public Criteria andEndAttendanceBetween(Integer value1, Integer value2) {
            addCriterion("end_attendance between", value1, value2, "endAttendance");
            return (Criteria) this;
        }

        public Criteria andEndAttendanceNotBetween(Integer value1, Integer value2) {
            addCriterion("end_attendance not between", value1, value2, "endAttendance");
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

        public Criteria andSkdIdIsNull() {
            addCriterion("skd_id is null");
            return (Criteria) this;
        }

        public Criteria andSkdIdIsNotNull() {
            addCriterion("skd_id is not null");
            return (Criteria) this;
        }

        public Criteria andSkdIdEqualTo(Long value) {
            addCriterion("skd_id =", value, "skdId");
            return (Criteria) this;
        }

        public Criteria andSkdIdNotEqualTo(Long value) {
            addCriterion("skd_id <>", value, "skdId");
            return (Criteria) this;
        }

        public Criteria andSkdIdGreaterThan(Long value) {
            addCriterion("skd_id >", value, "skdId");
            return (Criteria) this;
        }

        public Criteria andSkdIdGreaterThanOrEqualTo(Long value) {
            addCriterion("skd_id >=", value, "skdId");
            return (Criteria) this;
        }

        public Criteria andSkdIdLessThan(Long value) {
            addCriterion("skd_id <", value, "skdId");
            return (Criteria) this;
        }

        public Criteria andSkdIdLessThanOrEqualTo(Long value) {
            addCriterion("skd_id <=", value, "skdId");
            return (Criteria) this;
        }

        public Criteria andSkdIdIn(List<Long> values) {
            addCriterion("skd_id in", values, "skdId");
            return (Criteria) this;
        }

        public Criteria andSkdIdNotIn(List<Long> values) {
            addCriterion("skd_id not in", values, "skdId");
            return (Criteria) this;
        }

        public Criteria andSkdIdBetween(Long value1, Long value2) {
            addCriterion("skd_id between", value1, value2, "skdId");
            return (Criteria) this;
        }

        public Criteria andSkdIdNotBetween(Long value1, Long value2) {
            addCriterion("skd_id not between", value1, value2, "skdId");
            return (Criteria) this;
        }

        public Criteria andNeedBookIsNull() {
            addCriterion("need_book is null");
            return (Criteria) this;
        }

        public Criteria andNeedBookIsNotNull() {
            addCriterion("need_book is not null");
            return (Criteria) this;
        }

        public Criteria andNeedBookEqualTo(Integer value) {
            addCriterion("need_book =", value, "needBook");
            return (Criteria) this;
        }

        public Criteria andNeedBookNotEqualTo(Integer value) {
            addCriterion("need_book <>", value, "needBook");
            return (Criteria) this;
        }

        public Criteria andNeedBookGreaterThan(Integer value) {
            addCriterion("need_book >", value, "needBook");
            return (Criteria) this;
        }

        public Criteria andNeedBookGreaterThanOrEqualTo(Integer value) {
            addCriterion("need_book >=", value, "needBook");
            return (Criteria) this;
        }

        public Criteria andNeedBookLessThan(Integer value) {
            addCriterion("need_book <", value, "needBook");
            return (Criteria) this;
        }

        public Criteria andNeedBookLessThanOrEqualTo(Integer value) {
            addCriterion("need_book <=", value, "needBook");
            return (Criteria) this;
        }

        public Criteria andNeedBookIn(List<Integer> values) {
            addCriterion("need_book in", values, "needBook");
            return (Criteria) this;
        }

        public Criteria andNeedBookNotIn(List<Integer> values) {
            addCriterion("need_book not in", values, "needBook");
            return (Criteria) this;
        }

        public Criteria andNeedBookBetween(Integer value1, Integer value2) {
            addCriterion("need_book between", value1, value2, "needBook");
            return (Criteria) this;
        }

        public Criteria andNeedBookNotBetween(Integer value1, Integer value2) {
            addCriterion("need_book not between", value1, value2, "needBook");
            return (Criteria) this;
        }

        public Criteria andBindStatusIsNull() {
            addCriterion("bind_status is null");
            return (Criteria) this;
        }

        public Criteria andBindStatusIsNotNull() {
            addCriterion("bind_status is not null");
            return (Criteria) this;
        }

        public Criteria andBindStatusEqualTo(Integer value) {
            addCriterion("bind_status =", value, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andBindStatusNotEqualTo(Integer value) {
            addCriterion("bind_status <>", value, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andBindStatusGreaterThan(Integer value) {
            addCriterion("bind_status >", value, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andBindStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("bind_status >=", value, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andBindStatusLessThan(Integer value) {
            addCriterion("bind_status <", value, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andBindStatusLessThanOrEqualTo(Integer value) {
            addCriterion("bind_status <=", value, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andBindStatusIn(List<Integer> values) {
            addCriterion("bind_status in", values, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andBindStatusNotIn(List<Integer> values) {
            addCriterion("bind_status not in", values, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andBindStatusBetween(Integer value1, Integer value2) {
            addCriterion("bind_status between", value1, value2, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andBindStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("bind_status not between", value1, value2, "bindStatus");
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

        public Criteria andAttendanceDateIsNull() {
            addCriterion("attendance_date is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceDateIsNotNull() {
            addCriterion("attendance_date is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceDateEqualTo(Date value) {
            addCriterion("attendance_date =", value, "attendanceDate");
            return (Criteria) this;
        }

        public Criteria andAttendanceDateNotEqualTo(Date value) {
            addCriterion("attendance_date <>", value, "attendanceDate");
            return (Criteria) this;
        }

        public Criteria andAttendanceDateGreaterThan(Date value) {
            addCriterion("attendance_date >", value, "attendanceDate");
            return (Criteria) this;
        }

        public Criteria andAttendanceDateGreaterThanOrEqualTo(Date value) {
            addCriterion("attendance_date >=", value, "attendanceDate");
            return (Criteria) this;
        }

        public Criteria andAttendanceDateLessThan(Date value) {
            addCriterion("attendance_date <", value, "attendanceDate");
            return (Criteria) this;
        }

        public Criteria andAttendanceDateLessThanOrEqualTo(Date value) {
            addCriterion("attendance_date <=", value, "attendanceDate");
            return (Criteria) this;
        }

        public Criteria andAttendanceDateIn(List<Date> values) {
            addCriterion("attendance_date in", values, "attendanceDate");
            return (Criteria) this;
        }

        public Criteria andAttendanceDateNotIn(List<Date> values) {
            addCriterion("attendance_date not in", values, "attendanceDate");
            return (Criteria) this;
        }

        public Criteria andAttendanceDateBetween(Date value1, Date value2) {
            addCriterion("attendance_date between", value1, value2, "attendanceDate");
            return (Criteria) this;
        }

        public Criteria andAttendanceDateNotBetween(Date value1, Date value2) {
            addCriterion("attendance_date not between", value1, value2, "attendanceDate");
            return (Criteria) this;
        }

        public Criteria andPatientAgeStrIsNull() {
            addCriterion("patient_age_str is null");
            return (Criteria) this;
        }

        public Criteria andPatientAgeStrIsNotNull() {
            addCriterion("patient_age_str is not null");
            return (Criteria) this;
        }

        public Criteria andPatientAgeStrEqualTo(String value) {
            addCriterion("patient_age_str =", value, "patientAgeStr");
            return (Criteria) this;
        }

        public Criteria andPatientAgeStrNotEqualTo(String value) {
            addCriterion("patient_age_str <>", value, "patientAgeStr");
            return (Criteria) this;
        }

        public Criteria andPatientAgeStrGreaterThan(String value) {
            addCriterion("patient_age_str >", value, "patientAgeStr");
            return (Criteria) this;
        }

        public Criteria andPatientAgeStrGreaterThanOrEqualTo(String value) {
            addCriterion("patient_age_str >=", value, "patientAgeStr");
            return (Criteria) this;
        }

        public Criteria andPatientAgeStrLessThan(String value) {
            addCriterion("patient_age_str <", value, "patientAgeStr");
            return (Criteria) this;
        }

        public Criteria andPatientAgeStrLessThanOrEqualTo(String value) {
            addCriterion("patient_age_str <=", value, "patientAgeStr");
            return (Criteria) this;
        }

        public Criteria andPatientAgeStrLike(String value) {
            addCriterion("patient_age_str like", value, "patientAgeStr");
            return (Criteria) this;
        }

        public Criteria andPatientAgeStrNotLike(String value) {
            addCriterion("patient_age_str not like", value, "patientAgeStr");
            return (Criteria) this;
        }

        public Criteria andPatientAgeStrIn(List<String> values) {
            addCriterion("patient_age_str in", values, "patientAgeStr");
            return (Criteria) this;
        }

        public Criteria andPatientAgeStrNotIn(List<String> values) {
            addCriterion("patient_age_str not in", values, "patientAgeStr");
            return (Criteria) this;
        }

        public Criteria andPatientAgeStrBetween(String value1, String value2) {
            addCriterion("patient_age_str between", value1, value2, "patientAgeStr");
            return (Criteria) this;
        }

        public Criteria andPatientAgeStrNotBetween(String value1, String value2) {
            addCriterion("patient_age_str not between", value1, value2, "patientAgeStr");
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