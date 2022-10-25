package com.deepsoft.haolifa.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@ApiModel("自控检验历史")
public class AutoControlInspectHistory implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty("id")
    private Integer id;


    @ApiModelProperty("单据id")
    private Integer autoControlId;


    @ApiModelProperty("单号")
    private String no;


    @ApiModelProperty("物料图号")
    private String materialGraphNo;


    @ApiModelProperty("物料名称")
    private String materialGraphName;


    @ApiModelProperty("检测数量")
    private Integer testNumber;


    @ApiModelProperty("合格数量")
    private Integer qualifiedNumber;


    @ApiModelProperty("不合格数量")
    private Integer unqualifiedNumber;


    @ApiModelProperty("处理意见")
    private String handlingSuggestion;


    @ApiModelProperty("备注")
    private String remark;


    @ApiModelProperty("状态：1 待入库 2 已入库")
    private Byte status;


    @ApiModelProperty("不合格原因列表")
    private String reasons;


    @ApiModelProperty("质检附件")
    private String accessory;


    @ApiModelProperty("创建时间")
    private Date createTime;


    @ApiModelProperty("更新时间")
    private Date updateTime;


    public AutoControlInspectHistory(Integer id, Integer autoControlId, String no, String materialGraphNo, String materialGraphName, Integer testNumber, Integer qualifiedNumber, Integer unqualifiedNumber, String handlingSuggestion, String remark, Byte status, String reasons, String accessory, Date createTime, Date updateTime) {
        this.id = id;
        this.autoControlId = autoControlId;
        this.no = no;
        this.materialGraphNo = materialGraphNo;
        this.materialGraphName = materialGraphName;
        this.testNumber = testNumber;
        this.qualifiedNumber = qualifiedNumber;
        this.unqualifiedNumber = unqualifiedNumber;
        this.handlingSuggestion = handlingSuggestion;
        this.remark = remark;
        this.status = status;
        this.reasons = reasons;
        this.accessory = accessory;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public AutoControlInspectHistory() {
        super();
    }
}
