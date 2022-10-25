package com.deepsoft.haolifa.model.vo.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author liuyaofei
 * @Date create in 下午9:37 2021/12/18
 * @description
 */
@Data
@EqualsAndHashCode()
@ApiModel(description = "工序对应人员明细表")
public class ProcedureUserVO {
    @ApiModelProperty(value = "用户ID")
    private Integer userId;
    @ApiModelProperty(value = "用户姓名")
    private String userName;
}
