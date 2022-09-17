package com.deepsoft.haolifa.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderTechnicalDetailedRelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderTechnicalDetailedRelExample() {
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

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoIsNull() {
            addCriterion("seq_no is null");
            return (Criteria) this;
        }

        public Criteria andSeqNoIsNotNull() {
            addCriterion("seq_no is not null");
            return (Criteria) this;
        }

        public Criteria andSeqNoEqualTo(String value) {
            addCriterion("seq_no =", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotEqualTo(String value) {
            addCriterion("seq_no <>", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoGreaterThan(String value) {
            addCriterion("seq_no >", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoGreaterThanOrEqualTo(String value) {
            addCriterion("seq_no >=", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoLessThan(String value) {
            addCriterion("seq_no <", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoLessThanOrEqualTo(String value) {
            addCriterion("seq_no <=", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoLike(String value) {
            addCriterion("seq_no like", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotLike(String value) {
            addCriterion("seq_no not like", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoIn(List<String> values) {
            addCriterion("seq_no in", values, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotIn(List<String> values) {
            addCriterion("seq_no not in", values, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoBetween(String value1, String value2) {
            addCriterion("seq_no between", value1, value2, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotBetween(String value1, String value2) {
            addCriterion("seq_no not between", value1, value2, "seqNo");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNumIsNull() {
            addCriterion("product_num is null");
            return (Criteria) this;
        }

        public Criteria andProductNumIsNotNull() {
            addCriterion("product_num is not null");
            return (Criteria) this;
        }

        public Criteria andProductNumEqualTo(Integer value) {
            addCriterion("product_num =", value, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumNotEqualTo(Integer value) {
            addCriterion("product_num <>", value, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumGreaterThan(Integer value) {
            addCriterion("product_num >", value, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_num >=", value, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumLessThan(Integer value) {
            addCriterion("product_num <", value, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumLessThanOrEqualTo(Integer value) {
            addCriterion("product_num <=", value, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumIn(List<Integer> values) {
            addCriterion("product_num in", values, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumNotIn(List<Integer> values) {
            addCriterion("product_num not in", values, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumBetween(Integer value1, Integer value2) {
            addCriterion("product_num between", value1, value2, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumNotBetween(Integer value1, Integer value2) {
            addCriterion("product_num not between", value1, value2, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductModelIsNull() {
            addCriterion("product_model is null");
            return (Criteria) this;
        }

        public Criteria andProductModelIsNotNull() {
            addCriterion("product_model is not null");
            return (Criteria) this;
        }

        public Criteria andProductModelEqualTo(String value) {
            addCriterion("product_model =", value, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelNotEqualTo(String value) {
            addCriterion("product_model <>", value, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelGreaterThan(String value) {
            addCriterion("product_model >", value, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelGreaterThanOrEqualTo(String value) {
            addCriterion("product_model >=", value, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelLessThan(String value) {
            addCriterion("product_model <", value, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelLessThanOrEqualTo(String value) {
            addCriterion("product_model <=", value, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelLike(String value) {
            addCriterion("product_model like", value, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelNotLike(String value) {
            addCriterion("product_model not like", value, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelIn(List<String> values) {
            addCriterion("product_model in", values, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelNotIn(List<String> values) {
            addCriterion("product_model not in", values, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelBetween(String value1, String value2) {
            addCriterion("product_model between", value1, value2, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelNotBetween(String value1, String value2) {
            addCriterion("product_model not between", value1, value2, "productModel");
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

        public Criteria andUpperFlangeStandardIsNull() {
            addCriterion("upper_flange_standard is null");
            return (Criteria) this;
        }

        public Criteria andUpperFlangeStandardIsNotNull() {
            addCriterion("upper_flange_standard is not null");
            return (Criteria) this;
        }

        public Criteria andUpperFlangeStandardEqualTo(String value) {
            addCriterion("upper_flange_standard =", value, "upperFlangeStandard");
            return (Criteria) this;
        }

        public Criteria andUpperFlangeStandardNotEqualTo(String value) {
            addCriterion("upper_flange_standard <>", value, "upperFlangeStandard");
            return (Criteria) this;
        }

        public Criteria andUpperFlangeStandardGreaterThan(String value) {
            addCriterion("upper_flange_standard >", value, "upperFlangeStandard");
            return (Criteria) this;
        }

        public Criteria andUpperFlangeStandardGreaterThanOrEqualTo(String value) {
            addCriterion("upper_flange_standard >=", value, "upperFlangeStandard");
            return (Criteria) this;
        }

        public Criteria andUpperFlangeStandardLessThan(String value) {
            addCriterion("upper_flange_standard <", value, "upperFlangeStandard");
            return (Criteria) this;
        }

        public Criteria andUpperFlangeStandardLessThanOrEqualTo(String value) {
            addCriterion("upper_flange_standard <=", value, "upperFlangeStandard");
            return (Criteria) this;
        }

        public Criteria andUpperFlangeStandardLike(String value) {
            addCriterion("upper_flange_standard like", value, "upperFlangeStandard");
            return (Criteria) this;
        }

        public Criteria andUpperFlangeStandardNotLike(String value) {
            addCriterion("upper_flange_standard not like", value, "upperFlangeStandard");
            return (Criteria) this;
        }

        public Criteria andUpperFlangeStandardIn(List<String> values) {
            addCriterion("upper_flange_standard in", values, "upperFlangeStandard");
            return (Criteria) this;
        }

        public Criteria andUpperFlangeStandardNotIn(List<String> values) {
            addCriterion("upper_flange_standard not in", values, "upperFlangeStandard");
            return (Criteria) this;
        }

        public Criteria andUpperFlangeStandardBetween(String value1, String value2) {
            addCriterion("upper_flange_standard between", value1, value2, "upperFlangeStandard");
            return (Criteria) this;
        }

        public Criteria andUpperFlangeStandardNotBetween(String value1, String value2) {
            addCriterion("upper_flange_standard not between", value1, value2, "upperFlangeStandard");
            return (Criteria) this;
        }

        public Criteria andConnectingHoleIsNull() {
            addCriterion("connecting_hole is null");
            return (Criteria) this;
        }

        public Criteria andConnectingHoleIsNotNull() {
            addCriterion("connecting_hole is not null");
            return (Criteria) this;
        }

        public Criteria andConnectingHoleEqualTo(String value) {
            addCriterion("connecting_hole =", value, "connectingHole");
            return (Criteria) this;
        }

        public Criteria andConnectingHoleNotEqualTo(String value) {
            addCriterion("connecting_hole <>", value, "connectingHole");
            return (Criteria) this;
        }

        public Criteria andConnectingHoleGreaterThan(String value) {
            addCriterion("connecting_hole >", value, "connectingHole");
            return (Criteria) this;
        }

        public Criteria andConnectingHoleGreaterThanOrEqualTo(String value) {
            addCriterion("connecting_hole >=", value, "connectingHole");
            return (Criteria) this;
        }

        public Criteria andConnectingHoleLessThan(String value) {
            addCriterion("connecting_hole <", value, "connectingHole");
            return (Criteria) this;
        }

        public Criteria andConnectingHoleLessThanOrEqualTo(String value) {
            addCriterion("connecting_hole <=", value, "connectingHole");
            return (Criteria) this;
        }

        public Criteria andConnectingHoleLike(String value) {
            addCriterion("connecting_hole like", value, "connectingHole");
            return (Criteria) this;
        }

        public Criteria andConnectingHoleNotLike(String value) {
            addCriterion("connecting_hole not like", value, "connectingHole");
            return (Criteria) this;
        }

        public Criteria andConnectingHoleIn(List<String> values) {
            addCriterion("connecting_hole in", values, "connectingHole");
            return (Criteria) this;
        }

        public Criteria andConnectingHoleNotIn(List<String> values) {
            addCriterion("connecting_hole not in", values, "connectingHole");
            return (Criteria) this;
        }

        public Criteria andConnectingHoleBetween(String value1, String value2) {
            addCriterion("connecting_hole between", value1, value2, "connectingHole");
            return (Criteria) this;
        }

        public Criteria andConnectingHoleNotBetween(String value1, String value2) {
            addCriterion("connecting_hole not between", value1, value2, "connectingHole");
            return (Criteria) this;
        }

        public Criteria andAngleIsNull() {
            addCriterion("angle is null");
            return (Criteria) this;
        }

        public Criteria andAngleIsNotNull() {
            addCriterion("angle is not null");
            return (Criteria) this;
        }

        public Criteria andAngleEqualTo(String value) {
            addCriterion("angle =", value, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleNotEqualTo(String value) {
            addCriterion("angle <>", value, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleGreaterThan(String value) {
            addCriterion("angle >", value, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleGreaterThanOrEqualTo(String value) {
            addCriterion("angle >=", value, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleLessThan(String value) {
            addCriterion("angle <", value, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleLessThanOrEqualTo(String value) {
            addCriterion("angle <=", value, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleLike(String value) {
            addCriterion("angle like", value, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleNotLike(String value) {
            addCriterion("angle not like", value, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleIn(List<String> values) {
            addCriterion("angle in", values, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleNotIn(List<String> values) {
            addCriterion("angle not in", values, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleBetween(String value1, String value2) {
            addCriterion("angle between", value1, value2, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleNotBetween(String value1, String value2) {
            addCriterion("angle not between", value1, value2, "angle");
            return (Criteria) this;
        }

        public Criteria andCenterDistanceIsNull() {
            addCriterion("center_distance is null");
            return (Criteria) this;
        }

        public Criteria andCenterDistanceIsNotNull() {
            addCriterion("center_distance is not null");
            return (Criteria) this;
        }

        public Criteria andCenterDistanceEqualTo(String value) {
            addCriterion("center_distance =", value, "centerDistance");
            return (Criteria) this;
        }

        public Criteria andCenterDistanceNotEqualTo(String value) {
            addCriterion("center_distance <>", value, "centerDistance");
            return (Criteria) this;
        }

        public Criteria andCenterDistanceGreaterThan(String value) {
            addCriterion("center_distance >", value, "centerDistance");
            return (Criteria) this;
        }

        public Criteria andCenterDistanceGreaterThanOrEqualTo(String value) {
            addCriterion("center_distance >=", value, "centerDistance");
            return (Criteria) this;
        }

        public Criteria andCenterDistanceLessThan(String value) {
            addCriterion("center_distance <", value, "centerDistance");
            return (Criteria) this;
        }

        public Criteria andCenterDistanceLessThanOrEqualTo(String value) {
            addCriterion("center_distance <=", value, "centerDistance");
            return (Criteria) this;
        }

        public Criteria andCenterDistanceLike(String value) {
            addCriterion("center_distance like", value, "centerDistance");
            return (Criteria) this;
        }

        public Criteria andCenterDistanceNotLike(String value) {
            addCriterion("center_distance not like", value, "centerDistance");
            return (Criteria) this;
        }

        public Criteria andCenterDistanceIn(List<String> values) {
            addCriterion("center_distance in", values, "centerDistance");
            return (Criteria) this;
        }

        public Criteria andCenterDistanceNotIn(List<String> values) {
            addCriterion("center_distance not in", values, "centerDistance");
            return (Criteria) this;
        }

        public Criteria andCenterDistanceBetween(String value1, String value2) {
            addCriterion("center_distance between", value1, value2, "centerDistance");
            return (Criteria) this;
        }

        public Criteria andCenterDistanceNotBetween(String value1, String value2) {
            addCriterion("center_distance not between", value1, value2, "centerDistance");
            return (Criteria) this;
        }

        public Criteria andOutputShaftTypeIsNull() {
            addCriterion("output_shaft_type is null");
            return (Criteria) this;
        }

        public Criteria andOutputShaftTypeIsNotNull() {
            addCriterion("output_shaft_type is not null");
            return (Criteria) this;
        }

        public Criteria andOutputShaftTypeEqualTo(String value) {
            addCriterion("output_shaft_type =", value, "outputShaftType");
            return (Criteria) this;
        }

        public Criteria andOutputShaftTypeNotEqualTo(String value) {
            addCriterion("output_shaft_type <>", value, "outputShaftType");
            return (Criteria) this;
        }

        public Criteria andOutputShaftTypeGreaterThan(String value) {
            addCriterion("output_shaft_type >", value, "outputShaftType");
            return (Criteria) this;
        }

        public Criteria andOutputShaftTypeGreaterThanOrEqualTo(String value) {
            addCriterion("output_shaft_type >=", value, "outputShaftType");
            return (Criteria) this;
        }

        public Criteria andOutputShaftTypeLessThan(String value) {
            addCriterion("output_shaft_type <", value, "outputShaftType");
            return (Criteria) this;
        }

        public Criteria andOutputShaftTypeLessThanOrEqualTo(String value) {
            addCriterion("output_shaft_type <=", value, "outputShaftType");
            return (Criteria) this;
        }

        public Criteria andOutputShaftTypeLike(String value) {
            addCriterion("output_shaft_type like", value, "outputShaftType");
            return (Criteria) this;
        }

        public Criteria andOutputShaftTypeNotLike(String value) {
            addCriterion("output_shaft_type not like", value, "outputShaftType");
            return (Criteria) this;
        }

        public Criteria andOutputShaftTypeIn(List<String> values) {
            addCriterion("output_shaft_type in", values, "outputShaftType");
            return (Criteria) this;
        }

        public Criteria andOutputShaftTypeNotIn(List<String> values) {
            addCriterion("output_shaft_type not in", values, "outputShaftType");
            return (Criteria) this;
        }

        public Criteria andOutputShaftTypeBetween(String value1, String value2) {
            addCriterion("output_shaft_type between", value1, value2, "outputShaftType");
            return (Criteria) this;
        }

        public Criteria andOutputShaftTypeNotBetween(String value1, String value2) {
            addCriterion("output_shaft_type not between", value1, value2, "outputShaftType");
            return (Criteria) this;
        }

        public Criteria andOutputShaftLengthIsNull() {
            addCriterion("output_shaft_length is null");
            return (Criteria) this;
        }

        public Criteria andOutputShaftLengthIsNotNull() {
            addCriterion("output_shaft_length is not null");
            return (Criteria) this;
        }

        public Criteria andOutputShaftLengthEqualTo(String value) {
            addCriterion("output_shaft_length =", value, "outputShaftLength");
            return (Criteria) this;
        }

        public Criteria andOutputShaftLengthNotEqualTo(String value) {
            addCriterion("output_shaft_length <>", value, "outputShaftLength");
            return (Criteria) this;
        }

        public Criteria andOutputShaftLengthGreaterThan(String value) {
            addCriterion("output_shaft_length >", value, "outputShaftLength");
            return (Criteria) this;
        }

        public Criteria andOutputShaftLengthGreaterThanOrEqualTo(String value) {
            addCriterion("output_shaft_length >=", value, "outputShaftLength");
            return (Criteria) this;
        }

        public Criteria andOutputShaftLengthLessThan(String value) {
            addCriterion("output_shaft_length <", value, "outputShaftLength");
            return (Criteria) this;
        }

        public Criteria andOutputShaftLengthLessThanOrEqualTo(String value) {
            addCriterion("output_shaft_length <=", value, "outputShaftLength");
            return (Criteria) this;
        }

        public Criteria andOutputShaftLengthLike(String value) {
            addCriterion("output_shaft_length like", value, "outputShaftLength");
            return (Criteria) this;
        }

        public Criteria andOutputShaftLengthNotLike(String value) {
            addCriterion("output_shaft_length not like", value, "outputShaftLength");
            return (Criteria) this;
        }

        public Criteria andOutputShaftLengthIn(List<String> values) {
            addCriterion("output_shaft_length in", values, "outputShaftLength");
            return (Criteria) this;
        }

        public Criteria andOutputShaftLengthNotIn(List<String> values) {
            addCriterion("output_shaft_length not in", values, "outputShaftLength");
            return (Criteria) this;
        }

        public Criteria andOutputShaftLengthBetween(String value1, String value2) {
            addCriterion("output_shaft_length between", value1, value2, "outputShaftLength");
            return (Criteria) this;
        }

        public Criteria andOutputShaftLengthNotBetween(String value1, String value2) {
            addCriterion("output_shaft_length not between", value1, value2, "outputShaftLength");
            return (Criteria) this;
        }

        public Criteria andAxisDrawingNoIsNull() {
            addCriterion("axis_drawing_no is null");
            return (Criteria) this;
        }

        public Criteria andAxisDrawingNoIsNotNull() {
            addCriterion("axis_drawing_no is not null");
            return (Criteria) this;
        }

        public Criteria andAxisDrawingNoEqualTo(String value) {
            addCriterion("axis_drawing_no =", value, "axisDrawingNo");
            return (Criteria) this;
        }

        public Criteria andAxisDrawingNoNotEqualTo(String value) {
            addCriterion("axis_drawing_no <>", value, "axisDrawingNo");
            return (Criteria) this;
        }

        public Criteria andAxisDrawingNoGreaterThan(String value) {
            addCriterion("axis_drawing_no >", value, "axisDrawingNo");
            return (Criteria) this;
        }

        public Criteria andAxisDrawingNoGreaterThanOrEqualTo(String value) {
            addCriterion("axis_drawing_no >=", value, "axisDrawingNo");
            return (Criteria) this;
        }

        public Criteria andAxisDrawingNoLessThan(String value) {
            addCriterion("axis_drawing_no <", value, "axisDrawingNo");
            return (Criteria) this;
        }

        public Criteria andAxisDrawingNoLessThanOrEqualTo(String value) {
            addCriterion("axis_drawing_no <=", value, "axisDrawingNo");
            return (Criteria) this;
        }

        public Criteria andAxisDrawingNoLike(String value) {
            addCriterion("axis_drawing_no like", value, "axisDrawingNo");
            return (Criteria) this;
        }

        public Criteria andAxisDrawingNoNotLike(String value) {
            addCriterion("axis_drawing_no not like", value, "axisDrawingNo");
            return (Criteria) this;
        }

        public Criteria andAxisDrawingNoIn(List<String> values) {
            addCriterion("axis_drawing_no in", values, "axisDrawingNo");
            return (Criteria) this;
        }

        public Criteria andAxisDrawingNoNotIn(List<String> values) {
            addCriterion("axis_drawing_no not in", values, "axisDrawingNo");
            return (Criteria) this;
        }

        public Criteria andAxisDrawingNoBetween(String value1, String value2) {
            addCriterion("axis_drawing_no between", value1, value2, "axisDrawingNo");
            return (Criteria) this;
        }

        public Criteria andAxisDrawingNoNotBetween(String value1, String value2) {
            addCriterion("axis_drawing_no not between", value1, value2, "axisDrawingNo");
            return (Criteria) this;
        }

        public Criteria andConnectingSleeveIsNull() {
            addCriterion("connecting_sleeve is null");
            return (Criteria) this;
        }

        public Criteria andConnectingSleeveIsNotNull() {
            addCriterion("connecting_sleeve is not null");
            return (Criteria) this;
        }

        public Criteria andConnectingSleeveEqualTo(String value) {
            addCriterion("connecting_sleeve =", value, "connectingSleeve");
            return (Criteria) this;
        }

        public Criteria andConnectingSleeveNotEqualTo(String value) {
            addCriterion("connecting_sleeve <>", value, "connectingSleeve");
            return (Criteria) this;
        }

        public Criteria andConnectingSleeveGreaterThan(String value) {
            addCriterion("connecting_sleeve >", value, "connectingSleeve");
            return (Criteria) this;
        }

        public Criteria andConnectingSleeveGreaterThanOrEqualTo(String value) {
            addCriterion("connecting_sleeve >=", value, "connectingSleeve");
            return (Criteria) this;
        }

        public Criteria andConnectingSleeveLessThan(String value) {
            addCriterion("connecting_sleeve <", value, "connectingSleeve");
            return (Criteria) this;
        }

        public Criteria andConnectingSleeveLessThanOrEqualTo(String value) {
            addCriterion("connecting_sleeve <=", value, "connectingSleeve");
            return (Criteria) this;
        }

        public Criteria andConnectingSleeveLike(String value) {
            addCriterion("connecting_sleeve like", value, "connectingSleeve");
            return (Criteria) this;
        }

        public Criteria andConnectingSleeveNotLike(String value) {
            addCriterion("connecting_sleeve not like", value, "connectingSleeve");
            return (Criteria) this;
        }

        public Criteria andConnectingSleeveIn(List<String> values) {
            addCriterion("connecting_sleeve in", values, "connectingSleeve");
            return (Criteria) this;
        }

        public Criteria andConnectingSleeveNotIn(List<String> values) {
            addCriterion("connecting_sleeve not in", values, "connectingSleeve");
            return (Criteria) this;
        }

        public Criteria andConnectingSleeveBetween(String value1, String value2) {
            addCriterion("connecting_sleeve between", value1, value2, "connectingSleeve");
            return (Criteria) this;
        }

        public Criteria andConnectingSleeveNotBetween(String value1, String value2) {
            addCriterion("connecting_sleeve not between", value1, value2, "connectingSleeve");
            return (Criteria) this;
        }

        public Criteria andTransitionPlateIsNull() {
            addCriterion("transition_plate is null");
            return (Criteria) this;
        }

        public Criteria andTransitionPlateIsNotNull() {
            addCriterion("transition_plate is not null");
            return (Criteria) this;
        }

        public Criteria andTransitionPlateEqualTo(String value) {
            addCriterion("transition_plate =", value, "transitionPlate");
            return (Criteria) this;
        }

        public Criteria andTransitionPlateNotEqualTo(String value) {
            addCriterion("transition_plate <>", value, "transitionPlate");
            return (Criteria) this;
        }

        public Criteria andTransitionPlateGreaterThan(String value) {
            addCriterion("transition_plate >", value, "transitionPlate");
            return (Criteria) this;
        }

        public Criteria andTransitionPlateGreaterThanOrEqualTo(String value) {
            addCriterion("transition_plate >=", value, "transitionPlate");
            return (Criteria) this;
        }

        public Criteria andTransitionPlateLessThan(String value) {
            addCriterion("transition_plate <", value, "transitionPlate");
            return (Criteria) this;
        }

        public Criteria andTransitionPlateLessThanOrEqualTo(String value) {
            addCriterion("transition_plate <=", value, "transitionPlate");
            return (Criteria) this;
        }

        public Criteria andTransitionPlateLike(String value) {
            addCriterion("transition_plate like", value, "transitionPlate");
            return (Criteria) this;
        }

        public Criteria andTransitionPlateNotLike(String value) {
            addCriterion("transition_plate not like", value, "transitionPlate");
            return (Criteria) this;
        }

        public Criteria andTransitionPlateIn(List<String> values) {
            addCriterion("transition_plate in", values, "transitionPlate");
            return (Criteria) this;
        }

        public Criteria andTransitionPlateNotIn(List<String> values) {
            addCriterion("transition_plate not in", values, "transitionPlate");
            return (Criteria) this;
        }

        public Criteria andTransitionPlateBetween(String value1, String value2) {
            addCriterion("transition_plate between", value1, value2, "transitionPlate");
            return (Criteria) this;
        }

        public Criteria andTransitionPlateNotBetween(String value1, String value2) {
            addCriterion("transition_plate not between", value1, value2, "transitionPlate");
            return (Criteria) this;
        }

        public Criteria andStaticTorqueIsNull() {
            addCriterion("static_torque is null");
            return (Criteria) this;
        }

        public Criteria andStaticTorqueIsNotNull() {
            addCriterion("static_torque is not null");
            return (Criteria) this;
        }

        public Criteria andStaticTorqueEqualTo(String value) {
            addCriterion("static_torque =", value, "staticTorque");
            return (Criteria) this;
        }

        public Criteria andStaticTorqueNotEqualTo(String value) {
            addCriterion("static_torque <>", value, "staticTorque");
            return (Criteria) this;
        }

        public Criteria andStaticTorqueGreaterThan(String value) {
            addCriterion("static_torque >", value, "staticTorque");
            return (Criteria) this;
        }

        public Criteria andStaticTorqueGreaterThanOrEqualTo(String value) {
            addCriterion("static_torque >=", value, "staticTorque");
            return (Criteria) this;
        }

        public Criteria andStaticTorqueLessThan(String value) {
            addCriterion("static_torque <", value, "staticTorque");
            return (Criteria) this;
        }

        public Criteria andStaticTorqueLessThanOrEqualTo(String value) {
            addCriterion("static_torque <=", value, "staticTorque");
            return (Criteria) this;
        }

        public Criteria andStaticTorqueLike(String value) {
            addCriterion("static_torque like", value, "staticTorque");
            return (Criteria) this;
        }

        public Criteria andStaticTorqueNotLike(String value) {
            addCriterion("static_torque not like", value, "staticTorque");
            return (Criteria) this;
        }

        public Criteria andStaticTorqueIn(List<String> values) {
            addCriterion("static_torque in", values, "staticTorque");
            return (Criteria) this;
        }

        public Criteria andStaticTorqueNotIn(List<String> values) {
            addCriterion("static_torque not in", values, "staticTorque");
            return (Criteria) this;
        }

        public Criteria andStaticTorqueBetween(String value1, String value2) {
            addCriterion("static_torque between", value1, value2, "staticTorque");
            return (Criteria) this;
        }

        public Criteria andStaticTorqueNotBetween(String value1, String value2) {
            addCriterion("static_torque not between", value1, value2, "staticTorque");
            return (Criteria) this;
        }

        public Criteria andActuatorModelIsNull() {
            addCriterion("actuator_model is null");
            return (Criteria) this;
        }

        public Criteria andActuatorModelIsNotNull() {
            addCriterion("actuator_model is not null");
            return (Criteria) this;
        }

        public Criteria andActuatorModelEqualTo(String value) {
            addCriterion("actuator_model =", value, "actuatorModel");
            return (Criteria) this;
        }

        public Criteria andActuatorModelNotEqualTo(String value) {
            addCriterion("actuator_model <>", value, "actuatorModel");
            return (Criteria) this;
        }

        public Criteria andActuatorModelGreaterThan(String value) {
            addCriterion("actuator_model >", value, "actuatorModel");
            return (Criteria) this;
        }

        public Criteria andActuatorModelGreaterThanOrEqualTo(String value) {
            addCriterion("actuator_model >=", value, "actuatorModel");
            return (Criteria) this;
        }

        public Criteria andActuatorModelLessThan(String value) {
            addCriterion("actuator_model <", value, "actuatorModel");
            return (Criteria) this;
        }

        public Criteria andActuatorModelLessThanOrEqualTo(String value) {
            addCriterion("actuator_model <=", value, "actuatorModel");
            return (Criteria) this;
        }

        public Criteria andActuatorModelLike(String value) {
            addCriterion("actuator_model like", value, "actuatorModel");
            return (Criteria) this;
        }

        public Criteria andActuatorModelNotLike(String value) {
            addCriterion("actuator_model not like", value, "actuatorModel");
            return (Criteria) this;
        }

        public Criteria andActuatorModelIn(List<String> values) {
            addCriterion("actuator_model in", values, "actuatorModel");
            return (Criteria) this;
        }

        public Criteria andActuatorModelNotIn(List<String> values) {
            addCriterion("actuator_model not in", values, "actuatorModel");
            return (Criteria) this;
        }

        public Criteria andActuatorModelBetween(String value1, String value2) {
            addCriterion("actuator_model between", value1, value2, "actuatorModel");
            return (Criteria) this;
        }

        public Criteria andActuatorModelNotBetween(String value1, String value2) {
            addCriterion("actuator_model not between", value1, value2, "actuatorModel");
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

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
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

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
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