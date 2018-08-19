package com.deepsoft.haolifa.model.dto;

import lombok.Data;

/**
 * 库房查询条件
 */
@Data
public class StoreRoomConditionDTO {

    /**
     * 库房名称
     */
    private String name;

    /**
     * 库房类型
     */
    private Byte type;

}
