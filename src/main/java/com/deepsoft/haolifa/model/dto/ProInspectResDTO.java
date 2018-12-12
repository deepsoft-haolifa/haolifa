package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ProInspectResDTO {
    private Integer id;
    @ApiModelProperty(required = true,value = "订单号")
    private String orderNo;
    @ApiModelProperty(required = true,value = "不合格数量")
    private Integer unqualifiedNumber;
    @ApiModelProperty(value = "不合格原因")
    private String reason;
    @ApiModelProperty(required = true,value = "成品型号")
    private String productModel;
    @ApiModelProperty(required = true,value = "成品规格")
    private String productSpecifications;
    @ApiModelProperty(required = true,value = "检测结果")
    private String testingResult;


//    @ApiModelProperty(required = true,value = "送检单号")
//    private String inspectNo;
//    @ApiModelProperty(required = true,value = "检测单位")
//    private String testingUnit;
//    @ApiModelProperty(required = true,value = "检测工序")
//    private String testingProcess;
//    @ApiModelProperty(required = true,value = "检测数量")
//    private Integer testingNumber;
//    @ApiModelProperty(required = true,value = "操作人")
//    private String testingPerson;
//    @ApiModelProperty(required = true,value = "技术要求")
//    private String technicalRequirements;
//    @ApiModelProperty(required = true,value = "检验员")
//    private String inspector;
//    @ApiModelProperty(value = "责任单位")
//    private String responsibleDepartment;
//    @ApiModelProperty(value = "责任单位负责人")
//    private String departmentLeader;
//    @ApiModelProperty(value = "责任认定日期")
//    private String responsibleAnalyaeTime;

}
