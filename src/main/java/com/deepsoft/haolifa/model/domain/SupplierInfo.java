package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class SupplierInfo {
    private Integer id;

    private String suppilerNo;

    private String suppilerName;

    private String website;

    private Byte nature;

    private String phone;

    private String address;

    private String postcode;

    private String fax;

    private String legalPerson;

    private String legalPersonPhone;

    private Integer totalFactoryArea;

    private Integer totalArchitArea;

    private Byte workType;

    private String staffInfo;

    private String credentialsInfo;

    private String financialInfo;

    private String mainOrgan;

    private String qualityAssuranceInfo;

    private String processRoute;

    private String suppilerPreparer;

    private String responsiblePerson;

    private Integer createUserId;

    private Date updateTime;

    private Date createTime;

    private Byte isDelete;

    public SupplierInfo(Integer id, String suppilerNo, String suppilerName, String website, Byte nature, String phone, String address, String postcode, String fax, String legalPerson, String legalPersonPhone, Integer totalFactoryArea, Integer totalArchitArea, Byte workType, String staffInfo, String credentialsInfo, String financialInfo, String mainOrgan, String qualityAssuranceInfo, String processRoute, String suppilerPreparer, String responsiblePerson, Integer createUserId, Date updateTime, Date createTime, Byte isDelete) {
        this.id = id;
        this.suppilerNo = suppilerNo;
        this.suppilerName = suppilerName;
        this.website = website;
        this.nature = nature;
        this.phone = phone;
        this.address = address;
        this.postcode = postcode;
        this.fax = fax;
        this.legalPerson = legalPerson;
        this.legalPersonPhone = legalPersonPhone;
        this.totalFactoryArea = totalFactoryArea;
        this.totalArchitArea = totalArchitArea;
        this.workType = workType;
        this.staffInfo = staffInfo;
        this.credentialsInfo = credentialsInfo;
        this.financialInfo = financialInfo;
        this.mainOrgan = mainOrgan;
        this.qualityAssuranceInfo = qualityAssuranceInfo;
        this.processRoute = processRoute;
        this.suppilerPreparer = suppilerPreparer;
        this.responsiblePerson = responsiblePerson;
        this.createUserId = createUserId;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.isDelete = isDelete;
    }

    public SupplierInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSuppilerNo() {
        return suppilerNo;
    }

    public void setSuppilerNo(String suppilerNo) {
        this.suppilerNo = suppilerNo == null ? null : suppilerNo.trim();
    }

    public String getSuppilerName() {
        return suppilerName;
    }

    public void setSuppilerName(String suppilerName) {
        this.suppilerName = suppilerName == null ? null : suppilerName.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public Byte getNature() {
        return nature;
    }

    public void setNature(Byte nature) {
        this.nature = nature;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson == null ? null : legalPerson.trim();
    }

    public String getLegalPersonPhone() {
        return legalPersonPhone;
    }

    public void setLegalPersonPhone(String legalPersonPhone) {
        this.legalPersonPhone = legalPersonPhone == null ? null : legalPersonPhone.trim();
    }

    public Integer getTotalFactoryArea() {
        return totalFactoryArea;
    }

    public void setTotalFactoryArea(Integer totalFactoryArea) {
        this.totalFactoryArea = totalFactoryArea;
    }

    public Integer getTotalArchitArea() {
        return totalArchitArea;
    }

    public void setTotalArchitArea(Integer totalArchitArea) {
        this.totalArchitArea = totalArchitArea;
    }

    public Byte getWorkType() {
        return workType;
    }

    public void setWorkType(Byte workType) {
        this.workType = workType;
    }

    public String getStaffInfo() {
        return staffInfo;
    }

    public void setStaffInfo(String staffInfo) {
        this.staffInfo = staffInfo == null ? null : staffInfo.trim();
    }

    public String getCredentialsInfo() {
        return credentialsInfo;
    }

    public void setCredentialsInfo(String credentialsInfo) {
        this.credentialsInfo = credentialsInfo == null ? null : credentialsInfo.trim();
    }

    public String getFinancialInfo() {
        return financialInfo;
    }

    public void setFinancialInfo(String financialInfo) {
        this.financialInfo = financialInfo == null ? null : financialInfo.trim();
    }

    public String getMainOrgan() {
        return mainOrgan;
    }

    public void setMainOrgan(String mainOrgan) {
        this.mainOrgan = mainOrgan == null ? null : mainOrgan.trim();
    }

    public String getQualityAssuranceInfo() {
        return qualityAssuranceInfo;
    }

    public void setQualityAssuranceInfo(String qualityAssuranceInfo) {
        this.qualityAssuranceInfo = qualityAssuranceInfo == null ? null : qualityAssuranceInfo.trim();
    }

    public String getProcessRoute() {
        return processRoute;
    }

    public void setProcessRoute(String processRoute) {
        this.processRoute = processRoute == null ? null : processRoute.trim();
    }

    public String getSuppilerPreparer() {
        return suppilerPreparer;
    }

    public void setSuppilerPreparer(String suppilerPreparer) {
        this.suppilerPreparer = suppilerPreparer == null ? null : suppilerPreparer.trim();
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson == null ? null : responsiblePerson.trim();
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}