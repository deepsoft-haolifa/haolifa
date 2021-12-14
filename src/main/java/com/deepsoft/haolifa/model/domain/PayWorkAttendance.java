package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class PayWorkAttendance {
    private Integer id;

    private Integer serial;

    private String department;

    private Integer userId;

    private String userName;

    private Integer attendanceDays;

    private Integer lateTimes;

    private Integer leaveEarlyTimes;

    private Integer absenteeismTimes;

    private Integer middleDays;

    private Integer nightDays;

    private Integer businessTravelDays;

    private Integer compassionateLeaveDays;

    private Integer sickLeaveDays;

    private Integer workOvertimeDays;

    private Integer lateAndLeaveTimes;

    private String remark;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;

    public PayWorkAttendance(Integer id, Integer serial, String department, Integer userId, String userName, Integer attendanceDays, Integer lateTimes, Integer leaveEarlyTimes, Integer absenteeismTimes, Integer middleDays, Integer nightDays, Integer businessTravelDays, Integer compassionateLeaveDays, Integer sickLeaveDays, Integer workOvertimeDays, Integer lateAndLeaveTimes, String remark, String createUser, String updateUser, Date createTime, Date updateTime) {
        this.id = id;
        this.serial = serial;
        this.department = department;
        this.userId = userId;
        this.userName = userName;
        this.attendanceDays = attendanceDays;
        this.lateTimes = lateTimes;
        this.leaveEarlyTimes = leaveEarlyTimes;
        this.absenteeismTimes = absenteeismTimes;
        this.middleDays = middleDays;
        this.nightDays = nightDays;
        this.businessTravelDays = businessTravelDays;
        this.compassionateLeaveDays = compassionateLeaveDays;
        this.sickLeaveDays = sickLeaveDays;
        this.workOvertimeDays = workOvertimeDays;
        this.lateAndLeaveTimes = lateAndLeaveTimes;
        this.remark = remark;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public PayWorkAttendance() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getAttendanceDays() {
        return attendanceDays;
    }

    public void setAttendanceDays(Integer attendanceDays) {
        this.attendanceDays = attendanceDays;
    }

    public Integer getLateTimes() {
        return lateTimes;
    }

    public void setLateTimes(Integer lateTimes) {
        this.lateTimes = lateTimes;
    }

    public Integer getLeaveEarlyTimes() {
        return leaveEarlyTimes;
    }

    public void setLeaveEarlyTimes(Integer leaveEarlyTimes) {
        this.leaveEarlyTimes = leaveEarlyTimes;
    }

    public Integer getAbsenteeismTimes() {
        return absenteeismTimes;
    }

    public void setAbsenteeismTimes(Integer absenteeismTimes) {
        this.absenteeismTimes = absenteeismTimes;
    }

    public Integer getMiddleDays() {
        return middleDays;
    }

    public void setMiddleDays(Integer middleDays) {
        this.middleDays = middleDays;
    }

    public Integer getNightDays() {
        return nightDays;
    }

    public void setNightDays(Integer nightDays) {
        this.nightDays = nightDays;
    }

    public Integer getBusinessTravelDays() {
        return businessTravelDays;
    }

    public void setBusinessTravelDays(Integer businessTravelDays) {
        this.businessTravelDays = businessTravelDays;
    }

    public Integer getCompassionateLeaveDays() {
        return compassionateLeaveDays;
    }

    public void setCompassionateLeaveDays(Integer compassionateLeaveDays) {
        this.compassionateLeaveDays = compassionateLeaveDays;
    }

    public Integer getSickLeaveDays() {
        return sickLeaveDays;
    }

    public void setSickLeaveDays(Integer sickLeaveDays) {
        this.sickLeaveDays = sickLeaveDays;
    }

    public Integer getWorkOvertimeDays() {
        return workOvertimeDays;
    }

    public void setWorkOvertimeDays(Integer workOvertimeDays) {
        this.workOvertimeDays = workOvertimeDays;
    }

    public Integer getLateAndLeaveTimes() {
        return lateAndLeaveTimes;
    }

    public void setLateAndLeaveTimes(Integer lateAndLeaveTimes) {
        this.lateAndLeaveTimes = lateAndLeaveTimes;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
