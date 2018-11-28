package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeliveryRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeliveryRecordExample() {
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

        public Criteria andDeliveryUrlIsNull() {
            addCriterion("delivery_url is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryUrlIsNotNull() {
            addCriterion("delivery_url is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryUrlEqualTo(String value) {
            addCriterion("delivery_url =", value, "deliveryUrl");
            return (Criteria) this;
        }

        public Criteria andDeliveryUrlNotEqualTo(String value) {
            addCriterion("delivery_url <>", value, "deliveryUrl");
            return (Criteria) this;
        }

        public Criteria andDeliveryUrlGreaterThan(String value) {
            addCriterion("delivery_url >", value, "deliveryUrl");
            return (Criteria) this;
        }

        public Criteria andDeliveryUrlGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_url >=", value, "deliveryUrl");
            return (Criteria) this;
        }

        public Criteria andDeliveryUrlLessThan(String value) {
            addCriterion("delivery_url <", value, "deliveryUrl");
            return (Criteria) this;
        }

        public Criteria andDeliveryUrlLessThanOrEqualTo(String value) {
            addCriterion("delivery_url <=", value, "deliveryUrl");
            return (Criteria) this;
        }

        public Criteria andDeliveryUrlLike(String value) {
            addCriterion("delivery_url like", value, "deliveryUrl");
            return (Criteria) this;
        }

        public Criteria andDeliveryUrlNotLike(String value) {
            addCriterion("delivery_url not like", value, "deliveryUrl");
            return (Criteria) this;
        }

        public Criteria andDeliveryUrlIn(List<String> values) {
            addCriterion("delivery_url in", values, "deliveryUrl");
            return (Criteria) this;
        }

        public Criteria andDeliveryUrlNotIn(List<String> values) {
            addCriterion("delivery_url not in", values, "deliveryUrl");
            return (Criteria) this;
        }

        public Criteria andDeliveryUrlBetween(String value1, String value2) {
            addCriterion("delivery_url between", value1, value2, "deliveryUrl");
            return (Criteria) this;
        }

        public Criteria andDeliveryUrlNotBetween(String value1, String value2) {
            addCriterion("delivery_url not between", value1, value2, "deliveryUrl");
            return (Criteria) this;
        }

        public Criteria andDeliveryClassifyIsNull() {
            addCriterion("delivery_classify is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryClassifyIsNotNull() {
            addCriterion("delivery_classify is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryClassifyEqualTo(Byte value) {
            addCriterion("delivery_classify =", value, "deliveryClassify");
            return (Criteria) this;
        }

        public Criteria andDeliveryClassifyNotEqualTo(Byte value) {
            addCriterion("delivery_classify <>", value, "deliveryClassify");
            return (Criteria) this;
        }

        public Criteria andDeliveryClassifyGreaterThan(Byte value) {
            addCriterion("delivery_classify >", value, "deliveryClassify");
            return (Criteria) this;
        }

        public Criteria andDeliveryClassifyGreaterThanOrEqualTo(Byte value) {
            addCriterion("delivery_classify >=", value, "deliveryClassify");
            return (Criteria) this;
        }

        public Criteria andDeliveryClassifyLessThan(Byte value) {
            addCriterion("delivery_classify <", value, "deliveryClassify");
            return (Criteria) this;
        }

        public Criteria andDeliveryClassifyLessThanOrEqualTo(Byte value) {
            addCriterion("delivery_classify <=", value, "deliveryClassify");
            return (Criteria) this;
        }

        public Criteria andDeliveryClassifyIn(List<Byte> values) {
            addCriterion("delivery_classify in", values, "deliveryClassify");
            return (Criteria) this;
        }

        public Criteria andDeliveryClassifyNotIn(List<Byte> values) {
            addCriterion("delivery_classify not in", values, "deliveryClassify");
            return (Criteria) this;
        }

        public Criteria andDeliveryClassifyBetween(Byte value1, Byte value2) {
            addCriterion("delivery_classify between", value1, value2, "deliveryClassify");
            return (Criteria) this;
        }

        public Criteria andDeliveryClassifyNotBetween(Byte value1, Byte value2) {
            addCriterion("delivery_classify not between", value1, value2, "deliveryClassify");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoIsNull() {
            addCriterion("delivery_no is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoIsNotNull() {
            addCriterion("delivery_no is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoEqualTo(String value) {
            addCriterion("delivery_no =", value, "deliveryNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoNotEqualTo(String value) {
            addCriterion("delivery_no <>", value, "deliveryNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoGreaterThan(String value) {
            addCriterion("delivery_no >", value, "deliveryNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_no >=", value, "deliveryNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoLessThan(String value) {
            addCriterion("delivery_no <", value, "deliveryNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoLessThanOrEqualTo(String value) {
            addCriterion("delivery_no <=", value, "deliveryNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoLike(String value) {
            addCriterion("delivery_no like", value, "deliveryNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoNotLike(String value) {
            addCriterion("delivery_no not like", value, "deliveryNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoIn(List<String> values) {
            addCriterion("delivery_no in", values, "deliveryNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoNotIn(List<String> values) {
            addCriterion("delivery_no not in", values, "deliveryNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoBetween(String value1, String value2) {
            addCriterion("delivery_no between", value1, value2, "deliveryNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoNotBetween(String value1, String value2) {
            addCriterion("delivery_no not between", value1, value2, "deliveryNo");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoIsNull() {
            addCriterion("contract_order_no is null");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoIsNotNull() {
            addCriterion("contract_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoEqualTo(String value) {
            addCriterion("contract_order_no =", value, "contractOrderNo");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoNotEqualTo(String value) {
            addCriterion("contract_order_no <>", value, "contractOrderNo");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoGreaterThan(String value) {
            addCriterion("contract_order_no >", value, "contractOrderNo");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("contract_order_no >=", value, "contractOrderNo");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoLessThan(String value) {
            addCriterion("contract_order_no <", value, "contractOrderNo");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoLessThanOrEqualTo(String value) {
            addCriterion("contract_order_no <=", value, "contractOrderNo");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoLike(String value) {
            addCriterion("contract_order_no like", value, "contractOrderNo");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoNotLike(String value) {
            addCriterion("contract_order_no not like", value, "contractOrderNo");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoIn(List<String> values) {
            addCriterion("contract_order_no in", values, "contractOrderNo");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoNotIn(List<String> values) {
            addCriterion("contract_order_no not in", values, "contractOrderNo");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoBetween(String value1, String value2) {
            addCriterion("contract_order_no between", value1, value2, "contractOrderNo");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoNotBetween(String value1, String value2) {
            addCriterion("contract_order_no not between", value1, value2, "contractOrderNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIsNull() {
            addCriterion("delivery_time is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIsNotNull() {
            addCriterion("delivery_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeEqualTo(Date value) {
            addCriterion("delivery_time =", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotEqualTo(Date value) {
            addCriterion("delivery_time <>", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThan(Date value) {
            addCriterion("delivery_time >", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("delivery_time >=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThan(Date value) {
            addCriterion("delivery_time <", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThanOrEqualTo(Date value) {
            addCriterion("delivery_time <=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIn(List<Date> values) {
            addCriterion("delivery_time in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotIn(List<Date> values) {
            addCriterion("delivery_time not in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeBetween(Date value1, Date value2) {
            addCriterion("delivery_time between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotBetween(Date value1, Date value2) {
            addCriterion("delivery_time not between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andOperationNoIsNull() {
            addCriterion("operation_no is null");
            return (Criteria) this;
        }

        public Criteria andOperationNoIsNotNull() {
            addCriterion("operation_no is not null");
            return (Criteria) this;
        }

        public Criteria andOperationNoEqualTo(String value) {
            addCriterion("operation_no =", value, "operationNo");
            return (Criteria) this;
        }

        public Criteria andOperationNoNotEqualTo(String value) {
            addCriterion("operation_no <>", value, "operationNo");
            return (Criteria) this;
        }

        public Criteria andOperationNoGreaterThan(String value) {
            addCriterion("operation_no >", value, "operationNo");
            return (Criteria) this;
        }

        public Criteria andOperationNoGreaterThanOrEqualTo(String value) {
            addCriterion("operation_no >=", value, "operationNo");
            return (Criteria) this;
        }

        public Criteria andOperationNoLessThan(String value) {
            addCriterion("operation_no <", value, "operationNo");
            return (Criteria) this;
        }

        public Criteria andOperationNoLessThanOrEqualTo(String value) {
            addCriterion("operation_no <=", value, "operationNo");
            return (Criteria) this;
        }

        public Criteria andOperationNoLike(String value) {
            addCriterion("operation_no like", value, "operationNo");
            return (Criteria) this;
        }

        public Criteria andOperationNoNotLike(String value) {
            addCriterion("operation_no not like", value, "operationNo");
            return (Criteria) this;
        }

        public Criteria andOperationNoIn(List<String> values) {
            addCriterion("operation_no in", values, "operationNo");
            return (Criteria) this;
        }

        public Criteria andOperationNoNotIn(List<String> values) {
            addCriterion("operation_no not in", values, "operationNo");
            return (Criteria) this;
        }

        public Criteria andOperationNoBetween(String value1, String value2) {
            addCriterion("operation_no between", value1, value2, "operationNo");
            return (Criteria) this;
        }

        public Criteria andOperationNoNotBetween(String value1, String value2) {
            addCriterion("operation_no not between", value1, value2, "operationNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoIsNull() {
            addCriterion("customer_no is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNoIsNotNull() {
            addCriterion("customer_no is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNoEqualTo(String value) {
            addCriterion("customer_no =", value, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoNotEqualTo(String value) {
            addCriterion("customer_no <>", value, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoGreaterThan(String value) {
            addCriterion("customer_no >", value, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoGreaterThanOrEqualTo(String value) {
            addCriterion("customer_no >=", value, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoLessThan(String value) {
            addCriterion("customer_no <", value, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoLessThanOrEqualTo(String value) {
            addCriterion("customer_no <=", value, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoLike(String value) {
            addCriterion("customer_no like", value, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoNotLike(String value) {
            addCriterion("customer_no not like", value, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoIn(List<String> values) {
            addCriterion("customer_no in", values, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoNotIn(List<String> values) {
            addCriterion("customer_no not in", values, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoBetween(String value1, String value2) {
            addCriterion("customer_no between", value1, value2, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoNotBetween(String value1, String value2) {
            addCriterion("customer_no not between", value1, value2, "customerNo");
            return (Criteria) this;
        }

        public Criteria andProductCountIsNull() {
            addCriterion("product_count is null");
            return (Criteria) this;
        }

        public Criteria andProductCountIsNotNull() {
            addCriterion("product_count is not null");
            return (Criteria) this;
        }

        public Criteria andProductCountEqualTo(Integer value) {
            addCriterion("product_count =", value, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountNotEqualTo(Integer value) {
            addCriterion("product_count <>", value, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountGreaterThan(Integer value) {
            addCriterion("product_count >", value, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_count >=", value, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountLessThan(Integer value) {
            addCriterion("product_count <", value, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountLessThanOrEqualTo(Integer value) {
            addCriterion("product_count <=", value, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountIn(List<Integer> values) {
            addCriterion("product_count in", values, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountNotIn(List<Integer> values) {
            addCriterion("product_count not in", values, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountBetween(Integer value1, Integer value2) {
            addCriterion("product_count between", value1, value2, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountNotBetween(Integer value1, Integer value2) {
            addCriterion("product_count not between", value1, value2, "productCount");
            return (Criteria) this;
        }

        public Criteria andPackingModeIsNull() {
            addCriterion("packing_mode is null");
            return (Criteria) this;
        }

        public Criteria andPackingModeIsNotNull() {
            addCriterion("packing_mode is not null");
            return (Criteria) this;
        }

        public Criteria andPackingModeEqualTo(String value) {
            addCriterion("packing_mode =", value, "packingMode");
            return (Criteria) this;
        }

        public Criteria andPackingModeNotEqualTo(String value) {
            addCriterion("packing_mode <>", value, "packingMode");
            return (Criteria) this;
        }

        public Criteria andPackingModeGreaterThan(String value) {
            addCriterion("packing_mode >", value, "packingMode");
            return (Criteria) this;
        }

        public Criteria andPackingModeGreaterThanOrEqualTo(String value) {
            addCriterion("packing_mode >=", value, "packingMode");
            return (Criteria) this;
        }

        public Criteria andPackingModeLessThan(String value) {
            addCriterion("packing_mode <", value, "packingMode");
            return (Criteria) this;
        }

        public Criteria andPackingModeLessThanOrEqualTo(String value) {
            addCriterion("packing_mode <=", value, "packingMode");
            return (Criteria) this;
        }

        public Criteria andPackingModeLike(String value) {
            addCriterion("packing_mode like", value, "packingMode");
            return (Criteria) this;
        }

        public Criteria andPackingModeNotLike(String value) {
            addCriterion("packing_mode not like", value, "packingMode");
            return (Criteria) this;
        }

        public Criteria andPackingModeIn(List<String> values) {
            addCriterion("packing_mode in", values, "packingMode");
            return (Criteria) this;
        }

        public Criteria andPackingModeNotIn(List<String> values) {
            addCriterion("packing_mode not in", values, "packingMode");
            return (Criteria) this;
        }

        public Criteria andPackingModeBetween(String value1, String value2) {
            addCriterion("packing_mode between", value1, value2, "packingMode");
            return (Criteria) this;
        }

        public Criteria andPackingModeNotBetween(String value1, String value2) {
            addCriterion("packing_mode not between", value1, value2, "packingMode");
            return (Criteria) this;
        }

        public Criteria andPieceCountIsNull() {
            addCriterion("piece_count is null");
            return (Criteria) this;
        }

        public Criteria andPieceCountIsNotNull() {
            addCriterion("piece_count is not null");
            return (Criteria) this;
        }

        public Criteria andPieceCountEqualTo(Integer value) {
            addCriterion("piece_count =", value, "pieceCount");
            return (Criteria) this;
        }

        public Criteria andPieceCountNotEqualTo(Integer value) {
            addCriterion("piece_count <>", value, "pieceCount");
            return (Criteria) this;
        }

        public Criteria andPieceCountGreaterThan(Integer value) {
            addCriterion("piece_count >", value, "pieceCount");
            return (Criteria) this;
        }

        public Criteria andPieceCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("piece_count >=", value, "pieceCount");
            return (Criteria) this;
        }

        public Criteria andPieceCountLessThan(Integer value) {
            addCriterion("piece_count <", value, "pieceCount");
            return (Criteria) this;
        }

        public Criteria andPieceCountLessThanOrEqualTo(Integer value) {
            addCriterion("piece_count <=", value, "pieceCount");
            return (Criteria) this;
        }

        public Criteria andPieceCountIn(List<Integer> values) {
            addCriterion("piece_count in", values, "pieceCount");
            return (Criteria) this;
        }

        public Criteria andPieceCountNotIn(List<Integer> values) {
            addCriterion("piece_count not in", values, "pieceCount");
            return (Criteria) this;
        }

        public Criteria andPieceCountBetween(Integer value1, Integer value2) {
            addCriterion("piece_count between", value1, value2, "pieceCount");
            return (Criteria) this;
        }

        public Criteria andPieceCountNotBetween(Integer value1, Integer value2) {
            addCriterion("piece_count not between", value1, value2, "pieceCount");
            return (Criteria) this;
        }

        public Criteria andTransportCompanyIsNull() {
            addCriterion("transport_company is null");
            return (Criteria) this;
        }

        public Criteria andTransportCompanyIsNotNull() {
            addCriterion("transport_company is not null");
            return (Criteria) this;
        }

        public Criteria andTransportCompanyEqualTo(String value) {
            addCriterion("transport_company =", value, "transportCompany");
            return (Criteria) this;
        }

        public Criteria andTransportCompanyNotEqualTo(String value) {
            addCriterion("transport_company <>", value, "transportCompany");
            return (Criteria) this;
        }

        public Criteria andTransportCompanyGreaterThan(String value) {
            addCriterion("transport_company >", value, "transportCompany");
            return (Criteria) this;
        }

        public Criteria andTransportCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("transport_company >=", value, "transportCompany");
            return (Criteria) this;
        }

        public Criteria andTransportCompanyLessThan(String value) {
            addCriterion("transport_company <", value, "transportCompany");
            return (Criteria) this;
        }

        public Criteria andTransportCompanyLessThanOrEqualTo(String value) {
            addCriterion("transport_company <=", value, "transportCompany");
            return (Criteria) this;
        }

        public Criteria andTransportCompanyLike(String value) {
            addCriterion("transport_company like", value, "transportCompany");
            return (Criteria) this;
        }

        public Criteria andTransportCompanyNotLike(String value) {
            addCriterion("transport_company not like", value, "transportCompany");
            return (Criteria) this;
        }

        public Criteria andTransportCompanyIn(List<String> values) {
            addCriterion("transport_company in", values, "transportCompany");
            return (Criteria) this;
        }

        public Criteria andTransportCompanyNotIn(List<String> values) {
            addCriterion("transport_company not in", values, "transportCompany");
            return (Criteria) this;
        }

        public Criteria andTransportCompanyBetween(String value1, String value2) {
            addCriterion("transport_company between", value1, value2, "transportCompany");
            return (Criteria) this;
        }

        public Criteria andTransportCompanyNotBetween(String value1, String value2) {
            addCriterion("transport_company not between", value1, value2, "transportCompany");
            return (Criteria) this;
        }

        public Criteria andCourierNoIsNull() {
            addCriterion("courier_no is null");
            return (Criteria) this;
        }

        public Criteria andCourierNoIsNotNull() {
            addCriterion("courier_no is not null");
            return (Criteria) this;
        }

        public Criteria andCourierNoEqualTo(String value) {
            addCriterion("courier_no =", value, "courierNo");
            return (Criteria) this;
        }

        public Criteria andCourierNoNotEqualTo(String value) {
            addCriterion("courier_no <>", value, "courierNo");
            return (Criteria) this;
        }

        public Criteria andCourierNoGreaterThan(String value) {
            addCriterion("courier_no >", value, "courierNo");
            return (Criteria) this;
        }

        public Criteria andCourierNoGreaterThanOrEqualTo(String value) {
            addCriterion("courier_no >=", value, "courierNo");
            return (Criteria) this;
        }

        public Criteria andCourierNoLessThan(String value) {
            addCriterion("courier_no <", value, "courierNo");
            return (Criteria) this;
        }

        public Criteria andCourierNoLessThanOrEqualTo(String value) {
            addCriterion("courier_no <=", value, "courierNo");
            return (Criteria) this;
        }

        public Criteria andCourierNoLike(String value) {
            addCriterion("courier_no like", value, "courierNo");
            return (Criteria) this;
        }

        public Criteria andCourierNoNotLike(String value) {
            addCriterion("courier_no not like", value, "courierNo");
            return (Criteria) this;
        }

        public Criteria andCourierNoIn(List<String> values) {
            addCriterion("courier_no in", values, "courierNo");
            return (Criteria) this;
        }

        public Criteria andCourierNoNotIn(List<String> values) {
            addCriterion("courier_no not in", values, "courierNo");
            return (Criteria) this;
        }

        public Criteria andCourierNoBetween(String value1, String value2) {
            addCriterion("courier_no between", value1, value2, "courierNo");
            return (Criteria) this;
        }

        public Criteria andCourierNoNotBetween(String value1, String value2) {
            addCriterion("courier_no not between", value1, value2, "courierNo");
            return (Criteria) this;
        }

        public Criteria andCollectProviceIsNull() {
            addCriterion("collect_provice is null");
            return (Criteria) this;
        }

        public Criteria andCollectProviceIsNotNull() {
            addCriterion("collect_provice is not null");
            return (Criteria) this;
        }

        public Criteria andCollectProviceEqualTo(String value) {
            addCriterion("collect_provice =", value, "collectProvice");
            return (Criteria) this;
        }

        public Criteria andCollectProviceNotEqualTo(String value) {
            addCriterion("collect_provice <>", value, "collectProvice");
            return (Criteria) this;
        }

        public Criteria andCollectProviceGreaterThan(String value) {
            addCriterion("collect_provice >", value, "collectProvice");
            return (Criteria) this;
        }

        public Criteria andCollectProviceGreaterThanOrEqualTo(String value) {
            addCriterion("collect_provice >=", value, "collectProvice");
            return (Criteria) this;
        }

        public Criteria andCollectProviceLessThan(String value) {
            addCriterion("collect_provice <", value, "collectProvice");
            return (Criteria) this;
        }

        public Criteria andCollectProviceLessThanOrEqualTo(String value) {
            addCriterion("collect_provice <=", value, "collectProvice");
            return (Criteria) this;
        }

        public Criteria andCollectProviceLike(String value) {
            addCriterion("collect_provice like", value, "collectProvice");
            return (Criteria) this;
        }

        public Criteria andCollectProviceNotLike(String value) {
            addCriterion("collect_provice not like", value, "collectProvice");
            return (Criteria) this;
        }

        public Criteria andCollectProviceIn(List<String> values) {
            addCriterion("collect_provice in", values, "collectProvice");
            return (Criteria) this;
        }

        public Criteria andCollectProviceNotIn(List<String> values) {
            addCriterion("collect_provice not in", values, "collectProvice");
            return (Criteria) this;
        }

        public Criteria andCollectProviceBetween(String value1, String value2) {
            addCriterion("collect_provice between", value1, value2, "collectProvice");
            return (Criteria) this;
        }

        public Criteria andCollectProviceNotBetween(String value1, String value2) {
            addCriterion("collect_provice not between", value1, value2, "collectProvice");
            return (Criteria) this;
        }

        public Criteria andCollectAddressIsNull() {
            addCriterion("collect_address is null");
            return (Criteria) this;
        }

        public Criteria andCollectAddressIsNotNull() {
            addCriterion("collect_address is not null");
            return (Criteria) this;
        }

        public Criteria andCollectAddressEqualTo(String value) {
            addCriterion("collect_address =", value, "collectAddress");
            return (Criteria) this;
        }

        public Criteria andCollectAddressNotEqualTo(String value) {
            addCriterion("collect_address <>", value, "collectAddress");
            return (Criteria) this;
        }

        public Criteria andCollectAddressGreaterThan(String value) {
            addCriterion("collect_address >", value, "collectAddress");
            return (Criteria) this;
        }

        public Criteria andCollectAddressGreaterThanOrEqualTo(String value) {
            addCriterion("collect_address >=", value, "collectAddress");
            return (Criteria) this;
        }

        public Criteria andCollectAddressLessThan(String value) {
            addCriterion("collect_address <", value, "collectAddress");
            return (Criteria) this;
        }

        public Criteria andCollectAddressLessThanOrEqualTo(String value) {
            addCriterion("collect_address <=", value, "collectAddress");
            return (Criteria) this;
        }

        public Criteria andCollectAddressLike(String value) {
            addCriterion("collect_address like", value, "collectAddress");
            return (Criteria) this;
        }

        public Criteria andCollectAddressNotLike(String value) {
            addCriterion("collect_address not like", value, "collectAddress");
            return (Criteria) this;
        }

        public Criteria andCollectAddressIn(List<String> values) {
            addCriterion("collect_address in", values, "collectAddress");
            return (Criteria) this;
        }

        public Criteria andCollectAddressNotIn(List<String> values) {
            addCriterion("collect_address not in", values, "collectAddress");
            return (Criteria) this;
        }

        public Criteria andCollectAddressBetween(String value1, String value2) {
            addCriterion("collect_address between", value1, value2, "collectAddress");
            return (Criteria) this;
        }

        public Criteria andCollectAddressNotBetween(String value1, String value2) {
            addCriterion("collect_address not between", value1, value2, "collectAddress");
            return (Criteria) this;
        }

        public Criteria andCollectNameIsNull() {
            addCriterion("collect_name is null");
            return (Criteria) this;
        }

        public Criteria andCollectNameIsNotNull() {
            addCriterion("collect_name is not null");
            return (Criteria) this;
        }

        public Criteria andCollectNameEqualTo(String value) {
            addCriterion("collect_name =", value, "collectName");
            return (Criteria) this;
        }

        public Criteria andCollectNameNotEqualTo(String value) {
            addCriterion("collect_name <>", value, "collectName");
            return (Criteria) this;
        }

        public Criteria andCollectNameGreaterThan(String value) {
            addCriterion("collect_name >", value, "collectName");
            return (Criteria) this;
        }

        public Criteria andCollectNameGreaterThanOrEqualTo(String value) {
            addCriterion("collect_name >=", value, "collectName");
            return (Criteria) this;
        }

        public Criteria andCollectNameLessThan(String value) {
            addCriterion("collect_name <", value, "collectName");
            return (Criteria) this;
        }

        public Criteria andCollectNameLessThanOrEqualTo(String value) {
            addCriterion("collect_name <=", value, "collectName");
            return (Criteria) this;
        }

        public Criteria andCollectNameLike(String value) {
            addCriterion("collect_name like", value, "collectName");
            return (Criteria) this;
        }

        public Criteria andCollectNameNotLike(String value) {
            addCriterion("collect_name not like", value, "collectName");
            return (Criteria) this;
        }

        public Criteria andCollectNameIn(List<String> values) {
            addCriterion("collect_name in", values, "collectName");
            return (Criteria) this;
        }

        public Criteria andCollectNameNotIn(List<String> values) {
            addCriterion("collect_name not in", values, "collectName");
            return (Criteria) this;
        }

        public Criteria andCollectNameBetween(String value1, String value2) {
            addCriterion("collect_name between", value1, value2, "collectName");
            return (Criteria) this;
        }

        public Criteria andCollectNameNotBetween(String value1, String value2) {
            addCriterion("collect_name not between", value1, value2, "collectName");
            return (Criteria) this;
        }

        public Criteria andCollectPhoneIsNull() {
            addCriterion("collect_phone is null");
            return (Criteria) this;
        }

        public Criteria andCollectPhoneIsNotNull() {
            addCriterion("collect_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCollectPhoneEqualTo(String value) {
            addCriterion("collect_phone =", value, "collectPhone");
            return (Criteria) this;
        }

        public Criteria andCollectPhoneNotEqualTo(String value) {
            addCriterion("collect_phone <>", value, "collectPhone");
            return (Criteria) this;
        }

        public Criteria andCollectPhoneGreaterThan(String value) {
            addCriterion("collect_phone >", value, "collectPhone");
            return (Criteria) this;
        }

        public Criteria andCollectPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("collect_phone >=", value, "collectPhone");
            return (Criteria) this;
        }

        public Criteria andCollectPhoneLessThan(String value) {
            addCriterion("collect_phone <", value, "collectPhone");
            return (Criteria) this;
        }

        public Criteria andCollectPhoneLessThanOrEqualTo(String value) {
            addCriterion("collect_phone <=", value, "collectPhone");
            return (Criteria) this;
        }

        public Criteria andCollectPhoneLike(String value) {
            addCriterion("collect_phone like", value, "collectPhone");
            return (Criteria) this;
        }

        public Criteria andCollectPhoneNotLike(String value) {
            addCriterion("collect_phone not like", value, "collectPhone");
            return (Criteria) this;
        }

        public Criteria andCollectPhoneIn(List<String> values) {
            addCriterion("collect_phone in", values, "collectPhone");
            return (Criteria) this;
        }

        public Criteria andCollectPhoneNotIn(List<String> values) {
            addCriterion("collect_phone not in", values, "collectPhone");
            return (Criteria) this;
        }

        public Criteria andCollectPhoneBetween(String value1, String value2) {
            addCriterion("collect_phone between", value1, value2, "collectPhone");
            return (Criteria) this;
        }

        public Criteria andCollectPhoneNotBetween(String value1, String value2) {
            addCriterion("collect_phone not between", value1, value2, "collectPhone");
            return (Criteria) this;
        }

        public Criteria andWeightPieceIsNull() {
            addCriterion("weight_piece is null");
            return (Criteria) this;
        }

        public Criteria andWeightPieceIsNotNull() {
            addCriterion("weight_piece is not null");
            return (Criteria) this;
        }

        public Criteria andWeightPieceEqualTo(BigDecimal value) {
            addCriterion("weight_piece =", value, "weightPiece");
            return (Criteria) this;
        }

        public Criteria andWeightPieceNotEqualTo(BigDecimal value) {
            addCriterion("weight_piece <>", value, "weightPiece");
            return (Criteria) this;
        }

        public Criteria andWeightPieceGreaterThan(BigDecimal value) {
            addCriterion("weight_piece >", value, "weightPiece");
            return (Criteria) this;
        }

        public Criteria andWeightPieceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weight_piece >=", value, "weightPiece");
            return (Criteria) this;
        }

        public Criteria andWeightPieceLessThan(BigDecimal value) {
            addCriterion("weight_piece <", value, "weightPiece");
            return (Criteria) this;
        }

        public Criteria andWeightPieceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weight_piece <=", value, "weightPiece");
            return (Criteria) this;
        }

        public Criteria andWeightPieceIn(List<BigDecimal> values) {
            addCriterion("weight_piece in", values, "weightPiece");
            return (Criteria) this;
        }

        public Criteria andWeightPieceNotIn(List<BigDecimal> values) {
            addCriterion("weight_piece not in", values, "weightPiece");
            return (Criteria) this;
        }

        public Criteria andWeightPieceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight_piece between", value1, value2, "weightPiece");
            return (Criteria) this;
        }

        public Criteria andWeightPieceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight_piece not between", value1, value2, "weightPiece");
            return (Criteria) this;
        }

        public Criteria andPricePieceIsNull() {
            addCriterion("price_piece is null");
            return (Criteria) this;
        }

        public Criteria andPricePieceIsNotNull() {
            addCriterion("price_piece is not null");
            return (Criteria) this;
        }

        public Criteria andPricePieceEqualTo(BigDecimal value) {
            addCriterion("price_piece =", value, "pricePiece");
            return (Criteria) this;
        }

        public Criteria andPricePieceNotEqualTo(BigDecimal value) {
            addCriterion("price_piece <>", value, "pricePiece");
            return (Criteria) this;
        }

        public Criteria andPricePieceGreaterThan(BigDecimal value) {
            addCriterion("price_piece >", value, "pricePiece");
            return (Criteria) this;
        }

        public Criteria andPricePieceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_piece >=", value, "pricePiece");
            return (Criteria) this;
        }

        public Criteria andPricePieceLessThan(BigDecimal value) {
            addCriterion("price_piece <", value, "pricePiece");
            return (Criteria) this;
        }

        public Criteria andPricePieceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_piece <=", value, "pricePiece");
            return (Criteria) this;
        }

        public Criteria andPricePieceIn(List<BigDecimal> values) {
            addCriterion("price_piece in", values, "pricePiece");
            return (Criteria) this;
        }

        public Criteria andPricePieceNotIn(List<BigDecimal> values) {
            addCriterion("price_piece not in", values, "pricePiece");
            return (Criteria) this;
        }

        public Criteria andPricePieceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_piece between", value1, value2, "pricePiece");
            return (Criteria) this;
        }

        public Criteria andPricePieceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_piece not between", value1, value2, "pricePiece");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeIsNull() {
            addCriterion("delivery_fee is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeIsNotNull() {
            addCriterion("delivery_fee is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeEqualTo(BigDecimal value) {
            addCriterion("delivery_fee =", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeNotEqualTo(BigDecimal value) {
            addCriterion("delivery_fee <>", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeGreaterThan(BigDecimal value) {
            addCriterion("delivery_fee >", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("delivery_fee >=", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeLessThan(BigDecimal value) {
            addCriterion("delivery_fee <", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("delivery_fee <=", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeIn(List<BigDecimal> values) {
            addCriterion("delivery_fee in", values, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeNotIn(List<BigDecimal> values) {
            addCriterion("delivery_fee not in", values, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("delivery_fee between", value1, value2, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("delivery_fee not between", value1, value2, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNull() {
            addCriterion("total_fee is null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNotNull() {
            addCriterion("total_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeEqualTo(BigDecimal value) {
            addCriterion("total_fee =", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotEqualTo(BigDecimal value) {
            addCriterion("total_fee <>", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThan(BigDecimal value) {
            addCriterion("total_fee >", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_fee >=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThan(BigDecimal value) {
            addCriterion("total_fee <", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_fee <=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIn(List<BigDecimal> values) {
            addCriterion("total_fee in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotIn(List<BigDecimal> values) {
            addCriterion("total_fee not in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_fee between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_fee not between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andSettlementWayIsNull() {
            addCriterion("settlement_way is null");
            return (Criteria) this;
        }

        public Criteria andSettlementWayIsNotNull() {
            addCriterion("settlement_way is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementWayEqualTo(String value) {
            addCriterion("settlement_way =", value, "settlementWay");
            return (Criteria) this;
        }

        public Criteria andSettlementWayNotEqualTo(String value) {
            addCriterion("settlement_way <>", value, "settlementWay");
            return (Criteria) this;
        }

        public Criteria andSettlementWayGreaterThan(String value) {
            addCriterion("settlement_way >", value, "settlementWay");
            return (Criteria) this;
        }

        public Criteria andSettlementWayGreaterThanOrEqualTo(String value) {
            addCriterion("settlement_way >=", value, "settlementWay");
            return (Criteria) this;
        }

        public Criteria andSettlementWayLessThan(String value) {
            addCriterion("settlement_way <", value, "settlementWay");
            return (Criteria) this;
        }

        public Criteria andSettlementWayLessThanOrEqualTo(String value) {
            addCriterion("settlement_way <=", value, "settlementWay");
            return (Criteria) this;
        }

        public Criteria andSettlementWayLike(String value) {
            addCriterion("settlement_way like", value, "settlementWay");
            return (Criteria) this;
        }

        public Criteria andSettlementWayNotLike(String value) {
            addCriterion("settlement_way not like", value, "settlementWay");
            return (Criteria) this;
        }

        public Criteria andSettlementWayIn(List<String> values) {
            addCriterion("settlement_way in", values, "settlementWay");
            return (Criteria) this;
        }

        public Criteria andSettlementWayNotIn(List<String> values) {
            addCriterion("settlement_way not in", values, "settlementWay");
            return (Criteria) this;
        }

        public Criteria andSettlementWayBetween(String value1, String value2) {
            addCriterion("settlement_way between", value1, value2, "settlementWay");
            return (Criteria) this;
        }

        public Criteria andSettlementWayNotBetween(String value1, String value2) {
            addCriterion("settlement_way not between", value1, value2, "settlementWay");
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