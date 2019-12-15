package com.neu.his.cloud.service.dms.model;

import java.util.ArrayList;
import java.util.List;

public class SmsFrequentUsedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SmsFrequentUsedExample() {
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

        public Criteria andMedicineDiseIdListIsNull() {
            addCriterion("medicine_dise_id_list is null");
            return (Criteria) this;
        }

        public Criteria andMedicineDiseIdListIsNotNull() {
            addCriterion("medicine_dise_id_list is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineDiseIdListEqualTo(String value) {
            addCriterion("medicine_dise_id_list =", value, "medicineDiseIdList");
            return (Criteria) this;
        }

        public Criteria andMedicineDiseIdListNotEqualTo(String value) {
            addCriterion("medicine_dise_id_list <>", value, "medicineDiseIdList");
            return (Criteria) this;
        }

        public Criteria andMedicineDiseIdListGreaterThan(String value) {
            addCriterion("medicine_dise_id_list >", value, "medicineDiseIdList");
            return (Criteria) this;
        }

        public Criteria andMedicineDiseIdListGreaterThanOrEqualTo(String value) {
            addCriterion("medicine_dise_id_list >=", value, "medicineDiseIdList");
            return (Criteria) this;
        }

        public Criteria andMedicineDiseIdListLessThan(String value) {
            addCriterion("medicine_dise_id_list <", value, "medicineDiseIdList");
            return (Criteria) this;
        }

        public Criteria andMedicineDiseIdListLessThanOrEqualTo(String value) {
            addCriterion("medicine_dise_id_list <=", value, "medicineDiseIdList");
            return (Criteria) this;
        }

        public Criteria andMedicineDiseIdListLike(String value) {
            addCriterion("medicine_dise_id_list like", value, "medicineDiseIdList");
            return (Criteria) this;
        }

        public Criteria andMedicineDiseIdListNotLike(String value) {
            addCriterion("medicine_dise_id_list not like", value, "medicineDiseIdList");
            return (Criteria) this;
        }

        public Criteria andMedicineDiseIdListIn(List<String> values) {
            addCriterion("medicine_dise_id_list in", values, "medicineDiseIdList");
            return (Criteria) this;
        }

        public Criteria andMedicineDiseIdListNotIn(List<String> values) {
            addCriterion("medicine_dise_id_list not in", values, "medicineDiseIdList");
            return (Criteria) this;
        }

        public Criteria andMedicineDiseIdListBetween(String value1, String value2) {
            addCriterion("medicine_dise_id_list between", value1, value2, "medicineDiseIdList");
            return (Criteria) this;
        }

        public Criteria andMedicineDiseIdListNotBetween(String value1, String value2) {
            addCriterion("medicine_dise_id_list not between", value1, value2, "medicineDiseIdList");
            return (Criteria) this;
        }

        public Criteria andDispositionIdListIsNull() {
            addCriterion("disposition_id_list is null");
            return (Criteria) this;
        }

        public Criteria andDispositionIdListIsNotNull() {
            addCriterion("disposition_id_list is not null");
            return (Criteria) this;
        }

        public Criteria andDispositionIdListEqualTo(String value) {
            addCriterion("disposition_id_list =", value, "dispositionIdList");
            return (Criteria) this;
        }

        public Criteria andDispositionIdListNotEqualTo(String value) {
            addCriterion("disposition_id_list <>", value, "dispositionIdList");
            return (Criteria) this;
        }

        public Criteria andDispositionIdListGreaterThan(String value) {
            addCriterion("disposition_id_list >", value, "dispositionIdList");
            return (Criteria) this;
        }

        public Criteria andDispositionIdListGreaterThanOrEqualTo(String value) {
            addCriterion("disposition_id_list >=", value, "dispositionIdList");
            return (Criteria) this;
        }

        public Criteria andDispositionIdListLessThan(String value) {
            addCriterion("disposition_id_list <", value, "dispositionIdList");
            return (Criteria) this;
        }

        public Criteria andDispositionIdListLessThanOrEqualTo(String value) {
            addCriterion("disposition_id_list <=", value, "dispositionIdList");
            return (Criteria) this;
        }

        public Criteria andDispositionIdListLike(String value) {
            addCriterion("disposition_id_list like", value, "dispositionIdList");
            return (Criteria) this;
        }

        public Criteria andDispositionIdListNotLike(String value) {
            addCriterion("disposition_id_list not like", value, "dispositionIdList");
            return (Criteria) this;
        }

        public Criteria andDispositionIdListIn(List<String> values) {
            addCriterion("disposition_id_list in", values, "dispositionIdList");
            return (Criteria) this;
        }

        public Criteria andDispositionIdListNotIn(List<String> values) {
            addCriterion("disposition_id_list not in", values, "dispositionIdList");
            return (Criteria) this;
        }

        public Criteria andDispositionIdListBetween(String value1, String value2) {
            addCriterion("disposition_id_list between", value1, value2, "dispositionIdList");
            return (Criteria) this;
        }

        public Criteria andDispositionIdListNotBetween(String value1, String value2) {
            addCriterion("disposition_id_list not between", value1, value2, "dispositionIdList");
            return (Criteria) this;
        }

        public Criteria andTestIdListIsNull() {
            addCriterion("test_id_list is null");
            return (Criteria) this;
        }

        public Criteria andTestIdListIsNotNull() {
            addCriterion("test_id_list is not null");
            return (Criteria) this;
        }

        public Criteria andTestIdListEqualTo(String value) {
            addCriterion("test_id_list =", value, "testIdList");
            return (Criteria) this;
        }

        public Criteria andTestIdListNotEqualTo(String value) {
            addCriterion("test_id_list <>", value, "testIdList");
            return (Criteria) this;
        }

        public Criteria andTestIdListGreaterThan(String value) {
            addCriterion("test_id_list >", value, "testIdList");
            return (Criteria) this;
        }

        public Criteria andTestIdListGreaterThanOrEqualTo(String value) {
            addCriterion("test_id_list >=", value, "testIdList");
            return (Criteria) this;
        }

        public Criteria andTestIdListLessThan(String value) {
            addCriterion("test_id_list <", value, "testIdList");
            return (Criteria) this;
        }

        public Criteria andTestIdListLessThanOrEqualTo(String value) {
            addCriterion("test_id_list <=", value, "testIdList");
            return (Criteria) this;
        }

        public Criteria andTestIdListLike(String value) {
            addCriterion("test_id_list like", value, "testIdList");
            return (Criteria) this;
        }

        public Criteria andTestIdListNotLike(String value) {
            addCriterion("test_id_list not like", value, "testIdList");
            return (Criteria) this;
        }

        public Criteria andTestIdListIn(List<String> values) {
            addCriterion("test_id_list in", values, "testIdList");
            return (Criteria) this;
        }

        public Criteria andTestIdListNotIn(List<String> values) {
            addCriterion("test_id_list not in", values, "testIdList");
            return (Criteria) this;
        }

        public Criteria andTestIdListBetween(String value1, String value2) {
            addCriterion("test_id_list between", value1, value2, "testIdList");
            return (Criteria) this;
        }

        public Criteria andTestIdListNotBetween(String value1, String value2) {
            addCriterion("test_id_list not between", value1, value2, "testIdList");
            return (Criteria) this;
        }

        public Criteria andHerbalDiseIdListIsNull() {
            addCriterion("herbal_dise_id_list is null");
            return (Criteria) this;
        }

        public Criteria andHerbalDiseIdListIsNotNull() {
            addCriterion("herbal_dise_id_list is not null");
            return (Criteria) this;
        }

        public Criteria andHerbalDiseIdListEqualTo(String value) {
            addCriterion("herbal_dise_id_list =", value, "herbalDiseIdList");
            return (Criteria) this;
        }

        public Criteria andHerbalDiseIdListNotEqualTo(String value) {
            addCriterion("herbal_dise_id_list <>", value, "herbalDiseIdList");
            return (Criteria) this;
        }

        public Criteria andHerbalDiseIdListGreaterThan(String value) {
            addCriterion("herbal_dise_id_list >", value, "herbalDiseIdList");
            return (Criteria) this;
        }

        public Criteria andHerbalDiseIdListGreaterThanOrEqualTo(String value) {
            addCriterion("herbal_dise_id_list >=", value, "herbalDiseIdList");
            return (Criteria) this;
        }

        public Criteria andHerbalDiseIdListLessThan(String value) {
            addCriterion("herbal_dise_id_list <", value, "herbalDiseIdList");
            return (Criteria) this;
        }

        public Criteria andHerbalDiseIdListLessThanOrEqualTo(String value) {
            addCriterion("herbal_dise_id_list <=", value, "herbalDiseIdList");
            return (Criteria) this;
        }

        public Criteria andHerbalDiseIdListLike(String value) {
            addCriterion("herbal_dise_id_list like", value, "herbalDiseIdList");
            return (Criteria) this;
        }

        public Criteria andHerbalDiseIdListNotLike(String value) {
            addCriterion("herbal_dise_id_list not like", value, "herbalDiseIdList");
            return (Criteria) this;
        }

        public Criteria andHerbalDiseIdListIn(List<String> values) {
            addCriterion("herbal_dise_id_list in", values, "herbalDiseIdList");
            return (Criteria) this;
        }

        public Criteria andHerbalDiseIdListNotIn(List<String> values) {
            addCriterion("herbal_dise_id_list not in", values, "herbalDiseIdList");
            return (Criteria) this;
        }

        public Criteria andHerbalDiseIdListBetween(String value1, String value2) {
            addCriterion("herbal_dise_id_list between", value1, value2, "herbalDiseIdList");
            return (Criteria) this;
        }

        public Criteria andHerbalDiseIdListNotBetween(String value1, String value2) {
            addCriterion("herbal_dise_id_list not between", value1, value2, "herbalDiseIdList");
            return (Criteria) this;
        }

        public Criteria andCheckModelIdListIsNull() {
            addCriterion("check_model_id_list is null");
            return (Criteria) this;
        }

        public Criteria andCheckModelIdListIsNotNull() {
            addCriterion("check_model_id_list is not null");
            return (Criteria) this;
        }

        public Criteria andCheckModelIdListEqualTo(String value) {
            addCriterion("check_model_id_list =", value, "checkModelIdList");
            return (Criteria) this;
        }

        public Criteria andCheckModelIdListNotEqualTo(String value) {
            addCriterion("check_model_id_list <>", value, "checkModelIdList");
            return (Criteria) this;
        }

        public Criteria andCheckModelIdListGreaterThan(String value) {
            addCriterion("check_model_id_list >", value, "checkModelIdList");
            return (Criteria) this;
        }

        public Criteria andCheckModelIdListGreaterThanOrEqualTo(String value) {
            addCriterion("check_model_id_list >=", value, "checkModelIdList");
            return (Criteria) this;
        }

        public Criteria andCheckModelIdListLessThan(String value) {
            addCriterion("check_model_id_list <", value, "checkModelIdList");
            return (Criteria) this;
        }

        public Criteria andCheckModelIdListLessThanOrEqualTo(String value) {
            addCriterion("check_model_id_list <=", value, "checkModelIdList");
            return (Criteria) this;
        }

        public Criteria andCheckModelIdListLike(String value) {
            addCriterion("check_model_id_list like", value, "checkModelIdList");
            return (Criteria) this;
        }

        public Criteria andCheckModelIdListNotLike(String value) {
            addCriterion("check_model_id_list not like", value, "checkModelIdList");
            return (Criteria) this;
        }

        public Criteria andCheckModelIdListIn(List<String> values) {
            addCriterion("check_model_id_list in", values, "checkModelIdList");
            return (Criteria) this;
        }

        public Criteria andCheckModelIdListNotIn(List<String> values) {
            addCriterion("check_model_id_list not in", values, "checkModelIdList");
            return (Criteria) this;
        }

        public Criteria andCheckModelIdListBetween(String value1, String value2) {
            addCriterion("check_model_id_list between", value1, value2, "checkModelIdList");
            return (Criteria) this;
        }

        public Criteria andCheckModelIdListNotBetween(String value1, String value2) {
            addCriterion("check_model_id_list not between", value1, value2, "checkModelIdList");
            return (Criteria) this;
        }

        public Criteria andDispositionModelIdListIsNull() {
            addCriterion("disposition_model_id_list is null");
            return (Criteria) this;
        }

        public Criteria andDispositionModelIdListIsNotNull() {
            addCriterion("disposition_model_id_list is not null");
            return (Criteria) this;
        }

        public Criteria andDispositionModelIdListEqualTo(String value) {
            addCriterion("disposition_model_id_list =", value, "dispositionModelIdList");
            return (Criteria) this;
        }

        public Criteria andDispositionModelIdListNotEqualTo(String value) {
            addCriterion("disposition_model_id_list <>", value, "dispositionModelIdList");
            return (Criteria) this;
        }

        public Criteria andDispositionModelIdListGreaterThan(String value) {
            addCriterion("disposition_model_id_list >", value, "dispositionModelIdList");
            return (Criteria) this;
        }

        public Criteria andDispositionModelIdListGreaterThanOrEqualTo(String value) {
            addCriterion("disposition_model_id_list >=", value, "dispositionModelIdList");
            return (Criteria) this;
        }

        public Criteria andDispositionModelIdListLessThan(String value) {
            addCriterion("disposition_model_id_list <", value, "dispositionModelIdList");
            return (Criteria) this;
        }

        public Criteria andDispositionModelIdListLessThanOrEqualTo(String value) {
            addCriterion("disposition_model_id_list <=", value, "dispositionModelIdList");
            return (Criteria) this;
        }

        public Criteria andDispositionModelIdListLike(String value) {
            addCriterion("disposition_model_id_list like", value, "dispositionModelIdList");
            return (Criteria) this;
        }

        public Criteria andDispositionModelIdListNotLike(String value) {
            addCriterion("disposition_model_id_list not like", value, "dispositionModelIdList");
            return (Criteria) this;
        }

        public Criteria andDispositionModelIdListIn(List<String> values) {
            addCriterion("disposition_model_id_list in", values, "dispositionModelIdList");
            return (Criteria) this;
        }

        public Criteria andDispositionModelIdListNotIn(List<String> values) {
            addCriterion("disposition_model_id_list not in", values, "dispositionModelIdList");
            return (Criteria) this;
        }

        public Criteria andDispositionModelIdListBetween(String value1, String value2) {
            addCriterion("disposition_model_id_list between", value1, value2, "dispositionModelIdList");
            return (Criteria) this;
        }

        public Criteria andDispositionModelIdListNotBetween(String value1, String value2) {
            addCriterion("disposition_model_id_list not between", value1, value2, "dispositionModelIdList");
            return (Criteria) this;
        }

        public Criteria andTestModelIdListIsNull() {
            addCriterion("test_model_id_list is null");
            return (Criteria) this;
        }

        public Criteria andTestModelIdListIsNotNull() {
            addCriterion("test_model_id_list is not null");
            return (Criteria) this;
        }

        public Criteria andTestModelIdListEqualTo(String value) {
            addCriterion("test_model_id_list =", value, "testModelIdList");
            return (Criteria) this;
        }

        public Criteria andTestModelIdListNotEqualTo(String value) {
            addCriterion("test_model_id_list <>", value, "testModelIdList");
            return (Criteria) this;
        }

        public Criteria andTestModelIdListGreaterThan(String value) {
            addCriterion("test_model_id_list >", value, "testModelIdList");
            return (Criteria) this;
        }

        public Criteria andTestModelIdListGreaterThanOrEqualTo(String value) {
            addCriterion("test_model_id_list >=", value, "testModelIdList");
            return (Criteria) this;
        }

        public Criteria andTestModelIdListLessThan(String value) {
            addCriterion("test_model_id_list <", value, "testModelIdList");
            return (Criteria) this;
        }

        public Criteria andTestModelIdListLessThanOrEqualTo(String value) {
            addCriterion("test_model_id_list <=", value, "testModelIdList");
            return (Criteria) this;
        }

        public Criteria andTestModelIdListLike(String value) {
            addCriterion("test_model_id_list like", value, "testModelIdList");
            return (Criteria) this;
        }

        public Criteria andTestModelIdListNotLike(String value) {
            addCriterion("test_model_id_list not like", value, "testModelIdList");
            return (Criteria) this;
        }

        public Criteria andTestModelIdListIn(List<String> values) {
            addCriterion("test_model_id_list in", values, "testModelIdList");
            return (Criteria) this;
        }

        public Criteria andTestModelIdListNotIn(List<String> values) {
            addCriterion("test_model_id_list not in", values, "testModelIdList");
            return (Criteria) this;
        }

        public Criteria andTestModelIdListBetween(String value1, String value2) {
            addCriterion("test_model_id_list between", value1, value2, "testModelIdList");
            return (Criteria) this;
        }

        public Criteria andTestModelIdListNotBetween(String value1, String value2) {
            addCriterion("test_model_id_list not between", value1, value2, "testModelIdList");
            return (Criteria) this;
        }

        public Criteria andDrugModelIdListIsNull() {
            addCriterion("drug_model_id_list is null");
            return (Criteria) this;
        }

        public Criteria andDrugModelIdListIsNotNull() {
            addCriterion("drug_model_id_list is not null");
            return (Criteria) this;
        }

        public Criteria andDrugModelIdListEqualTo(String value) {
            addCriterion("drug_model_id_list =", value, "drugModelIdList");
            return (Criteria) this;
        }

        public Criteria andDrugModelIdListNotEqualTo(String value) {
            addCriterion("drug_model_id_list <>", value, "drugModelIdList");
            return (Criteria) this;
        }

        public Criteria andDrugModelIdListGreaterThan(String value) {
            addCriterion("drug_model_id_list >", value, "drugModelIdList");
            return (Criteria) this;
        }

        public Criteria andDrugModelIdListGreaterThanOrEqualTo(String value) {
            addCriterion("drug_model_id_list >=", value, "drugModelIdList");
            return (Criteria) this;
        }

        public Criteria andDrugModelIdListLessThan(String value) {
            addCriterion("drug_model_id_list <", value, "drugModelIdList");
            return (Criteria) this;
        }

        public Criteria andDrugModelIdListLessThanOrEqualTo(String value) {
            addCriterion("drug_model_id_list <=", value, "drugModelIdList");
            return (Criteria) this;
        }

        public Criteria andDrugModelIdListLike(String value) {
            addCriterion("drug_model_id_list like", value, "drugModelIdList");
            return (Criteria) this;
        }

        public Criteria andDrugModelIdListNotLike(String value) {
            addCriterion("drug_model_id_list not like", value, "drugModelIdList");
            return (Criteria) this;
        }

        public Criteria andDrugModelIdListIn(List<String> values) {
            addCriterion("drug_model_id_list in", values, "drugModelIdList");
            return (Criteria) this;
        }

        public Criteria andDrugModelIdListNotIn(List<String> values) {
            addCriterion("drug_model_id_list not in", values, "drugModelIdList");
            return (Criteria) this;
        }

        public Criteria andDrugModelIdListBetween(String value1, String value2) {
            addCriterion("drug_model_id_list between", value1, value2, "drugModelIdList");
            return (Criteria) this;
        }

        public Criteria andDrugModelIdListNotBetween(String value1, String value2) {
            addCriterion("drug_model_id_list not between", value1, value2, "drugModelIdList");
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

        public Criteria andCheckIdListIsNull() {
            addCriterion("check_id_list is null");
            return (Criteria) this;
        }

        public Criteria andCheckIdListIsNotNull() {
            addCriterion("check_id_list is not null");
            return (Criteria) this;
        }

        public Criteria andCheckIdListEqualTo(String value) {
            addCriterion("check_id_list =", value, "checkIdList");
            return (Criteria) this;
        }

        public Criteria andCheckIdListNotEqualTo(String value) {
            addCriterion("check_id_list <>", value, "checkIdList");
            return (Criteria) this;
        }

        public Criteria andCheckIdListGreaterThan(String value) {
            addCriterion("check_id_list >", value, "checkIdList");
            return (Criteria) this;
        }

        public Criteria andCheckIdListGreaterThanOrEqualTo(String value) {
            addCriterion("check_id_list >=", value, "checkIdList");
            return (Criteria) this;
        }

        public Criteria andCheckIdListLessThan(String value) {
            addCriterion("check_id_list <", value, "checkIdList");
            return (Criteria) this;
        }

        public Criteria andCheckIdListLessThanOrEqualTo(String value) {
            addCriterion("check_id_list <=", value, "checkIdList");
            return (Criteria) this;
        }

        public Criteria andCheckIdListLike(String value) {
            addCriterion("check_id_list like", value, "checkIdList");
            return (Criteria) this;
        }

        public Criteria andCheckIdListNotLike(String value) {
            addCriterion("check_id_list not like", value, "checkIdList");
            return (Criteria) this;
        }

        public Criteria andCheckIdListIn(List<String> values) {
            addCriterion("check_id_list in", values, "checkIdList");
            return (Criteria) this;
        }

        public Criteria andCheckIdListNotIn(List<String> values) {
            addCriterion("check_id_list not in", values, "checkIdList");
            return (Criteria) this;
        }

        public Criteria andCheckIdListBetween(String value1, String value2) {
            addCriterion("check_id_list between", value1, value2, "checkIdList");
            return (Criteria) this;
        }

        public Criteria andCheckIdListNotBetween(String value1, String value2) {
            addCriterion("check_id_list not between", value1, value2, "checkIdList");
            return (Criteria) this;
        }

        public Criteria andDrugIdListIsNull() {
            addCriterion("drug_id_list is null");
            return (Criteria) this;
        }

        public Criteria andDrugIdListIsNotNull() {
            addCriterion("drug_id_list is not null");
            return (Criteria) this;
        }

        public Criteria andDrugIdListEqualTo(String value) {
            addCriterion("drug_id_list =", value, "drugIdList");
            return (Criteria) this;
        }

        public Criteria andDrugIdListNotEqualTo(String value) {
            addCriterion("drug_id_list <>", value, "drugIdList");
            return (Criteria) this;
        }

        public Criteria andDrugIdListGreaterThan(String value) {
            addCriterion("drug_id_list >", value, "drugIdList");
            return (Criteria) this;
        }

        public Criteria andDrugIdListGreaterThanOrEqualTo(String value) {
            addCriterion("drug_id_list >=", value, "drugIdList");
            return (Criteria) this;
        }

        public Criteria andDrugIdListLessThan(String value) {
            addCriterion("drug_id_list <", value, "drugIdList");
            return (Criteria) this;
        }

        public Criteria andDrugIdListLessThanOrEqualTo(String value) {
            addCriterion("drug_id_list <=", value, "drugIdList");
            return (Criteria) this;
        }

        public Criteria andDrugIdListLike(String value) {
            addCriterion("drug_id_list like", value, "drugIdList");
            return (Criteria) this;
        }

        public Criteria andDrugIdListNotLike(String value) {
            addCriterion("drug_id_list not like", value, "drugIdList");
            return (Criteria) this;
        }

        public Criteria andDrugIdListIn(List<String> values) {
            addCriterion("drug_id_list in", values, "drugIdList");
            return (Criteria) this;
        }

        public Criteria andDrugIdListNotIn(List<String> values) {
            addCriterion("drug_id_list not in", values, "drugIdList");
            return (Criteria) this;
        }

        public Criteria andDrugIdListBetween(String value1, String value2) {
            addCriterion("drug_id_list between", value1, value2, "drugIdList");
            return (Criteria) this;
        }

        public Criteria andDrugIdListNotBetween(String value1, String value2) {
            addCriterion("drug_id_list not between", value1, value2, "drugIdList");
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