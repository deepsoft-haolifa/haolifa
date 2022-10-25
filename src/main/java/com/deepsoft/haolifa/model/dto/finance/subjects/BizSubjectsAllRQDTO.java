package com.deepsoft.haolifa.model.dto.finance.subjects;


import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 科目表
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizSubjectsAllRQDTO extends PageParam {

    @ApiModelProperty(value = "科目类别")
    private String subjectsType;

}
