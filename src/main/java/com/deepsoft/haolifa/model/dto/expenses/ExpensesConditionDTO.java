package com.deepsoft.haolifa.model.dto.expenses;

import com.deepsoft.haolifa.model.dto.report.ReportBaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 费用信息接口查询
 * @author murphy.he
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ExpensesConditionDTO extends ReportBaseDTO {
    @ApiModelProperty(value = "一级分类名称, 搜索全部时值：全部")
    private String classifyName;
    @ApiModelProperty(value = "二级分类名称，搜索全部时值：全部")
    private String secondClassifyName;
    @ApiModelProperty("报销人")
    private String commitUser;
    @ApiModelProperty("凭证号")
    private String voucherNo;
    @ApiModelProperty("部门名称")
    private String department;
}
