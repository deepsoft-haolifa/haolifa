package com.deepsoft.haolifa.model.dto.finance.subjects;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 科目表
 */
@Data
public class BizSubjectsRSDTO {

    @ApiModelProperty(value = "科目id")
    private Integer id;
    @ApiModelProperty(value = "科目名称")
    private String name;
    @ApiModelProperty(value = "科目类别")
    private String type;
    @ApiModelProperty(value = "父节点")
    private String parentId;
    @ApiModelProperty(value = "几级节点")
    private Integer level;
    @ApiModelProperty(value = "科目代码")
    private String code;
    @ApiModelProperty(value = "科目描述")
    private String remark;
    @ApiModelProperty(value = "百分比")
    private double percent;

    private String status;
    private String delFlag;
    private Integer createUser;
    private Integer updateUser;
    private Date createTime;
    private Date updateTime;


}
