package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class PayWages {
    private Integer id;

    private String serial;

    private String department;

    private String userName;

    private Integer requiredAttendanceDays;

    private Integer actualAttendanceDays;

    private Integer lateAndLeaveTimes;

    private BigDecimal lateAndLeaveFine;

    private Integer absenteeismTimes;

    private BigDecimal absenteeismFine;

    private BigDecimal fullAttendanceMoney;

    private Integer byPieceCount;

    private BigDecimal byPieceMoney;

    private Integer temporaryDispatchCount;

    private BigDecimal temporaryDispatchMoney;

    private Integer oddJobCount;

    private BigDecimal oddJobMoney;

    private Integer industrialWasteCount;

    private BigDecimal industrialWasteMoney;

    private BigDecimal minLiveSecurityFund;

    private BigDecimal accruedPerformanceSalary;

    private BigDecimal totalMoney;

    private BigDecimal commendationMoney;

    private BigDecimal lunchAllowanceMoney;

    private BigDecimal overtimePayMoney;

    private BigDecimal otherSubsidiesMoney;

    private BigDecimal totalPayableMoney;

    private BigDecimal deductPersonalInsuranceMoney;

    private BigDecimal totalTaxPayableMoney;

    private BigDecimal taxableWagesMoney;

    private BigDecimal deductionPersonalIncomeTax;

    private BigDecimal netSalaryMoney;

    private String remark;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;

    private String wagesYear;

    private String wagesMonth;

    private Integer userId;

    public PayWages(Integer id, String serial, String department, String userName, Integer requiredAttendanceDays, Integer actualAttendanceDays, Integer lateAndLeaveTimes, BigDecimal lateAndLeaveFine, Integer absenteeismTimes, BigDecimal absenteeismFine, BigDecimal fullAttendanceMoney, Integer byPieceCount, BigDecimal byPieceMoney, Integer temporaryDispatchCount, BigDecimal temporaryDispatchMoney, Integer oddJobCount, BigDecimal oddJobMoney, Integer industrialWasteCount, BigDecimal industrialWasteMoney, BigDecimal minLiveSecurityFund, BigDecimal accruedPerformanceSalary, BigDecimal totalMoney, BigDecimal commendationMoney, BigDecimal lunchAllowanceMoney, BigDecimal overtimePayMoney, BigDecimal otherSubsidiesMoney, BigDecimal totalPayableMoney, BigDecimal deductPersonalInsuranceMoney, BigDecimal totalTaxPayableMoney, BigDecimal taxableWagesMoney, BigDecimal deductionPersonalIncomeTax, BigDecimal netSalaryMoney, String remark, String createUser, String updateUser, Date createTime, Date updateTime, String wagesYear, String wagesMonth, Integer userId) {
        this.id = id;
        this.serial = serial;
        this.department = department;
        this.userName = userName;
        this.requiredAttendanceDays = requiredAttendanceDays;
        this.actualAttendanceDays = actualAttendanceDays;
        this.lateAndLeaveTimes = lateAndLeaveTimes;
        this.lateAndLeaveFine = lateAndLeaveFine;
        this.absenteeismTimes = absenteeismTimes;
        this.absenteeismFine = absenteeismFine;
        this.fullAttendanceMoney = fullAttendanceMoney;
        this.byPieceCount = byPieceCount;
        this.byPieceMoney = byPieceMoney;
        this.temporaryDispatchCount = temporaryDispatchCount;
        this.temporaryDispatchMoney = temporaryDispatchMoney;
        this.oddJobCount = oddJobCount;
        this.oddJobMoney = oddJobMoney;
        this.industrialWasteCount = industrialWasteCount;
        this.industrialWasteMoney = industrialWasteMoney;
        this.minLiveSecurityFund = minLiveSecurityFund;
        this.accruedPerformanceSalary = accruedPerformanceSalary;
        this.totalMoney = totalMoney;
        this.commendationMoney = commendationMoney;
        this.lunchAllowanceMoney = lunchAllowanceMoney;
        this.overtimePayMoney = overtimePayMoney;
        this.otherSubsidiesMoney = otherSubsidiesMoney;
        this.totalPayableMoney = totalPayableMoney;
        this.deductPersonalInsuranceMoney = deductPersonalInsuranceMoney;
        this.totalTaxPayableMoney = totalTaxPayableMoney;
        this.taxableWagesMoney = taxableWagesMoney;
        this.deductionPersonalIncomeTax = deductionPersonalIncomeTax;
        this.netSalaryMoney = netSalaryMoney;
        this.remark = remark;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.wagesYear = wagesYear;
        this.wagesMonth = wagesMonth;
        this.userId = userId;
    }

    public PayWages() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial == null ? null : serial.trim();
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

    public Integer getRequiredAttendanceDays() {
        return requiredAttendanceDays;
    }

    public void setRequiredAttendanceDays(Integer requiredAttendanceDays) {
        this.requiredAttendanceDays = requiredAttendanceDays;
    }

    public Integer getActualAttendanceDays() {
        return actualAttendanceDays;
    }

    public void setActualAttendanceDays(Integer actualAttendanceDays) {
        this.actualAttendanceDays = actualAttendanceDays;
    }

    public Integer getLateAndLeaveTimes() {
        return lateAndLeaveTimes;
    }

    public void setLateAndLeaveTimes(Integer lateAndLeaveTimes) {
        this.lateAndLeaveTimes = lateAndLeaveTimes;
    }

    public BigDecimal getLateAndLeaveFine() {
        return lateAndLeaveFine;
    }

    public void setLateAndLeaveFine(BigDecimal lateAndLeaveFine) {
        this.lateAndLeaveFine = lateAndLeaveFine;
    }

    public Integer getAbsenteeismTimes() {
        return absenteeismTimes;
    }

    public void setAbsenteeismTimes(Integer absenteeismTimes) {
        this.absenteeismTimes = absenteeismTimes;
    }

    public BigDecimal getAbsenteeismFine() {
        return absenteeismFine;
    }

    public void setAbsenteeismFine(BigDecimal absenteeismFine) {
        this.absenteeismFine = absenteeismFine;
    }

    public BigDecimal getFullAttendanceMoney() {
        return fullAttendanceMoney;
    }

    public void setFullAttendanceMoney(BigDecimal fullAttendanceMoney) {
        this.fullAttendanceMoney = fullAttendanceMoney;
    }

    public Integer getByPieceCount() {
        return byPieceCount;
    }

    public void setByPieceCount(Integer byPieceCount) {
        this.byPieceCount = byPieceCount;
    }

    public BigDecimal getByPieceMoney() {
        return byPieceMoney;
    }

    public void setByPieceMoney(BigDecimal byPieceMoney) {
        this.byPieceMoney = byPieceMoney;
    }

    public Integer getTemporaryDispatchCount() {
        return temporaryDispatchCount;
    }

    public void setTemporaryDispatchCount(Integer temporaryDispatchCount) {
        this.temporaryDispatchCount = temporaryDispatchCount;
    }

    public BigDecimal getTemporaryDispatchMoney() {
        return temporaryDispatchMoney;
    }

    public void setTemporaryDispatchMoney(BigDecimal temporaryDispatchMoney) {
        this.temporaryDispatchMoney = temporaryDispatchMoney;
    }

    public Integer getOddJobCount() {
        return oddJobCount;
    }

    public void setOddJobCount(Integer oddJobCount) {
        this.oddJobCount = oddJobCount;
    }

    public BigDecimal getOddJobMoney() {
        return oddJobMoney;
    }

    public void setOddJobMoney(BigDecimal oddJobMoney) {
        this.oddJobMoney = oddJobMoney;
    }

    public Integer getIndustrialWasteCount() {
        return industrialWasteCount;
    }

    public void setIndustrialWasteCount(Integer industrialWasteCount) {
        this.industrialWasteCount = industrialWasteCount;
    }

    public BigDecimal getIndustrialWasteMoney() {
        return industrialWasteMoney;
    }

    public void setIndustrialWasteMoney(BigDecimal industrialWasteMoney) {
        this.industrialWasteMoney = industrialWasteMoney;
    }

    public BigDecimal getMinLiveSecurityFund() {
        return minLiveSecurityFund;
    }

    public void setMinLiveSecurityFund(BigDecimal minLiveSecurityFund) {
        this.minLiveSecurityFund = minLiveSecurityFund;
    }

    public BigDecimal getAccruedPerformanceSalary() {
        return accruedPerformanceSalary;
    }

    public void setAccruedPerformanceSalary(BigDecimal accruedPerformanceSalary) {
        this.accruedPerformanceSalary = accruedPerformanceSalary;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public BigDecimal getCommendationMoney() {
        return commendationMoney;
    }

    public void setCommendationMoney(BigDecimal commendationMoney) {
        this.commendationMoney = commendationMoney;
    }

    public BigDecimal getLunchAllowanceMoney() {
        return lunchAllowanceMoney;
    }

    public void setLunchAllowanceMoney(BigDecimal lunchAllowanceMoney) {
        this.lunchAllowanceMoney = lunchAllowanceMoney;
    }

    public BigDecimal getOvertimePayMoney() {
        return overtimePayMoney;
    }

    public void setOvertimePayMoney(BigDecimal overtimePayMoney) {
        this.overtimePayMoney = overtimePayMoney;
    }

    public BigDecimal getOtherSubsidiesMoney() {
        return otherSubsidiesMoney;
    }

    public void setOtherSubsidiesMoney(BigDecimal otherSubsidiesMoney) {
        this.otherSubsidiesMoney = otherSubsidiesMoney;
    }

    public BigDecimal getTotalPayableMoney() {
        return totalPayableMoney;
    }

    public void setTotalPayableMoney(BigDecimal totalPayableMoney) {
        this.totalPayableMoney = totalPayableMoney;
    }

    public BigDecimal getDeductPersonalInsuranceMoney() {
        return deductPersonalInsuranceMoney;
    }

    public void setDeductPersonalInsuranceMoney(BigDecimal deductPersonalInsuranceMoney) {
        this.deductPersonalInsuranceMoney = deductPersonalInsuranceMoney;
    }

    public BigDecimal getTotalTaxPayableMoney() {
        return totalTaxPayableMoney;
    }

    public void setTotalTaxPayableMoney(BigDecimal totalTaxPayableMoney) {
        this.totalTaxPayableMoney = totalTaxPayableMoney;
    }

    public BigDecimal getTaxableWagesMoney() {
        return taxableWagesMoney;
    }

    public void setTaxableWagesMoney(BigDecimal taxableWagesMoney) {
        this.taxableWagesMoney = taxableWagesMoney;
    }

    public BigDecimal getDeductionPersonalIncomeTax() {
        return deductionPersonalIncomeTax;
    }

    public void setDeductionPersonalIncomeTax(BigDecimal deductionPersonalIncomeTax) {
        this.deductionPersonalIncomeTax = deductionPersonalIncomeTax;
    }

    public BigDecimal getNetSalaryMoney() {
        return netSalaryMoney;
    }

    public void setNetSalaryMoney(BigDecimal netSalaryMoney) {
        this.netSalaryMoney = netSalaryMoney;
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

    public String getWagesYear() {
        return wagesYear;
    }

    public void setWagesYear(String wagesYear) {
        this.wagesYear = wagesYear == null ? null : wagesYear.trim();
    }

    public String getWagesMonth() {
        return wagesMonth;
    }

    public void setWagesMonth(String wagesMonth) {
        this.wagesMonth = wagesMonth == null ? null : wagesMonth.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}