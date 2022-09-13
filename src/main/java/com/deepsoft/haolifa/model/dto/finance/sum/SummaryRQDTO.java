package com.deepsoft.haolifa.model.dto.finance.sum;

import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 合计
 *
 * @author murphy.he
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class SummaryRQDTO extends PageParam {

    @ApiModelProperty(value = "供应商名称")
    private String supplierName;
    @ApiModelProperty(value = "开始时间")
    private String startTime;
    @ApiModelProperty(value = "结束时间")
    private String endTime;
}
