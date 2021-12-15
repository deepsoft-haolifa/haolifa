package com.deepsoft.haolifa.model.dto.pay;

import com.deepsoft.haolifa.model.dto.BaseCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper=true)
@ApiModel(description = "工时定额表")
public class PayHourQuotaDTO extends BaseCondition {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "序号")
    private Integer serial;
    @ApiModelProperty(value = "车间名称")
    private String workshopName;
    @ApiModelProperty(value = "过程产品名称")
    private String productName;
    @ApiModelProperty(value = "适用ID类别（图号类别）")
    private String idCategory;
    @ApiModelProperty(value = "适用型号")
    private String appModel;
    @ApiModelProperty(value = "适用规格")
    private String appSpecifications;
    @ApiModelProperty(value = "工种类别")
    private String workType;
    @ApiModelProperty(value = "工序名称")
    private String procedureName;
    @ApiModelProperty(value = "岗位代码")
    private String postCode;
    @ApiModelProperty(value = "工时定额（元）")
    private BigDecimal hourQuotaPrice;
}
