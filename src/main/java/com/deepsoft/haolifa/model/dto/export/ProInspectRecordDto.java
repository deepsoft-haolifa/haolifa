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
public class ProInspectRecordDto {

    private String orderNo;

    private String productNo;

    private String productModel;

    private String productSpecifications;

    private Integer testingNumber;

    private Integer qualifiedNumber;

    private Integer unqualifiedNumber;

    private String reason;

    private Byte storageStatus;

    private Date createTime;

    private Date updateTime;

    private BigDecimal price;
}
