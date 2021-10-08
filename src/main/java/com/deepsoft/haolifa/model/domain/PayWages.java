package com.deepsoft.haolifa.model.domain;

import com.deepsoft.haolifa.annotation.ExcelHandle;

import java.math.BigDecimal;
import java.util.Date;

public class PayWages {
    private Integer id;
    @ExcelHandle(name = "序号")
    private String serial;
    @ExcelHandle(name = "部门")
    private String department;
    @ExcelHandle(name = "姓名")
    private String userName;
    @ExcelHandle(name = "应出勤天数")
    private Integer requiredAttendanceDays;
    @ExcelHandle(name = "实出勤天数")
    private Integer actualAttendanceDays;
    @ExcelHandle(name = "出道早退次数")
    private Integer lateAndLeaveTimes;
    @ExcelHandle(name = "迟到早退罚款")
    private BigDecimal lateAndLeaveFine;
    @ExcelHandle(name = "旷工次数")
    private Integer absenteeismTimes;
    @ExcelHandle(name = "旷工罚款")
    private BigDecimal absenteeismFine;
    @ExcelHandle(name = "全勤奖")
    private BigDecimal fullAttendanceMoney;
    @ExcelHandle(name = "计件定额数量")
    private Integer byPieceCount;
    @ExcelHandle(name = "计件定额金额")
    private BigDecimal byPieceMoney;
    @ExcelHandle(name = "岗位工资派工单数量")
    private Integer temporaryDispatchCount;
    @ExcelHandle(name = "岗位工资派工单金额")
    private BigDecimal temporaryDispatchMoney;
    @ExcelHandle(name = "零工工资零工数量")
    private Integer oddJobCount;
    @ExcelHandle(name = "零工工资零工金额")
    private BigDecimal oddJobMoney;
    @ExcelHandle(name = "工废扣款工废数量")
    private Integer industrialWasteCount;
    @ExcelHandle(name = "工废扣款工废金额")
    private BigDecimal industrialWasteMoney;
    @ExcelHandle(name = "最底生活保障金")
    private BigDecimal minLiveSecurityFund;
    @ExcelHandle(name = "计提的绩效工资")
    private BigDecimal accruedPerformanceSalary;
    @ExcelHandle(name = "总计工资")
    private BigDecimal totalMoney;
    @ExcelHandle(name = "嘉奖")
    private BigDecimal commendationMoney;
    @ExcelHandle(name = "午餐补贴")
    private BigDecimal lunchAllowanceMoney;
    @ExcelHandle(name = "加班费")
    private BigDecimal overtimePayMoney;
    @ExcelHandle(name = "其他补贴")
    private BigDecimal otherSubsidiesMoney;
    @ExcelHandle(name = "应发合计")
    private BigDecimal totalPayableMoney;
    @ExcelHandle(name = "扣个人保险")
    private BigDecimal deductPersonalInsuranceMoney;
    @ExcelHandle(name = "应纳税合计")
    private BigDecimal totalTaxPayableMoney;
    @ExcelHandle(name = "应纳税工资")
    private BigDecimal taxableWagesMoney;
    @ExcelHandle(name = "扣个人所得税")
    private BigDecimal deductionPersonalIncomeTax;
    @ExcelHandle(name = "实发工资")
    private BigDecimal netSalaryMoney;
    @ExcelHandle(name = "备注")
    private String remark;
    @ExcelHandle(name = "创建人")
    private String createUser;
    @ExcelHandle(name = "更新人")
    private String updateUser;
    @ExcelHandle(name = "创建时间")
    private Date createTime;
    @ExcelHandle(name = "更新日期")
    private Date updateTime;

    public PayWages(Integer id, String serial, String department, String userName, Integer requiredAttendanceDays, Integer actualAttendanceDays, Integer lateAndLeaveTimes, BigDecimal lateAndLeaveFine, Integer absenteeismTimes, BigDecimal absenteeismFine, BigDecimal fullAttendanceMoney, Integer byPieceCount, BigDecimal byPieceMoney, Integer temporaryDispatchCount, BigDecimal temporaryDispatchMoney, Integer oddJobCount, BigDecimal oddJobMoney, Integer industrialWasteCount, BigDecimal industrialWasteMoney, BigDecimal minLiveSecurityFund, BigDecimal accruedPerformanceSalary, BigDecimal totalMoney, BigDecimal commendationMoney, BigDecimal lunchAllowanceMoney, BigDecimal overtimePayMoney, BigDecimal otherSubsidiesMoney, BigDecimal totalPayableMoney, BigDecimal deductPersonalInsuranceMoney, BigDecimal totalTaxPayableMoney, BigDecimal taxableWagesMoney, BigDecimal deductionPersonalIncomeTax, BigDecimal netSalaryMoney, String remark, String createUser, String updateUser, Date createTime, Date updateTime) {
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
}
