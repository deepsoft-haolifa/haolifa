package com.deepsoft.haolifa.model.dto.finance.payapp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

/***
 * 付款申请-添加
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PayApplyAddDTO {

    @ApiModelProperty(value = "付款金额")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "详情")
    private List<PayApplyDetailAddDTO> applyDetailAddDTOList;

}
