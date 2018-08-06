package com.deepsoft.haolifa.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SupplierExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SupplierExample() {
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

        public Criteria andSuppilerNoIsNull() {
            addCriterion("suppiler_no is null");
            return (Criteria) this;
        }

        public Criteria andSuppilerNoIsNotNull() {
            addCriterion("suppiler_no is not null");
            return (Criteria) this;
        }

        public Criteria andSuppilerNoEqualTo(String value) {
            addCriterion("suppiler_no =", value, "suppilerNo");
            return (Criteria) this;
        }

        public Criteria andSuppilerNoNotEqualTo(String value) {
            addCriterion("suppiler_no <>", value, "suppilerNo");
            return (Criteria) this;
        }

        public Criteria andSuppilerNoGreaterThan(String value) {
            addCriterion("suppiler_no >", value, "suppilerNo");
            return (Criteria) this;
        }

        public Criteria andSuppilerNoGreaterThanOrEqualTo(String value) {
            addCriterion("suppiler_no >=", value, "suppilerNo");
            return (Criteria) this;
        }

        public Criteria andSuppilerNoLessThan(String value) {
            addCriterion("suppiler_no <", value, "suppilerNo");
            return (Criteria) this;
        }

        public Criteria andSuppilerNoLessThanOrEqualTo(String value) {
            addCriterion("suppiler_no <=", value, "suppilerNo");
            return (Criteria) this;
        }

        public Criteria andSuppilerNoLike(String value) {
            addCriterion("suppiler_no like", value, "suppilerNo");
            return (Criteria) this;
        }

        public Criteria andSuppilerNoNotLike(String value) {
            addCriterion("suppiler_no not like", value, "suppilerNo");
            return (Criteria) this;
        }

        public Criteria andSuppilerNoIn(List<String> values) {
            addCriterion("suppiler_no in", values, "suppilerNo");
            return (Criteria) this;
        }

        public Criteria andSuppilerNoNotIn(List<String> values) {
            addCriterion("suppiler_no not in", values, "suppilerNo");
            return (Criteria) this;
        }

        public Criteria andSuppilerNoBetween(String value1, String value2) {
            addCriterion("suppiler_no between", value1, value2, "suppilerNo");
            return (Criteria) this;
        }

        public Criteria andSuppilerNoNotBetween(String value1, String value2) {
            addCriterion("suppiler_no not between", value1, value2, "suppilerNo");
            return (Criteria) this;
        }

        public Criteria andSuppilerNameIsNull() {
            addCriterion("suppiler_name is null");
            return (Criteria) this;
        }

        public Criteria andSuppilerNameIsNotNull() {
            addCriterion("suppiler_name is not null");
            return (Criteria) this;
        }

        public Criteria andSuppilerNameEqualTo(String value) {
            addCriterion("suppiler_name =", value, "suppilerName");
            return (Criteria) this;
        }

        public Criteria andSuppilerNameNotEqualTo(String value) {
            addCriterion("suppiler_name <>", value, "suppilerName");
            return (Criteria) this;
        }

        public Criteria andSuppilerNameGreaterThan(String value) {
            addCriterion("suppiler_name >", value, "suppilerName");
            return (Criteria) this;
        }

        public Criteria andSuppilerNameGreaterThanOrEqualTo(String value) {
            addCriterion("suppiler_name >=", value, "suppilerName");
            return (Criteria) this;
        }

        public Criteria andSuppilerNameLessThan(String value) {
            addCriterion("suppiler_name <", value, "suppilerName");
            return (Criteria) this;
        }

        public Criteria andSuppilerNameLessThanOrEqualTo(String value) {
            addCriterion("suppiler_name <=", value, "suppilerName");
            return (Criteria) this;
        }

        public Criteria andSuppilerNameLike(String value) {
            addCriterion("suppiler_name like", value, "suppilerName");
            return (Criteria) this;
        }

        public Criteria andSuppilerNameNotLike(String value) {
            addCriterion("suppiler_name not like", value, "suppilerName");
            return (Criteria) this;
        }

        public Criteria andSuppilerNameIn(List<String> values) {
            addCriterion("suppiler_name in", values, "suppilerName");
            return (Criteria) this;
        }

        public Criteria andSuppilerNameNotIn(List<String> values) {
            addCriterion("suppiler_name not in", values, "suppilerName");
            return (Criteria) this;
        }

        public Criteria andSuppilerNameBetween(String value1, String value2) {
            addCriterion("suppiler_name between", value1, value2, "suppilerName");
            return (Criteria) this;
        }

        public Criteria andSuppilerNameNotBetween(String value1, String value2) {
            addCriterion("suppiler_name not between", value1, value2, "suppilerName");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNull() {
            addCriterion("website is null");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNotNull() {
            addCriterion("website is not null");
            return (Criteria) this;
        }

        public Criteria andWebsiteEqualTo(String value) {
            addCriterion("website =", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotEqualTo(String value) {
            addCriterion("website <>", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThan(String value) {
            addCriterion("website >", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("website >=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThan(String value) {
            addCriterion("website <", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThanOrEqualTo(String value) {
            addCriterion("website <=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLike(String value) {
            addCriterion("website like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotLike(String value) {
            addCriterion("website not like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteIn(List<String> values) {
            addCriterion("website in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotIn(List<String> values) {
            addCriterion("website not in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteBetween(String value1, String value2) {
            addCriterion("website between", value1, value2, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotBetween(String value1, String value2) {
            addCriterion("website not between", value1, value2, "website");
            return (Criteria) this;
        }

        public Criteria andNatureIsNull() {
            addCriterion("nature is null");
            return (Criteria) this;
        }

        public Criteria andNatureIsNotNull() {
            addCriterion("nature is not null");
            return (Criteria) this;
        }

        public Criteria andNatureEqualTo(Byte value) {
            addCriterion("nature =", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureNotEqualTo(Byte value) {
            addCriterion("nature <>", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureGreaterThan(Byte value) {
            addCriterion("nature >", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureGreaterThanOrEqualTo(Byte value) {
            addCriterion("nature >=", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureLessThan(Byte value) {
            addCriterion("nature <", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureLessThanOrEqualTo(Byte value) {
            addCriterion("nature <=", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureIn(List<Byte> values) {
            addCriterion("nature in", values, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureNotIn(List<Byte> values) {
            addCriterion("nature not in", values, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureBetween(Byte value1, Byte value2) {
            addCriterion("nature between", value1, value2, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureNotBetween(Byte value1, Byte value2) {
            addCriterion("nature not between", value1, value2, "nature");
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

        public Criteria andPostcodeIsNull() {
            addCriterion("postcode is null");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNotNull() {
            addCriterion("postcode is not null");
            return (Criteria) this;
        }

        public Criteria andPostcodeEqualTo(String value) {
            addCriterion("postcode =", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotEqualTo(String value) {
            addCriterion("postcode <>", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThan(String value) {
            addCriterion("postcode >", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("postcode >=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThan(String value) {
            addCriterion("postcode <", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThanOrEqualTo(String value) {
            addCriterion("postcode <=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLike(String value) {
            addCriterion("postcode like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotLike(String value) {
            addCriterion("postcode not like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeIn(List<String> values) {
            addCriterion("postcode in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotIn(List<String> values) {
            addCriterion("postcode not in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeBetween(String value1, String value2) {
            addCriterion("postcode between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotBetween(String value1, String value2) {
            addCriterion("postcode not between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andFaxIsNull() {
            addCriterion("fax is null");
            return (Criteria) this;
        }

        public Criteria andFaxIsNotNull() {
            addCriterion("fax is not null");
            return (Criteria) this;
        }

        public Criteria andFaxEqualTo(String value) {
            addCriterion("fax =", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotEqualTo(String value) {
            addCriterion("fax <>", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThan(String value) {
            addCriterion("fax >", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThanOrEqualTo(String value) {
            addCriterion("fax >=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThan(String value) {
            addCriterion("fax <", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThanOrEqualTo(String value) {
            addCriterion("fax <=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLike(String value) {
            addCriterion("fax like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotLike(String value) {
            addCriterion("fax not like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxIn(List<String> values) {
            addCriterion("fax in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotIn(List<String> values) {
            addCriterion("fax not in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxBetween(String value1, String value2) {
            addCriterion("fax between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotBetween(String value1, String value2) {
            addCriterion("fax not between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIsNull() {
            addCriterion("legal_person is null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIsNotNull() {
            addCriterion("legal_person is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonEqualTo(String value) {
            addCriterion("legal_person =", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotEqualTo(String value) {
            addCriterion("legal_person <>", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonGreaterThan(String value) {
            addCriterion("legal_person >", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonGreaterThanOrEqualTo(String value) {
            addCriterion("legal_person >=", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLessThan(String value) {
            addCriterion("legal_person <", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLessThanOrEqualTo(String value) {
            addCriterion("legal_person <=", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLike(String value) {
            addCriterion("legal_person like", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotLike(String value) {
            addCriterion("legal_person not like", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIn(List<String> values) {
            addCriterion("legal_person in", values, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotIn(List<String> values) {
            addCriterion("legal_person not in", values, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonBetween(String value1, String value2) {
            addCriterion("legal_person between", value1, value2, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotBetween(String value1, String value2) {
            addCriterion("legal_person not between", value1, value2, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPhoneIsNull() {
            addCriterion("legal_person_phone is null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPhoneIsNotNull() {
            addCriterion("legal_person_phone is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPhoneEqualTo(String value) {
            addCriterion("legal_person_phone =", value, "legalPersonPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPhoneNotEqualTo(String value) {
            addCriterion("legal_person_phone <>", value, "legalPersonPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPhoneGreaterThan(String value) {
            addCriterion("legal_person_phone >", value, "legalPersonPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("legal_person_phone >=", value, "legalPersonPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPhoneLessThan(String value) {
            addCriterion("legal_person_phone <", value, "legalPersonPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPhoneLessThanOrEqualTo(String value) {
            addCriterion("legal_person_phone <=", value, "legalPersonPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPhoneLike(String value) {
            addCriterion("legal_person_phone like", value, "legalPersonPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPhoneNotLike(String value) {
            addCriterion("legal_person_phone not like", value, "legalPersonPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPhoneIn(List<String> values) {
            addCriterion("legal_person_phone in", values, "legalPersonPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPhoneNotIn(List<String> values) {
            addCriterion("legal_person_phone not in", values, "legalPersonPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPhoneBetween(String value1, String value2) {
            addCriterion("legal_person_phone between", value1, value2, "legalPersonPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPhoneNotBetween(String value1, String value2) {
            addCriterion("legal_person_phone not between", value1, value2, "legalPersonPhone");
            return (Criteria) this;
        }

        public Criteria andTotalFactoryAreaIsNull() {
            addCriterion("total_factory_area is null");
            return (Criteria) this;
        }

        public Criteria andTotalFactoryAreaIsNotNull() {
            addCriterion("total_factory_area is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFactoryAreaEqualTo(Integer value) {
            addCriterion("total_factory_area =", value, "totalFactoryArea");
            return (Criteria) this;
        }

        public Criteria andTotalFactoryAreaNotEqualTo(Integer value) {
            addCriterion("total_factory_area <>", value, "totalFactoryArea");
            return (Criteria) this;
        }

        public Criteria andTotalFactoryAreaGreaterThan(Integer value) {
            addCriterion("total_factory_area >", value, "totalFactoryArea");
            return (Criteria) this;
        }

        public Criteria andTotalFactoryAreaGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_factory_area >=", value, "totalFactoryArea");
            return (Criteria) this;
        }

        public Criteria andTotalFactoryAreaLessThan(Integer value) {
            addCriterion("total_factory_area <", value, "totalFactoryArea");
            return (Criteria) this;
        }

        public Criteria andTotalFactoryAreaLessThanOrEqualTo(Integer value) {
            addCriterion("total_factory_area <=", value, "totalFactoryArea");
            return (Criteria) this;
        }

        public Criteria andTotalFactoryAreaIn(List<Integer> values) {
            addCriterion("total_factory_area in", values, "totalFactoryArea");
            return (Criteria) this;
        }

        public Criteria andTotalFactoryAreaNotIn(List<Integer> values) {
            addCriterion("total_factory_area not in", values, "totalFactoryArea");
            return (Criteria) this;
        }

        public Criteria andTotalFactoryAreaBetween(Integer value1, Integer value2) {
            addCriterion("total_factory_area between", value1, value2, "totalFactoryArea");
            return (Criteria) this;
        }

        public Criteria andTotalFactoryAreaNotBetween(Integer value1, Integer value2) {
            addCriterion("total_factory_area not between", value1, value2, "totalFactoryArea");
            return (Criteria) this;
        }

        public Criteria andTotalArchitAreaIsNull() {
            addCriterion("total_archit_area is null");
            return (Criteria) this;
        }

        public Criteria andTotalArchitAreaIsNotNull() {
            addCriterion("total_archit_area is not null");
            return (Criteria) this;
        }

        public Criteria andTotalArchitAreaEqualTo(Integer value) {
            addCriterion("total_archit_area =", value, "totalArchitArea");
            return (Criteria) this;
        }

        public Criteria andTotalArchitAreaNotEqualTo(Integer value) {
            addCriterion("total_archit_area <>", value, "totalArchitArea");
            return (Criteria) this;
        }

        public Criteria andTotalArchitAreaGreaterThan(Integer value) {
            addCriterion("total_archit_area >", value, "totalArchitArea");
            return (Criteria) this;
        }

        public Criteria andTotalArchitAreaGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_archit_area >=", value, "totalArchitArea");
            return (Criteria) this;
        }

        public Criteria andTotalArchitAreaLessThan(Integer value) {
            addCriterion("total_archit_area <", value, "totalArchitArea");
            return (Criteria) this;
        }

        public Criteria andTotalArchitAreaLessThanOrEqualTo(Integer value) {
            addCriterion("total_archit_area <=", value, "totalArchitArea");
            return (Criteria) this;
        }

        public Criteria andTotalArchitAreaIn(List<Integer> values) {
            addCriterion("total_archit_area in", values, "totalArchitArea");
            return (Criteria) this;
        }

        public Criteria andTotalArchitAreaNotIn(List<Integer> values) {
            addCriterion("total_archit_area not in", values, "totalArchitArea");
            return (Criteria) this;
        }

        public Criteria andTotalArchitAreaBetween(Integer value1, Integer value2) {
            addCriterion("total_archit_area between", value1, value2, "totalArchitArea");
            return (Criteria) this;
        }

        public Criteria andTotalArchitAreaNotBetween(Integer value1, Integer value2) {
            addCriterion("total_archit_area not between", value1, value2, "totalArchitArea");
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

        public Criteria andWorkTypeEqualTo(Byte value) {
            addCriterion("work_type =", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotEqualTo(Byte value) {
            addCriterion("work_type <>", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeGreaterThan(Byte value) {
            addCriterion("work_type >", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("work_type >=", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLessThan(Byte value) {
            addCriterion("work_type <", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLessThanOrEqualTo(Byte value) {
            addCriterion("work_type <=", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIn(List<Byte> values) {
            addCriterion("work_type in", values, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotIn(List<Byte> values) {
            addCriterion("work_type not in", values, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeBetween(Byte value1, Byte value2) {
            addCriterion("work_type between", value1, value2, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("work_type not between", value1, value2, "workType");
            return (Criteria) this;
        }

        public Criteria andStaffInfoIsNull() {
            addCriterion("staff_info is null");
            return (Criteria) this;
        }

        public Criteria andStaffInfoIsNotNull() {
            addCriterion("staff_info is not null");
            return (Criteria) this;
        }

        public Criteria andStaffInfoEqualTo(String value) {
            addCriterion("staff_info =", value, "staffInfo");
            return (Criteria) this;
        }

        public Criteria andStaffInfoNotEqualTo(String value) {
            addCriterion("staff_info <>", value, "staffInfo");
            return (Criteria) this;
        }

        public Criteria andStaffInfoGreaterThan(String value) {
            addCriterion("staff_info >", value, "staffInfo");
            return (Criteria) this;
        }

        public Criteria andStaffInfoGreaterThanOrEqualTo(String value) {
            addCriterion("staff_info >=", value, "staffInfo");
            return (Criteria) this;
        }

        public Criteria andStaffInfoLessThan(String value) {
            addCriterion("staff_info <", value, "staffInfo");
            return (Criteria) this;
        }

        public Criteria andStaffInfoLessThanOrEqualTo(String value) {
            addCriterion("staff_info <=", value, "staffInfo");
            return (Criteria) this;
        }

        public Criteria andStaffInfoLike(String value) {
            addCriterion("staff_info like", value, "staffInfo");
            return (Criteria) this;
        }

        public Criteria andStaffInfoNotLike(String value) {
            addCriterion("staff_info not like", value, "staffInfo");
            return (Criteria) this;
        }

        public Criteria andStaffInfoIn(List<String> values) {
            addCriterion("staff_info in", values, "staffInfo");
            return (Criteria) this;
        }

        public Criteria andStaffInfoNotIn(List<String> values) {
            addCriterion("staff_info not in", values, "staffInfo");
            return (Criteria) this;
        }

        public Criteria andStaffInfoBetween(String value1, String value2) {
            addCriterion("staff_info between", value1, value2, "staffInfo");
            return (Criteria) this;
        }

        public Criteria andStaffInfoNotBetween(String value1, String value2) {
            addCriterion("staff_info not between", value1, value2, "staffInfo");
            return (Criteria) this;
        }

        public Criteria andCredentialsInfoIsNull() {
            addCriterion("credentials_info is null");
            return (Criteria) this;
        }

        public Criteria andCredentialsInfoIsNotNull() {
            addCriterion("credentials_info is not null");
            return (Criteria) this;
        }

        public Criteria andCredentialsInfoEqualTo(String value) {
            addCriterion("credentials_info =", value, "credentialsInfo");
            return (Criteria) this;
        }

        public Criteria andCredentialsInfoNotEqualTo(String value) {
            addCriterion("credentials_info <>", value, "credentialsInfo");
            return (Criteria) this;
        }

        public Criteria andCredentialsInfoGreaterThan(String value) {
            addCriterion("credentials_info >", value, "credentialsInfo");
            return (Criteria) this;
        }

        public Criteria andCredentialsInfoGreaterThanOrEqualTo(String value) {
            addCriterion("credentials_info >=", value, "credentialsInfo");
            return (Criteria) this;
        }

        public Criteria andCredentialsInfoLessThan(String value) {
            addCriterion("credentials_info <", value, "credentialsInfo");
            return (Criteria) this;
        }

        public Criteria andCredentialsInfoLessThanOrEqualTo(String value) {
            addCriterion("credentials_info <=", value, "credentialsInfo");
            return (Criteria) this;
        }

        public Criteria andCredentialsInfoLike(String value) {
            addCriterion("credentials_info like", value, "credentialsInfo");
            return (Criteria) this;
        }

        public Criteria andCredentialsInfoNotLike(String value) {
            addCriterion("credentials_info not like", value, "credentialsInfo");
            return (Criteria) this;
        }

        public Criteria andCredentialsInfoIn(List<String> values) {
            addCriterion("credentials_info in", values, "credentialsInfo");
            return (Criteria) this;
        }

        public Criteria andCredentialsInfoNotIn(List<String> values) {
            addCriterion("credentials_info not in", values, "credentialsInfo");
            return (Criteria) this;
        }

        public Criteria andCredentialsInfoBetween(String value1, String value2) {
            addCriterion("credentials_info between", value1, value2, "credentialsInfo");
            return (Criteria) this;
        }

        public Criteria andCredentialsInfoNotBetween(String value1, String value2) {
            addCriterion("credentials_info not between", value1, value2, "credentialsInfo");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoIsNull() {
            addCriterion("financial_info is null");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoIsNotNull() {
            addCriterion("financial_info is not null");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoEqualTo(String value) {
            addCriterion("financial_info =", value, "financialInfo");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoNotEqualTo(String value) {
            addCriterion("financial_info <>", value, "financialInfo");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoGreaterThan(String value) {
            addCriterion("financial_info >", value, "financialInfo");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoGreaterThanOrEqualTo(String value) {
            addCriterion("financial_info >=", value, "financialInfo");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoLessThan(String value) {
            addCriterion("financial_info <", value, "financialInfo");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoLessThanOrEqualTo(String value) {
            addCriterion("financial_info <=", value, "financialInfo");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoLike(String value) {
            addCriterion("financial_info like", value, "financialInfo");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoNotLike(String value) {
            addCriterion("financial_info not like", value, "financialInfo");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoIn(List<String> values) {
            addCriterion("financial_info in", values, "financialInfo");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoNotIn(List<String> values) {
            addCriterion("financial_info not in", values, "financialInfo");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoBetween(String value1, String value2) {
            addCriterion("financial_info between", value1, value2, "financialInfo");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoNotBetween(String value1, String value2) {
            addCriterion("financial_info not between", value1, value2, "financialInfo");
            return (Criteria) this;
        }

        public Criteria andMainOrganIsNull() {
            addCriterion("main_organ is null");
            return (Criteria) this;
        }

        public Criteria andMainOrganIsNotNull() {
            addCriterion("main_organ is not null");
            return (Criteria) this;
        }

        public Criteria andMainOrganEqualTo(String value) {
            addCriterion("main_organ =", value, "mainOrgan");
            return (Criteria) this;
        }

        public Criteria andMainOrganNotEqualTo(String value) {
            addCriterion("main_organ <>", value, "mainOrgan");
            return (Criteria) this;
        }

        public Criteria andMainOrganGreaterThan(String value) {
            addCriterion("main_organ >", value, "mainOrgan");
            return (Criteria) this;
        }

        public Criteria andMainOrganGreaterThanOrEqualTo(String value) {
            addCriterion("main_organ >=", value, "mainOrgan");
            return (Criteria) this;
        }

        public Criteria andMainOrganLessThan(String value) {
            addCriterion("main_organ <", value, "mainOrgan");
            return (Criteria) this;
        }

        public Criteria andMainOrganLessThanOrEqualTo(String value) {
            addCriterion("main_organ <=", value, "mainOrgan");
            return (Criteria) this;
        }

        public Criteria andMainOrganLike(String value) {
            addCriterion("main_organ like", value, "mainOrgan");
            return (Criteria) this;
        }

        public Criteria andMainOrganNotLike(String value) {
            addCriterion("main_organ not like", value, "mainOrgan");
            return (Criteria) this;
        }

        public Criteria andMainOrganIn(List<String> values) {
            addCriterion("main_organ in", values, "mainOrgan");
            return (Criteria) this;
        }

        public Criteria andMainOrganNotIn(List<String> values) {
            addCriterion("main_organ not in", values, "mainOrgan");
            return (Criteria) this;
        }

        public Criteria andMainOrganBetween(String value1, String value2) {
            addCriterion("main_organ between", value1, value2, "mainOrgan");
            return (Criteria) this;
        }

        public Criteria andMainOrganNotBetween(String value1, String value2) {
            addCriterion("main_organ not between", value1, value2, "mainOrgan");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceInfoIsNull() {
            addCriterion("quality_assurance_info is null");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceInfoIsNotNull() {
            addCriterion("quality_assurance_info is not null");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceInfoEqualTo(String value) {
            addCriterion("quality_assurance_info =", value, "qualityAssuranceInfo");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceInfoNotEqualTo(String value) {
            addCriterion("quality_assurance_info <>", value, "qualityAssuranceInfo");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceInfoGreaterThan(String value) {
            addCriterion("quality_assurance_info >", value, "qualityAssuranceInfo");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceInfoGreaterThanOrEqualTo(String value) {
            addCriterion("quality_assurance_info >=", value, "qualityAssuranceInfo");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceInfoLessThan(String value) {
            addCriterion("quality_assurance_info <", value, "qualityAssuranceInfo");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceInfoLessThanOrEqualTo(String value) {
            addCriterion("quality_assurance_info <=", value, "qualityAssuranceInfo");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceInfoLike(String value) {
            addCriterion("quality_assurance_info like", value, "qualityAssuranceInfo");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceInfoNotLike(String value) {
            addCriterion("quality_assurance_info not like", value, "qualityAssuranceInfo");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceInfoIn(List<String> values) {
            addCriterion("quality_assurance_info in", values, "qualityAssuranceInfo");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceInfoNotIn(List<String> values) {
            addCriterion("quality_assurance_info not in", values, "qualityAssuranceInfo");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceInfoBetween(String value1, String value2) {
            addCriterion("quality_assurance_info between", value1, value2, "qualityAssuranceInfo");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceInfoNotBetween(String value1, String value2) {
            addCriterion("quality_assurance_info not between", value1, value2, "qualityAssuranceInfo");
            return (Criteria) this;
        }

        public Criteria andProcessRouteIsNull() {
            addCriterion("process_route is null");
            return (Criteria) this;
        }

        public Criteria andProcessRouteIsNotNull() {
            addCriterion("process_route is not null");
            return (Criteria) this;
        }

        public Criteria andProcessRouteEqualTo(String value) {
            addCriterion("process_route =", value, "processRoute");
            return (Criteria) this;
        }

        public Criteria andProcessRouteNotEqualTo(String value) {
            addCriterion("process_route <>", value, "processRoute");
            return (Criteria) this;
        }

        public Criteria andProcessRouteGreaterThan(String value) {
            addCriterion("process_route >", value, "processRoute");
            return (Criteria) this;
        }

        public Criteria andProcessRouteGreaterThanOrEqualTo(String value) {
            addCriterion("process_route >=", value, "processRoute");
            return (Criteria) this;
        }

        public Criteria andProcessRouteLessThan(String value) {
            addCriterion("process_route <", value, "processRoute");
            return (Criteria) this;
        }

        public Criteria andProcessRouteLessThanOrEqualTo(String value) {
            addCriterion("process_route <=", value, "processRoute");
            return (Criteria) this;
        }

        public Criteria andProcessRouteLike(String value) {
            addCriterion("process_route like", value, "processRoute");
            return (Criteria) this;
        }

        public Criteria andProcessRouteNotLike(String value) {
            addCriterion("process_route not like", value, "processRoute");
            return (Criteria) this;
        }

        public Criteria andProcessRouteIn(List<String> values) {
            addCriterion("process_route in", values, "processRoute");
            return (Criteria) this;
        }

        public Criteria andProcessRouteNotIn(List<String> values) {
            addCriterion("process_route not in", values, "processRoute");
            return (Criteria) this;
        }

        public Criteria andProcessRouteBetween(String value1, String value2) {
            addCriterion("process_route between", value1, value2, "processRoute");
            return (Criteria) this;
        }

        public Criteria andProcessRouteNotBetween(String value1, String value2) {
            addCriterion("process_route not between", value1, value2, "processRoute");
            return (Criteria) this;
        }

        public Criteria andSuppilerPreparerIsNull() {
            addCriterion("suppiler_preparer is null");
            return (Criteria) this;
        }

        public Criteria andSuppilerPreparerIsNotNull() {
            addCriterion("suppiler_preparer is not null");
            return (Criteria) this;
        }

        public Criteria andSuppilerPreparerEqualTo(String value) {
            addCriterion("suppiler_preparer =", value, "suppilerPreparer");
            return (Criteria) this;
        }

        public Criteria andSuppilerPreparerNotEqualTo(String value) {
            addCriterion("suppiler_preparer <>", value, "suppilerPreparer");
            return (Criteria) this;
        }

        public Criteria andSuppilerPreparerGreaterThan(String value) {
            addCriterion("suppiler_preparer >", value, "suppilerPreparer");
            return (Criteria) this;
        }

        public Criteria andSuppilerPreparerGreaterThanOrEqualTo(String value) {
            addCriterion("suppiler_preparer >=", value, "suppilerPreparer");
            return (Criteria) this;
        }

        public Criteria andSuppilerPreparerLessThan(String value) {
            addCriterion("suppiler_preparer <", value, "suppilerPreparer");
            return (Criteria) this;
        }

        public Criteria andSuppilerPreparerLessThanOrEqualTo(String value) {
            addCriterion("suppiler_preparer <=", value, "suppilerPreparer");
            return (Criteria) this;
        }

        public Criteria andSuppilerPreparerLike(String value) {
            addCriterion("suppiler_preparer like", value, "suppilerPreparer");
            return (Criteria) this;
        }

        public Criteria andSuppilerPreparerNotLike(String value) {
            addCriterion("suppiler_preparer not like", value, "suppilerPreparer");
            return (Criteria) this;
        }

        public Criteria andSuppilerPreparerIn(List<String> values) {
            addCriterion("suppiler_preparer in", values, "suppilerPreparer");
            return (Criteria) this;
        }

        public Criteria andSuppilerPreparerNotIn(List<String> values) {
            addCriterion("suppiler_preparer not in", values, "suppilerPreparer");
            return (Criteria) this;
        }

        public Criteria andSuppilerPreparerBetween(String value1, String value2) {
            addCriterion("suppiler_preparer between", value1, value2, "suppilerPreparer");
            return (Criteria) this;
        }

        public Criteria andSuppilerPreparerNotBetween(String value1, String value2) {
            addCriterion("suppiler_preparer not between", value1, value2, "suppilerPreparer");
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

        public Criteria andEvaluationIsNull() {
            addCriterion("evaluation is null");
            return (Criteria) this;
        }

        public Criteria andEvaluationIsNotNull() {
            addCriterion("evaluation is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluationEqualTo(String value) {
            addCriterion("evaluation =", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationNotEqualTo(String value) {
            addCriterion("evaluation <>", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationGreaterThan(String value) {
            addCriterion("evaluation >", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationGreaterThanOrEqualTo(String value) {
            addCriterion("evaluation >=", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationLessThan(String value) {
            addCriterion("evaluation <", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationLessThanOrEqualTo(String value) {
            addCriterion("evaluation <=", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationLike(String value) {
            addCriterion("evaluation like", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationNotLike(String value) {
            addCriterion("evaluation not like", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationIn(List<String> values) {
            addCriterion("evaluation in", values, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationNotIn(List<String> values) {
            addCriterion("evaluation not in", values, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationBetween(String value1, String value2) {
            addCriterion("evaluation between", value1, value2, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationNotBetween(String value1, String value2) {
            addCriterion("evaluation not between", value1, value2, "evaluation");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedIsNull() {
            addCriterion("is_qualified is null");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedIsNotNull() {
            addCriterion("is_qualified is not null");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedEqualTo(Byte value) {
            addCriterion("is_qualified =", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedNotEqualTo(Byte value) {
            addCriterion("is_qualified <>", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedGreaterThan(Byte value) {
            addCriterion("is_qualified >", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_qualified >=", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedLessThan(Byte value) {
            addCriterion("is_qualified <", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedLessThanOrEqualTo(Byte value) {
            addCriterion("is_qualified <=", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedIn(List<Byte> values) {
            addCriterion("is_qualified in", values, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedNotIn(List<Byte> values) {
            addCriterion("is_qualified not in", values, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedBetween(Byte value1, Byte value2) {
            addCriterion("is_qualified between", value1, value2, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedNotBetween(Byte value1, Byte value2) {
            addCriterion("is_qualified not between", value1, value2, "isQualified");
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