package com.deepsoft.haolifa.model.domain;

import java.util.ArrayList;
import java.util.List;

public class ProductPurchaseRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductPurchaseRecordExample() {
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

        public Criteria andPurchasePlanNoIsNull() {
            addCriterion("purchase_plan_no is null");
            return (Criteria) this;
        }

        public Criteria andPurchasePlanNoIsNotNull() {
            addCriterion("purchase_plan_no is not null");
            return (Criteria) this;
        }

        public Criteria andPurchasePlanNoEqualTo(String value) {
            addCriterion("purchase_plan_no =", value, "purchasePlanNo");
            return (Criteria) this;
        }

        public Criteria andPurchasePlanNoNotEqualTo(String value) {
            addCriterion("purchase_plan_no <>", value, "purchasePlanNo");
            return (Criteria) this;
        }

        public Criteria andPurchasePlanNoGreaterThan(String value) {
            addCriterion("purchase_plan_no >", value, "purchasePlanNo");
            return (Criteria) this;
        }

        public Criteria andPurchasePlanNoGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_plan_no >=", value, "purchasePlanNo");
            return (Criteria) this;
        }

        public Criteria andPurchasePlanNoLessThan(String value) {
            addCriterion("purchase_plan_no <", value, "purchasePlanNo");
            return (Criteria) this;
        }

        public Criteria andPurchasePlanNoLessThanOrEqualTo(String value) {
            addCriterion("purchase_plan_no <=", value, "purchasePlanNo");
            return (Criteria) this;
        }

        public Criteria andPurchasePlanNoLike(String value) {
            addCriterion("purchase_plan_no like", value, "purchasePlanNo");
            return (Criteria) this;
        }

        public Criteria andPurchasePlanNoNotLike(String value) {
            addCriterion("purchase_plan_no not like", value, "purchasePlanNo");
            return (Criteria) this;
        }

        public Criteria andPurchasePlanNoIn(List<String> values) {
            addCriterion("purchase_plan_no in", values, "purchasePlanNo");
            return (Criteria) this;
        }

        public Criteria andPurchasePlanNoNotIn(List<String> values) {
            addCriterion("purchase_plan_no not in", values, "purchasePlanNo");
            return (Criteria) this;
        }

        public Criteria andPurchasePlanNoBetween(String value1, String value2) {
            addCriterion("purchase_plan_no between", value1, value2, "purchasePlanNo");
            return (Criteria) this;
        }

        public Criteria andPurchasePlanNoNotBetween(String value1, String value2) {
            addCriterion("purchase_plan_no not between", value1, value2, "purchasePlanNo");
            return (Criteria) this;
        }

        public Criteria andProductOrderNoIsNull() {
            addCriterion("product_order_no is null");
            return (Criteria) this;
        }

        public Criteria andProductOrderNoIsNotNull() {
            addCriterion("product_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andProductOrderNoEqualTo(String value) {
            addCriterion("product_order_no =", value, "productOrderNo");
            return (Criteria) this;
        }

        public Criteria andProductOrderNoNotEqualTo(String value) {
            addCriterion("product_order_no <>", value, "productOrderNo");
            return (Criteria) this;
        }

        public Criteria andProductOrderNoGreaterThan(String value) {
            addCriterion("product_order_no >", value, "productOrderNo");
            return (Criteria) this;
        }

        public Criteria andProductOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("product_order_no >=", value, "productOrderNo");
            return (Criteria) this;
        }

        public Criteria andProductOrderNoLessThan(String value) {
            addCriterion("product_order_no <", value, "productOrderNo");
            return (Criteria) this;
        }

        public Criteria andProductOrderNoLessThanOrEqualTo(String value) {
            addCriterion("product_order_no <=", value, "productOrderNo");
            return (Criteria) this;
        }

        public Criteria andProductOrderNoLike(String value) {
            addCriterion("product_order_no like", value, "productOrderNo");
            return (Criteria) this;
        }

        public Criteria andProductOrderNoNotLike(String value) {
            addCriterion("product_order_no not like", value, "productOrderNo");
            return (Criteria) this;
        }

        public Criteria andProductOrderNoIn(List<String> values) {
            addCriterion("product_order_no in", values, "productOrderNo");
            return (Criteria) this;
        }

        public Criteria andProductOrderNoNotIn(List<String> values) {
            addCriterion("product_order_no not in", values, "productOrderNo");
            return (Criteria) this;
        }

        public Criteria andProductOrderNoBetween(String value1, String value2) {
            addCriterion("product_order_no between", value1, value2, "productOrderNo");
            return (Criteria) this;
        }

        public Criteria andProductOrderNoNotBetween(String value1, String value2) {
            addCriterion("product_order_no not between", value1, value2, "productOrderNo");
            return (Criteria) this;
        }

        public Criteria andMaterialGraphNoIsNull() {
            addCriterion("material_graph_no is null");
            return (Criteria) this;
        }

        public Criteria andMaterialGraphNoIsNotNull() {
            addCriterion("material_graph_no is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialGraphNoEqualTo(String value) {
            addCriterion("material_graph_no =", value, "materialGraphNo");
            return (Criteria) this;
        }

        public Criteria andMaterialGraphNoNotEqualTo(String value) {
            addCriterion("material_graph_no <>", value, "materialGraphNo");
            return (Criteria) this;
        }

        public Criteria andMaterialGraphNoGreaterThan(String value) {
            addCriterion("material_graph_no >", value, "materialGraphNo");
            return (Criteria) this;
        }

        public Criteria andMaterialGraphNoGreaterThanOrEqualTo(String value) {
            addCriterion("material_graph_no >=", value, "materialGraphNo");
            return (Criteria) this;
        }

        public Criteria andMaterialGraphNoLessThan(String value) {
            addCriterion("material_graph_no <", value, "materialGraphNo");
            return (Criteria) this;
        }

        public Criteria andMaterialGraphNoLessThanOrEqualTo(String value) {
            addCriterion("material_graph_no <=", value, "materialGraphNo");
            return (Criteria) this;
        }

        public Criteria andMaterialGraphNoLike(String value) {
            addCriterion("material_graph_no like", value, "materialGraphNo");
            return (Criteria) this;
        }

        public Criteria andMaterialGraphNoNotLike(String value) {
            addCriterion("material_graph_no not like", value, "materialGraphNo");
            return (Criteria) this;
        }

        public Criteria andMaterialGraphNoIn(List<String> values) {
            addCriterion("material_graph_no in", values, "materialGraphNo");
            return (Criteria) this;
        }

        public Criteria andMaterialGraphNoNotIn(List<String> values) {
            addCriterion("material_graph_no not in", values, "materialGraphNo");
            return (Criteria) this;
        }

        public Criteria andMaterialGraphNoBetween(String value1, String value2) {
            addCriterion("material_graph_no between", value1, value2, "materialGraphNo");
            return (Criteria) this;
        }

        public Criteria andMaterialGraphNoNotBetween(String value1, String value2) {
            addCriterion("material_graph_no not between", value1, value2, "materialGraphNo");
            return (Criteria) this;
        }

        public Criteria andApplyBuyNoIsNull() {
            addCriterion("apply_buy_no is null");
            return (Criteria) this;
        }

        public Criteria andApplyBuyNoIsNotNull() {
            addCriterion("apply_buy_no is not null");
            return (Criteria) this;
        }

        public Criteria andApplyBuyNoEqualTo(String value) {
            addCriterion("apply_buy_no =", value, "applyBuyNo");
            return (Criteria) this;
        }

        public Criteria andApplyBuyNoNotEqualTo(String value) {
            addCriterion("apply_buy_no <>", value, "applyBuyNo");
            return (Criteria) this;
        }

        public Criteria andApplyBuyNoGreaterThan(String value) {
            addCriterion("apply_buy_no >", value, "applyBuyNo");
            return (Criteria) this;
        }

        public Criteria andApplyBuyNoGreaterThanOrEqualTo(String value) {
            addCriterion("apply_buy_no >=", value, "applyBuyNo");
            return (Criteria) this;
        }

        public Criteria andApplyBuyNoLessThan(String value) {
            addCriterion("apply_buy_no <", value, "applyBuyNo");
            return (Criteria) this;
        }

        public Criteria andApplyBuyNoLessThanOrEqualTo(String value) {
            addCriterion("apply_buy_no <=", value, "applyBuyNo");
            return (Criteria) this;
        }

        public Criteria andApplyBuyNoLike(String value) {
            addCriterion("apply_buy_no like", value, "applyBuyNo");
            return (Criteria) this;
        }

        public Criteria andApplyBuyNoNotLike(String value) {
            addCriterion("apply_buy_no not like", value, "applyBuyNo");
            return (Criteria) this;
        }

        public Criteria andApplyBuyNoIn(List<String> values) {
            addCriterion("apply_buy_no in", values, "applyBuyNo");
            return (Criteria) this;
        }

        public Criteria andApplyBuyNoNotIn(List<String> values) {
            addCriterion("apply_buy_no not in", values, "applyBuyNo");
            return (Criteria) this;
        }

        public Criteria andApplyBuyNoBetween(String value1, String value2) {
            addCriterion("apply_buy_no between", value1, value2, "applyBuyNo");
            return (Criteria) this;
        }

        public Criteria andApplyBuyNoNotBetween(String value1, String value2) {
            addCriterion("apply_buy_no not between", value1, value2, "applyBuyNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoIsNull() {
            addCriterion("purchase_order_no is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoIsNotNull() {
            addCriterion("purchase_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoEqualTo(String value) {
            addCriterion("purchase_order_no =", value, "purchaseOrderNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoNotEqualTo(String value) {
            addCriterion("purchase_order_no <>", value, "purchaseOrderNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoGreaterThan(String value) {
            addCriterion("purchase_order_no >", value, "purchaseOrderNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_order_no >=", value, "purchaseOrderNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoLessThan(String value) {
            addCriterion("purchase_order_no <", value, "purchaseOrderNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoLessThanOrEqualTo(String value) {
            addCriterion("purchase_order_no <=", value, "purchaseOrderNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoLike(String value) {
            addCriterion("purchase_order_no like", value, "purchaseOrderNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoNotLike(String value) {
            addCriterion("purchase_order_no not like", value, "purchaseOrderNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoIn(List<String> values) {
            addCriterion("purchase_order_no in", values, "purchaseOrderNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoNotIn(List<String> values) {
            addCriterion("purchase_order_no not in", values, "purchaseOrderNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoBetween(String value1, String value2) {
            addCriterion("purchase_order_no between", value1, value2, "purchaseOrderNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoNotBetween(String value1, String value2) {
            addCriterion("purchase_order_no not between", value1, value2, "purchaseOrderNo");
            return (Criteria) this;
        }

        public Criteria andStockStatusIsNull() {
            addCriterion("stock_status is null");
            return (Criteria) this;
        }

        public Criteria andStockStatusIsNotNull() {
            addCriterion("stock_status is not null");
            return (Criteria) this;
        }

        public Criteria andStockStatusEqualTo(Byte value) {
            addCriterion("stock_status =", value, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusNotEqualTo(Byte value) {
            addCriterion("stock_status <>", value, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusGreaterThan(Byte value) {
            addCriterion("stock_status >", value, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("stock_status >=", value, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusLessThan(Byte value) {
            addCriterion("stock_status <", value, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusLessThanOrEqualTo(Byte value) {
            addCriterion("stock_status <=", value, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusIn(List<Byte> values) {
            addCriterion("stock_status in", values, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusNotIn(List<Byte> values) {
            addCriterion("stock_status not in", values, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusBetween(Byte value1, Byte value2) {
            addCriterion("stock_status between", value1, value2, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("stock_status not between", value1, value2, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderStatusIsNull() {
            addCriterion("purchase_order_status is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderStatusIsNotNull() {
            addCriterion("purchase_order_status is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderStatusEqualTo(Byte value) {
            addCriterion("purchase_order_status =", value, "purchaseOrderStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderStatusNotEqualTo(Byte value) {
            addCriterion("purchase_order_status <>", value, "purchaseOrderStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderStatusGreaterThan(Byte value) {
            addCriterion("purchase_order_status >", value, "purchaseOrderStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("purchase_order_status >=", value, "purchaseOrderStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderStatusLessThan(Byte value) {
            addCriterion("purchase_order_status <", value, "purchaseOrderStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderStatusLessThanOrEqualTo(Byte value) {
            addCriterion("purchase_order_status <=", value, "purchaseOrderStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderStatusIn(List<Byte> values) {
            addCriterion("purchase_order_status in", values, "purchaseOrderStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderStatusNotIn(List<Byte> values) {
            addCriterion("purchase_order_status not in", values, "purchaseOrderStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderStatusBetween(Byte value1, Byte value2) {
            addCriterion("purchase_order_status between", value1, value2, "purchaseOrderStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("purchase_order_status not between", value1, value2, "purchaseOrderStatus");
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