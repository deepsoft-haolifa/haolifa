package com.deepsoft.haolifa.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PriceProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PriceProductExample() {
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

        public Criteria andProductNoIsNull() {
            addCriterion("product_no is null");
            return (Criteria) this;
        }

        public Criteria andProductNoIsNotNull() {
            addCriterion("product_no is not null");
            return (Criteria) this;
        }

        public Criteria andProductNoEqualTo(String value) {
            addCriterion("product_no =", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoNotEqualTo(String value) {
            addCriterion("product_no <>", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoGreaterThan(String value) {
            addCriterion("product_no >", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoGreaterThanOrEqualTo(String value) {
            addCriterion("product_no >=", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoLessThan(String value) {
            addCriterion("product_no <", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoLessThanOrEqualTo(String value) {
            addCriterion("product_no <=", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoLike(String value) {
            addCriterion("product_no like", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoNotLike(String value) {
            addCriterion("product_no not like", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoIn(List<String> values) {
            addCriterion("product_no in", values, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoNotIn(List<String> values) {
            addCriterion("product_no not in", values, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoBetween(String value1, String value2) {
            addCriterion("product_no between", value1, value2, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoNotBetween(String value1, String value2) {
            addCriterion("product_no not between", value1, value2, "productNo");
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

        public Criteria andConnectionModeIsNull() {
            addCriterion("connection_mode is null");
            return (Criteria) this;
        }

        public Criteria andConnectionModeIsNotNull() {
            addCriterion("connection_mode is not null");
            return (Criteria) this;
        }

        public Criteria andConnectionModeEqualTo(String value) {
            addCriterion("connection_mode =", value, "connectionMode");
            return (Criteria) this;
        }

        public Criteria andConnectionModeNotEqualTo(String value) {
            addCriterion("connection_mode <>", value, "connectionMode");
            return (Criteria) this;
        }

        public Criteria andConnectionModeGreaterThan(String value) {
            addCriterion("connection_mode >", value, "connectionMode");
            return (Criteria) this;
        }

        public Criteria andConnectionModeGreaterThanOrEqualTo(String value) {
            addCriterion("connection_mode >=", value, "connectionMode");
            return (Criteria) this;
        }

        public Criteria andConnectionModeLessThan(String value) {
            addCriterion("connection_mode <", value, "connectionMode");
            return (Criteria) this;
        }

        public Criteria andConnectionModeLessThanOrEqualTo(String value) {
            addCriterion("connection_mode <=", value, "connectionMode");
            return (Criteria) this;
        }

        public Criteria andConnectionModeLike(String value) {
            addCriterion("connection_mode like", value, "connectionMode");
            return (Criteria) this;
        }

        public Criteria andConnectionModeNotLike(String value) {
            addCriterion("connection_mode not like", value, "connectionMode");
            return (Criteria) this;
        }

        public Criteria andConnectionModeIn(List<String> values) {
            addCriterion("connection_mode in", values, "connectionMode");
            return (Criteria) this;
        }

        public Criteria andConnectionModeNotIn(List<String> values) {
            addCriterion("connection_mode not in", values, "connectionMode");
            return (Criteria) this;
        }

        public Criteria andConnectionModeBetween(String value1, String value2) {
            addCriterion("connection_mode between", value1, value2, "connectionMode");
            return (Criteria) this;
        }

        public Criteria andConnectionModeNotBetween(String value1, String value2) {
            addCriterion("connection_mode not between", value1, value2, "connectionMode");
            return (Criteria) this;
        }

        public Criteria andStructuralStyleIsNull() {
            addCriterion("structural_style is null");
            return (Criteria) this;
        }

        public Criteria andStructuralStyleIsNotNull() {
            addCriterion("structural_style is not null");
            return (Criteria) this;
        }

        public Criteria andStructuralStyleEqualTo(String value) {
            addCriterion("structural_style =", value, "structuralStyle");
            return (Criteria) this;
        }

        public Criteria andStructuralStyleNotEqualTo(String value) {
            addCriterion("structural_style <>", value, "structuralStyle");
            return (Criteria) this;
        }

        public Criteria andStructuralStyleGreaterThan(String value) {
            addCriterion("structural_style >", value, "structuralStyle");
            return (Criteria) this;
        }

        public Criteria andStructuralStyleGreaterThanOrEqualTo(String value) {
            addCriterion("structural_style >=", value, "structuralStyle");
            return (Criteria) this;
        }

        public Criteria andStructuralStyleLessThan(String value) {
            addCriterion("structural_style <", value, "structuralStyle");
            return (Criteria) this;
        }

        public Criteria andStructuralStyleLessThanOrEqualTo(String value) {
            addCriterion("structural_style <=", value, "structuralStyle");
            return (Criteria) this;
        }

        public Criteria andStructuralStyleLike(String value) {
            addCriterion("structural_style like", value, "structuralStyle");
            return (Criteria) this;
        }

        public Criteria andStructuralStyleNotLike(String value) {
            addCriterion("structural_style not like", value, "structuralStyle");
            return (Criteria) this;
        }

        public Criteria andStructuralStyleIn(List<String> values) {
            addCriterion("structural_style in", values, "structuralStyle");
            return (Criteria) this;
        }

        public Criteria andStructuralStyleNotIn(List<String> values) {
            addCriterion("structural_style not in", values, "structuralStyle");
            return (Criteria) this;
        }

        public Criteria andStructuralStyleBetween(String value1, String value2) {
            addCriterion("structural_style between", value1, value2, "structuralStyle");
            return (Criteria) this;
        }

        public Criteria andStructuralStyleNotBetween(String value1, String value2) {
            addCriterion("structural_style not between", value1, value2, "structuralStyle");
            return (Criteria) this;
        }

        public Criteria andNominalPressureIsNull() {
            addCriterion("nominal_pressure is null");
            return (Criteria) this;
        }

        public Criteria andNominalPressureIsNotNull() {
            addCriterion("nominal_pressure is not null");
            return (Criteria) this;
        }

        public Criteria andNominalPressureEqualTo(String value) {
            addCriterion("nominal_pressure =", value, "nominalPressure");
            return (Criteria) this;
        }

        public Criteria andNominalPressureNotEqualTo(String value) {
            addCriterion("nominal_pressure <>", value, "nominalPressure");
            return (Criteria) this;
        }

        public Criteria andNominalPressureGreaterThan(String value) {
            addCriterion("nominal_pressure >", value, "nominalPressure");
            return (Criteria) this;
        }

        public Criteria andNominalPressureGreaterThanOrEqualTo(String value) {
            addCriterion("nominal_pressure >=", value, "nominalPressure");
            return (Criteria) this;
        }

        public Criteria andNominalPressureLessThan(String value) {
            addCriterion("nominal_pressure <", value, "nominalPressure");
            return (Criteria) this;
        }

        public Criteria andNominalPressureLessThanOrEqualTo(String value) {
            addCriterion("nominal_pressure <=", value, "nominalPressure");
            return (Criteria) this;
        }

        public Criteria andNominalPressureLike(String value) {
            addCriterion("nominal_pressure like", value, "nominalPressure");
            return (Criteria) this;
        }

        public Criteria andNominalPressureNotLike(String value) {
            addCriterion("nominal_pressure not like", value, "nominalPressure");
            return (Criteria) this;
        }

        public Criteria andNominalPressureIn(List<String> values) {
            addCriterion("nominal_pressure in", values, "nominalPressure");
            return (Criteria) this;
        }

        public Criteria andNominalPressureNotIn(List<String> values) {
            addCriterion("nominal_pressure not in", values, "nominalPressure");
            return (Criteria) this;
        }

        public Criteria andNominalPressureBetween(String value1, String value2) {
            addCriterion("nominal_pressure between", value1, value2, "nominalPressure");
            return (Criteria) this;
        }

        public Criteria andNominalPressureNotBetween(String value1, String value2) {
            addCriterion("nominal_pressure not between", value1, value2, "nominalPressure");
            return (Criteria) this;
        }

        public Criteria andFatiMaterialIsNull() {
            addCriterion("fati_material is null");
            return (Criteria) this;
        }

        public Criteria andFatiMaterialIsNotNull() {
            addCriterion("fati_material is not null");
            return (Criteria) this;
        }

        public Criteria andFatiMaterialEqualTo(String value) {
            addCriterion("fati_material =", value, "fatiMaterial");
            return (Criteria) this;
        }

        public Criteria andFatiMaterialNotEqualTo(String value) {
            addCriterion("fati_material <>", value, "fatiMaterial");
            return (Criteria) this;
        }

        public Criteria andFatiMaterialGreaterThan(String value) {
            addCriterion("fati_material >", value, "fatiMaterial");
            return (Criteria) this;
        }

        public Criteria andFatiMaterialGreaterThanOrEqualTo(String value) {
            addCriterion("fati_material >=", value, "fatiMaterial");
            return (Criteria) this;
        }

        public Criteria andFatiMaterialLessThan(String value) {
            addCriterion("fati_material <", value, "fatiMaterial");
            return (Criteria) this;
        }

        public Criteria andFatiMaterialLessThanOrEqualTo(String value) {
            addCriterion("fati_material <=", value, "fatiMaterial");
            return (Criteria) this;
        }

        public Criteria andFatiMaterialLike(String value) {
            addCriterion("fati_material like", value, "fatiMaterial");
            return (Criteria) this;
        }

        public Criteria andFatiMaterialNotLike(String value) {
            addCriterion("fati_material not like", value, "fatiMaterial");
            return (Criteria) this;
        }

        public Criteria andFatiMaterialIn(List<String> values) {
            addCriterion("fati_material in", values, "fatiMaterial");
            return (Criteria) this;
        }

        public Criteria andFatiMaterialNotIn(List<String> values) {
            addCriterion("fati_material not in", values, "fatiMaterial");
            return (Criteria) this;
        }

        public Criteria andFatiMaterialBetween(String value1, String value2) {
            addCriterion("fati_material between", value1, value2, "fatiMaterial");
            return (Criteria) this;
        }

        public Criteria andFatiMaterialNotBetween(String value1, String value2) {
            addCriterion("fati_material not between", value1, value2, "fatiMaterial");
            return (Criteria) this;
        }

        public Criteria andFabanMaterialIsNull() {
            addCriterion("faban_material is null");
            return (Criteria) this;
        }

        public Criteria andFabanMaterialIsNotNull() {
            addCriterion("faban_material is not null");
            return (Criteria) this;
        }

        public Criteria andFabanMaterialEqualTo(String value) {
            addCriterion("faban_material =", value, "fabanMaterial");
            return (Criteria) this;
        }

        public Criteria andFabanMaterialNotEqualTo(String value) {
            addCriterion("faban_material <>", value, "fabanMaterial");
            return (Criteria) this;
        }

        public Criteria andFabanMaterialGreaterThan(String value) {
            addCriterion("faban_material >", value, "fabanMaterial");
            return (Criteria) this;
        }

        public Criteria andFabanMaterialGreaterThanOrEqualTo(String value) {
            addCriterion("faban_material >=", value, "fabanMaterial");
            return (Criteria) this;
        }

        public Criteria andFabanMaterialLessThan(String value) {
            addCriterion("faban_material <", value, "fabanMaterial");
            return (Criteria) this;
        }

        public Criteria andFabanMaterialLessThanOrEqualTo(String value) {
            addCriterion("faban_material <=", value, "fabanMaterial");
            return (Criteria) this;
        }

        public Criteria andFabanMaterialLike(String value) {
            addCriterion("faban_material like", value, "fabanMaterial");
            return (Criteria) this;
        }

        public Criteria andFabanMaterialNotLike(String value) {
            addCriterion("faban_material not like", value, "fabanMaterial");
            return (Criteria) this;
        }

        public Criteria andFabanMaterialIn(List<String> values) {
            addCriterion("faban_material in", values, "fabanMaterial");
            return (Criteria) this;
        }

        public Criteria andFabanMaterialNotIn(List<String> values) {
            addCriterion("faban_material not in", values, "fabanMaterial");
            return (Criteria) this;
        }

        public Criteria andFabanMaterialBetween(String value1, String value2) {
            addCriterion("faban_material between", value1, value2, "fabanMaterial");
            return (Criteria) this;
        }

        public Criteria andFabanMaterialNotBetween(String value1, String value2) {
            addCriterion("faban_material not between", value1, value2, "fabanMaterial");
            return (Criteria) this;
        }

        public Criteria andSealFormIsNull() {
            addCriterion("seal_form is null");
            return (Criteria) this;
        }

        public Criteria andSealFormIsNotNull() {
            addCriterion("seal_form is not null");
            return (Criteria) this;
        }

        public Criteria andSealFormEqualTo(String value) {
            addCriterion("seal_form =", value, "sealForm");
            return (Criteria) this;
        }

        public Criteria andSealFormNotEqualTo(String value) {
            addCriterion("seal_form <>", value, "sealForm");
            return (Criteria) this;
        }

        public Criteria andSealFormGreaterThan(String value) {
            addCriterion("seal_form >", value, "sealForm");
            return (Criteria) this;
        }

        public Criteria andSealFormGreaterThanOrEqualTo(String value) {
            addCriterion("seal_form >=", value, "sealForm");
            return (Criteria) this;
        }

        public Criteria andSealFormLessThan(String value) {
            addCriterion("seal_form <", value, "sealForm");
            return (Criteria) this;
        }

        public Criteria andSealFormLessThanOrEqualTo(String value) {
            addCriterion("seal_form <=", value, "sealForm");
            return (Criteria) this;
        }

        public Criteria andSealFormLike(String value) {
            addCriterion("seal_form like", value, "sealForm");
            return (Criteria) this;
        }

        public Criteria andSealFormNotLike(String value) {
            addCriterion("seal_form not like", value, "sealForm");
            return (Criteria) this;
        }

        public Criteria andSealFormIn(List<String> values) {
            addCriterion("seal_form in", values, "sealForm");
            return (Criteria) this;
        }

        public Criteria andSealFormNotIn(List<String> values) {
            addCriterion("seal_form not in", values, "sealForm");
            return (Criteria) this;
        }

        public Criteria andSealFormBetween(String value1, String value2) {
            addCriterion("seal_form between", value1, value2, "sealForm");
            return (Criteria) this;
        }

        public Criteria andSealFormNotBetween(String value1, String value2) {
            addCriterion("seal_form not between", value1, value2, "sealForm");
            return (Criteria) this;
        }

        public Criteria andFazhouMaterialIsNull() {
            addCriterion("fazhou_material is null");
            return (Criteria) this;
        }

        public Criteria andFazhouMaterialIsNotNull() {
            addCriterion("fazhou_material is not null");
            return (Criteria) this;
        }

        public Criteria andFazhouMaterialEqualTo(String value) {
            addCriterion("fazhou_material =", value, "fazhouMaterial");
            return (Criteria) this;
        }

        public Criteria andFazhouMaterialNotEqualTo(String value) {
            addCriterion("fazhou_material <>", value, "fazhouMaterial");
            return (Criteria) this;
        }

        public Criteria andFazhouMaterialGreaterThan(String value) {
            addCriterion("fazhou_material >", value, "fazhouMaterial");
            return (Criteria) this;
        }

        public Criteria andFazhouMaterialGreaterThanOrEqualTo(String value) {
            addCriterion("fazhou_material >=", value, "fazhouMaterial");
            return (Criteria) this;
        }

        public Criteria andFazhouMaterialLessThan(String value) {
            addCriterion("fazhou_material <", value, "fazhouMaterial");
            return (Criteria) this;
        }

        public Criteria andFazhouMaterialLessThanOrEqualTo(String value) {
            addCriterion("fazhou_material <=", value, "fazhouMaterial");
            return (Criteria) this;
        }

        public Criteria andFazhouMaterialLike(String value) {
            addCriterion("fazhou_material like", value, "fazhouMaterial");
            return (Criteria) this;
        }

        public Criteria andFazhouMaterialNotLike(String value) {
            addCriterion("fazhou_material not like", value, "fazhouMaterial");
            return (Criteria) this;
        }

        public Criteria andFazhouMaterialIn(List<String> values) {
            addCriterion("fazhou_material in", values, "fazhouMaterial");
            return (Criteria) this;
        }

        public Criteria andFazhouMaterialNotIn(List<String> values) {
            addCriterion("fazhou_material not in", values, "fazhouMaterial");
            return (Criteria) this;
        }

        public Criteria andFazhouMaterialBetween(String value1, String value2) {
            addCriterion("fazhou_material between", value1, value2, "fazhouMaterial");
            return (Criteria) this;
        }

        public Criteria andFazhouMaterialNotBetween(String value1, String value2) {
            addCriterion("fazhou_material not between", value1, value2, "fazhouMaterial");
            return (Criteria) this;
        }

        public Criteria andAccessoriesIsNull() {
            addCriterion("accessories is null");
            return (Criteria) this;
        }

        public Criteria andAccessoriesIsNotNull() {
            addCriterion("accessories is not null");
            return (Criteria) this;
        }

        public Criteria andAccessoriesEqualTo(String value) {
            addCriterion("accessories =", value, "accessories");
            return (Criteria) this;
        }

        public Criteria andAccessoriesNotEqualTo(String value) {
            addCriterion("accessories <>", value, "accessories");
            return (Criteria) this;
        }

        public Criteria andAccessoriesGreaterThan(String value) {
            addCriterion("accessories >", value, "accessories");
            return (Criteria) this;
        }

        public Criteria andAccessoriesGreaterThanOrEqualTo(String value) {
            addCriterion("accessories >=", value, "accessories");
            return (Criteria) this;
        }

        public Criteria andAccessoriesLessThan(String value) {
            addCriterion("accessories <", value, "accessories");
            return (Criteria) this;
        }

        public Criteria andAccessoriesLessThanOrEqualTo(String value) {
            addCriterion("accessories <=", value, "accessories");
            return (Criteria) this;
        }

        public Criteria andAccessoriesLike(String value) {
            addCriterion("accessories like", value, "accessories");
            return (Criteria) this;
        }

        public Criteria andAccessoriesNotLike(String value) {
            addCriterion("accessories not like", value, "accessories");
            return (Criteria) this;
        }

        public Criteria andAccessoriesIn(List<String> values) {
            addCriterion("accessories in", values, "accessories");
            return (Criteria) this;
        }

        public Criteria andAccessoriesNotIn(List<String> values) {
            addCriterion("accessories not in", values, "accessories");
            return (Criteria) this;
        }

        public Criteria andAccessoriesBetween(String value1, String value2) {
            addCriterion("accessories between", value1, value2, "accessories");
            return (Criteria) this;
        }

        public Criteria andAccessoriesNotBetween(String value1, String value2) {
            addCriterion("accessories not between", value1, value2, "accessories");
            return (Criteria) this;
        }

        public Criteria andDriveIsNull() {
            addCriterion("drive is null");
            return (Criteria) this;
        }

        public Criteria andDriveIsNotNull() {
            addCriterion("drive is not null");
            return (Criteria) this;
        }

        public Criteria andDriveEqualTo(String value) {
            addCriterion("drive =", value, "drive");
            return (Criteria) this;
        }

        public Criteria andDriveNotEqualTo(String value) {
            addCriterion("drive <>", value, "drive");
            return (Criteria) this;
        }

        public Criteria andDriveGreaterThan(String value) {
            addCriterion("drive >", value, "drive");
            return (Criteria) this;
        }

        public Criteria andDriveGreaterThanOrEqualTo(String value) {
            addCriterion("drive >=", value, "drive");
            return (Criteria) this;
        }

        public Criteria andDriveLessThan(String value) {
            addCriterion("drive <", value, "drive");
            return (Criteria) this;
        }

        public Criteria andDriveLessThanOrEqualTo(String value) {
            addCriterion("drive <=", value, "drive");
            return (Criteria) this;
        }

        public Criteria andDriveLike(String value) {
            addCriterion("drive like", value, "drive");
            return (Criteria) this;
        }

        public Criteria andDriveNotLike(String value) {
            addCriterion("drive not like", value, "drive");
            return (Criteria) this;
        }

        public Criteria andDriveIn(List<String> values) {
            addCriterion("drive in", values, "drive");
            return (Criteria) this;
        }

        public Criteria andDriveNotIn(List<String> values) {
            addCriterion("drive not in", values, "drive");
            return (Criteria) this;
        }

        public Criteria andDriveBetween(String value1, String value2) {
            addCriterion("drive between", value1, value2, "drive");
            return (Criteria) this;
        }

        public Criteria andDriveNotBetween(String value1, String value2) {
            addCriterion("drive not between", value1, value2, "drive");
            return (Criteria) this;
        }

        public Criteria andHaoliModelIsNull() {
            addCriterion("haoli_model is null");
            return (Criteria) this;
        }

        public Criteria andHaoliModelIsNotNull() {
            addCriterion("haoli_model is not null");
            return (Criteria) this;
        }

        public Criteria andHaoliModelEqualTo(String value) {
            addCriterion("haoli_model =", value, "haoliModel");
            return (Criteria) this;
        }

        public Criteria andHaoliModelNotEqualTo(String value) {
            addCriterion("haoli_model <>", value, "haoliModel");
            return (Criteria) this;
        }

        public Criteria andHaoliModelGreaterThan(String value) {
            addCriterion("haoli_model >", value, "haoliModel");
            return (Criteria) this;
        }

        public Criteria andHaoliModelGreaterThanOrEqualTo(String value) {
            addCriterion("haoli_model >=", value, "haoliModel");
            return (Criteria) this;
        }

        public Criteria andHaoliModelLessThan(String value) {
            addCriterion("haoli_model <", value, "haoliModel");
            return (Criteria) this;
        }

        public Criteria andHaoliModelLessThanOrEqualTo(String value) {
            addCriterion("haoli_model <=", value, "haoliModel");
            return (Criteria) this;
        }

        public Criteria andHaoliModelLike(String value) {
            addCriterion("haoli_model like", value, "haoliModel");
            return (Criteria) this;
        }

        public Criteria andHaoliModelNotLike(String value) {
            addCriterion("haoli_model not like", value, "haoliModel");
            return (Criteria) this;
        }

        public Criteria andHaoliModelIn(List<String> values) {
            addCriterion("haoli_model in", values, "haoliModel");
            return (Criteria) this;
        }

        public Criteria andHaoliModelNotIn(List<String> values) {
            addCriterion("haoli_model not in", values, "haoliModel");
            return (Criteria) this;
        }

        public Criteria andHaoliModelBetween(String value1, String value2) {
            addCriterion("haoli_model between", value1, value2, "haoliModel");
            return (Criteria) this;
        }

        public Criteria andHaoliModelNotBetween(String value1, String value2) {
            addCriterion("haoli_model not between", value1, value2, "haoliModel");
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

        public Criteria andProductPriceIsNull() {
            addCriterion("product_price is null");
            return (Criteria) this;
        }

        public Criteria andProductPriceIsNotNull() {
            addCriterion("product_price is not null");
            return (Criteria) this;
        }

        public Criteria andProductPriceEqualTo(String value) {
            addCriterion("product_price =", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotEqualTo(String value) {
            addCriterion("product_price <>", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceGreaterThan(String value) {
            addCriterion("product_price >", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceGreaterThanOrEqualTo(String value) {
            addCriterion("product_price >=", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceLessThan(String value) {
            addCriterion("product_price <", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceLessThanOrEqualTo(String value) {
            addCriterion("product_price <=", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceLike(String value) {
            addCriterion("product_price like", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotLike(String value) {
            addCriterion("product_price not like", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceIn(List<String> values) {
            addCriterion("product_price in", values, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotIn(List<String> values) {
            addCriterion("product_price not in", values, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceBetween(String value1, String value2) {
            addCriterion("product_price between", value1, value2, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotBetween(String value1, String value2) {
            addCriterion("product_price not between", value1, value2, "productPrice");
            return (Criteria) this;
        }

        public Criteria andPriceBookIsNull() {
            addCriterion("price_book is null");
            return (Criteria) this;
        }

        public Criteria andPriceBookIsNotNull() {
            addCriterion("price_book is not null");
            return (Criteria) this;
        }

        public Criteria andPriceBookEqualTo(String value) {
            addCriterion("price_book =", value, "priceBook");
            return (Criteria) this;
        }

        public Criteria andPriceBookNotEqualTo(String value) {
            addCriterion("price_book <>", value, "priceBook");
            return (Criteria) this;
        }

        public Criteria andPriceBookGreaterThan(String value) {
            addCriterion("price_book >", value, "priceBook");
            return (Criteria) this;
        }

        public Criteria andPriceBookGreaterThanOrEqualTo(String value) {
            addCriterion("price_book >=", value, "priceBook");
            return (Criteria) this;
        }

        public Criteria andPriceBookLessThan(String value) {
            addCriterion("price_book <", value, "priceBook");
            return (Criteria) this;
        }

        public Criteria andPriceBookLessThanOrEqualTo(String value) {
            addCriterion("price_book <=", value, "priceBook");
            return (Criteria) this;
        }

        public Criteria andPriceBookLike(String value) {
            addCriterion("price_book like", value, "priceBook");
            return (Criteria) this;
        }

        public Criteria andPriceBookNotLike(String value) {
            addCriterion("price_book not like", value, "priceBook");
            return (Criteria) this;
        }

        public Criteria andPriceBookIn(List<String> values) {
            addCriterion("price_book in", values, "priceBook");
            return (Criteria) this;
        }

        public Criteria andPriceBookNotIn(List<String> values) {
            addCriterion("price_book not in", values, "priceBook");
            return (Criteria) this;
        }

        public Criteria andPriceBookBetween(String value1, String value2) {
            addCriterion("price_book between", value1, value2, "priceBook");
            return (Criteria) this;
        }

        public Criteria andPriceBookNotBetween(String value1, String value2) {
            addCriterion("price_book not between", value1, value2, "priceBook");
            return (Criteria) this;
        }

        public Criteria andFatiPriceIsNull() {
            addCriterion("fati_price is null");
            return (Criteria) this;
        }

        public Criteria andFatiPriceIsNotNull() {
            addCriterion("fati_price is not null");
            return (Criteria) this;
        }

        public Criteria andFatiPriceEqualTo(String value) {
            addCriterion("fati_price =", value, "fatiPrice");
            return (Criteria) this;
        }

        public Criteria andFatiPriceNotEqualTo(String value) {
            addCriterion("fati_price <>", value, "fatiPrice");
            return (Criteria) this;
        }

        public Criteria andFatiPriceGreaterThan(String value) {
            addCriterion("fati_price >", value, "fatiPrice");
            return (Criteria) this;
        }

        public Criteria andFatiPriceGreaterThanOrEqualTo(String value) {
            addCriterion("fati_price >=", value, "fatiPrice");
            return (Criteria) this;
        }

        public Criteria andFatiPriceLessThan(String value) {
            addCriterion("fati_price <", value, "fatiPrice");
            return (Criteria) this;
        }

        public Criteria andFatiPriceLessThanOrEqualTo(String value) {
            addCriterion("fati_price <=", value, "fatiPrice");
            return (Criteria) this;
        }

        public Criteria andFatiPriceLike(String value) {
            addCriterion("fati_price like", value, "fatiPrice");
            return (Criteria) this;
        }

        public Criteria andFatiPriceNotLike(String value) {
            addCriterion("fati_price not like", value, "fatiPrice");
            return (Criteria) this;
        }

        public Criteria andFatiPriceIn(List<String> values) {
            addCriterion("fati_price in", values, "fatiPrice");
            return (Criteria) this;
        }

        public Criteria andFatiPriceNotIn(List<String> values) {
            addCriterion("fati_price not in", values, "fatiPrice");
            return (Criteria) this;
        }

        public Criteria andFatiPriceBetween(String value1, String value2) {
            addCriterion("fati_price between", value1, value2, "fatiPrice");
            return (Criteria) this;
        }

        public Criteria andFatiPriceNotBetween(String value1, String value2) {
            addCriterion("fati_price not between", value1, value2, "fatiPrice");
            return (Criteria) this;
        }

        public Criteria andFabanPriceIsNull() {
            addCriterion("faban_price is null");
            return (Criteria) this;
        }

        public Criteria andFabanPriceIsNotNull() {
            addCriterion("faban_price is not null");
            return (Criteria) this;
        }

        public Criteria andFabanPriceEqualTo(String value) {
            addCriterion("faban_price =", value, "fabanPrice");
            return (Criteria) this;
        }

        public Criteria andFabanPriceNotEqualTo(String value) {
            addCriterion("faban_price <>", value, "fabanPrice");
            return (Criteria) this;
        }

        public Criteria andFabanPriceGreaterThan(String value) {
            addCriterion("faban_price >", value, "fabanPrice");
            return (Criteria) this;
        }

        public Criteria andFabanPriceGreaterThanOrEqualTo(String value) {
            addCriterion("faban_price >=", value, "fabanPrice");
            return (Criteria) this;
        }

        public Criteria andFabanPriceLessThan(String value) {
            addCriterion("faban_price <", value, "fabanPrice");
            return (Criteria) this;
        }

        public Criteria andFabanPriceLessThanOrEqualTo(String value) {
            addCriterion("faban_price <=", value, "fabanPrice");
            return (Criteria) this;
        }

        public Criteria andFabanPriceLike(String value) {
            addCriterion("faban_price like", value, "fabanPrice");
            return (Criteria) this;
        }

        public Criteria andFabanPriceNotLike(String value) {
            addCriterion("faban_price not like", value, "fabanPrice");
            return (Criteria) this;
        }

        public Criteria andFabanPriceIn(List<String> values) {
            addCriterion("faban_price in", values, "fabanPrice");
            return (Criteria) this;
        }

        public Criteria andFabanPriceNotIn(List<String> values) {
            addCriterion("faban_price not in", values, "fabanPrice");
            return (Criteria) this;
        }

        public Criteria andFabanPriceBetween(String value1, String value2) {
            addCriterion("faban_price between", value1, value2, "fabanPrice");
            return (Criteria) this;
        }

        public Criteria andFabanPriceNotBetween(String value1, String value2) {
            addCriterion("faban_price not between", value1, value2, "fabanPrice");
            return (Criteria) this;
        }

        public Criteria andFazuoPriceIsNull() {
            addCriterion("fazuo_price is null");
            return (Criteria) this;
        }

        public Criteria andFazuoPriceIsNotNull() {
            addCriterion("fazuo_price is not null");
            return (Criteria) this;
        }

        public Criteria andFazuoPriceEqualTo(String value) {
            addCriterion("fazuo_price =", value, "fazuoPrice");
            return (Criteria) this;
        }

        public Criteria andFazuoPriceNotEqualTo(String value) {
            addCriterion("fazuo_price <>", value, "fazuoPrice");
            return (Criteria) this;
        }

        public Criteria andFazuoPriceGreaterThan(String value) {
            addCriterion("fazuo_price >", value, "fazuoPrice");
            return (Criteria) this;
        }

        public Criteria andFazuoPriceGreaterThanOrEqualTo(String value) {
            addCriterion("fazuo_price >=", value, "fazuoPrice");
            return (Criteria) this;
        }

        public Criteria andFazuoPriceLessThan(String value) {
            addCriterion("fazuo_price <", value, "fazuoPrice");
            return (Criteria) this;
        }

        public Criteria andFazuoPriceLessThanOrEqualTo(String value) {
            addCriterion("fazuo_price <=", value, "fazuoPrice");
            return (Criteria) this;
        }

        public Criteria andFazuoPriceLike(String value) {
            addCriterion("fazuo_price like", value, "fazuoPrice");
            return (Criteria) this;
        }

        public Criteria andFazuoPriceNotLike(String value) {
            addCriterion("fazuo_price not like", value, "fazuoPrice");
            return (Criteria) this;
        }

        public Criteria andFazuoPriceIn(List<String> values) {
            addCriterion("fazuo_price in", values, "fazuoPrice");
            return (Criteria) this;
        }

        public Criteria andFazuoPriceNotIn(List<String> values) {
            addCriterion("fazuo_price not in", values, "fazuoPrice");
            return (Criteria) this;
        }

        public Criteria andFazuoPriceBetween(String value1, String value2) {
            addCriterion("fazuo_price between", value1, value2, "fazuoPrice");
            return (Criteria) this;
        }

        public Criteria andFazuoPriceNotBetween(String value1, String value2) {
            addCriterion("fazuo_price not between", value1, value2, "fazuoPrice");
            return (Criteria) this;
        }

        public Criteria andFazhouPriceIsNull() {
            addCriterion("fazhou_price is null");
            return (Criteria) this;
        }

        public Criteria andFazhouPriceIsNotNull() {
            addCriterion("fazhou_price is not null");
            return (Criteria) this;
        }

        public Criteria andFazhouPriceEqualTo(String value) {
            addCriterion("fazhou_price =", value, "fazhouPrice");
            return (Criteria) this;
        }

        public Criteria andFazhouPriceNotEqualTo(String value) {
            addCriterion("fazhou_price <>", value, "fazhouPrice");
            return (Criteria) this;
        }

        public Criteria andFazhouPriceGreaterThan(String value) {
            addCriterion("fazhou_price >", value, "fazhouPrice");
            return (Criteria) this;
        }

        public Criteria andFazhouPriceGreaterThanOrEqualTo(String value) {
            addCriterion("fazhou_price >=", value, "fazhouPrice");
            return (Criteria) this;
        }

        public Criteria andFazhouPriceLessThan(String value) {
            addCriterion("fazhou_price <", value, "fazhouPrice");
            return (Criteria) this;
        }

        public Criteria andFazhouPriceLessThanOrEqualTo(String value) {
            addCriterion("fazhou_price <=", value, "fazhouPrice");
            return (Criteria) this;
        }

        public Criteria andFazhouPriceLike(String value) {
            addCriterion("fazhou_price like", value, "fazhouPrice");
            return (Criteria) this;
        }

        public Criteria andFazhouPriceNotLike(String value) {
            addCriterion("fazhou_price not like", value, "fazhouPrice");
            return (Criteria) this;
        }

        public Criteria andFazhouPriceIn(List<String> values) {
            addCriterion("fazhou_price in", values, "fazhouPrice");
            return (Criteria) this;
        }

        public Criteria andFazhouPriceNotIn(List<String> values) {
            addCriterion("fazhou_price not in", values, "fazhouPrice");
            return (Criteria) this;
        }

        public Criteria andFazhouPriceBetween(String value1, String value2) {
            addCriterion("fazhou_price between", value1, value2, "fazhouPrice");
            return (Criteria) this;
        }

        public Criteria andFazhouPriceNotBetween(String value1, String value2) {
            addCriterion("fazhou_price not between", value1, value2, "fazhouPrice");
            return (Criteria) this;
        }

        public Criteria andAccessoriesPriceIsNull() {
            addCriterion("accessories_price is null");
            return (Criteria) this;
        }

        public Criteria andAccessoriesPriceIsNotNull() {
            addCriterion("accessories_price is not null");
            return (Criteria) this;
        }

        public Criteria andAccessoriesPriceEqualTo(String value) {
            addCriterion("accessories_price =", value, "accessoriesPrice");
            return (Criteria) this;
        }

        public Criteria andAccessoriesPriceNotEqualTo(String value) {
            addCriterion("accessories_price <>", value, "accessoriesPrice");
            return (Criteria) this;
        }

        public Criteria andAccessoriesPriceGreaterThan(String value) {
            addCriterion("accessories_price >", value, "accessoriesPrice");
            return (Criteria) this;
        }

        public Criteria andAccessoriesPriceGreaterThanOrEqualTo(String value) {
            addCriterion("accessories_price >=", value, "accessoriesPrice");
            return (Criteria) this;
        }

        public Criteria andAccessoriesPriceLessThan(String value) {
            addCriterion("accessories_price <", value, "accessoriesPrice");
            return (Criteria) this;
        }

        public Criteria andAccessoriesPriceLessThanOrEqualTo(String value) {
            addCriterion("accessories_price <=", value, "accessoriesPrice");
            return (Criteria) this;
        }

        public Criteria andAccessoriesPriceLike(String value) {
            addCriterion("accessories_price like", value, "accessoriesPrice");
            return (Criteria) this;
        }

        public Criteria andAccessoriesPriceNotLike(String value) {
            addCriterion("accessories_price not like", value, "accessoriesPrice");
            return (Criteria) this;
        }

        public Criteria andAccessoriesPriceIn(List<String> values) {
            addCriterion("accessories_price in", values, "accessoriesPrice");
            return (Criteria) this;
        }

        public Criteria andAccessoriesPriceNotIn(List<String> values) {
            addCriterion("accessories_price not in", values, "accessoriesPrice");
            return (Criteria) this;
        }

        public Criteria andAccessoriesPriceBetween(String value1, String value2) {
            addCriterion("accessories_price between", value1, value2, "accessoriesPrice");
            return (Criteria) this;
        }

        public Criteria andAccessoriesPriceNotBetween(String value1, String value2) {
            addCriterion("accessories_price not between", value1, value2, "accessoriesPrice");
            return (Criteria) this;
        }

        public Criteria andDrivePriceIsNull() {
            addCriterion("drive_price is null");
            return (Criteria) this;
        }

        public Criteria andDrivePriceIsNotNull() {
            addCriterion("drive_price is not null");
            return (Criteria) this;
        }

        public Criteria andDrivePriceEqualTo(String value) {
            addCriterion("drive_price =", value, "drivePrice");
            return (Criteria) this;
        }

        public Criteria andDrivePriceNotEqualTo(String value) {
            addCriterion("drive_price <>", value, "drivePrice");
            return (Criteria) this;
        }

        public Criteria andDrivePriceGreaterThan(String value) {
            addCriterion("drive_price >", value, "drivePrice");
            return (Criteria) this;
        }

        public Criteria andDrivePriceGreaterThanOrEqualTo(String value) {
            addCriterion("drive_price >=", value, "drivePrice");
            return (Criteria) this;
        }

        public Criteria andDrivePriceLessThan(String value) {
            addCriterion("drive_price <", value, "drivePrice");
            return (Criteria) this;
        }

        public Criteria andDrivePriceLessThanOrEqualTo(String value) {
            addCriterion("drive_price <=", value, "drivePrice");
            return (Criteria) this;
        }

        public Criteria andDrivePriceLike(String value) {
            addCriterion("drive_price like", value, "drivePrice");
            return (Criteria) this;
        }

        public Criteria andDrivePriceNotLike(String value) {
            addCriterion("drive_price not like", value, "drivePrice");
            return (Criteria) this;
        }

        public Criteria andDrivePriceIn(List<String> values) {
            addCriterion("drive_price in", values, "drivePrice");
            return (Criteria) this;
        }

        public Criteria andDrivePriceNotIn(List<String> values) {
            addCriterion("drive_price not in", values, "drivePrice");
            return (Criteria) this;
        }

        public Criteria andDrivePriceBetween(String value1, String value2) {
            addCriterion("drive_price between", value1, value2, "drivePrice");
            return (Criteria) this;
        }

        public Criteria andDrivePriceNotBetween(String value1, String value2) {
            addCriterion("drive_price not between", value1, value2, "drivePrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(String value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(String value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(String value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(String value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(String value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(String value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLike(String value) {
            addCriterion("total_price like", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotLike(String value) {
            addCriterion("total_price not like", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<String> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<String> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(String value1, String value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(String value1, String value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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