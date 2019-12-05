package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SupplierReqDTO {

    @ApiModelProperty(value = "图号")
    private List<String> graphNos;

    private Integer materialCount;
}
