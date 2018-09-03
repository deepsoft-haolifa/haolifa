package com.deepsoft.haolifa.model.dto.storage;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 出库零件实体
 */
@Data
public class OutMaterialStorageDTO extends BaseStorageDTO{

    /**
     * 零件号
     */
    private String materialGraphNo;

    /**
     * 出库数量（负数）
     */
    private Integer quantity;
    /**
     * 领料部门
     */
    private String receiveDepartment;
}
