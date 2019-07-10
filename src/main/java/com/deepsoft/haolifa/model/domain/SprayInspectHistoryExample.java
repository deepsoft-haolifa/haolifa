package com.deepsoft.haolifa.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SprayInspectHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SprayInspectHistoryExample() {
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

        public Criteria andSprayNoIsNull() {
            addCriterion("spray_no is null");
            return (Criteria) this;
        }

        public Criteria andSprayNoIsNotNull() {
            addCriterion("spray_no is not null");
            return (Criteria) this;
        }

        public Criteria andSprayNoEqualTo(String value) {
            addCriterion("spray_no =", value, "sprayNo");
            return (Criteria) this;
        }

        public Criteria andSprayNoNotEqualTo(String value) {
            addCriterion("spray_no <>", value, "sprayNo");
            return (Criteria) this;
        }

        public Criteria andSprayNoGreaterThan(String value) {
            addCriterion("spray_no >", value, "sprayNo");
            return (Criteria) this;
        }

        public Criteria andSprayNoGreaterThanOrEqualTo(String value) {
            addCriterion("spray_no >=", value, "sprayNo");
            return (Criteria) this;
        }

        public Criteria andSprayNoLessThan(String value) {
            addCriterion("spray_no <", value, "sprayNo");
            return (Criteria) this;
        }

        public Criteria andSprayNoLessThanOrEqualTo(String value) {
            addCriterion("spray_no <=", value, "sprayNo");
            return (Criteria) this;
        }

        public Criteria andSprayNoLike(String value) {
            addCriterion("spray_no like", value, "sprayNo");
            return (Criteria) this;
        }

        public Criteria andSprayNoNotLike(String value) {
            addCriterion("spray_no not like", value, "sprayNo");
            return (Criteria) this;
        }

        public Criteria andSprayNoIn(List<String> values) {
            addCriterion("spray_no in", values, "sprayNo");
            return (Criteria) this;
        }

        public Criteria andSprayNoNotIn(List<String> values) {
            addCriterion("spray_no not in", values, "sprayNo");
            return (Criteria) this;
        }

        public Criteria andSprayNoBetween(String value1, String value2) {
            addCriterion("spray_no between", value1, value2, "sprayNo");
            return (Criteria) this;
        }

        public Criteria andSprayNoNotBetween(String value1, String value2) {
            addCriterion("spray_no not between", value1, value2, "sprayNo");
            return (Criteria) this;
        }

        public Criteria andOriginalGraphNoIsNull() {
            addCriterion("original_graph_no is null");
            return (Criteria) this;
        }

        public Criteria andOriginalGraphNoIsNotNull() {
            addCriterion("original_graph_no is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalGraphNoEqualTo(String value) {
            addCriterion("original_graph_no =", value, "originalGraphNo");
            return (Criteria) this;
        }

        public Criteria andOriginalGraphNoNotEqualTo(String value) {
            addCriterion("original_graph_no <>", value, "originalGraphNo");
            return (Criteria) this;
        }

        public Criteria andOriginalGraphNoGreaterThan(String value) {
            addCriterion("original_graph_no >", value, "originalGraphNo");
            return (Criteria) this;
        }

        public Criteria andOriginalGraphNoGreaterThanOrEqualTo(String value) {
            addCriterion("original_graph_no >=", value, "originalGraphNo");
            return (Criteria) this;
        }

        public Criteria andOriginalGraphNoLessThan(String value) {
            addCriterion("original_graph_no <", value, "originalGraphNo");
            return (Criteria) this;
        }

        public Criteria andOriginalGraphNoLessThanOrEqualTo(String value) {
            addCriterion("original_graph_no <=", value, "originalGraphNo");
            return (Criteria) this;
        }

        public Criteria andOriginalGraphNoLike(String value) {
            addCriterion("original_graph_no like", value, "originalGraphNo");
            return (Criteria) this;
        }

        public Criteria andOriginalGraphNoNotLike(String value) {
            addCriterion("original_graph_no not like", value, "originalGraphNo");
            return (Criteria) this;
        }

        public Criteria andOriginalGraphNoIn(List<String> values) {
            addCriterion("original_graph_no in", values, "originalGraphNo");
            return (Criteria) this;
        }

        public Criteria andOriginalGraphNoNotIn(List<String> values) {
            addCriterion("original_graph_no not in", values, "originalGraphNo");
            return (Criteria) this;
        }

        public Criteria andOriginalGraphNoBetween(String value1, String value2) {
            addCriterion("original_graph_no between", value1, value2, "originalGraphNo");
            return (Criteria) this;
        }

        public Criteria andOriginalGraphNoNotBetween(String value1, String value2) {
            addCriterion("original_graph_no not between", value1, value2, "originalGraphNo");
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

        public Criteria andMaterialGraphNameIsNull() {
            addCriterion("material_graph_name is null");
            return (Criteria) this;
        }

        public Criteria andMaterialGraphNameIsNotNull() {
            addCriterion("material_graph_name is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialGraphNameEqualTo(String value) {
            addCriterion("material_graph_name =", value, "materialGraphName");
            return (Criteria) this;
        }

        public Criteria andMaterialGraphNameNotEqualTo(String value) {
            addCriterion("material_graph_name <>", value, "materialGraphName");
            return (Criteria) this;
        }

        public Criteria andMaterialGraphNameGreaterThan(String value) {
            addCriterion("material_graph_name >", value, "materialGraphName");
            return (Criteria) this;
        }

        public Criteria andMaterialGraphNameGreaterThanOrEqualTo(String value) {
            addCriterion("material_graph_name >=", value, "materialGraphName");
            return (Criteria) this;
        }

        public Criteria andMaterialGraphNameLessThan(String value) {
            addCriterion("material_graph_name <", value, "materialGraphName");
            return (Criteria) this;
        }

        public Criteria andMaterialGraphNameLessThanOrEqualTo(String value) {
            addCriterion("material_graph_name <=", value, "materialGraphName");
            return (Criteria) this;
        }

        public Criteria andMaterialGraphNameLike(String value) {
            addCriterion("material_graph_name like", value, "materialGraphName");
            return (Criteria) this;
        }

        public Criteria andMaterialGraphNameNotLike(String value) {
            addCriterion("material_graph_name not like", value, "materialGraphName");
            return (Criteria) this;
        }

        public Criteria andMaterialGraphNameIn(List<String> values) {
            addCriterion("material_graph_name in", values, "materialGraphName");
            return (Criteria) this;
        }

        public Criteria andMaterialGraphNameNotIn(List<String> values) {
            addCriterion("material_graph_name not in", values, "materialGraphName");
            return (Criteria) this;
        }

        public Criteria andMaterialGraphNameBetween(String value1, String value2) {
            addCriterion("material_graph_name between", value1, value2, "materialGraphName");
            return (Criteria) this;
        }

        public Criteria andMaterialGraphNameNotBetween(String value1, String value2) {
            addCriterion("material_graph_name not between", value1, value2, "materialGraphName");
            return (Criteria) this;
        }

        public Criteria andTestNumberIsNull() {
            addCriterion("test_number is null");
            return (Criteria) this;
        }

        public Criteria andTestNumberIsNotNull() {
            addCriterion("test_number is not null");
            return (Criteria) this;
        }

        public Criteria andTestNumberEqualTo(Integer value) {
            addCriterion("test_number =", value, "testNumber");
            return (Criteria) this;
        }

        public Criteria andTestNumberNotEqualTo(Integer value) {
            addCriterion("test_number <>", value, "testNumber");
            return (Criteria) this;
        }

        public Criteria andTestNumberGreaterThan(Integer value) {
            addCriterion("test_number >", value, "testNumber");
            return (Criteria) this;
        }

        public Criteria andTestNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("test_number >=", value, "testNumber");
            return (Criteria) this;
        }

        public Criteria andTestNumberLessThan(Integer value) {
            addCriterion("test_number <", value, "testNumber");
            return (Criteria) this;
        }

        public Criteria andTestNumberLessThanOrEqualTo(Integer value) {
            addCriterion("test_number <=", value, "testNumber");
            return (Criteria) this;
        }

        public Criteria andTestNumberIn(List<Integer> values) {
            addCriterion("test_number in", values, "testNumber");
            return (Criteria) this;
        }

        public Criteria andTestNumberNotIn(List<Integer> values) {
            addCriterion("test_number not in", values, "testNumber");
            return (Criteria) this;
        }

        public Criteria andTestNumberBetween(Integer value1, Integer value2) {
            addCriterion("test_number between", value1, value2, "testNumber");
            return (Criteria) this;
        }

        public Criteria andTestNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("test_number not between", value1, value2, "testNumber");
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

        public Criteria andHandlingSuggestionIsNull() {
            addCriterion("handling_suggestion is null");
            return (Criteria) this;
        }

        public Criteria andHandlingSuggestionIsNotNull() {
            addCriterion("handling_suggestion is not null");
            return (Criteria) this;
        }

        public Criteria andHandlingSuggestionEqualTo(String value) {
            addCriterion("handling_suggestion =", value, "handlingSuggestion");
            return (Criteria) this;
        }

        public Criteria andHandlingSuggestionNotEqualTo(String value) {
            addCriterion("handling_suggestion <>", value, "handlingSuggestion");
            return (Criteria) this;
        }

        public Criteria andHandlingSuggestionGreaterThan(String value) {
            addCriterion("handling_suggestion >", value, "handlingSuggestion");
            return (Criteria) this;
        }

        public Criteria andHandlingSuggestionGreaterThanOrEqualTo(String value) {
            addCriterion("handling_suggestion >=", value, "handlingSuggestion");
            return (Criteria) this;
        }

        public Criteria andHandlingSuggestionLessThan(String value) {
            addCriterion("handling_suggestion <", value, "handlingSuggestion");
            return (Criteria) this;
        }

        public Criteria andHandlingSuggestionLessThanOrEqualTo(String value) {
            addCriterion("handling_suggestion <=", value, "handlingSuggestion");
            return (Criteria) this;
        }

        public Criteria andHandlingSuggestionLike(String value) {
            addCriterion("handling_suggestion like", value, "handlingSuggestion");
            return (Criteria) this;
        }

        public Criteria andHandlingSuggestionNotLike(String value) {
            addCriterion("handling_suggestion not like", value, "handlingSuggestion");
            return (Criteria) this;
        }

        public Criteria andHandlingSuggestionIn(List<String> values) {
            addCriterion("handling_suggestion in", values, "handlingSuggestion");
            return (Criteria) this;
        }

        public Criteria andHandlingSuggestionNotIn(List<String> values) {
            addCriterion("handling_suggestion not in", values, "handlingSuggestion");
            return (Criteria) this;
        }

        public Criteria andHandlingSuggestionBetween(String value1, String value2) {
            addCriterion("handling_suggestion between", value1, value2, "handlingSuggestion");
            return (Criteria) this;
        }

        public Criteria andHandlingSuggestionNotBetween(String value1, String value2) {
            addCriterion("handling_suggestion not between", value1, value2, "handlingSuggestion");
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