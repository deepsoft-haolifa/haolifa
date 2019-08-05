package com.deepsoft.haolifa.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProInspectRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProInspectRecordExample() {
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

        public Criteria andProductSpecificationsIsNull() {
            addCriterion("product_specifications is null");
            return (Criteria) this;
        }

        public Criteria andProductSpecificationsIsNotNull() {
            addCriterion("product_specifications is not null");
            return (Criteria) this;
        }

        public Criteria andProductSpecificationsEqualTo(String value) {
            addCriterion("product_specifications =", value, "productSpecifications");
            return (Criteria) this;
        }

        public Criteria andProductSpecificationsNotEqualTo(String value) {
            addCriterion("product_specifications <>", value, "productSpecifications");
            return (Criteria) this;
        }

        public Criteria andProductSpecificationsGreaterThan(String value) {
            addCriterion("product_specifications >", value, "productSpecifications");
            return (Criteria) this;
        }

        public Criteria andProductSpecificationsGreaterThanOrEqualTo(String value) {
            addCriterion("product_specifications >=", value, "productSpecifications");
            return (Criteria) this;
        }

        public Criteria andProductSpecificationsLessThan(String value) {
            addCriterion("product_specifications <", value, "productSpecifications");
            return (Criteria) this;
        }

        public Criteria andProductSpecificationsLessThanOrEqualTo(String value) {
            addCriterion("product_specifications <=", value, "productSpecifications");
            return (Criteria) this;
        }

        public Criteria andProductSpecificationsLike(String value) {
            addCriterion("product_specifications like", value, "productSpecifications");
            return (Criteria) this;
        }

        public Criteria andProductSpecificationsNotLike(String value) {
            addCriterion("product_specifications not like", value, "productSpecifications");
            return (Criteria) this;
        }

        public Criteria andProductSpecificationsIn(List<String> values) {
            addCriterion("product_specifications in", values, "productSpecifications");
            return (Criteria) this;
        }

        public Criteria andProductSpecificationsNotIn(List<String> values) {
            addCriterion("product_specifications not in", values, "productSpecifications");
            return (Criteria) this;
        }

        public Criteria andProductSpecificationsBetween(String value1, String value2) {
            addCriterion("product_specifications between", value1, value2, "productSpecifications");
            return (Criteria) this;
        }

        public Criteria andProductSpecificationsNotBetween(String value1, String value2) {
            addCriterion("product_specifications not between", value1, value2, "productSpecifications");
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

        public Criteria andQualifiedNumberIsNull() {
            addCriterion("qualified_number is null");
            return (Criteria) this;
        }

        public Criteria andQualifiedNumberIsNotNull() {
            addCriterion("qualified_number is not null");
            return (Criteria) this;
        }

        public Criteria andQualifiedNumberEqualTo(Integer value) {
            addCriterion("qualified_number =", value, "qualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andQualifiedNumberNotEqualTo(Integer value) {
            addCriterion("qualified_number <>", value, "qualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andQualifiedNumberGreaterThan(Integer value) {
            addCriterion("qualified_number >", value, "qualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andQualifiedNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("qualified_number >=", value, "qualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andQualifiedNumberLessThan(Integer value) {
            addCriterion("qualified_number <", value, "qualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andQualifiedNumberLessThanOrEqualTo(Integer value) {
            addCriterion("qualified_number <=", value, "qualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andQualifiedNumberIn(List<Integer> values) {
            addCriterion("qualified_number in", values, "qualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andQualifiedNumberNotIn(List<Integer> values) {
            addCriterion("qualified_number not in", values, "qualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andQualifiedNumberBetween(Integer value1, Integer value2) {
            addCriterion("qualified_number between", value1, value2, "qualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andQualifiedNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("qualified_number not between", value1, value2, "qualifiedNumber");
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

        public Criteria andStorageStatusIsNull() {
            addCriterion("storage_status is null");
            return (Criteria) this;
        }

        public Criteria andStorageStatusIsNotNull() {
            addCriterion("storage_status is not null");
            return (Criteria) this;
        }

        public Criteria andStorageStatusEqualTo(Byte value) {
            addCriterion("storage_status =", value, "storageStatus");
            return (Criteria) this;
        }

        public Criteria andStorageStatusNotEqualTo(Byte value) {
            addCriterion("storage_status <>", value, "storageStatus");
            return (Criteria) this;
        }

        public Criteria andStorageStatusGreaterThan(Byte value) {
            addCriterion("storage_status >", value, "storageStatus");
            return (Criteria) this;
        }

        public Criteria andStorageStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("storage_status >=", value, "storageStatus");
            return (Criteria) this;
        }

        public Criteria andStorageStatusLessThan(Byte value) {
            addCriterion("storage_status <", value, "storageStatus");
            return (Criteria) this;
        }

        public Criteria andStorageStatusLessThanOrEqualTo(Byte value) {
            addCriterion("storage_status <=", value, "storageStatus");
            return (Criteria) this;
        }

        public Criteria andStorageStatusIn(List<Byte> values) {
            addCriterion("storage_status in", values, "storageStatus");
            return (Criteria) this;
        }

        public Criteria andStorageStatusNotIn(List<Byte> values) {
            addCriterion("storage_status not in", values, "storageStatus");
            return (Criteria) this;
        }

        public Criteria andStorageStatusBetween(Byte value1, Byte value2) {
            addCriterion("storage_status between", value1, value2, "storageStatus");
            return (Criteria) this;
        }

        public Criteria andStorageStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("storage_status not between", value1, value2, "storageStatus");
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

        public Criteria andAccessoryIsNull() {
            addCriterion("accessory is null");
            return (Criteria) this;
        }

        public Criteria andAccessoryIsNotNull() {
            addCriterion("accessory is not null");
            return (Criteria) this;
        }

        public Criteria andAccessoryEqualTo(String value) {
            addCriterion("accessory =", value, "accessory");
            return (Criteria) this;
        }

        public Criteria andAccessoryNotEqualTo(String value) {
            addCriterion("accessory <>", value, "accessory");
            return (Criteria) this;
        }

        public Criteria andAccessoryGreaterThan(String value) {
            addCriterion("accessory >", value, "accessory");
            return (Criteria) this;
        }

        public Criteria andAccessoryGreaterThanOrEqualTo(String value) {
            addCriterion("accessory >=", value, "accessory");
            return (Criteria) this;
        }

        public Criteria andAccessoryLessThan(String value) {
            addCriterion("accessory <", value, "accessory");
            return (Criteria) this;
        }

        public Criteria andAccessoryLessThanOrEqualTo(String value) {
            addCriterion("accessory <=", value, "accessory");
            return (Criteria) this;
        }

        public Criteria andAccessoryLike(String value) {
            addCriterion("accessory like", value, "accessory");
            return (Criteria) this;
        }

        public Criteria andAccessoryNotLike(String value) {
            addCriterion("accessory not like", value, "accessory");
            return (Criteria) this;
        }

        public Criteria andAccessoryIn(List<String> values) {
            addCriterion("accessory in", values, "accessory");
            return (Criteria) this;
        }

        public Criteria andAccessoryNotIn(List<String> values) {
            addCriterion("accessory not in", values, "accessory");
            return (Criteria) this;
        }

        public Criteria andAccessoryBetween(String value1, String value2) {
            addCriterion("accessory between", value1, value2, "accessory");
            return (Criteria) this;
        }

        public Criteria andAccessoryNotBetween(String value1, String value2) {
            addCriterion("accessory not between", value1, value2, "accessory");
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