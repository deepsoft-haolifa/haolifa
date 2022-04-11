package com.deepsoft.haolifa.model.dto.finance.subjectsbalance;


import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 科目表
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizSubjectsBalanceRQDTO extends PageParam {

    @ApiModelProperty(value = "科目名称")
    private String name;
    @ApiModelProperty(value = "科目类别")
    private String type;


}
