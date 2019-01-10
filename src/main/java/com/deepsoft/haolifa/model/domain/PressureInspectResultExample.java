package com.deepsoft.haolifa.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PressureInspectResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PressureInspectResultExample() {
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

        public Criteria andInspectNoIsNull() {
            addCriterion("inspect_no is null");
            return (Criteria) this;
        }

        public Criteria andInspectNoIsNotNull() {
            addCriterion("inspect_no is not null");
            return (Criteria) this;
        }

        public Criteria andInspectNoEqualTo(String value) {
            addCriterion("inspect_no =", value, "inspectNo");
            return (Criteria) this;
        }

        public Criteria andInspectNoNotEqualTo(String value) {
            addCriterion("inspect_no <>", value, "inspectNo");
            return (Criteria) this;
        }

        public Criteria andInspectNoGreaterThan(String value) {
            addCriterion("inspect_no >", value, "inspectNo");
            return (Criteria) this;
        }

        public Criteria andInspectNoGreaterThanOrEqualTo(String value) {
            addCriterion("inspect_no >=", value, "inspectNo");
            return (Criteria) this;
        }

        public Criteria andInspectNoLessThan(String value) {
            addCriterion("inspect_no <", value, "inspectNo");
            return (Criteria) this;
        }

        public Criteria andInspectNoLessThanOrEqualTo(String value) {
            addCriterion("inspect_no <=", value, "inspectNo");
            return (Criteria) this;
        }

        public Criteria andInspectNoLike(String value) {
            addCriterion("inspect_no like", value, "inspectNo");
            return (Criteria) this;
        }

        public Criteria andInspectNoNotLike(String value) {
            addCriterion("inspect_no not like", value, "inspectNo");
            return (Criteria) this;
        }

        public Criteria andInspectNoIn(List<String> values) {
            addCriterion("inspect_no in", values, "inspectNo");
            return (Criteria) this;
        }

        public Criteria andInspectNoNotIn(List<String> values) {
            addCriterion("inspect_no not in", values, "inspectNo");
            return (Criteria) this;
        }

        public Criteria andInspectNoBetween(String value1, String value2) {
            addCriterion("inspect_no between", value1, value2, "inspectNo");
            return (Criteria) this;
        }

        public Criteria andInspectNoNotBetween(String value1, String value2) {
            addCriterion("inspect_no not between", value1, value2, "inspectNo");
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

        public Criteria andTestingNumberIsNull() {
            addCriterion("testing_number is null");
            return (Criteria) this;
        }

        public Criteria andTestingNumberIsNotNull() {
            addCriterion("testing_number is not null");
            return (Criteria) this;
        }

        public Criteria andTestingNumberEqualTo(Integer value) {
            addCriterion("testing_number =", value, "testingNumber");
            return (Criteria) this;
        }

        public Criteria andTestingNumberNotEqualTo(Integer value) {
            addCriterion("testing_number <>", value, "testingNumber");
            return (Criteria) this;
        }

        public Criteria andTestingNumberGreaterThan(Integer value) {
            addCriterion("testing_number >", value, "testingNumber");
            return (Criteria) this;
        }

        public Criteria andTestingNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("testing_number >=", value, "testingNumber");
            return (Criteria) this;
        }

        public Criteria andTestingNumberLessThan(Integer value) {
            addCriterion("testing_number <", value, "testingNumber");
            return (Criteria) this;
        }

        public Criteria andTestingNumberLessThanOrEqualTo(Integer value) {
            addCriterion("testing_number <=", value, "testingNumber");
            return (Criteria) this;
        }

        public Criteria andTestingNumberIn(List<Integer> values) {
            addCriterion("testing_number in", values, "testingNumber");
            return (Criteria) this;
        }

        public Criteria andTestingNumberNotIn(List<Integer> values) {
            addCriterion("testing_number not in", values, "testingNumber");
            return (Criteria) this;
        }

        public Criteria andTestingNumberBetween(Integer value1, Integer value2) {
            addCriterion("testing_number between", value1, value2, "testingNumber");
            return (Criteria) this;
        }

        public Criteria andTestingNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("testing_number not between", value1, value2, "testingNumber");
            return (Criteria) this;
        }

        public Criteria andReinspectNumberIsNull() {
            addCriterion("reinspect_number is null");
            return (Criteria) this;
        }

        public Criteria andReinspectNumberIsNotNull() {
            addCriterion("reinspect_number is not null");
            return (Criteria) this;
        }

        public Criteria andReinspectNumberEqualTo(Integer value) {
            addCriterion("reinspect_number =", value, "reinspectNumber");
            return (Criteria) this;
        }

        public Criteria andReinspectNumberNotEqualTo(Integer value) {
            addCriterion("reinspect_number <>", value, "reinspectNumber");
            return (Criteria) this;
        }

        public Criteria andReinspectNumberGreaterThan(Integer value) {
            addCriterion("reinspect_number >", value, "reinspectNumber");
            return (Criteria) this;
        }

        public Criteria andReinspectNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("reinspect_number >=", value, "reinspectNumber");
            return (Criteria) this;
        }

        public Criteria andReinspectNumberLessThan(Integer value) {
            addCriterion("reinspect_number <", value, "reinspectNumber");
            return (Criteria) this;
        }

        public Criteria andReinspectNumberLessThanOrEqualTo(Integer value) {
            addCriterion("reinspect_number <=", value, "reinspectNumber");
            return (Criteria) this;
        }

        public Criteria andReinspectNumberIn(List<Integer> values) {
            addCriterion("reinspect_number in", values, "reinspectNumber");
            return (Criteria) this;
        }

        public Criteria andReinspectNumberNotIn(List<Integer> values) {
            addCriterion("reinspect_number not in", values, "reinspectNumber");
            return (Criteria) this;
        }

        public Criteria andReinspectNumberBetween(Integer value1, Integer value2) {
            addCriterion("reinspect_number between", value1, value2, "reinspectNumber");
            return (Criteria) this;
        }

        public Criteria andReinspectNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("reinspect_number not between", value1, value2, "reinspectNumber");
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

        public Criteria andUnqualifiedNumberIsNull() {
            addCriterion("unqualified_number is null");
            return (Criteria) this;
        }

        public Criteria andUnqualifiedNumberIsNotNull() {
            addCriterion("unqualified_number is not null");
            return (Criteria) this;
        }

        public Criteria andUnqualifiedNumberEqualTo(Integer value) {
            addCriterion("unqualified_number =", value, "unqualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andUnqualifiedNumberNotEqualTo(Integer value) {
            addCriterion("unqualified_number <>", value, "unqualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andUnqualifiedNumberGreaterThan(Integer value) {
            addCriterion("unqualified_number >", value, "unqualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andUnqualifiedNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("unqualified_number >=", value, "unqualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andUnqualifiedNumberLessThan(Integer value) {
            addCriterion("unqualified_number <", value, "unqualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andUnqualifiedNumberLessThanOrEqualTo(Integer value) {
            addCriterion("unqualified_number <=", value, "unqualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andUnqualifiedNumberIn(List<Integer> values) {
            addCriterion("unqualified_number in", values, "unqualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andUnqualifiedNumberNotIn(List<Integer> values) {
            addCriterion("unqualified_number not in", values, "unqualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andUnqualifiedNumberBetween(Integer value1, Integer value2) {
            addCriterion("unqualified_number between", value1, value2, "unqualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andUnqualifiedNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("unqualified_number not between", value1, value2, "unqualifiedNumber");
            return (Criteria) this;
        }

        public Criteria andInspecteTimeIsNull() {
            addCriterion("inspecte_time is null");
            return (Criteria) this;
        }

        public Criteria andInspecteTimeIsNotNull() {
            addCriterion("inspecte_time is not null");
            return (Criteria) this;
        }

        public Criteria andInspecteTimeEqualTo(Date value) {
            addCriterion("inspecte_time =", value, "inspecteTime");
            return (Criteria) this;
        }

        public Criteria andInspecteTimeNotEqualTo(Date value) {
            addCriterion("inspecte_time <>", value, "inspecteTime");
            return (Criteria) this;
        }

        public Criteria andInspecteTimeGreaterThan(Date value) {
            addCriterion("inspecte_time >", value, "inspecteTime");
            return (Criteria) this;
        }

        public Criteria andInspecteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("inspecte_time >=", value, "inspecteTime");
            return (Criteria) this;
        }

        public Criteria andInspecteTimeLessThan(Date value) {
            addCriterion("inspecte_time <", value, "inspecteTime");
            return (Criteria) this;
        }

        public Criteria andInspecteTimeLessThanOrEqualTo(Date value) {
            addCriterion("inspecte_time <=", value, "inspecteTime");
            return (Criteria) this;
        }

        public Criteria andInspecteTimeIn(List<Date> values) {
            addCriterion("inspecte_time in", values, "inspecteTime");
            return (Criteria) this;
        }

        public Criteria andInspecteTimeNotIn(List<Date> values) {
            addCriterion("inspecte_time not in", values, "inspecteTime");
            return (Criteria) this;
        }

        public Criteria andInspecteTimeBetween(Date value1, Date value2) {
            addCriterion("inspecte_time between", value1, value2, "inspecteTime");
            return (Criteria) this;
        }

        public Criteria andInspecteTimeNotBetween(Date value1, Date value2) {
            addCriterion("inspecte_time not between", value1, value2, "inspecteTime");
            return (Criteria) this;
        }

        public Criteria andTestingPersonIsNull() {
            addCriterion("testing_person is null");
            return (Criteria) this;
        }

        public Criteria andTestingPersonIsNotNull() {
            addCriterion("testing_person is not null");
            return (Criteria) this;
        }

        public Criteria andTestingPersonEqualTo(String value) {
            addCriterion("testing_person =", value, "testingPerson");
            return (Criteria) this;
        }

        public Criteria andTestingPersonNotEqualTo(String value) {
            addCriterion("testing_person <>", value, "testingPerson");
            return (Criteria) this;
        }

        public Criteria andTestingPersonGreaterThan(String value) {
            addCriterion("testing_person >", value, "testingPerson");
            return (Criteria) this;
        }

        public Criteria andTestingPersonGreaterThanOrEqualTo(String value) {
            addCriterion("testing_person >=", value, "testingPerson");
            return (Criteria) this;
        }

        public Criteria andTestingPersonLessThan(String value) {
            addCriterion("testing_person <", value, "testingPerson");
            return (Criteria) this;
        }

        public Criteria andTestingPersonLessThanOrEqualTo(String value) {
            addCriterion("testing_person <=", value, "testingPerson");
            return (Criteria) this;
        }

        public Criteria andTestingPersonLike(String value) {
            addCriterion("testing_person like", value, "testingPerson");
            return (Criteria) this;
        }

        public Criteria andTestingPersonNotLike(String value) {
            addCriterion("testing_person not like", value, "testingPerson");
            return (Criteria) this;
        }

        public Criteria andTestingPersonIn(List<String> values) {
            addCriterion("testing_person in", values, "testingPerson");
            return (Criteria) this;
        }

        public Criteria andTestingPersonNotIn(List<String> values) {
            addCriterion("testing_person not in", values, "testingPerson");
            return (Criteria) this;
        }

        public Criteria andTestingPersonBetween(String value1, String value2) {
            addCriterion("testing_person between", value1, value2, "testingPerson");
            return (Criteria) this;
        }

        public Criteria andTestingPersonNotBetween(String value1, String value2) {
            addCriterion("testing_person not between", value1, value2, "testingPerson");
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