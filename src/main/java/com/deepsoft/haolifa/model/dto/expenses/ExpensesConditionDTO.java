package com.deepsoft.haolifa.model.dto.expenses;

import com.deepsoft.haolifa.model.dto.report.ReportBaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 费用信息接口查询
 * @author murphy.he
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ExpensesConditionDTO extends ReportBaseDTO{
    @ApiModelProperty(value = "页码，从1开始")
    private Integer pageNum = 1;
    @ApiModelProperty(value = "页面大小")
    private Integer pageSize = 20;
    @ApiModelProperty(value = "一级分类名称, 搜索全部时值：全部")
    private String classifyName;
    @ApiModelProperty(value = "二级分类名称，搜索全部时值：全部")
    private String secondClassifyName;
    @ApiModelProperty(value = "二级分类名称，搜索全部时值：全部")
    private List<String> secondClassifyNameList;
    @ApiModelProperty(value = "排除的二级分类名称")
    private List<String> excludeSecondClassifyNameList;
    @ApiModelProperty("报销人")
    private String commitUser;
    @ApiModelProperty("凭证号")
    private String voucherNo;
    @ApiModelProperty("部门名称")
    private String department;
}
