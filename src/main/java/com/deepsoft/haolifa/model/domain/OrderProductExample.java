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

        public Criteria andDemandTelphoneIsNull() {
            addCriterion("demand_telphone is null");
            return (Criteria) this;
        }

        public Criteria andDemandTelphoneIsNotNull() {
            addCriterion("demand_telphone is not null");
            return (Criteria) this;
        }

        public Criteria andDemandTelphoneEqualTo(String value) {
            addCriterion("demand_telphone =", value, "demandTelphone");
            return (Criteria) this;
        }

        public Criteria andDemandTelphoneNotEqualTo(String value) {
            addCriterion("demand_telphone <>", value, "demandTelphone");
            return (Criteria) this;
        }

        public Criteria andDemandTelphoneGreaterThan(String value) {
            addCriterion("demand_telphone >", value, "demandTelphone");
            return (Criteria) this;
        }

        public Criteria andDemandTelphoneGreaterThanOrEqualTo(String value) {
            addCriterion("demand_telphone >=", value, "demandTelphone");
            return (Criteria) this;
        }

        public Criteria andDemandTelphoneLessThan(String value) {
            addCriterion("demand_telphone <", value, "demandTelphone");
            return (Criteria) this;
        }

        public Criteria andDemandTelphoneLessThanOrEqualTo(String value) {
            addCriterion("demand_telphone <=", value, "demandTelphone");
            return (Criteria) this;
        }

        public Criteria andDemandTelphoneLike(String value) {
            addCriterion("demand_telphone like", value, "demandTelphone");
            return (Criteria) this;
        }

        public Criteria andDemandTelphoneNotLike(String value) {
            addCriterion("demand_telphone not like", value, "demandTelphone");
            return (Criteria) this;
        }

        public Criteria andDemandTelphoneIn(List<String> values) {
            addCriterion("demand_telphone in", values, "demandTelphone");
            return (Criteria) this;
        }

        public Criteria andDemandTelphoneNotIn(List<String> values) {
            addCriterion("demand_telphone not in", values, "demandTelphone");
            return (Criteria) this;
        }

        public Criteria andDemandTelphoneBetween(String value1, String value2) {
            addCriterion("demand_telphone between", value1, value2, "demandTelphone");
            return (Criteria) this;
        }

        public Criteria andDemandTelphoneNotBetween(String value1, String value2) {
            addCriterion("demand_telphone not between", value1, value2, "demandTelphone");
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

        public Criteria andDemandAddressIsNull() {
            addCriterion("demand_address is null");
            return (Criteria) this;
        }

        public Criteria andDemandAddressIsNotNull() {
            addCriterion("demand_address is not null");
            return (Criteria) this;
        }

        public Criteria andDemandAddressEqualTo(String value) {
            addCriterion("demand_address =", value, "demandAddress");
            return (Criteria) this;
        }

        public Criteria andDemandAddressNotEqualTo(String value) {
            addCriterion("demand_address <>", value, "demandAddress");
            return (Criteria) this;
        }

        public Criteria andDemandAddressGreaterThan(String value) {
            addCriterion("demand_address >", value, "demandAddress");
            return (Criteria) this;
        }

        public Criteria andDemandAddressGreaterThanOrEqualTo(String value) {
            addCriterion("demand_address >=", value, "demandAddress");
            return (Criteria) this;
        }

        public Criteria andDemandAddressLessThan(String value) {
            addCriterion("demand_address <", value, "demandAddress");
            return (Criteria) this;
        }

        public Criteria andDemandAddressLessThanOrEqualTo(String value) {
            addCriterion("demand_address <=", value, "demandAddress");
            return (Criteria) this;
        }

        public Criteria andDemandAddressLike(String value) {
            addCriterion("demand_address like", value, "demandAddress");
            return (Criteria) this;
        }

        public Criteria andDemandAddressNotLike(String value) {
            addCriterion("demand_address not like", value, "demandAddress");
            return (Criteria) this;
        }

        public Criteria andDemandAddressIn(List<String> values) {
            addCriterion("demand_address in", values, "demandAddress");
            return (Criteria) this;
        }

        public Criteria andDemandAddressNotIn(List<String> values) {
            addCriterion("demand_address not in", values, "demandAddress");
            return (Criteria) this;
        }

        public Criteria andDemandAddressBetween(String value1, String value2) {
            addCriterion("demand_address between", value1, value2, "demandAddress");
            return (Criteria) this;
        }

        public Criteria andDemandAddressNotBetween(String value1, String value2) {
            addCriterion("demand_address not between", value1, value2, "demandAddress");
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

        public Criteria andSupplyTelphoneIsNull() {
            addCriterion("supply_telphone is null");
            return (Criteria) this;
        }

        public Criteria andSupplyTelphoneIsNotNull() {
            addCriterion("supply_telphone is not null");
            return (Criteria) this;
        }

        public Criteria andSupplyTelphoneEqualTo(String value) {
            addCriterion("supply_telphone =", value, "supplyTelphone");
            return (Criteria) this;
        }

        public Criteria andSupplyTelphoneNotEqualTo(String value) {
            addCriterion("supply_telphone <>", value, "supplyTelphone");
            return (Criteria) this;
        }

        public Criteria andSupplyTelphoneGreaterThan(String value) {
            addCriterion("supply_telphone >", value, "supplyTelphone");
            return (Criteria) this;
        }

        public Criteria andSupplyTelphoneGreaterThanOrEqualTo(String value) {
            addCriterion("supply_telphone >=", value, "supplyTelphone");
            return (Criteria) this;
        }

        public Criteria andSupplyTelphoneLessThan(String value) {
            addCriterion("supply_telphone <", value, "supplyTelphone");
            return (Criteria) this;
        }

        public Criteria andSupplyTelphoneLessThanOrEqualTo(String value) {
            addCriterion("supply_telphone <=", value, "supplyTelphone");
            return (Criteria) this;
        }

        public Criteria andSupplyTelphoneLike(String value) {
            addCriterion("supply_telphone like", value, "supplyTelphone");
            return (Criteria) this;
        }

        public Criteria andSupplyTelphoneNotLike(String value) {
            addCriterion("supply_telphone not like", value, "supplyTelphone");
            return (Criteria) this;
        }

        public Criteria andSupplyTelphoneIn(List<String> values) {
            addCriterion("supply_telphone in", values, "supplyTelphone");
            return (Criteria) this;
        }

        public Criteria andSupplyTelphoneNotIn(List<String> values) {
            addCriterion("supply_telphone not in", values, "supplyTelphone");
            return (Criteria) this;
        }

        public Criteria andSupplyTelphoneBetween(String value1, String value2) {
            addCriterion("supply_telphone between", value1, value2, "supplyTelphone");
            return (Criteria) this;
        }

        public Criteria andSupplyTelphoneNotBetween(String value1, String value2) {
            addCriterion("supply_telphone not between", value1, value2, "supplyTelphone");
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

        public Criteria andSupplyAddressIsNull() {
            addCriterion("supply_address is null");
            return (Criteria) this;
        }

        public Criteria andSupplyAddressIsNotNull() {
            addCriterion("supply_address is not null");
            return (Criteria) this;
        }

        public Criteria andSupplyAddressEqualTo(String value) {
            addCriterion("supply_address =", value, "supplyAddress");
            return (Criteria) this;
        }

        public Criteria andSupplyAddressNotEqualTo(String value) {
            addCriterion("supply_address <>", value, "supplyAddress");
            return (Criteria) this;
        }

        public Criteria andSupplyAddressGreaterThan(String value) {
            addCriterion("supply_address >", value, "supplyAddress");
            return (Criteria) this;
        }

        public Criteria andSupplyAddressGreaterThanOrEqualTo(String value) {
            addCriterion("supply_address >=", value, "supplyAddress");
            return (Criteria) this;
        }

        public Criteria andSupplyAddressLessThan(String value) {
            addCriterion("supply_address <", value, "supplyAddress");
            return (Criteria) this;
        }

        public Criteria andSupplyAddressLessThanOrEqualTo(String value) {
            addCriterion("supply_address <=", value, "supplyAddress");
            return (Criteria) this;
        }

        public Criteria andSupplyAddressLike(String value) {
            addCriterion("supply_address like", value, "supplyAddress");
            return (Criteria) this;
        }

        public Criteria andSupplyAddressNotLike(String value) {
            addCriterion("supply_address not like", value, "supplyAddress");
            return (Criteria) this;
        }

        public Criteria andSupplyAddressIn(List<String> values) {
            addCriterion("supply_address in", values, "supplyAddress");
            return (Criteria) this;
        }

        public Criteria andSupplyAddressNotIn(List<String> values) {
            addCriterion("supply_address not in", values, "supplyAddress");
            return (Criteria) this;
        }

        public Criteria andSupplyAddressBetween(String value1, String value2) {
            addCriterion("supply_address between", value1, value2, "supplyAddress");
            return (Criteria) this;
        }

        public Criteria andSupplyAddressNotBetween(String value1, String value2) {
            addCriterion("supply_address not between", value1, value2, "supplyAddress");
            return (Criteria) this;
        }

        public Criteria andContractNumberIsNull() {
            addCriterion("contract_number is null");
            return (Criteria) this;
        }

        public Criteria andContractNumberIsNotNull() {
            addCriterion("contract_number is not null");
            return (Criteria) this;
        }

        public Criteria andContractNumberEqualTo(String value) {
            addCriterion("contract_number =", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberNotEqualTo(String value) {
            addCriterion("contract_number <>", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberGreaterThan(String value) {
            addCriterion("contract_number >", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberGreaterThanOrEqualTo(String value) {
            addCriterion("contract_number >=", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberLessThan(String value) {
            addCriterion("contract_number <", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberLessThanOrEqualTo(String value) {
            addCriterion("contract_number <=", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberLike(String value) {
            addCriterion("contract_number like", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberNotLike(String value) {
            addCriterion("contract_number not like", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberIn(List<String> values) {
            addCriterion("contract_number in", values, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberNotIn(List<String> values) {
            addCriterion("contract_number not in", values, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberBetween(String value1, String value2) {
            addCriterion("contract_number between", value1, value2, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberNotBetween(String value1, String value2) {
            addCriterion("contract_number not between", value1, value2, "contractNumber");
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

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
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

        public Criteria andLableIsNull() {
            addCriterion("lable is null");
            return (Criteria) this;
        }

        public Criteria andLableIsNotNull() {
            addCriterion("lable is not null");
            return (Criteria) this;
        }

        public Criteria andLableEqualTo(String value) {
            addCriterion("lable =", value, "lable");
            return (Criteria) this;
        }

        public Criteria andLableNotEqualTo(String value) {
            addCriterion("lable <>", value, "lable");
            return (Criteria) this;
        }

        public Criteria andLableGreaterThan(String value) {
            addCriterion("lable >", value, "lable");
            return (Criteria) this;
        }

        public Criteria andLableGreaterThanOrEqualTo(String value) {
            addCriterion("lable >=", value, "lable");
            return (Criteria) this;
        }

        public Criteria andLableLessThan(String value) {
            addCriterion("lable <", value, "lable");
            return (Criteria) this;
        }

        public Criteria andLableLessThanOrEqualTo(String value) {
            addCriterion("lable <=", value, "lable");
            return (Criteria) this;
        }

        public Criteria andLableLike(String value) {
            addCriterion("lable like", value, "lable");
            return (Criteria) this;
        }

        public Criteria andLableNotLike(String value) {
            addCriterion("lable not like", value, "lable");
            return (Criteria) this;
        }

        public Criteria andLableIn(List<String> values) {
            addCriterion("lable in", values, "lable");
            return (Criteria) this;
        }

        public Criteria andLableNotIn(List<String> values) {
            addCriterion("lable not in", values, "lable");
            return (Criteria) this;
        }

        public Criteria andLableBetween(String value1, String value2) {
            addCriterion("lable between", value1, value2, "lable");
            return (Criteria) this;
        }

        public Criteria andLableNotBetween(String value1, String value2) {
            addCriterion("lable not between", value1, value2, "lable");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIsNull() {
            addCriterion("specifications is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIsNotNull() {
            addCriterion("specifications is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationsEqualTo(String value) {
            addCriterion("specifications =", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotEqualTo(String value) {
            addCriterion("specifications <>", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsGreaterThan(String value) {
            addCriterion("specifications >", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsGreaterThanOrEqualTo(String value) {
            addCriterion("specifications >=", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLessThan(String value) {
            addCriterion("specifications <", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLessThanOrEqualTo(String value) {
            addCriterion("specifications <=", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLike(String value) {
            addCriterion("specifications like", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotLike(String value) {
            addCriterion("specifications not like", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIn(List<String> values) {
            addCriterion("specifications in", values, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotIn(List<String> values) {
            addCriterion("specifications not in", values, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsBetween(String value1, String value2) {
            addCriterion("specifications between", value1, value2, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotBetween(String value1, String value2) {
            addCriterion("specifications not between", value1, value2, "specifications");
            return (Criteria) this;
        }

        public Criteria andProductColorIsNull() {
            addCriterion("product_color is null");
            return (Criteria) this;
        }

        public Criteria andProductColorIsNotNull() {
            addCriterion("product_color is not null");
            return (Criteria) this;
        }

        public Criteria andProductColorEqualTo(String value) {
            addCriterion("product_color =", value, "productColor");
            return (Criteria) this;
        }

        public Criteria andProductColorNotEqualTo(String value) {
            addCriterion("product_color <>", value, "productColor");
            return (Criteria) this;
        }

        public Criteria andProductColorGreaterThan(String value) {
            addCriterion("product_color >", value, "productColor");
            return (Criteria) this;
        }

        public Criteria andProductColorGreaterThanOrEqualTo(String value) {
            addCriterion("product_color >=", value, "productColor");
            return (Criteria) this;
        }

        public Criteria andProductColorLessThan(String value) {
            addCriterion("product_color <", value, "productColor");
            return (Criteria) this;
        }

        public Criteria andProductColorLessThanOrEqualTo(String value) {
            addCriterion("product_color <=", value, "productColor");
            return (Criteria) this;
        }

        public Criteria andProductColorLike(String value) {
            addCriterion("product_color like", value, "productColor");
            return (Criteria) this;
        }

        public Criteria andProductColorNotLike(String value) {
            addCriterion("product_color not like", value, "productColor");
            return (Criteria) this;
        }

        public Criteria andProductColorIn(List<String> values) {
            addCriterion("product_color in", values, "productColor");
            return (Criteria) this;
        }

        public Criteria andProductColorNotIn(List<String> values) {
            addCriterion("product_color not in", values, "productColor");
            return (Criteria) this;
        }

        public Criteria andProductColorBetween(String value1, String value2) {
            addCriterion("product_color between", value1, value2, "productColor");
            return (Criteria) this;
        }

        public Criteria andProductColorNotBetween(String value1, String value2) {
            addCriterion("product_color not between", value1, value2, "productColor");
            return (Criteria) this;
        }

        public Criteria andProductNumberIsNull() {
            addCriterion("product_number is null");
            return (Criteria) this;
        }

        public Criteria andProductNumberIsNotNull() {
            addCriterion("product_number is not null");
            return (Criteria) this;
        }

        public Criteria andProductNumberEqualTo(Integer value) {
            addCriterion("product_number =", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberNotEqualTo(Integer value) {
            addCriterion("product_number <>", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberGreaterThan(Integer value) {
            addCriterion("product_number >", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_number >=", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberLessThan(Integer value) {
            addCriterion("product_number <", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberLessThanOrEqualTo(Integer value) {
            addCriterion("product_number <=", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberIn(List<Integer> values) {
            addCriterion("product_number in", values, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberNotIn(List<Integer> values) {
            addCriterion("product_number not in", values, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberBetween(Integer value1, Integer value2) {
            addCriterion("product_number between", value1, value2, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("product_number not between", value1, value2, "productNumber");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
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

        public Criteria andMaterialDescriptionIsNull() {
            addCriterion("material_description is null");
            return (Criteria) this;
        }

        public Criteria andMaterialDescriptionIsNotNull() {
            addCriterion("material_description is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialDescriptionEqualTo(String value) {
            addCriterion("material_description =", value, "materialDescription");
            return (Criteria) this;
        }

        public Criteria andMaterialDescriptionNotEqualTo(String value) {
            addCriterion("material_description <>", value, "materialDescription");
            return (Criteria) this;
        }

        public Criteria andMaterialDescriptionGreaterThan(String value) {
            addCriterion("material_description >", value, "materialDescription");
            return (Criteria) this;
        }

        public Criteria andMaterialDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("material_description >=", value, "materialDescription");
            return (Criteria) this;
        }

        public Criteria andMaterialDescriptionLessThan(String value) {
            addCriterion("material_description <", value, "materialDescription");
            return (Criteria) this;
        }

        public Criteria andMaterialDescriptionLessThanOrEqualTo(String value) {
            addCriterion("material_description <=", value, "materialDescription");
            return (Criteria) this;
        }

        public Criteria andMaterialDescriptionLike(String value) {
            addCriterion("material_description like", value, "materialDescription");
            return (Criteria) this;
        }

        public Criteria andMaterialDescriptionNotLike(String value) {
            addCriterion("material_description not like", value, "materialDescription");
            return (Criteria) this;
        }

        public Criteria andMaterialDescriptionIn(List<String> values) {
            addCriterion("material_description in", values, "materialDescription");
            return (Criteria) this;
        }

        public Criteria andMaterialDescriptionNotIn(List<String> values) {
            addCriterion("material_description not in", values, "materialDescription");
            return (Criteria) this;
        }

        public Criteria andMaterialDescriptionBetween(String value1, String value2) {
            addCriterion("material_description between", value1, value2, "materialDescription");
            return (Criteria) this;
        }

        public Criteria andMaterialDescriptionNotBetween(String value1, String value2) {
            addCriterion("material_description not between", value1, value2, "materialDescription");
            return (Criteria) this;
        }

        public Criteria andProductRemarkIsNull() {
            addCriterion("product_remark is null");
            return (Criteria) this;
        }

        public Criteria andProductRemarkIsNotNull() {
            addCriterion("product_remark is not null");
            return (Criteria) this;
        }

        public Criteria andProductRemarkEqualTo(String value) {
            addCriterion("product_remark =", value, "productRemark");
            return (Criteria) this;
        }

        public Criteria andProductRemarkNotEqualTo(String value) {
            addCriterion("product_remark <>", value, "productRemark");
            return (Criteria) this;
        }

        public Criteria andProductRemarkGreaterThan(String value) {
            addCriterion("product_remark >", value, "productRemark");
            return (Criteria) this;
        }

        public Criteria andProductRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("product_remark >=", value, "productRemark");
            return (Criteria) this;
        }

        public Criteria andProductRemarkLessThan(String value) {
            addCriterion("product_remark <", value, "productRemark");
            return (Criteria) this;
        }

        public Criteria andProductRemarkLessThanOrEqualTo(String value) {
            addCriterion("product_remark <=", value, "productRemark");
            return (Criteria) this;
        }

        public Criteria andProductRemarkLike(String value) {
            addCriterion("product_remark like", value, "productRemark");
            return (Criteria) this;
        }

        public Criteria andProductRemarkNotLike(String value) {
            addCriterion("product_remark not like", value, "productRemark");
            return (Criteria) this;
        }

        public Criteria andProductRemarkIn(List<String> values) {
            addCriterion("product_remark in", values, "productRemark");
            return (Criteria) this;
        }

        public Criteria andProductRemarkNotIn(List<String> values) {
            addCriterion("product_remark not in", values, "productRemark");
            return (Criteria) this;
        }

        public Criteria andProductRemarkBetween(String value1, String value2) {
            addCriterion("product_remark between", value1, value2, "productRemark");
            return (Criteria) this;
        }

        public Criteria andProductRemarkNotBetween(String value1, String value2) {
            addCriterion("product_remark not between", value1, value2, "productRemark");
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

        public Criteria andTransportTypeIsNull() {
            addCriterion("transport_type is null");
            return (Criteria) this;
        }

        public Criteria andTransportTypeIsNotNull() {
            addCriterion("transport_type is not null");
            return (Criteria) this;
        }

        public Criteria andTransportTypeEqualTo(String value) {
            addCriterion("transport_type =", value, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeNotEqualTo(String value) {
            addCriterion("transport_type <>", value, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeGreaterThan(String value) {
            addCriterion("transport_type >", value, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeGreaterThanOrEqualTo(String value) {
            addCriterion("transport_type >=", value, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeLessThan(String value) {
            addCriterion("transport_type <", value, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeLessThanOrEqualTo(String value) {
            addCriterion("transport_type <=", value, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeLike(String value) {
            addCriterion("transport_type like", value, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeNotLike(String value) {
            addCriterion("transport_type not like", value, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeIn(List<String> values) {
            addCriterion("transport_type in", values, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeNotIn(List<String> values) {
            addCriterion("transport_type not in", values, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeBetween(String value1, String value2) {
            addCriterion("transport_type between", value1, value2, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeNotBetween(String value1, String value2) {
            addCriterion("transport_type not between", value1, value2, "transportType");
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

        public Criteria andDeliveryTimeEqualTo(String value) {
            addCriterion("delivery_time =", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotEqualTo(String value) {
            addCriterion("delivery_time <>", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThan(String value) {
            addCriterion("delivery_time >", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_time >=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThan(String value) {
            addCriterion("delivery_time <", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThanOrEqualTo(String value) {
            addCriterion("delivery_time <=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLike(String value) {
            addCriterion("delivery_time like", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotLike(String value) {
            addCriterion("delivery_time not like", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIn(List<String> values) {
            addCriterion("delivery_time in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotIn(List<String> values) {
            addCriterion("delivery_time not in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeBetween(String value1, String value2) {
            addCriterion("delivery_time between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotBetween(String value1, String value2) {
            addCriterion("delivery_time not between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andReceiptInfoIsNull() {
            addCriterion("receipt_info is null");
            return (Criteria) this;
        }

        public Criteria andReceiptInfoIsNotNull() {
            addCriterion("receipt_info is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptInfoEqualTo(String value) {
            addCriterion("receipt_info =", value, "receiptInfo");
            return (Criteria) this;
        }

        public Criteria andReceiptInfoNotEqualTo(String value) {
            addCriterion("receipt_info <>", value, "receiptInfo");
            return (Criteria) this;
        }

        public Criteria andReceiptInfoGreaterThan(String value) {
            addCriterion("receipt_info >", value, "receiptInfo");
            return (Criteria) this;
        }

        public Criteria andReceiptInfoGreaterThanOrEqualTo(String value) {
            addCriterion("receipt_info >=", value, "receiptInfo");
            return (Criteria) this;
        }

        public Criteria andReceiptInfoLessThan(String value) {
            addCriterion("receipt_info <", value, "receiptInfo");
            return (Criteria) this;
        }

        public Criteria andReceiptInfoLessThanOrEqualTo(String value) {
            addCriterion("receipt_info <=", value, "receiptInfo");
            return (Criteria) this;
        }

        public Criteria andReceiptInfoLike(String value) {
            addCriterion("receipt_info like", value, "receiptInfo");
            return (Criteria) this;
        }

        public Criteria andReceiptInfoNotLike(String value) {
            addCriterion("receipt_info not like", value, "receiptInfo");
            return (Criteria) this;
        }

        public Criteria andReceiptInfoIn(List<String> values) {
            addCriterion("receipt_info in", values, "receiptInfo");
            return (Criteria) this;
        }

        public Criteria andReceiptInfoNotIn(List<String> values) {
            addCriterion("receipt_info not in", values, "receiptInfo");
            return (Criteria) this;
        }

        public Criteria andReceiptInfoBetween(String value1, String value2) {
            addCriterion("receipt_info between", value1, value2, "receiptInfo");
            return (Criteria) this;
        }

        public Criteria andReceiptInfoNotBetween(String value1, String value2) {
            addCriterion("receipt_info not between", value1, value2, "receiptInfo");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIsNull() {
            addCriterion("payment_method is null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIsNotNull() {
            addCriterion("payment_method is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodEqualTo(String value) {
            addCriterion("payment_method =", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotEqualTo(String value) {
            addCriterion("payment_method <>", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThan(String value) {
            addCriterion("payment_method >", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThanOrEqualTo(String value) {
            addCriterion("payment_method >=", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThan(String value) {
            addCriterion("payment_method <", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThanOrEqualTo(String value) {
            addCriterion("payment_method <=", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLike(String value) {
            addCriterion("payment_method like", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotLike(String value) {
            addCriterion("payment_method not like", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIn(List<String> values) {
            addCriterion("payment_method in", values, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotIn(List<String> values) {
            addCriterion("payment_method not in", values, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodBetween(String value1, String value2) {
            addCriterion("payment_method between", value1, value2, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotBetween(String value1, String value2) {
            addCriterion("payment_method not between", value1, value2, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andFreightIsNull() {
            addCriterion("freight is null");
            return (Criteria) this;
        }

        public Criteria andFreightIsNotNull() {
            addCriterion("freight is not null");
            return (Criteria) this;
        }

        public Criteria andFreightEqualTo(String value) {
            addCriterion("freight =", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotEqualTo(String value) {
            addCriterion("freight <>", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThan(String value) {
            addCriterion("freight >", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThanOrEqualTo(String value) {
            addCriterion("freight >=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThan(String value) {
            addCriterion("freight <", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThanOrEqualTo(String value) {
            addCriterion("freight <=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLike(String value) {
            addCriterion("freight like", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotLike(String value) {
            addCriterion("freight not like", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightIn(List<String> values) {
            addCriterion("freight in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotIn(List<String> values) {
            addCriterion("freight not in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightBetween(String value1, String value2) {
            addCriterion("freight between", value1, value2, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotBetween(String value1, String value2) {
            addCriterion("freight not between", value1, value2, "freight");
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