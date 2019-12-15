package com.neu.his.cloud.service.pms.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DmsNonDrugItemRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DmsNonDrugItemRecordExample() {
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

        public Criteria andAimIsNull() {
            addCriterion("aim is null");
            return (Criteria) this;
        }

        public Criteria andAimIsNotNull() {
            addCriterion("aim is not null");
            return (Criteria) this;
        }

        public Criteria andAimEqualTo(String value) {
            addCriterion("aim =", value, "aim");
            return (Criteria) this;
        }

        public Criteria andAimNotEqualTo(String value) {
            addCriterion("aim <>", value, "aim");
            return (Criteria) this;
        }

        public Criteria andAimGreaterThan(String value) {
            addCriterion("aim >", value, "aim");
            return (Criteria) this;
        }

        public Criteria andAimGreaterThanOrEqualTo(String value) {
            addCriterion("aim >=", value, "aim");
            return (Criteria) this;
        }

        public Criteria andAimLessThan(String value) {
            addCriterion("aim <", value, "aim");
            return (Criteria) this;
        }

        public Criteria andAimLessThanOrEqualTo(String value) {
            addCriterion("aim <=", value, "aim");
            return (Criteria) this;
        }

        public Criteria andAimLike(String value) {
            addCriterion("aim like", value, "aim");
            return (Criteria) this;
        }

        public Criteria andAimNotLike(String value) {
            addCriterion("aim not like", value, "aim");
            return (Criteria) this;
        }

        public Criteria andAimIn(List<String> values) {
            addCriterion("aim in", values, "aim");
            return (Criteria) this;
        }

        public Criteria andAimNotIn(List<String> values) {
            addCriterion("aim not in", values, "aim");
            return (Criteria) this;
        }

        public Criteria andAimBetween(String value1, String value2) {
            addCriterion("aim between", value1, value2, "aim");
            return (Criteria) this;
        }

        public Criteria andAimNotBetween(String value1, String value2) {
            addCriterion("aim not between", value1, value2, "aim");
            return (Criteria) this;
        }

        public Criteria andDemandIsNull() {
            addCriterion("demand is null");
            return (Criteria) this;
        }

        public Criteria andDemandIsNotNull() {
            addCriterion("demand is not null");
            return (Criteria) this;
        }

        public Criteria andDemandEqualTo(String value) {
            addCriterion("demand =", value, "demand");
            return (Criteria) this;
        }

        public Criteria andDemandNotEqualTo(String value) {
            addCriterion("demand <>", value, "demand");
            return (Criteria) this;
        }

        public Criteria andDemandGreaterThan(String value) {
            addCriterion("demand >", value, "demand");
            return (Criteria) this;
        }

        public Criteria andDemandGreaterThanOrEqualTo(String value) {
            addCriterion("demand >=", value, "demand");
            return (Criteria) this;
        }

        public Criteria andDemandLessThan(String value) {
            addCriterion("demand <", value, "demand");
            return (Criteria) this;
        }

        public Criteria andDemandLessThanOrEqualTo(String value) {
            addCriterion("demand <=", value, "demand");
            return (Criteria) this;
        }

        public Criteria andDemandLike(String value) {
            addCriterion("demand like", value, "demand");
            return (Criteria) this;
        }

        public Criteria andDemandNotLike(String value) {
            addCriterion("demand not like", value, "demand");
            return (Criteria) this;
        }

        public Criteria andDemandIn(List<String> values) {
            addCriterion("demand in", values, "demand");
            return (Criteria) this;
        }

        public Criteria andDemandNotIn(List<String> values) {
            addCriterion("demand not in", values, "demand");
            return (Criteria) this;
        }

        public Criteria andDemandBetween(String value1, String value2) {
            addCriterion("demand between", value1, value2, "demand");
            return (Criteria) this;
        }

        public Criteria andDemandNotBetween(String value1, String value2) {
            addCriterion("demand not between", value1, value2, "demand");
            return (Criteria) this;
        }

        public Criteria andLogStatusIsNull() {
            addCriterion("log_status is null");
            return (Criteria) this;
        }

        public Criteria andLogStatusIsNotNull() {
            addCriterion("log_status is not null");
            return (Criteria) this;
        }

        public Criteria andLogStatusEqualTo(Integer value) {
            addCriterion("log_status =", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusNotEqualTo(Integer value) {
            addCriterion("log_status <>", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusGreaterThan(Integer value) {
            addCriterion("log_status >", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("log_status >=", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusLessThan(Integer value) {
            addCriterion("log_status <", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusLessThanOrEqualTo(Integer value) {
            addCriterion("log_status <=", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusIn(List<Integer> values) {
            addCriterion("log_status in", values, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusNotIn(List<Integer> values) {
            addCriterion("log_status not in", values, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusBetween(Integer value1, Integer value2) {
            addCriterion("log_status between", value1, value2, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("log_status not between", value1, value2, "logStatus");
            return (Criteria) this;
        }

        public Criteria andCheckResultIsNull() {
            addCriterion("check_result is null");
            return (Criteria) this;
        }

        public Criteria andCheckResultIsNotNull() {
            addCriterion("check_result is not null");
            return (Criteria) this;
        }

        public Criteria andCheckResultEqualTo(String value) {
            addCriterion("check_result =", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotEqualTo(String value) {
            addCriterion("check_result <>", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultGreaterThan(String value) {
            addCriterion("check_result >", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultGreaterThanOrEqualTo(String value) {
            addCriterion("check_result >=", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultLessThan(String value) {
            addCriterion("check_result <", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultLessThanOrEqualTo(String value) {
            addCriterion("check_result <=", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultLike(String value) {
            addCriterion("check_result like", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotLike(String value) {
            addCriterion("check_result not like", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultIn(List<String> values) {
            addCriterion("check_result in", values, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotIn(List<String> values) {
            addCriterion("check_result not in", values, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultBetween(String value1, String value2) {
            addCriterion("check_result between", value1, value2, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotBetween(String value1, String value2) {
            addCriterion("check_result not between", value1, value2, "checkResult");
            return (Criteria) this;
        }

        public Criteria andResultImgUrlListIsNull() {
            addCriterion("result_img_url_list is null");
            return (Criteria) this;
        }

        public Criteria andResultImgUrlListIsNotNull() {
            addCriterion("result_img_url_list is not null");
            return (Criteria) this;
        }

        public Criteria andResultImgUrlListEqualTo(String value) {
            addCriterion("result_img_url_list =", value, "resultImgUrlList");
            return (Criteria) this;
        }

        public Criteria andResultImgUrlListNotEqualTo(String value) {
            addCriterion("result_img_url_list <>", value, "resultImgUrlList");
            return (Criteria) this;
        }

        public Criteria andResultImgUrlListGreaterThan(String value) {
            addCriterion("result_img_url_list >", value, "resultImgUrlList");
            return (Criteria) this;
        }

        public Criteria andResultImgUrlListGreaterThanOrEqualTo(String value) {
            addCriterion("result_img_url_list >=", value, "resultImgUrlList");
            return (Criteria) this;
        }

        public Criteria andResultImgUrlListLessThan(String value) {
            addCriterion("result_img_url_list <", value, "resultImgUrlList");
            return (Criteria) this;
        }

        public Criteria andResultImgUrlListLessThanOrEqualTo(String value) {
            addCriterion("result_img_url_list <=", value, "resultImgUrlList");
            return (Criteria) this;
        }

        public Criteria andResultImgUrlListLike(String value) {
            addCriterion("result_img_url_list like", value, "resultImgUrlList");
            return (Criteria) this;
        }

        public Criteria andResultImgUrlListNotLike(String value) {
            addCriterion("result_img_url_list not like", value, "resultImgUrlList");
            return (Criteria) this;
        }

        public Criteria andResultImgUrlListIn(List<String> values) {
            addCriterion("result_img_url_list in", values, "resultImgUrlList");
            return (Criteria) this;
        }

        public Criteria andResultImgUrlListNotIn(List<String> values) {
            addCriterion("result_img_url_list not in", values, "resultImgUrlList");
            return (Criteria) this;
        }

        public Criteria andResultImgUrlListBetween(String value1, String value2) {
            addCriterion("result_img_url_list between", value1, value2, "resultImgUrlList");
            return (Criteria) this;
        }

        public Criteria andResultImgUrlListNotBetween(String value1, String value2) {
            addCriterion("result_img_url_list not between", value1, value2, "resultImgUrlList");
            return (Criteria) this;
        }

        public Criteria andClinicalImpressionIsNull() {
            addCriterion("clinical_impression is null");
            return (Criteria) this;
        }

        public Criteria andClinicalImpressionIsNotNull() {
            addCriterion("clinical_impression is not null");
            return (Criteria) this;
        }

        public Criteria andClinicalImpressionEqualTo(String value) {
            addCriterion("clinical_impression =", value, "clinicalImpression");
            return (Criteria) this;
        }

        public Criteria andClinicalImpressionNotEqualTo(String value) {
            addCriterion("clinical_impression <>", value, "clinicalImpression");
            return (Criteria) this;
        }

        public Criteria andClinicalImpressionGreaterThan(String value) {
            addCriterion("clinical_impression >", value, "clinicalImpression");
            return (Criteria) this;
        }

        public Criteria andClinicalImpressionGreaterThanOrEqualTo(String value) {
            addCriterion("clinical_impression >=", value, "clinicalImpression");
            return (Criteria) this;
        }

        public Criteria andClinicalImpressionLessThan(String value) {
            addCriterion("clinical_impression <", value, "clinicalImpression");
            return (Criteria) this;
        }

        public Criteria andClinicalImpressionLessThanOrEqualTo(String value) {
            addCriterion("clinical_impression <=", value, "clinicalImpression");
            return (Criteria) this;
        }

        public Criteria andClinicalImpressionLike(String value) {
            addCriterion("clinical_impression like", value, "clinicalImpression");
            return (Criteria) this;
        }

        public Criteria andClinicalImpressionNotLike(String value) {
            addCriterion("clinical_impression not like", value, "clinicalImpression");
            return (Criteria) this;
        }

        public Criteria andClinicalImpressionIn(List<String> values) {
            addCriterion("clinical_impression in", values, "clinicalImpression");
            return (Criteria) this;
        }

        public Criteria andClinicalImpressionNotIn(List<String> values) {
            addCriterion("clinical_impression not in", values, "clinicalImpression");
            return (Criteria) this;
        }

        public Criteria andClinicalImpressionBetween(String value1, String value2) {
            addCriterion("clinical_impression between", value1, value2, "clinicalImpression");
            return (Criteria) this;
        }

        public Criteria andClinicalImpressionNotBetween(String value1, String value2) {
            addCriterion("clinical_impression not between", value1, value2, "clinicalImpression");
            return (Criteria) this;
        }

        public Criteria andClinicalDiagnosisIsNull() {
            addCriterion("clinical_diagnosis is null");
            return (Criteria) this;
        }

        public Criteria andClinicalDiagnosisIsNotNull() {
            addCriterion("clinical_diagnosis is not null");
            return (Criteria) this;
        }

        public Criteria andClinicalDiagnosisEqualTo(String value) {
            addCriterion("clinical_diagnosis =", value, "clinicalDiagnosis");
            return (Criteria) this;
        }

        public Criteria andClinicalDiagnosisNotEqualTo(String value) {
            addCriterion("clinical_diagnosis <>", value, "clinicalDiagnosis");
            return (Criteria) this;
        }

        public Criteria andClinicalDiagnosisGreaterThan(String value) {
            addCriterion("clinical_diagnosis >", value, "clinicalDiagnosis");
            return (Criteria) this;
        }

        public Criteria andClinicalDiagnosisGreaterThanOrEqualTo(String value) {
            addCriterion("clinical_diagnosis >=", value, "clinicalDiagnosis");
            return (Criteria) this;
        }

        public Criteria andClinicalDiagnosisLessThan(String value) {
            addCriterion("clinical_diagnosis <", value, "clinicalDiagnosis");
            return (Criteria) this;
        }

        public Criteria andClinicalDiagnosisLessThanOrEqualTo(String value) {
            addCriterion("clinical_diagnosis <=", value, "clinicalDiagnosis");
            return (Criteria) this;
        }

        public Criteria andClinicalDiagnosisLike(String value) {
            addCriterion("clinical_diagnosis like", value, "clinicalDiagnosis");
            return (Criteria) this;
        }

        public Criteria andClinicalDiagnosisNotLike(String value) {
            addCriterion("clinical_diagnosis not like", value, "clinicalDiagnosis");
            return (Criteria) this;
        }

        public Criteria andClinicalDiagnosisIn(List<String> values) {
            addCriterion("clinical_diagnosis in", values, "clinicalDiagnosis");
            return (Criteria) this;
        }

        public Criteria andClinicalDiagnosisNotIn(List<String> values) {
            addCriterion("clinical_diagnosis not in", values, "clinicalDiagnosis");
            return (Criteria) this;
        }

        public Criteria andClinicalDiagnosisBetween(String value1, String value2) {
            addCriterion("clinical_diagnosis between", value1, value2, "clinicalDiagnosis");
            return (Criteria) this;
        }

        public Criteria andClinicalDiagnosisNotBetween(String value1, String value2) {
            addCriterion("clinical_diagnosis not between", value1, value2, "clinicalDiagnosis");
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

        public Criteria andExcuteStaffIdIsNull() {
            addCriterion("excute_staff_id is null");
            return (Criteria) this;
        }

        public Criteria andExcuteStaffIdIsNotNull() {
            addCriterion("excute_staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andExcuteStaffIdEqualTo(Long value) {
            addCriterion("excute_staff_id =", value, "excuteStaffId");
            return (Criteria) this;
        }

        public Criteria andExcuteStaffIdNotEqualTo(Long value) {
            addCriterion("excute_staff_id <>", value, "excuteStaffId");
            return (Criteria) this;
        }

        public Criteria andExcuteStaffIdGreaterThan(Long value) {
            addCriterion("excute_staff_id >", value, "excuteStaffId");
            return (Criteria) this;
        }

        public Criteria andExcuteStaffIdGreaterThanOrEqualTo(Long value) {
            addCriterion("excute_staff_id >=", value, "excuteStaffId");
            return (Criteria) this;
        }

        public Criteria andExcuteStaffIdLessThan(Long value) {
            addCriterion("excute_staff_id <", value, "excuteStaffId");
            return (Criteria) this;
        }

        public Criteria andExcuteStaffIdLessThanOrEqualTo(Long value) {
            addCriterion("excute_staff_id <=", value, "excuteStaffId");
            return (Criteria) this;
        }

        public Criteria andExcuteStaffIdIn(List<Long> values) {
            addCriterion("excute_staff_id in", values, "excuteStaffId");
            return (Criteria) this;
        }

        public Criteria andExcuteStaffIdNotIn(List<Long> values) {
            addCriterion("excute_staff_id not in", values, "excuteStaffId");
            return (Criteria) this;
        }

        public Criteria andExcuteStaffIdBetween(Long value1, Long value2) {
            addCriterion("excute_staff_id between", value1, value2, "excuteStaffId");
            return (Criteria) this;
        }

        public Criteria andExcuteStaffIdNotBetween(Long value1, Long value2) {
            addCriterion("excute_staff_id not between", value1, value2, "excuteStaffId");
            return (Criteria) this;
        }

        public Criteria andLogDatetimeIsNull() {
            addCriterion("log_datetime is null");
            return (Criteria) this;
        }

        public Criteria andLogDatetimeIsNotNull() {
            addCriterion("log_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andLogDatetimeEqualTo(Date value) {
            addCriterion("log_datetime =", value, "logDatetime");
            return (Criteria) this;
        }

        public Criteria andLogDatetimeNotEqualTo(Date value) {
            addCriterion("log_datetime <>", value, "logDatetime");
            return (Criteria) this;
        }

        public Criteria andLogDatetimeGreaterThan(Date value) {
            addCriterion("log_datetime >", value, "logDatetime");
            return (Criteria) this;
        }

        public Criteria andLogDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("log_datetime >=", value, "logDatetime");
            return (Criteria) this;
        }

        public Criteria andLogDatetimeLessThan(Date value) {
            addCriterion("log_datetime <", value, "logDatetime");
            return (Criteria) this;
        }

        public Criteria andLogDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("log_datetime <=", value, "logDatetime");
            return (Criteria) this;
        }

        public Criteria andLogDatetimeIn(List<Date> values) {
            addCriterion("log_datetime in", values, "logDatetime");
            return (Criteria) this;
        }

        public Criteria andLogDatetimeNotIn(List<Date> values) {
            addCriterion("log_datetime not in", values, "logDatetime");
            return (Criteria) this;
        }

        public Criteria andLogDatetimeBetween(Date value1, Date value2) {
            addCriterion("log_datetime between", value1, value2, "logDatetime");
            return (Criteria) this;
        }

        public Criteria andLogDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("log_datetime not between", value1, value2, "logDatetime");
            return (Criteria) this;
        }

        public Criteria andNoDrugIdIsNull() {
            addCriterion("no_drug_id is null");
            return (Criteria) this;
        }

        public Criteria andNoDrugIdIsNotNull() {
            addCriterion("no_drug_id is not null");
            return (Criteria) this;
        }

        public Criteria andNoDrugIdEqualTo(Long value) {
            addCriterion("no_drug_id =", value, "noDrugId");
            return (Criteria) this;
        }

        public Criteria andNoDrugIdNotEqualTo(Long value) {
            addCriterion("no_drug_id <>", value, "noDrugId");
            return (Criteria) this;
        }

        public Criteria andNoDrugIdGreaterThan(Long value) {
            addCriterion("no_drug_id >", value, "noDrugId");
            return (Criteria) this;
        }

        public Criteria andNoDrugIdGreaterThanOrEqualTo(Long value) {
            addCriterion("no_drug_id >=", value, "noDrugId");
            return (Criteria) this;
        }

        public Criteria andNoDrugIdLessThan(Long value) {
            addCriterion("no_drug_id <", value, "noDrugId");
            return (Criteria) this;
        }

        public Criteria andNoDrugIdLessThanOrEqualTo(Long value) {
            addCriterion("no_drug_id <=", value, "noDrugId");
            return (Criteria) this;
        }

        public Criteria andNoDrugIdIn(List<Long> values) {
            addCriterion("no_drug_id in", values, "noDrugId");
            return (Criteria) this;
        }

        public Criteria andNoDrugIdNotIn(List<Long> values) {
            addCriterion("no_drug_id not in", values, "noDrugId");
            return (Criteria) this;
        }

        public Criteria andNoDrugIdBetween(Long value1, Long value2) {
            addCriterion("no_drug_id between", value1, value2, "noDrugId");
            return (Criteria) this;
        }

        public Criteria andNoDrugIdNotBetween(Long value1, Long value2) {
            addCriterion("no_drug_id not between", value1, value2, "noDrugId");
            return (Criteria) this;
        }

        public Criteria andCheckPartsIsNull() {
            addCriterion("check_parts is null");
            return (Criteria) this;
        }

        public Criteria andCheckPartsIsNotNull() {
            addCriterion("check_parts is not null");
            return (Criteria) this;
        }

        public Criteria andCheckPartsEqualTo(String value) {
            addCriterion("check_parts =", value, "checkParts");
            return (Criteria) this;
        }

        public Criteria andCheckPartsNotEqualTo(String value) {
            addCriterion("check_parts <>", value, "checkParts");
            return (Criteria) this;
        }

        public Criteria andCheckPartsGreaterThan(String value) {
            addCriterion("check_parts >", value, "checkParts");
            return (Criteria) this;
        }

        public Criteria andCheckPartsGreaterThanOrEqualTo(String value) {
            addCriterion("check_parts >=", value, "checkParts");
            return (Criteria) this;
        }

        public Criteria andCheckPartsLessThan(String value) {
            addCriterion("check_parts <", value, "checkParts");
            return (Criteria) this;
        }

        public Criteria andCheckPartsLessThanOrEqualTo(String value) {
            addCriterion("check_parts <=", value, "checkParts");
            return (Criteria) this;
        }

        public Criteria andCheckPartsLike(String value) {
            addCriterion("check_parts like", value, "checkParts");
            return (Criteria) this;
        }

        public Criteria andCheckPartsNotLike(String value) {
            addCriterion("check_parts not like", value, "checkParts");
            return (Criteria) this;
        }

        public Criteria andCheckPartsIn(List<String> values) {
            addCriterion("check_parts in", values, "checkParts");
            return (Criteria) this;
        }

        public Criteria andCheckPartsNotIn(List<String> values) {
            addCriterion("check_parts not in", values, "checkParts");
            return (Criteria) this;
        }

        public Criteria andCheckPartsBetween(String value1, String value2) {
            addCriterion("check_parts between", value1, value2, "checkParts");
            return (Criteria) this;
        }

        public Criteria andCheckPartsNotBetween(String value1, String value2) {
            addCriterion("check_parts not between", value1, value2, "checkParts");
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

        public Criteria andExcuteDeptIdIsNull() {
            addCriterion("excute_dept_id is null");
            return (Criteria) this;
        }

        public Criteria andExcuteDeptIdIsNotNull() {
            addCriterion("excute_dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andExcuteDeptIdEqualTo(Long value) {
            addCriterion("excute_dept_id =", value, "excuteDeptId");
            return (Criteria) this;
        }

        public Criteria andExcuteDeptIdNotEqualTo(Long value) {
            addCriterion("excute_dept_id <>", value, "excuteDeptId");
            return (Criteria) this;
        }

        public Criteria andExcuteDeptIdGreaterThan(Long value) {
            addCriterion("excute_dept_id >", value, "excuteDeptId");
            return (Criteria) this;
        }

        public Criteria andExcuteDeptIdGreaterThanOrEqualTo(Long value) {
            addCriterion("excute_dept_id >=", value, "excuteDeptId");
            return (Criteria) this;
        }

        public Criteria andExcuteDeptIdLessThan(Long value) {
            addCriterion("excute_dept_id <", value, "excuteDeptId");
            return (Criteria) this;
        }

        public Criteria andExcuteDeptIdLessThanOrEqualTo(Long value) {
            addCriterion("excute_dept_id <=", value, "excuteDeptId");
            return (Criteria) this;
        }

        public Criteria andExcuteDeptIdIn(List<Long> values) {
            addCriterion("excute_dept_id in", values, "excuteDeptId");
            return (Criteria) this;
        }

        public Criteria andExcuteDeptIdNotIn(List<Long> values) {
            addCriterion("excute_dept_id not in", values, "excuteDeptId");
            return (Criteria) this;
        }

        public Criteria andExcuteDeptIdBetween(Long value1, Long value2) {
            addCriterion("excute_dept_id between", value1, value2, "excuteDeptId");
            return (Criteria) this;
        }

        public Criteria andExcuteDeptIdNotBetween(Long value1, Long value2) {
            addCriterion("excute_dept_id not between", value1, value2, "excuteDeptId");
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

        public Criteria andLogStaffIdIsNull() {
            addCriterion("log_staff_id is null");
            return (Criteria) this;
        }

        public Criteria andLogStaffIdIsNotNull() {
            addCriterion("log_staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogStaffIdEqualTo(Long value) {
            addCriterion("log_staff_id =", value, "logStaffId");
            return (Criteria) this;
        }

        public Criteria andLogStaffIdNotEqualTo(Long value) {
            addCriterion("log_staff_id <>", value, "logStaffId");
            return (Criteria) this;
        }

        public Criteria andLogStaffIdGreaterThan(Long value) {
            addCriterion("log_staff_id >", value, "logStaffId");
            return (Criteria) this;
        }

        public Criteria andLogStaffIdGreaterThanOrEqualTo(Long value) {
            addCriterion("log_staff_id >=", value, "logStaffId");
            return (Criteria) this;
        }

        public Criteria andLogStaffIdLessThan(Long value) {
            addCriterion("log_staff_id <", value, "logStaffId");
            return (Criteria) this;
        }

        public Criteria andLogStaffIdLessThanOrEqualTo(Long value) {
            addCriterion("log_staff_id <=", value, "logStaffId");
            return (Criteria) this;
        }

        public Criteria andLogStaffIdIn(List<Long> values) {
            addCriterion("log_staff_id in", values, "logStaffId");
            return (Criteria) this;
        }

        public Criteria andLogStaffIdNotIn(List<Long> values) {
            addCriterion("log_staff_id not in", values, "logStaffId");
            return (Criteria) this;
        }

        public Criteria andLogStaffIdBetween(Long value1, Long value2) {
            addCriterion("log_staff_id between", value1, value2, "logStaffId");
            return (Criteria) this;
        }

        public Criteria andLogStaffIdNotBetween(Long value1, Long value2) {
            addCriterion("log_staff_id not between", value1, value2, "logStaffId");
            return (Criteria) this;
        }

        public Criteria andExcuteTimeIsNull() {
            addCriterion("excute_time is null");
            return (Criteria) this;
        }

        public Criteria andExcuteTimeIsNotNull() {
            addCriterion("excute_time is not null");
            return (Criteria) this;
        }

        public Criteria andExcuteTimeEqualTo(Date value) {
            addCriterion("excute_time =", value, "excuteTime");
            return (Criteria) this;
        }

        public Criteria andExcuteTimeNotEqualTo(Date value) {
            addCriterion("excute_time <>", value, "excuteTime");
            return (Criteria) this;
        }

        public Criteria andExcuteTimeGreaterThan(Date value) {
            addCriterion("excute_time >", value, "excuteTime");
            return (Criteria) this;
        }

        public Criteria andExcuteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("excute_time >=", value, "excuteTime");
            return (Criteria) this;
        }

        public Criteria andExcuteTimeLessThan(Date value) {
            addCriterion("excute_time <", value, "excuteTime");
            return (Criteria) this;
        }

        public Criteria andExcuteTimeLessThanOrEqualTo(Date value) {
            addCriterion("excute_time <=", value, "excuteTime");
            return (Criteria) this;
        }

        public Criteria andExcuteTimeIn(List<Date> values) {
            addCriterion("excute_time in", values, "excuteTime");
            return (Criteria) this;
        }

        public Criteria andExcuteTimeNotIn(List<Date> values) {
            addCriterion("excute_time not in", values, "excuteTime");
            return (Criteria) this;
        }

        public Criteria andExcuteTimeBetween(Date value1, Date value2) {
            addCriterion("excute_time between", value1, value2, "excuteTime");
            return (Criteria) this;
        }

        public Criteria andExcuteTimeNotBetween(Date value1, Date value2) {
            addCriterion("excute_time not between", value1, value2, "excuteTime");
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