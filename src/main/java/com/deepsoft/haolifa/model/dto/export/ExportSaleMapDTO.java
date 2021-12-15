package com.deepsoft.haolifa.model.dto.export;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * 销售报表-合同报表
 */
@NoArgsConstructor
@Data
public class ExportSaleMapDTO {


    private String companyName;
    private List<ValueRespVo> value;

    @NoArgsConstructor
    @Data
    public static class ValueRespVo {
        private String year;
        private BigDecimal amount;
    }
}
