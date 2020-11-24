package com.deepsoft.haolifa.model.dto.export;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 导出成品入库单记录
 *
 * @author murphy.he
 **/
@Data
public class ExportEntryOutRecordDto {

    private String orderNo;

    private String productNo;

    private String productModel;

    private String productSpecifications;

    private Integer quantity;

    private Date createTime;

    private Date updateTime;

    private BigDecimal price;

    private String productDepartment;
}
