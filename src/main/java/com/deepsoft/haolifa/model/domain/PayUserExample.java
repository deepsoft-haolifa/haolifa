package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PayUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PayUserExample() {
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

        public Criteria andOnceUserNameIsNull() {
            addCriterion("once_user_name is null");
            return (Criteria) this;
        }

        public Criteria andOnceUserNameIsNotNull() {
            addCriterion("once_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andOnceUserNameEqualTo(String value) {
            addCriterion("once_user_name =", value, "onceUserName");
            return (Criteria) this;
        }

        public Criteria andOnceUserNameNotEqualTo(String value) {
            addCriterion("once_user_name <>", value, "onceUserName");
            return (Criteria) this;
        }

        public Criteria andOnceUserNameGreaterThan(String value) {
            addCriterion("once_user_name >", value, "onceUserName");
            return (Criteria) this;
        }

        public Criteria andOnceUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("once_user_name >=", value, "onceUserName");
            return (Criteria) this;
        }

        public Criteria andOnceUserNameLessThan(String value) {
            addCriterion("once_user_name <", value, "onceUserName");
            return (Criteria) this;
        }

        public Criteria andOnceUserNameLessThanOrEqualTo(String value) {
            addCriterion("once_user_name <=", value, "onceUserName");
            return (Criteria) this;
        }

        public Criteria andOnceUserNameLike(String value) {
            addCriterion("once_user_name like", value, "onceUserName");
            return (Criteria) this;
        }

        public Criteria andOnceUserNameNotLike(String value) {
            addCriterion("once_user_name not like", value, "onceUserName");
            return (Criteria) this;
        }

        public Criteria andOnceUserNameIn(List<String> values) {
            addCriterion("once_user_name in", values, "onceUserName");
            return (Criteria) this;
        }

        public Criteria andOnceUserNameNotIn(List<String> values) {
            addCriterion("once_user_name not in", values, "onceUserName");
            return (Criteria) this;
        }

        public Criteria andOnceUserNameBetween(String value1, String value2) {
            addCriterion("once_user_name between", value1, value2, "onceUserName");
            return (Criteria) this;
        }

        public Criteria andOnceUserNameNotBetween(String value1, String value2) {
            addCriterion("once_user_name not between", value1, value2, "onceUserName");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Byte value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Byte value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Byte value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Byte value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Byte value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Byte value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Byte> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Byte> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Byte value1, Byte value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Byte value1, Byte value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("nation is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("nation is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("nation =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("nation <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("nation >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("nation >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("nation <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("nation <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("nation like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("nation not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<String> values) {
            addCriterion("nation in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<String> values) {
            addCriterion("nation not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("nation between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("nation not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIsNull() {
            addCriterion("native_place is null");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIsNotNull() {
            addCriterion("native_place is not null");
            return (Criteria) this;
        }

        public Criteria andNativePlaceEqualTo(String value) {
            addCriterion("native_place =", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotEqualTo(String value) {
            addCriterion("native_place <>", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceGreaterThan(String value) {
            addCriterion("native_place >", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceGreaterThanOrEqualTo(String value) {
            addCriterion("native_place >=", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLessThan(String value) {
            addCriterion("native_place <", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLessThanOrEqualTo(String value) {
            addCriterion("native_place <=", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLike(String value) {
            addCriterion("native_place like", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotLike(String value) {
            addCriterion("native_place not like", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIn(List<String> values) {
            addCriterion("native_place in", values, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotIn(List<String> values) {
            addCriterion("native_place not in", values, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceBetween(String value1, String value2) {
            addCriterion("native_place between", value1, value2, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotBetween(String value1, String value2) {
            addCriterion("native_place not between", value1, value2, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andPoliticalOutlookIsNull() {
            addCriterion("political_outlook is null");
            return (Criteria) this;
        }

        public Criteria andPoliticalOutlookIsNotNull() {
            addCriterion("political_outlook is not null");
            return (Criteria) this;
        }

        public Criteria andPoliticalOutlookEqualTo(String value) {
            addCriterion("political_outlook =", value, "politicalOutlook");
            return (Criteria) this;
        }

        public Criteria andPoliticalOutlookNotEqualTo(String value) {
            addCriterion("political_outlook <>", value, "politicalOutlook");
            return (Criteria) this;
        }

        public Criteria andPoliticalOutlookGreaterThan(String value) {
            addCriterion("political_outlook >", value, "politicalOutlook");
            return (Criteria) this;
        }

        public Criteria andPoliticalOutlookGreaterThanOrEqualTo(String value) {
            addCriterion("political_outlook >=", value, "politicalOutlook");
            return (Criteria) this;
        }

        public Criteria andPoliticalOutlookLessThan(String value) {
            addCriterion("political_outlook <", value, "politicalOutlook");
            return (Criteria) this;
        }

        public Criteria andPoliticalOutlookLessThanOrEqualTo(String value) {
            addCriterion("political_outlook <=", value, "politicalOutlook");
            return (Criteria) this;
        }

        public Criteria andPoliticalOutlookLike(String value) {
            addCriterion("political_outlook like", value, "politicalOutlook");
            return (Criteria) this;
        }

        public Criteria andPoliticalOutlookNotLike(String value) {
            addCriterion("political_outlook not like", value, "politicalOutlook");
            return (Criteria) this;
        }

        public Criteria andPoliticalOutlookIn(List<String> values) {
            addCriterion("political_outlook in", values, "politicalOutlook");
            return (Criteria) this;
        }

        public Criteria andPoliticalOutlookNotIn(List<String> values) {
            addCriterion("political_outlook not in", values, "politicalOutlook");
            return (Criteria) this;
        }

        public Criteria andPoliticalOutlookBetween(String value1, String value2) {
            addCriterion("political_outlook between", value1, value2, "politicalOutlook");
            return (Criteria) this;
        }

        public Criteria andPoliticalOutlookNotBetween(String value1, String value2) {
            addCriterion("political_outlook not between", value1, value2, "politicalOutlook");
            return (Criteria) this;
        }

        public Criteria andBloodTypeIsNull() {
            addCriterion("blood_type is null");
            return (Criteria) this;
        }

        public Criteria andBloodTypeIsNotNull() {
            addCriterion("blood_type is not null");
            return (Criteria) this;
        }

        public Criteria andBloodTypeEqualTo(String value) {
            addCriterion("blood_type =", value, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeNotEqualTo(String value) {
            addCriterion("blood_type <>", value, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeGreaterThan(String value) {
            addCriterion("blood_type >", value, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeGreaterThanOrEqualTo(String value) {
            addCriterion("blood_type >=", value, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeLessThan(String value) {
            addCriterion("blood_type <", value, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeLessThanOrEqualTo(String value) {
            addCriterion("blood_type <=", value, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeLike(String value) {
            addCriterion("blood_type like", value, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeNotLike(String value) {
            addCriterion("blood_type not like", value, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeIn(List<String> values) {
            addCriterion("blood_type in", values, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeNotIn(List<String> values) {
            addCriterion("blood_type not in", values, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeBetween(String value1, String value2) {
            addCriterion("blood_type between", value1, value2, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeNotBetween(String value1, String value2) {
            addCriterion("blood_type not between", value1, value2, "bloodType");
            return (Criteria) this;
        }

        public Criteria andHealthIsNull() {
            addCriterion("health is null");
            return (Criteria) this;
        }

        public Criteria andHealthIsNotNull() {
            addCriterion("health is not null");
            return (Criteria) this;
        }

        public Criteria andHealthEqualTo(String value) {
            addCriterion("health =", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthNotEqualTo(String value) {
            addCriterion("health <>", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthGreaterThan(String value) {
            addCriterion("health >", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthGreaterThanOrEqualTo(String value) {
            addCriterion("health >=", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthLessThan(String value) {
            addCriterion("health <", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthLessThanOrEqualTo(String value) {
            addCriterion("health <=", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthLike(String value) {
            addCriterion("health like", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthNotLike(String value) {
            addCriterion("health not like", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthIn(List<String> values) {
            addCriterion("health in", values, "health");
            return (Criteria) this;
        }

        public Criteria andHealthNotIn(List<String> values) {
            addCriterion("health not in", values, "health");
            return (Criteria) this;
        }

        public Criteria andHealthBetween(String value1, String value2) {
            addCriterion("health between", value1, value2, "health");
            return (Criteria) this;
        }

        public Criteria andHealthNotBetween(String value1, String value2) {
            addCriterion("health not between", value1, value2, "health");
            return (Criteria) this;
        }

        public Criteria andMarryStatusIsNull() {
            addCriterion("marry_status is null");
            return (Criteria) this;
        }

        public Criteria andMarryStatusIsNotNull() {
            addCriterion("marry_status is not null");
            return (Criteria) this;
        }

        public Criteria andMarryStatusEqualTo(Byte value) {
            addCriterion("marry_status =", value, "marryStatus");
            return (Criteria) this;
        }

        public Criteria andMarryStatusNotEqualTo(Byte value) {
            addCriterion("marry_status <>", value, "marryStatus");
            return (Criteria) this;
        }

        public Criteria andMarryStatusGreaterThan(Byte value) {
            addCriterion("marry_status >", value, "marryStatus");
            return (Criteria) this;
        }

        public Criteria andMarryStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("marry_status >=", value, "marryStatus");
            return (Criteria) this;
        }

        public Criteria andMarryStatusLessThan(Byte value) {
            addCriterion("marry_status <", value, "marryStatus");
            return (Criteria) this;
        }

        public Criteria andMarryStatusLessThanOrEqualTo(Byte value) {
            addCriterion("marry_status <=", value, "marryStatus");
            return (Criteria) this;
        }

        public Criteria andMarryStatusIn(List<Byte> values) {
            addCriterion("marry_status in", values, "marryStatus");
            return (Criteria) this;
        }

        public Criteria andMarryStatusNotIn(List<Byte> values) {
            addCriterion("marry_status not in", values, "marryStatus");
            return (Criteria) this;
        }

        public Criteria andMarryStatusBetween(Byte value1, Byte value2) {
            addCriterion("marry_status between", value1, value2, "marryStatus");
            return (Criteria) this;
        }

        public Criteria andMarryStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("marry_status not between", value1, value2, "marryStatus");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNull() {
            addCriterion("id_card is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNotNull() {
            addCriterion("id_card is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEqualTo(String value) {
            addCriterion("id_card =", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotEqualTo(String value) {
            addCriterion("id_card <>", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThan(String value) {
            addCriterion("id_card >", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("id_card >=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThan(String value) {
            addCriterion("id_card <", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThanOrEqualTo(String value) {
            addCriterion("id_card <=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLike(String value) {
            addCriterion("id_card like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotLike(String value) {
            addCriterion("id_card not like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardIn(List<String> values) {
            addCriterion("id_card in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotIn(List<String> values) {
            addCriterion("id_card not in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardBetween(String value1, String value2) {
            addCriterion("id_card between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotBetween(String value1, String value2) {
            addCriterion("id_card not between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andRegisteredIsNull() {
            addCriterion("registered is null");
            return (Criteria) this;
        }

        public Criteria andRegisteredIsNotNull() {
            addCriterion("registered is not null");
            return (Criteria) this;
        }

        public Criteria andRegisteredEqualTo(String value) {
            addCriterion("registered =", value, "registered");
            return (Criteria) this;
        }

        public Criteria andRegisteredNotEqualTo(String value) {
            addCriterion("registered <>", value, "registered");
            return (Criteria) this;
        }

        public Criteria andRegisteredGreaterThan(String value) {
            addCriterion("registered >", value, "registered");
            return (Criteria) this;
        }

        public Criteria andRegisteredGreaterThanOrEqualTo(String value) {
            addCriterion("registered >=", value, "registered");
            return (Criteria) this;
        }

        public Criteria andRegisteredLessThan(String value) {
            addCriterion("registered <", value, "registered");
            return (Criteria) this;
        }

        public Criteria andRegisteredLessThanOrEqualTo(String value) {
            addCriterion("registered <=", value, "registered");
            return (Criteria) this;
        }

        public Criteria andRegisteredLike(String value) {
            addCriterion("registered like", value, "registered");
            return (Criteria) this;
        }

        public Criteria andRegisteredNotLike(String value) {
            addCriterion("registered not like", value, "registered");
            return (Criteria) this;
        }

        public Criteria andRegisteredIn(List<String> values) {
            addCriterion("registered in", values, "registered");
            return (Criteria) this;
        }

        public Criteria andRegisteredNotIn(List<String> values) {
            addCriterion("registered not in", values, "registered");
            return (Criteria) this;
        }

        public Criteria andRegisteredBetween(String value1, String value2) {
            addCriterion("registered between", value1, value2, "registered");
            return (Criteria) this;
        }

        public Criteria andRegisteredNotBetween(String value1, String value2) {
            addCriterion("registered not between", value1, value2, "registered");
            return (Criteria) this;
        }

        public Criteria andUniversityFromIsNull() {
            addCriterion("university_from is null");
            return (Criteria) this;
        }

        public Criteria andUniversityFromIsNotNull() {
            addCriterion("university_from is not null");
            return (Criteria) this;
        }

        public Criteria andUniversityFromEqualTo(String value) {
            addCriterion("university_from =", value, "universityFrom");
            return (Criteria) this;
        }

        public Criteria andUniversityFromNotEqualTo(String value) {
            addCriterion("university_from <>", value, "universityFrom");
            return (Criteria) this;
        }

        public Criteria andUniversityFromGreaterThan(String value) {
            addCriterion("university_from >", value, "universityFrom");
            return (Criteria) this;
        }

        public Criteria andUniversityFromGreaterThanOrEqualTo(String value) {
            addCriterion("university_from >=", value, "universityFrom");
            return (Criteria) this;
        }

        public Criteria andUniversityFromLessThan(String value) {
            addCriterion("university_from <", value, "universityFrom");
            return (Criteria) this;
        }

        public Criteria andUniversityFromLessThanOrEqualTo(String value) {
            addCriterion("university_from <=", value, "universityFrom");
            return (Criteria) this;
        }

        public Criteria andUniversityFromLike(String value) {
            addCriterion("university_from like", value, "universityFrom");
            return (Criteria) this;
        }

        public Criteria andUniversityFromNotLike(String value) {
            addCriterion("university_from not like", value, "universityFrom");
            return (Criteria) this;
        }

        public Criteria andUniversityFromIn(List<String> values) {
            addCriterion("university_from in", values, "universityFrom");
            return (Criteria) this;
        }

        public Criteria andUniversityFromNotIn(List<String> values) {
            addCriterion("university_from not in", values, "universityFrom");
            return (Criteria) this;
        }

        public Criteria andUniversityFromBetween(String value1, String value2) {
            addCriterion("university_from between", value1, value2, "universityFrom");
            return (Criteria) this;
        }

        public Criteria andUniversityFromNotBetween(String value1, String value2) {
            addCriterion("university_from not between", value1, value2, "universityFrom");
            return (Criteria) this;
        }

        public Criteria andMajorIsNull() {
            addCriterion("major is null");
            return (Criteria) this;
        }

        public Criteria andMajorIsNotNull() {
            addCriterion("major is not null");
            return (Criteria) this;
        }

        public Criteria andMajorEqualTo(String value) {
            addCriterion("major =", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotEqualTo(String value) {
            addCriterion("major <>", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThan(String value) {
            addCriterion("major >", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThanOrEqualTo(String value) {
            addCriterion("major >=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThan(String value) {
            addCriterion("major <", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThanOrEqualTo(String value) {
            addCriterion("major <=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLike(String value) {
            addCriterion("major like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotLike(String value) {
            addCriterion("major not like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorIn(List<String> values) {
            addCriterion("major in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotIn(List<String> values) {
            addCriterion("major not in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorBetween(String value1, String value2) {
            addCriterion("major between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotBetween(String value1, String value2) {
            addCriterion("major not between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andEducationIsNull() {
            addCriterion("education is null");
            return (Criteria) this;
        }

        public Criteria andEducationIsNotNull() {
            addCriterion("education is not null");
            return (Criteria) this;
        }

        public Criteria andEducationEqualTo(Byte value) {
            addCriterion("education =", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotEqualTo(Byte value) {
            addCriterion("education <>", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThan(Byte value) {
            addCriterion("education >", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThanOrEqualTo(Byte value) {
            addCriterion("education >=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThan(Byte value) {
            addCriterion("education <", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThanOrEqualTo(Byte value) {
            addCriterion("education <=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationIn(List<Byte> values) {
            addCriterion("education in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotIn(List<Byte> values) {
            addCriterion("education not in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationBetween(Byte value1, Byte value2) {
            addCriterion("education between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotBetween(Byte value1, Byte value2) {
            addCriterion("education not between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeIsNull() {
            addCriterion("graduation_time is null");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeIsNotNull() {
            addCriterion("graduation_time is not null");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeEqualTo(Date value) {
            addCriterion("graduation_time =", value, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeNotEqualTo(Date value) {
            addCriterion("graduation_time <>", value, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeGreaterThan(Date value) {
            addCriterion("graduation_time >", value, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("graduation_time >=", value, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeLessThan(Date value) {
            addCriterion("graduation_time <", value, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeLessThanOrEqualTo(Date value) {
            addCriterion("graduation_time <=", value, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeIn(List<Date> values) {
            addCriterion("graduation_time in", values, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeNotIn(List<Date> values) {
            addCriterion("graduation_time not in", values, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeBetween(Date value1, Date value2) {
            addCriterion("graduation_time between", value1, value2, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeNotBetween(Date value1, Date value2) {
            addCriterion("graduation_time not between", value1, value2, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeIsNull() {
            addCriterion("working_time is null");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeIsNotNull() {
            addCriterion("working_time is not null");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeEqualTo(Date value) {
            addCriterion("working_time =", value, "workingTime");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeNotEqualTo(Date value) {
            addCriterion("working_time <>", value, "workingTime");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeGreaterThan(Date value) {
            addCriterion("working_time >", value, "workingTime");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("working_time >=", value, "workingTime");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeLessThan(Date value) {
            addCriterion("working_time <", value, "workingTime");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeLessThanOrEqualTo(Date value) {
            addCriterion("working_time <=", value, "workingTime");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeIn(List<Date> values) {
            addCriterion("working_time in", values, "workingTime");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeNotIn(List<Date> values) {
            addCriterion("working_time not in", values, "workingTime");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeBetween(Date value1, Date value2) {
            addCriterion("working_time between", value1, value2, "workingTime");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeNotBetween(Date value1, Date value2) {
            addCriterion("working_time not between", value1, value2, "workingTime");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andInsuranceBaseIsNull() {
            addCriterion("insurance_base is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceBaseIsNotNull() {
            addCriterion("insurance_base is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceBaseEqualTo(BigDecimal value) {
            addCriterion("insurance_base =", value, "insuranceBase");
            return (Criteria) this;
        }

        public Criteria andInsuranceBaseNotEqualTo(BigDecimal value) {
            addCriterion("insurance_base <>", value, "insuranceBase");
            return (Criteria) this;
        }

        public Criteria andInsuranceBaseGreaterThan(BigDecimal value) {
            addCriterion("insurance_base >", value, "insuranceBase");
            return (Criteria) this;
        }

        public Criteria andInsuranceBaseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("insurance_base >=", value, "insuranceBase");
            return (Criteria) this;
        }

        public Criteria andInsuranceBaseLessThan(BigDecimal value) {
            addCriterion("insurance_base <", value, "insuranceBase");
            return (Criteria) this;
        }

        public Criteria andInsuranceBaseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("insurance_base <=", value, "insuranceBase");
            return (Criteria) this;
        }

        public Criteria andInsuranceBaseIn(List<BigDecimal> values) {
            addCriterion("insurance_base in", values, "insuranceBase");
            return (Criteria) this;
        }

        public Criteria andInsuranceBaseNotIn(List<BigDecimal> values) {
            addCriterion("insurance_base not in", values, "insuranceBase");
            return (Criteria) this;
        }

        public Criteria andInsuranceBaseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("insurance_base between", value1, value2, "insuranceBase");
            return (Criteria) this;
        }

        public Criteria andInsuranceBaseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("insurance_base not between", value1, value2, "insuranceBase");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andMailIsNull() {
            addCriterion("mail is null");
            return (Criteria) this;
        }

        public Criteria andMailIsNotNull() {
            addCriterion("mail is not null");
            return (Criteria) this;
        }

        public Criteria andMailEqualTo(String value) {
            addCriterion("mail =", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotEqualTo(String value) {
            addCriterion("mail <>", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThan(String value) {
            addCriterion("mail >", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThanOrEqualTo(String value) {
            addCriterion("mail >=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThan(String value) {
            addCriterion("mail <", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThanOrEqualTo(String value) {
            addCriterion("mail <=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLike(String value) {
            addCriterion("mail like", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotLike(String value) {
            addCriterion("mail not like", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailIn(List<String> values) {
            addCriterion("mail in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotIn(List<String> values) {
            addCriterion("mail not in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailBetween(String value1, String value2) {
            addCriterion("mail between", value1, value2, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotBetween(String value1, String value2) {
            addCriterion("mail not between", value1, value2, "mail");
            return (Criteria) this;
        }

        public Criteria andTeamIdIsNull() {
            addCriterion("team_id is null");
            return (Criteria) this;
        }

        public Criteria andTeamIdIsNotNull() {
            addCriterion("team_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeamIdEqualTo(Integer value) {
            addCriterion("team_id =", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotEqualTo(Integer value) {
            addCriterion("team_id <>", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThan(Integer value) {
            addCriterion("team_id >", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("team_id >=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThan(Integer value) {
            addCriterion("team_id <", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThanOrEqualTo(Integer value) {
            addCriterion("team_id <=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdIn(List<Integer> values) {
            addCriterion("team_id in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotIn(List<Integer> values) {
            addCriterion("team_id not in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdBetween(Integer value1, Integer value2) {
            addCriterion("team_id between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotBetween(Integer value1, Integer value2) {
            addCriterion("team_id not between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andBasePayIsNull() {
            addCriterion("base_pay is null");
            return (Criteria) this;
        }

        public Criteria andBasePayIsNotNull() {
            addCriterion("base_pay is not null");
            return (Criteria) this;
        }

        public Criteria andBasePayEqualTo(BigDecimal value) {
            addCriterion("base_pay =", value, "basePay");
            return (Criteria) this;
        }

        public Criteria andBasePayNotEqualTo(BigDecimal value) {
            addCriterion("base_pay <>", value, "basePay");
            return (Criteria) this;
        }

        public Criteria andBasePayGreaterThan(BigDecimal value) {
            addCriterion("base_pay >", value, "basePay");
            return (Criteria) this;
        }

        public Criteria andBasePayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("base_pay >=", value, "basePay");
            return (Criteria) this;
        }

        public Criteria andBasePayLessThan(BigDecimal value) {
            addCriterion("base_pay <", value, "basePay");
            return (Criteria) this;
        }

        public Criteria andBasePayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("base_pay <=", value, "basePay");
            return (Criteria) this;
        }

        public Criteria andBasePayIn(List<BigDecimal> values) {
            addCriterion("base_pay in", values, "basePay");
            return (Criteria) this;
        }

        public Criteria andBasePayNotIn(List<BigDecimal> values) {
            addCriterion("base_pay not in", values, "basePay");
            return (Criteria) this;
        }

        public Criteria andBasePayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("base_pay between", value1, value2, "basePay");
            return (Criteria) this;
        }

        public Criteria andBasePayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("base_pay not between", value1, value2, "basePay");
            return (Criteria) this;
        }

        public Criteria andMeritPayIsNull() {
            addCriterion("merit_pay is null");
            return (Criteria) this;
        }

        public Criteria andMeritPayIsNotNull() {
            addCriterion("merit_pay is not null");
            return (Criteria) this;
        }

        public Criteria andMeritPayEqualTo(BigDecimal value) {
            addCriterion("merit_pay =", value, "meritPay");
            return (Criteria) this;
        }

        public Criteria andMeritPayNotEqualTo(BigDecimal value) {
            addCriterion("merit_pay <>", value, "meritPay");
            return (Criteria) this;
        }

        public Criteria andMeritPayGreaterThan(BigDecimal value) {
            addCriterion("merit_pay >", value, "meritPay");
            return (Criteria) this;
        }

        public Criteria andMeritPayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("merit_pay >=", value, "meritPay");
            return (Criteria) this;
        }

        public Criteria andMeritPayLessThan(BigDecimal value) {
            addCriterion("merit_pay <", value, "meritPay");
            return (Criteria) this;
        }

        public Criteria andMeritPayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("merit_pay <=", value, "meritPay");
            return (Criteria) this;
        }

        public Criteria andMeritPayIn(List<BigDecimal> values) {
            addCriterion("merit_pay in", values, "meritPay");
            return (Criteria) this;
        }

        public Criteria andMeritPayNotIn(List<BigDecimal> values) {
            addCriterion("merit_pay not in", values, "meritPay");
            return (Criteria) this;
        }

        public Criteria andMeritPayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("merit_pay between", value1, value2, "meritPay");
            return (Criteria) this;
        }

        public Criteria andMeritPayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("merit_pay not between", value1, value2, "meritPay");
            return (Criteria) this;
        }

        public Criteria andPostIdIsNull() {
            addCriterion("post_id is null");
            return (Criteria) this;
        }

        public Criteria andPostIdIsNotNull() {
            addCriterion("post_id is not null");
            return (Criteria) this;
        }

        public Criteria andPostIdEqualTo(Integer value) {
            addCriterion("post_id =", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotEqualTo(Integer value) {
            addCriterion("post_id <>", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdGreaterThan(Integer value) {
            addCriterion("post_id >", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("post_id >=", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLessThan(Integer value) {
            addCriterion("post_id <", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLessThanOrEqualTo(Integer value) {
            addCriterion("post_id <=", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdIn(List<Integer> values) {
            addCriterion("post_id in", values, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotIn(List<Integer> values) {
            addCriterion("post_id not in", values, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdBetween(Integer value1, Integer value2) {
            addCriterion("post_id between", value1, value2, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotBetween(Integer value1, Integer value2) {
            addCriterion("post_id not between", value1, value2, "postId");
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