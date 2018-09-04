package com.deepsoft.haolifa.model.dto.storage;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 入库成品实体
 */
@Data
public class EntryProductStorageDTO extends BaseStorageDTO{


    @ApiModelProperty(value = "成品号",required = true)
    private String productNo;

    @ApiModelProperty(value = "入库数量（正数）",required = true)
    private Integer quantity;

    @ApiModelProperty(value = "生产部门",required = true)
    private String productDepartment;

}
