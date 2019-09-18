package com.deepsoft.haolifa.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GraphNoRelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GraphNoRelExample() {
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

        public Criteria andGraphNoIsNull() {
            addCriterion("graph_no is null");
            return (Criteria) this;
        }

        public Criteria andGraphNoIsNotNull() {
            addCriterion("graph_no is not null");
            return (Criteria) this;
        }

        public Criteria andGraphNoEqualTo(String value) {
            addCriterion("graph_no =", value, "graphNo");
            return (Criteria) this;
        }

        public Criteria andGraphNoNotEqualTo(String value) {
            addCriterion("graph_no <>", value, "graphNo");
            return (Criteria) this;
        }

        public Criteria andGraphNoGreaterThan(String value) {
            addCriterion("graph_no >", value, "graphNo");
            return (Criteria) this;
        }

        public Criteria andGraphNoGreaterThanOrEqualTo(String value) {
            addCriterion("graph_no >=", value, "graphNo");
            return (Criteria) this;
        }

        public Criteria andGraphNoLessThan(String value) {
            addCriterion("graph_no <", value, "graphNo");
            return (Criteria) this;
        }

        public Criteria andGraphNoLessThanOrEqualTo(String value) {
            addCriterion("graph_no <=", value, "graphNo");
            return (Criteria) this;
        }

        public Criteria andGraphNoLike(String value) {
            addCriterion("graph_no like", value, "graphNo");
            return (Criteria) this;
        }

        public Criteria andGraphNoNotLike(String value) {
            addCriterion("graph_no not like", value, "graphNo");
            return (Criteria) this;
        }

        public Criteria andGraphNoIn(List<String> values) {
            addCriterion("graph_no in", values, "graphNo");
            return (Criteria) this;
        }

        public Criteria andGraphNoNotIn(List<String> values) {
            addCriterion("graph_no not in", values, "graphNo");
            return (Criteria) this;
        }

        public Criteria andGraphNoBetween(String value1, String value2) {
            addCriterion("graph_no between", value1, value2, "graphNo");
            return (Criteria) this;
        }

        public Criteria andGraphNoNotBetween(String value1, String value2) {
            addCriterion("graph_no not between", value1, value2, "graphNo");
            return (Criteria) this;
        }

        public Criteria andGraphNoMIsNull() {
            addCriterion("graph_no_m is null");
            return (Criteria) this;
        }

        public Criteria andGraphNoMIsNotNull() {
            addCriterion("graph_no_m is not null");
            return (Criteria) this;
        }

        public Criteria andGraphNoMEqualTo(String value) {
            addCriterion("graph_no_m =", value, "graphNoM");
            return (Criteria) this;
        }

        public Criteria andGraphNoMNotEqualTo(String value) {
            addCriterion("graph_no_m <>", value, "graphNoM");
            return (Criteria) this;
        }

        public Criteria andGraphNoMGreaterThan(String value) {
            addCriterion("graph_no_m >", value, "graphNoM");
            return (Criteria) this;
        }

        public Criteria andGraphNoMGreaterThanOrEqualTo(String value) {
            addCriterion("graph_no_m >=", value, "graphNoM");
            return (Criteria) this;
        }

        public Criteria andGraphNoMLessThan(String value) {
            addCriterion("graph_no_m <", value, "graphNoM");
            return (Criteria) this;
        }

        public Criteria andGraphNoMLessThanOrEqualTo(String value) {
            addCriterion("graph_no_m <=", value, "graphNoM");
            return (Criteria) this;
        }

        public Criteria andGraphNoMLike(String value) {
            addCriterion("graph_no_m like", value, "graphNoM");
            return (Criteria) this;
        }

        public Criteria andGraphNoMNotLike(String value) {
            addCriterion("graph_no_m not like", value, "graphNoM");
            return (Criteria) this;
        }

        public Criteria andGraphNoMIn(List<String> values) {
            addCriterion("graph_no_m in", values, "graphNoM");
            return (Criteria) this;
        }

        public Criteria andGraphNoMNotIn(List<String> values) {
            addCriterion("graph_no_m not in", values, "graphNoM");
            return (Criteria) this;
        }

        public Criteria andGraphNoMBetween(String value1, String value2) {
            addCriterion("graph_no_m between", value1, value2, "graphNoM");
            return (Criteria) this;
        }

        public Criteria andGraphNoMNotBetween(String value1, String value2) {
            addCriterion("graph_no_m not between", value1, value2, "graphNoM");
            return (Criteria) this;
        }

        public Criteria andGraphNoJIsNull() {
            addCriterion("graph_no_j is null");
            return (Criteria) this;
        }

        public Criteria andGraphNoJIsNotNull() {
            addCriterion("graph_no_j is not null");
            return (Criteria) this;
        }

        public Criteria andGraphNoJEqualTo(String value) {
            addCriterion("graph_no_j =", value, "graphNoJ");
            return (Criteria) this;
        }

        public Criteria andGraphNoJNotEqualTo(String value) {
            addCriterion("graph_no_j <>", value, "graphNoJ");
            return (Criteria) this;
        }

        public Criteria andGraphNoJGreaterThan(String value) {
            addCriterion("graph_no_j >", value, "graphNoJ");
            return (Criteria) this;
        }

        public Criteria andGraphNoJGreaterThanOrEqualTo(String value) {
            addCriterion("graph_no_j >=", value, "graphNoJ");
            return (Criteria) this;
        }

        public Criteria andGraphNoJLessThan(String value) {
            addCriterion("graph_no_j <", value, "graphNoJ");
            return (Criteria) this;
        }

        public Criteria andGraphNoJLessThanOrEqualTo(String value) {
            addCriterion("graph_no_j <=", value, "graphNoJ");
            return (Criteria) this;
        }

        public Criteria andGraphNoJLike(String value) {
            addCriterion("graph_no_j like", value, "graphNoJ");
            return (Criteria) this;
        }

        public Criteria andGraphNoJNotLike(String value) {
            addCriterion("graph_no_j not like", value, "graphNoJ");
            return (Criteria) this;
        }

        public Criteria andGraphNoJIn(List<String> values) {
            addCriterion("graph_no_j in", values, "graphNoJ");
            return (Criteria) this;
        }

        public Criteria andGraphNoJNotIn(List<String> values) {
            addCriterion("graph_no_j not in", values, "graphNoJ");
            return (Criteria) this;
        }

        public Criteria andGraphNoJBetween(String value1, String value2) {
            addCriterion("graph_no_j between", value1, value2, "graphNoJ");
            return (Criteria) this;
        }

        public Criteria andGraphNoJNotBetween(String value1, String value2) {
            addCriterion("graph_no_j not between", value1, value2, "graphNoJ");
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