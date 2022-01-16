package com.deepsoft.haolifa.model.dto.autoControlEntrust;

import com.deepsoft.haolifa.model.dto.BaseCondition;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author murphy.he
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class AutoControlEntrustConditionDto extends BaseCondition {
    @ApiModelProperty("委托单号")
    private String entrustNo;

    @ApiModelProperty("图号")
    private String graphNo;

    @ApiModelProperty("状态：0 创建 1 加工中 2 质检完成 3 加工完成 4 暂停加工")
    private Byte status;

    @ApiModelProperty("0 待质检 1 质检中 2 质检完成")
    private Byte inspectStatus;

    @ApiModelProperty("1 质检菜单下")
    private Integer type;
}
