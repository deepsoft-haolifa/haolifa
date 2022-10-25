package com.deepsoft.haolifa.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author liuyaofei
 * @Date create in 下午10:49 2021/11/24
 * @description
 */
@Data
public class DictionariesVo {
    @ApiModelProperty("code码")
    private String code;
    @ApiModelProperty("name值")
    private String name;
}
