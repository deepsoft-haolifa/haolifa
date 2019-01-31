package com.deepsoft.haolifa.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@Data
@ApiModel("已办事项")
public class DoneItemVO {

    @ApiModelProperty("流程id")
    private Integer flowId;
    @ApiModelProperty("流程名")
    private String flowName;
    @ApiModelProperty("流程实例id")
    private Integer instanceId;
    @ApiModelProperty("创建人用户名")
    private String createUser;
    @ApiModelProperty("创建人真名")
    private String createUserRealName;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("流程关联表单号")
    private String formNo;

}
