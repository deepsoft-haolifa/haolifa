package com.deepsoft.haolifa.model.domain;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * <p>
 * 领料单表
 * </p>
 *
 * @author murphy.he
 * @since 2019-11-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="MaterialRequisition对象", description="领料单表")
public class MaterialRequisition implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "领料单号")
    private String requisitionNo;

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "领料部门")
    private String deptName;

    @ApiModelProperty(value = "零件名称")
    private String materialName;

    @ApiModelProperty(value = "零件图号")
    private String graphNo;

    @ApiModelProperty(value = "所需数量")
    private Integer quantity;

    @ApiModelProperty(value = "批次号")
    private String batchNumber;

    @ApiModelProperty(value = "出库状态（0 未出库；1.出库完成）")
    private Integer outRoomStatus;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建用户")
    private Integer createUser;

    @ApiModelProperty(value = "更新用户")
    private Integer updateUser;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
