package com.deepsoft.haolifa.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel("自控委托单")
public class AutoControlEntrust  {


    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("委托单号")
    private String entrustNo;


    @ApiModelProperty("产品名称")
    private String name;


    @ApiModelProperty("图号")
    private String graphNo;


    @ApiModelProperty("规格")
    private String specifications;


    @ApiModelProperty("型号")
    private String model;


    @ApiModelProperty("委托工种类别")
    private String workType;


    @ApiModelProperty("数量")
    private Integer qty;


    @ApiModelProperty("合格数")
    private Integer qualifiedNumber;


    @ApiModelProperty("状态：0 创建 1 加工中 2 质检完成 3 加工完成 4 暂停加工")
    private Byte status;


    @ApiModelProperty("0 待质检 1 质检中 2 质检完成")
    private Byte inspectStatus;


    @ApiModelProperty("create_time")
    private Date createTime;


    @ApiModelProperty("update_time")
    private Date updateTime;

    public AutoControlEntrust(Integer id, String entrustNo, String name, String graphNo, String specifications, String model, String workType, Integer qty, Integer qualifiedNumber, Byte status, Byte inspectStatus, Date createTime, Date updateTime) {
        this.id = id;
        this.entrustNo = entrustNo;
        this.name = name;
        this.graphNo = graphNo;
        this.specifications = specifications;
        this.model = model;
        this.workType = workType;
        this.qty = qty;
        this.qualifiedNumber = qualifiedNumber;
        this.status = status;
        this.inspectStatus = inspectStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public AutoControlEntrust() {
        super();
    }

}