package com.deepsoft.haolifa.model.vo.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Author liuyaofei
 * @Date create in 下午9:34 2021/12/18
 * @description
 */
@Data
@EqualsAndHashCode()
@ApiModel(description = "工序对应人员明细表")
public class PayWorkingProcedureUserVO {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "订单号")
    private String orderNo;
    @ApiModelProperty(value = "产品ID")
    private Integer productId;
    private String productModel;
    @ApiModelProperty(value = "岗位（工序）名称")
    private String postName;
    @ApiModelProperty(value = "岗位能力简称")
    private String postCapability;
    @ApiModelProperty(value = "岗位（工序）代码")
    private String postCode;
    @ApiModelProperty(value = "工序对应的人员")
    private List<ProcedureUserVO> userList;
}
