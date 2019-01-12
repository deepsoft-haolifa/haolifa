package com.deepsoft.haolifa.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderMaterialExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderMaterialExample() {
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

        public Criteria andMaterialNameIsNull() {
            addCriterion("material_name is null");
            return (Criteria) this;
        }

        public Criteria andMaterialNameIsNotNull() {
            addCriterion("material_name is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialNameEqualTo(String value) {
            addCriterion("material_name =", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotEqualTo(String value) {
            addCriterion("material_name <>", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameGreaterThan(String value) {
            addCriterion("material_name >", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameGreaterThanOrEqualTo(String value) {
            addCriterion("material_name >=", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLessThan(String value) {
            addCriterion("material_name <", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLessThanOrEqualTo(String value) {
            addCriterion("material_name <=", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLike(String value) {
            addCriterion("material_name like", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotLike(String value) {
            addCriterion("material_name not like", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameIn(List<String> values) {
            addCriterion("material_name in", values, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotIn(List<String> values) {
            addCriterion("material_name not in", values, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameBetween(String value1, String value2) {
            addCriterion("material_name between", value1, value2, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotBetween(String value1, String value2) {
            addCriterion("material_name not between", value1, value2, "materialName");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialGraphNoIsNull() {
            addCriterion("replace_material_graph_no is null");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialGraphNoIsNotNull() {
            addCriterion("replace_material_graph_no is not null");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialGraphNoEqualTo(String value) {
            addCriterion("replace_material_graph_no =", value, "replaceMaterialGraphNo");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialGraphNoNotEqualTo(String value) {
            addCriterion("replace_material_graph_no <>", value, "replaceMaterialGraphNo");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialGraphNoGreaterThan(String value) {
            addCriterion("replace_material_graph_no >", value, "replaceMaterialGraphNo");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialGraphNoGreaterThanOrEqualTo(String value) {
            addCriterion("replace_material_graph_no >=", value, "replaceMaterialGraphNo");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialGraphNoLessThan(String value) {
            addCriterion("replace_material_graph_no <", value, "replaceMaterialGraphNo");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialGraphNoLessThanOrEqualTo(String value) {
            addCriterion("replace_material_graph_no <=", value, "replaceMaterialGraphNo");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialGraphNoLike(String value) {
            addCriterion("replace_material_graph_no like", value, "replaceMaterialGraphNo");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialGraphNoNotLike(String value) {
            addCriterion("replace_material_graph_no not like", value, "replaceMaterialGraphNo");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialGraphNoIn(List<String> values) {
            addCriterion("replace_material_graph_no in", values, "replaceMaterialGraphNo");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialGraphNoNotIn(List<String> values) {
            addCriterion("replace_material_graph_no not in", values, "replaceMaterialGraphNo");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialGraphNoBetween(String value1, String value2) {
            addCriterion("replace_material_graph_no between", value1, value2, "replaceMaterialGraphNo");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialGraphNoNotBetween(String value1, String value2) {
            addCriterion("replace_material_graph_no not between", value1, value2, "replaceMaterialGraphNo");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialNameIsNull() {
            addCriterion("replace_material_name is null");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialNameIsNotNull() {
            addCriterion("replace_material_name is not null");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialNameEqualTo(String value) {
            addCriterion("replace_material_name =", value, "replaceMaterialName");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialNameNotEqualTo(String value) {
            addCriterion("replace_material_name <>", value, "replaceMaterialName");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialNameGreaterThan(String value) {
            addCriterion("replace_material_name >", value, "replaceMaterialName");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialNameGreaterThanOrEqualTo(String value) {
            addCriterion("replace_material_name >=", value, "replaceMaterialName");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialNameLessThan(String value) {
            addCriterion("replace_material_name <", value, "replaceMaterialName");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialNameLessThanOrEqualTo(String value) {
            addCriterion("replace_material_name <=", value, "replaceMaterialName");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialNameLike(String value) {
            addCriterion("replace_material_name like", value, "replaceMaterialName");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialNameNotLike(String value) {
            addCriterion("replace_material_name not like", value, "replaceMaterialName");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialNameIn(List<String> values) {
            addCriterion("replace_material_name in", values, "replaceMaterialName");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialNameNotIn(List<String> values) {
            addCriterion("replace_material_name not in", values, "replaceMaterialName");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialNameBetween(String value1, String value2) {
            addCriterion("replace_material_name between", value1, value2, "replaceMaterialName");
            return (Criteria) this;
        }

        public Criteria andReplaceMaterialNameNotBetween(String value1, String value2) {
            addCriterion("replace_material_name not between", value1, value2, "replaceMaterialName");
            return (Criteria) this;
        }

        public Criteria andIsReplaceIsNull() {
            addCriterion("is_replace is null");
            return (Criteria) this;
        }

        public Criteria andIsReplaceIsNotNull() {
            addCriterion("is_replace is not null");
            return (Criteria) this;
        }

        public Criteria andIsReplaceEqualTo(Byte value) {
            addCriterion("is_replace =", value, "isReplace");
            return (Criteria) this;
        }

        public Criteria andIsReplaceNotEqualTo(Byte value) {
            addCriterion("is_replace <>", value, "isReplace");
            return (Criteria) this;
        }

        public Criteria andIsReplaceGreaterThan(Byte value) {
            addCriterion("is_replace >", value, "isReplace");
            return (Criteria) this;
        }

        public Criteria andIsReplaceGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_replace >=", value, "isReplace");
            return (Criteria) this;
        }

        public Criteria andIsReplaceLessThan(Byte value) {
            addCriterion("is_replace <", value, "isReplace");
            return (Criteria) this;
        }

        public Criteria andIsReplaceLessThanOrEqualTo(Byte value) {
            addCriterion("is_replace <=", value, "isReplace");
            return (Criteria) this;
        }

        public Criteria andIsReplaceIn(List<Byte> values) {
            addCriterion("is_replace in", values, "isReplace");
            return (Criteria) this;
        }

        public Criteria andIsReplaceNotIn(List<Byte> values) {
            addCriterion("is_replace not in", values, "isReplace");
            return (Criteria) this;
        }

        public Criteria andIsReplaceBetween(Byte value1, Byte value2) {
            addCriterion("is_replace between", value1, value2, "isReplace");
            return (Criteria) this;
        }

        public Criteria andIsReplaceNotBetween(Byte value1, Byte value2) {
            addCriterion("is_replace not between", value1, value2, "isReplace");
            return (Criteria) this;
        }

        public Criteria andMaterialCountIsNull() {
            addCriterion("material_count is null");
            return (Criteria) this;
        }

        public Criteria andMaterialCountIsNotNull() {
            addCriterion("material_count is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialCountEqualTo(Integer value) {
            addCriterion("material_count =", value, "materialCount");
            return (Criteria) this;
        }

        public Criteria andMaterialCountNotEqualTo(Integer value) {
            addCriterion("material_count <>", value, "materialCount");
            return (Criteria) this;
        }

        public Criteria andMaterialCountGreaterThan(Integer value) {
            addCriterion("material_count >", value, "materialCount");
            return (Criteria) this;
        }

        public Criteria andMaterialCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("material_count >=", value, "materialCount");
            return (Criteria) this;
        }

        public Criteria andMaterialCountLessThan(Integer value) {
            addCriterion("material_count <", value, "materialCount");
            return (Criteria) this;
        }

        public Criteria andMaterialCountLessThanOrEqualTo(Integer value) {
            addCriterion("material_count <=", value, "materialCount");
            return (Criteria) this;
        }

        public Criteria andMaterialCountIn(List<Integer> values) {
            addCriterion("material_count in", values, "materialCount");
            return (Criteria) this;
        }

        public Criteria andMaterialCountNotIn(List<Integer> values) {
            addCriterion("material_count not in", values, "materialCount");
            return (Criteria) this;
        }

        public Criteria andMaterialCountBetween(Integer value1, Integer value2) {
            addCriterion("material_count between", value1, value2, "materialCount");
            return (Criteria) this;
        }

        public Criteria andMaterialCountNotBetween(Integer value1, Integer value2) {
            addCriterion("material_count not between", value1, value2, "materialCount");
            return (Criteria) this;
        }

        public Criteria andLackMaterialCountIsNull() {
            addCriterion("lack_material_count is null");
            return (Criteria) this;
        }

        public Criteria andLackMaterialCountIsNotNull() {
            addCriterion("lack_material_count is not null");
            return (Criteria) this;
        }

        public Criteria andLackMaterialCountEqualTo(Integer value) {
            addCriterion("lack_material_count =", value, "lackMaterialCount");
            return (Criteria) this;
        }

        public Criteria andLackMaterialCountNotEqualTo(Integer value) {
            addCriterion("lack_material_count <>", value, "lackMaterialCount");
            return (Criteria) this;
        }

        public Criteria andLackMaterialCountGreaterThan(Integer value) {
            addCriterion("lack_material_count >", value, "lackMaterialCount");
            return (Criteria) this;
        }

        public Criteria andLackMaterialCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("lack_material_count >=", value, "lackMaterialCount");
            return (Criteria) this;
        }

        public Criteria andLackMaterialCountLessThan(Integer value) {
            addCriterion("lack_material_count <", value, "lackMaterialCount");
            return (Criteria) this;
        }

        public Criteria andLackMaterialCountLessThanOrEqualTo(Integer value) {
            addCriterion("lack_material_count <=", value, "lackMaterialCount");
            return (Criteria) this;
        }

        public Criteria andLackMaterialCountIn(List<Integer> values) {
            addCriterion("lack_material_count in", values, "lackMaterialCount");
            return (Criteria) this;
        }

        public Criteria andLackMaterialCountNotIn(List<Integer> values) {
            addCriterion("lack_material_count not in", values, "lackMaterialCount");
            return (Criteria) this;
        }

        public Criteria andLackMaterialCountBetween(Integer value1, Integer value2) {
            addCriterion("lack_material_count between", value1, value2, "lackMaterialCount");
            return (Criteria) this;
        }

        public Criteria andLackMaterialCountNotBetween(Integer value1, Integer value2) {
            addCriterion("lack_material_count not between", value1, value2, "lackMaterialCount");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNull() {
            addCriterion("check_status is null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNotNull() {
            addCriterion("check_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusEqualTo(Byte value) {
            addCriterion("check_status =", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotEqualTo(Byte value) {
            addCriterion("check_status <>", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThan(Byte value) {
            addCriterion("check_status >", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("check_status >=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThan(Byte value) {
            addCriterion("check_status <", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThanOrEqualTo(Byte value) {
            addCriterion("check_status <=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIn(List<Byte> values) {
            addCriterion("check_status in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotIn(List<Byte> values) {
            addCriterion("check_status not in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusBetween(Byte value1, Byte value2) {
            addCriterion("check_status between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("check_status not between", value1, value2, "checkStatus");
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