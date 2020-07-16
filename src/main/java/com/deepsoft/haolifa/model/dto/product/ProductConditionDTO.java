package com.deepsoft.haolifa.model.dto.product;

import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @className: ProductMaterialDTO
 * @description: 成品零件配置实体
 * @author: hedong@ibeesaas.com
 * @date: 2018-10-15 10:22
 **/
@Data
@EqualsAndHashCode
public class ProductConditionDTO extends PageParam {
    @ApiModelProperty(value = "成品名称", required = true)
    private String name;
    @ApiModelProperty(value = "成品号（全局唯一）", required = true)
    private String productNo;
    @ApiModelProperty(value = "成品型号")
    private String productModel;
    @ApiModelProperty(value = "成品规格（如：DN65，DN80）")
    private String specifications;
}
