package com.deepsoft.haolifa.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SupplierEvaluationInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SupplierEvaluationInfoExample() {
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

        public Criteria andSupplierNumIsNull() {
            addCriterion("supplier_num is null");
            return (Criteria) this;
        }

        public Criteria andSupplierNumIsNotNull() {
            addCriterion("supplier_num is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierNumEqualTo(String value) {
            addCriterion("supplier_num =", value, "supplierNum");
            return (Criteria) this;
        }

        public Criteria andSupplierNumNotEqualTo(String value) {
            addCriterion("supplier_num <>", value, "supplierNum");
            return (Criteria) this;
        }

        public Criteria andSupplierNumGreaterThan(String value) {
            addCriterion("supplier_num >", value, "supplierNum");
            return (Criteria) this;
        }

        public Criteria andSupplierNumGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_num >=", value, "supplierNum");
            return (Criteria) this;
        }

        public Criteria andSupplierNumLessThan(String value) {
            addCriterion("supplier_num <", value, "supplierNum");
            return (Criteria) this;
        }

        public Criteria andSupplierNumLessThanOrEqualTo(String value) {
            addCriterion("supplier_num <=", value, "supplierNum");
            return (Criteria) this;
        }

        public Criteria andSupplierNumLike(String value) {
            addCriterion("supplier_num like", value, "supplierNum");
            return (Criteria) this;
        }

        public Criteria andSupplierNumNotLike(String value) {
            addCriterion("supplier_num not like", value, "supplierNum");
            return (Criteria) this;
        }

        public Criteria andSupplierNumIn(List<String> values) {
            addCriterion("supplier_num in", values, "supplierNum");
            return (Criteria) this;
        }

        public Criteria andSupplierNumNotIn(List<String> values) {
            addCriterion("supplier_num not in", values, "supplierNum");
            return (Criteria) this;
        }

        public Criteria andSupplierNumBetween(String value1, String value2) {
            addCriterion("supplier_num between", value1, value2, "supplierNum");
            return (Criteria) this;
        }

        public Criteria andSupplierNumNotBetween(String value1, String value2) {
            addCriterion("supplier_num not between", value1, value2, "supplierNum");
            return (Criteria) this;
        }

        public Criteria andQcWayIsNull() {
            addCriterion("qc_way is null");
            return (Criteria) this;
        }

        public Criteria andQcWayIsNotNull() {
            addCriterion("qc_way is not null");
            return (Criteria) this;
        }

        public Criteria andQcWayEqualTo(String value) {
            addCriterion("qc_way =", value, "qcWay");
            return (Criteria) this;
        }

        public Criteria andQcWayNotEqualTo(String value) {
            addCriterion("qc_way <>", value, "qcWay");
            return (Criteria) this;
        }

        public Criteria andQcWayGreaterThan(String value) {
            addCriterion("qc_way >", value, "qcWay");
            return (Criteria) this;
        }

        public Criteria andQcWayGreaterThanOrEqualTo(String value) {
            addCriterion("qc_way >=", value, "qcWay");
            return (Criteria) this;
        }

        public Criteria andQcWayLessThan(String value) {
            addCriterion("qc_way <", value, "qcWay");
            return (Criteria) this;
        }

        public Criteria andQcWayLessThanOrEqualTo(String value) {
            addCriterion("qc_way <=", value, "qcWay");
            return (Criteria) this;
        }

        public Criteria andQcWayLike(String value) {
            addCriterion("qc_way like", value, "qcWay");
            return (Criteria) this;
        }

        public Criteria andQcWayNotLike(String value) {
            addCriterion("qc_way not like", value, "qcWay");
            return (Criteria) this;
        }

        public Criteria andQcWayIn(List<String> values) {
            addCriterion("qc_way in", values, "qcWay");
            return (Criteria) this;
        }

        public Criteria andQcWayNotIn(List<String> values) {
            addCriterion("qc_way not in", values, "qcWay");
            return (Criteria) this;
        }

        public Criteria andQcWayBetween(String value1, String value2) {
            addCriterion("qc_way between", value1, value2, "qcWay");
            return (Criteria) this;
        }

        public Criteria andQcWayNotBetween(String value1, String value2) {
            addCriterion("qc_way not between", value1, value2, "qcWay");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(String value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(String value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(String value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(String value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(String value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(String value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLike(String value) {
            addCriterion("year like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotLike(String value) {
            addCriterion("year not like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<String> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<String> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(String value1, String value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(String value1, String value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andQualityScoreIsNull() {
            addCriterion("quality_score is null");
            return (Criteria) this;
        }

        public Criteria andQualityScoreIsNotNull() {
            addCriterion("quality_score is not null");
            return (Criteria) this;
        }

        public Criteria andQualityScoreEqualTo(Integer value) {
            addCriterion("quality_score =", value, "qualityScore");
            return (Criteria) this;
        }

        public Criteria andQualityScoreNotEqualTo(Integer value) {
            addCriterion("quality_score <>", value, "qualityScore");
            return (Criteria) this;
        }

        public Criteria andQualityScoreGreaterThan(Integer value) {
            addCriterion("quality_score >", value, "qualityScore");
            return (Criteria) this;
        }

        public Criteria andQualityScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("quality_score >=", value, "qualityScore");
            return (Criteria) this;
        }

        public Criteria andQualityScoreLessThan(Integer value) {
            addCriterion("quality_score <", value, "qualityScore");
            return (Criteria) this;
        }

        public Criteria andQualityScoreLessThanOrEqualTo(Integer value) {
            addCriterion("quality_score <=", value, "qualityScore");
            return (Criteria) this;
        }

        public Criteria andQualityScoreIn(List<Integer> values) {
            addCriterion("quality_score in", values, "qualityScore");
            return (Criteria) this;
        }

        public Criteria andQualityScoreNotIn(List<Integer> values) {
            addCriterion("quality_score not in", values, "qualityScore");
            return (Criteria) this;
        }

        public Criteria andQualityScoreBetween(Integer value1, Integer value2) {
            addCriterion("quality_score between", value1, value2, "qualityScore");
            return (Criteria) this;
        }

        public Criteria andQualityScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("quality_score not between", value1, value2, "qualityScore");
            return (Criteria) this;
        }

        public Criteria andQualityPersonIsNull() {
            addCriterion("quality_person is null");
            return (Criteria) this;
        }

        public Criteria andQualityPersonIsNotNull() {
            addCriterion("quality_person is not null");
            return (Criteria) this;
        }

        public Criteria andQualityPersonEqualTo(String value) {
            addCriterion("quality_person =", value, "qualityPerson");
            return (Criteria) this;
        }

        public Criteria andQualityPersonNotEqualTo(String value) {
            addCriterion("quality_person <>", value, "qualityPerson");
            return (Criteria) this;
        }

        public Criteria andQualityPersonGreaterThan(String value) {
            addCriterion("quality_person >", value, "qualityPerson");
            return (Criteria) this;
        }

        public Criteria andQualityPersonGreaterThanOrEqualTo(String value) {
            addCriterion("quality_person >=", value, "qualityPerson");
            return (Criteria) this;
        }

        public Criteria andQualityPersonLessThan(String value) {
            addCriterion("quality_person <", value, "qualityPerson");
            return (Criteria) this;
        }

        public Criteria andQualityPersonLessThanOrEqualTo(String value) {
            addCriterion("quality_person <=", value, "qualityPerson");
            return (Criteria) this;
        }

        public Criteria andQualityPersonLike(String value) {
            addCriterion("quality_person like", value, "qualityPerson");
            return (Criteria) this;
        }

        public Criteria andQualityPersonNotLike(String value) {
            addCriterion("quality_person not like", value, "qualityPerson");
            return (Criteria) this;
        }

        public Criteria andQualityPersonIn(List<String> values) {
            addCriterion("quality_person in", values, "qualityPerson");
            return (Criteria) this;
        }

        public Criteria andQualityPersonNotIn(List<String> values) {
            addCriterion("quality_person not in", values, "qualityPerson");
            return (Criteria) this;
        }

        public Criteria andQualityPersonBetween(String value1, String value2) {
            addCriterion("quality_person between", value1, value2, "qualityPerson");
            return (Criteria) this;
        }

        public Criteria andQualityPersonNotBetween(String value1, String value2) {
            addCriterion("quality_person not between", value1, value2, "qualityPerson");
            return (Criteria) this;
        }

        public Criteria andQualityDateIsNull() {
            addCriterion("quality_date is null");
            return (Criteria) this;
        }

        public Criteria andQualityDateIsNotNull() {
            addCriterion("quality_date is not null");
            return (Criteria) this;
        }

        public Criteria andQualityDateEqualTo(Date value) {
            addCriterion("quality_date =", value, "qualityDate");
            return (Criteria) this;
        }

        public Criteria andQualityDateNotEqualTo(Date value) {
            addCriterion("quality_date <>", value, "qualityDate");
            return (Criteria) this;
        }

        public Criteria andQualityDateGreaterThan(Date value) {
            addCriterion("quality_date >", value, "qualityDate");
            return (Criteria) this;
        }

        public Criteria andQualityDateGreaterThanOrEqualTo(Date value) {
            addCriterion("quality_date >=", value, "qualityDate");
            return (Criteria) this;
        }

        public Criteria andQualityDateLessThan(Date value) {
            addCriterion("quality_date <", value, "qualityDate");
            return (Criteria) this;
        }

        public Criteria andQualityDateLessThanOrEqualTo(Date value) {
            addCriterion("quality_date <=", value, "qualityDate");
            return (Criteria) this;
        }

        public Criteria andQualityDateIn(List<Date> values) {
            addCriterion("quality_date in", values, "qualityDate");
            return (Criteria) this;
        }

        public Criteria andQualityDateNotIn(List<Date> values) {
            addCriterion("quality_date not in", values, "qualityDate");
            return (Criteria) this;
        }

        public Criteria andQualityDateBetween(Date value1, Date value2) {
            addCriterion("quality_date between", value1, value2, "qualityDate");
            return (Criteria) this;
        }

        public Criteria andQualityDateNotBetween(Date value1, Date value2) {
            addCriterion("quality_date not between", value1, value2, "qualityDate");
            return (Criteria) this;
        }

        public Criteria andDeliverScoreIsNull() {
            addCriterion("deliver_score is null");
            return (Criteria) this;
        }

        public Criteria andDeliverScoreIsNotNull() {
            addCriterion("deliver_score is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverScoreEqualTo(Integer value) {
            addCriterion("deliver_score =", value, "deliverScore");
            return (Criteria) this;
        }

        public Criteria andDeliverScoreNotEqualTo(Integer value) {
            addCriterion("deliver_score <>", value, "deliverScore");
            return (Criteria) this;
        }

        public Criteria andDeliverScoreGreaterThan(Integer value) {
            addCriterion("deliver_score >", value, "deliverScore");
            return (Criteria) this;
        }

        public Criteria andDeliverScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("deliver_score >=", value, "deliverScore");
            return (Criteria) this;
        }

        public Criteria andDeliverScoreLessThan(Integer value) {
            addCriterion("deliver_score <", value, "deliverScore");
            return (Criteria) this;
        }

        public Criteria andDeliverScoreLessThanOrEqualTo(Integer value) {
            addCriterion("deliver_score <=", value, "deliverScore");
            return (Criteria) this;
        }

        public Criteria andDeliverScoreIn(List<Integer> values) {
            addCriterion("deliver_score in", values, "deliverScore");
            return (Criteria) this;
        }

        public Criteria andDeliverScoreNotIn(List<Integer> values) {
            addCriterion("deliver_score not in", values, "deliverScore");
            return (Criteria) this;
        }

        public Criteria andDeliverScoreBetween(Integer value1, Integer value2) {
            addCriterion("deliver_score between", value1, value2, "deliverScore");
            return (Criteria) this;
        }

        public Criteria andDeliverScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("deliver_score not between", value1, value2, "deliverScore");
            return (Criteria) this;
        }

        public Criteria andDeliverPersonIsNull() {
            addCriterion("deliver_person is null");
            return (Criteria) this;
        }

        public Criteria andDeliverPersonIsNotNull() {
            addCriterion("deliver_person is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverPersonEqualTo(String value) {
            addCriterion("deliver_person =", value, "deliverPerson");
            return (Criteria) this;
        }

        public Criteria andDeliverPersonNotEqualTo(String value) {
            addCriterion("deliver_person <>", value, "deliverPerson");
            return (Criteria) this;
        }

        public Criteria andDeliverPersonGreaterThan(String value) {
            addCriterion("deliver_person >", value, "deliverPerson");
            return (Criteria) this;
        }

        public Criteria andDeliverPersonGreaterThanOrEqualTo(String value) {
            addCriterion("deliver_person >=", value, "deliverPerson");
            return (Criteria) this;
        }

        public Criteria andDeliverPersonLessThan(String value) {
            addCriterion("deliver_person <", value, "deliverPerson");
            return (Criteria) this;
        }

        public Criteria andDeliverPersonLessThanOrEqualTo(String value) {
            addCriterion("deliver_person <=", value, "deliverPerson");
            return (Criteria) this;
        }

        public Criteria andDeliverPersonLike(String value) {
            addCriterion("deliver_person like", value, "deliverPerson");
            return (Criteria) this;
        }

        public Criteria andDeliverPersonNotLike(String value) {
            addCriterion("deliver_person not like", value, "deliverPerson");
            return (Criteria) this;
        }

        public Criteria andDeliverPersonIn(List<String> values) {
            addCriterion("deliver_person in", values, "deliverPerson");
            return (Criteria) this;
        }

        public Criteria andDeliverPersonNotIn(List<String> values) {
            addCriterion("deliver_person not in", values, "deliverPerson");
            return (Criteria) this;
        }

        public Criteria andDeliverPersonBetween(String value1, String value2) {
            addCriterion("deliver_person between", value1, value2, "deliverPerson");
            return (Criteria) this;
        }

        public Criteria andDeliverPersonNotBetween(String value1, String value2) {
            addCriterion("deliver_person not between", value1, value2, "deliverPerson");
            return (Criteria) this;
        }

        public Criteria andDeliverScoreDateIsNull() {
            addCriterion("deliver_score_date is null");
            return (Criteria) this;
        }

        public Criteria andDeliverScoreDateIsNotNull() {
            addCriterion("deliver_score_date is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverScoreDateEqualTo(Date value) {
            addCriterion("deliver_score_date =", value, "deliverScoreDate");
            return (Criteria) this;
        }

        public Criteria andDeliverScoreDateNotEqualTo(Date value) {
            addCriterion("deliver_score_date <>", value, "deliverScoreDate");
            return (Criteria) this;
        }

        public Criteria andDeliverScoreDateGreaterThan(Date value) {
            addCriterion("deliver_score_date >", value, "deliverScoreDate");
            return (Criteria) this;
        }

        public Criteria andDeliverScoreDateGreaterThanOrEqualTo(Date value) {
            addCriterion("deliver_score_date >=", value, "deliverScoreDate");
            return (Criteria) this;
        }

        public Criteria andDeliverScoreDateLessThan(Date value) {
            addCriterion("deliver_score_date <", value, "deliverScoreDate");
            return (Criteria) this;
        }

        public Criteria andDeliverScoreDateLessThanOrEqualTo(Date value) {
            addCriterion("deliver_score_date <=", value, "deliverScoreDate");
            return (Criteria) this;
        }

        public Criteria andDeliverScoreDateIn(List<Date> values) {
            addCriterion("deliver_score_date in", values, "deliverScoreDate");
            return (Criteria) this;
        }

        public Criteria andDeliverScoreDateNotIn(List<Date> values) {
            addCriterion("deliver_score_date not in", values, "deliverScoreDate");
            return (Criteria) this;
        }

        public Criteria andDeliverScoreDateBetween(Date value1, Date value2) {
            addCriterion("deliver_score_date between", value1, value2, "deliverScoreDate");
            return (Criteria) this;
        }

        public Criteria andDeliverScoreDateNotBetween(Date value1, Date value2) {
            addCriterion("deliver_score_date not between", value1, value2, "deliverScoreDate");
            return (Criteria) this;
        }

        public Criteria andOtherScoreIsNull() {
            addCriterion("other_score is null");
            return (Criteria) this;
        }

        public Criteria andOtherScoreIsNotNull() {
            addCriterion("other_score is not null");
            return (Criteria) this;
        }

        public Criteria andOtherScoreEqualTo(Integer value) {
            addCriterion("other_score =", value, "otherScore");
            return (Criteria) this;
        }

        public Criteria andOtherScoreNotEqualTo(Integer value) {
            addCriterion("other_score <>", value, "otherScore");
            return (Criteria) this;
        }

        public Criteria andOtherScoreGreaterThan(Integer value) {
            addCriterion("other_score >", value, "otherScore");
            return (Criteria) this;
        }

        public Criteria andOtherScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("other_score >=", value, "otherScore");
            return (Criteria) this;
        }

        public Criteria andOtherScoreLessThan(Integer value) {
            addCriterion("other_score <", value, "otherScore");
            return (Criteria) this;
        }

        public Criteria andOtherScoreLessThanOrEqualTo(Integer value) {
            addCriterion("other_score <=", value, "otherScore");
            return (Criteria) this;
        }

        public Criteria andOtherScoreIn(List<Integer> values) {
            addCriterion("other_score in", values, "otherScore");
            return (Criteria) this;
        }

        public Criteria andOtherScoreNotIn(List<Integer> values) {
            addCriterion("other_score not in", values, "otherScore");
            return (Criteria) this;
        }

        public Criteria andOtherScoreBetween(Integer value1, Integer value2) {
            addCriterion("other_score between", value1, value2, "otherScore");
            return (Criteria) this;
        }

        public Criteria andOtherScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("other_score not between", value1, value2, "otherScore");
            return (Criteria) this;
        }

        public Criteria andOtherPersonIsNull() {
            addCriterion("other_person is null");
            return (Criteria) this;
        }

        public Criteria andOtherPersonIsNotNull() {
            addCriterion("other_person is not null");
            return (Criteria) this;
        }

        public Criteria andOtherPersonEqualTo(String value) {
            addCriterion("other_person =", value, "otherPerson");
            return (Criteria) this;
        }

        public Criteria andOtherPersonNotEqualTo(String value) {
            addCriterion("other_person <>", value, "otherPerson");
            return (Criteria) this;
        }

        public Criteria andOtherPersonGreaterThan(String value) {
            addCriterion("other_person >", value, "otherPerson");
            return (Criteria) this;
        }

        public Criteria andOtherPersonGreaterThanOrEqualTo(String value) {
            addCriterion("other_person >=", value, "otherPerson");
            return (Criteria) this;
        }

        public Criteria andOtherPersonLessThan(String value) {
            addCriterion("other_person <", value, "otherPerson");
            return (Criteria) this;
        }

        public Criteria andOtherPersonLessThanOrEqualTo(String value) {
            addCriterion("other_person <=", value, "otherPerson");
            return (Criteria) this;
        }

        public Criteria andOtherPersonLike(String value) {
            addCriterion("other_person like", value, "otherPerson");
            return (Criteria) this;
        }

        public Criteria andOtherPersonNotLike(String value) {
            addCriterion("other_person not like", value, "otherPerson");
            return (Criteria) this;
        }

        public Criteria andOtherPersonIn(List<String> values) {
            addCriterion("other_person in", values, "otherPerson");
            return (Criteria) this;
        }

        public Criteria andOtherPersonNotIn(List<String> values) {
            addCriterion("other_person not in", values, "otherPerson");
            return (Criteria) this;
        }

        public Criteria andOtherPersonBetween(String value1, String value2) {
            addCriterion("other_person between", value1, value2, "otherPerson");
            return (Criteria) this;
        }

        public Criteria andOtherPersonNotBetween(String value1, String value2) {
            addCriterion("other_person not between", value1, value2, "otherPerson");
            return (Criteria) this;
        }

        public Criteria andOtherScoreDateIsNull() {
            addCriterion("other_score_date is null");
            return (Criteria) this;
        }

        public Criteria andOtherScoreDateIsNotNull() {
            addCriterion("other_score_date is not null");
            return (Criteria) this;
        }

        public Criteria andOtherScoreDateEqualTo(Long value) {
            addCriterion("other_score_date =", value, "otherScoreDate");
            return (Criteria) this;
        }

        public Criteria andOtherScoreDateNotEqualTo(Long value) {
            addCriterion("other_score_date <>", value, "otherScoreDate");
            return (Criteria) this;
        }

        public Criteria andOtherScoreDateGreaterThan(Long value) {
            addCriterion("other_score_date >", value, "otherScoreDate");
            return (Criteria) this;
        }

        public Criteria andOtherScoreDateGreaterThanOrEqualTo(Long value) {
            addCriterion("other_score_date >=", value, "otherScoreDate");
            return (Criteria) this;
        }

        public Criteria andOtherScoreDateLessThan(Long value) {
            addCriterion("other_score_date <", value, "otherScoreDate");
            return (Criteria) this;
        }

        public Criteria andOtherScoreDateLessThanOrEqualTo(Long value) {
            addCriterion("other_score_date <=", value, "otherScoreDate");
            return (Criteria) this;
        }

        public Criteria andOtherScoreDateIn(List<Long> values) {
            addCriterion("other_score_date in", values, "otherScoreDate");
            return (Criteria) this;
        }

        public Criteria andOtherScoreDateNotIn(List<Long> values) {
            addCriterion("other_score_date not in", values, "otherScoreDate");
            return (Criteria) this;
        }

        public Criteria andOtherScoreDateBetween(Long value1, Long value2) {
            addCriterion("other_score_date between", value1, value2, "otherScoreDate");
            return (Criteria) this;
        }

        public Criteria andOtherScoreDateNotBetween(Long value1, Long value2) {
            addCriterion("other_score_date not between", value1, value2, "otherScoreDate");
            return (Criteria) this;
        }

        public Criteria andPriceScoreIsNull() {
            addCriterion("price_score is null");
            return (Criteria) this;
        }

        public Criteria andPriceScoreIsNotNull() {
            addCriterion("price_score is not null");
            return (Criteria) this;
        }

        public Criteria andPriceScoreEqualTo(Date value) {
            addCriterion("price_score =", value, "priceScore");
            return (Criteria) this;
        }

        public Criteria andPriceScoreNotEqualTo(Date value) {
            addCriterion("price_score <>", value, "priceScore");
            return (Criteria) this;
        }

        public Criteria andPriceScoreGreaterThan(Date value) {
            addCriterion("price_score >", value, "priceScore");
            return (Criteria) this;
        }

        public Criteria andPriceScoreGreaterThanOrEqualTo(Date value) {
            addCriterion("price_score >=", value, "priceScore");
            return (Criteria) this;
        }

        public Criteria andPriceScoreLessThan(Date value) {
            addCriterion("price_score <", value, "priceScore");
            return (Criteria) this;
        }

        public Criteria andPriceScoreLessThanOrEqualTo(Date value) {
            addCriterion("price_score <=", value, "priceScore");
            return (Criteria) this;
        }

        public Criteria andPriceScoreIn(List<Date> values) {
            addCriterion("price_score in", values, "priceScore");
            return (Criteria) this;
        }

        public Criteria andPriceScoreNotIn(List<Date> values) {
            addCriterion("price_score not in", values, "priceScore");
            return (Criteria) this;
        }

        public Criteria andPriceScoreBetween(Date value1, Date value2) {
            addCriterion("price_score between", value1, value2, "priceScore");
            return (Criteria) this;
        }

        public Criteria andPriceScoreNotBetween(Date value1, Date value2) {
            addCriterion("price_score not between", value1, value2, "priceScore");
            return (Criteria) this;
        }

        public Criteria andPricePersonIsNull() {
            addCriterion("price_person is null");
            return (Criteria) this;
        }

        public Criteria andPricePersonIsNotNull() {
            addCriterion("price_person is not null");
            return (Criteria) this;
        }

        public Criteria andPricePersonEqualTo(String value) {
            addCriterion("price_person =", value, "pricePerson");
            return (Criteria) this;
        }

        public Criteria andPricePersonNotEqualTo(String value) {
            addCriterion("price_person <>", value, "pricePerson");
            return (Criteria) this;
        }

        public Criteria andPricePersonGreaterThan(String value) {
            addCriterion("price_person >", value, "pricePerson");
            return (Criteria) this;
        }

        public Criteria andPricePersonGreaterThanOrEqualTo(String value) {
            addCriterion("price_person >=", value, "pricePerson");
            return (Criteria) this;
        }

        public Criteria andPricePersonLessThan(String value) {
            addCriterion("price_person <", value, "pricePerson");
            return (Criteria) this;
        }

        public Criteria andPricePersonLessThanOrEqualTo(String value) {
            addCriterion("price_person <=", value, "pricePerson");
            return (Criteria) this;
        }

        public Criteria andPricePersonLike(String value) {
            addCriterion("price_person like", value, "pricePerson");
            return (Criteria) this;
        }

        public Criteria andPricePersonNotLike(String value) {
            addCriterion("price_person not like", value, "pricePerson");
            return (Criteria) this;
        }

        public Criteria andPricePersonIn(List<String> values) {
            addCriterion("price_person in", values, "pricePerson");
            return (Criteria) this;
        }

        public Criteria andPricePersonNotIn(List<String> values) {
            addCriterion("price_person not in", values, "pricePerson");
            return (Criteria) this;
        }

        public Criteria andPricePersonBetween(String value1, String value2) {
            addCriterion("price_person between", value1, value2, "pricePerson");
            return (Criteria) this;
        }

        public Criteria andPricePersonNotBetween(String value1, String value2) {
            addCriterion("price_person not between", value1, value2, "pricePerson");
            return (Criteria) this;
        }

        public Criteria andPriceScoreDateIsNull() {
            addCriterion("price_score_date is null");
            return (Criteria) this;
        }

        public Criteria andPriceScoreDateIsNotNull() {
            addCriterion("price_score_date is not null");
            return (Criteria) this;
        }

        public Criteria andPriceScoreDateEqualTo(Date value) {
            addCriterion("price_score_date =", value, "priceScoreDate");
            return (Criteria) this;
        }

        public Criteria andPriceScoreDateNotEqualTo(Date value) {
            addCriterion("price_score_date <>", value, "priceScoreDate");
            return (Criteria) this;
        }

        public Criteria andPriceScoreDateGreaterThan(Date value) {
            addCriterion("price_score_date >", value, "priceScoreDate");
            return (Criteria) this;
        }

        public Criteria andPriceScoreDateGreaterThanOrEqualTo(Date value) {
            addCriterion("price_score_date >=", value, "priceScoreDate");
            return (Criteria) this;
        }

        public Criteria andPriceScoreDateLessThan(Date value) {
            addCriterion("price_score_date <", value, "priceScoreDate");
            return (Criteria) this;
        }

        public Criteria andPriceScoreDateLessThanOrEqualTo(Date value) {
            addCriterion("price_score_date <=", value, "priceScoreDate");
            return (Criteria) this;
        }

        public Criteria andPriceScoreDateIn(List<Date> values) {
            addCriterion("price_score_date in", values, "priceScoreDate");
            return (Criteria) this;
        }

        public Criteria andPriceScoreDateNotIn(List<Date> values) {
            addCriterion("price_score_date not in", values, "priceScoreDate");
            return (Criteria) this;
        }

        public Criteria andPriceScoreDateBetween(Date value1, Date value2) {
            addCriterion("price_score_date between", value1, value2, "priceScoreDate");
            return (Criteria) this;
        }

        public Criteria andPriceScoreDateNotBetween(Date value1, Date value2) {
            addCriterion("price_score_date not between", value1, value2, "priceScoreDate");
            return (Criteria) this;
        }

        public Criteria andTotalScoreIsNull() {
            addCriterion("total_score is null");
            return (Criteria) this;
        }

        public Criteria andTotalScoreIsNotNull() {
            addCriterion("total_score is not null");
            return (Criteria) this;
        }

        public Criteria andTotalScoreEqualTo(Integer value) {
            addCriterion("total_score =", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotEqualTo(Integer value) {
            addCriterion("total_score <>", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreGreaterThan(Integer value) {
            addCriterion("total_score >", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_score >=", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreLessThan(Integer value) {
            addCriterion("total_score <", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreLessThanOrEqualTo(Integer value) {
            addCriterion("total_score <=", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreIn(List<Integer> values) {
            addCriterion("total_score in", values, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotIn(List<Integer> values) {
            addCriterion("total_score not in", values, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreBetween(Integer value1, Integer value2) {
            addCriterion("total_score between", value1, value2, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("total_score not between", value1, value2, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalPersonIsNull() {
            addCriterion("total_person is null");
            return (Criteria) this;
        }

        public Criteria andTotalPersonIsNotNull() {
            addCriterion("total_person is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPersonEqualTo(String value) {
            addCriterion("total_person =", value, "totalPerson");
            return (Criteria) this;
        }

        public Criteria andTotalPersonNotEqualTo(String value) {
            addCriterion("total_person <>", value, "totalPerson");
            return (Criteria) this;
        }

        public Criteria andTotalPersonGreaterThan(String value) {
            addCriterion("total_person >", value, "totalPerson");
            return (Criteria) this;
        }

        public Criteria andTotalPersonGreaterThanOrEqualTo(String value) {
            addCriterion("total_person >=", value, "totalPerson");
            return (Criteria) this;
        }

        public Criteria andTotalPersonLessThan(String value) {
            addCriterion("total_person <", value, "totalPerson");
            return (Criteria) this;
        }

        public Criteria andTotalPersonLessThanOrEqualTo(String value) {
            addCriterion("total_person <=", value, "totalPerson");
            return (Criteria) this;
        }

        public Criteria andTotalPersonLike(String value) {
            addCriterion("total_person like", value, "totalPerson");
            return (Criteria) this;
        }

        public Criteria andTotalPersonNotLike(String value) {
            addCriterion("total_person not like", value, "totalPerson");
            return (Criteria) this;
        }

        public Criteria andTotalPersonIn(List<String> values) {
            addCriterion("total_person in", values, "totalPerson");
            return (Criteria) this;
        }

        public Criteria andTotalPersonNotIn(List<String> values) {
            addCriterion("total_person not in", values, "totalPerson");
            return (Criteria) this;
        }

        public Criteria andTotalPersonBetween(String value1, String value2) {
            addCriterion("total_person between", value1, value2, "totalPerson");
            return (Criteria) this;
        }

        public Criteria andTotalPersonNotBetween(String value1, String value2) {
            addCriterion("total_person not between", value1, value2, "totalPerson");
            return (Criteria) this;
        }

        public Criteria andTotalScoreDateIsNull() {
            addCriterion("total_score_date is null");
            return (Criteria) this;
        }

        public Criteria andTotalScoreDateIsNotNull() {
            addCriterion("total_score_date is not null");
            return (Criteria) this;
        }

        public Criteria andTotalScoreDateEqualTo(Date value) {
            addCriterion("total_score_date =", value, "totalScoreDate");
            return (Criteria) this;
        }

        public Criteria andTotalScoreDateNotEqualTo(Date value) {
            addCriterion("total_score_date <>", value, "totalScoreDate");
            return (Criteria) this;
        }

        public Criteria andTotalScoreDateGreaterThan(Date value) {
            addCriterion("total_score_date >", value, "totalScoreDate");
            return (Criteria) this;
        }

        public Criteria andTotalScoreDateGreaterThanOrEqualTo(Date value) {
            addCriterion("total_score_date >=", value, "totalScoreDate");
            return (Criteria) this;
        }

        public Criteria andTotalScoreDateLessThan(Date value) {
            addCriterion("total_score_date <", value, "totalScoreDate");
            return (Criteria) this;
        }

        public Criteria andTotalScoreDateLessThanOrEqualTo(Date value) {
            addCriterion("total_score_date <=", value, "totalScoreDate");
            return (Criteria) this;
        }

        public Criteria andTotalScoreDateIn(List<Date> values) {
            addCriterion("total_score_date in", values, "totalScoreDate");
            return (Criteria) this;
        }

        public Criteria andTotalScoreDateNotIn(List<Date> values) {
            addCriterion("total_score_date not in", values, "totalScoreDate");
            return (Criteria) this;
        }

        public Criteria andTotalScoreDateBetween(Date value1, Date value2) {
            addCriterion("total_score_date between", value1, value2, "totalScoreDate");
            return (Criteria) this;
        }

        public Criteria andTotalScoreDateNotBetween(Date value1, Date value2) {
            addCriterion("total_score_date not between", value1, value2, "totalScoreDate");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionsIsNull() {
            addCriterion("manager_opinions is null");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionsIsNotNull() {
            addCriterion("manager_opinions is not null");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionsEqualTo(String value) {
            addCriterion("manager_opinions =", value, "managerOpinions");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionsNotEqualTo(String value) {
            addCriterion("manager_opinions <>", value, "managerOpinions");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionsGreaterThan(String value) {
            addCriterion("manager_opinions >", value, "managerOpinions");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionsGreaterThanOrEqualTo(String value) {
            addCriterion("manager_opinions >=", value, "managerOpinions");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionsLessThan(String value) {
            addCriterion("manager_opinions <", value, "managerOpinions");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionsLessThanOrEqualTo(String value) {
            addCriterion("manager_opinions <=", value, "managerOpinions");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionsLike(String value) {
            addCriterion("manager_opinions like", value, "managerOpinions");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionsNotLike(String value) {
            addCriterion("manager_opinions not like", value, "managerOpinions");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionsIn(List<String> values) {
            addCriterion("manager_opinions in", values, "managerOpinions");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionsNotIn(List<String> values) {
            addCriterion("manager_opinions not in", values, "managerOpinions");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionsBetween(String value1, String value2) {
            addCriterion("manager_opinions between", value1, value2, "managerOpinions");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionsNotBetween(String value1, String value2) {
            addCriterion("manager_opinions not between", value1, value2, "managerOpinions");
            return (Criteria) this;
        }

        public Criteria andManagerPersonIsNull() {
            addCriterion("manager_person is null");
            return (Criteria) this;
        }

        public Criteria andManagerPersonIsNotNull() {
            addCriterion("manager_person is not null");
            return (Criteria) this;
        }

        public Criteria andManagerPersonEqualTo(String value) {
            addCriterion("manager_person =", value, "managerPerson");
            return (Criteria) this;
        }

        public Criteria andManagerPersonNotEqualTo(String value) {
            addCriterion("manager_person <>", value, "managerPerson");
            return (Criteria) this;
        }

        public Criteria andManagerPersonGreaterThan(String value) {
            addCriterion("manager_person >", value, "managerPerson");
            return (Criteria) this;
        }

        public Criteria andManagerPersonGreaterThanOrEqualTo(String value) {
            addCriterion("manager_person >=", value, "managerPerson");
            return (Criteria) this;
        }

        public Criteria andManagerPersonLessThan(String value) {
            addCriterion("manager_person <", value, "managerPerson");
            return (Criteria) this;
        }

        public Criteria andManagerPersonLessThanOrEqualTo(String value) {
            addCriterion("manager_person <=", value, "managerPerson");
            return (Criteria) this;
        }

        public Criteria andManagerPersonLike(String value) {
            addCriterion("manager_person like", value, "managerPerson");
            return (Criteria) this;
        }

        public Criteria andManagerPersonNotLike(String value) {
            addCriterion("manager_person not like", value, "managerPerson");
            return (Criteria) this;
        }

        public Criteria andManagerPersonIn(List<String> values) {
            addCriterion("manager_person in", values, "managerPerson");
            return (Criteria) this;
        }

        public Criteria andManagerPersonNotIn(List<String> values) {
            addCriterion("manager_person not in", values, "managerPerson");
            return (Criteria) this;
        }

        public Criteria andManagerPersonBetween(String value1, String value2) {
            addCriterion("manager_person between", value1, value2, "managerPerson");
            return (Criteria) this;
        }

        public Criteria andManagerPersonNotBetween(String value1, String value2) {
            addCriterion("manager_person not between", value1, value2, "managerPerson");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionsDateIsNull() {
            addCriterion("manager_opinions_date is null");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionsDateIsNotNull() {
            addCriterion("manager_opinions_date is not null");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionsDateEqualTo(Date value) {
            addCriterion("manager_opinions_date =", value, "managerOpinionsDate");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionsDateNotEqualTo(Date value) {
            addCriterion("manager_opinions_date <>", value, "managerOpinionsDate");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionsDateGreaterThan(Date value) {
            addCriterion("manager_opinions_date >", value, "managerOpinionsDate");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionsDateGreaterThanOrEqualTo(Date value) {
            addCriterion("manager_opinions_date >=", value, "managerOpinionsDate");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionsDateLessThan(Date value) {
            addCriterion("manager_opinions_date <", value, "managerOpinionsDate");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionsDateLessThanOrEqualTo(Date value) {
            addCriterion("manager_opinions_date <=", value, "managerOpinionsDate");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionsDateIn(List<Date> values) {
            addCriterion("manager_opinions_date in", values, "managerOpinionsDate");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionsDateNotIn(List<Date> values) {
            addCriterion("manager_opinions_date not in", values, "managerOpinionsDate");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionsDateBetween(Date value1, Date value2) {
            addCriterion("manager_opinions_date between", value1, value2, "managerOpinionsDate");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionsDateNotBetween(Date value1, Date value2) {
            addCriterion("manager_opinions_date not between", value1, value2, "managerOpinionsDate");
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

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Byte value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Byte value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Byte value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Byte value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Byte value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Byte> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Byte> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Byte value1, Byte value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Byte value1, Byte value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andCreateDataIsNull() {
            addCriterion("create_data is null");
            return (Criteria) this;
        }

        public Criteria andCreateDataIsNotNull() {
            addCriterion("create_data is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDataEqualTo(Date value) {
            addCriterion("create_data =", value, "createData");
            return (Criteria) this;
        }

        public Criteria andCreateDataNotEqualTo(Date value) {
            addCriterion("create_data <>", value, "createData");
            return (Criteria) this;
        }

        public Criteria andCreateDataGreaterThan(Date value) {
            addCriterion("create_data >", value, "createData");
            return (Criteria) this;
        }

        public Criteria andCreateDataGreaterThanOrEqualTo(Date value) {
            addCriterion("create_data >=", value, "createData");
            return (Criteria) this;
        }

        public Criteria andCreateDataLessThan(Date value) {
            addCriterion("create_data <", value, "createData");
            return (Criteria) this;
        }

        public Criteria andCreateDataLessThanOrEqualTo(Date value) {
            addCriterion("create_data <=", value, "createData");
            return (Criteria) this;
        }

        public Criteria andCreateDataIn(List<Date> values) {
            addCriterion("create_data in", values, "createData");
            return (Criteria) this;
        }

        public Criteria andCreateDataNotIn(List<Date> values) {
            addCriterion("create_data not in", values, "createData");
            return (Criteria) this;
        }

        public Criteria andCreateDataBetween(Date value1, Date value2) {
            addCriterion("create_data between", value1, value2, "createData");
            return (Criteria) this;
        }

        public Criteria andCreateDataNotBetween(Date value1, Date value2) {
            addCriterion("create_data not between", value1, value2, "createData");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
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