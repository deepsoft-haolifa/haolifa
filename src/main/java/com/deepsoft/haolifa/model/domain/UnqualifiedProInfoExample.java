package com.deepsoft.haolifa.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UnqualifiedProInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UnqualifiedProInfoExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNull() {
            addCriterion("order_num is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNotNull() {
            addCriterion("order_num is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumEqualTo(String value) {
            addCriterion("order_num =", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotEqualTo(String value) {
            addCriterion("order_num <>", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThan(String value) {
            addCriterion("order_num >", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThanOrEqualTo(String value) {
            addCriterion("order_num >=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThan(String value) {
            addCriterion("order_num <", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThanOrEqualTo(String value) {
            addCriterion("order_num <=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLike(String value) {
            addCriterion("order_num like", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotLike(String value) {
            addCriterion("order_num not like", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumIn(List<String> values) {
            addCriterion("order_num in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotIn(List<String> values) {
            addCriterion("order_num not in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumBetween(String value1, String value2) {
            addCriterion("order_num between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotBetween(String value1, String value2) {
            addCriterion("order_num not between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andTestingUnitIsNull() {
            addCriterion("testing_unit is null");
            return (Criteria) this;
        }

        public Criteria andTestingUnitIsNotNull() {
            addCriterion("testing_unit is not null");
            return (Criteria) this;
        }

        public Criteria andTestingUnitEqualTo(String value) {
            addCriterion("testing_unit =", value, "testingUnit");
            return (Criteria) this;
        }

        public Criteria andTestingUnitNotEqualTo(String value) {
            addCriterion("testing_unit <>", value, "testingUnit");
            return (Criteria) this;
        }

        public Criteria andTestingUnitGreaterThan(String value) {
            addCriterion("testing_unit >", value, "testingUnit");
            return (Criteria) this;
        }

        public Criteria andTestingUnitGreaterThanOrEqualTo(String value) {
            addCriterion("testing_unit >=", value, "testingUnit");
            return (Criteria) this;
        }

        public Criteria andTestingUnitLessThan(String value) {
            addCriterion("testing_unit <", value, "testingUnit");
            return (Criteria) this;
        }

        public Criteria andTestingUnitLessThanOrEqualTo(String value) {
            addCriterion("testing_unit <=", value, "testingUnit");
            return (Criteria) this;
        }

        public Criteria andTestingUnitLike(String value) {
            addCriterion("testing_unit like", value, "testingUnit");
            return (Criteria) this;
        }

        public Criteria andTestingUnitNotLike(String value) {
            addCriterion("testing_unit not like", value, "testingUnit");
            return (Criteria) this;
        }

        public Criteria andTestingUnitIn(List<String> values) {
            addCriterion("testing_unit in", values, "testingUnit");
            return (Criteria) this;
        }

        public Criteria andTestingUnitNotIn(List<String> values) {
            addCriterion("testing_unit not in", values, "testingUnit");
            return (Criteria) this;
        }

        public Criteria andTestingUnitBetween(String value1, String value2) {
            addCriterion("testing_unit between", value1, value2, "testingUnit");
            return (Criteria) this;
        }

        public Criteria andTestingUnitNotBetween(String value1, String value2) {
            addCriterion("testing_unit not between", value1, value2, "testingUnit");
            return (Criteria) this;
        }

        public Criteria andTestingProcessIsNull() {
            addCriterion("testing_process is null");
            return (Criteria) this;
        }

        public Criteria andTestingProcessIsNotNull() {
            addCriterion("testing_process is not null");
            return (Criteria) this;
        }

        public Criteria andTestingProcessEqualTo(String value) {
            addCriterion("testing_process =", value, "testingProcess");
            return (Criteria) this;
        }

        public Criteria andTestingProcessNotEqualTo(String value) {
            addCriterion("testing_process <>", value, "testingProcess");
            return (Criteria) this;
        }

        public Criteria andTestingProcessGreaterThan(String value) {
            addCriterion("testing_process >", value, "testingProcess");
            return (Criteria) this;
        }

        public Criteria andTestingProcessGreaterThanOrEqualTo(String value) {
            addCriterion("testing_process >=", value, "testingProcess");
            return (Criteria) this;
        }

        public Criteria andTestingProcessLessThan(String value) {
            addCriterion("testing_process <", value, "testingProcess");
            return (Criteria) this;
        }

        public Criteria andTestingProcessLessThanOrEqualTo(String value) {
            addCriterion("testing_process <=", value, "testingProcess");
            return (Criteria) this;
        }

        public Criteria andTestingProcessLike(String value) {
            addCriterion("testing_process like", value, "testingProcess");
            return (Criteria) this;
        }

        public Criteria andTestingProcessNotLike(String value) {
            addCriterion("testing_process not like", value, "testingProcess");
            return (Criteria) this;
        }

        public Criteria andTestingProcessIn(List<String> values) {
            addCriterion("testing_process in", values, "testingProcess");
            return (Criteria) this;
        }

        public Criteria andTestingProcessNotIn(List<String> values) {
            addCriterion("testing_process not in", values, "testingProcess");
            return (Criteria) this;
        }

        public Criteria andTestingProcessBetween(String value1, String value2) {
            addCriterion("testing_process between", value1, value2, "testingProcess");
            return (Criteria) this;
        }

        public Criteria andTestingProcessNotBetween(String value1, String value2) {
            addCriterion("testing_process not between", value1, value2, "testingProcess");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Long value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Long value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Long value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Long value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Long value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Long value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Long> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Long> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Long value1, Long value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Long value1, Long value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andTestingNumberIsNull() {
            addCriterion("testing_number is null");
            return (Criteria) this;
        }

        public Criteria andTestingNumberIsNotNull() {
            addCriterion("testing_number is not null");
            return (Criteria) this;
        }

        public Criteria andTestingNumberEqualTo(Integer value) {
            addCriterion("testing_number =", value, "testingNumber");
            return (Criteria) this;
        }

        public Criteria andTestingNumberNotEqualTo(Integer value) {
            addCriterion("testing_number <>", value, "testingNumber");
            return (Criteria) this;
        }

        public Criteria andTestingNumberGreaterThan(Integer value) {
            addCriterion("testing_number >", value, "testingNumber");
            return (Criteria) this;
        }

        public Criteria andTestingNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("testing_number >=", value, "testingNumber");
            return (Criteria) this;
        }

        public Criteria andTestingNumberLessThan(Integer value) {
            addCriterion("testing_number <", value, "testingNumber");
            return (Criteria) this;
        }

        public Criteria andTestingNumberLessThanOrEqualTo(Integer value) {
            addCriterion("testing_number <=", value, "testingNumber");
            return (Criteria) this;
        }

        public Criteria andTestingNumberIn(List<Integer> values) {
            addCriterion("testing_number in", values, "testingNumber");
            return (Criteria) this;
        }

        public Criteria andTestingNumberNotIn(List<Integer> values) {
            addCriterion("testing_number not in", values, "testingNumber");
            return (Criteria) this;
        }

        public Criteria andTestingNumberBetween(Integer value1, Integer value2) {
            addCriterion("testing_number between", value1, value2, "testingNumber");
            return (Criteria) this;
        }

        public Criteria andTestingNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("testing_number not between", value1, value2, "testingNumber");
            return (Criteria) this;
        }

        public Criteria andUnqualifiedNumberIsNull() {
            addCriterion("unqualified_number is null");
            return (Criteria) this;
        }

        public Criteria andUnqualifiedNumberIsNotNull() {
            addCriterion("unqualified_number is not null");
            return (Criteria) this;
        }

        public Criteria andUnqualifiedNumberEqualTo(Integer value) {
            addCriterion("unqualified_number =", value, "unqualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andUnqualifiedNumberNotEqualTo(Integer value) {
            addCriterion("unqualified_number <>", value, "unqualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andUnqualifiedNumberGreaterThan(Integer value) {
            addCriterion("unqualified_number >", value, "unqualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andUnqualifiedNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("unqualified_number >=", value, "unqualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andUnqualifiedNumberLessThan(Integer value) {
            addCriterion("unqualified_number <", value, "unqualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andUnqualifiedNumberLessThanOrEqualTo(Integer value) {
            addCriterion("unqualified_number <=", value, "unqualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andUnqualifiedNumberIn(List<Integer> values) {
            addCriterion("unqualified_number in", values, "unqualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andUnqualifiedNumberNotIn(List<Integer> values) {
            addCriterion("unqualified_number not in", values, "unqualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andUnqualifiedNumberBetween(Integer value1, Integer value2) {
            addCriterion("unqualified_number between", value1, value2, "unqualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andUnqualifiedNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("unqualified_number not between", value1, value2, "unqualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andTestingPersonIsNull() {
            addCriterion("testing_person is null");
            return (Criteria) this;
        }

        public Criteria andTestingPersonIsNotNull() {
            addCriterion("testing_person is not null");
            return (Criteria) this;
        }

        public Criteria andTestingPersonEqualTo(String value) {
            addCriterion("testing_person =", value, "testingPerson");
            return (Criteria) this;
        }

        public Criteria andTestingPersonNotEqualTo(String value) {
            addCriterion("testing_person <>", value, "testingPerson");
            return (Criteria) this;
        }

        public Criteria andTestingPersonGreaterThan(String value) {
            addCriterion("testing_person >", value, "testingPerson");
            return (Criteria) this;
        }

        public Criteria andTestingPersonGreaterThanOrEqualTo(String value) {
            addCriterion("testing_person >=", value, "testingPerson");
            return (Criteria) this;
        }

        public Criteria andTestingPersonLessThan(String value) {
            addCriterion("testing_person <", value, "testingPerson");
            return (Criteria) this;
        }

        public Criteria andTestingPersonLessThanOrEqualTo(String value) {
            addCriterion("testing_person <=", value, "testingPerson");
            return (Criteria) this;
        }

        public Criteria andTestingPersonLike(String value) {
            addCriterion("testing_person like", value, "testingPerson");
            return (Criteria) this;
        }

        public Criteria andTestingPersonNotLike(String value) {
            addCriterion("testing_person not like", value, "testingPerson");
            return (Criteria) this;
        }

        public Criteria andTestingPersonIn(List<String> values) {
            addCriterion("testing_person in", values, "testingPerson");
            return (Criteria) this;
        }

        public Criteria andTestingPersonNotIn(List<String> values) {
            addCriterion("testing_person not in", values, "testingPerson");
            return (Criteria) this;
        }

        public Criteria andTestingPersonBetween(String value1, String value2) {
            addCriterion("testing_person between", value1, value2, "testingPerson");
            return (Criteria) this;
        }

        public Criteria andTestingPersonNotBetween(String value1, String value2) {
            addCriterion("testing_person not between", value1, value2, "testingPerson");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementsIsNull() {
            addCriterion("technical_requirements is null");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementsIsNotNull() {
            addCriterion("technical_requirements is not null");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementsEqualTo(String value) {
            addCriterion("technical_requirements =", value, "technicalRequirements");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementsNotEqualTo(String value) {
            addCriterion("technical_requirements <>", value, "technicalRequirements");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementsGreaterThan(String value) {
            addCriterion("technical_requirements >", value, "technicalRequirements");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementsGreaterThanOrEqualTo(String value) {
            addCriterion("technical_requirements >=", value, "technicalRequirements");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementsLessThan(String value) {
            addCriterion("technical_requirements <", value, "technicalRequirements");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementsLessThanOrEqualTo(String value) {
            addCriterion("technical_requirements <=", value, "technicalRequirements");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementsLike(String value) {
            addCriterion("technical_requirements like", value, "technicalRequirements");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementsNotLike(String value) {
            addCriterion("technical_requirements not like", value, "technicalRequirements");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementsIn(List<String> values) {
            addCriterion("technical_requirements in", values, "technicalRequirements");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementsNotIn(List<String> values) {
            addCriterion("technical_requirements not in", values, "technicalRequirements");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementsBetween(String value1, String value2) {
            addCriterion("technical_requirements between", value1, value2, "technicalRequirements");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementsNotBetween(String value1, String value2) {
            addCriterion("technical_requirements not between", value1, value2, "technicalRequirements");
            return (Criteria) this;
        }

        public Criteria andTestingResultIsNull() {
            addCriterion("testing_result is null");
            return (Criteria) this;
        }

        public Criteria andTestingResultIsNotNull() {
            addCriterion("testing_result is not null");
            return (Criteria) this;
        }

        public Criteria andTestingResultEqualTo(String value) {
            addCriterion("testing_result =", value, "testingResult");
            return (Criteria) this;
        }

        public Criteria andTestingResultNotEqualTo(String value) {
            addCriterion("testing_result <>", value, "testingResult");
            return (Criteria) this;
        }

        public Criteria andTestingResultGreaterThan(String value) {
            addCriterion("testing_result >", value, "testingResult");
            return (Criteria) this;
        }

        public Criteria andTestingResultGreaterThanOrEqualTo(String value) {
            addCriterion("testing_result >=", value, "testingResult");
            return (Criteria) this;
        }

        public Criteria andTestingResultLessThan(String value) {
            addCriterion("testing_result <", value, "testingResult");
            return (Criteria) this;
        }

        public Criteria andTestingResultLessThanOrEqualTo(String value) {
            addCriterion("testing_result <=", value, "testingResult");
            return (Criteria) this;
        }

        public Criteria andTestingResultLike(String value) {
            addCriterion("testing_result like", value, "testingResult");
            return (Criteria) this;
        }

        public Criteria andTestingResultNotLike(String value) {
            addCriterion("testing_result not like", value, "testingResult");
            return (Criteria) this;
        }

        public Criteria andTestingResultIn(List<String> values) {
            addCriterion("testing_result in", values, "testingResult");
            return (Criteria) this;
        }

        public Criteria andTestingResultNotIn(List<String> values) {
            addCriterion("testing_result not in", values, "testingResult");
            return (Criteria) this;
        }

        public Criteria andTestingResultBetween(String value1, String value2) {
            addCriterion("testing_result between", value1, value2, "testingResult");
            return (Criteria) this;
        }

        public Criteria andTestingResultNotBetween(String value1, String value2) {
            addCriterion("testing_result not between", value1, value2, "testingResult");
            return (Criteria) this;
        }

        public Criteria andInspectorIsNull() {
            addCriterion("inspector is null");
            return (Criteria) this;
        }

        public Criteria andInspectorIsNotNull() {
            addCriterion("inspector is not null");
            return (Criteria) this;
        }

        public Criteria andInspectorEqualTo(String value) {
            addCriterion("inspector =", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorNotEqualTo(String value) {
            addCriterion("inspector <>", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorGreaterThan(String value) {
            addCriterion("inspector >", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorGreaterThanOrEqualTo(String value) {
            addCriterion("inspector >=", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorLessThan(String value) {
            addCriterion("inspector <", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorLessThanOrEqualTo(String value) {
            addCriterion("inspector <=", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorLike(String value) {
            addCriterion("inspector like", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorNotLike(String value) {
            addCriterion("inspector not like", value, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorIn(List<String> values) {
            addCriterion("inspector in", values, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorNotIn(List<String> values) {
            addCriterion("inspector not in", values, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorBetween(String value1, String value2) {
            addCriterion("inspector between", value1, value2, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspectorNotBetween(String value1, String value2) {
            addCriterion("inspector not between", value1, value2, "inspector");
            return (Criteria) this;
        }

        public Criteria andInspecteDateIsNull() {
            addCriterion("inspecte_date is null");
            return (Criteria) this;
        }

        public Criteria andInspecteDateIsNotNull() {
            addCriterion("inspecte_date is not null");
            return (Criteria) this;
        }

        public Criteria andInspecteDateEqualTo(Date value) {
            addCriterion("inspecte_date =", value, "inspecteDate");
            return (Criteria) this;
        }

        public Criteria andInspecteDateNotEqualTo(Date value) {
            addCriterion("inspecte_date <>", value, "inspecteDate");
            return (Criteria) this;
        }

        public Criteria andInspecteDateGreaterThan(Date value) {
            addCriterion("inspecte_date >", value, "inspecteDate");
            return (Criteria) this;
        }

        public Criteria andInspecteDateGreaterThanOrEqualTo(Date value) {
            addCriterion("inspecte_date >=", value, "inspecteDate");
            return (Criteria) this;
        }

        public Criteria andInspecteDateLessThan(Date value) {
            addCriterion("inspecte_date <", value, "inspecteDate");
            return (Criteria) this;
        }

        public Criteria andInspecteDateLessThanOrEqualTo(Date value) {
            addCriterion("inspecte_date <=", value, "inspecteDate");
            return (Criteria) this;
        }

        public Criteria andInspecteDateIn(List<Date> values) {
            addCriterion("inspecte_date in", values, "inspecteDate");
            return (Criteria) this;
        }

        public Criteria andInspecteDateNotIn(List<Date> values) {
            addCriterion("inspecte_date not in", values, "inspecteDate");
            return (Criteria) this;
        }

        public Criteria andInspecteDateBetween(Date value1, Date value2) {
            addCriterion("inspecte_date between", value1, value2, "inspecteDate");
            return (Criteria) this;
        }

        public Criteria andInspecteDateNotBetween(Date value1, Date value2) {
            addCriterion("inspecte_date not between", value1, value2, "inspecteDate");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andResponsibleDepartmentIsNull() {
            addCriterion("responsible_department is null");
            return (Criteria) this;
        }

        public Criteria andResponsibleDepartmentIsNotNull() {
            addCriterion("responsible_department is not null");
            return (Criteria) this;
        }

        public Criteria andResponsibleDepartmentEqualTo(String value) {
            addCriterion("responsible_department =", value, "responsibleDepartment");
            return (Criteria) this;
        }

        public Criteria andResponsibleDepartmentNotEqualTo(String value) {
            addCriterion("responsible_department <>", value, "responsibleDepartment");
            return (Criteria) this;
        }

        public Criteria andResponsibleDepartmentGreaterThan(String value) {
            addCriterion("responsible_department >", value, "responsibleDepartment");
            return (Criteria) this;
        }

        public Criteria andResponsibleDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("responsible_department >=", value, "responsibleDepartment");
            return (Criteria) this;
        }

        public Criteria andResponsibleDepartmentLessThan(String value) {
            addCriterion("responsible_department <", value, "responsibleDepartment");
            return (Criteria) this;
        }

        public Criteria andResponsibleDepartmentLessThanOrEqualTo(String value) {
            addCriterion("responsible_department <=", value, "responsibleDepartment");
            return (Criteria) this;
        }

        public Criteria andResponsibleDepartmentLike(String value) {
            addCriterion("responsible_department like", value, "responsibleDepartment");
            return (Criteria) this;
        }

        public Criteria andResponsibleDepartmentNotLike(String value) {
            addCriterion("responsible_department not like", value, "responsibleDepartment");
            return (Criteria) this;
        }

        public Criteria andResponsibleDepartmentIn(List<String> values) {
            addCriterion("responsible_department in", values, "responsibleDepartment");
            return (Criteria) this;
        }

        public Criteria andResponsibleDepartmentNotIn(List<String> values) {
            addCriterion("responsible_department not in", values, "responsibleDepartment");
            return (Criteria) this;
        }

        public Criteria andResponsibleDepartmentBetween(String value1, String value2) {
            addCriterion("responsible_department between", value1, value2, "responsibleDepartment");
            return (Criteria) this;
        }

        public Criteria andResponsibleDepartmentNotBetween(String value1, String value2) {
            addCriterion("responsible_department not between", value1, value2, "responsibleDepartment");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIsNull() {
            addCriterion("department_leader is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIsNotNull() {
            addCriterion("department_leader is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderEqualTo(String value) {
            addCriterion("department_leader =", value, "departmentLeader");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderNotEqualTo(String value) {
            addCriterion("department_leader <>", value, "departmentLeader");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderGreaterThan(String value) {
            addCriterion("department_leader >", value, "departmentLeader");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("department_leader >=", value, "departmentLeader");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderLessThan(String value) {
            addCriterion("department_leader <", value, "departmentLeader");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderLessThanOrEqualTo(String value) {
            addCriterion("department_leader <=", value, "departmentLeader");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderLike(String value) {
            addCriterion("department_leader like", value, "departmentLeader");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderNotLike(String value) {
            addCriterion("department_leader not like", value, "departmentLeader");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIn(List<String> values) {
            addCriterion("department_leader in", values, "departmentLeader");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderNotIn(List<String> values) {
            addCriterion("department_leader not in", values, "departmentLeader");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderBetween(String value1, String value2) {
            addCriterion("department_leader between", value1, value2, "departmentLeader");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderNotBetween(String value1, String value2) {
            addCriterion("department_leader not between", value1, value2, "departmentLeader");
            return (Criteria) this;
        }

        public Criteria andResponsibleAnalyzeDateIsNull() {
            addCriterion("responsible_analyze_date is null");
            return (Criteria) this;
        }

        public Criteria andResponsibleAnalyzeDateIsNotNull() {
            addCriterion("responsible_analyze_date is not null");
            return (Criteria) this;
        }

        public Criteria andResponsibleAnalyzeDateEqualTo(Date value) {
            addCriterion("responsible_analyze_date =", value, "responsibleAnalyzeDate");
            return (Criteria) this;
        }

        public Criteria andResponsibleAnalyzeDateNotEqualTo(Date value) {
            addCriterion("responsible_analyze_date <>", value, "responsibleAnalyzeDate");
            return (Criteria) this;
        }

        public Criteria andResponsibleAnalyzeDateGreaterThan(Date value) {
            addCriterion("responsible_analyze_date >", value, "responsibleAnalyzeDate");
            return (Criteria) this;
        }

        public Criteria andResponsibleAnalyzeDateGreaterThanOrEqualTo(Date value) {
            addCriterion("responsible_analyze_date >=", value, "responsibleAnalyzeDate");
            return (Criteria) this;
        }

        public Criteria andResponsibleAnalyzeDateLessThan(Date value) {
            addCriterion("responsible_analyze_date <", value, "responsibleAnalyzeDate");
            return (Criteria) this;
        }

        public Criteria andResponsibleAnalyzeDateLessThanOrEqualTo(Date value) {
            addCriterion("responsible_analyze_date <=", value, "responsibleAnalyzeDate");
            return (Criteria) this;
        }

        public Criteria andResponsibleAnalyzeDateIn(List<Date> values) {
            addCriterion("responsible_analyze_date in", values, "responsibleAnalyzeDate");
            return (Criteria) this;
        }

        public Criteria andResponsibleAnalyzeDateNotIn(List<Date> values) {
            addCriterion("responsible_analyze_date not in", values, "responsibleAnalyzeDate");
            return (Criteria) this;
        }

        public Criteria andResponsibleAnalyzeDateBetween(Date value1, Date value2) {
            addCriterion("responsible_analyze_date between", value1, value2, "responsibleAnalyzeDate");
            return (Criteria) this;
        }

        public Criteria andResponsibleAnalyzeDateNotBetween(Date value1, Date value2) {
            addCriterion("responsible_analyze_date not between", value1, value2, "responsibleAnalyzeDate");
            return (Criteria) this;
        }

        public Criteria andTechnicalDepartmentOpinionIsNull() {
            addCriterion("technical_department_opinion is null");
            return (Criteria) this;
        }

        public Criteria andTechnicalDepartmentOpinionIsNotNull() {
            addCriterion("technical_department_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andTechnicalDepartmentOpinionEqualTo(String value) {
            addCriterion("technical_department_opinion =", value, "technicalDepartmentOpinion");
            return (Criteria) this;
        }

        public Criteria andTechnicalDepartmentOpinionNotEqualTo(String value) {
            addCriterion("technical_department_opinion <>", value, "technicalDepartmentOpinion");
            return (Criteria) this;
        }

        public Criteria andTechnicalDepartmentOpinionGreaterThan(String value) {
            addCriterion("technical_department_opinion >", value, "technicalDepartmentOpinion");
            return (Criteria) this;
        }

        public Criteria andTechnicalDepartmentOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("technical_department_opinion >=", value, "technicalDepartmentOpinion");
            return (Criteria) this;
        }

        public Criteria andTechnicalDepartmentOpinionLessThan(String value) {
            addCriterion("technical_department_opinion <", value, "technicalDepartmentOpinion");
            return (Criteria) this;
        }

        public Criteria andTechnicalDepartmentOpinionLessThanOrEqualTo(String value) {
            addCriterion("technical_department_opinion <=", value, "technicalDepartmentOpinion");
            return (Criteria) this;
        }

        public Criteria andTechnicalDepartmentOpinionLike(String value) {
            addCriterion("technical_department_opinion like", value, "technicalDepartmentOpinion");
            return (Criteria) this;
        }

        public Criteria andTechnicalDepartmentOpinionNotLike(String value) {
            addCriterion("technical_department_opinion not like", value, "technicalDepartmentOpinion");
            return (Criteria) this;
        }

        public Criteria andTechnicalDepartmentOpinionIn(List<String> values) {
            addCriterion("technical_department_opinion in", values, "technicalDepartmentOpinion");
            return (Criteria) this;
        }

        public Criteria andTechnicalDepartmentOpinionNotIn(List<String> values) {
            addCriterion("technical_department_opinion not in", values, "technicalDepartmentOpinion");
            return (Criteria) this;
        }

        public Criteria andTechnicalDepartmentOpinionBetween(String value1, String value2) {
            addCriterion("technical_department_opinion between", value1, value2, "technicalDepartmentOpinion");
            return (Criteria) this;
        }

        public Criteria andTechnicalDepartmentOpinionNotBetween(String value1, String value2) {
            addCriterion("technical_department_opinion not between", value1, value2, "technicalDepartmentOpinion");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Byte value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Byte value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Byte value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Byte value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Byte value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Byte> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Byte> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Byte value1, Byte value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Byte value1, Byte value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(Integer value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(Integer value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(Integer value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(Integer value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<Integer> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<Integer> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
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