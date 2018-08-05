package com.deepsoft.haolifa.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlowStepExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FlowStepExample() {
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

        public Criteria andStepIdIsNull() {
            addCriterion("step_id is null");
            return (Criteria) this;
        }

        public Criteria andStepIdIsNotNull() {
            addCriterion("step_id is not null");
            return (Criteria) this;
        }

        public Criteria andStepIdEqualTo(Integer value) {
            addCriterion("step_id =", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdNotEqualTo(Integer value) {
            addCriterion("step_id <>", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdGreaterThan(Integer value) {
            addCriterion("step_id >", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("step_id >=", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdLessThan(Integer value) {
            addCriterion("step_id <", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdLessThanOrEqualTo(Integer value) {
            addCriterion("step_id <=", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdIn(List<Integer> values) {
            addCriterion("step_id in", values, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdNotIn(List<Integer> values) {
            addCriterion("step_id not in", values, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdBetween(Integer value1, Integer value2) {
            addCriterion("step_id between", value1, value2, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdNotBetween(Integer value1, Integer value2) {
            addCriterion("step_id not between", value1, value2, "stepId");
            return (Criteria) this;
        }

        public Criteria andNextStepIdIsNull() {
            addCriterion("next_step_id is null");
            return (Criteria) this;
        }

        public Criteria andNextStepIdIsNotNull() {
            addCriterion("next_step_id is not null");
            return (Criteria) this;
        }

        public Criteria andNextStepIdEqualTo(Integer value) {
            addCriterion("next_step_id =", value, "nextStepId");
            return (Criteria) this;
        }

        public Criteria andNextStepIdNotEqualTo(Integer value) {
            addCriterion("next_step_id <>", value, "nextStepId");
            return (Criteria) this;
        }

        public Criteria andNextStepIdGreaterThan(Integer value) {
            addCriterion("next_step_id >", value, "nextStepId");
            return (Criteria) this;
        }

        public Criteria andNextStepIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("next_step_id >=", value, "nextStepId");
            return (Criteria) this;
        }

        public Criteria andNextStepIdLessThan(Integer value) {
            addCriterion("next_step_id <", value, "nextStepId");
            return (Criteria) this;
        }

        public Criteria andNextStepIdLessThanOrEqualTo(Integer value) {
            addCriterion("next_step_id <=", value, "nextStepId");
            return (Criteria) this;
        }

        public Criteria andNextStepIdIn(List<Integer> values) {
            addCriterion("next_step_id in", values, "nextStepId");
            return (Criteria) this;
        }

        public Criteria andNextStepIdNotIn(List<Integer> values) {
            addCriterion("next_step_id not in", values, "nextStepId");
            return (Criteria) this;
        }

        public Criteria andNextStepIdBetween(Integer value1, Integer value2) {
            addCriterion("next_step_id between", value1, value2, "nextStepId");
            return (Criteria) this;
        }

        public Criteria andNextStepIdNotBetween(Integer value1, Integer value2) {
            addCriterion("next_step_id not between", value1, value2, "nextStepId");
            return (Criteria) this;
        }

        public Criteria andPreStepIdIsNull() {
            addCriterion("pre_step_id is null");
            return (Criteria) this;
        }

        public Criteria andPreStepIdIsNotNull() {
            addCriterion("pre_step_id is not null");
            return (Criteria) this;
        }

        public Criteria andPreStepIdEqualTo(Integer value) {
            addCriterion("pre_step_id =", value, "preStepId");
            return (Criteria) this;
        }

        public Criteria andPreStepIdNotEqualTo(Integer value) {
            addCriterion("pre_step_id <>", value, "preStepId");
            return (Criteria) this;
        }

        public Criteria andPreStepIdGreaterThan(Integer value) {
            addCriterion("pre_step_id >", value, "preStepId");
            return (Criteria) this;
        }

        public Criteria andPreStepIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pre_step_id >=", value, "preStepId");
            return (Criteria) this;
        }

        public Criteria andPreStepIdLessThan(Integer value) {
            addCriterion("pre_step_id <", value, "preStepId");
            return (Criteria) this;
        }

        public Criteria andPreStepIdLessThanOrEqualTo(Integer value) {
            addCriterion("pre_step_id <=", value, "preStepId");
            return (Criteria) this;
        }

        public Criteria andPreStepIdIn(List<Integer> values) {
            addCriterion("pre_step_id in", values, "preStepId");
            return (Criteria) this;
        }

        public Criteria andPreStepIdNotIn(List<Integer> values) {
            addCriterion("pre_step_id not in", values, "preStepId");
            return (Criteria) this;
        }

        public Criteria andPreStepIdBetween(Integer value1, Integer value2) {
            addCriterion("pre_step_id between", value1, value2, "preStepId");
            return (Criteria) this;
        }

        public Criteria andPreStepIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pre_step_id not between", value1, value2, "preStepId");
            return (Criteria) this;
        }

        public Criteria andGotoStepIdIsNull() {
            addCriterion("goto_step_id is null");
            return (Criteria) this;
        }

        public Criteria andGotoStepIdIsNotNull() {
            addCriterion("goto_step_id is not null");
            return (Criteria) this;
        }

        public Criteria andGotoStepIdEqualTo(Integer value) {
            addCriterion("goto_step_id =", value, "gotoStepId");
            return (Criteria) this;
        }

        public Criteria andGotoStepIdNotEqualTo(Integer value) {
            addCriterion("goto_step_id <>", value, "gotoStepId");
            return (Criteria) this;
        }

        public Criteria andGotoStepIdGreaterThan(Integer value) {
            addCriterion("goto_step_id >", value, "gotoStepId");
            return (Criteria) this;
        }

        public Criteria andGotoStepIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goto_step_id >=", value, "gotoStepId");
            return (Criteria) this;
        }

        public Criteria andGotoStepIdLessThan(Integer value) {
            addCriterion("goto_step_id <", value, "gotoStepId");
            return (Criteria) this;
        }

        public Criteria andGotoStepIdLessThanOrEqualTo(Integer value) {
            addCriterion("goto_step_id <=", value, "gotoStepId");
            return (Criteria) this;
        }

        public Criteria andGotoStepIdIn(List<Integer> values) {
            addCriterion("goto_step_id in", values, "gotoStepId");
            return (Criteria) this;
        }

        public Criteria andGotoStepIdNotIn(List<Integer> values) {
            addCriterion("goto_step_id not in", values, "gotoStepId");
            return (Criteria) this;
        }

        public Criteria andGotoStepIdBetween(Integer value1, Integer value2) {
            addCriterion("goto_step_id between", value1, value2, "gotoStepId");
            return (Criteria) this;
        }

        public Criteria andGotoStepIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goto_step_id not between", value1, value2, "gotoStepId");
            return (Criteria) this;
        }

        public Criteria andStepOrderIsNull() {
            addCriterion("step_order is null");
            return (Criteria) this;
        }

        public Criteria andStepOrderIsNotNull() {
            addCriterion("step_order is not null");
            return (Criteria) this;
        }

        public Criteria andStepOrderEqualTo(Integer value) {
            addCriterion("step_order =", value, "stepOrder");
            return (Criteria) this;
        }

        public Criteria andStepOrderNotEqualTo(Integer value) {
            addCriterion("step_order <>", value, "stepOrder");
            return (Criteria) this;
        }

        public Criteria andStepOrderGreaterThan(Integer value) {
            addCriterion("step_order >", value, "stepOrder");
            return (Criteria) this;
        }

        public Criteria andStepOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("step_order >=", value, "stepOrder");
            return (Criteria) this;
        }

        public Criteria andStepOrderLessThan(Integer value) {
            addCriterion("step_order <", value, "stepOrder");
            return (Criteria) this;
        }

        public Criteria andStepOrderLessThanOrEqualTo(Integer value) {
            addCriterion("step_order <=", value, "stepOrder");
            return (Criteria) this;
        }

        public Criteria andStepOrderIn(List<Integer> values) {
            addCriterion("step_order in", values, "stepOrder");
            return (Criteria) this;
        }

        public Criteria andStepOrderNotIn(List<Integer> values) {
            addCriterion("step_order not in", values, "stepOrder");
            return (Criteria) this;
        }

        public Criteria andStepOrderBetween(Integer value1, Integer value2) {
            addCriterion("step_order between", value1, value2, "stepOrder");
            return (Criteria) this;
        }

        public Criteria andStepOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("step_order not between", value1, value2, "stepOrder");
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