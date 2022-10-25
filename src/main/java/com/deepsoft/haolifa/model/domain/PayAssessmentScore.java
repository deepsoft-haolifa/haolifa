package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class PayAssessmentScore {
    private Integer id;

    private Integer assessmentId;

    private Integer userId;

    private String scoreYear;

    private String scoreMonth;

    private Integer score;

    private Date scoreTime;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;

    public PayAssessmentScore(Integer id, Integer assessmentId, Integer userId, String scoreYear, String scoreMonth, Integer score, Date scoreTime, String createUser, String updateUser, Date createTime, Date updateTime) {
        this.id = id;
        this.assessmentId = assessmentId;
        this.userId = userId;
        this.scoreYear = scoreYear;
        this.scoreMonth = scoreMonth;
        this.score = score;
        this.scoreTime = scoreTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public PayAssessmentScore() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(Integer assessmentId) {
        this.assessmentId = assessmentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getScoreYear() {
        return scoreYear;
    }

    public void setScoreYear(String scoreYear) {
        this.scoreYear = scoreYear == null ? null : scoreYear.trim();
    }

    public String getScoreMonth() {
        return scoreMonth;
    }

    public void setScoreMonth(String scoreMonth) {
        this.scoreMonth = scoreMonth == null ? null : scoreMonth.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getScoreTime() {
        return scoreTime;
    }

    public void setScoreTime(Date scoreTime) {
        this.scoreTime = scoreTime;
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