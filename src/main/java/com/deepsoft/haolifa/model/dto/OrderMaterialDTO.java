package com.deepsoft.haolifa.model.dto;

import lombok.Data;


/**
 * @className: CheckMaterialDTO
 * @description: 核料实体
 * @author: hedong@ibeesaas.com
 * @date: 2018-11-19 21:20
 **/
@Data
public class OrderMaterialDTO {

    private String orderNo;

    private String materialGraphNo;

    private String replaceMaterialGraphNo;

    private Integer materialCount;
}
