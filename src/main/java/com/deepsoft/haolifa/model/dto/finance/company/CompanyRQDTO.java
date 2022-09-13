package com.deepsoft.haolifa.model.dto.finance.company;

import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CompanyRQDTO  extends PageParam {

    @ApiModelProperty(value = "单位code")
    private String code;

    @ApiModelProperty(value = "单位名称")
    private String name;

}
