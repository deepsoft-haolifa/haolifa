package com.deepsoft.haolifa.model.dto.export;

import com.deepsoft.haolifa.model.dto.report.ReportBaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author murphy.he
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ReportSupplierConditionDTO extends ReportBaseDTO {
    @ApiModelProperty(value = "供应商名称")
    private String supplierName;
}
