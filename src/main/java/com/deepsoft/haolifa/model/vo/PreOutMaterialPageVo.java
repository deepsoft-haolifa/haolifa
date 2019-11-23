package com.deepsoft.haolifa.model.vo;

import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 零件待出库 实体
 *
 * @author murphy.he
 **/
@Data
public class PreOutMaterialPageVo extends PageParam {
    
    @ApiModelProperty(value = "订单号、委托单号")
    private String busNo;

    @ApiModelProperty(value = "图号")
    private String graphNo;

    @ApiModelProperty(value = "零件名称")
    private String materialName;

    @ApiModelProperty(value = "批次号")
    private String batchNumber;

    @ApiModelProperty(value = "类型（1.领料单出库；2.机加工委托；3.喷涂委托）")
    private Integer type;
}
