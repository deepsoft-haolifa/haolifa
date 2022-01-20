package com.deepsoft.haolifa.model.dto.pay.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author liuyaofei
 * @Date create in 下午9:53 2021/11/18
 * @description 工资查询返回对象
 */
@ApiModel(description = "工资查询返回对象")
@Data
@EqualsAndHashCode()
public class PayWagesSearchResVO {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "序号")
    private String serial;
    @ApiModelProperty(value = "部门")
    private String department;
    @ApiModelProperty(value = "用户ID")
    private Integer userId;
    @ApiModelProperty(value = "姓名")
    private String userName;
    @ApiModelProperty(value = "工资月份")
    private Date wagesMonth;
    @ApiModelProperty(value = "应出勤天数")
    private Integer requiredAttendanceDays;
    @ApiModelProperty(value = "实出勤天数")
    private Integer actualAttendanceDays;
    @ApiModelProperty(value = "出道早退次数")
    private Integer lateAndLeaveTimes;
    @ApiModelProperty(value = "迟到早退罚款")
    private BigDecimal lateAndLeaveFine;
    @ApiModelProperty(value = "旷工次数")
    private Integer absenteeismTimes;
    @ApiModelProperty(value = "旷工罚款")
    private BigDecimal absenteeismFine;
    @ApiModelProperty(value = "全勤奖")
    private BigDecimal fullAttendanceMoney;
    @ApiModelProperty(value = "计件定额数量")
    private Integer byPieceCount;
    @ApiModelProperty(value = "计件定额金额")
    private BigDecimal byPieceMoney;
    @ApiModelProperty(value = "岗位工资派工单数量")
    private Integer temporaryDispatchCount;
    @ApiModelProperty(value = "岗位工资派工单金额")
    private BigDecimal temporaryDispatchMoney;
    @ApiModelProperty(value = "零工工资零工数量")
    private Integer oddJobCount;
    @ApiModelProperty(value = "零工工资零工金额")
    private BigDecimal oddJobMoney;
    @ApiModelProperty(value = "工废扣款工废数量")
    private Integer industrialWasteCount;
    @ApiModelProperty(value = "工废扣款工废金额")
    private BigDecimal industrialWasteMoney;
    @ApiModelProperty(value = "最底生活保障金")
    private BigDecimal minLiveSecurityFund;
    @ApiModelProperty(value = "计提的绩效工资")
    private BigDecimal accruedPerformanceSalary;
    @ApiModelProperty(value = "总计工资")
    private BigDecimal totalMoney;
    @ApiModelProperty(value = "嘉奖")
    private BigDecimal commendationMoney;
    @ApiModelProperty(value = "午餐补贴")
    private BigDecimal lunchAllowanceMoney;
    @ApiModelProperty(value = "加班费")
    private BigDecimal overtimePayMoney;
    @ApiModelProperty(value = "其他补贴")
    private BigDecimal otherSubsidiesMoney;
    @ApiModelProperty(value = "应发合计")
    private BigDecimal totalPayableMoney;
    @ApiModelProperty(value = "扣个人保险")
    private BigDecimal deductPersonalInsuranceMoney;
    @ApiModelProperty(value = "应纳税合计")
    private BigDecimal totalTaxPayableMoney;
    @ApiModelProperty(value = "应纳税工资")
    private BigDecimal taxableWagesMoney;
    @ApiModelProperty(value = "扣个人所得税")
    private BigDecimal deductionPersonalIncomeTax;
    @ApiModelProperty(value = "实发工资")
    private BigDecimal netSalaryMoney;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;
}
