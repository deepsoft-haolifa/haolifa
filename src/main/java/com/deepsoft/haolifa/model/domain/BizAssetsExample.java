package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BizAssetsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BizAssetsExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andBhIsNull() {
            addCriterion("bh is null");
            return (Criteria) this;
        }

        public Criteria andBhIsNotNull() {
            addCriterion("bh is not null");
            return (Criteria) this;
        }

        public Criteria andBhEqualTo(String value) {
            addCriterion("bh =", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhNotEqualTo(String value) {
            addCriterion("bh <>", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhGreaterThan(String value) {
            addCriterion("bh >", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhGreaterThanOrEqualTo(String value) {
            addCriterion("bh >=", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhLessThan(String value) {
            addCriterion("bh <", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhLessThanOrEqualTo(String value) {
            addCriterion("bh <=", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhLike(String value) {
            addCriterion("bh like", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhNotLike(String value) {
            addCriterion("bh not like", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhIn(List<String> values) {
            addCriterion("bh in", values, "bh");
            return (Criteria) this;
        }

        public Criteria andBhNotIn(List<String> values) {
            addCriterion("bh not in", values, "bh");
            return (Criteria) this;
        }

        public Criteria andBhBetween(String value1, String value2) {
            addCriterion("bh between", value1, value2, "bh");
            return (Criteria) this;
        }

        public Criteria andBhNotBetween(String value1, String value2) {
            addCriterion("bh not between", value1, value2, "bh");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(String value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(String value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(String value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(String value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(String value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(String value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLike(String value) {
            addCriterion("num like", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotLike(String value) {
            addCriterion("num not like", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<String> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<String> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(String value1, String value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(String value1, String value2) {
            addCriterion("num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNull() {
            addCriterion("dept_id is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(String value) {
            addCriterion("dept_id =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(String value) {
            addCriterion("dept_id <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(String value) {
            addCriterion("dept_id >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(String value) {
            addCriterion("dept_id >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(String value) {
            addCriterion("dept_id <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(String value) {
            addCriterion("dept_id <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLike(String value) {
            addCriterion("dept_id like", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotLike(String value) {
            addCriterion("dept_id not like", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<String> values) {
            addCriterion("dept_id in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<String> values) {
            addCriterion("dept_id not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(String value1, String value2) {
            addCriterion("dept_id between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(String value1, String value2) {
            addCriterion("dept_id not between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andAddTypeIsNull() {
            addCriterion("add_type is null");
            return (Criteria) this;
        }

        public Criteria andAddTypeIsNotNull() {
            addCriterion("add_type is not null");
            return (Criteria) this;
        }

        public Criteria andAddTypeEqualTo(String value) {
            addCriterion("add_type =", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeNotEqualTo(String value) {
            addCriterion("add_type <>", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeGreaterThan(String value) {
            addCriterion("add_type >", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeGreaterThanOrEqualTo(String value) {
            addCriterion("add_type >=", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeLessThan(String value) {
            addCriterion("add_type <", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeLessThanOrEqualTo(String value) {
            addCriterion("add_type <=", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeLike(String value) {
            addCriterion("add_type like", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeNotLike(String value) {
            addCriterion("add_type not like", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeIn(List<String> values) {
            addCriterion("add_type in", values, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeNotIn(List<String> values) {
            addCriterion("add_type not in", values, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeBetween(String value1, String value2) {
            addCriterion("add_type between", value1, value2, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeNotBetween(String value1, String value2) {
            addCriterion("add_type not between", value1, value2, "addType");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateIsNull() {
            addCriterion("equipment_state is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateIsNotNull() {
            addCriterion("equipment_state is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateEqualTo(String value) {
            addCriterion("equipment_state =", value, "equipmentState");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateNotEqualTo(String value) {
            addCriterion("equipment_state <>", value, "equipmentState");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateGreaterThan(String value) {
            addCriterion("equipment_state >", value, "equipmentState");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_state >=", value, "equipmentState");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateLessThan(String value) {
            addCriterion("equipment_state <", value, "equipmentState");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateLessThanOrEqualTo(String value) {
            addCriterion("equipment_state <=", value, "equipmentState");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateLike(String value) {
            addCriterion("equipment_state like", value, "equipmentState");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateNotLike(String value) {
            addCriterion("equipment_state not like", value, "equipmentState");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateIn(List<String> values) {
            addCriterion("equipment_state in", values, "equipmentState");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateNotIn(List<String> values) {
            addCriterion("equipment_state not in", values, "equipmentState");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateBetween(String value1, String value2) {
            addCriterion("equipment_state between", value1, value2, "equipmentState");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateNotBetween(String value1, String value2) {
            addCriterion("equipment_state not between", value1, value2, "equipmentState");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNull() {
            addCriterion("manufacturer is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNotNull() {
            addCriterion("manufacturer is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerEqualTo(String value) {
            addCriterion("manufacturer =", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotEqualTo(String value) {
            addCriterion("manufacturer <>", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThan(String value) {
            addCriterion("manufacturer >", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThanOrEqualTo(String value) {
            addCriterion("manufacturer >=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThan(String value) {
            addCriterion("manufacturer <", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThanOrEqualTo(String value) {
            addCriterion("manufacturer <=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLike(String value) {
            addCriterion("manufacturer like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotLike(String value) {
            addCriterion("manufacturer not like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerIn(List<String> values) {
            addCriterion("manufacturer in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotIn(List<String> values) {
            addCriterion("manufacturer not in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerBetween(String value1, String value2) {
            addCriterion("manufacturer between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotBetween(String value1, String value2) {
            addCriterion("manufacturer not between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andPurchasingTimeIsNull() {
            addCriterion("purchasing_time is null");
            return (Criteria) this;
        }

        public Criteria andPurchasingTimeIsNotNull() {
            addCriterion("purchasing_time is not null");
            return (Criteria) this;
        }

        public Criteria andPurchasingTimeEqualTo(Date value) {
            addCriterion("purchasing_time =", value, "purchasingTime");
            return (Criteria) this;
        }

        public Criteria andPurchasingTimeNotEqualTo(Date value) {
            addCriterion("purchasing_time <>", value, "purchasingTime");
            return (Criteria) this;
        }

        public Criteria andPurchasingTimeGreaterThan(Date value) {
            addCriterion("purchasing_time >", value, "purchasingTime");
            return (Criteria) this;
        }

        public Criteria andPurchasingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("purchasing_time >=", value, "purchasingTime");
            return (Criteria) this;
        }

        public Criteria andPurchasingTimeLessThan(Date value) {
            addCriterion("purchasing_time <", value, "purchasingTime");
            return (Criteria) this;
        }

        public Criteria andPurchasingTimeLessThanOrEqualTo(Date value) {
            addCriterion("purchasing_time <=", value, "purchasingTime");
            return (Criteria) this;
        }

        public Criteria andPurchasingTimeIn(List<Date> values) {
            addCriterion("purchasing_time in", values, "purchasingTime");
            return (Criteria) this;
        }

        public Criteria andPurchasingTimeNotIn(List<Date> values) {
            addCriterion("purchasing_time not in", values, "purchasingTime");
            return (Criteria) this;
        }

        public Criteria andPurchasingTimeBetween(Date value1, Date value2) {
            addCriterion("purchasing_time between", value1, value2, "purchasingTime");
            return (Criteria) this;
        }

        public Criteria andPurchasingTimeNotBetween(Date value1, Date value2) {
            addCriterion("purchasing_time not between", value1, value2, "purchasingTime");
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

        public Criteria andUseYearIsNull() {
            addCriterion("use_year is null");
            return (Criteria) this;
        }

        public Criteria andUseYearIsNotNull() {
            addCriterion("use_year is not null");
            return (Criteria) this;
        }

        public Criteria andUseYearEqualTo(String value) {
            addCriterion("use_year =", value, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearNotEqualTo(String value) {
            addCriterion("use_year <>", value, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearGreaterThan(String value) {
            addCriterion("use_year >", value, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearGreaterThanOrEqualTo(String value) {
            addCriterion("use_year >=", value, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearLessThan(String value) {
            addCriterion("use_year <", value, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearLessThanOrEqualTo(String value) {
            addCriterion("use_year <=", value, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearLike(String value) {
            addCriterion("use_year like", value, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearNotLike(String value) {
            addCriterion("use_year not like", value, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearIn(List<String> values) {
            addCriterion("use_year in", values, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearNotIn(List<String> values) {
            addCriterion("use_year not in", values, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearBetween(String value1, String value2) {
            addCriterion("use_year between", value1, value2, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearNotBetween(String value1, String value2) {
            addCriterion("use_year not between", value1, value2, "useYear");
            return (Criteria) this;
        }

        public Criteria andDepreciationMethodIsNull() {
            addCriterion("depreciation_method is null");
            return (Criteria) this;
        }

        public Criteria andDepreciationMethodIsNotNull() {
            addCriterion("depreciation_method is not null");
            return (Criteria) this;
        }

        public Criteria andDepreciationMethodEqualTo(String value) {
            addCriterion("depreciation_method =", value, "depreciationMethod");
            return (Criteria) this;
        }

        public Criteria andDepreciationMethodNotEqualTo(String value) {
            addCriterion("depreciation_method <>", value, "depreciationMethod");
            return (Criteria) this;
        }

        public Criteria andDepreciationMethodGreaterThan(String value) {
            addCriterion("depreciation_method >", value, "depreciationMethod");
            return (Criteria) this;
        }

        public Criteria andDepreciationMethodGreaterThanOrEqualTo(String value) {
            addCriterion("depreciation_method >=", value, "depreciationMethod");
            return (Criteria) this;
        }

        public Criteria andDepreciationMethodLessThan(String value) {
            addCriterion("depreciation_method <", value, "depreciationMethod");
            return (Criteria) this;
        }

        public Criteria andDepreciationMethodLessThanOrEqualTo(String value) {
            addCriterion("depreciation_method <=", value, "depreciationMethod");
            return (Criteria) this;
        }

        public Criteria andDepreciationMethodLike(String value) {
            addCriterion("depreciation_method like", value, "depreciationMethod");
            return (Criteria) this;
        }

        public Criteria andDepreciationMethodNotLike(String value) {
            addCriterion("depreciation_method not like", value, "depreciationMethod");
            return (Criteria) this;
        }

        public Criteria andDepreciationMethodIn(List<String> values) {
            addCriterion("depreciation_method in", values, "depreciationMethod");
            return (Criteria) this;
        }

        public Criteria andDepreciationMethodNotIn(List<String> values) {
            addCriterion("depreciation_method not in", values, "depreciationMethod");
            return (Criteria) this;
        }

        public Criteria andDepreciationMethodBetween(String value1, String value2) {
            addCriterion("depreciation_method between", value1, value2, "depreciationMethod");
            return (Criteria) this;
        }

        public Criteria andDepreciationMethodNotBetween(String value1, String value2) {
            addCriterion("depreciation_method not between", value1, value2, "depreciationMethod");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andAccruedMonthIsNull() {
            addCriterion("accrued_month is null");
            return (Criteria) this;
        }

        public Criteria andAccruedMonthIsNotNull() {
            addCriterion("accrued_month is not null");
            return (Criteria) this;
        }

        public Criteria andAccruedMonthEqualTo(String value) {
            addCriterion("accrued_month =", value, "accruedMonth");
            return (Criteria) this;
        }

        public Criteria andAccruedMonthNotEqualTo(String value) {
            addCriterion("accrued_month <>", value, "accruedMonth");
            return (Criteria) this;
        }

        public Criteria andAccruedMonthGreaterThan(String value) {
            addCriterion("accrued_month >", value, "accruedMonth");
            return (Criteria) this;
        }

        public Criteria andAccruedMonthGreaterThanOrEqualTo(String value) {
            addCriterion("accrued_month >=", value, "accruedMonth");
            return (Criteria) this;
        }

        public Criteria andAccruedMonthLessThan(String value) {
            addCriterion("accrued_month <", value, "accruedMonth");
            return (Criteria) this;
        }

        public Criteria andAccruedMonthLessThanOrEqualTo(String value) {
            addCriterion("accrued_month <=", value, "accruedMonth");
            return (Criteria) this;
        }

        public Criteria andAccruedMonthLike(String value) {
            addCriterion("accrued_month like", value, "accruedMonth");
            return (Criteria) this;
        }

        public Criteria andAccruedMonthNotLike(String value) {
            addCriterion("accrued_month not like", value, "accruedMonth");
            return (Criteria) this;
        }

        public Criteria andAccruedMonthIn(List<String> values) {
            addCriterion("accrued_month in", values, "accruedMonth");
            return (Criteria) this;
        }

        public Criteria andAccruedMonthNotIn(List<String> values) {
            addCriterion("accrued_month not in", values, "accruedMonth");
            return (Criteria) this;
        }

        public Criteria andAccruedMonthBetween(String value1, String value2) {
            addCriterion("accrued_month between", value1, value2, "accruedMonth");
            return (Criteria) this;
        }

        public Criteria andAccruedMonthNotBetween(String value1, String value2) {
            addCriterion("accrued_month not between", value1, value2, "accruedMonth");
            return (Criteria) this;
        }

        public Criteria andOutputRateIsNull() {
            addCriterion("output_rate is null");
            return (Criteria) this;
        }

        public Criteria andOutputRateIsNotNull() {
            addCriterion("output_rate is not null");
            return (Criteria) this;
        }

        public Criteria andOutputRateEqualTo(String value) {
            addCriterion("output_rate =", value, "outputRate");
            return (Criteria) this;
        }

        public Criteria andOutputRateNotEqualTo(String value) {
            addCriterion("output_rate <>", value, "outputRate");
            return (Criteria) this;
        }

        public Criteria andOutputRateGreaterThan(String value) {
            addCriterion("output_rate >", value, "outputRate");
            return (Criteria) this;
        }

        public Criteria andOutputRateGreaterThanOrEqualTo(String value) {
            addCriterion("output_rate >=", value, "outputRate");
            return (Criteria) this;
        }

        public Criteria andOutputRateLessThan(String value) {
            addCriterion("output_rate <", value, "outputRate");
            return (Criteria) this;
        }

        public Criteria andOutputRateLessThanOrEqualTo(String value) {
            addCriterion("output_rate <=", value, "outputRate");
            return (Criteria) this;
        }

        public Criteria andOutputRateLike(String value) {
            addCriterion("output_rate like", value, "outputRate");
            return (Criteria) this;
        }

        public Criteria andOutputRateNotLike(String value) {
            addCriterion("output_rate not like", value, "outputRate");
            return (Criteria) this;
        }

        public Criteria andOutputRateIn(List<String> values) {
            addCriterion("output_rate in", values, "outputRate");
            return (Criteria) this;
        }

        public Criteria andOutputRateNotIn(List<String> values) {
            addCriterion("output_rate not in", values, "outputRate");
            return (Criteria) this;
        }

        public Criteria andOutputRateBetween(String value1, String value2) {
            addCriterion("output_rate between", value1, value2, "outputRate");
            return (Criteria) this;
        }

        public Criteria andOutputRateNotBetween(String value1, String value2) {
            addCriterion("output_rate not between", value1, value2, "outputRate");
            return (Criteria) this;
        }

        public Criteria andSalvageValueIsNull() {
            addCriterion("salvage_value is null");
            return (Criteria) this;
        }

        public Criteria andSalvageValueIsNotNull() {
            addCriterion("salvage_value is not null");
            return (Criteria) this;
        }

        public Criteria andSalvageValueEqualTo(String value) {
            addCriterion("salvage_value =", value, "salvageValue");
            return (Criteria) this;
        }

        public Criteria andSalvageValueNotEqualTo(String value) {
            addCriterion("salvage_value <>", value, "salvageValue");
            return (Criteria) this;
        }

        public Criteria andSalvageValueGreaterThan(String value) {
            addCriterion("salvage_value >", value, "salvageValue");
            return (Criteria) this;
        }

        public Criteria andSalvageValueGreaterThanOrEqualTo(String value) {
            addCriterion("salvage_value >=", value, "salvageValue");
            return (Criteria) this;
        }

        public Criteria andSalvageValueLessThan(String value) {
            addCriterion("salvage_value <", value, "salvageValue");
            return (Criteria) this;
        }

        public Criteria andSalvageValueLessThanOrEqualTo(String value) {
            addCriterion("salvage_value <=", value, "salvageValue");
            return (Criteria) this;
        }

        public Criteria andSalvageValueLike(String value) {
            addCriterion("salvage_value like", value, "salvageValue");
            return (Criteria) this;
        }

        public Criteria andSalvageValueNotLike(String value) {
            addCriterion("salvage_value not like", value, "salvageValue");
            return (Criteria) this;
        }

        public Criteria andSalvageValueIn(List<String> values) {
            addCriterion("salvage_value in", values, "salvageValue");
            return (Criteria) this;
        }

        public Criteria andSalvageValueNotIn(List<String> values) {
            addCriterion("salvage_value not in", values, "salvageValue");
            return (Criteria) this;
        }

        public Criteria andSalvageValueBetween(String value1, String value2) {
            addCriterion("salvage_value between", value1, value2, "salvageValue");
            return (Criteria) this;
        }

        public Criteria andSalvageValueNotBetween(String value1, String value2) {
            addCriterion("salvage_value not between", value1, value2, "salvageValue");
            return (Criteria) this;
        }

        public Criteria andAccumulatedDepreciationIsNull() {
            addCriterion("accumulated_depreciation is null");
            return (Criteria) this;
        }

        public Criteria andAccumulatedDepreciationIsNotNull() {
            addCriterion("accumulated_depreciation is not null");
            return (Criteria) this;
        }

        public Criteria andAccumulatedDepreciationEqualTo(String value) {
            addCriterion("accumulated_depreciation =", value, "accumulatedDepreciation");
            return (Criteria) this;
        }

        public Criteria andAccumulatedDepreciationNotEqualTo(String value) {
            addCriterion("accumulated_depreciation <>", value, "accumulatedDepreciation");
            return (Criteria) this;
        }

        public Criteria andAccumulatedDepreciationGreaterThan(String value) {
            addCriterion("accumulated_depreciation >", value, "accumulatedDepreciation");
            return (Criteria) this;
        }

        public Criteria andAccumulatedDepreciationGreaterThanOrEqualTo(String value) {
            addCriterion("accumulated_depreciation >=", value, "accumulatedDepreciation");
            return (Criteria) this;
        }

        public Criteria andAccumulatedDepreciationLessThan(String value) {
            addCriterion("accumulated_depreciation <", value, "accumulatedDepreciation");
            return (Criteria) this;
        }

        public Criteria andAccumulatedDepreciationLessThanOrEqualTo(String value) {
            addCriterion("accumulated_depreciation <=", value, "accumulatedDepreciation");
            return (Criteria) this;
        }

        public Criteria andAccumulatedDepreciationLike(String value) {
            addCriterion("accumulated_depreciation like", value, "accumulatedDepreciation");
            return (Criteria) this;
        }

        public Criteria andAccumulatedDepreciationNotLike(String value) {
            addCriterion("accumulated_depreciation not like", value, "accumulatedDepreciation");
            return (Criteria) this;
        }

        public Criteria andAccumulatedDepreciationIn(List<String> values) {
            addCriterion("accumulated_depreciation in", values, "accumulatedDepreciation");
            return (Criteria) this;
        }

        public Criteria andAccumulatedDepreciationNotIn(List<String> values) {
            addCriterion("accumulated_depreciation not in", values, "accumulatedDepreciation");
            return (Criteria) this;
        }

        public Criteria andAccumulatedDepreciationBetween(String value1, String value2) {
            addCriterion("accumulated_depreciation between", value1, value2, "accumulatedDepreciation");
            return (Criteria) this;
        }

        public Criteria andAccumulatedDepreciationNotBetween(String value1, String value2) {
            addCriterion("accumulated_depreciation not between", value1, value2, "accumulatedDepreciation");
            return (Criteria) this;
        }

        public Criteria andMonthRateIsNull() {
            addCriterion("month_rate is null");
            return (Criteria) this;
        }

        public Criteria andMonthRateIsNotNull() {
            addCriterion("month_rate is not null");
            return (Criteria) this;
        }

        public Criteria andMonthRateEqualTo(String value) {
            addCriterion("month_rate =", value, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateNotEqualTo(String value) {
            addCriterion("month_rate <>", value, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateGreaterThan(String value) {
            addCriterion("month_rate >", value, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateGreaterThanOrEqualTo(String value) {
            addCriterion("month_rate >=", value, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateLessThan(String value) {
            addCriterion("month_rate <", value, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateLessThanOrEqualTo(String value) {
            addCriterion("month_rate <=", value, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateLike(String value) {
            addCriterion("month_rate like", value, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateNotLike(String value) {
            addCriterion("month_rate not like", value, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateIn(List<String> values) {
            addCriterion("month_rate in", values, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateNotIn(List<String> values) {
            addCriterion("month_rate not in", values, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateBetween(String value1, String value2) {
            addCriterion("month_rate between", value1, value2, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateNotBetween(String value1, String value2) {
            addCriterion("month_rate not between", value1, value2, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthDepreciationIsNull() {
            addCriterion("month_depreciation is null");
            return (Criteria) this;
        }

        public Criteria andMonthDepreciationIsNotNull() {
            addCriterion("month_depreciation is not null");
            return (Criteria) this;
        }

        public Criteria andMonthDepreciationEqualTo(String value) {
            addCriterion("month_depreciation =", value, "monthDepreciation");
            return (Criteria) this;
        }

        public Criteria andMonthDepreciationNotEqualTo(String value) {
            addCriterion("month_depreciation <>", value, "monthDepreciation");
            return (Criteria) this;
        }

        public Criteria andMonthDepreciationGreaterThan(String value) {
            addCriterion("month_depreciation >", value, "monthDepreciation");
            return (Criteria) this;
        }

        public Criteria andMonthDepreciationGreaterThanOrEqualTo(String value) {
            addCriterion("month_depreciation >=", value, "monthDepreciation");
            return (Criteria) this;
        }

        public Criteria andMonthDepreciationLessThan(String value) {
            addCriterion("month_depreciation <", value, "monthDepreciation");
            return (Criteria) this;
        }

        public Criteria andMonthDepreciationLessThanOrEqualTo(String value) {
            addCriterion("month_depreciation <=", value, "monthDepreciation");
            return (Criteria) this;
        }

        public Criteria andMonthDepreciationLike(String value) {
            addCriterion("month_depreciation like", value, "monthDepreciation");
            return (Criteria) this;
        }

        public Criteria andMonthDepreciationNotLike(String value) {
            addCriterion("month_depreciation not like", value, "monthDepreciation");
            return (Criteria) this;
        }

        public Criteria andMonthDepreciationIn(List<String> values) {
            addCriterion("month_depreciation in", values, "monthDepreciation");
            return (Criteria) this;
        }

        public Criteria andMonthDepreciationNotIn(List<String> values) {
            addCriterion("month_depreciation not in", values, "monthDepreciation");
            return (Criteria) this;
        }

        public Criteria andMonthDepreciationBetween(String value1, String value2) {
            addCriterion("month_depreciation between", value1, value2, "monthDepreciation");
            return (Criteria) this;
        }

        public Criteria andMonthDepreciationNotBetween(String value1, String value2) {
            addCriterion("month_depreciation not between", value1, value2, "monthDepreciation");
            return (Criteria) this;
        }

        public Criteria andNetWorthIsNull() {
            addCriterion("net_worth is null");
            return (Criteria) this;
        }

        public Criteria andNetWorthIsNotNull() {
            addCriterion("net_worth is not null");
            return (Criteria) this;
        }

        public Criteria andNetWorthEqualTo(String value) {
            addCriterion("net_worth =", value, "netWorth");
            return (Criteria) this;
        }

        public Criteria andNetWorthNotEqualTo(String value) {
            addCriterion("net_worth <>", value, "netWorth");
            return (Criteria) this;
        }

        public Criteria andNetWorthGreaterThan(String value) {
            addCriterion("net_worth >", value, "netWorth");
            return (Criteria) this;
        }

        public Criteria andNetWorthGreaterThanOrEqualTo(String value) {
            addCriterion("net_worth >=", value, "netWorth");
            return (Criteria) this;
        }

        public Criteria andNetWorthLessThan(String value) {
            addCriterion("net_worth <", value, "netWorth");
            return (Criteria) this;
        }

        public Criteria andNetWorthLessThanOrEqualTo(String value) {
            addCriterion("net_worth <=", value, "netWorth");
            return (Criteria) this;
        }

        public Criteria andNetWorthLike(String value) {
            addCriterion("net_worth like", value, "netWorth");
            return (Criteria) this;
        }

        public Criteria andNetWorthNotLike(String value) {
            addCriterion("net_worth not like", value, "netWorth");
            return (Criteria) this;
        }

        public Criteria andNetWorthIn(List<String> values) {
            addCriterion("net_worth in", values, "netWorth");
            return (Criteria) this;
        }

        public Criteria andNetWorthNotIn(List<String> values) {
            addCriterion("net_worth not in", values, "netWorth");
            return (Criteria) this;
        }

        public Criteria andNetWorthBetween(String value1, String value2) {
            addCriterion("net_worth between", value1, value2, "netWorth");
            return (Criteria) this;
        }

        public Criteria andNetWorthNotBetween(String value1, String value2) {
            addCriterion("net_worth not between", value1, value2, "netWorth");
            return (Criteria) this;
        }

        public Criteria andString1IsNull() {
            addCriterion("string1 is null");
            return (Criteria) this;
        }

        public Criteria andString1IsNotNull() {
            addCriterion("string1 is not null");
            return (Criteria) this;
        }

        public Criteria andString1EqualTo(String value) {
            addCriterion("string1 =", value, "string1");
            return (Criteria) this;
        }

        public Criteria andString1NotEqualTo(String value) {
            addCriterion("string1 <>", value, "string1");
            return (Criteria) this;
        }

        public Criteria andString1GreaterThan(String value) {
            addCriterion("string1 >", value, "string1");
            return (Criteria) this;
        }

        public Criteria andString1GreaterThanOrEqualTo(String value) {
            addCriterion("string1 >=", value, "string1");
            return (Criteria) this;
        }

        public Criteria andString1LessThan(String value) {
            addCriterion("string1 <", value, "string1");
            return (Criteria) this;
        }

        public Criteria andString1LessThanOrEqualTo(String value) {
            addCriterion("string1 <=", value, "string1");
            return (Criteria) this;
        }

        public Criteria andString1Like(String value) {
            addCriterion("string1 like", value, "string1");
            return (Criteria) this;
        }

        public Criteria andString1NotLike(String value) {
            addCriterion("string1 not like", value, "string1");
            return (Criteria) this;
        }

        public Criteria andString1In(List<String> values) {
            addCriterion("string1 in", values, "string1");
            return (Criteria) this;
        }

        public Criteria andString1NotIn(List<String> values) {
            addCriterion("string1 not in", values, "string1");
            return (Criteria) this;
        }

        public Criteria andString1Between(String value1, String value2) {
            addCriterion("string1 between", value1, value2, "string1");
            return (Criteria) this;
        }

        public Criteria andString1NotBetween(String value1, String value2) {
            addCriterion("string1 not between", value1, value2, "string1");
            return (Criteria) this;
        }

        public Criteria andString2IsNull() {
            addCriterion("string2 is null");
            return (Criteria) this;
        }

        public Criteria andString2IsNotNull() {
            addCriterion("string2 is not null");
            return (Criteria) this;
        }

        public Criteria andString2EqualTo(String value) {
            addCriterion("string2 =", value, "string2");
            return (Criteria) this;
        }

        public Criteria andString2NotEqualTo(String value) {
            addCriterion("string2 <>", value, "string2");
            return (Criteria) this;
        }

        public Criteria andString2GreaterThan(String value) {
            addCriterion("string2 >", value, "string2");
            return (Criteria) this;
        }

        public Criteria andString2GreaterThanOrEqualTo(String value) {
            addCriterion("string2 >=", value, "string2");
            return (Criteria) this;
        }

        public Criteria andString2LessThan(String value) {
            addCriterion("string2 <", value, "string2");
            return (Criteria) this;
        }

        public Criteria andString2LessThanOrEqualTo(String value) {
            addCriterion("string2 <=", value, "string2");
            return (Criteria) this;
        }

        public Criteria andString2Like(String value) {
            addCriterion("string2 like", value, "string2");
            return (Criteria) this;
        }

        public Criteria andString2NotLike(String value) {
            addCriterion("string2 not like", value, "string2");
            return (Criteria) this;
        }

        public Criteria andString2In(List<String> values) {
            addCriterion("string2 in", values, "string2");
            return (Criteria) this;
        }

        public Criteria andString2NotIn(List<String> values) {
            addCriterion("string2 not in", values, "string2");
            return (Criteria) this;
        }

        public Criteria andString2Between(String value1, String value2) {
            addCriterion("string2 between", value1, value2, "string2");
            return (Criteria) this;
        }

        public Criteria andString2NotBetween(String value1, String value2) {
            addCriterion("string2 not between", value1, value2, "string2");
            return (Criteria) this;
        }

        public Criteria andString3IsNull() {
            addCriterion("string3 is null");
            return (Criteria) this;
        }

        public Criteria andString3IsNotNull() {
            addCriterion("string3 is not null");
            return (Criteria) this;
        }

        public Criteria andString3EqualTo(String value) {
            addCriterion("string3 =", value, "string3");
            return (Criteria) this;
        }

        public Criteria andString3NotEqualTo(String value) {
            addCriterion("string3 <>", value, "string3");
            return (Criteria) this;
        }

        public Criteria andString3GreaterThan(String value) {
            addCriterion("string3 >", value, "string3");
            return (Criteria) this;
        }

        public Criteria andString3GreaterThanOrEqualTo(String value) {
            addCriterion("string3 >=", value, "string3");
            return (Criteria) this;
        }

        public Criteria andString3LessThan(String value) {
            addCriterion("string3 <", value, "string3");
            return (Criteria) this;
        }

        public Criteria andString3LessThanOrEqualTo(String value) {
            addCriterion("string3 <=", value, "string3");
            return (Criteria) this;
        }

        public Criteria andString3Like(String value) {
            addCriterion("string3 like", value, "string3");
            return (Criteria) this;
        }

        public Criteria andString3NotLike(String value) {
            addCriterion("string3 not like", value, "string3");
            return (Criteria) this;
        }

        public Criteria andString3In(List<String> values) {
            addCriterion("string3 in", values, "string3");
            return (Criteria) this;
        }

        public Criteria andString3NotIn(List<String> values) {
            addCriterion("string3 not in", values, "string3");
            return (Criteria) this;
        }

        public Criteria andString3Between(String value1, String value2) {
            addCriterion("string3 between", value1, value2, "string3");
            return (Criteria) this;
        }

        public Criteria andString3NotBetween(String value1, String value2) {
            addCriterion("string3 not between", value1, value2, "string3");
            return (Criteria) this;
        }

        public Criteria andString4IsNull() {
            addCriterion("string4 is null");
            return (Criteria) this;
        }

        public Criteria andString4IsNotNull() {
            addCriterion("string4 is not null");
            return (Criteria) this;
        }

        public Criteria andString4EqualTo(String value) {
            addCriterion("string4 =", value, "string4");
            return (Criteria) this;
        }

        public Criteria andString4NotEqualTo(String value) {
            addCriterion("string4 <>", value, "string4");
            return (Criteria) this;
        }

        public Criteria andString4GreaterThan(String value) {
            addCriterion("string4 >", value, "string4");
            return (Criteria) this;
        }

        public Criteria andString4GreaterThanOrEqualTo(String value) {
            addCriterion("string4 >=", value, "string4");
            return (Criteria) this;
        }

        public Criteria andString4LessThan(String value) {
            addCriterion("string4 <", value, "string4");
            return (Criteria) this;
        }

        public Criteria andString4LessThanOrEqualTo(String value) {
            addCriterion("string4 <=", value, "string4");
            return (Criteria) this;
        }

        public Criteria andString4Like(String value) {
            addCriterion("string4 like", value, "string4");
            return (Criteria) this;
        }

        public Criteria andString4NotLike(String value) {
            addCriterion("string4 not like", value, "string4");
            return (Criteria) this;
        }

        public Criteria andString4In(List<String> values) {
            addCriterion("string4 in", values, "string4");
            return (Criteria) this;
        }

        public Criteria andString4NotIn(List<String> values) {
            addCriterion("string4 not in", values, "string4");
            return (Criteria) this;
        }

        public Criteria andString4Between(String value1, String value2) {
            addCriterion("string4 between", value1, value2, "string4");
            return (Criteria) this;
        }

        public Criteria andString4NotBetween(String value1, String value2) {
            addCriterion("string4 not between", value1, value2, "string4");
            return (Criteria) this;
        }

        public Criteria andString5IsNull() {
            addCriterion("string5 is null");
            return (Criteria) this;
        }

        public Criteria andString5IsNotNull() {
            addCriterion("string5 is not null");
            return (Criteria) this;
        }

        public Criteria andString5EqualTo(String value) {
            addCriterion("string5 =", value, "string5");
            return (Criteria) this;
        }

        public Criteria andString5NotEqualTo(String value) {
            addCriterion("string5 <>", value, "string5");
            return (Criteria) this;
        }

        public Criteria andString5GreaterThan(String value) {
            addCriterion("string5 >", value, "string5");
            return (Criteria) this;
        }

        public Criteria andString5GreaterThanOrEqualTo(String value) {
            addCriterion("string5 >=", value, "string5");
            return (Criteria) this;
        }

        public Criteria andString5LessThan(String value) {
            addCriterion("string5 <", value, "string5");
            return (Criteria) this;
        }

        public Criteria andString5LessThanOrEqualTo(String value) {
            addCriterion("string5 <=", value, "string5");
            return (Criteria) this;
        }

        public Criteria andString5Like(String value) {
            addCriterion("string5 like", value, "string5");
            return (Criteria) this;
        }

        public Criteria andString5NotLike(String value) {
            addCriterion("string5 not like", value, "string5");
            return (Criteria) this;
        }

        public Criteria andString5In(List<String> values) {
            addCriterion("string5 in", values, "string5");
            return (Criteria) this;
        }

        public Criteria andString5NotIn(List<String> values) {
            addCriterion("string5 not in", values, "string5");
            return (Criteria) this;
        }

        public Criteria andString5Between(String value1, String value2) {
            addCriterion("string5 between", value1, value2, "string5");
            return (Criteria) this;
        }

        public Criteria andString5NotBetween(String value1, String value2) {
            addCriterion("string5 not between", value1, value2, "string5");
            return (Criteria) this;
        }

        public Criteria andString6IsNull() {
            addCriterion("string6 is null");
            return (Criteria) this;
        }

        public Criteria andString6IsNotNull() {
            addCriterion("string6 is not null");
            return (Criteria) this;
        }

        public Criteria andString6EqualTo(String value) {
            addCriterion("string6 =", value, "string6");
            return (Criteria) this;
        }

        public Criteria andString6NotEqualTo(String value) {
            addCriterion("string6 <>", value, "string6");
            return (Criteria) this;
        }

        public Criteria andString6GreaterThan(String value) {
            addCriterion("string6 >", value, "string6");
            return (Criteria) this;
        }

        public Criteria andString6GreaterThanOrEqualTo(String value) {
            addCriterion("string6 >=", value, "string6");
            return (Criteria) this;
        }

        public Criteria andString6LessThan(String value) {
            addCriterion("string6 <", value, "string6");
            return (Criteria) this;
        }

        public Criteria andString6LessThanOrEqualTo(String value) {
            addCriterion("string6 <=", value, "string6");
            return (Criteria) this;
        }

        public Criteria andString6Like(String value) {
            addCriterion("string6 like", value, "string6");
            return (Criteria) this;
        }

        public Criteria andString6NotLike(String value) {
            addCriterion("string6 not like", value, "string6");
            return (Criteria) this;
        }

        public Criteria andString6In(List<String> values) {
            addCriterion("string6 in", values, "string6");
            return (Criteria) this;
        }

        public Criteria andString6NotIn(List<String> values) {
            addCriterion("string6 not in", values, "string6");
            return (Criteria) this;
        }

        public Criteria andString6Between(String value1, String value2) {
            addCriterion("string6 between", value1, value2, "string6");
            return (Criteria) this;
        }

        public Criteria andString6NotBetween(String value1, String value2) {
            addCriterion("string6 not between", value1, value2, "string6");
            return (Criteria) this;
        }

        public Criteria andString7IsNull() {
            addCriterion("string7 is null");
            return (Criteria) this;
        }

        public Criteria andString7IsNotNull() {
            addCriterion("string7 is not null");
            return (Criteria) this;
        }

        public Criteria andString7EqualTo(String value) {
            addCriterion("string7 =", value, "string7");
            return (Criteria) this;
        }

        public Criteria andString7NotEqualTo(String value) {
            addCriterion("string7 <>", value, "string7");
            return (Criteria) this;
        }

        public Criteria andString7GreaterThan(String value) {
            addCriterion("string7 >", value, "string7");
            return (Criteria) this;
        }

        public Criteria andString7GreaterThanOrEqualTo(String value) {
            addCriterion("string7 >=", value, "string7");
            return (Criteria) this;
        }

        public Criteria andString7LessThan(String value) {
            addCriterion("string7 <", value, "string7");
            return (Criteria) this;
        }

        public Criteria andString7LessThanOrEqualTo(String value) {
            addCriterion("string7 <=", value, "string7");
            return (Criteria) this;
        }

        public Criteria andString7Like(String value) {
            addCriterion("string7 like", value, "string7");
            return (Criteria) this;
        }

        public Criteria andString7NotLike(String value) {
            addCriterion("string7 not like", value, "string7");
            return (Criteria) this;
        }

        public Criteria andString7In(List<String> values) {
            addCriterion("string7 in", values, "string7");
            return (Criteria) this;
        }

        public Criteria andString7NotIn(List<String> values) {
            addCriterion("string7 not in", values, "string7");
            return (Criteria) this;
        }

        public Criteria andString7Between(String value1, String value2) {
            addCriterion("string7 between", value1, value2, "string7");
            return (Criteria) this;
        }

        public Criteria andString7NotBetween(String value1, String value2) {
            addCriterion("string7 not between", value1, value2, "string7");
            return (Criteria) this;
        }

        public Criteria andString8IsNull() {
            addCriterion("string8 is null");
            return (Criteria) this;
        }

        public Criteria andString8IsNotNull() {
            addCriterion("string8 is not null");
            return (Criteria) this;
        }

        public Criteria andString8EqualTo(String value) {
            addCriterion("string8 =", value, "string8");
            return (Criteria) this;
        }

        public Criteria andString8NotEqualTo(String value) {
            addCriterion("string8 <>", value, "string8");
            return (Criteria) this;
        }

        public Criteria andString8GreaterThan(String value) {
            addCriterion("string8 >", value, "string8");
            return (Criteria) this;
        }

        public Criteria andString8GreaterThanOrEqualTo(String value) {
            addCriterion("string8 >=", value, "string8");
            return (Criteria) this;
        }

        public Criteria andString8LessThan(String value) {
            addCriterion("string8 <", value, "string8");
            return (Criteria) this;
        }

        public Criteria andString8LessThanOrEqualTo(String value) {
            addCriterion("string8 <=", value, "string8");
            return (Criteria) this;
        }

        public Criteria andString8Like(String value) {
            addCriterion("string8 like", value, "string8");
            return (Criteria) this;
        }

        public Criteria andString8NotLike(String value) {
            addCriterion("string8 not like", value, "string8");
            return (Criteria) this;
        }

        public Criteria andString8In(List<String> values) {
            addCriterion("string8 in", values, "string8");
            return (Criteria) this;
        }

        public Criteria andString8NotIn(List<String> values) {
            addCriterion("string8 not in", values, "string8");
            return (Criteria) this;
        }

        public Criteria andString8Between(String value1, String value2) {
            addCriterion("string8 between", value1, value2, "string8");
            return (Criteria) this;
        }

        public Criteria andString8NotBetween(String value1, String value2) {
            addCriterion("string8 not between", value1, value2, "string8");
            return (Criteria) this;
        }

        public Criteria andString9IsNull() {
            addCriterion("string9 is null");
            return (Criteria) this;
        }

        public Criteria andString9IsNotNull() {
            addCriterion("string9 is not null");
            return (Criteria) this;
        }

        public Criteria andString9EqualTo(String value) {
            addCriterion("string9 =", value, "string9");
            return (Criteria) this;
        }

        public Criteria andString9NotEqualTo(String value) {
            addCriterion("string9 <>", value, "string9");
            return (Criteria) this;
        }

        public Criteria andString9GreaterThan(String value) {
            addCriterion("string9 >", value, "string9");
            return (Criteria) this;
        }

        public Criteria andString9GreaterThanOrEqualTo(String value) {
            addCriterion("string9 >=", value, "string9");
            return (Criteria) this;
        }

        public Criteria andString9LessThan(String value) {
            addCriterion("string9 <", value, "string9");
            return (Criteria) this;
        }

        public Criteria andString9LessThanOrEqualTo(String value) {
            addCriterion("string9 <=", value, "string9");
            return (Criteria) this;
        }

        public Criteria andString9Like(String value) {
            addCriterion("string9 like", value, "string9");
            return (Criteria) this;
        }

        public Criteria andString9NotLike(String value) {
            addCriterion("string9 not like", value, "string9");
            return (Criteria) this;
        }

        public Criteria andString9In(List<String> values) {
            addCriterion("string9 in", values, "string9");
            return (Criteria) this;
        }

        public Criteria andString9NotIn(List<String> values) {
            addCriterion("string9 not in", values, "string9");
            return (Criteria) this;
        }

        public Criteria andString9Between(String value1, String value2) {
            addCriterion("string9 between", value1, value2, "string9");
            return (Criteria) this;
        }

        public Criteria andString9NotBetween(String value1, String value2) {
            addCriterion("string9 not between", value1, value2, "string9");
            return (Criteria) this;
        }

        public Criteria andString10IsNull() {
            addCriterion("string10 is null");
            return (Criteria) this;
        }

        public Criteria andString10IsNotNull() {
            addCriterion("string10 is not null");
            return (Criteria) this;
        }

        public Criteria andString10EqualTo(String value) {
            addCriterion("string10 =", value, "string10");
            return (Criteria) this;
        }

        public Criteria andString10NotEqualTo(String value) {
            addCriterion("string10 <>", value, "string10");
            return (Criteria) this;
        }

        public Criteria andString10GreaterThan(String value) {
            addCriterion("string10 >", value, "string10");
            return (Criteria) this;
        }

        public Criteria andString10GreaterThanOrEqualTo(String value) {
            addCriterion("string10 >=", value, "string10");
            return (Criteria) this;
        }

        public Criteria andString10LessThan(String value) {
            addCriterion("string10 <", value, "string10");
            return (Criteria) this;
        }

        public Criteria andString10LessThanOrEqualTo(String value) {
            addCriterion("string10 <=", value, "string10");
            return (Criteria) this;
        }

        public Criteria andString10Like(String value) {
            addCriterion("string10 like", value, "string10");
            return (Criteria) this;
        }

        public Criteria andString10NotLike(String value) {
            addCriterion("string10 not like", value, "string10");
            return (Criteria) this;
        }

        public Criteria andString10In(List<String> values) {
            addCriterion("string10 in", values, "string10");
            return (Criteria) this;
        }

        public Criteria andString10NotIn(List<String> values) {
            addCriterion("string10 not in", values, "string10");
            return (Criteria) this;
        }

        public Criteria andString10Between(String value1, String value2) {
            addCriterion("string10 between", value1, value2, "string10");
            return (Criteria) this;
        }

        public Criteria andString10NotBetween(String value1, String value2) {
            addCriterion("string10 not between", value1, value2, "string10");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(String value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(String value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(String value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(String value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(String value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(String value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLike(String value) {
            addCriterion("del_flag like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotLike(String value) {
            addCriterion("del_flag not like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<String> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<String> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(String value1, String value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(String value1, String value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
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

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
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