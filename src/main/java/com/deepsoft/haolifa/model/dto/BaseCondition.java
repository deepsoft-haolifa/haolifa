package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @className: BaseCondition
 * @description: 基础查询条件
 * @author: hedong@ibeesaas.com
 * @date: 2018-12-13 14:59
 **/
@Data
public class BaseCondition {
    @ApiModelProperty(value = "页码，从1开始")
    private Integer pageNum = 1;
    @ApiModelProperty(value = "页面大小")
    private Integer pageSize = 20;
}
