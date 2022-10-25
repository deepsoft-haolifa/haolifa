package com.deepsoft.haolifa.model.dto.finance.payapp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/***
 * 付款申请-查询rs
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PayApplyRSDTO {

    @ApiModelProperty(value = "ID")
    private Integer id;

    @ApiModelProperty(value = "审核状态")
    private String status;

    @ApiModelProperty(value = "申请总金额")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "付款单位")
    private String applyPayCompany;

    @ApiModelProperty(value = "申请时间")
    private Date applyTime;

    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）")
    private String delFlag;
    @ApiModelProperty(value = "创建者")
    private Integer createUser;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新者")
    private Integer updateUser;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "付款详情")
    private List<PayApplyDetailRSDTO> applyDetailRSDTOList;


}
