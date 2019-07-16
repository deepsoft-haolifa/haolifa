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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Integer value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Integer value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Integer value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Integer value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Integer> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Integer> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andPrevStepIdIsNull() {
            addCriterion("prev_step_id is null");
            return (Criteria) this;
        }

        public Criteria andPrevStepIdIsNotNull() {
            addCriterion("prev_step_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrevStepIdEqualTo(Integer value) {
            addCriterion("prev_step_id =", value, "prevStepId");
            return (Criteria) this;
        }

        public Criteria andPrevStepIdNotEqualTo(Integer value) {
            addCriterion("prev_step_id <>", value, "prevStepId");
            return (Criteria) this;
        }

        public Criteria andPrevStepIdGreaterThan(Integer value) {
            addCriterion("prev_step_id >", value, "prevStepId");
            return (Criteria) this;
        }

        public Criteria andPrevStepIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("prev_step_id >=", value, "prevStepId");
            return (Criteria) this;
        }

        public Criteria andPrevStepIdLessThan(Integer value) {
            addCriterion("prev_step_id <", value, "prevStepId");
            return (Criteria) this;
        }

        public Criteria andPrevStepIdLessThanOrEqualTo(Integer value) {
            addCriterion("prev_step_id <=", value, "prevStepId");
            return (Criteria) this;
        }

        public Criteria andPrevStepIdIn(List<Integer> values) {
            addCriterion("prev_step_id in", values, "prevStepId");
            return (Criteria) this;
        }

        public Criteria andPrevStepIdNotIn(List<Integer> values) {
            addCriterion("prev_step_id not in", values, "prevStepId");
            return (Criteria) this;
        }

        public Criteria andPrevStepIdBetween(Integer value1, Integer value2) {
            addCriterion("prev_step_id between", value1, value2, "prevStepId");
            return (Criteria) this;
        }

        public Criteria andPrevStepIdNotBetween(Integer value1, Integer value2) {
            addCriterion("prev_step_id not between", value1, value2, "prevStepId");
            return (Criteria) this;
        }

        public Criteria andConditionTrueIsNull() {
            addCriterion("condition_true is null");
            return (Criteria) this;
        }

        public Criteria andConditionTrueIsNotNull() {
            addCriterion("condition_true is not null");
            return (Criteria) this;
        }

        public Criteria andConditionTrueEqualTo(Integer value) {
            addCriterion("condition_true =", value, "conditionTrue");
            return (Criteria) this;
        }

        public Criteria andConditionTrueNotEqualTo(Integer value) {
            addCriterion("condition_true <>", value, "conditionTrue");
            return (Criteria) this;
        }

        public Criteria andConditionTrueGreaterThan(Integer value) {
            addCriterion("condition_true >", value, "conditionTrue");
            return (Criteria) this;
        }

        public Criteria andConditionTrueGreaterThanOrEqualTo(Integer value) {
            addCriterion("condition_true >=", value, "conditionTrue");
            return (Criteria) this;
        }

        public Criteria andConditionTrueLessThan(Integer value) {
            addCriterion("condition_true <", value, "conditionTrue");
            return (Criteria) this;
        }

        public Criteria andConditionTrueLessThanOrEqualTo(Integer value) {
            addCriterion("condition_true <=", value, "conditionTrue");
            return (Criteria) this;
        }

        public Criteria andConditionTrueIn(List<Integer> values) {
            addCriterion("condition_true in", values, "conditionTrue");
            return (Criteria) this;
        }

        public Criteria andConditionTrueNotIn(List<Integer> values) {
            addCriterion("condition_true not in", values, "conditionTrue");
            return (Criteria) this;
        }

        public Criteria andConditionTrueBetween(Integer value1, Integer value2) {
            addCriterion("condition_true between", value1, value2, "conditionTrue");
            return (Criteria) this;
        }

        public Criteria andConditionTrueNotBetween(Integer value1, Integer value2) {
            addCriterion("condition_true not between", value1, value2, "conditionTrue");
            return (Criteria) this;
        }

        public Criteria andConditionFalseIsNull() {
            addCriterion("condition_false is null");
            return (Criteria) this;
        }

        public Criteria andConditionFalseIsNotNull() {
            addCriterion("condition_false is not null");
            return (Criteria) this;
        }

        public Criteria andConditionFalseEqualTo(Integer value) {
            addCriterion("condition_false =", value, "conditionFalse");
            return (Criteria) this;
        }

        public Criteria andConditionFalseNotEqualTo(Integer value) {
            addCriterion("condition_false <>", value, "conditionFalse");
            return (Criteria) this;
        }

        public Criteria andConditionFalseGreaterThan(Integer value) {
            addCriterion("condition_false >", value, "conditionFalse");
            return (Criteria) this;
        }

        public Criteria andConditionFalseGreaterThanOrEqualTo(Integer value) {
            addCriterion("condition_false >=", value, "conditionFalse");
            return (Criteria) this;
        }

        public Criteria andConditionFalseLessThan(Integer value) {
            addCriterion("condition_false <", value, "conditionFalse");
            return (Criteria) this;
        }

        public Criteria andConditionFalseLessThanOrEqualTo(Integer value) {
            addCriterion("condition_false <=", value, "conditionFalse");
            return (Criteria) this;
        }

        public Criteria andConditionFalseIn(List<Integer> values) {
            addCriterion("condition_false in", values, "conditionFalse");
            return (Criteria) this;
        }

        public Criteria andConditionFalseNotIn(List<Integer> values) {
            addCriterion("condition_false not in", values, "conditionFalse");
            return (Criteria) this;
        }

        public Criteria andConditionFalseBetween(Integer value1, Integer value2) {
            addCriterion("condition_false between", value1, value2, "conditionFalse");
            return (Criteria) this;
        }

        public Criteria andConditionFalseNotBetween(Integer value1, Integer value2) {
            addCriterion("condition_false not between", value1, value2, "conditionFalse");
            return (Criteria) this;
        }

        public Criteria andFormShowStepIdIsNull() {
            addCriterion("form_show_step_id is null");
            return (Criteria) this;
        }

        public Criteria andFormShowStepIdIsNotNull() {
            addCriterion("form_show_step_id is not null");
            return (Criteria) this;
        }

        public Criteria andFormShowStepIdEqualTo(String value) {
            addCriterion("form_show_step_id =", value, "formShowStepId");
            return (Criteria) this;
        }

        public Criteria andFormShowStepIdNotEqualTo(String value) {
            addCriterion("form_show_step_id <>", value, "formShowStepId");
            return (Criteria) this;
        }

        public Criteria andFormShowStepIdGreaterThan(String value) {
            addCriterion("form_show_step_id >", value, "formShowStepId");
            return (Criteria) this;
        }

        public Criteria andFormShowStepIdGreaterThanOrEqualTo(String value) {
            addCriterion("form_show_step_id >=", value, "formShowStepId");
            return (Criteria) this;
        }

        public Criteria andFormShowStepIdLessThan(String value) {
            addCriterion("form_show_step_id <", value, "formShowStepId");
            return (Criteria) this;
        }

        public Criteria andFormShowStepIdLessThanOrEqualTo(String value) {
            addCriterion("form_show_step_id <=", value, "formShowStepId");
            return (Criteria) this;
        }

        public Criteria andFormShowStepIdLike(String value) {
            addCriterion("form_show_step_id like", value, "formShowStepId");
            return (Criteria) this;
        }

        public Criteria andFormShowStepIdNotLike(String value) {
            addCriterion("form_show_step_id not like", value, "formShowStepId");
            return (Criteria) this;
        }

        public Criteria andFormShowStepIdIn(List<String> values) {
            addCriterion("form_show_step_id in", values, "formShowStepId");
            return (Criteria) this;
        }

        public Criteria andFormShowStepIdNotIn(List<String> values) {
            addCriterion("form_show_step_id not in", values, "formShowStepId");
            return (Criteria) this;
        }

        public Criteria andFormShowStepIdBetween(String value1, String value2) {
            addCriterion("form_show_step_id between", value1, value2, "formShowStepId");
            return (Criteria) this;
        }

        public Criteria andFormShowStepIdNotBetween(String value1, String value2) {
            addCriterion("form_show_step_id not between", value1, value2, "formShowStepId");
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