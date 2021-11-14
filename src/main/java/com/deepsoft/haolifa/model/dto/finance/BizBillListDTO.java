package com.deepsoft.haolifa.model.dto.finance;


import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 科目表
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class BizBillListDTO extends PageParam {

    @ApiModelProperty(value = "凭证号")
    private String certificateNumber;
    @ApiModelProperty(value = "付款类别")
    private String paymentType;
    @ApiModelProperty(value = "收款单位")
    private String string1;
    @ApiModelProperty(value = "付款单位")
    private String remark;
    @ApiModelProperty(value = "部门")
    private Integer deptId;

}
