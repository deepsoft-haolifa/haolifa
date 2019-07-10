package com.deepsoft.haolifa.model.dto.order;

import com.deepsoft.haolifa.model.dto.material.MaterialResultDTO;
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


    @ApiModelProperty(value = "核料原料类型：（fati.阀体;fazuo:阀座;faban：阀板;fagan:阀杆;fatiyali.阀体压力;tongyong:通用零件）")
    private String type;
    @ApiModelProperty(value = "零件集合")
    private List<MaterialResultDTO> list;
}
