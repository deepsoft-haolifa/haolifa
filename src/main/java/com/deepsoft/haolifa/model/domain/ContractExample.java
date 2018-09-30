package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContractExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContractExample() {
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

        public Criteria andContractNameIsNull() {
            addCriterion("contract_name is null");
            return (Criteria) this;
        }

        public Criteria andContractNameIsNotNull() {
            addCriterion("contract_name is not null");
            return (Criteria) this;
        }

        public Criteria andContractNameEqualTo(String value) {
            addCriterion("contract_name =", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotEqualTo(String value) {
            addCriterion("contract_name <>", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameGreaterThan(String value) {
            addCriterion("contract_name >", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameGreaterThanOrEqualTo(String value) {
            addCriterion("contract_name >=", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLessThan(String value) {
            addCriterion("contract_name <", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLessThanOrEqualTo(String value) {
            addCriterion("contract_name <=", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLike(String value) {
            addCriterion("contract_name like", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotLike(String value) {
            addCriterion("contract_name not like", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameIn(List<String> values) {
            addCriterion("contract_name in", values, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotIn(List<String> values) {
            addCriterion("contract_name not in", values, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameBetween(String value1, String value2) {
            addCriterion("contract_name between", value1, value2, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotBetween(String value1, String value2) {
            addCriterion("contract_name not between", value1, value2, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractTypeIsNull() {
            addCriterion("contract_type is null");
            return (Criteria) this;
        }

        public Criteria andContractTypeIsNotNull() {
            addCriterion("contract_type is not null");
            return (Criteria) this;
        }

        public Criteria andContractTypeEqualTo(Byte value) {
            addCriterion("contract_type =", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotEqualTo(Byte value) {
            addCriterion("contract_type <>", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeGreaterThan(Byte value) {
            addCriterion("contract_type >", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("contract_type >=", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeLessThan(Byte value) {
            addCriterion("contract_type <", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeLessThanOrEqualTo(Byte value) {
            addCriterion("contract_type <=", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeIn(List<Byte> values) {
            addCriterion("contract_type in", values, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotIn(List<Byte> values) {
            addCriterion("contract_type not in", values, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeBetween(Byte value1, Byte value2) {
            addCriterion("contract_type between", value1, value2, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("contract_type not between", value1, value2, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractDurationIsNull() {
            addCriterion("contract_duration is null");
            return (Criteria) this;
        }

        public Criteria andContractDurationIsNotNull() {
            addCriterion("contract_duration is not null");
            return (Criteria) this;
        }

        public Criteria andContractDurationEqualTo(String value) {
            addCriterion("contract_duration =", value, "contractDuration");
            return (Criteria) this;
        }

        public Criteria andContractDurationNotEqualTo(String value) {
            addCriterion("contract_duration <>", value, "contractDuration");
            return (Criteria) this;
        }

        public Criteria andContractDurationGreaterThan(String value) {
            addCriterion("contract_duration >", value, "contractDuration");
            return (Criteria) this;
        }

        public Criteria andContractDurationGreaterThanOrEqualTo(String value) {
            addCriterion("contract_duration >=", value, "contractDuration");
            return (Criteria) this;
        }

        public Criteria andContractDurationLessThan(String value) {
            addCriterion("contract_duration <", value, "contractDuration");
            return (Criteria) this;
        }

        public Criteria andContractDurationLessThanOrEqualTo(String value) {
            addCriterion("contract_duration <=", value, "contractDuration");
            return (Criteria) this;
        }

        public Criteria andContractDurationLike(String value) {
            addCriterion("contract_duration like", value, "contractDuration");
            return (Criteria) this;
        }

        public Criteria andContractDurationNotLike(String value) {
            addCriterion("contract_duration not like", value, "contractDuration");
            return (Criteria) this;
        }

        public Criteria andContractDurationIn(List<String> values) {
            addCriterion("contract_duration in", values, "contractDuration");
            return (Criteria) this;
        }

        public Criteria andContractDurationNotIn(List<String> values) {
            addCriterion("contract_duration not in", values, "contractDuration");
            return (Criteria) this;
        }

        public Criteria andContractDurationBetween(String value1, String value2) {
            addCriterion("contract_duration between", value1, value2, "contractDuration");
            return (Criteria) this;
        }

        public Criteria andContractDurationNotBetween(String value1, String value2) {
            addCriterion("contract_duration not between", value1, value2, "contractDuration");
            return (Criteria) this;
        }

        public Criteria andContractSubjectIsNull() {
            addCriterion("contract_subject is null");
            return (Criteria) this;
        }

        public Criteria andContractSubjectIsNotNull() {
            addCriterion("contract_subject is not null");
            return (Criteria) this;
        }

        public Criteria andContractSubjectEqualTo(String value) {
            addCriterion("contract_subject =", value, "contractSubject");
            return (Criteria) this;
        }

        public Criteria andContractSubjectNotEqualTo(String value) {
            addCriterion("contract_subject <>", value, "contractSubject");
            return (Criteria) this;
        }

        public Criteria andContractSubjectGreaterThan(String value) {
            addCriterion("contract_subject >", value, "contractSubject");
            return (Criteria) this;
        }

        public Criteria andContractSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("contract_subject >=", value, "contractSubject");
            return (Criteria) this;
        }

        public Criteria andContractSubjectLessThan(String value) {
            addCriterion("contract_subject <", value, "contractSubject");
            return (Criteria) this;
        }

        public Criteria andContractSubjectLessThanOrEqualTo(String value) {
            addCriterion("contract_subject <=", value, "contractSubject");
            return (Criteria) this;
        }

        public Criteria andContractSubjectLike(String value) {
            addCriterion("contract_subject like", value, "contractSubject");
            return (Criteria) this;
        }

        public Criteria andContractSubjectNotLike(String value) {
            addCriterion("contract_subject not like", value, "contractSubject");
            return (Criteria) this;
        }

        public Criteria andContractSubjectIn(List<String> values) {
            addCriterion("contract_subject in", values, "contractSubject");
            return (Criteria) this;
        }

        public Criteria andContractSubjectNotIn(List<String> values) {
            addCriterion("contract_subject not in", values, "contractSubject");
            return (Criteria) this;
        }

        public Criteria andContractSubjectBetween(String value1, String value2) {
            addCriterion("contract_subject between", value1, value2, "contractSubject");
            return (Criteria) this;
        }

        public Criteria andContractSubjectNotBetween(String value1, String value2) {
            addCriterion("contract_subject not between", value1, value2, "contractSubject");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(BigDecimal value) {
            addCriterion("total_amount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(BigDecimal value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(BigDecimal value) {
            addCriterion("total_amount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(BigDecimal value) {
            addCriterion("total_amount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<BigDecimal> values) {
            addCriterion("total_amount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<BigDecimal> values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andContractPartyIsNull() {
            addCriterion("contract_party is null");
            return (Criteria) this;
        }

        public Criteria andContractPartyIsNotNull() {
            addCriterion("contract_party is not null");
            return (Criteria) this;
        }

        public Criteria andContractPartyEqualTo(String value) {
            addCriterion("contract_party =", value, "contractParty");
            return (Criteria) this;
        }

        public Criteria andContractPartyNotEqualTo(String value) {
            addCriterion("contract_party <>", value, "contractParty");
            return (Criteria) this;
        }

        public Criteria andContractPartyGreaterThan(String value) {
            addCriterion("contract_party >", value, "contractParty");
            return (Criteria) this;
        }

        public Criteria andContractPartyGreaterThanOrEqualTo(String value) {
            addCriterion("contract_party >=", value, "contractParty");
            return (Criteria) this;
        }

        public Criteria andContractPartyLessThan(String value) {
            addCriterion("contract_party <", value, "contractParty");
            return (Criteria) this;
        }

        public Criteria andContractPartyLessThanOrEqualTo(String value) {
            addCriterion("contract_party <=", value, "contractParty");
            return (Criteria) this;
        }

        public Criteria andContractPartyLike(String value) {
            addCriterion("contract_party like", value, "contractParty");
            return (Criteria) this;
        }

        public Criteria andContractPartyNotLike(String value) {
            addCriterion("contract_party not like", value, "contractParty");
            return (Criteria) this;
        }

        public Criteria andContractPartyIn(List<String> values) {
            addCriterion("contract_party in", values, "contractParty");
            return (Criteria) this;
        }

        public Criteria andContractPartyNotIn(List<String> values) {
            addCriterion("contract_party not in", values, "contractParty");
            return (Criteria) this;
        }

        public Criteria andContractPartyBetween(String value1, String value2) {
            addCriterion("contract_party between", value1, value2, "contractParty");
            return (Criteria) this;
        }

        public Criteria andContractPartyNotBetween(String value1, String value2) {
            addCriterion("contract_party not between", value1, value2, "contractParty");
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

        public Criteria andLinkmanIsNull() {
            addCriterion("linkman is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNotNull() {
            addCriterion("linkman is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanEqualTo(String value) {
            addCriterion("linkman =", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotEqualTo(String value) {
            addCriterion("linkman <>", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThan(String value) {
            addCriterion("linkman >", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThanOrEqualTo(String value) {
            addCriterion("linkman >=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThan(String value) {
            addCriterion("linkman <", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThanOrEqualTo(String value) {
            addCriterion("linkman <=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLike(String value) {
            addCriterion("linkman like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotLike(String value) {
            addCriterion("linkman not like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanIn(List<String> values) {
            addCriterion("linkman in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotIn(List<String> values) {
            addCriterion("linkman not in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanBetween(String value1, String value2) {
            addCriterion("linkman between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotBetween(String value1, String value2) {
            addCriterion("linkman not between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneIsNull() {
            addCriterion("linkman_phone is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneIsNotNull() {
            addCriterion("linkman_phone is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneEqualTo(String value) {
            addCriterion("linkman_phone =", value, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneNotEqualTo(String value) {
            addCriterion("linkman_phone <>", value, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneGreaterThan(String value) {
            addCriterion("linkman_phone >", value, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("linkman_phone >=", value, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneLessThan(String value) {
            addCriterion("linkman_phone <", value, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneLessThanOrEqualTo(String value) {
            addCriterion("linkman_phone <=", value, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneLike(String value) {
            addCriterion("linkman_phone like", value, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneNotLike(String value) {
            addCriterion("linkman_phone not like", value, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneIn(List<String> values) {
            addCriterion("linkman_phone in", values, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneNotIn(List<String> values) {
            addCriterion("linkman_phone not in", values, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneBetween(String value1, String value2) {
            addCriterion("linkman_phone between", value1, value2, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneNotBetween(String value1, String value2) {
            addCriterion("linkman_phone not between", value1, value2, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLeaderIsNull() {
            addCriterion("leader is null");
            return (Criteria) this;
        }

        public Criteria andLeaderIsNotNull() {
            addCriterion("leader is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderEqualTo(String value) {
            addCriterion("leader =", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotEqualTo(String value) {
            addCriterion("leader <>", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderGreaterThan(String value) {
            addCriterion("leader >", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("leader >=", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLessThan(String value) {
            addCriterion("leader <", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLessThanOrEqualTo(String value) {
            addCriterion("leader <=", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLike(String value) {
            addCriterion("leader like", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotLike(String value) {
            addCriterion("leader not like", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderIn(List<String> values) {
            addCriterion("leader in", values, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotIn(List<String> values) {
            addCriterion("leader not in", values, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderBetween(String value1, String value2) {
            addCriterion("leader between", value1, value2, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotBetween(String value1, String value2) {
            addCriterion("leader not between", value1, value2, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneIsNull() {
            addCriterion("leader_phone is null");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneIsNotNull() {
            addCriterion("leader_phone is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneEqualTo(String value) {
            addCriterion("leader_phone =", value, "leaderPhone");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneNotEqualTo(String value) {
            addCriterion("leader_phone <>", value, "leaderPhone");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneGreaterThan(String value) {
            addCriterion("leader_phone >", value, "leaderPhone");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("leader_phone >=", value, "leaderPhone");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneLessThan(String value) {
            addCriterion("leader_phone <", value, "leaderPhone");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneLessThanOrEqualTo(String value) {
            addCriterion("leader_phone <=", value, "leaderPhone");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneLike(String value) {
            addCriterion("leader_phone like", value, "leaderPhone");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneNotLike(String value) {
            addCriterion("leader_phone not like", value, "leaderPhone");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneIn(List<String> values) {
            addCriterion("leader_phone in", values, "leaderPhone");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneNotIn(List<String> values) {
            addCriterion("leader_phone not in", values, "leaderPhone");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneBetween(String value1, String value2) {
            addCriterion("leader_phone between", value1, value2, "leaderPhone");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneNotBetween(String value1, String value2) {
            addCriterion("leader_phone not between", value1, value2, "leaderPhone");
            return (Criteria) this;
        }

        public Criteria andPaymentCycleIsNull() {
            addCriterion("payment_cycle is null");
            return (Criteria) this;
        }

        public Criteria andPaymentCycleIsNotNull() {
            addCriterion("payment_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentCycleEqualTo(Byte value) {
            addCriterion("payment_cycle =", value, "paymentCycle");
            return (Criteria) this;
        }

        public Criteria andPaymentCycleNotEqualTo(Byte value) {
            addCriterion("payment_cycle <>", value, "paymentCycle");
            return (Criteria) this;
        }

        public Criteria andPaymentCycleGreaterThan(Byte value) {
            addCriterion("payment_cycle >", value, "paymentCycle");
            return (Criteria) this;
        }

        public Criteria andPaymentCycleGreaterThanOrEqualTo(Byte value) {
            addCriterion("payment_cycle >=", value, "paymentCycle");
            return (Criteria) this;
        }

        public Criteria andPaymentCycleLessThan(Byte value) {
            addCriterion("payment_cycle <", value, "paymentCycle");
            return (Criteria) this;
        }

        public Criteria andPaymentCycleLessThanOrEqualTo(Byte value) {
            addCriterion("payment_cycle <=", value, "paymentCycle");
            return (Criteria) this;
        }

        public Criteria andPaymentCycleIn(List<Byte> values) {
            addCriterion("payment_cycle in", values, "paymentCycle");
            return (Criteria) this;
        }

        public Criteria andPaymentCycleNotIn(List<Byte> values) {
            addCriterion("payment_cycle not in", values, "paymentCycle");
            return (Criteria) this;
        }

        public Criteria andPaymentCycleBetween(Byte value1, Byte value2) {
            addCriterion("payment_cycle between", value1, value2, "paymentCycle");
            return (Criteria) this;
        }

        public Criteria andPaymentCycleNotBetween(Byte value1, Byte value2) {
            addCriterion("payment_cycle not between", value1, value2, "paymentCycle");
            return (Criteria) this;
        }

        public Criteria andPaymentModeIsNull() {
            addCriterion("payment_mode is null");
            return (Criteria) this;
        }

        public Criteria andPaymentModeIsNotNull() {
            addCriterion("payment_mode is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentModeEqualTo(Byte value) {
            addCriterion("payment_mode =", value, "paymentMode");
            return (Criteria) this;
        }

        public Criteria andPaymentModeNotEqualTo(Byte value) {
            addCriterion("payment_mode <>", value, "paymentMode");
            return (Criteria) this;
        }

        public Criteria andPaymentModeGreaterThan(Byte value) {
            addCriterion("payment_mode >", value, "paymentMode");
            return (Criteria) this;
        }

        public Criteria andPaymentModeGreaterThanOrEqualTo(Byte value) {
            addCriterion("payment_mode >=", value, "paymentMode");
            return (Criteria) this;
        }

        public Criteria andPaymentModeLessThan(Byte value) {
            addCriterion("payment_mode <", value, "paymentMode");
            return (Criteria) this;
        }

        public Criteria andPaymentModeLessThanOrEqualTo(Byte value) {
            addCriterion("payment_mode <=", value, "paymentMode");
            return (Criteria) this;
        }

        public Criteria andPaymentModeIn(List<Byte> values) {
            addCriterion("payment_mode in", values, "paymentMode");
            return (Criteria) this;
        }

        public Criteria andPaymentModeNotIn(List<Byte> values) {
            addCriterion("payment_mode not in", values, "paymentMode");
            return (Criteria) this;
        }

        public Criteria andPaymentModeBetween(Byte value1, Byte value2) {
            addCriterion("payment_mode between", value1, value2, "paymentMode");
            return (Criteria) this;
        }

        public Criteria andPaymentModeNotBetween(Byte value1, Byte value2) {
            addCriterion("payment_mode not between", value1, value2, "paymentMode");
            return (Criteria) this;
        }

        public Criteria andContractSummaryIsNull() {
            addCriterion("contract_summary is null");
            return (Criteria) this;
        }

        public Criteria andContractSummaryIsNotNull() {
            addCriterion("contract_summary is not null");
            return (Criteria) this;
        }

        public Criteria andContractSummaryEqualTo(String value) {
            addCriterion("contract_summary =", value, "contractSummary");
            return (Criteria) this;
        }

        public Criteria andContractSummaryNotEqualTo(String value) {
            addCriterion("contract_summary <>", value, "contractSummary");
            return (Criteria) this;
        }

        public Criteria andContractSummaryGreaterThan(String value) {
            addCriterion("contract_summary >", value, "contractSummary");
            return (Criteria) this;
        }

        public Criteria andContractSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("contract_summary >=", value, "contractSummary");
            return (Criteria) this;
        }

        public Criteria andContractSummaryLessThan(String value) {
            addCriterion("contract_summary <", value, "contractSummary");
            return (Criteria) this;
        }

        public Criteria andContractSummaryLessThanOrEqualTo(String value) {
            addCriterion("contract_summary <=", value, "contractSummary");
            return (Criteria) this;
        }

        public Criteria andContractSummaryLike(String value) {
            addCriterion("contract_summary like", value, "contractSummary");
            return (Criteria) this;
        }

        public Criteria andContractSummaryNotLike(String value) {
            addCriterion("contract_summary not like", value, "contractSummary");
            return (Criteria) this;
        }

        public Criteria andContractSummaryIn(List<String> values) {
            addCriterion("contract_summary in", values, "contractSummary");
            return (Criteria) this;
        }

        public Criteria andContractSummaryNotIn(List<String> values) {
            addCriterion("contract_summary not in", values, "contractSummary");
            return (Criteria) this;
        }

        public Criteria andContractSummaryBetween(String value1, String value2) {
            addCriterion("contract_summary between", value1, value2, "contractSummary");
            return (Criteria) this;
        }

        public Criteria andContractSummaryNotBetween(String value1, String value2) {
            addCriterion("contract_summary not between", value1, value2, "contractSummary");
            return (Criteria) this;
        }

        public Criteria andAccessoryIsNull() {
            addCriterion("accessory is null");
            return (Criteria) this;
        }

        public Criteria andAccessoryIsNotNull() {
            addCriterion("accessory is not null");
            return (Criteria) this;
        }

        public Criteria andAccessoryEqualTo(String value) {
            addCriterion("accessory =", value, "accessory");
            return (Criteria) this;
        }

        public Criteria andAccessoryNotEqualTo(String value) {
            addCriterion("accessory <>", value, "accessory");
            return (Criteria) this;
        }

        public Criteria andAccessoryGreaterThan(String value) {
            addCriterion("accessory >", value, "accessory");
            return (Criteria) this;
        }

        public Criteria andAccessoryGreaterThanOrEqualTo(String value) {
            addCriterion("accessory >=", value, "accessory");
            return (Criteria) this;
        }

        public Criteria andAccessoryLessThan(String value) {
            addCriterion("accessory <", value, "accessory");
            return (Criteria) this;
        }

        public Criteria andAccessoryLessThanOrEqualTo(String value) {
            addCriterion("accessory <=", value, "accessory");
            return (Criteria) this;
        }

        public Criteria andAccessoryLike(String value) {
            addCriterion("accessory like", value, "accessory");
            return (Criteria) this;
        }

        public Criteria andAccessoryNotLike(String value) {
            addCriterion("accessory not like", value, "accessory");
            return (Criteria) this;
        }

        public Criteria andAccessoryIn(List<String> values) {
            addCriterion("accessory in", values, "accessory");
            return (Criteria) this;
        }

        public Criteria andAccessoryNotIn(List<String> values) {
            addCriterion("accessory not in", values, "accessory");
            return (Criteria) this;
        }

        public Criteria andAccessoryBetween(String value1, String value2) {
            addCriterion("accessory between", value1, value2, "accessory");
            return (Criteria) this;
        }

        public Criteria andAccessoryNotBetween(String value1, String value2) {
            addCriterion("accessory not between", value1, value2, "accessory");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(Integer value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(Integer value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(Integer value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(Integer value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<Integer> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<Integer> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
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