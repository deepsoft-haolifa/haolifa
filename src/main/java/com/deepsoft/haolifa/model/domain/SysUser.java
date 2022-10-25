package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class SysUser {
    private Integer id;

    private String username;

    private String password;

    private String realName;

    private String userNo;

    private Byte sex;

    private String nativePlace;

    private String phone;

    private String idCard;

    private String photoUrl;

    private Byte isDelete;

    private Integer departId;

    private Integer postId;

    private Date entryTime;

    private Date createTime;

    private Date updateTime;

    public SysUser(Integer id, String username, String password, String realName, String userNo, Byte sex, String nativePlace, String phone, String idCard, String photoUrl, Byte isDelete, Integer departId, Integer postId, Date entryTime, Date createTime, Date updateTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.userNo = userNo;
        this.sex = sex;
        this.nativePlace = nativePlace;
        this.phone = phone;
        this.idCard = idCard;
        this.photoUrl = photoUrl;
        this.isDelete = isDelete;
        this.departId = departId;
        this.postId = postId;
        this.entryTime = entryTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public SysUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace == null ? null : nativePlace.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getDepartId() {
        return departId;
    }

    public void setDepartId(Integer departId) {
        this.departId = departId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
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