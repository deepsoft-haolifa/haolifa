package com.deepsoft.haolifa.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("数据修复")
public class DataRepairVO {
    private Integer qty;
    private String graphNo;

}
