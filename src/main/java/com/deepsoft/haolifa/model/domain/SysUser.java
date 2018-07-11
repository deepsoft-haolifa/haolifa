package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class SysUser {
    private Long id;

    private String username;

    private String password;

    private Date ctime;

    private Date utime;

    public SysUser(Long id, String username, String password, Date ctime, Date utime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.ctime = ctime;
        this.utime = utime;
    }

    public SysUser() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}