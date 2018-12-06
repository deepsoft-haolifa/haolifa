package com.deepsoft.haolifa.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReplaceMaterialListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReplaceMaterialListExample() {
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

        public Criteria andMaterialUnitIsNull() {
            addCriterion("material_unit is null");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitIsNotNull() {
            addCriterion("material_unit is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitEqualTo(String value) {
            addCriterion("material_unit =", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitNotEqualTo(String value) {
            addCriterion("material_unit <>", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitGreaterThan(String value) {
            addCriterion("material_unit >", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitGreaterThanOrEqualTo(String value) {
            addCriterion("material_unit >=", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitLessThan(String value) {
            addCriterion("material_unit <", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitLessThanOrEqualTo(String value) {
            addCriterion("material_unit <=", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitLike(String value) {
            addCriterion("material_unit like", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitNotLike(String value) {
            addCriterion("material_unit not like", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitIn(List<String> values) {
            addCriterion("material_unit in", values, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitNotIn(List<String> values) {
            addCriterion("material_unit not in", values, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitBetween(String value1, String value2) {
            addCriterion("material_unit between", value1, value2, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitNotBetween(String value1, String value2) {
            addCriterion("material_unit not between", value1, value2, "materialUnit");
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

        public Criteria andReplaceReasonIsNull() {
            addCriterion("replace_reason is null");
            return (Criteria) this;
        }

        public Criteria andReplaceReasonIsNotNull() {
            addCriterion("replace_reason is not null");
            return (Criteria) this;
        }

        public Criteria andReplaceReasonEqualTo(String value) {
            addCriterion("replace_reason =", value, "replaceReason");
            return (Criteria) this;
        }

        public Criteria andReplaceReasonNotEqualTo(String value) {
            addCriterion("replace_reason <>", value, "replaceReason");
            return (Criteria) this;
        }

        public Criteria andReplaceReasonGreaterThan(String value) {
            addCriterion("replace_reason >", value, "replaceReason");
            return (Criteria) this;
        }

        public Criteria andReplaceReasonGreaterThanOrEqualTo(String value) {
            addCriterion("replace_reason >=", value, "replaceReason");
            return (Criteria) this;
        }

        public Criteria andReplaceReasonLessThan(String value) {
            addCriterion("replace_reason <", value, "replaceReason");
            return (Criteria) this;
        }

        public Criteria andReplaceReasonLessThanOrEqualTo(String value) {
            addCriterion("replace_reason <=", value, "replaceReason");
            return (Criteria) this;
        }

        public Criteria andReplaceReasonLike(String value) {
            addCriterion("replace_reason like", value, "replaceReason");
            return (Criteria) this;
        }

        public Criteria andReplaceReasonNotLike(String value) {
            addCriterion("replace_reason not like", value, "replaceReason");
            return (Criteria) this;
        }

        public Criteria andReplaceReasonIn(List<String> values) {
            addCriterion("replace_reason in", values, "replaceReason");
            return (Criteria) this;
        }

        public Criteria andReplaceReasonNotIn(List<String> values) {
            addCriterion("replace_reason not in", values, "replaceReason");
            return (Criteria) this;
        }

        public Criteria andReplaceReasonBetween(String value1, String value2) {
            addCriterion("replace_reason between", value1, value2, "replaceReason");
            return (Criteria) this;
        }

        public Criteria andReplaceReasonNotBetween(String value1, String value2) {
            addCriterion("replace_reason not between", value1, value2, "replaceReason");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonIsNull() {
            addCriterion("responsible_person is null");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonIsNotNull() {
            addCriterion("responsible_person is not null");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonEqualTo(String value) {
            addCriterion("responsible_person =", value, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonNotEqualTo(String value) {
            addCriterion("responsible_person <>", value, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonGreaterThan(String value) {
            addCriterion("responsible_person >", value, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonGreaterThanOrEqualTo(String value) {
            addCriterion("responsible_person >=", value, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonLessThan(String value) {
            addCriterion("responsible_person <", value, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonLessThanOrEqualTo(String value) {
            addCriterion("responsible_person <=", value, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonLike(String value) {
            addCriterion("responsible_person like", value, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonNotLike(String value) {
            addCriterion("responsible_person not like", value, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonIn(List<String> values) {
            addCriterion("responsible_person in", values, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonNotIn(List<String> values) {
            addCriterion("responsible_person not in", values, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonBetween(String value1, String value2) {
            addCriterion("responsible_person between", value1, value2, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonNotBetween(String value1, String value2) {
            addCriterion("responsible_person not between", value1, value2, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdIsNull() {
            addCriterion("audit_user_id is null");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdIsNotNull() {
            addCriterion("audit_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdEqualTo(Integer value) {
            addCriterion("audit_user_id =", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdNotEqualTo(Integer value) {
            addCriterion("audit_user_id <>", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdGreaterThan(Integer value) {
            addCriterion("audit_user_id >", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_user_id >=", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdLessThan(Integer value) {
            addCriterion("audit_user_id <", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("audit_user_id <=", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdIn(List<Integer> values) {
            addCriterion("audit_user_id in", values, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdNotIn(List<Integer> values) {
            addCriterion("audit_user_id not in", values, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdBetween(Integer value1, Integer value2) {
            addCriterion("audit_user_id between", value1, value2, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_user_id not between", value1, value2, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditInfoIsNull() {
            addCriterion("audit_info is null");
            return (Criteria) this;
        }

        public Criteria andAuditInfoIsNotNull() {
            addCriterion("audit_info is not null");
            return (Criteria) this;
        }

        public Criteria andAuditInfoEqualTo(String value) {
            addCriterion("audit_info =", value, "auditInfo");
            return (Criteria) this;
        }

        public Criteria andAuditInfoNotEqualTo(String value) {
            addCriterion("audit_info <>", value, "auditInfo");
            return (Criteria) this;
        }

        public Criteria andAuditInfoGreaterThan(String value) {
            addCriterion("audit_info >", value, "auditInfo");
            return (Criteria) this;
        }

        public Criteria andAuditInfoGreaterThanOrEqualTo(String value) {
            addCriterion("audit_info >=", value, "auditInfo");
            return (Criteria) this;
        }

        public Criteria andAuditInfoLessThan(String value) {
            addCriterion("audit_info <", value, "auditInfo");
            return (Criteria) this;
        }

        public Criteria andAuditInfoLessThanOrEqualTo(String value) {
            addCriterion("audit_info <=", value, "auditInfo");
            return (Criteria) this;
        }

        public Criteria andAuditInfoLike(String value) {
            addCriterion("audit_info like", value, "auditInfo");
            return (Criteria) this;
        }

        public Criteria andAuditInfoNotLike(String value) {
            addCriterion("audit_info not like", value, "auditInfo");
            return (Criteria) this;
        }

        public Criteria andAuditInfoIn(List<String> values) {
            addCriterion("audit_info in", values, "auditInfo");
            return (Criteria) this;
        }

        public Criteria andAuditInfoNotIn(List<String> values) {
            addCriterion("audit_info not in", values, "auditInfo");
            return (Criteria) this;
        }

        public Criteria andAuditInfoBetween(String value1, String value2) {
            addCriterion("audit_info between", value1, value2, "auditInfo");
            return (Criteria) this;
        }

        public Criteria andAuditInfoNotBetween(String value1, String value2) {
            addCriterion("audit_info not between", value1, value2, "auditInfo");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNull() {
            addCriterion("audit_time is null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNotNull() {
            addCriterion("audit_time is not null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeEqualTo(Date value) {
            addCriterion("audit_time =", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotEqualTo(Date value) {
            addCriterion("audit_time <>", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThan(Date value) {
            addCriterion("audit_time >", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("audit_time >=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThan(Date value) {
            addCriterion("audit_time <", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThanOrEqualTo(Date value) {
            addCriterion("audit_time <=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIn(List<Date> values) {
            addCriterion("audit_time in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotIn(List<Date> values) {
            addCriterion("audit_time not in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeBetween(Date value1, Date value2) {
            addCriterion("audit_time between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotBetween(Date value1, Date value2) {
            addCriterion("audit_time not between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditResultIsNull() {
            addCriterion("audit_result is null");
            return (Criteria) this;
        }

        public Criteria andAuditResultIsNotNull() {
            addCriterion("audit_result is not null");
            return (Criteria) this;
        }

        public Criteria andAuditResultEqualTo(Byte value) {
            addCriterion("audit_result =", value, "auditResult");
            return (Criteria) this;
        }

        public Criteria andAuditResultNotEqualTo(Byte value) {
            addCriterion("audit_result <>", value, "auditResult");
            return (Criteria) this;
        }

        public Criteria andAuditResultGreaterThan(Byte value) {
            addCriterion("audit_result >", value, "auditResult");
            return (Criteria) this;
        }

        public Criteria andAuditResultGreaterThanOrEqualTo(Byte value) {
            addCriterion("audit_result >=", value, "auditResult");
            return (Criteria) this;
        }

        public Criteria andAuditResultLessThan(Byte value) {
            addCriterion("audit_result <", value, "auditResult");
            return (Criteria) this;
        }

        public Criteria andAuditResultLessThanOrEqualTo(Byte value) {
            addCriterion("audit_result <=", value, "auditResult");
            return (Criteria) this;
        }

        public Criteria andAuditResultIn(List<Byte> values) {
            addCriterion("audit_result in", values, "auditResult");
            return (Criteria) this;
        }

        public Criteria andAuditResultNotIn(List<Byte> values) {
            addCriterion("audit_result not in", values, "auditResult");
            return (Criteria) this;
        }

        public Criteria andAuditResultBetween(Byte value1, Byte value2) {
            addCriterion("audit_result between", value1, value2, "auditResult");
            return (Criteria) this;
        }

        public Criteria andAuditResultNotBetween(Byte value1, Byte value2) {
            addCriterion("audit_result not between", value1, value2, "auditResult");
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