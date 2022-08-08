package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class PayUser {
    private Integer id;

    private String userName;

    private String userNo;

    private Integer parentId;

    private String onceUserName;

    private Byte sex;

    private Date birthday;

    private String nation;

    private String nativePlace;

    private String politicalOutlook;

    private String bloodType;

    private String health;

    private Byte marryStatus;

    private String idCard;

    private String registered;

    private String universityFrom;

    private String major;

    private Byte education;

    private Date graduationTime;

    private Date workingTime;

    private String address;

    private BigDecimal insuranceBase;

    private String phone;

    private String mail;

    private Integer teamId;

    private BigDecimal basePay;

    private BigDecimal meritPay;

    private Integer postId;

    private Integer departId;

    private String departName;

    private String userType;

    private String superiorName;

    private Integer superiorId;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;

    public PayUser(Integer id, String userName, String userNo, Integer parentId, String onceUserName, Byte sex, Date birthday, String nation, String nativePlace, String politicalOutlook, String bloodType, String health, Byte marryStatus, String idCard, String registered, String universityFrom, String major, Byte education, Date graduationTime, Date workingTime, String address, BigDecimal insuranceBase, String phone, String mail, Integer teamId, BigDecimal basePay, BigDecimal meritPay, Integer postId, Integer departId, String departName, String userType, String superiorName, Integer superiorId, String createUser, String updateUser, Date createTime, Date updateTime) {
        this.id = id;
        this.userName = userName;
        this.userNo = userNo;
        this.parentId = parentId;
        this.onceUserName = onceUserName;
        this.sex = sex;
        this.birthday = birthday;
        this.nation = nation;
        this.nativePlace = nativePlace;
        this.politicalOutlook = politicalOutlook;
        this.bloodType = bloodType;
        this.health = health;
        this.marryStatus = marryStatus;
        this.idCard = idCard;
        this.registered = registered;
        this.universityFrom = universityFrom;
        this.major = major;
        this.education = education;
        this.graduationTime = graduationTime;
        this.workingTime = workingTime;
        this.address = address;
        this.insuranceBase = insuranceBase;
        this.phone = phone;
        this.mail = mail;
        this.teamId = teamId;
        this.basePay = basePay;
        this.meritPay = meritPay;
        this.postId = postId;
        this.departId = departId;
        this.departName = departName;
        this.userType = userType;
        this.superiorName = superiorName;
        this.superiorId = superiorId;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public PayUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getOnceUserName() {
        return onceUserName;
    }

    public void setOnceUserName(String onceUserName) {
        this.onceUserName = onceUserName == null ? null : onceUserName.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace == null ? null : nativePlace.trim();
    }

    public String getPoliticalOutlook() {
        return politicalOutlook;
    }

    public void setPoliticalOutlook(String politicalOutlook) {
        this.politicalOutlook = politicalOutlook == null ? null : politicalOutlook.trim();
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType == null ? null : bloodType.trim();
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health == null ? null : health.trim();
    }

    public Byte getMarryStatus() {
        return marryStatus;
    }

    public void setMarryStatus(Byte marryStatus) {
        this.marryStatus = marryStatus;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered == null ? null : registered.trim();
    }

    public String getUniversityFrom() {
        return universityFrom;
    }

    public void setUniversityFrom(String universityFrom) {
        this.universityFrom = universityFrom == null ? null : universityFrom.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public Byte getEducation() {
        return education;
    }

    public void setEducation(Byte education) {
        this.education = education;
    }

    public Date getGraduationTime() {
        return graduationTime;
    }

    public void setGraduationTime(Date graduationTime) {
        this.graduationTime = graduationTime;
    }

    public Date getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(Date workingTime) {
        this.workingTime = workingTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public BigDecimal getInsuranceBase() {
        return insuranceBase;
    }

    public void setInsuranceBase(BigDecimal insuranceBase) {
        this.insuranceBase = insuranceBase;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public BigDecimal getBasePay() {
        return basePay;
    }

    public void setBasePay(BigDecimal basePay) {
        this.basePay = basePay;
    }

    public BigDecimal getMeritPay() {
        return meritPay;
    }

    public void setMeritPay(BigDecimal meritPay) {
        this.meritPay = meritPay;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getDepartId() {
        return departId;
    }

    public void setDepartId(Integer departId) {
        this.departId = departId;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName == null ? null : departName.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getSuperiorName() {
        return superiorName;
    }

    public void setSuperiorName(String superiorName) {
        this.superiorName = superiorName == null ? null : superiorName.trim();
    }

    public Integer getSuperiorId() {
        return superiorId;
    }

    public void setSuperiorId(Integer superiorId) {
        this.superiorId = superiorId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
