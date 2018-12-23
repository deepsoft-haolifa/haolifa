package com.deepsoft.haolifa.model.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 出库，入库请求实体
 */
@Data
public class EntryOutStorageDTO {


    /**
     * 库房No
     */
    private String roomNo;

    /**
     * 库房货位号
     */
    private String rackNo;

    /**
     * 成品号
     */
    private String productNo;

    /**
     * 成品型号
     */
    private String productModel;

    /**
     * 成品规格
     */
    private String productSpecifications;

    /**
     * 零件号
     */
    private String materialGraphNo;

    /**
     * 出入库数量
     */
    private Integer quantity;
    /**
     * 出入库数量
     */
    private Integer lockQuantity;
    /**
     * 出入库单价
     */
    private BigDecimal price;

    /**
     * 库存类型（1.成品；2.零件）
     */
    private Byte type;

    /**
     * 库存操作类型（1.出库；2.入库）
     */
    private Byte operationType;
}
