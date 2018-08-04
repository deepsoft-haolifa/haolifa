package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MaterialReceiveRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MaterialReceiveRecordExample() {
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

        public Criteria andReceiveNoIsNull() {
            addCriterion("receive_no is null");
            return (Criteria) this;
        }

        public Criteria andReceiveNoIsNotNull() {
            addCriterion("receive_no is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveNoEqualTo(String value) {
            addCriterion("receive_no =", value, "receiveNo");
            return (Criteria) this;
        }

        public Criteria andReceiveNoNotEqualTo(String value) {
            addCriterion("receive_no <>", value, "receiveNo");
            return (Criteria) this;
        }

        public Criteria andReceiveNoGreaterThan(String value) {
            addCriterion("receive_no >", value, "receiveNo");
            return (Criteria) this;
        }

        public Criteria andReceiveNoGreaterThanOrEqualTo(String value) {
            addCriterion("receive_no >=", value, "receiveNo");
            return (Criteria) this;
        }

        public Criteria andReceiveNoLessThan(String value) {
            addCriterion("receive_no <", value, "receiveNo");
            return (Criteria) this;
        }

        public Criteria andReceiveNoLessThanOrEqualTo(String value) {
            addCriterion("receive_no <=", value, "receiveNo");
            return (Criteria) this;
        }

        public Criteria andReceiveNoLike(String value) {
            addCriterion("receive_no like", value, "receiveNo");
            return (Criteria) this;
        }

        public Criteria andReceiveNoNotLike(String value) {
            addCriterion("receive_no not like", value, "receiveNo");
            return (Criteria) this;
        }

        public Criteria andReceiveNoIn(List<String> values) {
            addCriterion("receive_no in", values, "receiveNo");
            return (Criteria) this;
        }

        public Criteria andReceiveNoNotIn(List<String> values) {
            addCriterion("receive_no not in", values, "receiveNo");
            return (Criteria) this;
        }

        public Criteria andReceiveNoBetween(String value1, String value2) {
            addCriterion("receive_no between", value1, value2, "receiveNo");
            return (Criteria) this;
        }

        public Criteria andReceiveNoNotBetween(String value1, String value2) {
            addCriterion("receive_no not between", value1, value2, "receiveNo");
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

        public Criteria andReceiveDepartmentIsNull() {
            addCriterion("receive_department is null");
            return (Criteria) this;
        }

        public Criteria andReceiveDepartmentIsNotNull() {
            addCriterion("receive_department is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveDepartmentEqualTo(String value) {
            addCriterion("receive_department =", value, "receiveDepartment");
            return (Criteria) this;
        }

        public Criteria andReceiveDepartmentNotEqualTo(String value) {
            addCriterion("receive_department <>", value, "receiveDepartment");
            return (Criteria) this;
        }

        public Criteria andReceiveDepartmentGreaterThan(String value) {
            addCriterion("receive_department >", value, "receiveDepartment");
            return (Criteria) this;
        }

        public Criteria andReceiveDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("receive_department >=", value, "receiveDepartment");
            return (Criteria) this;
        }

        public Criteria andReceiveDepartmentLessThan(String value) {
            addCriterion("receive_department <", value, "receiveDepartment");
            return (Criteria) this;
        }

        public Criteria andReceiveDepartmentLessThanOrEqualTo(String value) {
            addCriterion("receive_department <=", value, "receiveDepartment");
            return (Criteria) this;
        }

        public Criteria andReceiveDepartmentLike(String value) {
            addCriterion("receive_department like", value, "receiveDepartment");
            return (Criteria) this;
        }

        public Criteria andReceiveDepartmentNotLike(String value) {
            addCriterion("receive_department not like", value, "receiveDepartment");
            return (Criteria) this;
        }

        public Criteria andReceiveDepartmentIn(List<String> values) {
            addCriterion("receive_department in", values, "receiveDepartment");
            return (Criteria) this;
        }

        public Criteria andReceiveDepartmentNotIn(List<String> values) {
            addCriterion("receive_department not in", values, "receiveDepartment");
            return (Criteria) this;
        }

        public Criteria andReceiveDepartmentBetween(String value1, String value2) {
            addCriterion("receive_department between", value1, value2, "receiveDepartment");
            return (Criteria) this;
        }

        public Criteria andReceiveDepartmentNotBetween(String value1, String value2) {
            addCriterion("receive_department not between", value1, value2, "receiveDepartment");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdIsNull() {
            addCriterion("receive_user_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdIsNotNull() {
            addCriterion("receive_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdEqualTo(String value) {
            addCriterion("receive_user_id =", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdNotEqualTo(String value) {
            addCriterion("receive_user_id <>", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdGreaterThan(String value) {
            addCriterion("receive_user_id >", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("receive_user_id >=", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdLessThan(String value) {
            addCriterion("receive_user_id <", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdLessThanOrEqualTo(String value) {
            addCriterion("receive_user_id <=", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdLike(String value) {
            addCriterion("receive_user_id like", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdNotLike(String value) {
            addCriterion("receive_user_id not like", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdIn(List<String> values) {
            addCriterion("receive_user_id in", values, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdNotIn(List<String> values) {
            addCriterion("receive_user_id not in", values, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdBetween(String value1, String value2) {
            addCriterion("receive_user_id between", value1, value2, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdNotBetween(String value1, String value2) {
            addCriterion("receive_user_id not between", value1, value2, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIsNull() {
            addCriterion("material_id is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIsNotNull() {
            addCriterion("material_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdEqualTo(Integer value) {
            addCriterion("material_id =", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotEqualTo(Integer value) {
            addCriterion("material_id <>", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThan(Integer value) {
            addCriterion("material_id >", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("material_id >=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThan(Integer value) {
            addCriterion("material_id <", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThanOrEqualTo(Integer value) {
            addCriterion("material_id <=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIn(List<Integer> values) {
            addCriterion("material_id in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotIn(List<Integer> values) {
            addCriterion("material_id not in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdBetween(Integer value1, Integer value2) {
            addCriterion("material_id between", value1, value2, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotBetween(Integer value1, Integer value2) {
            addCriterion("material_id not between", value1, value2, "materialId");
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

        public Criteria andMaterialPriceIsNull() {
            addCriterion("material_price is null");
            return (Criteria) this;
        }

        public Criteria andMaterialPriceIsNotNull() {
            addCriterion("material_price is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialPriceEqualTo(BigDecimal value) {
            addCriterion("material_price =", value, "materialPrice");
            return (Criteria) this;
        }

        public Criteria andMaterialPriceNotEqualTo(BigDecimal value) {
            addCriterion("material_price <>", value, "materialPrice");
            return (Criteria) this;
        }

        public Criteria andMaterialPriceGreaterThan(BigDecimal value) {
            addCriterion("material_price >", value, "materialPrice");
            return (Criteria) this;
        }

        public Criteria andMaterialPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("material_price >=", value, "materialPrice");
            return (Criteria) this;
        }

        public Criteria andMaterialPriceLessThan(BigDecimal value) {
            addCriterion("material_price <", value, "materialPrice");
            return (Criteria) this;
        }

        public Criteria andMaterialPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("material_price <=", value, "materialPrice");
            return (Criteria) this;
        }

        public Criteria andMaterialPriceIn(List<BigDecimal> values) {
            addCriterion("material_price in", values, "materialPrice");
            return (Criteria) this;
        }

        public Criteria andMaterialPriceNotIn(List<BigDecimal> values) {
            addCriterion("material_price not in", values, "materialPrice");
            return (Criteria) this;
        }

        public Criteria andMaterialPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("material_price between", value1, value2, "materialPrice");
            return (Criteria) this;
        }

        public Criteria andMaterialPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("material_price not between", value1, value2, "materialPrice");
            return (Criteria) this;
        }

        public Criteria andStartMaterialCountIsNull() {
            addCriterion("start_material_count is null");
            return (Criteria) this;
        }

        public Criteria andStartMaterialCountIsNotNull() {
            addCriterion("start_material_count is not null");
            return (Criteria) this;
        }

        public Criteria andStartMaterialCountEqualTo(String value) {
            addCriterion("start_material_count =", value, "startMaterialCount");
            return (Criteria) this;
        }

        public Criteria andStartMaterialCountNotEqualTo(String value) {
            addCriterion("start_material_count <>", value, "startMaterialCount");
            return (Criteria) this;
        }

        public Criteria andStartMaterialCountGreaterThan(String value) {
            addCriterion("start_material_count >", value, "startMaterialCount");
            return (Criteria) this;
        }

        public Criteria andStartMaterialCountGreaterThanOrEqualTo(String value) {
            addCriterion("start_material_count >=", value, "startMaterialCount");
            return (Criteria) this;
        }

        public Criteria andStartMaterialCountLessThan(String value) {
            addCriterion("start_material_count <", value, "startMaterialCount");
            return (Criteria) this;
        }

        public Criteria andStartMaterialCountLessThanOrEqualTo(String value) {
            addCriterion("start_material_count <=", value, "startMaterialCount");
            return (Criteria) this;
        }

        public Criteria andStartMaterialCountLike(String value) {
            addCriterion("start_material_count like", value, "startMaterialCount");
            return (Criteria) this;
        }

        public Criteria andStartMaterialCountNotLike(String value) {
            addCriterion("start_material_count not like", value, "startMaterialCount");
            return (Criteria) this;
        }

        public Criteria andStartMaterialCountIn(List<String> values) {
            addCriterion("start_material_count in", values, "startMaterialCount");
            return (Criteria) this;
        }

        public Criteria andStartMaterialCountNotIn(List<String> values) {
            addCriterion("start_material_count not in", values, "startMaterialCount");
            return (Criteria) this;
        }

        public Criteria andStartMaterialCountBetween(String value1, String value2) {
            addCriterion("start_material_count between", value1, value2, "startMaterialCount");
            return (Criteria) this;
        }

        public Criteria andStartMaterialCountNotBetween(String value1, String value2) {
            addCriterion("start_material_count not between", value1, value2, "startMaterialCount");
            return (Criteria) this;
        }

        public Criteria andStartMaterialAmountIsNull() {
            addCriterion("start_material_amount is null");
            return (Criteria) this;
        }

        public Criteria andStartMaterialAmountIsNotNull() {
            addCriterion("start_material_amount is not null");
            return (Criteria) this;
        }

        public Criteria andStartMaterialAmountEqualTo(BigDecimal value) {
            addCriterion("start_material_amount =", value, "startMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andStartMaterialAmountNotEqualTo(BigDecimal value) {
            addCriterion("start_material_amount <>", value, "startMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andStartMaterialAmountGreaterThan(BigDecimal value) {
            addCriterion("start_material_amount >", value, "startMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andStartMaterialAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("start_material_amount >=", value, "startMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andStartMaterialAmountLessThan(BigDecimal value) {
            addCriterion("start_material_amount <", value, "startMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andStartMaterialAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("start_material_amount <=", value, "startMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andStartMaterialAmountIn(List<BigDecimal> values) {
            addCriterion("start_material_amount in", values, "startMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andStartMaterialAmountNotIn(List<BigDecimal> values) {
            addCriterion("start_material_amount not in", values, "startMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andStartMaterialAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("start_material_amount between", value1, value2, "startMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andStartMaterialAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("start_material_amount not between", value1, value2, "startMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andActualMaterialCountIsNull() {
            addCriterion("actual_material_count is null");
            return (Criteria) this;
        }

        public Criteria andActualMaterialCountIsNotNull() {
            addCriterion("actual_material_count is not null");
            return (Criteria) this;
        }

        public Criteria andActualMaterialCountEqualTo(String value) {
            addCriterion("actual_material_count =", value, "actualMaterialCount");
            return (Criteria) this;
        }

        public Criteria andActualMaterialCountNotEqualTo(String value) {
            addCriterion("actual_material_count <>", value, "actualMaterialCount");
            return (Criteria) this;
        }

        public Criteria andActualMaterialCountGreaterThan(String value) {
            addCriterion("actual_material_count >", value, "actualMaterialCount");
            return (Criteria) this;
        }

        public Criteria andActualMaterialCountGreaterThanOrEqualTo(String value) {
            addCriterion("actual_material_count >=", value, "actualMaterialCount");
            return (Criteria) this;
        }

        public Criteria andActualMaterialCountLessThan(String value) {
            addCriterion("actual_material_count <", value, "actualMaterialCount");
            return (Criteria) this;
        }

        public Criteria andActualMaterialCountLessThanOrEqualTo(String value) {
            addCriterion("actual_material_count <=", value, "actualMaterialCount");
            return (Criteria) this;
        }

        public Criteria andActualMaterialCountLike(String value) {
            addCriterion("actual_material_count like", value, "actualMaterialCount");
            return (Criteria) this;
        }

        public Criteria andActualMaterialCountNotLike(String value) {
            addCriterion("actual_material_count not like", value, "actualMaterialCount");
            return (Criteria) this;
        }

        public Criteria andActualMaterialCountIn(List<String> values) {
            addCriterion("actual_material_count in", values, "actualMaterialCount");
            return (Criteria) this;
        }

        public Criteria andActualMaterialCountNotIn(List<String> values) {
            addCriterion("actual_material_count not in", values, "actualMaterialCount");
            return (Criteria) this;
        }

        public Criteria andActualMaterialCountBetween(String value1, String value2) {
            addCriterion("actual_material_count between", value1, value2, "actualMaterialCount");
            return (Criteria) this;
        }

        public Criteria andActualMaterialCountNotBetween(String value1, String value2) {
            addCriterion("actual_material_count not between", value1, value2, "actualMaterialCount");
            return (Criteria) this;
        }

        public Criteria andActualMaterialAmountIsNull() {
            addCriterion("actual_material_amount is null");
            return (Criteria) this;
        }

        public Criteria andActualMaterialAmountIsNotNull() {
            addCriterion("actual_material_amount is not null");
            return (Criteria) this;
        }

        public Criteria andActualMaterialAmountEqualTo(BigDecimal value) {
            addCriterion("actual_material_amount =", value, "actualMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andActualMaterialAmountNotEqualTo(BigDecimal value) {
            addCriterion("actual_material_amount <>", value, "actualMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andActualMaterialAmountGreaterThan(BigDecimal value) {
            addCriterion("actual_material_amount >", value, "actualMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andActualMaterialAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_material_amount >=", value, "actualMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andActualMaterialAmountLessThan(BigDecimal value) {
            addCriterion("actual_material_amount <", value, "actualMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andActualMaterialAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_material_amount <=", value, "actualMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andActualMaterialAmountIn(List<BigDecimal> values) {
            addCriterion("actual_material_amount in", values, "actualMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andActualMaterialAmountNotIn(List<BigDecimal> values) {
            addCriterion("actual_material_amount not in", values, "actualMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andActualMaterialAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_material_amount between", value1, value2, "actualMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andActualMaterialAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_material_amount not between", value1, value2, "actualMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andEndMaterialCountIsNull() {
            addCriterion("end_material_count is null");
            return (Criteria) this;
        }

        public Criteria andEndMaterialCountIsNotNull() {
            addCriterion("end_material_count is not null");
            return (Criteria) this;
        }

        public Criteria andEndMaterialCountEqualTo(String value) {
            addCriterion("end_material_count =", value, "endMaterialCount");
            return (Criteria) this;
        }

        public Criteria andEndMaterialCountNotEqualTo(String value) {
            addCriterion("end_material_count <>", value, "endMaterialCount");
            return (Criteria) this;
        }

        public Criteria andEndMaterialCountGreaterThan(String value) {
            addCriterion("end_material_count >", value, "endMaterialCount");
            return (Criteria) this;
        }

        public Criteria andEndMaterialCountGreaterThanOrEqualTo(String value) {
            addCriterion("end_material_count >=", value, "endMaterialCount");
            return (Criteria) this;
        }

        public Criteria andEndMaterialCountLessThan(String value) {
            addCriterion("end_material_count <", value, "endMaterialCount");
            return (Criteria) this;
        }

        public Criteria andEndMaterialCountLessThanOrEqualTo(String value) {
            addCriterion("end_material_count <=", value, "endMaterialCount");
            return (Criteria) this;
        }

        public Criteria andEndMaterialCountLike(String value) {
            addCriterion("end_material_count like", value, "endMaterialCount");
            return (Criteria) this;
        }

        public Criteria andEndMaterialCountNotLike(String value) {
            addCriterion("end_material_count not like", value, "endMaterialCount");
            return (Criteria) this;
        }

        public Criteria andEndMaterialCountIn(List<String> values) {
            addCriterion("end_material_count in", values, "endMaterialCount");
            return (Criteria) this;
        }

        public Criteria andEndMaterialCountNotIn(List<String> values) {
            addCriterion("end_material_count not in", values, "endMaterialCount");
            return (Criteria) this;
        }

        public Criteria andEndMaterialCountBetween(String value1, String value2) {
            addCriterion("end_material_count between", value1, value2, "endMaterialCount");
            return (Criteria) this;
        }

        public Criteria andEndMaterialCountNotBetween(String value1, String value2) {
            addCriterion("end_material_count not between", value1, value2, "endMaterialCount");
            return (Criteria) this;
        }

        public Criteria andEndMaterialAmountIsNull() {
            addCriterion("end_material_amount is null");
            return (Criteria) this;
        }

        public Criteria andEndMaterialAmountIsNotNull() {
            addCriterion("end_material_amount is not null");
            return (Criteria) this;
        }

        public Criteria andEndMaterialAmountEqualTo(BigDecimal value) {
            addCriterion("end_material_amount =", value, "endMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andEndMaterialAmountNotEqualTo(BigDecimal value) {
            addCriterion("end_material_amount <>", value, "endMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andEndMaterialAmountGreaterThan(BigDecimal value) {
            addCriterion("end_material_amount >", value, "endMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andEndMaterialAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("end_material_amount >=", value, "endMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andEndMaterialAmountLessThan(BigDecimal value) {
            addCriterion("end_material_amount <", value, "endMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andEndMaterialAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("end_material_amount <=", value, "endMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andEndMaterialAmountIn(List<BigDecimal> values) {
            addCriterion("end_material_amount in", values, "endMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andEndMaterialAmountNotIn(List<BigDecimal> values) {
            addCriterion("end_material_amount not in", values, "endMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andEndMaterialAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("end_material_amount between", value1, value2, "endMaterialAmount");
            return (Criteria) this;
        }

        public Criteria andEndMaterialAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("end_material_amount not between", value1, value2, "endMaterialAmount");
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