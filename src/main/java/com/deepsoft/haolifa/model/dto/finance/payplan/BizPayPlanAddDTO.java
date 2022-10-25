package com.deepsoft.haolifa.model.dto.finance.payplan;

import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/***
 * 付款计划-添加
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizPayPlanAddDTO extends PageParam {


    @ApiModelProperty(value = "公司（收款是收款公司，付款是付款公司")
    private String company;


}
