package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PriceMaterialExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PriceMaterialExample() {
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

        public Criteria andMaterialClassifyIdIsNull() {
            addCriterion("material_classify_id is null");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyIdIsNotNull() {
            addCriterion("material_classify_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyIdEqualTo(Integer value) {
            addCriterion("material_classify_id =", value, "materialClassifyId");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyIdNotEqualTo(Integer value) {
            addCriterion("material_classify_id <>", value, "materialClassifyId");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyIdGreaterThan(Integer value) {
            addCriterion("material_classify_id >", value, "materialClassifyId");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("material_classify_id >=", value, "materialClassifyId");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyIdLessThan(Integer value) {
            addCriterion("material_classify_id <", value, "materialClassifyId");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyIdLessThanOrEqualTo(Integer value) {
            addCriterion("material_classify_id <=", value, "materialClassifyId");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyIdIn(List<Integer> values) {
            addCriterion("material_classify_id in", values, "materialClassifyId");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyIdNotIn(List<Integer> values) {
            addCriterion("material_classify_id not in", values, "materialClassifyId");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyIdBetween(Integer value1, Integer value2) {
            addCriterion("material_classify_id between", value1, value2, "materialClassifyId");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("material_classify_id not between", value1, value2, "materialClassifyId");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyNameIsNull() {
            addCriterion("material_classify_name is null");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyNameIsNotNull() {
            addCriterion("material_classify_name is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyNameEqualTo(String value) {
            addCriterion("material_classify_name =", value, "materialClassifyName");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyNameNotEqualTo(String value) {
            addCriterion("material_classify_name <>", value, "materialClassifyName");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyNameGreaterThan(String value) {
            addCriterion("material_classify_name >", value, "materialClassifyName");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyNameGreaterThanOrEqualTo(String value) {
            addCriterion("material_classify_name >=", value, "materialClassifyName");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyNameLessThan(String value) {
            addCriterion("material_classify_name <", value, "materialClassifyName");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyNameLessThanOrEqualTo(String value) {
            addCriterion("material_classify_name <=", value, "materialClassifyName");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyNameLike(String value) {
            addCriterion("material_classify_name like", value, "materialClassifyName");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyNameNotLike(String value) {
            addCriterion("material_classify_name not like", value, "materialClassifyName");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyNameIn(List<String> values) {
            addCriterion("material_classify_name in", values, "materialClassifyName");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyNameNotIn(List<String> values) {
            addCriterion("material_classify_name not in", values, "materialClassifyName");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyNameBetween(String value1, String value2) {
            addCriterion("material_classify_name between", value1, value2, "materialClassifyName");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyNameNotBetween(String value1, String value2) {
            addCriterion("material_classify_name not between", value1, value2, "materialClassifyName");
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

        public Criteria andGraphNoIsNull() {
            addCriterion("graph_no is null");
            return (Criteria) this;
        }

        public Criteria andGraphNoIsNotNull() {
            addCriterion("graph_no is not null");
            return (Criteria) this;
        }

        public Criteria andGraphNoEqualTo(String value) {
            addCriterion("graph_no =", value, "graphNo");
            return (Criteria) this;
        }

        public Criteria andGraphNoNotEqualTo(String value) {
            addCriterion("graph_no <>", value, "graphNo");
            return (Criteria) this;
        }

        public Criteria andGraphNoGreaterThan(String value) {
            addCriterion("graph_no >", value, "graphNo");
            return (Criteria) this;
        }

        public Criteria andGraphNoGreaterThanOrEqualTo(String value) {
            addCriterion("graph_no >=", value, "graphNo");
            return (Criteria) this;
        }

        public Criteria andGraphNoLessThan(String value) {
            addCriterion("graph_no <", value, "graphNo");
            return (Criteria) this;
        }

        public Criteria andGraphNoLessThanOrEqualTo(String value) {
            addCriterion("graph_no <=", value, "graphNo");
            return (Criteria) this;
        }

        public Criteria andGraphNoLike(String value) {
            addCriterion("graph_no like", value, "graphNo");
            return (Criteria) this;
        }

        public Criteria andGraphNoNotLike(String value) {
            addCriterion("graph_no not like", value, "graphNo");
            return (Criteria) this;
        }

        public Criteria andGraphNoIn(List<String> values) {
            addCriterion("graph_no in", values, "graphNo");
            return (Criteria) this;
        }

        public Criteria andGraphNoNotIn(List<String> values) {
            addCriterion("graph_no not in", values, "graphNo");
            return (Criteria) this;
        }

        public Criteria andGraphNoBetween(String value1, String value2) {
            addCriterion("graph_no between", value1, value2, "graphNo");
            return (Criteria) this;
        }

        public Criteria andGraphNoNotBetween(String value1, String value2) {
            addCriterion("graph_no not between", value1, value2, "graphNo");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIsNull() {
            addCriterion("specifications is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIsNotNull() {
            addCriterion("specifications is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationsEqualTo(String value) {
            addCriterion("specifications =", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotEqualTo(String value) {
            addCriterion("specifications <>", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsGreaterThan(String value) {
            addCriterion("specifications >", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsGreaterThanOrEqualTo(String value) {
            addCriterion("specifications >=", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLessThan(String value) {
            addCriterion("specifications <", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLessThanOrEqualTo(String value) {
            addCriterion("specifications <=", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLike(String value) {
            addCriterion("specifications like", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotLike(String value) {
            addCriterion("specifications not like", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIn(List<String> values) {
            addCriterion("specifications in", values, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotIn(List<String> values) {
            addCriterion("specifications not in", values, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsBetween(String value1, String value2) {
            addCriterion("specifications between", value1, value2, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotBetween(String value1, String value2) {
            addCriterion("specifications not between", value1, value2, "specifications");
            return (Criteria) this;
        }

        public Criteria andMaterialIsNull() {
            addCriterion("material is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIsNotNull() {
            addCriterion("material is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialEqualTo(String value) {
            addCriterion("material =", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotEqualTo(String value) {
            addCriterion("material <>", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialGreaterThan(String value) {
            addCriterion("material >", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialGreaterThanOrEqualTo(String value) {
            addCriterion("material >=", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLessThan(String value) {
            addCriterion("material <", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLessThanOrEqualTo(String value) {
            addCriterion("material <=", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLike(String value) {
            addCriterion("material like", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotLike(String value) {
            addCriterion("material not like", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialIn(List<String> values) {
            addCriterion("material in", values, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotIn(List<String> values) {
            addCriterion("material not in", values, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialBetween(String value1, String value2) {
            addCriterion("material between", value1, value2, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotBetween(String value1, String value2) {
            addCriterion("material not between", value1, value2, "material");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andActualWeightIsNull() {
            addCriterion("actual_weight is null");
            return (Criteria) this;
        }

        public Criteria andActualWeightIsNotNull() {
            addCriterion("actual_weight is not null");
            return (Criteria) this;
        }

        public Criteria andActualWeightEqualTo(String value) {
            addCriterion("actual_weight =", value, "actualWeight");
            return (Criteria) this;
        }

        public Criteria andActualWeightNotEqualTo(String value) {
            addCriterion("actual_weight <>", value, "actualWeight");
            return (Criteria) this;
        }

        public Criteria andActualWeightGreaterThan(String value) {
            addCriterion("actual_weight >", value, "actualWeight");
            return (Criteria) this;
        }

        public Criteria andActualWeightGreaterThanOrEqualTo(String value) {
            addCriterion("actual_weight >=", value, "actualWeight");
            return (Criteria) this;
        }

        public Criteria andActualWeightLessThan(String value) {
            addCriterion("actual_weight <", value, "actualWeight");
            return (Criteria) this;
        }

        public Criteria andActualWeightLessThanOrEqualTo(String value) {
            addCriterion("actual_weight <=", value, "actualWeight");
            return (Criteria) this;
        }

        public Criteria andActualWeightLike(String value) {
            addCriterion("actual_weight like", value, "actualWeight");
            return (Criteria) this;
        }

        public Criteria andActualWeightNotLike(String value) {
            addCriterion("actual_weight not like", value, "actualWeight");
            return (Criteria) this;
        }

        public Criteria andActualWeightIn(List<String> values) {
            addCriterion("actual_weight in", values, "actualWeight");
            return (Criteria) this;
        }

        public Criteria andActualWeightNotIn(List<String> values) {
            addCriterion("actual_weight not in", values, "actualWeight");
            return (Criteria) this;
        }

        public Criteria andActualWeightBetween(String value1, String value2) {
            addCriterion("actual_weight between", value1, value2, "actualWeight");
            return (Criteria) this;
        }

        public Criteria andActualWeightNotBetween(String value1, String value2) {
            addCriterion("actual_weight not between", value1, value2, "actualWeight");
            return (Criteria) this;
        }

        public Criteria andTaxRateIsNull() {
            addCriterion("tax_rate is null");
            return (Criteria) this;
        }

        public Criteria andTaxRateIsNotNull() {
            addCriterion("tax_rate is not null");
            return (Criteria) this;
        }

        public Criteria andTaxRateEqualTo(String value) {
            addCriterion("tax_rate =", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotEqualTo(String value) {
            addCriterion("tax_rate <>", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateGreaterThan(String value) {
            addCriterion("tax_rate >", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateGreaterThanOrEqualTo(String value) {
            addCriterion("tax_rate >=", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateLessThan(String value) {
            addCriterion("tax_rate <", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateLessThanOrEqualTo(String value) {
            addCriterion("tax_rate <=", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateLike(String value) {
            addCriterion("tax_rate like", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotLike(String value) {
            addCriterion("tax_rate not like", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateIn(List<String> values) {
            addCriterion("tax_rate in", values, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotIn(List<String> values) {
            addCriterion("tax_rate not in", values, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateBetween(String value1, String value2) {
            addCriterion("tax_rate between", value1, value2, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotBetween(String value1, String value2) {
            addCriterion("tax_rate not between", value1, value2, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTonPriceIsNull() {
            addCriterion("ton_price is null");
            return (Criteria) this;
        }

        public Criteria andTonPriceIsNotNull() {
            addCriterion("ton_price is not null");
            return (Criteria) this;
        }

        public Criteria andTonPriceEqualTo(BigDecimal value) {
            addCriterion("ton_price =", value, "tonPrice");
            return (Criteria) this;
        }

        public Criteria andTonPriceNotEqualTo(BigDecimal value) {
            addCriterion("ton_price <>", value, "tonPrice");
            return (Criteria) this;
        }

        public Criteria andTonPriceGreaterThan(BigDecimal value) {
            addCriterion("ton_price >", value, "tonPrice");
            return (Criteria) this;
        }

        public Criteria andTonPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ton_price >=", value, "tonPrice");
            return (Criteria) this;
        }

        public Criteria andTonPriceLessThan(BigDecimal value) {
            addCriterion("ton_price <", value, "tonPrice");
            return (Criteria) this;
        }

        public Criteria andTonPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ton_price <=", value, "tonPrice");
            return (Criteria) this;
        }

        public Criteria andTonPriceIn(List<BigDecimal> values) {
            addCriterion("ton_price in", values, "tonPrice");
            return (Criteria) this;
        }

        public Criteria andTonPriceNotIn(List<BigDecimal> values) {
            addCriterion("ton_price not in", values, "tonPrice");
            return (Criteria) this;
        }

        public Criteria andTonPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ton_price between", value1, value2, "tonPrice");
            return (Criteria) this;
        }

        public Criteria andTonPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ton_price not between", value1, value2, "tonPrice");
            return (Criteria) this;
        }

        public Criteria andBlankCostIsNull() {
            addCriterion("blank_cost is null");
            return (Criteria) this;
        }

        public Criteria andBlankCostIsNotNull() {
            addCriterion("blank_cost is not null");
            return (Criteria) this;
        }

        public Criteria andBlankCostEqualTo(BigDecimal value) {
            addCriterion("blank_cost =", value, "blankCost");
            return (Criteria) this;
        }

        public Criteria andBlankCostNotEqualTo(BigDecimal value) {
            addCriterion("blank_cost <>", value, "blankCost");
            return (Criteria) this;
        }

        public Criteria andBlankCostGreaterThan(BigDecimal value) {
            addCriterion("blank_cost >", value, "blankCost");
            return (Criteria) this;
        }

        public Criteria andBlankCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("blank_cost >=", value, "blankCost");
            return (Criteria) this;
        }

        public Criteria andBlankCostLessThan(BigDecimal value) {
            addCriterion("blank_cost <", value, "blankCost");
            return (Criteria) this;
        }

        public Criteria andBlankCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("blank_cost <=", value, "blankCost");
            return (Criteria) this;
        }

        public Criteria andBlankCostIn(List<BigDecimal> values) {
            addCriterion("blank_cost in", values, "blankCost");
            return (Criteria) this;
        }

        public Criteria andBlankCostNotIn(List<BigDecimal> values) {
            addCriterion("blank_cost not in", values, "blankCost");
            return (Criteria) this;
        }

        public Criteria andBlankCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("blank_cost between", value1, value2, "blankCost");
            return (Criteria) this;
        }

        public Criteria andBlankCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("blank_cost not between", value1, value2, "blankCost");
            return (Criteria) this;
        }

        public Criteria andBlankCostTaxIsNull() {
            addCriterion("blank_cost_tax is null");
            return (Criteria) this;
        }

        public Criteria andBlankCostTaxIsNotNull() {
            addCriterion("blank_cost_tax is not null");
            return (Criteria) this;
        }

        public Criteria andBlankCostTaxEqualTo(BigDecimal value) {
            addCriterion("blank_cost_tax =", value, "blankCostTax");
            return (Criteria) this;
        }

        public Criteria andBlankCostTaxNotEqualTo(BigDecimal value) {
            addCriterion("blank_cost_tax <>", value, "blankCostTax");
            return (Criteria) this;
        }

        public Criteria andBlankCostTaxGreaterThan(BigDecimal value) {
            addCriterion("blank_cost_tax >", value, "blankCostTax");
            return (Criteria) this;
        }

        public Criteria andBlankCostTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("blank_cost_tax >=", value, "blankCostTax");
            return (Criteria) this;
        }

        public Criteria andBlankCostTaxLessThan(BigDecimal value) {
            addCriterion("blank_cost_tax <", value, "blankCostTax");
            return (Criteria) this;
        }

        public Criteria andBlankCostTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("blank_cost_tax <=", value, "blankCostTax");
            return (Criteria) this;
        }

        public Criteria andBlankCostTaxIn(List<BigDecimal> values) {
            addCriterion("blank_cost_tax in", values, "blankCostTax");
            return (Criteria) this;
        }

        public Criteria andBlankCostTaxNotIn(List<BigDecimal> values) {
            addCriterion("blank_cost_tax not in", values, "blankCostTax");
            return (Criteria) this;
        }

        public Criteria andBlankCostTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("blank_cost_tax between", value1, value2, "blankCostTax");
            return (Criteria) this;
        }

        public Criteria andBlankCostTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("blank_cost_tax not between", value1, value2, "blankCostTax");
            return (Criteria) this;
        }

        public Criteria andProcessCostIsNull() {
            addCriterion("process_cost is null");
            return (Criteria) this;
        }

        public Criteria andProcessCostIsNotNull() {
            addCriterion("process_cost is not null");
            return (Criteria) this;
        }

        public Criteria andProcessCostEqualTo(BigDecimal value) {
            addCriterion("process_cost =", value, "processCost");
            return (Criteria) this;
        }

        public Criteria andProcessCostNotEqualTo(BigDecimal value) {
            addCriterion("process_cost <>", value, "processCost");
            return (Criteria) this;
        }

        public Criteria andProcessCostGreaterThan(BigDecimal value) {
            addCriterion("process_cost >", value, "processCost");
            return (Criteria) this;
        }

        public Criteria andProcessCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("process_cost >=", value, "processCost");
            return (Criteria) this;
        }

        public Criteria andProcessCostLessThan(BigDecimal value) {
            addCriterion("process_cost <", value, "processCost");
            return (Criteria) this;
        }

        public Criteria andProcessCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("process_cost <=", value, "processCost");
            return (Criteria) this;
        }

        public Criteria andProcessCostIn(List<BigDecimal> values) {
            addCriterion("process_cost in", values, "processCost");
            return (Criteria) this;
        }

        public Criteria andProcessCostNotIn(List<BigDecimal> values) {
            addCriterion("process_cost not in", values, "processCost");
            return (Criteria) this;
        }

        public Criteria andProcessCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("process_cost between", value1, value2, "processCost");
            return (Criteria) this;
        }

        public Criteria andProcessCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("process_cost not between", value1, value2, "processCost");
            return (Criteria) this;
        }

        public Criteria andSprayCostIsNull() {
            addCriterion("spray_cost is null");
            return (Criteria) this;
        }

        public Criteria andSprayCostIsNotNull() {
            addCriterion("spray_cost is not null");
            return (Criteria) this;
        }

        public Criteria andSprayCostEqualTo(BigDecimal value) {
            addCriterion("spray_cost =", value, "sprayCost");
            return (Criteria) this;
        }

        public Criteria andSprayCostNotEqualTo(BigDecimal value) {
            addCriterion("spray_cost <>", value, "sprayCost");
            return (Criteria) this;
        }

        public Criteria andSprayCostGreaterThan(BigDecimal value) {
            addCriterion("spray_cost >", value, "sprayCost");
            return (Criteria) this;
        }

        public Criteria andSprayCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("spray_cost >=", value, "sprayCost");
            return (Criteria) this;
        }

        public Criteria andSprayCostLessThan(BigDecimal value) {
            addCriterion("spray_cost <", value, "sprayCost");
            return (Criteria) this;
        }

        public Criteria andSprayCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("spray_cost <=", value, "sprayCost");
            return (Criteria) this;
        }

        public Criteria andSprayCostIn(List<BigDecimal> values) {
            addCriterion("spray_cost in", values, "sprayCost");
            return (Criteria) this;
        }

        public Criteria andSprayCostNotIn(List<BigDecimal> values) {
            addCriterion("spray_cost not in", values, "sprayCost");
            return (Criteria) this;
        }

        public Criteria andSprayCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("spray_cost between", value1, value2, "sprayCost");
            return (Criteria) this;
        }

        public Criteria andSprayCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("spray_cost not between", value1, value2, "sprayCost");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceTaxIsNull() {
            addCriterion("price_tax is null");
            return (Criteria) this;
        }

        public Criteria andPriceTaxIsNotNull() {
            addCriterion("price_tax is not null");
            return (Criteria) this;
        }

        public Criteria andPriceTaxEqualTo(BigDecimal value) {
            addCriterion("price_tax =", value, "priceTax");
            return (Criteria) this;
        }

        public Criteria andPriceTaxNotEqualTo(BigDecimal value) {
            addCriterion("price_tax <>", value, "priceTax");
            return (Criteria) this;
        }

        public Criteria andPriceTaxGreaterThan(BigDecimal value) {
            addCriterion("price_tax >", value, "priceTax");
            return (Criteria) this;
        }

        public Criteria andPriceTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_tax >=", value, "priceTax");
            return (Criteria) this;
        }

        public Criteria andPriceTaxLessThan(BigDecimal value) {
            addCriterion("price_tax <", value, "priceTax");
            return (Criteria) this;
        }

        public Criteria andPriceTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_tax <=", value, "priceTax");
            return (Criteria) this;
        }

        public Criteria andPriceTaxIn(List<BigDecimal> values) {
            addCriterion("price_tax in", values, "priceTax");
            return (Criteria) this;
        }

        public Criteria andPriceTaxNotIn(List<BigDecimal> values) {
            addCriterion("price_tax not in", values, "priceTax");
            return (Criteria) this;
        }

        public Criteria andPriceTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_tax between", value1, value2, "priceTax");
            return (Criteria) this;
        }

        public Criteria andPriceTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_tax not between", value1, value2, "priceTax");
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

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(Integer value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(Integer value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(Integer value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(Integer value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(Integer value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<Integer> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<Integer> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(Integer value1, Integer value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(Integer value1, Integer value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(Integer value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(Integer value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(Integer value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(Integer value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(Integer value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<Integer> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<Integer> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(Integer value1, Integer value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(Integer value1, Integer value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
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