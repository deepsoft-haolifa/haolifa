package com.deepsoft.haolifa.model.dto;

import lombok.Data;

/**
 * 产品查询条件
 */
@Data
public class ProductConditionDTO {

    private String name;

    private String productNo;

    private Byte isDelete;

}
