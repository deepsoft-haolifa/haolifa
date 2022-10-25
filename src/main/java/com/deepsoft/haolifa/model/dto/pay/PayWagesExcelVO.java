package com.deepsoft.haolifa.model.dto.pay;

import com.deepsoft.haolifa.annotation.ExcelHandle;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author liuyaofei
 * @Date create in 14:22 2022/4/27
 * @description excel相关VO
 */
@ApiModel(description = "工资excel相关VO")
@Data
@EqualsAndHashCode()
public class PayWagesExcelVO {
    @ExcelHandle(name = "id")
    private Integer id;
    @ExcelHandle(name = "年份")
    private String wagesYear;
    @ExcelHandle(name = "月份")
    private String wagesMonth;
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
    @ExcelHandle(name = "修改人")
    private String updateUser;
    @ExcelHandle(name = "创建时间")
    private Date createTime;
    @ExcelHandle(name = "修改时间")
    private Date updateTime;
}
