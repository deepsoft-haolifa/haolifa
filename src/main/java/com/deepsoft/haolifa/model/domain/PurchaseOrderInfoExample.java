package com.deepsoft.haolifa.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurchaseOrderInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PurchaseOrderInfoExample() {
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

        public Criteria andFlowIdIsNull() {
            addCriterion("flow_id is null");
            return (Criteria) this;
        }

        public Criteria andFlowIdIsNotNull() {
            addCriterion("flow_id is not null");
            return (Criteria) this;
        }

        public Criteria andFlowIdEqualTo(Integer value) {
            addCriterion("flow_id =", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdNotEqualTo(Integer value) {
            addCriterion("flow_id <>", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdGreaterThan(Integer value) {
            addCriterion("flow_id >", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("flow_id >=", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdLessThan(Integer value) {
            addCriterion("flow_id <", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdLessThanOrEqualTo(Integer value) {
            addCriterion("flow_id <=", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdIn(List<Integer> values) {
            addCriterion("flow_id in", values, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdNotIn(List<Integer> values) {
            addCriterion("flow_id not in", values, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdBetween(Integer value1, Integer value2) {
            addCriterion("flow_id between", value1, value2, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdNotBetween(Integer value1, Integer value2) {
            addCriterion("flow_id not between", value1, value2, "flowId");
            return (Criteria) this;
        }

        public Criteria andApplyNoIsNull() {
            addCriterion("apply_no is null");
            return (Criteria) this;
        }

        public Criteria andApplyNoIsNotNull() {
            addCriterion("apply_no is not null");
            return (Criteria) this;
        }

        public Criteria andApplyNoEqualTo(String value) {
            addCriterion("apply_no =", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoNotEqualTo(String value) {
            addCriterion("apply_no <>", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoGreaterThan(String value) {
            addCriterion("apply_no >", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoGreaterThanOrEqualTo(String value) {
            addCriterion("apply_no >=", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoLessThan(String value) {
            addCriterion("apply_no <", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoLessThanOrEqualTo(String value) {
            addCriterion("apply_no <=", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoLike(String value) {
            addCriterion("apply_no like", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoNotLike(String value) {
            addCriterion("apply_no not like", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoIn(List<String> values) {
            addCriterion("apply_no in", values, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoNotIn(List<String> values) {
            addCriterion("apply_no not in", values, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoBetween(String value1, String value2) {
            addCriterion("apply_no between", value1, value2, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoNotBetween(String value1, String value2) {
            addCriterion("apply_no not between", value1, value2, "applyNo");
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

        public Criteria andOrderStateIsNull() {
            addCriterion("order_state is null");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNotNull() {
            addCriterion("order_state is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStateEqualTo(Byte value) {
            addCriterion("order_state =", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotEqualTo(Byte value) {
            addCriterion("order_state <>", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThan(Byte value) {
            addCriterion("order_state >", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("order_state >=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThan(Byte value) {
            addCriterion("order_state <", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThanOrEqualTo(Byte value) {
            addCriterion("order_state <=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateIn(List<Byte> values) {
            addCriterion("order_state in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotIn(List<Byte> values) {
            addCriterion("order_state not in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateBetween(Byte value1, Byte value2) {
            addCriterion("order_state between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotBetween(Byte value1, Byte value2) {
            addCriterion("order_state not between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNull() {
            addCriterion("supplier is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNotNull() {
            addCriterion("supplier is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierEqualTo(String value) {
            addCriterion("supplier =", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotEqualTo(String value) {
            addCriterion("supplier <>", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThan(String value) {
            addCriterion("supplier >", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThanOrEqualTo(String value) {
            addCriterion("supplier >=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThan(String value) {
            addCriterion("supplier <", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThanOrEqualTo(String value) {
            addCriterion("supplier <=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLike(String value) {
            addCriterion("supplier like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotLike(String value) {
            addCriterion("supplier not like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierIn(List<String> values) {
            addCriterion("supplier in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotIn(List<String> values) {
            addCriterion("supplier not in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierBetween(String value1, String value2) {
            addCriterion("supplier between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotBetween(String value1, String value2) {
            addCriterion("supplier not between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andDemanderIsNull() {
            addCriterion("demander is null");
            return (Criteria) this;
        }

        public Criteria andDemanderIsNotNull() {
            addCriterion("demander is not null");
            return (Criteria) this;
        }

        public Criteria andDemanderEqualTo(String value) {
            addCriterion("demander =", value, "demander");
            return (Criteria) this;
        }

        public Criteria andDemanderNotEqualTo(String value) {
            addCriterion("demander <>", value, "demander");
            return (Criteria) this;
        }

        public Criteria andDemanderGreaterThan(String value) {
            addCriterion("demander >", value, "demander");
            return (Criteria) this;
        }

        public Criteria andDemanderGreaterThanOrEqualTo(String value) {
            addCriterion("demander >=", value, "demander");
            return (Criteria) this;
        }

        public Criteria andDemanderLessThan(String value) {
            addCriterion("demander <", value, "demander");
            return (Criteria) this;
        }

        public Criteria andDemanderLessThanOrEqualTo(String value) {
            addCriterion("demander <=", value, "demander");
            return (Criteria) this;
        }

        public Criteria andDemanderLike(String value) {
            addCriterion("demander like", value, "demander");
            return (Criteria) this;
        }

        public Criteria andDemanderNotLike(String value) {
            addCriterion("demander not like", value, "demander");
            return (Criteria) this;
        }

        public Criteria andDemanderIn(List<String> values) {
            addCriterion("demander in", values, "demander");
            return (Criteria) this;
        }

        public Criteria andDemanderNotIn(List<String> values) {
            addCriterion("demander not in", values, "demander");
            return (Criteria) this;
        }

        public Criteria andDemanderBetween(String value1, String value2) {
            addCriterion("demander between", value1, value2, "demander");
            return (Criteria) this;
        }

        public Criteria andDemanderNotBetween(String value1, String value2) {
            addCriterion("demander not between", value1, value2, "demander");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkmanIsNull() {
            addCriterion("supplier_linkman is null");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkmanIsNotNull() {
            addCriterion("supplier_linkman is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkmanEqualTo(String value) {
            addCriterion("supplier_linkman =", value, "supplierLinkman");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkmanNotEqualTo(String value) {
            addCriterion("supplier_linkman <>", value, "supplierLinkman");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkmanGreaterThan(String value) {
            addCriterion("supplier_linkman >", value, "supplierLinkman");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkmanGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_linkman >=", value, "supplierLinkman");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkmanLessThan(String value) {
            addCriterion("supplier_linkman <", value, "supplierLinkman");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkmanLessThanOrEqualTo(String value) {
            addCriterion("supplier_linkman <=", value, "supplierLinkman");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkmanLike(String value) {
            addCriterion("supplier_linkman like", value, "supplierLinkman");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkmanNotLike(String value) {
            addCriterion("supplier_linkman not like", value, "supplierLinkman");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkmanIn(List<String> values) {
            addCriterion("supplier_linkman in", values, "supplierLinkman");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkmanNotIn(List<String> values) {
            addCriterion("supplier_linkman not in", values, "supplierLinkman");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkmanBetween(String value1, String value2) {
            addCriterion("supplier_linkman between", value1, value2, "supplierLinkman");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkmanNotBetween(String value1, String value2) {
            addCriterion("supplier_linkman not between", value1, value2, "supplierLinkman");
            return (Criteria) this;
        }

        public Criteria andDemanderLinkmanIsNull() {
            addCriterion("demander_linkman is null");
            return (Criteria) this;
        }

        public Criteria andDemanderLinkmanIsNotNull() {
            addCriterion("demander_linkman is not null");
            return (Criteria) this;
        }

        public Criteria andDemanderLinkmanEqualTo(String value) {
            addCriterion("demander_linkman =", value, "demanderLinkman");
            return (Criteria) this;
        }

        public Criteria andDemanderLinkmanNotEqualTo(String value) {
            addCriterion("demander_linkman <>", value, "demanderLinkman");
            return (Criteria) this;
        }

        public Criteria andDemanderLinkmanGreaterThan(String value) {
            addCriterion("demander_linkman >", value, "demanderLinkman");
            return (Criteria) this;
        }

        public Criteria andDemanderLinkmanGreaterThanOrEqualTo(String value) {
            addCriterion("demander_linkman >=", value, "demanderLinkman");
            return (Criteria) this;
        }

        public Criteria andDemanderLinkmanLessThan(String value) {
            addCriterion("demander_linkman <", value, "demanderLinkman");
            return (Criteria) this;
        }

        public Criteria andDemanderLinkmanLessThanOrEqualTo(String value) {
            addCriterion("demander_linkman <=", value, "demanderLinkman");
            return (Criteria) this;
        }

        public Criteria andDemanderLinkmanLike(String value) {
            addCriterion("demander_linkman like", value, "demanderLinkman");
            return (Criteria) this;
        }

        public Criteria andDemanderLinkmanNotLike(String value) {
            addCriterion("demander_linkman not like", value, "demanderLinkman");
            return (Criteria) this;
        }

        public Criteria andDemanderLinkmanIn(List<String> values) {
            addCriterion("demander_linkman in", values, "demanderLinkman");
            return (Criteria) this;
        }

        public Criteria andDemanderLinkmanNotIn(List<String> values) {
            addCriterion("demander_linkman not in", values, "demanderLinkman");
            return (Criteria) this;
        }

        public Criteria andDemanderLinkmanBetween(String value1, String value2) {
            addCriterion("demander_linkman between", value1, value2, "demanderLinkman");
            return (Criteria) this;
        }

        public Criteria andDemanderLinkmanNotBetween(String value1, String value2) {
            addCriterion("demander_linkman not between", value1, value2, "demanderLinkman");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrIsNull() {
            addCriterion("supplier_addr is null");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrIsNotNull() {
            addCriterion("supplier_addr is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrEqualTo(String value) {
            addCriterion("supplier_addr =", value, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrNotEqualTo(String value) {
            addCriterion("supplier_addr <>", value, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrGreaterThan(String value) {
            addCriterion("supplier_addr >", value, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_addr >=", value, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrLessThan(String value) {
            addCriterion("supplier_addr <", value, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrLessThanOrEqualTo(String value) {
            addCriterion("supplier_addr <=", value, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrLike(String value) {
            addCriterion("supplier_addr like", value, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrNotLike(String value) {
            addCriterion("supplier_addr not like", value, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrIn(List<String> values) {
            addCriterion("supplier_addr in", values, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrNotIn(List<String> values) {
            addCriterion("supplier_addr not in", values, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrBetween(String value1, String value2) {
            addCriterion("supplier_addr between", value1, value2, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrNotBetween(String value1, String value2) {
            addCriterion("supplier_addr not between", value1, value2, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andDemanderAddrIsNull() {
            addCriterion("demander_addr is null");
            return (Criteria) this;
        }

        public Criteria andDemanderAddrIsNotNull() {
            addCriterion("demander_addr is not null");
            return (Criteria) this;
        }

        public Criteria andDemanderAddrEqualTo(String value) {
            addCriterion("demander_addr =", value, "demanderAddr");
            return (Criteria) this;
        }

        public Criteria andDemanderAddrNotEqualTo(String value) {
            addCriterion("demander_addr <>", value, "demanderAddr");
            return (Criteria) this;
        }

        public Criteria andDemanderAddrGreaterThan(String value) {
            addCriterion("demander_addr >", value, "demanderAddr");
            return (Criteria) this;
        }

        public Criteria andDemanderAddrGreaterThanOrEqualTo(String value) {
            addCriterion("demander_addr >=", value, "demanderAddr");
            return (Criteria) this;
        }

        public Criteria andDemanderAddrLessThan(String value) {
            addCriterion("demander_addr <", value, "demanderAddr");
            return (Criteria) this;
        }

        public Criteria andDemanderAddrLessThanOrEqualTo(String value) {
            addCriterion("demander_addr <=", value, "demanderAddr");
            return (Criteria) this;
        }

        public Criteria andDemanderAddrLike(String value) {
            addCriterion("demander_addr like", value, "demanderAddr");
            return (Criteria) this;
        }

        public Criteria andDemanderAddrNotLike(String value) {
            addCriterion("demander_addr not like", value, "demanderAddr");
            return (Criteria) this;
        }

        public Criteria andDemanderAddrIn(List<String> values) {
            addCriterion("demander_addr in", values, "demanderAddr");
            return (Criteria) this;
        }

        public Criteria andDemanderAddrNotIn(List<String> values) {
            addCriterion("demander_addr not in", values, "demanderAddr");
            return (Criteria) this;
        }

        public Criteria andDemanderAddrBetween(String value1, String value2) {
            addCriterion("demander_addr between", value1, value2, "demanderAddr");
            return (Criteria) this;
        }

        public Criteria andDemanderAddrNotBetween(String value1, String value2) {
            addCriterion("demander_addr not between", value1, value2, "demanderAddr");
            return (Criteria) this;
        }

        public Criteria andSuppilerPhoneIsNull() {
            addCriterion("suppiler_phone is null");
            return (Criteria) this;
        }

        public Criteria andSuppilerPhoneIsNotNull() {
            addCriterion("suppiler_phone is not null");
            return (Criteria) this;
        }

        public Criteria andSuppilerPhoneEqualTo(String value) {
            addCriterion("suppiler_phone =", value, "suppilerPhone");
            return (Criteria) this;
        }

        public Criteria andSuppilerPhoneNotEqualTo(String value) {
            addCriterion("suppiler_phone <>", value, "suppilerPhone");
            return (Criteria) this;
        }

        public Criteria andSuppilerPhoneGreaterThan(String value) {
            addCriterion("suppiler_phone >", value, "suppilerPhone");
            return (Criteria) this;
        }

        public Criteria andSuppilerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("suppiler_phone >=", value, "suppilerPhone");
            return (Criteria) this;
        }

        public Criteria andSuppilerPhoneLessThan(String value) {
            addCriterion("suppiler_phone <", value, "suppilerPhone");
            return (Criteria) this;
        }

        public Criteria andSuppilerPhoneLessThanOrEqualTo(String value) {
            addCriterion("suppiler_phone <=", value, "suppilerPhone");
            return (Criteria) this;
        }

        public Criteria andSuppilerPhoneLike(String value) {
            addCriterion("suppiler_phone like", value, "suppilerPhone");
            return (Criteria) this;
        }

        public Criteria andSuppilerPhoneNotLike(String value) {
            addCriterion("suppiler_phone not like", value, "suppilerPhone");
            return (Criteria) this;
        }

        public Criteria andSuppilerPhoneIn(List<String> values) {
            addCriterion("suppiler_phone in", values, "suppilerPhone");
            return (Criteria) this;
        }

        public Criteria andSuppilerPhoneNotIn(List<String> values) {
            addCriterion("suppiler_phone not in", values, "suppilerPhone");
            return (Criteria) this;
        }

        public Criteria andSuppilerPhoneBetween(String value1, String value2) {
            addCriterion("suppiler_phone between", value1, value2, "suppilerPhone");
            return (Criteria) this;
        }

        public Criteria andSuppilerPhoneNotBetween(String value1, String value2) {
            addCriterion("suppiler_phone not between", value1, value2, "suppilerPhone");
            return (Criteria) this;
        }

        public Criteria andDemanderPhoneIsNull() {
            addCriterion("demander_phone is null");
            return (Criteria) this;
        }

        public Criteria andDemanderPhoneIsNotNull() {
            addCriterion("demander_phone is not null");
            return (Criteria) this;
        }

        public Criteria andDemanderPhoneEqualTo(String value) {
            addCriterion("demander_phone =", value, "demanderPhone");
            return (Criteria) this;
        }

        public Criteria andDemanderPhoneNotEqualTo(String value) {
            addCriterion("demander_phone <>", value, "demanderPhone");
            return (Criteria) this;
        }

        public Criteria andDemanderPhoneGreaterThan(String value) {
            addCriterion("demander_phone >", value, "demanderPhone");
            return (Criteria) this;
        }

        public Criteria andDemanderPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("demander_phone >=", value, "demanderPhone");
            return (Criteria) this;
        }

        public Criteria andDemanderPhoneLessThan(String value) {
            addCriterion("demander_phone <", value, "demanderPhone");
            return (Criteria) this;
        }

        public Criteria andDemanderPhoneLessThanOrEqualTo(String value) {
            addCriterion("demander_phone <=", value, "demanderPhone");
            return (Criteria) this;
        }

        public Criteria andDemanderPhoneLike(String value) {
            addCriterion("demander_phone like", value, "demanderPhone");
            return (Criteria) this;
        }

        public Criteria andDemanderPhoneNotLike(String value) {
            addCriterion("demander_phone not like", value, "demanderPhone");
            return (Criteria) this;
        }

        public Criteria andDemanderPhoneIn(List<String> values) {
            addCriterion("demander_phone in", values, "demanderPhone");
            return (Criteria) this;
        }

        public Criteria andDemanderPhoneNotIn(List<String> values) {
            addCriterion("demander_phone not in", values, "demanderPhone");
            return (Criteria) this;
        }

        public Criteria andDemanderPhoneBetween(String value1, String value2) {
            addCriterion("demander_phone between", value1, value2, "demanderPhone");
            return (Criteria) this;
        }

        public Criteria andDemanderPhoneNotBetween(String value1, String value2) {
            addCriterion("demander_phone not between", value1, value2, "demanderPhone");
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

        public Criteria andOperatorUserIdIsNull() {
            addCriterion("operator_user_id is null");
            return (Criteria) this;
        }

        public Criteria andOperatorUserIdIsNotNull() {
            addCriterion("operator_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorUserIdEqualTo(Integer value) {
            addCriterion("operator_user_id =", value, "operatorUserId");
            return (Criteria) this;
        }

        public Criteria andOperatorUserIdNotEqualTo(Integer value) {
            addCriterion("operator_user_id <>", value, "operatorUserId");
            return (Criteria) this;
        }

        public Criteria andOperatorUserIdGreaterThan(Integer value) {
            addCriterion("operator_user_id >", value, "operatorUserId");
            return (Criteria) this;
        }

        public Criteria andOperatorUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("operator_user_id >=", value, "operatorUserId");
            return (Criteria) this;
        }

        public Criteria andOperatorUserIdLessThan(Integer value) {
            addCriterion("operator_user_id <", value, "operatorUserId");
            return (Criteria) this;
        }

        public Criteria andOperatorUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("operator_user_id <=", value, "operatorUserId");
            return (Criteria) this;
        }

        public Criteria andOperatorUserIdIn(List<Integer> values) {
            addCriterion("operator_user_id in", values, "operatorUserId");
            return (Criteria) this;
        }

        public Criteria andOperatorUserIdNotIn(List<Integer> values) {
            addCriterion("operator_user_id not in", values, "operatorUserId");
            return (Criteria) this;
        }

        public Criteria andOperatorUserIdBetween(Integer value1, Integer value2) {
            addCriterion("operator_user_id between", value1, value2, "operatorUserId");
            return (Criteria) this;
        }

        public Criteria andOperatorUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("operator_user_id not between", value1, value2, "operatorUserId");
            return (Criteria) this;
        }

        public Criteria andOperateTimeIsNull() {
            addCriterion("operate_time is null");
            return (Criteria) this;
        }

        public Criteria andOperateTimeIsNotNull() {
            addCriterion("operate_time is not null");
            return (Criteria) this;
        }

        public Criteria andOperateTimeEqualTo(Date value) {
            addCriterion("operate_time =", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeNotEqualTo(Date value) {
            addCriterion("operate_time <>", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeGreaterThan(Date value) {
            addCriterion("operate_time >", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("operate_time >=", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeLessThan(Date value) {
            addCriterion("operate_time <", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeLessThanOrEqualTo(Date value) {
            addCriterion("operate_time <=", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeIn(List<Date> values) {
            addCriterion("operate_time in", values, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeNotIn(List<Date> values) {
            addCriterion("operate_time not in", values, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeBetween(Date value1, Date value2) {
            addCriterion("operate_time between", value1, value2, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeNotBetween(Date value1, Date value2) {
            addCriterion("operate_time not between", value1, value2, "operateTime");
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