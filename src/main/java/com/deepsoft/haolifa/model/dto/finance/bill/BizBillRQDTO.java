package com.deepsoft.haolifa.model.dto.finance.bill;


import com.deepsoft.haolifa.model.dto.DepartmentDTO;
import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 现金日记账
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class BizBillRQDTO extends PageParam {


    @ApiModelProperty(value = "凭证号")
    private String certificateNumber;

    @ApiModelProperty(value = "收款单位")
    private String collectionCompany;

    @ApiModelProperty(value = "付款类别")
    private String paymentType;
    @ApiModelProperty(value = "付款单位")
    private String paymentCompany;

    @ApiModelProperty(value = "部门ID")
    private String deptId;



}
