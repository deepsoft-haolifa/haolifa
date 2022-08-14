package com.deepsoft.haolifa.model.dto.technicalDetailed;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class TechnicalDetailedConditionDTO {
    @ApiModelProperty(value = "页码，从1开始")
    private Integer pageNum = 1;
    @ApiModelProperty(value = "页面大小")
    private Integer pageSize = 20;

    /**
     * 产品名称
     */
    @ApiModelProperty("产品名称")
    private String productName;

    /**
     * 型号
     */
    @ApiModelProperty("型号")
    private String productModel;

    /**
     * 规格
     */
    @ApiModelProperty("规格")
    private String specifications;

    /**
     * 执行器型号
     */
    @ApiModelProperty("执行器型号")
    private String actuatorModel;
}
