package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @className: MaterialTypeListDTO
 * @description: 核料前返回的数据实体
 * @author: hedong@ibeesaas.com
 * @date: 2018-11-21 21:08
 **/
@Data
public class MaterialTypeListDTO {


    @ApiModelProperty(value = "核料原料类型：（1.阀体；2.阀座；3：阀板；4.阀杆,5.阀体压力）")
    private Byte type;
    @ApiModelProperty(value = "零件图号数组集合,数组元素是零件图号")
    private List<String> list;
}
