package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SupplierRespDTO {

    @ApiModelProperty(value = "供应商编号")
    private String suppilerNo;
    @ApiModelProperty(value = "供应商名称")
    private String supplierName;
    @ApiModelProperty(value = "id")
    private Integer id;

    private String phone;

    private String address;

    private String legalPerson;

    private String legalPersonPhone;

    private String responsiblePerson;


}
