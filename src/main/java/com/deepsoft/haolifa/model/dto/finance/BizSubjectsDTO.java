package com.deepsoft.haolifa.model.dto.finance;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 科目表
 */
@Data
public class BizSubjectsDTO {

    @ApiModelProperty(value = "科目名称")
    private String name;
    @ApiModelProperty(value = "科目类别")
    private String type;
    @ApiModelProperty(value = "父节点")
    private Integer parentId;
    @ApiModelProperty(value = "几级节点")
    private Integer level;
    @ApiModelProperty(value = "科目代码")
    private String code;
    @ApiModelProperty(value = "科目描述")
    private String remark;

    @ApiModelProperty(value = "百分比")
    private double percent;
    @ApiModelProperty(value = "科目id")
    private Integer id;
    @ApiModelProperty(required = true,value = "页码")
    private Integer pageNum;
    @ApiModelProperty(required = true,value = "显示数量，默认10条")
    private Integer pageSize;

}
