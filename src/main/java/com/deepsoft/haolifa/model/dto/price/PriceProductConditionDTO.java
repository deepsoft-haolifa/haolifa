package com.deepsoft.haolifa.model.dto.price;

import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PriceProductConditionDTO extends PageParam {

    @ApiModelProperty(value = "型号")
    private String productModel;

    @ApiModelProperty(value = "产品号")
    private String productNo;
}

