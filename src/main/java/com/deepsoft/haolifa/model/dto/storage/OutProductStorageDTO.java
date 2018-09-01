package com.deepsoft.haolifa.model.dto.storage;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 出库成品实体
 */
@Data
public class OutProductStorageDTO extends BaseStorageDTO {

    /**
     * 成品号
     */
    private String productNo;

    /**
     * 出库数量（负数）
     */
    private Integer quantity;
    /**
     * 出库单价（销售单价）
     */
    private BigDecimal price;

    /**
     * 客户代号
     */
    private String customerNo;

    /**
     * 客户名称
     */
    private String customerName;

}
