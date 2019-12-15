package com.neu.his.cloud.service.dms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DmsCaseHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DmsCaseHistoryExample() {
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

        public Criteria andChiefComplaintIsNull() {
            addCriterion("chief_complaint is null");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintIsNotNull() {
            addCriterion("chief_complaint is not null");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintEqualTo(String value) {
            addCriterion("chief_complaint =", value, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintNotEqualTo(String value) {
            addCriterion("chief_complaint <>", value, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintGreaterThan(String value) {
            addCriterion("chief_complaint >", value, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintGreaterThanOrEqualTo(String value) {
            addCriterion("chief_complaint >=", value, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintLessThan(String value) {
            addCriterion("chief_complaint <", value, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintLessThanOrEqualTo(String value) {
            addCriterion("chief_complaint <=", value, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintLike(String value) {
            addCriterion("chief_complaint like", value, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintNotLike(String value) {
            addCriterion("chief_complaint not like", value, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintIn(List<String> values) {
            addCriterion("chief_complaint in", values, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintNotIn(List<String> values) {
            addCriterion("chief_complaint not in", values, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintBetween(String value1, String value2) {
            addCriterion("chief_complaint between", value1, value2, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintNotBetween(String value1, String value2) {
            addCriterion("chief_complaint not between", value1, value2, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessIsNull() {
            addCriterion("history_of_present_illness is null");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessIsNotNull() {
            addCriterion("history_of_present_illness is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessEqualTo(String value) {
            addCriterion("history_of_present_illness =", value, "historyOfPresentIllness");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessNotEqualTo(String value) {
            addCriterion("history_of_present_illness <>", value, "historyOfPresentIllness");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessGreaterThan(String value) {
            addCriterion("history_of_present_illness >", value, "historyOfPresentIllness");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessGreaterThanOrEqualTo(String value) {
            addCriterion("history_of_present_illness >=", value, "historyOfPresentIllness");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessLessThan(String value) {
            addCriterion("history_of_present_illness <", value, "historyOfPresentIllness");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessLessThanOrEqualTo(String value) {
            addCriterion("history_of_present_illness <=", value, "historyOfPresentIllness");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessLike(String value) {
            addCriterion("history_of_present_illness like", value, "historyOfPresentIllness");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessNotLike(String value) {
            addCriterion("history_of_present_illness not like", value, "historyOfPresentIllness");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessIn(List<String> values) {
            addCriterion("history_of_present_illness in", values, "historyOfPresentIllness");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessNotIn(List<String> values) {
            addCriterion("history_of_present_illness not in", values, "historyOfPresentIllness");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessBetween(String value1, String value2) {
            addCriterion("history_of_present_illness between", value1, value2, "historyOfPresentIllness");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessNotBetween(String value1, String value2) {
            addCriterion("history_of_present_illness not between", value1, value2, "historyOfPresentIllness");
            return (Criteria) this;
        }

        public Criteria andHistoryOfTreatmentIsNull() {
            addCriterion("history_of_treatment is null");
            return (Criteria) this;
        }

        public Criteria andHistoryOfTreatmentIsNotNull() {
            addCriterion("history_of_treatment is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryOfTreatmentEqualTo(String value) {
            addCriterion("history_of_treatment =", value, "historyOfTreatment");
            return (Criteria) this;
        }

        public Criteria andHistoryOfTreatmentNotEqualTo(String value) {
            addCriterion("history_of_treatment <>", value, "historyOfTreatment");
            return (Criteria) this;
        }

        public Criteria andHistoryOfTreatmentGreaterThan(String value) {
            addCriterion("history_of_treatment >", value, "historyOfTreatment");
            return (Criteria) this;
        }

        public Criteria andHistoryOfTreatmentGreaterThanOrEqualTo(String value) {
            addCriterion("history_of_treatment >=", value, "historyOfTreatment");
            return (Criteria) this;
        }

        public Criteria andHistoryOfTreatmentLessThan(String value) {
            addCriterion("history_of_treatment <", value, "historyOfTreatment");
            return (Criteria) this;
        }

        public Criteria andHistoryOfTreatmentLessThanOrEqualTo(String value) {
            addCriterion("history_of_treatment <=", value, "historyOfTreatment");
            return (Criteria) this;
        }

        public Criteria andHistoryOfTreatmentLike(String value) {
            addCriterion("history_of_treatment like", value, "historyOfTreatment");
            return (Criteria) this;
        }

        public Criteria andHistoryOfTreatmentNotLike(String value) {
            addCriterion("history_of_treatment not like", value, "historyOfTreatment");
            return (Criteria) this;
        }

        public Criteria andHistoryOfTreatmentIn(List<String> values) {
            addCriterion("history_of_treatment in", values, "historyOfTreatment");
            return (Criteria) this;
        }

        public Criteria andHistoryOfTreatmentNotIn(List<String> values) {
            addCriterion("history_of_treatment not in", values, "historyOfTreatment");
            return (Criteria) this;
        }

        public Criteria andHistoryOfTreatmentBetween(String value1, String value2) {
            addCriterion("history_of_treatment between", value1, value2, "historyOfTreatment");
            return (Criteria) this;
        }

        public Criteria andHistoryOfTreatmentNotBetween(String value1, String value2) {
            addCriterion("history_of_treatment not between", value1, value2, "historyOfTreatment");
            return (Criteria) this;
        }

        public Criteria andPastHistoryIsNull() {
            addCriterion("past_history is null");
            return (Criteria) this;
        }

        public Criteria andPastHistoryIsNotNull() {
            addCriterion("past_history is not null");
            return (Criteria) this;
        }

        public Criteria andPastHistoryEqualTo(String value) {
            addCriterion("past_history =", value, "pastHistory");
            return (Criteria) this;
        }

        public Criteria andPastHistoryNotEqualTo(String value) {
            addCriterion("past_history <>", value, "pastHistory");
            return (Criteria) this;
        }

        public Criteria andPastHistoryGreaterThan(String value) {
            addCriterion("past_history >", value, "pastHistory");
            return (Criteria) this;
        }

        public Criteria andPastHistoryGreaterThanOrEqualTo(String value) {
            addCriterion("past_history >=", value, "pastHistory");
            return (Criteria) this;
        }

        public Criteria andPastHistoryLessThan(String value) {
            addCriterion("past_history <", value, "pastHistory");
            return (Criteria) this;
        }

        public Criteria andPastHistoryLessThanOrEqualTo(String value) {
            addCriterion("past_history <=", value, "pastHistory");
            return (Criteria) this;
        }

        public Criteria andPastHistoryLike(String value) {
            addCriterion("past_history like", value, "pastHistory");
            return (Criteria) this;
        }

        public Criteria andPastHistoryNotLike(String value) {
            addCriterion("past_history not like", value, "pastHistory");
            return (Criteria) this;
        }

        public Criteria andPastHistoryIn(List<String> values) {
            addCriterion("past_history in", values, "pastHistory");
            return (Criteria) this;
        }

        public Criteria andPastHistoryNotIn(List<String> values) {
            addCriterion("past_history not in", values, "pastHistory");
            return (Criteria) this;
        }

        public Criteria andPastHistoryBetween(String value1, String value2) {
            addCriterion("past_history between", value1, value2, "pastHistory");
            return (Criteria) this;
        }

        public Criteria andPastHistoryNotBetween(String value1, String value2) {
            addCriterion("past_history not between", value1, value2, "pastHistory");
            return (Criteria) this;
        }

        public Criteria andAllergiesIsNull() {
            addCriterion("allergies is null");
            return (Criteria) this;
        }

        public Criteria andAllergiesIsNotNull() {
            addCriterion("allergies is not null");
            return (Criteria) this;
        }

        public Criteria andAllergiesEqualTo(String value) {
            addCriterion("allergies =", value, "allergies");
            return (Criteria) this;
        }

        public Criteria andAllergiesNotEqualTo(String value) {
            addCriterion("allergies <>", value, "allergies");
            return (Criteria) this;
        }

        public Criteria andAllergiesGreaterThan(String value) {
            addCriterion("allergies >", value, "allergies");
            return (Criteria) this;
        }

        public Criteria andAllergiesGreaterThanOrEqualTo(String value) {
            addCriterion("allergies >=", value, "allergies");
            return (Criteria) this;
        }

        public Criteria andAllergiesLessThan(String value) {
            addCriterion("allergies <", value, "allergies");
            return (Criteria) this;
        }

        public Criteria andAllergiesLessThanOrEqualTo(String value) {
            addCriterion("allergies <=", value, "allergies");
            return (Criteria) this;
        }

        public Criteria andAllergiesLike(String value) {
            addCriterion("allergies like", value, "allergies");
            return (Criteria) this;
        }

        public Criteria andAllergiesNotLike(String value) {
            addCriterion("allergies not like", value, "allergies");
            return (Criteria) this;
        }

        public Criteria andAllergiesIn(List<String> values) {
            addCriterion("allergies in", values, "allergies");
            return (Criteria) this;
        }

        public Criteria andAllergiesNotIn(List<String> values) {
            addCriterion("allergies not in", values, "allergies");
            return (Criteria) this;
        }

        public Criteria andAllergiesBetween(String value1, String value2) {
            addCriterion("allergies between", value1, value2, "allergies");
            return (Criteria) this;
        }

        public Criteria andAllergiesNotBetween(String value1, String value2) {
            addCriterion("allergies not between", value1, value2, "allergies");
            return (Criteria) this;
        }

        public Criteria andHealthCheckupIsNull() {
            addCriterion("health_checkup is null");
            return (Criteria) this;
        }

        public Criteria andHealthCheckupIsNotNull() {
            addCriterion("health_checkup is not null");
            return (Criteria) this;
        }

        public Criteria andHealthCheckupEqualTo(String value) {
            addCriterion("health_checkup =", value, "healthCheckup");
            return (Criteria) this;
        }

        public Criteria andHealthCheckupNotEqualTo(String value) {
            addCriterion("health_checkup <>", value, "healthCheckup");
            return (Criteria) this;
        }

        public Criteria andHealthCheckupGreaterThan(String value) {
            addCriterion("health_checkup >", value, "healthCheckup");
            return (Criteria) this;
        }

        public Criteria andHealthCheckupGreaterThanOrEqualTo(String value) {
            addCriterion("health_checkup >=", value, "healthCheckup");
            return (Criteria) this;
        }

        public Criteria andHealthCheckupLessThan(String value) {
            addCriterion("health_checkup <", value, "healthCheckup");
            return (Criteria) this;
        }

        public Criteria andHealthCheckupLessThanOrEqualTo(String value) {
            addCriterion("health_checkup <=", value, "healthCheckup");
            return (Criteria) this;
        }

        public Criteria andHealthCheckupLike(String value) {
            addCriterion("health_checkup like", value, "healthCheckup");
            return (Criteria) this;
        }

        public Criteria andHealthCheckupNotLike(String value) {
            addCriterion("health_checkup not like", value, "healthCheckup");
            return (Criteria) this;
        }

        public Criteria andHealthCheckupIn(List<String> values) {
            addCriterion("health_checkup in", values, "healthCheckup");
            return (Criteria) this;
        }

        public Criteria andHealthCheckupNotIn(List<String> values) {
            addCriterion("health_checkup not in", values, "healthCheckup");
            return (Criteria) this;
        }

        public Criteria andHealthCheckupBetween(String value1, String value2) {
            addCriterion("health_checkup between", value1, value2, "healthCheckup");
            return (Criteria) this;
        }

        public Criteria andHealthCheckupNotBetween(String value1, String value2) {
            addCriterion("health_checkup not between", value1, value2, "healthCheckup");
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

        public Criteria andPriliminaryDiseStrListIsNull() {
            addCriterion("priliminary_dise_str_list is null");
            return (Criteria) this;
        }

        public Criteria andPriliminaryDiseStrListIsNotNull() {
            addCriterion("priliminary_dise_str_list is not null");
            return (Criteria) this;
        }

        public Criteria andPriliminaryDiseStrListEqualTo(String value) {
            addCriterion("priliminary_dise_str_list =", value, "priliminaryDiseStrList");
            return (Criteria) this;
        }

        public Criteria andPriliminaryDiseStrListNotEqualTo(String value) {
            addCriterion("priliminary_dise_str_list <>", value, "priliminaryDiseStrList");
            return (Criteria) this;
        }

        public Criteria andPriliminaryDiseStrListGreaterThan(String value) {
            addCriterion("priliminary_dise_str_list >", value, "priliminaryDiseStrList");
            return (Criteria) this;
        }

        public Criteria andPriliminaryDiseStrListGreaterThanOrEqualTo(String value) {
            addCriterion("priliminary_dise_str_list >=", value, "priliminaryDiseStrList");
            return (Criteria) this;
        }

        public Criteria andPriliminaryDiseStrListLessThan(String value) {
            addCriterion("priliminary_dise_str_list <", value, "priliminaryDiseStrList");
            return (Criteria) this;
        }

        public Criteria andPriliminaryDiseStrListLessThanOrEqualTo(String value) {
            addCriterion("priliminary_dise_str_list <=", value, "priliminaryDiseStrList");
            return (Criteria) this;
        }

        public Criteria andPriliminaryDiseStrListLike(String value) {
            addCriterion("priliminary_dise_str_list like", value, "priliminaryDiseStrList");
            return (Criteria) this;
        }

        public Criteria andPriliminaryDiseStrListNotLike(String value) {
            addCriterion("priliminary_dise_str_list not like", value, "priliminaryDiseStrList");
            return (Criteria) this;
        }

        public Criteria andPriliminaryDiseStrListIn(List<String> values) {
            addCriterion("priliminary_dise_str_list in", values, "priliminaryDiseStrList");
            return (Criteria) this;
        }

        public Criteria andPriliminaryDiseStrListNotIn(List<String> values) {
            addCriterion("priliminary_dise_str_list not in", values, "priliminaryDiseStrList");
            return (Criteria) this;
        }

        public Criteria andPriliminaryDiseStrListBetween(String value1, String value2) {
            addCriterion("priliminary_dise_str_list between", value1, value2, "priliminaryDiseStrList");
            return (Criteria) this;
        }

        public Criteria andPriliminaryDiseStrListNotBetween(String value1, String value2) {
            addCriterion("priliminary_dise_str_list not between", value1, value2, "priliminaryDiseStrList");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterion("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterion("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterion("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterion("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterion("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterion("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterion("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterion("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterion("start_date not between", value1, value2, "startDate");
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

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Integer value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Integer value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Integer value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Integer value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Integer value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Integer> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Integer> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Integer value1, Integer value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andAgeStrIsNull() {
            addCriterion("age_str is null");
            return (Criteria) this;
        }

        public Criteria andAgeStrIsNotNull() {
            addCriterion("age_str is not null");
            return (Criteria) this;
        }

        public Criteria andAgeStrEqualTo(String value) {
            addCriterion("age_str =", value, "ageStr");
            return (Criteria) this;
        }

        public Criteria andAgeStrNotEqualTo(String value) {
            addCriterion("age_str <>", value, "ageStr");
            return (Criteria) this;
        }

        public Criteria andAgeStrGreaterThan(String value) {
            addCriterion("age_str >", value, "ageStr");
            return (Criteria) this;
        }

        public Criteria andAgeStrGreaterThanOrEqualTo(String value) {
            addCriterion("age_str >=", value, "ageStr");
            return (Criteria) this;
        }

        public Criteria andAgeStrLessThan(String value) {
            addCriterion("age_str <", value, "ageStr");
            return (Criteria) this;
        }

        public Criteria andAgeStrLessThanOrEqualTo(String value) {
            addCriterion("age_str <=", value, "ageStr");
            return (Criteria) this;
        }

        public Criteria andAgeStrLike(String value) {
            addCriterion("age_str like", value, "ageStr");
            return (Criteria) this;
        }

        public Criteria andAgeStrNotLike(String value) {
            addCriterion("age_str not like", value, "ageStr");
            return (Criteria) this;
        }

        public Criteria andAgeStrIn(List<String> values) {
            addCriterion("age_str in", values, "ageStr");
            return (Criteria) this;
        }

        public Criteria andAgeStrNotIn(List<String> values) {
            addCriterion("age_str not in", values, "ageStr");
            return (Criteria) this;
        }

        public Criteria andAgeStrBetween(String value1, String value2) {
            addCriterion("age_str between", value1, value2, "ageStr");
            return (Criteria) this;
        }

        public Criteria andAgeStrNotBetween(String value1, String value2) {
            addCriterion("age_str not between", value1, value2, "ageStr");
            return (Criteria) this;
        }

        public Criteria andCheckStrListIsNull() {
            addCriterion("check_str_list is null");
            return (Criteria) this;
        }

        public Criteria andCheckStrListIsNotNull() {
            addCriterion("check_str_list is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStrListEqualTo(String value) {
            addCriterion("check_str_list =", value, "checkStrList");
            return (Criteria) this;
        }

        public Criteria andCheckStrListNotEqualTo(String value) {
            addCriterion("check_str_list <>", value, "checkStrList");
            return (Criteria) this;
        }

        public Criteria andCheckStrListGreaterThan(String value) {
            addCriterion("check_str_list >", value, "checkStrList");
            return (Criteria) this;
        }

        public Criteria andCheckStrListGreaterThanOrEqualTo(String value) {
            addCriterion("check_str_list >=", value, "checkStrList");
            return (Criteria) this;
        }

        public Criteria andCheckStrListLessThan(String value) {
            addCriterion("check_str_list <", value, "checkStrList");
            return (Criteria) this;
        }

        public Criteria andCheckStrListLessThanOrEqualTo(String value) {
            addCriterion("check_str_list <=", value, "checkStrList");
            return (Criteria) this;
        }

        public Criteria andCheckStrListLike(String value) {
            addCriterion("check_str_list like", value, "checkStrList");
            return (Criteria) this;
        }

        public Criteria andCheckStrListNotLike(String value) {
            addCriterion("check_str_list not like", value, "checkStrList");
            return (Criteria) this;
        }

        public Criteria andCheckStrListIn(List<String> values) {
            addCriterion("check_str_list in", values, "checkStrList");
            return (Criteria) this;
        }

        public Criteria andCheckStrListNotIn(List<String> values) {
            addCriterion("check_str_list not in", values, "checkStrList");
            return (Criteria) this;
        }

        public Criteria andCheckStrListBetween(String value1, String value2) {
            addCriterion("check_str_list between", value1, value2, "checkStrList");
            return (Criteria) this;
        }

        public Criteria andCheckStrListNotBetween(String value1, String value2) {
            addCriterion("check_str_list not between", value1, value2, "checkStrList");
            return (Criteria) this;
        }

        public Criteria andDispositionStrListIsNull() {
            addCriterion("disposition_str_list is null");
            return (Criteria) this;
        }

        public Criteria andDispositionStrListIsNotNull() {
            addCriterion("disposition_str_list is not null");
            return (Criteria) this;
        }

        public Criteria andDispositionStrListEqualTo(String value) {
            addCriterion("disposition_str_list =", value, "dispositionStrList");
            return (Criteria) this;
        }

        public Criteria andDispositionStrListNotEqualTo(String value) {
            addCriterion("disposition_str_list <>", value, "dispositionStrList");
            return (Criteria) this;
        }

        public Criteria andDispositionStrListGreaterThan(String value) {
            addCriterion("disposition_str_list >", value, "dispositionStrList");
            return (Criteria) this;
        }

        public Criteria andDispositionStrListGreaterThanOrEqualTo(String value) {
            addCriterion("disposition_str_list >=", value, "dispositionStrList");
            return (Criteria) this;
        }

        public Criteria andDispositionStrListLessThan(String value) {
            addCriterion("disposition_str_list <", value, "dispositionStrList");
            return (Criteria) this;
        }

        public Criteria andDispositionStrListLessThanOrEqualTo(String value) {
            addCriterion("disposition_str_list <=", value, "dispositionStrList");
            return (Criteria) this;
        }

        public Criteria andDispositionStrListLike(String value) {
            addCriterion("disposition_str_list like", value, "dispositionStrList");
            return (Criteria) this;
        }

        public Criteria andDispositionStrListNotLike(String value) {
            addCriterion("disposition_str_list not like", value, "dispositionStrList");
            return (Criteria) this;
        }

        public Criteria andDispositionStrListIn(List<String> values) {
            addCriterion("disposition_str_list in", values, "dispositionStrList");
            return (Criteria) this;
        }

        public Criteria andDispositionStrListNotIn(List<String> values) {
            addCriterion("disposition_str_list not in", values, "dispositionStrList");
            return (Criteria) this;
        }

        public Criteria andDispositionStrListBetween(String value1, String value2) {
            addCriterion("disposition_str_list between", value1, value2, "dispositionStrList");
            return (Criteria) this;
        }

        public Criteria andDispositionStrListNotBetween(String value1, String value2) {
            addCriterion("disposition_str_list not between", value1, value2, "dispositionStrList");
            return (Criteria) this;
        }

        public Criteria andHerbalPrescriptionStrListIsNull() {
            addCriterion("herbal_prescription_str_list is null");
            return (Criteria) this;
        }

        public Criteria andHerbalPrescriptionStrListIsNotNull() {
            addCriterion("herbal_prescription_str_list is not null");
            return (Criteria) this;
        }

        public Criteria andHerbalPrescriptionStrListEqualTo(String value) {
            addCriterion("herbal_prescription_str_list =", value, "herbalPrescriptionStrList");
            return (Criteria) this;
        }

        public Criteria andHerbalPrescriptionStrListNotEqualTo(String value) {
            addCriterion("herbal_prescription_str_list <>", value, "herbalPrescriptionStrList");
            return (Criteria) this;
        }

        public Criteria andHerbalPrescriptionStrListGreaterThan(String value) {
            addCriterion("herbal_prescription_str_list >", value, "herbalPrescriptionStrList");
            return (Criteria) this;
        }

        public Criteria andHerbalPrescriptionStrListGreaterThanOrEqualTo(String value) {
            addCriterion("herbal_prescription_str_list >=", value, "herbalPrescriptionStrList");
            return (Criteria) this;
        }

        public Criteria andHerbalPrescriptionStrListLessThan(String value) {
            addCriterion("herbal_prescription_str_list <", value, "herbalPrescriptionStrList");
            return (Criteria) this;
        }

        public Criteria andHerbalPrescriptionStrListLessThanOrEqualTo(String value) {
            addCriterion("herbal_prescription_str_list <=", value, "herbalPrescriptionStrList");
            return (Criteria) this;
        }

        public Criteria andHerbalPrescriptionStrListLike(String value) {
            addCriterion("herbal_prescription_str_list like", value, "herbalPrescriptionStrList");
            return (Criteria) this;
        }

        public Criteria andHerbalPrescriptionStrListNotLike(String value) {
            addCriterion("herbal_prescription_str_list not like", value, "herbalPrescriptionStrList");
            return (Criteria) this;
        }

        public Criteria andHerbalPrescriptionStrListIn(List<String> values) {
            addCriterion("herbal_prescription_str_list in", values, "herbalPrescriptionStrList");
            return (Criteria) this;
        }

        public Criteria andHerbalPrescriptionStrListNotIn(List<String> values) {
            addCriterion("herbal_prescription_str_list not in", values, "herbalPrescriptionStrList");
            return (Criteria) this;
        }

        public Criteria andHerbalPrescriptionStrListBetween(String value1, String value2) {
            addCriterion("herbal_prescription_str_list between", value1, value2, "herbalPrescriptionStrList");
            return (Criteria) this;
        }

        public Criteria andHerbalPrescriptionStrListNotBetween(String value1, String value2) {
            addCriterion("herbal_prescription_str_list not between", value1, value2, "herbalPrescriptionStrList");
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

        public Criteria andDefiniteDiseStrListIsNull() {
            addCriterion("definite_dise_str_list is null");
            return (Criteria) this;
        }

        public Criteria andDefiniteDiseStrListIsNotNull() {
            addCriterion("definite_dise_str_list is not null");
            return (Criteria) this;
        }

        public Criteria andDefiniteDiseStrListEqualTo(String value) {
            addCriterion("definite_dise_str_list =", value, "definiteDiseStrList");
            return (Criteria) this;
        }

        public Criteria andDefiniteDiseStrListNotEqualTo(String value) {
            addCriterion("definite_dise_str_list <>", value, "definiteDiseStrList");
            return (Criteria) this;
        }

        public Criteria andDefiniteDiseStrListGreaterThan(String value) {
            addCriterion("definite_dise_str_list >", value, "definiteDiseStrList");
            return (Criteria) this;
        }

        public Criteria andDefiniteDiseStrListGreaterThanOrEqualTo(String value) {
            addCriterion("definite_dise_str_list >=", value, "definiteDiseStrList");
            return (Criteria) this;
        }

        public Criteria andDefiniteDiseStrListLessThan(String value) {
            addCriterion("definite_dise_str_list <", value, "definiteDiseStrList");
            return (Criteria) this;
        }

        public Criteria andDefiniteDiseStrListLessThanOrEqualTo(String value) {
            addCriterion("definite_dise_str_list <=", value, "definiteDiseStrList");
            return (Criteria) this;
        }

        public Criteria andDefiniteDiseStrListLike(String value) {
            addCriterion("definite_dise_str_list like", value, "definiteDiseStrList");
            return (Criteria) this;
        }

        public Criteria andDefiniteDiseStrListNotLike(String value) {
            addCriterion("definite_dise_str_list not like", value, "definiteDiseStrList");
            return (Criteria) this;
        }

        public Criteria andDefiniteDiseStrListIn(List<String> values) {
            addCriterion("definite_dise_str_list in", values, "definiteDiseStrList");
            return (Criteria) this;
        }

        public Criteria andDefiniteDiseStrListNotIn(List<String> values) {
            addCriterion("definite_dise_str_list not in", values, "definiteDiseStrList");
            return (Criteria) this;
        }

        public Criteria andDefiniteDiseStrListBetween(String value1, String value2) {
            addCriterion("definite_dise_str_list between", value1, value2, "definiteDiseStrList");
            return (Criteria) this;
        }

        public Criteria andDefiniteDiseStrListNotBetween(String value1, String value2) {
            addCriterion("definite_dise_str_list not between", value1, value2, "definiteDiseStrList");
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

        public Criteria andTestStrListIsNull() {
            addCriterion("test_str_list is null");
            return (Criteria) this;
        }

        public Criteria andTestStrListIsNotNull() {
            addCriterion("test_str_list is not null");
            return (Criteria) this;
        }

        public Criteria andTestStrListEqualTo(String value) {
            addCriterion("test_str_list =", value, "testStrList");
            return (Criteria) this;
        }

        public Criteria andTestStrListNotEqualTo(String value) {
            addCriterion("test_str_list <>", value, "testStrList");
            return (Criteria) this;
        }

        public Criteria andTestStrListGreaterThan(String value) {
            addCriterion("test_str_list >", value, "testStrList");
            return (Criteria) this;
        }

        public Criteria andTestStrListGreaterThanOrEqualTo(String value) {
            addCriterion("test_str_list >=", value, "testStrList");
            return (Criteria) this;
        }

        public Criteria andTestStrListLessThan(String value) {
            addCriterion("test_str_list <", value, "testStrList");
            return (Criteria) this;
        }

        public Criteria andTestStrListLessThanOrEqualTo(String value) {
            addCriterion("test_str_list <=", value, "testStrList");
            return (Criteria) this;
        }

        public Criteria andTestStrListLike(String value) {
            addCriterion("test_str_list like", value, "testStrList");
            return (Criteria) this;
        }

        public Criteria andTestStrListNotLike(String value) {
            addCriterion("test_str_list not like", value, "testStrList");
            return (Criteria) this;
        }

        public Criteria andTestStrListIn(List<String> values) {
            addCriterion("test_str_list in", values, "testStrList");
            return (Criteria) this;
        }

        public Criteria andTestStrListNotIn(List<String> values) {
            addCriterion("test_str_list not in", values, "testStrList");
            return (Criteria) this;
        }

        public Criteria andTestStrListBetween(String value1, String value2) {
            addCriterion("test_str_list between", value1, value2, "testStrList");
            return (Criteria) this;
        }

        public Criteria andTestStrListNotBetween(String value1, String value2) {
            addCriterion("test_str_list not between", value1, value2, "testStrList");
            return (Criteria) this;
        }

        public Criteria andMedicinePrescriptionStrListIsNull() {
            addCriterion("medicine_prescription_str_list is null");
            return (Criteria) this;
        }

        public Criteria andMedicinePrescriptionStrListIsNotNull() {
            addCriterion("medicine_prescription_str_list is not null");
            return (Criteria) this;
        }

        public Criteria andMedicinePrescriptionStrListEqualTo(String value) {
            addCriterion("medicine_prescription_str_list =", value, "medicinePrescriptionStrList");
            return (Criteria) this;
        }

        public Criteria andMedicinePrescriptionStrListNotEqualTo(String value) {
            addCriterion("medicine_prescription_str_list <>", value, "medicinePrescriptionStrList");
            return (Criteria) this;
        }

        public Criteria andMedicinePrescriptionStrListGreaterThan(String value) {
            addCriterion("medicine_prescription_str_list >", value, "medicinePrescriptionStrList");
            return (Criteria) this;
        }

        public Criteria andMedicinePrescriptionStrListGreaterThanOrEqualTo(String value) {
            addCriterion("medicine_prescription_str_list >=", value, "medicinePrescriptionStrList");
            return (Criteria) this;
        }

        public Criteria andMedicinePrescriptionStrListLessThan(String value) {
            addCriterion("medicine_prescription_str_list <", value, "medicinePrescriptionStrList");
            return (Criteria) this;
        }

        public Criteria andMedicinePrescriptionStrListLessThanOrEqualTo(String value) {
            addCriterion("medicine_prescription_str_list <=", value, "medicinePrescriptionStrList");
            return (Criteria) this;
        }

        public Criteria andMedicinePrescriptionStrListLike(String value) {
            addCriterion("medicine_prescription_str_list like", value, "medicinePrescriptionStrList");
            return (Criteria) this;
        }

        public Criteria andMedicinePrescriptionStrListNotLike(String value) {
            addCriterion("medicine_prescription_str_list not like", value, "medicinePrescriptionStrList");
            return (Criteria) this;
        }

        public Criteria andMedicinePrescriptionStrListIn(List<String> values) {
            addCriterion("medicine_prescription_str_list in", values, "medicinePrescriptionStrList");
            return (Criteria) this;
        }

        public Criteria andMedicinePrescriptionStrListNotIn(List<String> values) {
            addCriterion("medicine_prescription_str_list not in", values, "medicinePrescriptionStrList");
            return (Criteria) this;
        }

        public Criteria andMedicinePrescriptionStrListBetween(String value1, String value2) {
            addCriterion("medicine_prescription_str_list between", value1, value2, "medicinePrescriptionStrList");
            return (Criteria) this;
        }

        public Criteria andMedicinePrescriptionStrListNotBetween(String value1, String value2) {
            addCriterion("medicine_prescription_str_list not between", value1, value2, "medicinePrescriptionStrList");
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

        public Criteria andPriliminaryDiseIdListIsNull() {
            addCriterion("priliminary_dise_id_list is null");
            return (Criteria) this;
        }

        public Criteria andPriliminaryDiseIdListIsNotNull() {
            addCriterion("priliminary_dise_id_list is not null");
            return (Criteria) this;
        }

        public Criteria andPriliminaryDiseIdListEqualTo(String value) {
            addCriterion("priliminary_dise_id_list =", value, "priliminaryDiseIdList");
            return (Criteria) this;
        }

        public Criteria andPriliminaryDiseIdListNotEqualTo(String value) {
            addCriterion("priliminary_dise_id_list <>", value, "priliminaryDiseIdList");
            return (Criteria) this;
        }

        public Criteria andPriliminaryDiseIdListGreaterThan(String value) {
            addCriterion("priliminary_dise_id_list >", value, "priliminaryDiseIdList");
            return (Criteria) this;
        }

        public Criteria andPriliminaryDiseIdListGreaterThanOrEqualTo(String value) {
            addCriterion("priliminary_dise_id_list >=", value, "priliminaryDiseIdList");
            return (Criteria) this;
        }

        public Criteria andPriliminaryDiseIdListLessThan(String value) {
            addCriterion("priliminary_dise_id_list <", value, "priliminaryDiseIdList");
            return (Criteria) this;
        }

        public Criteria andPriliminaryDiseIdListLessThanOrEqualTo(String value) {
            addCriterion("priliminary_dise_id_list <=", value, "priliminaryDiseIdList");
            return (Criteria) this;
        }

        public Criteria andPriliminaryDiseIdListLike(String value) {
            addCriterion("priliminary_dise_id_list like", value, "priliminaryDiseIdList");
            return (Criteria) this;
        }

        public Criteria andPriliminaryDiseIdListNotLike(String value) {
            addCriterion("priliminary_dise_id_list not like", value, "priliminaryDiseIdList");
            return (Criteria) this;
        }

        public Criteria andPriliminaryDiseIdListIn(List<String> values) {
            addCriterion("priliminary_dise_id_list in", values, "priliminaryDiseIdList");
            return (Criteria) this;
        }

        public Criteria andPriliminaryDiseIdListNotIn(List<String> values) {
            addCriterion("priliminary_dise_id_list not in", values, "priliminaryDiseIdList");
            return (Criteria) this;
        }

        public Criteria andPriliminaryDiseIdListBetween(String value1, String value2) {
            addCriterion("priliminary_dise_id_list between", value1, value2, "priliminaryDiseIdList");
            return (Criteria) this;
        }

        public Criteria andPriliminaryDiseIdListNotBetween(String value1, String value2) {
            addCriterion("priliminary_dise_id_list not between", value1, value2, "priliminaryDiseIdList");
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

        public Criteria andTestResultIsNull() {
            addCriterion("test_result is null");
            return (Criteria) this;
        }

        public Criteria andTestResultIsNotNull() {
            addCriterion("test_result is not null");
            return (Criteria) this;
        }

        public Criteria andTestResultEqualTo(String value) {
            addCriterion("test_result =", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultNotEqualTo(String value) {
            addCriterion("test_result <>", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultGreaterThan(String value) {
            addCriterion("test_result >", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultGreaterThanOrEqualTo(String value) {
            addCriterion("test_result >=", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultLessThan(String value) {
            addCriterion("test_result <", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultLessThanOrEqualTo(String value) {
            addCriterion("test_result <=", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultLike(String value) {
            addCriterion("test_result like", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultNotLike(String value) {
            addCriterion("test_result not like", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultIn(List<String> values) {
            addCriterion("test_result in", values, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultNotIn(List<String> values) {
            addCriterion("test_result not in", values, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultBetween(String value1, String value2) {
            addCriterion("test_result between", value1, value2, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultNotBetween(String value1, String value2) {
            addCriterion("test_result not between", value1, value2, "testResult");
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