package com.deepsoft.haolifa.model.dto.storage;

import lombok.Data;

@Data
public class BaseStorageDTO {
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
    private Integer storeRoomRackNo;

    /**
     * 订单号
     */
    private String orderNo;
}
