package com.deepsoft.haolifa.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel("订单-技术清单-关联")
public class OrderTechnicalDetailedRel implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 订单编号
     */
    @ApiModelProperty("订单编号")
    private String orderNo;

    /**
     * 产品名称
     */
    @ApiModelProperty("产品名称")
    private String productName;

    /**
     * 数量
     */
    @ApiModelProperty("数量")
    private Integer productNum;

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

    public OrderTechnicalDetailedRel(Integer id, String orderNo, String productName, Integer productNum, String productModel, String specifications, String upperFlangeStandard, String connectingHole, String angle, String centerDistance, String outputShaftType, String outputShaftLength, String axisDrawingNo, String connectingSleeve, String transitionPlate, String staticTorque, String actuatorModel, String remark, String createUser, String updateUser, Date createTime, Date updateTime) {
        this.id = id;
        this.orderNo = orderNo;
        this.productName = productName;
        this.productNum = productNum;
        this.productModel = productModel;
        this.specifications = specifications;
        this.upperFlangeStandard = upperFlangeStandard;
        this.connectingHole = connectingHole;
        this.angle = angle;
        this.centerDistance = centerDistance;
        this.outputShaftType = outputShaftType;
        this.outputShaftLength = outputShaftLength;
        this.axisDrawingNo = axisDrawingNo;
        this.connectingSleeve = connectingSleeve;
        this.transitionPlate = transitionPlate;
        this.staticTorque = staticTorque;
        this.actuatorModel = actuatorModel;
        this.remark = remark;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public OrderTechnicalDetailedRel() {
        super();
    }
}
