package com.deepsoft.haolifa.model.dto.export;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author murphy.he
 **/
@Data
public class ExportQualityDto {
    @ApiModelProperty("检验总数")
    private Integer totalNum;
    @ApiModelProperty("合格数")
    private Integer qualifiedNumber;
    @ApiModelProperty("不合格数")
    private Integer unqualifiedNumber;
}
