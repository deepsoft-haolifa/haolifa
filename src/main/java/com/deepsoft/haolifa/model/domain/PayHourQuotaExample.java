package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PayHourQuotaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PayHourQuotaExample() {
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

        public Criteria andSerialIsNull() {
            addCriterion("serial is null");
            return (Criteria) this;
        }

        public Criteria andSerialIsNotNull() {
            addCriterion("serial is not null");
            return (Criteria) this;
        }

        public Criteria andSerialEqualTo(Integer value) {
            addCriterion("serial =", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotEqualTo(Integer value) {
            addCriterion("serial <>", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialGreaterThan(Integer value) {
            addCriterion("serial >", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialGreaterThanOrEqualTo(Integer value) {
            addCriterion("serial >=", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialLessThan(Integer value) {
            addCriterion("serial <", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialLessThanOrEqualTo(Integer value) {
            addCriterion("serial <=", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialIn(List<Integer> values) {
            addCriterion("serial in", values, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotIn(List<Integer> values) {
            addCriterion("serial not in", values, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialBetween(Integer value1, Integer value2) {
            addCriterion("serial between", value1, value2, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotBetween(Integer value1, Integer value2) {
            addCriterion("serial not between", value1, value2, "serial");
            return (Criteria) this;
        }

        public Criteria andWorkshopNameIsNull() {
            addCriterion("workshop_name is null");
            return (Criteria) this;
        }

        public Criteria andWorkshopNameIsNotNull() {
            addCriterion("workshop_name is not null");
            return (Criteria) this;
        }

        public Criteria andWorkshopNameEqualTo(String value) {
            addCriterion("workshop_name =", value, "workshopName");
            return (Criteria) this;
        }

        public Criteria andWorkshopNameNotEqualTo(String value) {
            addCriterion("workshop_name <>", value, "workshopName");
            return (Criteria) this;
        }

        public Criteria andWorkshopNameGreaterThan(String value) {
            addCriterion("workshop_name >", value, "workshopName");
            return (Criteria) this;
        }

        public Criteria andWorkshopNameGreaterThanOrEqualTo(String value) {
            addCriterion("workshop_name >=", value, "workshopName");
            return (Criteria) this;
        }

        public Criteria andWorkshopNameLessThan(String value) {
            addCriterion("workshop_name <", value, "workshopName");
            return (Criteria) this;
        }

        public Criteria andWorkshopNameLessThanOrEqualTo(String value) {
            addCriterion("workshop_name <=", value, "workshopName");
            return (Criteria) this;
        }

        public Criteria andWorkshopNameLike(String value) {
            addCriterion("workshop_name like", value, "workshopName");
            return (Criteria) this;
        }

        public Criteria andWorkshopNameNotLike(String value) {
            addCriterion("workshop_name not like", value, "workshopName");
            return (Criteria) this;
        }

        public Criteria andWorkshopNameIn(List<String> values) {
            addCriterion("workshop_name in", values, "workshopName");
            return (Criteria) this;
        }

        public Criteria andWorkshopNameNotIn(List<String> values) {
            addCriterion("workshop_name not in", values, "workshopName");
            return (Criteria) this;
        }

        public Criteria andWorkshopNameBetween(String value1, String value2) {
            addCriterion("workshop_name between", value1, value2, "workshopName");
            return (Criteria) this;
        }

        public Criteria andWorkshopNameNotBetween(String value1, String value2) {
            addCriterion("workshop_name not between", value1, value2, "workshopName");
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

        public Criteria andIdCategoryIsNull() {
            addCriterion("id_category is null");
            return (Criteria) this;
        }

        public Criteria andIdCategoryIsNotNull() {
            addCriterion("id_category is not null");
            return (Criteria) this;
        }

        public Criteria andIdCategoryEqualTo(String value) {
            addCriterion("id_category =", value, "idCategory");
            return (Criteria) this;
        }

        public Criteria andIdCategoryNotEqualTo(String value) {
            addCriterion("id_category <>", value, "idCategory");
            return (Criteria) this;
        }

        public Criteria andIdCategoryGreaterThan(String value) {
            addCriterion("id_category >", value, "idCategory");
            return (Criteria) this;
        }

        public Criteria andIdCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("id_category >=", value, "idCategory");
            return (Criteria) this;
        }

        public Criteria andIdCategoryLessThan(String value) {
            addCriterion("id_category <", value, "idCategory");
            return (Criteria) this;
        }

        public Criteria andIdCategoryLessThanOrEqualTo(String value) {
            addCriterion("id_category <=", value, "idCategory");
            return (Criteria) this;
        }

        public Criteria andIdCategoryLike(String value) {
            addCriterion("id_category like", value, "idCategory");
            return (Criteria) this;
        }

        public Criteria andIdCategoryNotLike(String value) {
            addCriterion("id_category not like", value, "idCategory");
            return (Criteria) this;
        }

        public Criteria andIdCategoryIn(List<String> values) {
            addCriterion("id_category in", values, "idCategory");
            return (Criteria) this;
        }

        public Criteria andIdCategoryNotIn(List<String> values) {
            addCriterion("id_category not in", values, "idCategory");
            return (Criteria) this;
        }

        public Criteria andIdCategoryBetween(String value1, String value2) {
            addCriterion("id_category between", value1, value2, "idCategory");
            return (Criteria) this;
        }

        public Criteria andIdCategoryNotBetween(String value1, String value2) {
            addCriterion("id_category not between", value1, value2, "idCategory");
            return (Criteria) this;
        }

        public Criteria andAppModelIsNull() {
            addCriterion("app_model is null");
            return (Criteria) this;
        }

        public Criteria andAppModelIsNotNull() {
            addCriterion("app_model is not null");
            return (Criteria) this;
        }

        public Criteria andAppModelEqualTo(String value) {
            addCriterion("app_model =", value, "appModel");
            return (Criteria) this;
        }

        public Criteria andAppModelNotEqualTo(String value) {
            addCriterion("app_model <>", value, "appModel");
            return (Criteria) this;
        }

        public Criteria andAppModelGreaterThan(String value) {
            addCriterion("app_model >", value, "appModel");
            return (Criteria) this;
        }

        public Criteria andAppModelGreaterThanOrEqualTo(String value) {
            addCriterion("app_model >=", value, "appModel");
            return (Criteria) this;
        }

        public Criteria andAppModelLessThan(String value) {
            addCriterion("app_model <", value, "appModel");
            return (Criteria) this;
        }

        public Criteria andAppModelLessThanOrEqualTo(String value) {
            addCriterion("app_model <=", value, "appModel");
            return (Criteria) this;
        }

        public Criteria andAppModelLike(String value) {
            addCriterion("app_model like", value, "appModel");
            return (Criteria) this;
        }

        public Criteria andAppModelNotLike(String value) {
            addCriterion("app_model not like", value, "appModel");
            return (Criteria) this;
        }

        public Criteria andAppModelIn(List<String> values) {
            addCriterion("app_model in", values, "appModel");
            return (Criteria) this;
        }

        public Criteria andAppModelNotIn(List<String> values) {
            addCriterion("app_model not in", values, "appModel");
            return (Criteria) this;
        }

        public Criteria andAppModelBetween(String value1, String value2) {
            addCriterion("app_model between", value1, value2, "appModel");
            return (Criteria) this;
        }

        public Criteria andAppModelNotBetween(String value1, String value2) {
            addCriterion("app_model not between", value1, value2, "appModel");
            return (Criteria) this;
        }

        public Criteria andAppSpecificationsIsNull() {
            addCriterion("app_specifications is null");
            return (Criteria) this;
        }

        public Criteria andAppSpecificationsIsNotNull() {
            addCriterion("app_specifications is not null");
            return (Criteria) this;
        }

        public Criteria andAppSpecificationsEqualTo(String value) {
            addCriterion("app_specifications =", value, "appSpecifications");
            return (Criteria) this;
        }

        public Criteria andAppSpecificationsNotEqualTo(String value) {
            addCriterion("app_specifications <>", value, "appSpecifications");
            return (Criteria) this;
        }

        public Criteria andAppSpecificationsGreaterThan(String value) {
            addCriterion("app_specifications >", value, "appSpecifications");
            return (Criteria) this;
        }

        public Criteria andAppSpecificationsGreaterThanOrEqualTo(String value) {
            addCriterion("app_specifications >=", value, "appSpecifications");
            return (Criteria) this;
        }

        public Criteria andAppSpecificationsLessThan(String value) {
            addCriterion("app_specifications <", value, "appSpecifications");
            return (Criteria) this;
        }

        public Criteria andAppSpecificationsLessThanOrEqualTo(String value) {
            addCriterion("app_specifications <=", value, "appSpecifications");
            return (Criteria) this;
        }

        public Criteria andAppSpecificationsLike(String value) {
            addCriterion("app_specifications like", value, "appSpecifications");
            return (Criteria) this;
        }

        public Criteria andAppSpecificationsNotLike(String value) {
            addCriterion("app_specifications not like", value, "appSpecifications");
            return (Criteria) this;
        }

        public Criteria andAppSpecificationsIn(List<String> values) {
            addCriterion("app_specifications in", values, "appSpecifications");
            return (Criteria) this;
        }

        public Criteria andAppSpecificationsNotIn(List<String> values) {
            addCriterion("app_specifications not in", values, "appSpecifications");
            return (Criteria) this;
        }

        public Criteria andAppSpecificationsBetween(String value1, String value2) {
            addCriterion("app_specifications between", value1, value2, "appSpecifications");
            return (Criteria) this;
        }

        public Criteria andAppSpecificationsNotBetween(String value1, String value2) {
            addCriterion("app_specifications not between", value1, value2, "appSpecifications");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIsNull() {
            addCriterion("work_type is null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIsNotNull() {
            addCriterion("work_type is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeEqualTo(String value) {
            addCriterion("work_type =", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotEqualTo(String value) {
            addCriterion("work_type <>", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeGreaterThan(String value) {
            addCriterion("work_type >", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeGreaterThanOrEqualTo(String value) {
            addCriterion("work_type >=", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLessThan(String value) {
            addCriterion("work_type <", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLessThanOrEqualTo(String value) {
            addCriterion("work_type <=", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLike(String value) {
            addCriterion("work_type like", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotLike(String value) {
            addCriterion("work_type not like", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIn(List<String> values) {
            addCriterion("work_type in", values, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotIn(List<String> values) {
            addCriterion("work_type not in", values, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeBetween(String value1, String value2) {
            addCriterion("work_type between", value1, value2, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotBetween(String value1, String value2) {
            addCriterion("work_type not between", value1, value2, "workType");
            return (Criteria) this;
        }

        public Criteria andProcedureNameIsNull() {
            addCriterion("procedure_name is null");
            return (Criteria) this;
        }

        public Criteria andProcedureNameIsNotNull() {
            addCriterion("procedure_name is not null");
            return (Criteria) this;
        }

        public Criteria andProcedureNameEqualTo(String value) {
            addCriterion("procedure_name =", value, "procedureName");
            return (Criteria) this;
        }

        public Criteria andProcedureNameNotEqualTo(String value) {
            addCriterion("procedure_name <>", value, "procedureName");
            return (Criteria) this;
        }

        public Criteria andProcedureNameGreaterThan(String value) {
            addCriterion("procedure_name >", value, "procedureName");
            return (Criteria) this;
        }

        public Criteria andProcedureNameGreaterThanOrEqualTo(String value) {
            addCriterion("procedure_name >=", value, "procedureName");
            return (Criteria) this;
        }

        public Criteria andProcedureNameLessThan(String value) {
            addCriterion("procedure_name <", value, "procedureName");
            return (Criteria) this;
        }

        public Criteria andProcedureNameLessThanOrEqualTo(String value) {
            addCriterion("procedure_name <=", value, "procedureName");
            return (Criteria) this;
        }

        public Criteria andProcedureNameLike(String value) {
            addCriterion("procedure_name like", value, "procedureName");
            return (Criteria) this;
        }

        public Criteria andProcedureNameNotLike(String value) {
            addCriterion("procedure_name not like", value, "procedureName");
            return (Criteria) this;
        }

        public Criteria andProcedureNameIn(List<String> values) {
            addCriterion("procedure_name in", values, "procedureName");
            return (Criteria) this;
        }

        public Criteria andProcedureNameNotIn(List<String> values) {
            addCriterion("procedure_name not in", values, "procedureName");
            return (Criteria) this;
        }

        public Criteria andProcedureNameBetween(String value1, String value2) {
            addCriterion("procedure_name between", value1, value2, "procedureName");
            return (Criteria) this;
        }

        public Criteria andProcedureNameNotBetween(String value1, String value2) {
            addCriterion("procedure_name not between", value1, value2, "procedureName");
            return (Criteria) this;
        }

        public Criteria andPostCodeIsNull() {
            addCriterion("post_code is null");
            return (Criteria) this;
        }

        public Criteria andPostCodeIsNotNull() {
            addCriterion("post_code is not null");
            return (Criteria) this;
        }

        public Criteria andPostCodeEqualTo(String value) {
            addCriterion("post_code =", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotEqualTo(String value) {
            addCriterion("post_code <>", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeGreaterThan(String value) {
            addCriterion("post_code >", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeGreaterThanOrEqualTo(String value) {
            addCriterion("post_code >=", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeLessThan(String value) {
            addCriterion("post_code <", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeLessThanOrEqualTo(String value) {
            addCriterion("post_code <=", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeLike(String value) {
            addCriterion("post_code like", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotLike(String value) {
            addCriterion("post_code not like", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeIn(List<String> values) {
            addCriterion("post_code in", values, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotIn(List<String> values) {
            addCriterion("post_code not in", values, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeBetween(String value1, String value2) {
            addCriterion("post_code between", value1, value2, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotBetween(String value1, String value2) {
            addCriterion("post_code not between", value1, value2, "postCode");
            return (Criteria) this;
        }

        public Criteria andHourQuotaPriceIsNull() {
            addCriterion("hour_quota_price is null");
            return (Criteria) this;
        }

        public Criteria andHourQuotaPriceIsNotNull() {
            addCriterion("hour_quota_price is not null");
            return (Criteria) this;
        }

        public Criteria andHourQuotaPriceEqualTo(BigDecimal value) {
            addCriterion("hour_quota_price =", value, "hourQuotaPrice");
            return (Criteria) this;
        }

        public Criteria andHourQuotaPriceNotEqualTo(BigDecimal value) {
            addCriterion("hour_quota_price <>", value, "hourQuotaPrice");
            return (Criteria) this;
        }

        public Criteria andHourQuotaPriceGreaterThan(BigDecimal value) {
            addCriterion("hour_quota_price >", value, "hourQuotaPrice");
            return (Criteria) this;
        }

        public Criteria andHourQuotaPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_quota_price >=", value, "hourQuotaPrice");
            return (Criteria) this;
        }

        public Criteria andHourQuotaPriceLessThan(BigDecimal value) {
            addCriterion("hour_quota_price <", value, "hourQuotaPrice");
            return (Criteria) this;
        }

        public Criteria andHourQuotaPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_quota_price <=", value, "hourQuotaPrice");
            return (Criteria) this;
        }

        public Criteria andHourQuotaPriceIn(List<BigDecimal> values) {
            addCriterion("hour_quota_price in", values, "hourQuotaPrice");
            return (Criteria) this;
        }

        public Criteria andHourQuotaPriceNotIn(List<BigDecimal> values) {
            addCriterion("hour_quota_price not in", values, "hourQuotaPrice");
            return (Criteria) this;
        }

        public Criteria andHourQuotaPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_quota_price between", value1, value2, "hourQuotaPrice");
            return (Criteria) this;
        }

        public Criteria andHourQuotaPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_quota_price not between", value1, value2, "hourQuotaPrice");
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

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
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

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
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