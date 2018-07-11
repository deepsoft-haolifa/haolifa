package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class Permission {
    private Long id;

    private String name;

    private String description;

    private String url;

    private Long pid;

    private Date ctime;

    private Date utime;

    public Permission(Long id, String name, String description, String url, Long pid, Date ctime, Date utime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.pid = pid;
        this.ctime = ctime;
        this.utime = utime;
    }

    public Permission(Long id, String name, String description, String url, Long pid) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.pid = pid;
    }

    public Permission() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
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