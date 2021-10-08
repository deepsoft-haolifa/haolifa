package com.deepsoft.haolifa.model.domain;

import com.deepsoft.haolifa.annotation.ExcelHandle;

import java.util.Date;

public class PayWorkAttendance {
    private Integer id;
    @ExcelHandle(name = "序号")
    private Integer serial;
    @ExcelHandle(name = "部门")
    private String department;
    @ExcelHandle(name = "姓名")
    private String userName;
    @ExcelHandle(name = "出勤天数")
    private Integer attendanceDays;
    @ExcelHandle(name = "迟到次数")
    private Integer lateTimes;
    @ExcelHandle(name = "早退次数")
    private Integer leaveEarlyTimes;
    @ExcelHandle(name = "旷工次数")
    private Integer absenteeismTimes;
    @ExcelHandle(name = "中班天数")
    private Integer middleDays;
    @ExcelHandle(name = "夜班天数")
    private Integer nightDays;
    @ExcelHandle(name = "出差天数")
    private Integer businessTravelDays;
    @ExcelHandle(name = "事假天数")
    private Integer compassionateLeaveDays;
    @ExcelHandle(name = "病假天数")
    private Integer sickLeaveDays;
    @ExcelHandle(name = "加班天数")
    private Integer workOvertimeDays;
    @ExcelHandle(name = "迟到早退次数")
    private Integer lateAndLeaveTimes;
    @ExcelHandle(name = "备注")
    private String remark;
    @ExcelHandle(name = "创建人")
    private String createUser;
    @ExcelHandle(name = "修改人")
    private String updateUser;
    @ExcelHandle(name = "创建时间")
    private Date createTime;
    @ExcelHandle(name = "修改时间")
    private Date updateTime;


    public PayWorkAttendance(Integer id, Integer serial, String department, String userName, Integer attendanceDays, Integer lateTimes, Integer leaveEarlyTimes, Integer absenteeismTimes, Integer middleDays, Integer nightDays, Integer businessTravelDays, Integer compassionateLeaveDays, Integer sickLeaveDays, Integer workOvertimeDays, Integer lateAndLeaveTimes, String remark, String createUser, String updateUser, Date createTime, Date updateTime) {
        this.id = id;
        this.serial = serial;
        this.department = department;
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
