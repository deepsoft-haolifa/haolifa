package com.deepsoft.haolifa.model.vo.pay;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author liuyaofei
 * @Date create in 上午11:17 2021/11/21
 * @description 工序对应人的表
 */
@Data
public class PayUserProcedureVO {
    @ApiModelProperty(value = "姓名")
    private String userName;
    @ApiModelProperty(value = "用户ID")
    private Integer userId;
    @ApiModelProperty(value = "岗位能力明细")
    private String capacityCode;
}
