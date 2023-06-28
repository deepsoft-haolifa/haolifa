package com.deepsoft.haolifa.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description 生产日计划
 * @author hedong
 * @date 2023-06-28
 */
@Data
@ApiModel("生产日计划")
public class ProductionDailyPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private Integer id;

    /**
     * 生产订单编号
     */
    @ApiModelProperty("生产订单编号")
    private String orderNo;

    /**
     * 订单数量
     */
    @ApiModelProperty("订单数量")
    private Integer orderNumber;

    /**
     * 完成数量
     */
    @ApiModelProperty("完成数量")
    private Integer finishNumber;

    /**
     * 计划日期
     */
    @ApiModelProperty("计划日期")
    private Date planDate;

    /**
     * 计划完成日期
     */
    @ApiModelProperty("计划完成日期")
    private Date planFinishDate;

    /**
     * 实际完成日期
     */
    @ApiModelProperty("实际完成日期")
    private Date actualFinishDate;

    /**
     * 发货日期
     */
    @ApiModelProperty("发货日期")
    private String deliveryDate;

    /**
     * 状态：wait 待完成 part 部分完成 completed 已完成
     */
    @ApiModelProperty("状态：wait 待完成 part 部分完成 completed 已完成")
    private String planStatus;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updateTime;

    /**
     * 创建用户
     */
    @ApiModelProperty("创建用户")
    private Integer createUser;

    /**
     * 更新用户
     */
    @ApiModelProperty("更新用户")
    private Integer updateUser;

    public ProductionDailyPlan(Integer id, String orderNo, Integer orderNumber, Integer finishNumber, Date planDate, Date planFinishDate, Date actualFinishDate, String deliveryDate, String planStatus, String remark, Date createTime, Date updateTime, Integer createUser, Integer updateUser) {
        this.id = id;
        this.orderNo = orderNo;
        this.orderNumber = orderNumber;
        this.finishNumber = finishNumber;
        this.planDate = planDate;
        this.planFinishDate = planFinishDate;
        this.actualFinishDate = actualFinishDate;
        this.deliveryDate = deliveryDate;
        this.planStatus = planStatus;
        this.remark = remark;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
    }
    public ProductionDailyPlan() {  super();}
}

