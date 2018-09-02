package com.deepsoft.haolifa.model.dto.redis;

import lombok.Data;

@Data
public class RedisMaterialInfo {
    /**
     * 库房Id
     */
    private Integer storeRoomId;
    /**
     * 库房货位Id
     */
    private Integer storeRoomRackId;
    /**
     * 库房货位号
     */
    private String storeRoomRackNo;

    /**
     * 锁定数量
     */
    private Integer lockQuantity;

}
