package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class Role {
    private Long id;

    private String name;

    private Date ctime;

    private Date utime;

    public Role(Long id, String name, Date ctime, Date utime) {
        this.id = id;
        this.name = name;
        this.ctime = ctime;
        this.utime = utime;
    }

    public Role() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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