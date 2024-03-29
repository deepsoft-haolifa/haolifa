package com.deepsoft.haolifa.model.dto.finance.assets;

import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class AssetsRQDTO extends PageParam {

    @ApiModelProperty(value = "设备名称")
    private  String name;

    @ApiModelProperty(value = "设备编号")
    private  String bh;

    @ApiModelProperty(value = "资产类别 数据字典 ASSETS_TYPE")
    private String type;

    @ApiModelProperty(value = "部门")
    private  Integer deptId;

    @ApiModelProperty(value = "领用人")
    private  String userName;

    @ApiModelProperty(value = "增加方式 数据字典 ASSETS_ADD_TYPE")
    private String addType;

    @ApiModelProperty(value = "状态（0正常 1停用）")
    private  String status;

}
