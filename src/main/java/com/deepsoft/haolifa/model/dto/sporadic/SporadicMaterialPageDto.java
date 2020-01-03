package com.deepsoft.haolifa.model.dto.sporadic;

import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author murphy.he
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SporadicMaterialPageDto extends PageParam {

    @ApiModelProperty(value = "零件分类名称")
    private String classifyName;

    @ApiModelProperty(value = "零件名称")
    private String materialName;

    @ApiModelProperty(value = "规格")
    private String specifications;

    @ApiModelProperty(value = "型号")
    private String model;
}
