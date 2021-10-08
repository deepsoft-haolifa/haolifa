package com.deepsoft.haolifa.model.dto.pay;

import com.deepsoft.haolifa.model.dto.BaseCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
@ApiModel(description = "工资明细DTO")
@Data
@EqualsAndHashCode(callSuper=true)
public class PayWagesDTO extends BaseCondition {
    @ApiModelProperty(name = "部门")
    private String department;
    @ApiModelProperty(name = "姓名")
    private String userName;
    @ApiModelProperty(name = "应出勤天数")
    private Integer requiredAttendanceDays;
    @ApiModelProperty(name = "实出勤天数")
    private Integer actualAttendanceDays;
    @ApiModelProperty(name = "迟到早退次数")
    private Integer lateAndLeaveTimes;
    @ApiModelProperty(name = "旷工次数")
    private Integer absenteeismTimes;
    @ApiModelProperty(name = "计件定额数量")
    private Integer byPieceCount;
    @ApiModelProperty(name = "计件定额金额")
    private BigDecimal byPieceMoney;
    @ApiModelProperty(name = "岗位工资派工单数量")
    private Integer temporaryDispatchCount;
    @ApiModelProperty(name = "岗位工资派工单金额")
    private BigDecimal temporaryDispatchMoney;
    @ApiModelProperty(name = "零工工资零工数量")
    private Integer oddJobCount;
    @ApiModelProperty(name = "零工工资零工金额")
    private BigDecimal oddJobMoney;
    @ApiModelProperty(name = "工废扣款工废数量")
    private Integer industrialWasteCount;
    @ApiModelProperty(name = "工废扣款工废金额")
    private BigDecimal industrialWasteMoney;
    @ApiModelProperty(value = "创建开始时间")
    private String startCreateTime;
    @ApiModelProperty(value = "创建结束时间")
    private String endCreateTime;

}
