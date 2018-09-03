package com.deepsoft.haolifa.model.dto.storage;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 入库零件实体
 */
@Data
public class EntryMaterialStorageDTO extends BaseStorageDTO{
    /**
     * 零件号
     */
    private String materialGraphNo;

    /**
     * 入库数量（正数）
     */
    private Integer quantity;
    /**
     * 零件购买单价
     */
    private BigDecimal price;

    /**
     * 供应商
     */
    private String supplier;

}
