package com.neu.his.cloud.zuul.model;

import java.util.ArrayList;
import java.util.List;

public class DmsCaseModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DmsCaseModelExample() {
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