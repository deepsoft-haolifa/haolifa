package com.deepsoft.haolifa.model.dto.storage;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 请求批次号
 *
 * @author murphy.he
 **/
@Data
public class BatchNoListDTO {
    @ApiModelProperty("零件图号")
    private String graphNo;

    @ApiModelProperty("数量")
    private Integer qty;

    @ApiModelProperty("批次号")
    private String batchNo;
}
