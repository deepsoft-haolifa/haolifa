package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SysLogConditionDTO extends PageParam {
    /**
     * 用户姓名
     */
    private String realName;

}
