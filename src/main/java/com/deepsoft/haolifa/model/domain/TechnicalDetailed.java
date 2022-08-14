package com.deepsoft.haolifa.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel("技术清单")
public class TechnicalDetailed
    implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 产品名称
     */
    @ApiModelProperty("产品名称")
    private String productName;

    /**
     * 型号
     */
    @ApiModelProperty("型号")
    private String productModel;

    /**
     * 规格
     */
    @ApiModelProperty("规格")
    private String specifications;

    /**
     * 上法兰标准
     */
    @ApiModelProperty("上法兰标准")
    private String upperFlangeStandard;

    /**
     * 连接孔
     */
    @ApiModelProperty("连接孔")
    private String connectingHole;

    /**
     * 角度
     */
    @ApiModelProperty("角度")
    private String angle;

    /**
     * 中心距
     */
    @ApiModelProperty("中心距")
    private String centerDistance;

    /**
     * 出轴型式
     */
    @ApiModelProperty("出轴型式")
    private String outputShaftType;

    /**
     * 出轴长度
     */
    @ApiModelProperty("出轴长度")
    private String outputShaftLength;

    /**
     * 轴图号
     */
    @ApiModelProperty("轴图号")
    private String axisDrawingNo;

    /**
     * 连接套
     */
    @ApiModelProperty("连接套")
    private String connectingSleeve;

    /**
     * 过渡盘
     */
    @ApiModelProperty("过渡盘")
    private String transitionPlate;

    /**
     * 静扭矩
     */
    @ApiModelProperty("静扭矩")
    private String staticTorque;

    /**
     * 执行器型号
     */
    @ApiModelProperty("执行器型号")
    private String actuatorModel;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String createUser;

    /**
     * 更新人
     */
    @ApiModelProperty("更新人")
    private String updateUser;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 更新日期
     */
    @ApiModelProperty("更新日期")
    private Date updateTime;
}
