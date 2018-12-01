package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@Data
public class ApplyBuyListDTO {

    private Integer id;

    private String productOrderNo;

    private Integer purchaseNumber;

    private Date arrivalTime;

    private Date createTime;

    private Date updateTime;

    private String materialGraphNo;

    private String materialName;

    private Byte status;

    private String dealUserName;
}
