package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BizBillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BizBillExample() {
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

        public Criteria andXhIsNull() {
            addCriterion("xh is null");
            return (Criteria) this;
        }

        public Criteria andXhIsNotNull() {
            addCriterion("xh is not null");
            return (Criteria) this;
        }

        public Criteria andXhEqualTo(String value) {
            addCriterion("xh =", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotEqualTo(String value) {
            addCriterion("xh <>", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhGreaterThan(String value) {
            addCriterion("xh >", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhGreaterThanOrEqualTo(String value) {
            addCriterion("xh >=", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhLessThan(String value) {
            addCriterion("xh <", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhLessThanOrEqualTo(String value) {
            addCriterion("xh <=", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhLike(String value) {
            addCriterion("xh like", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotLike(String value) {
            addCriterion("xh not like", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhIn(List<String> values) {
            addCriterion("xh in", values, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotIn(List<String> values) {
            addCriterion("xh not in", values, "xh");
            return (Criteria) this;
        }

        public Criteria andXhBetween(String value1, String value2) {
            addCriterion("xh between", value1, value2, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotBetween(String value1, String value2) {
            addCriterion("xh not between", value1, value2, "xh");
            return (Criteria) this;
        }

        public Criteria andDIsNull() {
            addCriterion("d is null");
            return (Criteria) this;
        }

        public Criteria andDIsNotNull() {
            addCriterion("d is not null");
            return (Criteria) this;
        }

        public Criteria andDEqualTo(Date value) {
            addCriterion("d =", value, "d");
            return (Criteria) this;
        }

        public Criteria andDNotEqualTo(Date value) {
            addCriterion("d <>", value, "d");
            return (Criteria) this;
        }

        public Criteria andDGreaterThan(Date value) {
            addCriterion("d >", value, "d");
            return (Criteria) this;
        }

        public Criteria andDGreaterThanOrEqualTo(Date value) {
            addCriterion("d >=", value, "d");
            return (Criteria) this;
        }

        public Criteria andDLessThan(Date value) {
            addCriterion("d <", value, "d");
            return (Criteria) this;
        }

        public Criteria andDLessThanOrEqualTo(Date value) {
            addCriterion("d <=", value, "d");
            return (Criteria) this;
        }

        public Criteria andDIn(List<Date> values) {
            addCriterion("d in", values, "d");
            return (Criteria) this;
        }

        public Criteria andDNotIn(List<Date> values) {
            addCriterion("d not in", values, "d");
            return (Criteria) this;
        }

        public Criteria andDBetween(Date value1, Date value2) {
            addCriterion("d between", value1, value2, "d");
            return (Criteria) this;
        }

        public Criteria andDNotBetween(Date value1, Date value2) {
            addCriterion("d not between", value1, value2, "d");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberIsNull() {
            addCriterion("certificate_number is null");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberIsNotNull() {
            addCriterion("certificate_number is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberEqualTo(String value) {
            addCriterion("certificate_number =", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberNotEqualTo(String value) {
            addCriterion("certificate_number <>", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberGreaterThan(String value) {
            addCriterion("certificate_number >", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberGreaterThanOrEqualTo(String value) {
            addCriterion("certificate_number >=", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberLessThan(String value) {
            addCriterion("certificate_number <", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberLessThanOrEqualTo(String value) {
            addCriterion("certificate_number <=", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberLike(String value) {
            addCriterion("certificate_number like", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberNotLike(String value) {
            addCriterion("certificate_number not like", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberIn(List<String> values) {
            addCriterion("certificate_number in", values, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberNotIn(List<String> values) {
            addCriterion("certificate_number not in", values, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberBetween(String value1, String value2) {
            addCriterion("certificate_number between", value1, value2, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberNotBetween(String value1, String value2) {
            addCriterion("certificate_number not between", value1, value2, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeIsNull() {
            addCriterion("settlement_type is null");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeIsNotNull() {
            addCriterion("settlement_type is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeEqualTo(String value) {
            addCriterion("settlement_type =", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeNotEqualTo(String value) {
            addCriterion("settlement_type <>", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeGreaterThan(String value) {
            addCriterion("settlement_type >", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeGreaterThanOrEqualTo(String value) {
            addCriterion("settlement_type >=", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeLessThan(String value) {
            addCriterion("settlement_type <", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeLessThanOrEqualTo(String value) {
            addCriterion("settlement_type <=", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeLike(String value) {
            addCriterion("settlement_type like", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeNotLike(String value) {
            addCriterion("settlement_type not like", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeIn(List<String> values) {
            addCriterion("settlement_type in", values, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeNotIn(List<String> values) {
            addCriterion("settlement_type not in", values, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeBetween(String value1, String value2) {
            addCriterion("settlement_type between", value1, value2, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeNotBetween(String value1, String value2) {
            addCriterion("settlement_type not between", value1, value2, "settlementType");
            return (Criteria) this;
        }

        public Criteria andClearingBanksIsNull() {
            addCriterion("clearing_banks is null");
            return (Criteria) this;
        }

        public Criteria andClearingBanksIsNotNull() {
            addCriterion("clearing_banks is not null");
            return (Criteria) this;
        }

        public Criteria andClearingBanksEqualTo(String value) {
            addCriterion("clearing_banks =", value, "clearingBanks");
            return (Criteria) this;
        }

        public Criteria andClearingBanksNotEqualTo(String value) {
            addCriterion("clearing_banks <>", value, "clearingBanks");
            return (Criteria) this;
        }

        public Criteria andClearingBanksGreaterThan(String value) {
            addCriterion("clearing_banks >", value, "clearingBanks");
            return (Criteria) this;
        }

        public Criteria andClearingBanksGreaterThanOrEqualTo(String value) {
            addCriterion("clearing_banks >=", value, "clearingBanks");
            return (Criteria) this;
        }

        public Criteria andClearingBanksLessThan(String value) {
            addCriterion("clearing_banks <", value, "clearingBanks");
            return (Criteria) this;
        }

        public Criteria andClearingBanksLessThanOrEqualTo(String value) {
            addCriterion("clearing_banks <=", value, "clearingBanks");
            return (Criteria) this;
        }

        public Criteria andClearingBanksLike(String value) {
            addCriterion("clearing_banks like", value, "clearingBanks");
            return (Criteria) this;
        }

        public Criteria andClearingBanksNotLike(String value) {
            addCriterion("clearing_banks not like", value, "clearingBanks");
            return (Criteria) this;
        }

        public Criteria andClearingBanksIn(List<String> values) {
            addCriterion("clearing_banks in", values, "clearingBanks");
            return (Criteria) this;
        }

        public Criteria andClearingBanksNotIn(List<String> values) {
            addCriterion("clearing_banks not in", values, "clearingBanks");
            return (Criteria) this;
        }

        public Criteria andClearingBanksBetween(String value1, String value2) {
            addCriterion("clearing_banks between", value1, value2, "clearingBanks");
            return (Criteria) this;
        }

        public Criteria andClearingBanksNotBetween(String value1, String value2) {
            addCriterion("clearing_banks not between", value1, value2, "clearingBanks");
            return (Criteria) this;
        }

        public Criteria andPreMonthMoneyIsNull() {
            addCriterion("pre_month_money is null");
            return (Criteria) this;
        }

        public Criteria andPreMonthMoneyIsNotNull() {
            addCriterion("pre_month_money is not null");
            return (Criteria) this;
        }

        public Criteria andPreMonthMoneyEqualTo(BigDecimal value) {
            addCriterion("pre_month_money =", value, "preMonthMoney");
            return (Criteria) this;
        }

        public Criteria andPreMonthMoneyNotEqualTo(BigDecimal value) {
            addCriterion("pre_month_money <>", value, "preMonthMoney");
            return (Criteria) this;
        }

        public Criteria andPreMonthMoneyGreaterThan(BigDecimal value) {
            addCriterion("pre_month_money >", value, "preMonthMoney");
            return (Criteria) this;
        }

        public Criteria andPreMonthMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pre_month_money >=", value, "preMonthMoney");
            return (Criteria) this;
        }

        public Criteria andPreMonthMoneyLessThan(BigDecimal value) {
            addCriterion("pre_month_money <", value, "preMonthMoney");
            return (Criteria) this;
        }

        public Criteria andPreMonthMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pre_month_money <=", value, "preMonthMoney");
            return (Criteria) this;
        }

        public Criteria andPreMonthMoneyIn(List<BigDecimal> values) {
            addCriterion("pre_month_money in", values, "preMonthMoney");
            return (Criteria) this;
        }

        public Criteria andPreMonthMoneyNotIn(List<BigDecimal> values) {
            addCriterion("pre_month_money not in", values, "preMonthMoney");
            return (Criteria) this;
        }

        public Criteria andPreMonthMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pre_month_money between", value1, value2, "preMonthMoney");
            return (Criteria) this;
        }

        public Criteria andPreMonthMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pre_month_money not between", value1, value2, "preMonthMoney");
            return (Criteria) this;
        }

        public Criteria andCollectionMoneyIsNull() {
            addCriterion("collection_money is null");
            return (Criteria) this;
        }

        public Criteria andCollectionMoneyIsNotNull() {
            addCriterion("collection_money is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionMoneyEqualTo(BigDecimal value) {
            addCriterion("collection_money =", value, "collectionMoney");
            return (Criteria) this;
        }

        public Criteria andCollectionMoneyNotEqualTo(BigDecimal value) {
            addCriterion("collection_money <>", value, "collectionMoney");
            return (Criteria) this;
        }

        public Criteria andCollectionMoneyGreaterThan(BigDecimal value) {
            addCriterion("collection_money >", value, "collectionMoney");
            return (Criteria) this;
        }

        public Criteria andCollectionMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("collection_money >=", value, "collectionMoney");
            return (Criteria) this;
        }

        public Criteria andCollectionMoneyLessThan(BigDecimal value) {
            addCriterion("collection_money <", value, "collectionMoney");
            return (Criteria) this;
        }

        public Criteria andCollectionMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("collection_money <=", value, "collectionMoney");
            return (Criteria) this;
        }

        public Criteria andCollectionMoneyIn(List<BigDecimal> values) {
            addCriterion("collection_money in", values, "collectionMoney");
            return (Criteria) this;
        }

        public Criteria andCollectionMoneyNotIn(List<BigDecimal> values) {
            addCriterion("collection_money not in", values, "collectionMoney");
            return (Criteria) this;
        }

        public Criteria andCollectionMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("collection_money between", value1, value2, "collectionMoney");
            return (Criteria) this;
        }

        public Criteria andCollectionMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("collection_money not between", value1, value2, "collectionMoney");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeIsNull() {
            addCriterion("collection_type is null");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeIsNotNull() {
            addCriterion("collection_type is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeEqualTo(String value) {
            addCriterion("collection_type =", value, "collectionType");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeNotEqualTo(String value) {
            addCriterion("collection_type <>", value, "collectionType");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeGreaterThan(String value) {
            addCriterion("collection_type >", value, "collectionType");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("collection_type >=", value, "collectionType");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeLessThan(String value) {
            addCriterion("collection_type <", value, "collectionType");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeLessThanOrEqualTo(String value) {
            addCriterion("collection_type <=", value, "collectionType");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeLike(String value) {
            addCriterion("collection_type like", value, "collectionType");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeNotLike(String value) {
            addCriterion("collection_type not like", value, "collectionType");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeIn(List<String> values) {
            addCriterion("collection_type in", values, "collectionType");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeNotIn(List<String> values) {
            addCriterion("collection_type not in", values, "collectionType");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeBetween(String value1, String value2) {
            addCriterion("collection_type between", value1, value2, "collectionType");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeNotBetween(String value1, String value2) {
            addCriterion("collection_type not between", value1, value2, "collectionType");
            return (Criteria) this;
        }

        public Criteria andPaymentIsNull() {
            addCriterion("payment is null");
            return (Criteria) this;
        }

        public Criteria andPaymentIsNotNull() {
            addCriterion("payment is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentEqualTo(BigDecimal value) {
            addCriterion("payment =", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotEqualTo(BigDecimal value) {
            addCriterion("payment <>", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentGreaterThan(BigDecimal value) {
            addCriterion("payment >", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("payment >=", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentLessThan(BigDecimal value) {
            addCriterion("payment <", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("payment <=", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentIn(List<BigDecimal> values) {
            addCriterion("payment in", values, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotIn(List<BigDecimal> values) {
            addCriterion("payment not in", values, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payment between", value1, value2, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payment not between", value1, value2, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIsNull() {
            addCriterion("payment_type is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIsNotNull() {
            addCriterion("payment_type is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeEqualTo(String value) {
            addCriterion("payment_type =", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotEqualTo(String value) {
            addCriterion("payment_type <>", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThan(String value) {
            addCriterion("payment_type >", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("payment_type >=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThan(String value) {
            addCriterion("payment_type <", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThanOrEqualTo(String value) {
            addCriterion("payment_type <=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLike(String value) {
            addCriterion("payment_type like", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotLike(String value) {
            addCriterion("payment_type not like", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIn(List<String> values) {
            addCriterion("payment_type in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotIn(List<String> values) {
            addCriterion("payment_type not in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeBetween(String value1, String value2) {
            addCriterion("payment_type between", value1, value2, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotBetween(String value1, String value2) {
            addCriterion("payment_type not between", value1, value2, "paymentType");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(BigDecimal value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(BigDecimal value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(BigDecimal value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(BigDecimal value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<BigDecimal> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<BigDecimal> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance not between", value1, value2, "balance");
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

        public Criteria andContractUserIsNull() {
            addCriterion("contract_user is null");
            return (Criteria) this;
        }

        public Criteria andContractUserIsNotNull() {
            addCriterion("contract_user is not null");
            return (Criteria) this;
        }

        public Criteria andContractUserEqualTo(Integer value) {
            addCriterion("contract_user =", value, "contractUser");
            return (Criteria) this;
        }

        public Criteria andContractUserNotEqualTo(Integer value) {
            addCriterion("contract_user <>", value, "contractUser");
            return (Criteria) this;
        }

        public Criteria andContractUserGreaterThan(Integer value) {
            addCriterion("contract_user >", value, "contractUser");
            return (Criteria) this;
        }

        public Criteria andContractUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("contract_user >=", value, "contractUser");
            return (Criteria) this;
        }

        public Criteria andContractUserLessThan(Integer value) {
            addCriterion("contract_user <", value, "contractUser");
            return (Criteria) this;
        }

        public Criteria andContractUserLessThanOrEqualTo(Integer value) {
            addCriterion("contract_user <=", value, "contractUser");
            return (Criteria) this;
        }

        public Criteria andContractUserIn(List<Integer> values) {
            addCriterion("contract_user in", values, "contractUser");
            return (Criteria) this;
        }

        public Criteria andContractUserNotIn(List<Integer> values) {
            addCriterion("contract_user not in", values, "contractUser");
            return (Criteria) this;
        }

        public Criteria andContractUserBetween(Integer value1, Integer value2) {
            addCriterion("contract_user between", value1, value2, "contractUser");
            return (Criteria) this;
        }

        public Criteria andContractUserNotBetween(Integer value1, Integer value2) {
            addCriterion("contract_user not between", value1, value2, "contractUser");
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
