package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderProductExample() {
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

        public Criteria andOrderContractNoIsNull() {
            addCriterion("order_contract_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderContractNoIsNotNull() {
            addCriterion("order_contract_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderContractNoEqualTo(String value) {
            addCriterion("order_contract_no =", value, "orderContractNo");
            return (Criteria) this;
        }

        public Criteria andOrderContractNoNotEqualTo(String value) {
            addCriterion("order_contract_no <>", value, "orderContractNo");
            return (Criteria) this;
        }

        public Criteria andOrderContractNoGreaterThan(String value) {
            addCriterion("order_contract_no >", value, "orderContractNo");
            return (Criteria) this;
        }

        public Criteria andOrderContractNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_contract_no >=", value, "orderContractNo");
            return (Criteria) this;
        }

        public Criteria andOrderContractNoLessThan(String value) {
            addCriterion("order_contract_no <", value, "orderContractNo");
            return (Criteria) this;
        }

        public Criteria andOrderContractNoLessThanOrEqualTo(String value) {
            addCriterion("order_contract_no <=", value, "orderContractNo");
            return (Criteria) this;
        }

        public Criteria andOrderContractNoLike(String value) {
            addCriterion("order_contract_no like", value, "orderContractNo");
            return (Criteria) this;
        }

        public Criteria andOrderContractNoNotLike(String value) {
            addCriterion("order_contract_no not like", value, "orderContractNo");
            return (Criteria) this;
        }

        public Criteria andOrderContractNoIn(List<String> values) {
            addCriterion("order_contract_no in", values, "orderContractNo");
            return (Criteria) this;
        }

        public Criteria andOrderContractNoNotIn(List<String> values) {
            addCriterion("order_contract_no not in", values, "orderContractNo");
            return (Criteria) this;
        }

        public Criteria andOrderContractNoBetween(String value1, String value2) {
            addCriterion("order_contract_no between", value1, value2, "orderContractNo");
            return (Criteria) this;
        }

        public Criteria andOrderContractNoNotBetween(String value1, String value2) {
            addCriterion("order_contract_no not between", value1, value2, "orderContractNo");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(Byte value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(Byte value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(Byte value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(Byte value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(Byte value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<Byte> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<Byte> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(Byte value1, Byte value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderContractUrlIsNull() {
            addCriterion("order_contract_url is null");
            return (Criteria) this;
        }

        public Criteria andOrderContractUrlIsNotNull() {
            addCriterion("order_contract_url is not null");
            return (Criteria) this;
        }

        public Criteria andOrderContractUrlEqualTo(String value) {
            addCriterion("order_contract_url =", value, "orderContractUrl");
            return (Criteria) this;
        }

        public Criteria andOrderContractUrlNotEqualTo(String value) {
            addCriterion("order_contract_url <>", value, "orderContractUrl");
            return (Criteria) this;
        }

        public Criteria andOrderContractUrlGreaterThan(String value) {
            addCriterion("order_contract_url >", value, "orderContractUrl");
            return (Criteria) this;
        }

        public Criteria andOrderContractUrlGreaterThanOrEqualTo(String value) {
            addCriterion("order_contract_url >=", value, "orderContractUrl");
            return (Criteria) this;
        }

        public Criteria andOrderContractUrlLessThan(String value) {
            addCriterion("order_contract_url <", value, "orderContractUrl");
            return (Criteria) this;
        }

        public Criteria andOrderContractUrlLessThanOrEqualTo(String value) {
            addCriterion("order_contract_url <=", value, "orderContractUrl");
            return (Criteria) this;
        }

        public Criteria andOrderContractUrlLike(String value) {
            addCriterion("order_contract_url like", value, "orderContractUrl");
            return (Criteria) this;
        }

        public Criteria andOrderContractUrlNotLike(String value) {
            addCriterion("order_contract_url not like", value, "orderContractUrl");
            return (Criteria) this;
        }

        public Criteria andOrderContractUrlIn(List<String> values) {
            addCriterion("order_contract_url in", values, "orderContractUrl");
            return (Criteria) this;
        }

        public Criteria andOrderContractUrlNotIn(List<String> values) {
            addCriterion("order_contract_url not in", values, "orderContractUrl");
            return (Criteria) this;
        }

        public Criteria andOrderContractUrlBetween(String value1, String value2) {
            addCriterion("order_contract_url between", value1, value2, "orderContractUrl");
            return (Criteria) this;
        }

        public Criteria andOrderContractUrlNotBetween(String value1, String value2) {
            addCriterion("order_contract_url not between", value1, value2, "orderContractUrl");
            return (Criteria) this;
        }

        public Criteria andOrderContractExtendUrlIsNull() {
            addCriterion("order_contract_extend_url is null");
            return (Criteria) this;
        }

        public Criteria andOrderContractExtendUrlIsNotNull() {
            addCriterion("order_contract_extend_url is not null");
            return (Criteria) this;
        }

        public Criteria andOrderContractExtendUrlEqualTo(String value) {
            addCriterion("order_contract_extend_url =", value, "orderContractExtendUrl");
            return (Criteria) this;
        }

        public Criteria andOrderContractExtendUrlNotEqualTo(String value) {
            addCriterion("order_contract_extend_url <>", value, "orderContractExtendUrl");
            return (Criteria) this;
        }

        public Criteria andOrderContractExtendUrlGreaterThan(String value) {
            addCriterion("order_contract_extend_url >", value, "orderContractExtendUrl");
            return (Criteria) this;
        }

        public Criteria andOrderContractExtendUrlGreaterThanOrEqualTo(String value) {
            addCriterion("order_contract_extend_url >=", value, "orderContractExtendUrl");
            return (Criteria) this;
        }

        public Criteria andOrderContractExtendUrlLessThan(String value) {
            addCriterion("order_contract_extend_url <", value, "orderContractExtendUrl");
            return (Criteria) this;
        }

        public Criteria andOrderContractExtendUrlLessThanOrEqualTo(String value) {
            addCriterion("order_contract_extend_url <=", value, "orderContractExtendUrl");
            return (Criteria) this;
        }

        public Criteria andOrderContractExtendUrlLike(String value) {
            addCriterion("order_contract_extend_url like", value, "orderContractExtendUrl");
            return (Criteria) this;
        }

        public Criteria andOrderContractExtendUrlNotLike(String value) {
            addCriterion("order_contract_extend_url not like", value, "orderContractExtendUrl");
            return (Criteria) this;
        }

        public Criteria andOrderContractExtendUrlIn(List<String> values) {
            addCriterion("order_contract_extend_url in", values, "orderContractExtendUrl");
            return (Criteria) this;
        }

        public Criteria andOrderContractExtendUrlNotIn(List<String> values) {
            addCriterion("order_contract_extend_url not in", values, "orderContractExtendUrl");
            return (Criteria) this;
        }

        public Criteria andOrderContractExtendUrlBetween(String value1, String value2) {
            addCriterion("order_contract_extend_url between", value1, value2, "orderContractExtendUrl");
            return (Criteria) this;
        }

        public Criteria andOrderContractExtendUrlNotBetween(String value1, String value2) {
            addCriterion("order_contract_extend_url not between", value1, value2, "orderContractExtendUrl");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequireIsNull() {
            addCriterion("technical_require is null");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequireIsNotNull() {
            addCriterion("technical_require is not null");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequireEqualTo(String value) {
            addCriterion("technical_require =", value, "technicalRequire");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequireNotEqualTo(String value) {
            addCriterion("technical_require <>", value, "technicalRequire");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequireGreaterThan(String value) {
            addCriterion("technical_require >", value, "technicalRequire");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequireGreaterThanOrEqualTo(String value) {
            addCriterion("technical_require >=", value, "technicalRequire");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequireLessThan(String value) {
            addCriterion("technical_require <", value, "technicalRequire");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequireLessThanOrEqualTo(String value) {
            addCriterion("technical_require <=", value, "technicalRequire");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequireLike(String value) {
            addCriterion("technical_require like", value, "technicalRequire");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequireNotLike(String value) {
            addCriterion("technical_require not like", value, "technicalRequire");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequireIn(List<String> values) {
            addCriterion("technical_require in", values, "technicalRequire");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequireNotIn(List<String> values) {
            addCriterion("technical_require not in", values, "technicalRequire");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequireBetween(String value1, String value2) {
            addCriterion("technical_require between", value1, value2, "technicalRequire");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequireNotBetween(String value1, String value2) {
            addCriterion("technical_require not between", value1, value2, "technicalRequire");
            return (Criteria) this;
        }

        public Criteria andFinishFeedbackTimeIsNull() {
            addCriterion("finish_feedback_time is null");
            return (Criteria) this;
        }

        public Criteria andFinishFeedbackTimeIsNotNull() {
            addCriterion("finish_feedback_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinishFeedbackTimeEqualTo(String value) {
            addCriterion("finish_feedback_time =", value, "finishFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andFinishFeedbackTimeNotEqualTo(String value) {
            addCriterion("finish_feedback_time <>", value, "finishFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andFinishFeedbackTimeGreaterThan(String value) {
            addCriterion("finish_feedback_time >", value, "finishFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andFinishFeedbackTimeGreaterThanOrEqualTo(String value) {
            addCriterion("finish_feedback_time >=", value, "finishFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andFinishFeedbackTimeLessThan(String value) {
            addCriterion("finish_feedback_time <", value, "finishFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andFinishFeedbackTimeLessThanOrEqualTo(String value) {
            addCriterion("finish_feedback_time <=", value, "finishFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andFinishFeedbackTimeLike(String value) {
            addCriterion("finish_feedback_time like", value, "finishFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andFinishFeedbackTimeNotLike(String value) {
            addCriterion("finish_feedback_time not like", value, "finishFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andFinishFeedbackTimeIn(List<String> values) {
            addCriterion("finish_feedback_time in", values, "finishFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andFinishFeedbackTimeNotIn(List<String> values) {
            addCriterion("finish_feedback_time not in", values, "finishFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andFinishFeedbackTimeBetween(String value1, String value2) {
            addCriterion("finish_feedback_time between", value1, value2, "finishFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andFinishFeedbackTimeNotBetween(String value1, String value2) {
            addCriterion("finish_feedback_time not between", value1, value2, "finishFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeConfirmUserIsNull() {
            addCriterion("feedback_time_confirm_user is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeConfirmUserIsNotNull() {
            addCriterion("feedback_time_confirm_user is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeConfirmUserEqualTo(String value) {
            addCriterion("feedback_time_confirm_user =", value, "feedbackTimeConfirmUser");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeConfirmUserNotEqualTo(String value) {
            addCriterion("feedback_time_confirm_user <>", value, "feedbackTimeConfirmUser");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeConfirmUserGreaterThan(String value) {
            addCriterion("feedback_time_confirm_user >", value, "feedbackTimeConfirmUser");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeConfirmUserGreaterThanOrEqualTo(String value) {
            addCriterion("feedback_time_confirm_user >=", value, "feedbackTimeConfirmUser");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeConfirmUserLessThan(String value) {
            addCriterion("feedback_time_confirm_user <", value, "feedbackTimeConfirmUser");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeConfirmUserLessThanOrEqualTo(String value) {
            addCriterion("feedback_time_confirm_user <=", value, "feedbackTimeConfirmUser");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeConfirmUserLike(String value) {
            addCriterion("feedback_time_confirm_user like", value, "feedbackTimeConfirmUser");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeConfirmUserNotLike(String value) {
            addCriterion("feedback_time_confirm_user not like", value, "feedbackTimeConfirmUser");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeConfirmUserIn(List<String> values) {
            addCriterion("feedback_time_confirm_user in", values, "feedbackTimeConfirmUser");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeConfirmUserNotIn(List<String> values) {
            addCriterion("feedback_time_confirm_user not in", values, "feedbackTimeConfirmUser");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeConfirmUserBetween(String value1, String value2) {
            addCriterion("feedback_time_confirm_user between", value1, value2, "feedbackTimeConfirmUser");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeConfirmUserNotBetween(String value1, String value2) {
            addCriterion("feedback_time_confirm_user not between", value1, value2, "feedbackTimeConfirmUser");
            return (Criteria) this;
        }

        public Criteria andPurchaseFeedbackTimeIsNull() {
            addCriterion("purchase_feedback_time is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseFeedbackTimeIsNotNull() {
            addCriterion("purchase_feedback_time is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseFeedbackTimeEqualTo(String value) {
            addCriterion("purchase_feedback_time =", value, "purchaseFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseFeedbackTimeNotEqualTo(String value) {
            addCriterion("purchase_feedback_time <>", value, "purchaseFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseFeedbackTimeGreaterThan(String value) {
            addCriterion("purchase_feedback_time >", value, "purchaseFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseFeedbackTimeGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_feedback_time >=", value, "purchaseFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseFeedbackTimeLessThan(String value) {
            addCriterion("purchase_feedback_time <", value, "purchaseFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseFeedbackTimeLessThanOrEqualTo(String value) {
            addCriterion("purchase_feedback_time <=", value, "purchaseFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseFeedbackTimeLike(String value) {
            addCriterion("purchase_feedback_time like", value, "purchaseFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseFeedbackTimeNotLike(String value) {
            addCriterion("purchase_feedback_time not like", value, "purchaseFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseFeedbackTimeIn(List<String> values) {
            addCriterion("purchase_feedback_time in", values, "purchaseFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseFeedbackTimeNotIn(List<String> values) {
            addCriterion("purchase_feedback_time not in", values, "purchaseFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseFeedbackTimeBetween(String value1, String value2) {
            addCriterion("purchase_feedback_time between", value1, value2, "purchaseFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseFeedbackTimeNotBetween(String value1, String value2) {
            addCriterion("purchase_feedback_time not between", value1, value2, "purchaseFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andProductionFeedbackTimeIsNull() {
            addCriterion("production_feedback_time is null");
            return (Criteria) this;
        }

        public Criteria andProductionFeedbackTimeIsNotNull() {
            addCriterion("production_feedback_time is not null");
            return (Criteria) this;
        }

        public Criteria andProductionFeedbackTimeEqualTo(String value) {
            addCriterion("production_feedback_time =", value, "productionFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andProductionFeedbackTimeNotEqualTo(String value) {
            addCriterion("production_feedback_time <>", value, "productionFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andProductionFeedbackTimeGreaterThan(String value) {
            addCriterion("production_feedback_time >", value, "productionFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andProductionFeedbackTimeGreaterThanOrEqualTo(String value) {
            addCriterion("production_feedback_time >=", value, "productionFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andProductionFeedbackTimeLessThan(String value) {
            addCriterion("production_feedback_time <", value, "productionFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andProductionFeedbackTimeLessThanOrEqualTo(String value) {
            addCriterion("production_feedback_time <=", value, "productionFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andProductionFeedbackTimeLike(String value) {
            addCriterion("production_feedback_time like", value, "productionFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andProductionFeedbackTimeNotLike(String value) {
            addCriterion("production_feedback_time not like", value, "productionFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andProductionFeedbackTimeIn(List<String> values) {
            addCriterion("production_feedback_time in", values, "productionFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andProductionFeedbackTimeNotIn(List<String> values) {
            addCriterion("production_feedback_time not in", values, "productionFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andProductionFeedbackTimeBetween(String value1, String value2) {
            addCriterion("production_feedback_time between", value1, value2, "productionFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andProductionFeedbackTimeNotBetween(String value1, String value2) {
            addCriterion("production_feedback_time not between", value1, value2, "productionFeedbackTime");
            return (Criteria) this;
        }

        public Criteria andAssemblyShopIsNull() {
            addCriterion("assembly_shop is null");
            return (Criteria) this;
        }

        public Criteria andAssemblyShopIsNotNull() {
            addCriterion("assembly_shop is not null");
            return (Criteria) this;
        }

        public Criteria andAssemblyShopEqualTo(String value) {
            addCriterion("assembly_shop =", value, "assemblyShop");
            return (Criteria) this;
        }

        public Criteria andAssemblyShopNotEqualTo(String value) {
            addCriterion("assembly_shop <>", value, "assemblyShop");
            return (Criteria) this;
        }

        public Criteria andAssemblyShopGreaterThan(String value) {
            addCriterion("assembly_shop >", value, "assemblyShop");
            return (Criteria) this;
        }

        public Criteria andAssemblyShopGreaterThanOrEqualTo(String value) {
            addCriterion("assembly_shop >=", value, "assemblyShop");
            return (Criteria) this;
        }

        public Criteria andAssemblyShopLessThan(String value) {
            addCriterion("assembly_shop <", value, "assemblyShop");
            return (Criteria) this;
        }

        public Criteria andAssemblyShopLessThanOrEqualTo(String value) {
            addCriterion("assembly_shop <=", value, "assemblyShop");
            return (Criteria) this;
        }

        public Criteria andAssemblyShopLike(String value) {
            addCriterion("assembly_shop like", value, "assemblyShop");
            return (Criteria) this;
        }

        public Criteria andAssemblyShopNotLike(String value) {
            addCriterion("assembly_shop not like", value, "assemblyShop");
            return (Criteria) this;
        }

        public Criteria andAssemblyShopIn(List<String> values) {
            addCriterion("assembly_shop in", values, "assemblyShop");
            return (Criteria) this;
        }

        public Criteria andAssemblyShopNotIn(List<String> values) {
            addCriterion("assembly_shop not in", values, "assemblyShop");
            return (Criteria) this;
        }

        public Criteria andAssemblyShopBetween(String value1, String value2) {
            addCriterion("assembly_shop between", value1, value2, "assemblyShop");
            return (Criteria) this;
        }

        public Criteria andAssemblyShopNotBetween(String value1, String value2) {
            addCriterion("assembly_shop not between", value1, value2, "assemblyShop");
            return (Criteria) this;
        }

        public Criteria andAssemblyGroupIsNull() {
            addCriterion("assembly_group is null");
            return (Criteria) this;
        }

        public Criteria andAssemblyGroupIsNotNull() {
            addCriterion("assembly_group is not null");
            return (Criteria) this;
        }

        public Criteria andAssemblyGroupEqualTo(String value) {
            addCriterion("assembly_group =", value, "assemblyGroup");
            return (Criteria) this;
        }

        public Criteria andAssemblyGroupNotEqualTo(String value) {
            addCriterion("assembly_group <>", value, "assemblyGroup");
            return (Criteria) this;
        }

        public Criteria andAssemblyGroupGreaterThan(String value) {
            addCriterion("assembly_group >", value, "assemblyGroup");
            return (Criteria) this;
        }

        public Criteria andAssemblyGroupGreaterThanOrEqualTo(String value) {
            addCriterion("assembly_group >=", value, "assemblyGroup");
            return (Criteria) this;
        }

        public Criteria andAssemblyGroupLessThan(String value) {
            addCriterion("assembly_group <", value, "assemblyGroup");
            return (Criteria) this;
        }

        public Criteria andAssemblyGroupLessThanOrEqualTo(String value) {
            addCriterion("assembly_group <=", value, "assemblyGroup");
            return (Criteria) this;
        }

        public Criteria andAssemblyGroupLike(String value) {
            addCriterion("assembly_group like", value, "assemblyGroup");
            return (Criteria) this;
        }

        public Criteria andAssemblyGroupNotLike(String value) {
            addCriterion("assembly_group not like", value, "assemblyGroup");
            return (Criteria) this;
        }

        public Criteria andAssemblyGroupIn(List<String> values) {
            addCriterion("assembly_group in", values, "assemblyGroup");
            return (Criteria) this;
        }

        public Criteria andAssemblyGroupNotIn(List<String> values) {
            addCriterion("assembly_group not in", values, "assemblyGroup");
            return (Criteria) this;
        }

        public Criteria andAssemblyGroupBetween(String value1, String value2) {
            addCriterion("assembly_group between", value1, value2, "assemblyGroup");
            return (Criteria) this;
        }

        public Criteria andAssemblyGroupNotBetween(String value1, String value2) {
            addCriterion("assembly_group not between", value1, value2, "assemblyGroup");
            return (Criteria) this;
        }

        public Criteria andDemandNameIsNull() {
            addCriterion("demand_name is null");
            return (Criteria) this;
        }

        public Criteria andDemandNameIsNotNull() {
            addCriterion("demand_name is not null");
            return (Criteria) this;
        }

        public Criteria andDemandNameEqualTo(String value) {
            addCriterion("demand_name =", value, "demandName");
            return (Criteria) this;
        }

        public Criteria andDemandNameNotEqualTo(String value) {
            addCriterion("demand_name <>", value, "demandName");
            return (Criteria) this;
        }

        public Criteria andDemandNameGreaterThan(String value) {
            addCriterion("demand_name >", value, "demandName");
            return (Criteria) this;
        }

        public Criteria andDemandNameGreaterThanOrEqualTo(String value) {
            addCriterion("demand_name >=", value, "demandName");
            return (Criteria) this;
        }

        public Criteria andDemandNameLessThan(String value) {
            addCriterion("demand_name <", value, "demandName");
            return (Criteria) this;
        }

        public Criteria andDemandNameLessThanOrEqualTo(String value) {
            addCriterion("demand_name <=", value, "demandName");
            return (Criteria) this;
        }

        public Criteria andDemandNameLike(String value) {
            addCriterion("demand_name like", value, "demandName");
            return (Criteria) this;
        }

        public Criteria andDemandNameNotLike(String value) {
            addCriterion("demand_name not like", value, "demandName");
            return (Criteria) this;
        }

        public Criteria andDemandNameIn(List<String> values) {
            addCriterion("demand_name in", values, "demandName");
            return (Criteria) this;
        }

        public Criteria andDemandNameNotIn(List<String> values) {
            addCriterion("demand_name not in", values, "demandName");
            return (Criteria) this;
        }

        public Criteria andDemandNameBetween(String value1, String value2) {
            addCriterion("demand_name between", value1, value2, "demandName");
            return (Criteria) this;
        }

        public Criteria andDemandNameNotBetween(String value1, String value2) {
            addCriterion("demand_name not between", value1, value2, "demandName");
            return (Criteria) this;
        }

        public Criteria andDemandAgentNameIsNull() {
            addCriterion("demand_agent_name is null");
            return (Criteria) this;
        }

        public Criteria andDemandAgentNameIsNotNull() {
            addCriterion("demand_agent_name is not null");
            return (Criteria) this;
        }

        public Criteria andDemandAgentNameEqualTo(String value) {
            addCriterion("demand_agent_name =", value, "demandAgentName");
            return (Criteria) this;
        }

        public Criteria andDemandAgentNameNotEqualTo(String value) {
            addCriterion("demand_agent_name <>", value, "demandAgentName");
            return (Criteria) this;
        }

        public Criteria andDemandAgentNameGreaterThan(String value) {
            addCriterion("demand_agent_name >", value, "demandAgentName");
            return (Criteria) this;
        }

        public Criteria andDemandAgentNameGreaterThanOrEqualTo(String value) {
            addCriterion("demand_agent_name >=", value, "demandAgentName");
            return (Criteria) this;
        }

        public Criteria andDemandAgentNameLessThan(String value) {
            addCriterion("demand_agent_name <", value, "demandAgentName");
            return (Criteria) this;
        }

        public Criteria andDemandAgentNameLessThanOrEqualTo(String value) {
            addCriterion("demand_agent_name <=", value, "demandAgentName");
            return (Criteria) this;
        }

        public Criteria andDemandAgentNameLike(String value) {
            addCriterion("demand_agent_name like", value, "demandAgentName");
            return (Criteria) this;
        }

        public Criteria andDemandAgentNameNotLike(String value) {
            addCriterion("demand_agent_name not like", value, "demandAgentName");
            return (Criteria) this;
        }

        public Criteria andDemandAgentNameIn(List<String> values) {
            addCriterion("demand_agent_name in", values, "demandAgentName");
            return (Criteria) this;
        }

        public Criteria andDemandAgentNameNotIn(List<String> values) {
            addCriterion("demand_agent_name not in", values, "demandAgentName");
            return (Criteria) this;
        }

        public Criteria andDemandAgentNameBetween(String value1, String value2) {
            addCriterion("demand_agent_name between", value1, value2, "demandAgentName");
            return (Criteria) this;
        }

        public Criteria andDemandAgentNameNotBetween(String value1, String value2) {
            addCriterion("demand_agent_name not between", value1, value2, "demandAgentName");
            return (Criteria) this;
        }

        public Criteria andDemandPhoneIsNull() {
            addCriterion("demand_phone is null");
            return (Criteria) this;
        }

        public Criteria andDemandPhoneIsNotNull() {
            addCriterion("demand_phone is not null");
            return (Criteria) this;
        }

        public Criteria andDemandPhoneEqualTo(String value) {
            addCriterion("demand_phone =", value, "demandPhone");
            return (Criteria) this;
        }

        public Criteria andDemandPhoneNotEqualTo(String value) {
            addCriterion("demand_phone <>", value, "demandPhone");
            return (Criteria) this;
        }

        public Criteria andDemandPhoneGreaterThan(String value) {
            addCriterion("demand_phone >", value, "demandPhone");
            return (Criteria) this;
        }

        public Criteria andDemandPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("demand_phone >=", value, "demandPhone");
            return (Criteria) this;
        }

        public Criteria andDemandPhoneLessThan(String value) {
            addCriterion("demand_phone <", value, "demandPhone");
            return (Criteria) this;
        }

        public Criteria andDemandPhoneLessThanOrEqualTo(String value) {
            addCriterion("demand_phone <=", value, "demandPhone");
            return (Criteria) this;
        }

        public Criteria andDemandPhoneLike(String value) {
            addCriterion("demand_phone like", value, "demandPhone");
            return (Criteria) this;
        }

        public Criteria andDemandPhoneNotLike(String value) {
            addCriterion("demand_phone not like", value, "demandPhone");
            return (Criteria) this;
        }

        public Criteria andDemandPhoneIn(List<String> values) {
            addCriterion("demand_phone in", values, "demandPhone");
            return (Criteria) this;
        }

        public Criteria andDemandPhoneNotIn(List<String> values) {
            addCriterion("demand_phone not in", values, "demandPhone");
            return (Criteria) this;
        }

        public Criteria andDemandPhoneBetween(String value1, String value2) {
            addCriterion("demand_phone between", value1, value2, "demandPhone");
            return (Criteria) this;
        }

        public Criteria andDemandPhoneNotBetween(String value1, String value2) {
            addCriterion("demand_phone not between", value1, value2, "demandPhone");
            return (Criteria) this;
        }

        public Criteria andDemandFaxIsNull() {
            addCriterion("demand_fax is null");
            return (Criteria) this;
        }

        public Criteria andDemandFaxIsNotNull() {
            addCriterion("demand_fax is not null");
            return (Criteria) this;
        }

        public Criteria andDemandFaxEqualTo(String value) {
            addCriterion("demand_fax =", value, "demandFax");
            return (Criteria) this;
        }

        public Criteria andDemandFaxNotEqualTo(String value) {
            addCriterion("demand_fax <>", value, "demandFax");
            return (Criteria) this;
        }

        public Criteria andDemandFaxGreaterThan(String value) {
            addCriterion("demand_fax >", value, "demandFax");
            return (Criteria) this;
        }

        public Criteria andDemandFaxGreaterThanOrEqualTo(String value) {
            addCriterion("demand_fax >=", value, "demandFax");
            return (Criteria) this;
        }

        public Criteria andDemandFaxLessThan(String value) {
            addCriterion("demand_fax <", value, "demandFax");
            return (Criteria) this;
        }

        public Criteria andDemandFaxLessThanOrEqualTo(String value) {
            addCriterion("demand_fax <=", value, "demandFax");
            return (Criteria) this;
        }

        public Criteria andDemandFaxLike(String value) {
            addCriterion("demand_fax like", value, "demandFax");
            return (Criteria) this;
        }

        public Criteria andDemandFaxNotLike(String value) {
            addCriterion("demand_fax not like", value, "demandFax");
            return (Criteria) this;
        }

        public Criteria andDemandFaxIn(List<String> values) {
            addCriterion("demand_fax in", values, "demandFax");
            return (Criteria) this;
        }

        public Criteria andDemandFaxNotIn(List<String> values) {
            addCriterion("demand_fax not in", values, "demandFax");
            return (Criteria) this;
        }

        public Criteria andDemandFaxBetween(String value1, String value2) {
            addCriterion("demand_fax between", value1, value2, "demandFax");
            return (Criteria) this;
        }

        public Criteria andDemandFaxNotBetween(String value1, String value2) {
            addCriterion("demand_fax not between", value1, value2, "demandFax");
            return (Criteria) this;
        }

        public Criteria andDemandBankNameIsNull() {
            addCriterion("demand_bank_name is null");
            return (Criteria) this;
        }

        public Criteria andDemandBankNameIsNotNull() {
            addCriterion("demand_bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andDemandBankNameEqualTo(String value) {
            addCriterion("demand_bank_name =", value, "demandBankName");
            return (Criteria) this;
        }

        public Criteria andDemandBankNameNotEqualTo(String value) {
            addCriterion("demand_bank_name <>", value, "demandBankName");
            return (Criteria) this;
        }

        public Criteria andDemandBankNameGreaterThan(String value) {
            addCriterion("demand_bank_name >", value, "demandBankName");
            return (Criteria) this;
        }

        public Criteria andDemandBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("demand_bank_name >=", value, "demandBankName");
            return (Criteria) this;
        }

        public Criteria andDemandBankNameLessThan(String value) {
            addCriterion("demand_bank_name <", value, "demandBankName");
            return (Criteria) this;
        }

        public Criteria andDemandBankNameLessThanOrEqualTo(String value) {
            addCriterion("demand_bank_name <=", value, "demandBankName");
            return (Criteria) this;
        }

        public Criteria andDemandBankNameLike(String value) {
            addCriterion("demand_bank_name like", value, "demandBankName");
            return (Criteria) this;
        }

        public Criteria andDemandBankNameNotLike(String value) {
            addCriterion("demand_bank_name not like", value, "demandBankName");
            return (Criteria) this;
        }

        public Criteria andDemandBankNameIn(List<String> values) {
            addCriterion("demand_bank_name in", values, "demandBankName");
            return (Criteria) this;
        }

        public Criteria andDemandBankNameNotIn(List<String> values) {
            addCriterion("demand_bank_name not in", values, "demandBankName");
            return (Criteria) this;
        }

        public Criteria andDemandBankNameBetween(String value1, String value2) {
            addCriterion("demand_bank_name between", value1, value2, "demandBankName");
            return (Criteria) this;
        }

        public Criteria andDemandBankNameNotBetween(String value1, String value2) {
            addCriterion("demand_bank_name not between", value1, value2, "demandBankName");
            return (Criteria) this;
        }

        public Criteria andDemandBankCardNoIsNull() {
            addCriterion("demand_bank_card_no is null");
            return (Criteria) this;
        }

        public Criteria andDemandBankCardNoIsNotNull() {
            addCriterion("demand_bank_card_no is not null");
            return (Criteria) this;
        }

        public Criteria andDemandBankCardNoEqualTo(String value) {
            addCriterion("demand_bank_card_no =", value, "demandBankCardNo");
            return (Criteria) this;
        }

        public Criteria andDemandBankCardNoNotEqualTo(String value) {
            addCriterion("demand_bank_card_no <>", value, "demandBankCardNo");
            return (Criteria) this;
        }

        public Criteria andDemandBankCardNoGreaterThan(String value) {
            addCriterion("demand_bank_card_no >", value, "demandBankCardNo");
            return (Criteria) this;
        }

        public Criteria andDemandBankCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("demand_bank_card_no >=", value, "demandBankCardNo");
            return (Criteria) this;
        }

        public Criteria andDemandBankCardNoLessThan(String value) {
            addCriterion("demand_bank_card_no <", value, "demandBankCardNo");
            return (Criteria) this;
        }

        public Criteria andDemandBankCardNoLessThanOrEqualTo(String value) {
            addCriterion("demand_bank_card_no <=", value, "demandBankCardNo");
            return (Criteria) this;
        }

        public Criteria andDemandBankCardNoLike(String value) {
            addCriterion("demand_bank_card_no like", value, "demandBankCardNo");
            return (Criteria) this;
        }

        public Criteria andDemandBankCardNoNotLike(String value) {
            addCriterion("demand_bank_card_no not like", value, "demandBankCardNo");
            return (Criteria) this;
        }

        public Criteria andDemandBankCardNoIn(List<String> values) {
            addCriterion("demand_bank_card_no in", values, "demandBankCardNo");
            return (Criteria) this;
        }

        public Criteria andDemandBankCardNoNotIn(List<String> values) {
            addCriterion("demand_bank_card_no not in", values, "demandBankCardNo");
            return (Criteria) this;
        }

        public Criteria andDemandBankCardNoBetween(String value1, String value2) {
            addCriterion("demand_bank_card_no between", value1, value2, "demandBankCardNo");
            return (Criteria) this;
        }

        public Criteria andDemandBankCardNoNotBetween(String value1, String value2) {
            addCriterion("demand_bank_card_no not between", value1, value2, "demandBankCardNo");
            return (Criteria) this;
        }

        public Criteria andSupplyNameIsNull() {
            addCriterion("supply_name is null");
            return (Criteria) this;
        }

        public Criteria andSupplyNameIsNotNull() {
            addCriterion("supply_name is not null");
            return (Criteria) this;
        }

        public Criteria andSupplyNameEqualTo(String value) {
            addCriterion("supply_name =", value, "supplyName");
            return (Criteria) this;
        }

        public Criteria andSupplyNameNotEqualTo(String value) {
            addCriterion("supply_name <>", value, "supplyName");
            return (Criteria) this;
        }

        public Criteria andSupplyNameGreaterThan(String value) {
            addCriterion("supply_name >", value, "supplyName");
            return (Criteria) this;
        }

        public Criteria andSupplyNameGreaterThanOrEqualTo(String value) {
            addCriterion("supply_name >=", value, "supplyName");
            return (Criteria) this;
        }

        public Criteria andSupplyNameLessThan(String value) {
            addCriterion("supply_name <", value, "supplyName");
            return (Criteria) this;
        }

        public Criteria andSupplyNameLessThanOrEqualTo(String value) {
            addCriterion("supply_name <=", value, "supplyName");
            return (Criteria) this;
        }

        public Criteria andSupplyNameLike(String value) {
            addCriterion("supply_name like", value, "supplyName");
            return (Criteria) this;
        }

        public Criteria andSupplyNameNotLike(String value) {
            addCriterion("supply_name not like", value, "supplyName");
            return (Criteria) this;
        }

        public Criteria andSupplyNameIn(List<String> values) {
            addCriterion("supply_name in", values, "supplyName");
            return (Criteria) this;
        }

        public Criteria andSupplyNameNotIn(List<String> values) {
            addCriterion("supply_name not in", values, "supplyName");
            return (Criteria) this;
        }

        public Criteria andSupplyNameBetween(String value1, String value2) {
            addCriterion("supply_name between", value1, value2, "supplyName");
            return (Criteria) this;
        }

        public Criteria andSupplyNameNotBetween(String value1, String value2) {
            addCriterion("supply_name not between", value1, value2, "supplyName");
            return (Criteria) this;
        }

        public Criteria andSupplyAgentNameIsNull() {
            addCriterion("supply_agent_name is null");
            return (Criteria) this;
        }

        public Criteria andSupplyAgentNameIsNotNull() {
            addCriterion("supply_agent_name is not null");
            return (Criteria) this;
        }

        public Criteria andSupplyAgentNameEqualTo(String value) {
            addCriterion("supply_agent_name =", value, "supplyAgentName");
            return (Criteria) this;
        }

        public Criteria andSupplyAgentNameNotEqualTo(String value) {
            addCriterion("supply_agent_name <>", value, "supplyAgentName");
            return (Criteria) this;
        }

        public Criteria andSupplyAgentNameGreaterThan(String value) {
            addCriterion("supply_agent_name >", value, "supplyAgentName");
            return (Criteria) this;
        }

        public Criteria andSupplyAgentNameGreaterThanOrEqualTo(String value) {
            addCriterion("supply_agent_name >=", value, "supplyAgentName");
            return (Criteria) this;
        }

        public Criteria andSupplyAgentNameLessThan(String value) {
            addCriterion("supply_agent_name <", value, "supplyAgentName");
            return (Criteria) this;
        }

        public Criteria andSupplyAgentNameLessThanOrEqualTo(String value) {
            addCriterion("supply_agent_name <=", value, "supplyAgentName");
            return (Criteria) this;
        }

        public Criteria andSupplyAgentNameLike(String value) {
            addCriterion("supply_agent_name like", value, "supplyAgentName");
            return (Criteria) this;
        }

        public Criteria andSupplyAgentNameNotLike(String value) {
            addCriterion("supply_agent_name not like", value, "supplyAgentName");
            return (Criteria) this;
        }

        public Criteria andSupplyAgentNameIn(List<String> values) {
            addCriterion("supply_agent_name in", values, "supplyAgentName");
            return (Criteria) this;
        }

        public Criteria andSupplyAgentNameNotIn(List<String> values) {
            addCriterion("supply_agent_name not in", values, "supplyAgentName");
            return (Criteria) this;
        }

        public Criteria andSupplyAgentNameBetween(String value1, String value2) {
            addCriterion("supply_agent_name between", value1, value2, "supplyAgentName");
            return (Criteria) this;
        }

        public Criteria andSupplyAgentNameNotBetween(String value1, String value2) {
            addCriterion("supply_agent_name not between", value1, value2, "supplyAgentName");
            return (Criteria) this;
        }

        public Criteria andSupplyPhoneIsNull() {
            addCriterion("supply_phone is null");
            return (Criteria) this;
        }

        public Criteria andSupplyPhoneIsNotNull() {
            addCriterion("supply_phone is not null");
            return (Criteria) this;
        }

        public Criteria andSupplyPhoneEqualTo(String value) {
            addCriterion("supply_phone =", value, "supplyPhone");
            return (Criteria) this;
        }

        public Criteria andSupplyPhoneNotEqualTo(String value) {
            addCriterion("supply_phone <>", value, "supplyPhone");
            return (Criteria) this;
        }

        public Criteria andSupplyPhoneGreaterThan(String value) {
            addCriterion("supply_phone >", value, "supplyPhone");
            return (Criteria) this;
        }

        public Criteria andSupplyPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("supply_phone >=", value, "supplyPhone");
            return (Criteria) this;
        }

        public Criteria andSupplyPhoneLessThan(String value) {
            addCriterion("supply_phone <", value, "supplyPhone");
            return (Criteria) this;
        }

        public Criteria andSupplyPhoneLessThanOrEqualTo(String value) {
            addCriterion("supply_phone <=", value, "supplyPhone");
            return (Criteria) this;
        }

        public Criteria andSupplyPhoneLike(String value) {
            addCriterion("supply_phone like", value, "supplyPhone");
            return (Criteria) this;
        }

        public Criteria andSupplyPhoneNotLike(String value) {
            addCriterion("supply_phone not like", value, "supplyPhone");
            return (Criteria) this;
        }

        public Criteria andSupplyPhoneIn(List<String> values) {
            addCriterion("supply_phone in", values, "supplyPhone");
            return (Criteria) this;
        }

        public Criteria andSupplyPhoneNotIn(List<String> values) {
            addCriterion("supply_phone not in", values, "supplyPhone");
            return (Criteria) this;
        }

        public Criteria andSupplyPhoneBetween(String value1, String value2) {
            addCriterion("supply_phone between", value1, value2, "supplyPhone");
            return (Criteria) this;
        }

        public Criteria andSupplyPhoneNotBetween(String value1, String value2) {
            addCriterion("supply_phone not between", value1, value2, "supplyPhone");
            return (Criteria) this;
        }

        public Criteria andSupplyFaxIsNull() {
            addCriterion("supply_fax is null");
            return (Criteria) this;
        }

        public Criteria andSupplyFaxIsNotNull() {
            addCriterion("supply_fax is not null");
            return (Criteria) this;
        }

        public Criteria andSupplyFaxEqualTo(String value) {
            addCriterion("supply_fax =", value, "supplyFax");
            return (Criteria) this;
        }

        public Criteria andSupplyFaxNotEqualTo(String value) {
            addCriterion("supply_fax <>", value, "supplyFax");
            return (Criteria) this;
        }

        public Criteria andSupplyFaxGreaterThan(String value) {
            addCriterion("supply_fax >", value, "supplyFax");
            return (Criteria) this;
        }

        public Criteria andSupplyFaxGreaterThanOrEqualTo(String value) {
            addCriterion("supply_fax >=", value, "supplyFax");
            return (Criteria) this;
        }

        public Criteria andSupplyFaxLessThan(String value) {
            addCriterion("supply_fax <", value, "supplyFax");
            return (Criteria) this;
        }

        public Criteria andSupplyFaxLessThanOrEqualTo(String value) {
            addCriterion("supply_fax <=", value, "supplyFax");
            return (Criteria) this;
        }

        public Criteria andSupplyFaxLike(String value) {
            addCriterion("supply_fax like", value, "supplyFax");
            return (Criteria) this;
        }

        public Criteria andSupplyFaxNotLike(String value) {
            addCriterion("supply_fax not like", value, "supplyFax");
            return (Criteria) this;
        }

        public Criteria andSupplyFaxIn(List<String> values) {
            addCriterion("supply_fax in", values, "supplyFax");
            return (Criteria) this;
        }

        public Criteria andSupplyFaxNotIn(List<String> values) {
            addCriterion("supply_fax not in", values, "supplyFax");
            return (Criteria) this;
        }

        public Criteria andSupplyFaxBetween(String value1, String value2) {
            addCriterion("supply_fax between", value1, value2, "supplyFax");
            return (Criteria) this;
        }

        public Criteria andSupplyFaxNotBetween(String value1, String value2) {
            addCriterion("supply_fax not between", value1, value2, "supplyFax");
            return (Criteria) this;
        }

        public Criteria andSupplyBankNameIsNull() {
            addCriterion("supply_bank_name is null");
            return (Criteria) this;
        }

        public Criteria andSupplyBankNameIsNotNull() {
            addCriterion("supply_bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andSupplyBankNameEqualTo(String value) {
            addCriterion("supply_bank_name =", value, "supplyBankName");
            return (Criteria) this;
        }

        public Criteria andSupplyBankNameNotEqualTo(String value) {
            addCriterion("supply_bank_name <>", value, "supplyBankName");
            return (Criteria) this;
        }

        public Criteria andSupplyBankNameGreaterThan(String value) {
            addCriterion("supply_bank_name >", value, "supplyBankName");
            return (Criteria) this;
        }

        public Criteria andSupplyBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("supply_bank_name >=", value, "supplyBankName");
            return (Criteria) this;
        }

        public Criteria andSupplyBankNameLessThan(String value) {
            addCriterion("supply_bank_name <", value, "supplyBankName");
            return (Criteria) this;
        }

        public Criteria andSupplyBankNameLessThanOrEqualTo(String value) {
            addCriterion("supply_bank_name <=", value, "supplyBankName");
            return (Criteria) this;
        }

        public Criteria andSupplyBankNameLike(String value) {
            addCriterion("supply_bank_name like", value, "supplyBankName");
            return (Criteria) this;
        }

        public Criteria andSupplyBankNameNotLike(String value) {
            addCriterion("supply_bank_name not like", value, "supplyBankName");
            return (Criteria) this;
        }

        public Criteria andSupplyBankNameIn(List<String> values) {
            addCriterion("supply_bank_name in", values, "supplyBankName");
            return (Criteria) this;
        }

        public Criteria andSupplyBankNameNotIn(List<String> values) {
            addCriterion("supply_bank_name not in", values, "supplyBankName");
            return (Criteria) this;
        }

        public Criteria andSupplyBankNameBetween(String value1, String value2) {
            addCriterion("supply_bank_name between", value1, value2, "supplyBankName");
            return (Criteria) this;
        }

        public Criteria andSupplyBankNameNotBetween(String value1, String value2) {
            addCriterion("supply_bank_name not between", value1, value2, "supplyBankName");
            return (Criteria) this;
        }

        public Criteria andContractBankCardNoIsNull() {
            addCriterion("contract_bank_card_no is null");
            return (Criteria) this;
        }

        public Criteria andContractBankCardNoIsNotNull() {
            addCriterion("contract_bank_card_no is not null");
            return (Criteria) this;
        }

        public Criteria andContractBankCardNoEqualTo(String value) {
            addCriterion("contract_bank_card_no =", value, "contractBankCardNo");
            return (Criteria) this;
        }

        public Criteria andContractBankCardNoNotEqualTo(String value) {
            addCriterion("contract_bank_card_no <>", value, "contractBankCardNo");
            return (Criteria) this;
        }

        public Criteria andContractBankCardNoGreaterThan(String value) {
            addCriterion("contract_bank_card_no >", value, "contractBankCardNo");
            return (Criteria) this;
        }

        public Criteria andContractBankCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("contract_bank_card_no >=", value, "contractBankCardNo");
            return (Criteria) this;
        }

        public Criteria andContractBankCardNoLessThan(String value) {
            addCriterion("contract_bank_card_no <", value, "contractBankCardNo");
            return (Criteria) this;
        }

        public Criteria andContractBankCardNoLessThanOrEqualTo(String value) {
            addCriterion("contract_bank_card_no <=", value, "contractBankCardNo");
            return (Criteria) this;
        }

        public Criteria andContractBankCardNoLike(String value) {
            addCriterion("contract_bank_card_no like", value, "contractBankCardNo");
            return (Criteria) this;
        }

        public Criteria andContractBankCardNoNotLike(String value) {
            addCriterion("contract_bank_card_no not like", value, "contractBankCardNo");
            return (Criteria) this;
        }

        public Criteria andContractBankCardNoIn(List<String> values) {
            addCriterion("contract_bank_card_no in", values, "contractBankCardNo");
            return (Criteria) this;
        }

        public Criteria andContractBankCardNoNotIn(List<String> values) {
            addCriterion("contract_bank_card_no not in", values, "contractBankCardNo");
            return (Criteria) this;
        }

        public Criteria andContractBankCardNoBetween(String value1, String value2) {
            addCriterion("contract_bank_card_no between", value1, value2, "contractBankCardNo");
            return (Criteria) this;
        }

        public Criteria andContractBankCardNoNotBetween(String value1, String value2) {
            addCriterion("contract_bank_card_no not between", value1, value2, "contractBankCardNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceIsNull() {
            addCriterion("delivery_place is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceIsNotNull() {
            addCriterion("delivery_place is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceEqualTo(String value) {
            addCriterion("delivery_place =", value, "deliveryPlace");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceNotEqualTo(String value) {
            addCriterion("delivery_place <>", value, "deliveryPlace");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceGreaterThan(String value) {
            addCriterion("delivery_place >", value, "deliveryPlace");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_place >=", value, "deliveryPlace");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceLessThan(String value) {
            addCriterion("delivery_place <", value, "deliveryPlace");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceLessThanOrEqualTo(String value) {
            addCriterion("delivery_place <=", value, "deliveryPlace");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceLike(String value) {
            addCriterion("delivery_place like", value, "deliveryPlace");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceNotLike(String value) {
            addCriterion("delivery_place not like", value, "deliveryPlace");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceIn(List<String> values) {
            addCriterion("delivery_place in", values, "deliveryPlace");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceNotIn(List<String> values) {
            addCriterion("delivery_place not in", values, "deliveryPlace");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceBetween(String value1, String value2) {
            addCriterion("delivery_place between", value1, value2, "deliveryPlace");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceNotBetween(String value1, String value2) {
            addCriterion("delivery_place not between", value1, value2, "deliveryPlace");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateIsNull() {
            addCriterion("delivery_date is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateIsNotNull() {
            addCriterion("delivery_date is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateEqualTo(String value) {
            addCriterion("delivery_date =", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotEqualTo(String value) {
            addCriterion("delivery_date <>", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateGreaterThan(String value) {
            addCriterion("delivery_date >", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_date >=", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateLessThan(String value) {
            addCriterion("delivery_date <", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateLessThanOrEqualTo(String value) {
            addCriterion("delivery_date <=", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateLike(String value) {
            addCriterion("delivery_date like", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotLike(String value) {
            addCriterion("delivery_date not like", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateIn(List<String> values) {
            addCriterion("delivery_date in", values, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotIn(List<String> values) {
            addCriterion("delivery_date not in", values, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateBetween(String value1, String value2) {
            addCriterion("delivery_date between", value1, value2, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotBetween(String value1, String value2) {
            addCriterion("delivery_date not between", value1, value2, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateIsNull() {
            addCriterion("contract_sign_date is null");
            return (Criteria) this;
        }

        public Criteria andContractSignDateIsNotNull() {
            addCriterion("contract_sign_date is not null");
            return (Criteria) this;
        }

        public Criteria andContractSignDateEqualTo(String value) {
            addCriterion("contract_sign_date =", value, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateNotEqualTo(String value) {
            addCriterion("contract_sign_date <>", value, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateGreaterThan(String value) {
            addCriterion("contract_sign_date >", value, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateGreaterThanOrEqualTo(String value) {
            addCriterion("contract_sign_date >=", value, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateLessThan(String value) {
            addCriterion("contract_sign_date <", value, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateLessThanOrEqualTo(String value) {
            addCriterion("contract_sign_date <=", value, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateLike(String value) {
            addCriterion("contract_sign_date like", value, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateNotLike(String value) {
            addCriterion("contract_sign_date not like", value, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateIn(List<String> values) {
            addCriterion("contract_sign_date in", values, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateNotIn(List<String> values) {
            addCriterion("contract_sign_date not in", values, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateBetween(String value1, String value2) {
            addCriterion("contract_sign_date between", value1, value2, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateNotBetween(String value1, String value2) {
            addCriterion("contract_sign_date not between", value1, value2, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andTotalCountIsNull() {
            addCriterion("total_count is null");
            return (Criteria) this;
        }

        public Criteria andTotalCountIsNotNull() {
            addCriterion("total_count is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCountEqualTo(Integer value) {
            addCriterion("total_count =", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotEqualTo(Integer value) {
            addCriterion("total_count <>", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountGreaterThan(Integer value) {
            addCriterion("total_count >", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_count >=", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountLessThan(Integer value) {
            addCriterion("total_count <", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountLessThanOrEqualTo(Integer value) {
            addCriterion("total_count <=", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountIn(List<Integer> values) {
            addCriterion("total_count in", values, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotIn(List<Integer> values) {
            addCriterion("total_count not in", values, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountBetween(Integer value1, Integer value2) {
            addCriterion("total_count between", value1, value2, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotBetween(Integer value1, Integer value2) {
            addCriterion("total_count not between", value1, value2, "totalCount");
            return (Criteria) this;
        }

        public Criteria andDiscountTotalPriceIsNull() {
            addCriterion("discount_total_price is null");
            return (Criteria) this;
        }

        public Criteria andDiscountTotalPriceIsNotNull() {
            addCriterion("discount_total_price is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountTotalPriceEqualTo(BigDecimal value) {
            addCriterion("discount_total_price =", value, "discountTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountTotalPriceNotEqualTo(BigDecimal value) {
            addCriterion("discount_total_price <>", value, "discountTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountTotalPriceGreaterThan(BigDecimal value) {
            addCriterion("discount_total_price >", value, "discountTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_total_price >=", value, "discountTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountTotalPriceLessThan(BigDecimal value) {
            addCriterion("discount_total_price <", value, "discountTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountTotalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_total_price <=", value, "discountTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountTotalPriceIn(List<BigDecimal> values) {
            addCriterion("discount_total_price in", values, "discountTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountTotalPriceNotIn(List<BigDecimal> values) {
            addCriterion("discount_total_price not in", values, "discountTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_total_price between", value1, value2, "discountTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_total_price not between", value1, value2, "discountTotalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(BigDecimal value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(BigDecimal value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(BigDecimal value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(BigDecimal value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<BigDecimal> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<BigDecimal> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireIsNull() {
            addCriterion("special_require is null");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireIsNotNull() {
            addCriterion("special_require is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireEqualTo(String value) {
            addCriterion("special_require =", value, "specialRequire");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireNotEqualTo(String value) {
            addCriterion("special_require <>", value, "specialRequire");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireGreaterThan(String value) {
            addCriterion("special_require >", value, "specialRequire");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireGreaterThanOrEqualTo(String value) {
            addCriterion("special_require >=", value, "specialRequire");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireLessThan(String value) {
            addCriterion("special_require <", value, "specialRequire");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireLessThanOrEqualTo(String value) {
            addCriterion("special_require <=", value, "specialRequire");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireLike(String value) {
            addCriterion("special_require like", value, "specialRequire");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireNotLike(String value) {
            addCriterion("special_require not like", value, "specialRequire");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireIn(List<String> values) {
            addCriterion("special_require in", values, "specialRequire");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireNotIn(List<String> values) {
            addCriterion("special_require not in", values, "specialRequire");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireBetween(String value1, String value2) {
            addCriterion("special_require between", value1, value2, "specialRequire");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireNotBetween(String value1, String value2) {
            addCriterion("special_require not between", value1, value2, "specialRequire");
            return (Criteria) this;
        }

        public Criteria andCargoInformationIsNull() {
            addCriterion("cargo_information is null");
            return (Criteria) this;
        }

        public Criteria andCargoInformationIsNotNull() {
            addCriterion("cargo_information is not null");
            return (Criteria) this;
        }

        public Criteria andCargoInformationEqualTo(String value) {
            addCriterion("cargo_information =", value, "cargoInformation");
            return (Criteria) this;
        }

        public Criteria andCargoInformationNotEqualTo(String value) {
            addCriterion("cargo_information <>", value, "cargoInformation");
            return (Criteria) this;
        }

        public Criteria andCargoInformationGreaterThan(String value) {
            addCriterion("cargo_information >", value, "cargoInformation");
            return (Criteria) this;
        }

        public Criteria andCargoInformationGreaterThanOrEqualTo(String value) {
            addCriterion("cargo_information >=", value, "cargoInformation");
            return (Criteria) this;
        }

        public Criteria andCargoInformationLessThan(String value) {
            addCriterion("cargo_information <", value, "cargoInformation");
            return (Criteria) this;
        }

        public Criteria andCargoInformationLessThanOrEqualTo(String value) {
            addCriterion("cargo_information <=", value, "cargoInformation");
            return (Criteria) this;
        }

        public Criteria andCargoInformationLike(String value) {
            addCriterion("cargo_information like", value, "cargoInformation");
            return (Criteria) this;
        }

        public Criteria andCargoInformationNotLike(String value) {
            addCriterion("cargo_information not like", value, "cargoInformation");
            return (Criteria) this;
        }

        public Criteria andCargoInformationIn(List<String> values) {
            addCriterion("cargo_information in", values, "cargoInformation");
            return (Criteria) this;
        }

        public Criteria andCargoInformationNotIn(List<String> values) {
            addCriterion("cargo_information not in", values, "cargoInformation");
            return (Criteria) this;
        }

        public Criteria andCargoInformationBetween(String value1, String value2) {
            addCriterion("cargo_information between", value1, value2, "cargoInformation");
            return (Criteria) this;
        }

        public Criteria andCargoInformationNotBetween(String value1, String value2) {
            addCriterion("cargo_information not between", value1, value2, "cargoInformation");
            return (Criteria) this;
        }

        public Criteria andSignBoardIsNull() {
            addCriterion("sign_board is null");
            return (Criteria) this;
        }

        public Criteria andSignBoardIsNotNull() {
            addCriterion("sign_board is not null");
            return (Criteria) this;
        }

        public Criteria andSignBoardEqualTo(String value) {
            addCriterion("sign_board =", value, "signBoard");
            return (Criteria) this;
        }

        public Criteria andSignBoardNotEqualTo(String value) {
            addCriterion("sign_board <>", value, "signBoard");
            return (Criteria) this;
        }

        public Criteria andSignBoardGreaterThan(String value) {
            addCriterion("sign_board >", value, "signBoard");
            return (Criteria) this;
        }

        public Criteria andSignBoardGreaterThanOrEqualTo(String value) {
            addCriterion("sign_board >=", value, "signBoard");
            return (Criteria) this;
        }

        public Criteria andSignBoardLessThan(String value) {
            addCriterion("sign_board <", value, "signBoard");
            return (Criteria) this;
        }

        public Criteria andSignBoardLessThanOrEqualTo(String value) {
            addCriterion("sign_board <=", value, "signBoard");
            return (Criteria) this;
        }

        public Criteria andSignBoardLike(String value) {
            addCriterion("sign_board like", value, "signBoard");
            return (Criteria) this;
        }

        public Criteria andSignBoardNotLike(String value) {
            addCriterion("sign_board not like", value, "signBoard");
            return (Criteria) this;
        }

        public Criteria andSignBoardIn(List<String> values) {
            addCriterion("sign_board in", values, "signBoard");
            return (Criteria) this;
        }

        public Criteria andSignBoardNotIn(List<String> values) {
            addCriterion("sign_board not in", values, "signBoard");
            return (Criteria) this;
        }

        public Criteria andSignBoardBetween(String value1, String value2) {
            addCriterion("sign_board between", value1, value2, "signBoard");
            return (Criteria) this;
        }

        public Criteria andSignBoardNotBetween(String value1, String value2) {
            addCriterion("sign_board not between", value1, value2, "signBoard");
            return (Criteria) this;
        }

        public Criteria andAcceptanceCriteriaIsNull() {
            addCriterion("acceptance_criteria is null");
            return (Criteria) this;
        }

        public Criteria andAcceptanceCriteriaIsNotNull() {
            addCriterion("acceptance_criteria is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptanceCriteriaEqualTo(String value) {
            addCriterion("acceptance_criteria =", value, "acceptanceCriteria");
            return (Criteria) this;
        }

        public Criteria andAcceptanceCriteriaNotEqualTo(String value) {
            addCriterion("acceptance_criteria <>", value, "acceptanceCriteria");
            return (Criteria) this;
        }

        public Criteria andAcceptanceCriteriaGreaterThan(String value) {
            addCriterion("acceptance_criteria >", value, "acceptanceCriteria");
            return (Criteria) this;
        }

        public Criteria andAcceptanceCriteriaGreaterThanOrEqualTo(String value) {
            addCriterion("acceptance_criteria >=", value, "acceptanceCriteria");
            return (Criteria) this;
        }

        public Criteria andAcceptanceCriteriaLessThan(String value) {
            addCriterion("acceptance_criteria <", value, "acceptanceCriteria");
            return (Criteria) this;
        }

        public Criteria andAcceptanceCriteriaLessThanOrEqualTo(String value) {
            addCriterion("acceptance_criteria <=", value, "acceptanceCriteria");
            return (Criteria) this;
        }

        public Criteria andAcceptanceCriteriaLike(String value) {
            addCriterion("acceptance_criteria like", value, "acceptanceCriteria");
            return (Criteria) this;
        }

        public Criteria andAcceptanceCriteriaNotLike(String value) {
            addCriterion("acceptance_criteria not like", value, "acceptanceCriteria");
            return (Criteria) this;
        }

        public Criteria andAcceptanceCriteriaIn(List<String> values) {
            addCriterion("acceptance_criteria in", values, "acceptanceCriteria");
            return (Criteria) this;
        }

        public Criteria andAcceptanceCriteriaNotIn(List<String> values) {
            addCriterion("acceptance_criteria not in", values, "acceptanceCriteria");
            return (Criteria) this;
        }

        public Criteria andAcceptanceCriteriaBetween(String value1, String value2) {
            addCriterion("acceptance_criteria between", value1, value2, "acceptanceCriteria");
            return (Criteria) this;
        }

        public Criteria andAcceptanceCriteriaNotBetween(String value1, String value2) {
            addCriterion("acceptance_criteria not between", value1, value2, "acceptanceCriteria");
            return (Criteria) this;
        }

        public Criteria andWarrantyPeriodIsNull() {
            addCriterion("warranty_period is null");
            return (Criteria) this;
        }

        public Criteria andWarrantyPeriodIsNotNull() {
            addCriterion("warranty_period is not null");
            return (Criteria) this;
        }

        public Criteria andWarrantyPeriodEqualTo(String value) {
            addCriterion("warranty_period =", value, "warrantyPeriod");
            return (Criteria) this;
        }

        public Criteria andWarrantyPeriodNotEqualTo(String value) {
            addCriterion("warranty_period <>", value, "warrantyPeriod");
            return (Criteria) this;
        }

        public Criteria andWarrantyPeriodGreaterThan(String value) {
            addCriterion("warranty_period >", value, "warrantyPeriod");
            return (Criteria) this;
        }

        public Criteria andWarrantyPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("warranty_period >=", value, "warrantyPeriod");
            return (Criteria) this;
        }

        public Criteria andWarrantyPeriodLessThan(String value) {
            addCriterion("warranty_period <", value, "warrantyPeriod");
            return (Criteria) this;
        }

        public Criteria andWarrantyPeriodLessThanOrEqualTo(String value) {
            addCriterion("warranty_period <=", value, "warrantyPeriod");
            return (Criteria) this;
        }

        public Criteria andWarrantyPeriodLike(String value) {
            addCriterion("warranty_period like", value, "warrantyPeriod");
            return (Criteria) this;
        }

        public Criteria andWarrantyPeriodNotLike(String value) {
            addCriterion("warranty_period not like", value, "warrantyPeriod");
            return (Criteria) this;
        }

        public Criteria andWarrantyPeriodIn(List<String> values) {
            addCriterion("warranty_period in", values, "warrantyPeriod");
            return (Criteria) this;
        }

        public Criteria andWarrantyPeriodNotIn(List<String> values) {
            addCriterion("warranty_period not in", values, "warrantyPeriod");
            return (Criteria) this;
        }

        public Criteria andWarrantyPeriodBetween(String value1, String value2) {
            addCriterion("warranty_period between", value1, value2, "warrantyPeriod");
            return (Criteria) this;
        }

        public Criteria andWarrantyPeriodNotBetween(String value1, String value2) {
            addCriterion("warranty_period not between", value1, value2, "warrantyPeriod");
            return (Criteria) this;
        }

        public Criteria andPackagingSpecificationIsNull() {
            addCriterion("packaging_specification is null");
            return (Criteria) this;
        }

        public Criteria andPackagingSpecificationIsNotNull() {
            addCriterion("packaging_specification is not null");
            return (Criteria) this;
        }

        public Criteria andPackagingSpecificationEqualTo(String value) {
            addCriterion("packaging_specification =", value, "packagingSpecification");
            return (Criteria) this;
        }

        public Criteria andPackagingSpecificationNotEqualTo(String value) {
            addCriterion("packaging_specification <>", value, "packagingSpecification");
            return (Criteria) this;
        }

        public Criteria andPackagingSpecificationGreaterThan(String value) {
            addCriterion("packaging_specification >", value, "packagingSpecification");
            return (Criteria) this;
        }

        public Criteria andPackagingSpecificationGreaterThanOrEqualTo(String value) {
            addCriterion("packaging_specification >=", value, "packagingSpecification");
            return (Criteria) this;
        }

        public Criteria andPackagingSpecificationLessThan(String value) {
            addCriterion("packaging_specification <", value, "packagingSpecification");
            return (Criteria) this;
        }

        public Criteria andPackagingSpecificationLessThanOrEqualTo(String value) {
            addCriterion("packaging_specification <=", value, "packagingSpecification");
            return (Criteria) this;
        }

        public Criteria andPackagingSpecificationLike(String value) {
            addCriterion("packaging_specification like", value, "packagingSpecification");
            return (Criteria) this;
        }

        public Criteria andPackagingSpecificationNotLike(String value) {
            addCriterion("packaging_specification not like", value, "packagingSpecification");
            return (Criteria) this;
        }

        public Criteria andPackagingSpecificationIn(List<String> values) {
            addCriterion("packaging_specification in", values, "packagingSpecification");
            return (Criteria) this;
        }

        public Criteria andPackagingSpecificationNotIn(List<String> values) {
            addCriterion("packaging_specification not in", values, "packagingSpecification");
            return (Criteria) this;
        }

        public Criteria andPackagingSpecificationBetween(String value1, String value2) {
            addCriterion("packaging_specification between", value1, value2, "packagingSpecification");
            return (Criteria) this;
        }

        public Criteria andPackagingSpecificationNotBetween(String value1, String value2) {
            addCriterion("packaging_specification not between", value1, value2, "packagingSpecification");
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

        public Criteria andDeliverStatusIsNull() {
            addCriterion("deliver_status is null");
            return (Criteria) this;
        }

        public Criteria andDeliverStatusIsNotNull() {
            addCriterion("deliver_status is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverStatusEqualTo(Byte value) {
            addCriterion("deliver_status =", value, "deliverStatus");
            return (Criteria) this;
        }

        public Criteria andDeliverStatusNotEqualTo(Byte value) {
            addCriterion("deliver_status <>", value, "deliverStatus");
            return (Criteria) this;
        }

        public Criteria andDeliverStatusGreaterThan(Byte value) {
            addCriterion("deliver_status >", value, "deliverStatus");
            return (Criteria) this;
        }

        public Criteria andDeliverStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("deliver_status >=", value, "deliverStatus");
            return (Criteria) this;
        }

        public Criteria andDeliverStatusLessThan(Byte value) {
            addCriterion("deliver_status <", value, "deliverStatus");
            return (Criteria) this;
        }

        public Criteria andDeliverStatusLessThanOrEqualTo(Byte value) {
            addCriterion("deliver_status <=", value, "deliverStatus");
            return (Criteria) this;
        }

        public Criteria andDeliverStatusIn(List<Byte> values) {
            addCriterion("deliver_status in", values, "deliverStatus");
            return (Criteria) this;
        }

        public Criteria andDeliverStatusNotIn(List<Byte> values) {
            addCriterion("deliver_status not in", values, "deliverStatus");
            return (Criteria) this;
        }

        public Criteria andDeliverStatusBetween(Byte value1, Byte value2) {
            addCriterion("deliver_status between", value1, value2, "deliverStatus");
            return (Criteria) this;
        }

        public Criteria andDeliverStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("deliver_status not between", value1, value2, "deliverStatus");
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

        public Criteria andPressureQualifiedNumberIsNull() {
            addCriterion("pressure_qualified_number is null");
            return (Criteria) this;
        }

        public Criteria andPressureQualifiedNumberIsNotNull() {
            addCriterion("pressure_qualified_number is not null");
            return (Criteria) this;
        }

        public Criteria andPressureQualifiedNumberEqualTo(Integer value) {
            addCriterion("pressure_qualified_number =", value, "pressureQualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andPressureQualifiedNumberNotEqualTo(Integer value) {
            addCriterion("pressure_qualified_number <>", value, "pressureQualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andPressureQualifiedNumberGreaterThan(Integer value) {
            addCriterion("pressure_qualified_number >", value, "pressureQualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andPressureQualifiedNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("pressure_qualified_number >=", value, "pressureQualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andPressureQualifiedNumberLessThan(Integer value) {
            addCriterion("pressure_qualified_number <", value, "pressureQualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andPressureQualifiedNumberLessThanOrEqualTo(Integer value) {
            addCriterion("pressure_qualified_number <=", value, "pressureQualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andPressureQualifiedNumberIn(List<Integer> values) {
            addCriterion("pressure_qualified_number in", values, "pressureQualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andPressureQualifiedNumberNotIn(List<Integer> values) {
            addCriterion("pressure_qualified_number not in", values, "pressureQualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andPressureQualifiedNumberBetween(Integer value1, Integer value2) {
            addCriterion("pressure_qualified_number between", value1, value2, "pressureQualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andPressureQualifiedNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("pressure_qualified_number not between", value1, value2, "pressureQualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andDeliveredNumberIsNull() {
            addCriterion("delivered_number is null");
            return (Criteria) this;
        }

        public Criteria andDeliveredNumberIsNotNull() {
            addCriterion("delivered_number is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveredNumberEqualTo(Integer value) {
            addCriterion("delivered_number =", value, "deliveredNumber");
            return (Criteria) this;
        }

        public Criteria andDeliveredNumberNotEqualTo(Integer value) {
            addCriterion("delivered_number <>", value, "deliveredNumber");
            return (Criteria) this;
        }

        public Criteria andDeliveredNumberGreaterThan(Integer value) {
            addCriterion("delivered_number >", value, "deliveredNumber");
            return (Criteria) this;
        }

        public Criteria andDeliveredNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("delivered_number >=", value, "deliveredNumber");
            return (Criteria) this;
        }

        public Criteria andDeliveredNumberLessThan(Integer value) {
            addCriterion("delivered_number <", value, "deliveredNumber");
            return (Criteria) this;
        }

        public Criteria andDeliveredNumberLessThanOrEqualTo(Integer value) {
            addCriterion("delivered_number <=", value, "deliveredNumber");
            return (Criteria) this;
        }

        public Criteria andDeliveredNumberIn(List<Integer> values) {
            addCriterion("delivered_number in", values, "deliveredNumber");
            return (Criteria) this;
        }

        public Criteria andDeliveredNumberNotIn(List<Integer> values) {
            addCriterion("delivered_number not in", values, "deliveredNumber");
            return (Criteria) this;
        }

        public Criteria andDeliveredNumberBetween(Integer value1, Integer value2) {
            addCriterion("delivered_number between", value1, value2, "deliveredNumber");
            return (Criteria) this;
        }

        public Criteria andDeliveredNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("delivered_number not between", value1, value2, "deliveredNumber");
            return (Criteria) this;
        }

        public Criteria andReceivedAccountIsNull() {
            addCriterion("received_account is null");
            return (Criteria) this;
        }

        public Criteria andReceivedAccountIsNotNull() {
            addCriterion("received_account is not null");
            return (Criteria) this;
        }

        public Criteria andReceivedAccountEqualTo(BigDecimal value) {
            addCriterion("received_account =", value, "receivedAccount");
            return (Criteria) this;
        }

        public Criteria andReceivedAccountNotEqualTo(BigDecimal value) {
            addCriterion("received_account <>", value, "receivedAccount");
            return (Criteria) this;
        }

        public Criteria andReceivedAccountGreaterThan(BigDecimal value) {
            addCriterion("received_account >", value, "receivedAccount");
            return (Criteria) this;
        }

        public Criteria andReceivedAccountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("received_account >=", value, "receivedAccount");
            return (Criteria) this;
        }

        public Criteria andReceivedAccountLessThan(BigDecimal value) {
            addCriterion("received_account <", value, "receivedAccount");
            return (Criteria) this;
        }

        public Criteria andReceivedAccountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("received_account <=", value, "receivedAccount");
            return (Criteria) this;
        }

        public Criteria andReceivedAccountIn(List<BigDecimal> values) {
            addCriterion("received_account in", values, "receivedAccount");
            return (Criteria) this;
        }

        public Criteria andReceivedAccountNotIn(List<BigDecimal> values) {
            addCriterion("received_account not in", values, "receivedAccount");
            return (Criteria) this;
        }

        public Criteria andReceivedAccountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("received_account between", value1, value2, "receivedAccount");
            return (Criteria) this;
        }

        public Criteria andReceivedAccountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("received_account not between", value1, value2, "receivedAccount");
            return (Criteria) this;
        }

        public Criteria andGenPickingListIsNull() {
            addCriterion("gen_picking_list is null");
            return (Criteria) this;
        }

        public Criteria andGenPickingListIsNotNull() {
            addCriterion("gen_picking_list is not null");
            return (Criteria) this;
        }

        public Criteria andGenPickingListEqualTo(Byte value) {
            addCriterion("gen_picking_list =", value, "genPickingList");
            return (Criteria) this;
        }

        public Criteria andGenPickingListNotEqualTo(Byte value) {
            addCriterion("gen_picking_list <>", value, "genPickingList");
            return (Criteria) this;
        }

        public Criteria andGenPickingListGreaterThan(Byte value) {
            addCriterion("gen_picking_list >", value, "genPickingList");
            return (Criteria) this;
        }

        public Criteria andGenPickingListGreaterThanOrEqualTo(Byte value) {
            addCriterion("gen_picking_list >=", value, "genPickingList");
            return (Criteria) this;
        }

        public Criteria andGenPickingListLessThan(Byte value) {
            addCriterion("gen_picking_list <", value, "genPickingList");
            return (Criteria) this;
        }

        public Criteria andGenPickingListLessThanOrEqualTo(Byte value) {
            addCriterion("gen_picking_list <=", value, "genPickingList");
            return (Criteria) this;
        }

        public Criteria andGenPickingListIn(List<Byte> values) {
            addCriterion("gen_picking_list in", values, "genPickingList");
            return (Criteria) this;
        }

        public Criteria andGenPickingListNotIn(List<Byte> values) {
            addCriterion("gen_picking_list not in", values, "genPickingList");
            return (Criteria) this;
        }

        public Criteria andGenPickingListBetween(Byte value1, Byte value2) {
            addCriterion("gen_picking_list between", value1, value2, "genPickingList");
            return (Criteria) this;
        }

        public Criteria andGenPickingListNotBetween(Byte value1, Byte value2) {
            addCriterion("gen_picking_list not between", value1, value2, "genPickingList");
            return (Criteria) this;
        }

        public Criteria andIsCheckMaterialIsNull() {
            addCriterion("is_check_material is null");
            return (Criteria) this;
        }

        public Criteria andIsCheckMaterialIsNotNull() {
            addCriterion("is_check_material is not null");
            return (Criteria) this;
        }

        public Criteria andIsCheckMaterialEqualTo(Byte value) {
            addCriterion("is_check_material =", value, "isCheckMaterial");
            return (Criteria) this;
        }

        public Criteria andIsCheckMaterialNotEqualTo(Byte value) {
            addCriterion("is_check_material <>", value, "isCheckMaterial");
            return (Criteria) this;
        }

        public Criteria andIsCheckMaterialGreaterThan(Byte value) {
            addCriterion("is_check_material >", value, "isCheckMaterial");
            return (Criteria) this;
        }

        public Criteria andIsCheckMaterialGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_check_material >=", value, "isCheckMaterial");
            return (Criteria) this;
        }

        public Criteria andIsCheckMaterialLessThan(Byte value) {
            addCriterion("is_check_material <", value, "isCheckMaterial");
            return (Criteria) this;
        }

        public Criteria andIsCheckMaterialLessThanOrEqualTo(Byte value) {
            addCriterion("is_check_material <=", value, "isCheckMaterial");
            return (Criteria) this;
        }

        public Criteria andIsCheckMaterialIn(List<Byte> values) {
            addCriterion("is_check_material in", values, "isCheckMaterial");
            return (Criteria) this;
        }

        public Criteria andIsCheckMaterialNotIn(List<Byte> values) {
            addCriterion("is_check_material not in", values, "isCheckMaterial");
            return (Criteria) this;
        }

        public Criteria andIsCheckMaterialBetween(Byte value1, Byte value2) {
            addCriterion("is_check_material between", value1, value2, "isCheckMaterial");
            return (Criteria) this;
        }

        public Criteria andIsCheckMaterialNotBetween(Byte value1, Byte value2) {
            addCriterion("is_check_material not between", value1, value2, "isCheckMaterial");
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