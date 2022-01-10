package com.deepsoft.haolifa.model.dto.autoControl;

import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 零星物料出，入库实体
 *
 * @author murphy.he
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class AutoControlEntryOutPage extends PageParam {

    @ApiModelProperty(value = "物料名称")
    private String materialName;

    @ApiModelProperty(value = "零星物料Id")
    private Integer autoControlId;

    @ApiModelProperty(value = "1出库；2入库", allowableValues = "1,2")
    private Byte type;

    @ApiModelProperty("开始时间")
    private String startDate;

    @ApiModelProperty("结束时间")
    private String endDate;
}
