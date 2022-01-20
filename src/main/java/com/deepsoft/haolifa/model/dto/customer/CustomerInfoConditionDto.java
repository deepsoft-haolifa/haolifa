package com.deepsoft.haolifa.model.dto.customer;

import com.deepsoft.haolifa.model.dto.BaseCondition;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author murphy.he
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerInfoConditionDto extends BaseCondition {
    @ApiModelProperty("客户名称")
    private String name;
}
