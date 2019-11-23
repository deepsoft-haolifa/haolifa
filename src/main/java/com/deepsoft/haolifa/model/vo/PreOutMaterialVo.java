package com.deepsoft.haolifa.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 零件待出库 实体
 *
 * @author murphy.he
 **/
@Data
public class PreOutMaterialVo {

    @ApiModelProperty(value = "订单号、委托单号")
    private String busNo;

    @ApiModelProperty(value = "图号")
    private String graphNo;

    @ApiModelProperty(value = "零件名称")
    private String materialName;

    @ApiModelProperty(value = "出库数量")
    private Integer outQuantity;

    @ApiModelProperty(value = "批次号")
    private String batchNumber;

    @ApiModelProperty(value = "领料单位")
    private String deptName;

    @ApiModelProperty(value = "类型（1.领料单出库；2.机加工委托；3.喷涂委托）")
    private Integer type;

    @ApiModelProperty(value = "状态")
    private Integer status;
}
