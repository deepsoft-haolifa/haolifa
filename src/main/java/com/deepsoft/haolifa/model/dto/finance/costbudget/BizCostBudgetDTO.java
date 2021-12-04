package com.deepsoft.haolifa.model.dto.finance.costbudget;


import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 费用预算
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class BizCostBudgetDTO  extends PageParam {


    @ApiModelProperty(value = "ID")
    private Integer id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "日期")
    private Date d;

    @ApiModelProperty(value = "年")
    private String y;

    @ApiModelProperty(value = "月")
    private String m;

    @ApiModelProperty(value = "组织机构id")
    private Integer deptId;

    @ApiModelProperty(value = "科目id")
    private Integer subjectsId;

    @ApiModelProperty(value = "费用")
    private BigDecimal amount;

    @ApiModelProperty(value = "状态（0正常 1停用）")
    private String status;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "删除标志（0代表存在 2代表删除")
    private String delFlag;

    @ApiModelProperty(value = "创建者")
    private Integer createUser;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新者")
    private Integer updateUser;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
