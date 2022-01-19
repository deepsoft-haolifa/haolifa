package com.deepsoft.haolifa.model.dto.valveSeat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author murphy.he
 **/
@Data
public class ValveSeatEntrustReqDto {
    /**
     * id
     */
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 产品名称
     */
    @ApiModelProperty("产品名称")
    private String name;

    /**
     * 图号
     */
    @ApiModelProperty("图号")
    private String graphNo;

    /**
     * 规格
     */
    @ApiModelProperty("规格")
    private String specifications;

    /**
     * 型号
     */
    @ApiModelProperty("型号")
    private String model;

    /**
     * 数量
     */
    @ApiModelProperty("数量")
    private Integer qty;


}
