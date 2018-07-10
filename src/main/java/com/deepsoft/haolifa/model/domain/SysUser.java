package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class SysUser {
    private Integer id;

    private String loginName;

    private String password;

    private String userName;

    private Byte gender;

    private String email;

    private String phone;

    private Date ctime;

    private Date utime;

    private Integer createUserId;

    private Integer modifyUserId;

    private Byte isDelete;

    public SysUser(Integer id, String loginName, String password, String userName, Byte gender, String email, String phone, Date ctime, Date utime, Integer createUserId, Integer modifyUserId, Byte isDelete) {
        this.id = id;
        this.loginName = loginName;
        this.password = password;
        this.userName = userName;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.ctime = ctime;
        this.utime = utime;
        this.createUserId = createUserId;
        this.modifyUserId = modifyUserId;
        this.isDelete = isDelete;
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

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}