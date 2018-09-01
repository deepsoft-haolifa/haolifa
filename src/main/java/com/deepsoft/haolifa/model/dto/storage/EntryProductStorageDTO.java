package com.deepsoft.haolifa.model.dto.storage;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 入库成品实体
 */
@Data
public class EntryProductStorageDTO extends BaseStorageDTO{

    /**
     * 成品号
     */
    private String productNo;

    /**
     * 入库数量（正数）
     */
    private Integer quantity;

    /**
     * 生产部门
     */
    private String productDepartment;

}
