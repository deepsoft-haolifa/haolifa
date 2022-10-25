package com.deepsoft.haolifa.model.dto.pay;

import com.deepsoft.haolifa.model.dto.BaseCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
@Data
@EqualsAndHashCode(callSuper=true)
@ApiModel(description = "工资明细DTO")
public class PayWagesDTO extends BaseCondition {
    @ApiModelProperty(value = "部门")
    private String department;
    @ApiModelProperty(value = "姓名")
    private String userName;
    @ApiModelProperty(value = "应出勤天数")
    private Integer requiredAttendanceDays;
    @ApiModelProperty(value = "实出勤天数")
    private Integer actualAttendanceDays;
    @ApiModelProperty(value = "迟到早退次数")
    private Integer lateAndLeaveTimes;
    @ApiModelProperty(value = "旷工次数")
    private Integer absenteeismTimes;
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
    @ApiModelProperty(value = "创建开始时间")
    private String startCreateTime;
    @ApiModelProperty(value = "创建结束时间")
    private String endCreateTime;
    @ApiModelProperty(value = "年份")
    private String wagesYear;
    @ApiModelProperty(value = "月份")
    private String wagesMonth;

}
