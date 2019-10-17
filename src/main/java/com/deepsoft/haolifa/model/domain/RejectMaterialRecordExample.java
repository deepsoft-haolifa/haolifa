package com.deepsoft.haolifa.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RejectMaterialRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RejectMaterialRecordExample() {
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

        public Criteria andRecordNoIsNull() {
            addCriterion("record_no is null");
            return (Criteria) this;
        }

        public Criteria andRecordNoIsNotNull() {
            addCriterion("record_no is not null");
            return (Criteria) this;
        }

        public Criteria andRecordNoEqualTo(String value) {
            addCriterion("record_no =", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoNotEqualTo(String value) {
            addCriterion("record_no <>", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoGreaterThan(String value) {
            addCriterion("record_no >", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoGreaterThanOrEqualTo(String value) {
            addCriterion("record_no >=", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoLessThan(String value) {
            addCriterion("record_no <", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoLessThanOrEqualTo(String value) {
            addCriterion("record_no <=", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoLike(String value) {
            addCriterion("record_no like", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoNotLike(String value) {
            addCriterion("record_no not like", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoIn(List<String> values) {
            addCriterion("record_no in", values, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoNotIn(List<String> values) {
            addCriterion("record_no not in", values, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoBetween(String value1, String value2) {
            addCriterion("record_no between", value1, value2, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoNotBetween(String value1, String value2) {
            addCriterion("record_no not between", value1, value2, "recordNo");
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

        public Criteria andBatchNumberIsNull() {
            addCriterion("batch_number is null");
            return (Criteria) this;
        }

        public Criteria andBatchNumberIsNotNull() {
            addCriterion("batch_number is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNumberEqualTo(String value) {
            addCriterion("batch_number =", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberNotEqualTo(String value) {
            addCriterion("batch_number <>", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberGreaterThan(String value) {
            addCriterion("batch_number >", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberGreaterThanOrEqualTo(String value) {
            addCriterion("batch_number >=", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberLessThan(String value) {
            addCriterion("batch_number <", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberLessThanOrEqualTo(String value) {
            addCriterion("batch_number <=", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberLike(String value) {
            addCriterion("batch_number like", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberNotLike(String value) {
            addCriterion("batch_number not like", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberIn(List<String> values) {
            addCriterion("batch_number in", values, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberNotIn(List<String> values) {
            addCriterion("batch_number not in", values, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberBetween(String value1, String value2) {
            addCriterion("batch_number between", value1, value2, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberNotBetween(String value1, String value2) {
            addCriterion("batch_number not between", value1, value2, "batchNumber");
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

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andAcceptNumberIsNull() {
            addCriterion("accept_number is null");
            return (Criteria) this;
        }

        public Criteria andAcceptNumberIsNotNull() {
            addCriterion("accept_number is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptNumberEqualTo(Integer value) {
            addCriterion("accept_number =", value, "acceptNumber");
            return (Criteria) this;
        }

        public Criteria andAcceptNumberNotEqualTo(Integer value) {
            addCriterion("accept_number <>", value, "acceptNumber");
            return (Criteria) this;
        }

        public Criteria andAcceptNumberGreaterThan(Integer value) {
            addCriterion("accept_number >", value, "acceptNumber");
            return (Criteria) this;
        }

        public Criteria andAcceptNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("accept_number >=", value, "acceptNumber");
            return (Criteria) this;
        }

        public Criteria andAcceptNumberLessThan(Integer value) {
            addCriterion("accept_number <", value, "acceptNumber");
            return (Criteria) this;
        }

        public Criteria andAcceptNumberLessThanOrEqualTo(Integer value) {
            addCriterion("accept_number <=", value, "acceptNumber");
            return (Criteria) this;
        }

        public Criteria andAcceptNumberIn(List<Integer> values) {
            addCriterion("accept_number in", values, "acceptNumber");
            return (Criteria) this;
        }

        public Criteria andAcceptNumberNotIn(List<Integer> values) {
            addCriterion("accept_number not in", values, "acceptNumber");
            return (Criteria) this;
        }

        public Criteria andAcceptNumberBetween(Integer value1, Integer value2) {
            addCriterion("accept_number between", value1, value2, "acceptNumber");
            return (Criteria) this;
        }

        public Criteria andAcceptNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("accept_number not between", value1, value2, "acceptNumber");
            return (Criteria) this;
        }

        public Criteria andEntrustNumberIsNull() {
            addCriterion("entrust_number is null");
            return (Criteria) this;
        }

        public Criteria andEntrustNumberIsNotNull() {
            addCriterion("entrust_number is not null");
            return (Criteria) this;
        }

        public Criteria andEntrustNumberEqualTo(Integer value) {
            addCriterion("entrust_number =", value, "entrustNumber");
            return (Criteria) this;
        }

        public Criteria andEntrustNumberNotEqualTo(Integer value) {
            addCriterion("entrust_number <>", value, "entrustNumber");
            return (Criteria) this;
        }

        public Criteria andEntrustNumberGreaterThan(Integer value) {
            addCriterion("entrust_number >", value, "entrustNumber");
            return (Criteria) this;
        }

        public Criteria andEntrustNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("entrust_number >=", value, "entrustNumber");
            return (Criteria) this;
        }

        public Criteria andEntrustNumberLessThan(Integer value) {
            addCriterion("entrust_number <", value, "entrustNumber");
            return (Criteria) this;
        }

        public Criteria andEntrustNumberLessThanOrEqualTo(Integer value) {
            addCriterion("entrust_number <=", value, "entrustNumber");
            return (Criteria) this;
        }

        public Criteria andEntrustNumberIn(List<Integer> values) {
            addCriterion("entrust_number in", values, "entrustNumber");
            return (Criteria) this;
        }

        public Criteria andEntrustNumberNotIn(List<Integer> values) {
            addCriterion("entrust_number not in", values, "entrustNumber");
            return (Criteria) this;
        }

        public Criteria andEntrustNumberBetween(Integer value1, Integer value2) {
            addCriterion("entrust_number between", value1, value2, "entrustNumber");
            return (Criteria) this;
        }

        public Criteria andEntrustNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("entrust_number not between", value1, value2, "entrustNumber");
            return (Criteria) this;
        }

        public Criteria andBackNumberIsNull() {
            addCriterion("back_number is null");
            return (Criteria) this;
        }

        public Criteria andBackNumberIsNotNull() {
            addCriterion("back_number is not null");
            return (Criteria) this;
        }

        public Criteria andBackNumberEqualTo(Integer value) {
            addCriterion("back_number =", value, "backNumber");
            return (Criteria) this;
        }

        public Criteria andBackNumberNotEqualTo(Integer value) {
            addCriterion("back_number <>", value, "backNumber");
            return (Criteria) this;
        }

        public Criteria andBackNumberGreaterThan(Integer value) {
            addCriterion("back_number >", value, "backNumber");
            return (Criteria) this;
        }

        public Criteria andBackNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("back_number >=", value, "backNumber");
            return (Criteria) this;
        }

        public Criteria andBackNumberLessThan(Integer value) {
            addCriterion("back_number <", value, "backNumber");
            return (Criteria) this;
        }

        public Criteria andBackNumberLessThanOrEqualTo(Integer value) {
            addCriterion("back_number <=", value, "backNumber");
            return (Criteria) this;
        }

        public Criteria andBackNumberIn(List<Integer> values) {
            addCriterion("back_number in", values, "backNumber");
            return (Criteria) this;
        }

        public Criteria andBackNumberNotIn(List<Integer> values) {
            addCriterion("back_number not in", values, "backNumber");
            return (Criteria) this;
        }

        public Criteria andBackNumberBetween(Integer value1, Integer value2) {
            addCriterion("back_number between", value1, value2, "backNumber");
            return (Criteria) this;
        }

        public Criteria andBackNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("back_number not between", value1, value2, "backNumber");
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

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andInspectIdIsNull() {
            addCriterion("inspect_id is null");
            return (Criteria) this;
        }

        public Criteria andInspectIdIsNotNull() {
            addCriterion("inspect_id is not null");
            return (Criteria) this;
        }

        public Criteria andInspectIdEqualTo(Long value) {
            addCriterion("inspect_id =", value, "inspectId");
            return (Criteria) this;
        }

        public Criteria andInspectIdNotEqualTo(Long value) {
            addCriterion("inspect_id <>", value, "inspectId");
            return (Criteria) this;
        }

        public Criteria andInspectIdGreaterThan(Long value) {
            addCriterion("inspect_id >", value, "inspectId");
            return (Criteria) this;
        }

        public Criteria andInspectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("inspect_id >=", value, "inspectId");
            return (Criteria) this;
        }

        public Criteria andInspectIdLessThan(Long value) {
            addCriterion("inspect_id <", value, "inspectId");
            return (Criteria) this;
        }

        public Criteria andInspectIdLessThanOrEqualTo(Long value) {
            addCriterion("inspect_id <=", value, "inspectId");
            return (Criteria) this;
        }

        public Criteria andInspectIdIn(List<Long> values) {
            addCriterion("inspect_id in", values, "inspectId");
            return (Criteria) this;
        }

        public Criteria andInspectIdNotIn(List<Long> values) {
            addCriterion("inspect_id not in", values, "inspectId");
            return (Criteria) this;
        }

        public Criteria andInspectIdBetween(Long value1, Long value2) {
            addCriterion("inspect_id between", value1, value2, "inspectId");
            return (Criteria) this;
        }

        public Criteria andInspectIdNotBetween(Long value1, Long value2) {
            addCriterion("inspect_id not between", value1, value2, "inspectId");
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