package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @className: ProductMaterialDTO
 * @description: 成品零件配置实体
 * @author: hedong@ibeesaas.com
 * @date: 2018-10-15 10:22
 **/
@Data
public class ProductMaterialDTO {

    @ApiModelProperty(value = "零件图号", required = true)
    private String materialGraphNo;
    @ApiModelProperty(value = "零件数量", required = true)
    private Integer materialCount;
    @ApiModelProperty(value = "该零件可替换的图号")
    private String replaceMaterialGraphNo;
}
