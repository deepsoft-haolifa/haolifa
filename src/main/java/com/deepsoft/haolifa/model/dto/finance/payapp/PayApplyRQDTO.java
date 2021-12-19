package com.deepsoft.haolifa.model.dto.finance.payapp;

import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


/***
 * 付款申请-查询条件
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PayApplyRQDTO extends PageParam {


    @ApiModelProperty(value = "审核状态")
    private String status;


}
