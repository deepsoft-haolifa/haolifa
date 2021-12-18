package com.deepsoft.haolifa.model.dto.finance.payplan;

import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/***
 * 应付汇总 rq
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizPayPlanSummaryRQDTO extends PageParam {


    @ApiModelProperty(value = "申请编号")
    private String applyNo;

    // query
    @ApiModelProperty(value = "查询条件-开始日期")
    private Date applyDateStart;
    @ApiModelProperty(value = "查询条件-结束日期")
    private Date applyDateEnd;
    @ApiModelProperty(value = "采购合同ID")
    private String contractId;

    @ApiModelProperty(value = "采购合同号")
    private String contractNo;

    @ApiModelProperty(value = "申请付款单位")
    private String applyPayCompany;

    @ApiModelProperty(value = "收款单位")
    private String applyCollectionCompany;

    @ApiModelProperty(value = "付款方式;")
    private String payWay;

    @ApiModelProperty(value = "付款状态 0.未付；1.付款中 2已付款")
    private String status;

    @ApiModelProperty(value = "数据状态：1. 老总选择； 2. 财务主管选择；3.出纳付款")
    private String dataStatus;

}
