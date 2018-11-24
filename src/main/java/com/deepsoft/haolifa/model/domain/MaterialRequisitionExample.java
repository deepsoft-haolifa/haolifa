package com.deepsoft.haolifa.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MaterialRequisitionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MaterialRequisitionExample() {
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

        public Criteria andReceiveUserNameIsNull() {
            addCriterion("receive_user_name is null");
            return (Criteria) this;
        }

        public Criteria andReceiveUserNameIsNotNull() {
            addCriterion("receive_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveUserNameEqualTo(String value) {
            addCriterion("receive_user_name =", value, "receiveUserName");
            return (Criteria) this;
        }

        public Criteria andReceiveUserNameNotEqualTo(String value) {
            addCriterion("receive_user_name <>", value, "receiveUserName");
            return (Criteria) this;
        }

        public Criteria andReceiveUserNameGreaterThan(String value) {
            addCriterion("receive_user_name >", value, "receiveUserName");
            return (Criteria) this;
        }

        public Criteria andReceiveUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("receive_user_name >=", value, "receiveUserName");
            return (Criteria) this;
        }

        public Criteria andReceiveUserNameLessThan(String value) {
            addCriterion("receive_user_name <", value, "receiveUserName");
            return (Criteria) this;
        }

        public Criteria andReceiveUserNameLessThanOrEqualTo(String value) {
            addCriterion("receive_user_name <=", value, "receiveUserName");
            return (Criteria) this;
        }

        public Criteria andReceiveUserNameLike(String value) {
            addCriterion("receive_user_name like", value, "receiveUserName");
            return (Criteria) this;
        }

        public Criteria andReceiveUserNameNotLike(String value) {
            addCriterion("receive_user_name not like", value, "receiveUserName");
            return (Criteria) this;
        }

        public Criteria andReceiveUserNameIn(List<String> values) {
            addCriterion("receive_user_name in", values, "receiveUserName");
            return (Criteria) this;
        }

        public Criteria andReceiveUserNameNotIn(List<String> values) {
            addCriterion("receive_user_name not in", values, "receiveUserName");
            return (Criteria) this;
        }

        public Criteria andReceiveUserNameBetween(String value1, String value2) {
            addCriterion("receive_user_name between", value1, value2, "receiveUserName");
            return (Criteria) this;
        }

        public Criteria andReceiveUserNameNotBetween(String value1, String value2) {
            addCriterion("receive_user_name not between", value1, value2, "receiveUserName");
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