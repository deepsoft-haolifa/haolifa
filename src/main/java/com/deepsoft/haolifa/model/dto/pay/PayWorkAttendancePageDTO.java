package com.deepsoft.haolifa.model.dto.pay;

import com.deepsoft.haolifa.annotation.ExcelHandle;
import com.deepsoft.haolifa.model.dto.BaseCondition;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author liuyaofei
 * @Date create in 上午11:57 2021/9/11
 * @description 考勤表
 */
@ApiModel(description = "考勤表")
@Data
@EqualsAndHashCode(callSuper=true)
public class PayWorkAttendancePageDTO extends BaseCondition {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ExcelHandle(name = "序号")
    @ApiModelProperty(value = "序号")
    private Integer serial;
    @ExcelHandle(name = "部门")
    @ApiModelProperty(value = "部门")
    private String department;
    @ApiModelProperty(value = "用户ID")
    @ExcelHandle(name = "用户ID")
    private Integer userId;
    @ApiModelProperty(value = "姓名")
    @ExcelHandle(name = "姓名")
    private String userName;
    @ApiModelProperty(value = "年份")
    @ExcelHandle(name = "年份")
    private String attendYear;
    @ApiModelProperty(value = "月份")
    @ExcelHandle(name = "月份")
    private String attendMonth;
    @ApiModelProperty(value = "出勤天数")
    @ExcelHandle(name = "出勤天数")
    private Integer attendanceDays;
    @ApiModelProperty(value = "迟到次数")
    @ExcelHandle(name = "迟到次数")
    private Integer lateTimes;
    @ApiModelProperty(value = "早退次数")
    @ExcelHandle(name = "早退次数")
    private Integer leaveEarlyTimes;
    @ApiModelProperty(value = "旷工次数")
    @ExcelHandle(name = "旷工次数")
    private Integer absenteeismTimes;
    @ApiModelProperty(value = "中班天数")
    @ExcelHandle(name = "中班天数")
    private Integer middleDays;
    @ApiModelProperty(value = "夜班天数")
    @ExcelHandle(name = "夜班天数")
    private Integer nightDays;
    @ApiModelProperty(value = "出差天数")
    @ExcelHandle(name = "出差天数")
    private Integer businessTravelDays;
    @ApiModelProperty(value = "事假天数")
    @ExcelHandle(name = "事假天数")
    private Integer compassionateLeaveDays;
    @ApiModelProperty(value = "病假天数")
    @ExcelHandle(name = "病假天数")
    private Integer sickLeaveDays;
    @ApiModelProperty(value = "加班天数")
    @ExcelHandle(name = "加班天数")
    private Integer workOvertimeDays;
    @ApiModelProperty(value = "迟到早退次数")
    @ExcelHandle(name = "迟到早退次数")
    private Integer lateAndLeaveTimes;
    @ApiModelProperty(value = "备注")
    @ExcelHandle(name = "备注")
    private String remark;
}
