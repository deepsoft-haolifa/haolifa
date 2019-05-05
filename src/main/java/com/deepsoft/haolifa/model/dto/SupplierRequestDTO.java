package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description = "新增,更新供应商信息")
public class SupplierRequestDTO {

    private Integer id;

    private List<Accessory> accessories;

    @ApiModelProperty(required = true, value = "供应商编号")
    private String suppilerNo;
    @ApiModelProperty(required = true, value = "供应商名称")
    private String suppilerName;
    @ApiModelProperty(required = true, value = "供应商网站地址")
    private String website;
    @ApiModelProperty(required = true, value = "供应商企业性质 0 国有 1 三资 2集体 3 联营 4 私营", allowableValues = "0,1,2,3,4")
    private Byte nature;
    @ApiModelProperty(required = true, value = "联系电话")
    private String phone;
    @ApiModelProperty(required = true, value = "地址")
    private String address;
    @ApiModelProperty(required = true, value = "邮编")
    private String postcode;
    @ApiModelProperty(required = true, value = "传真")
    private String fax;
    @ApiModelProperty(required = true, value = "法人")
    private String legalPerson;
    @ApiModelProperty(required = true, value = "法人联系电话")
    private String legalPersonPhone;
    @ApiModelProperty(required = true, value = "工厂总面积")
    private Integer totalFactoryArea;
    @ApiModelProperty(required = true, value = "建筑物面积")
    private Integer totalArchitArea;
    @ApiModelProperty(required = true, value = "工作班次 0 正常 1 两班倒 2 三班倒", allowableValues = "0,1,2")
    private Byte workType;
    @ApiModelProperty(required = true, value = "企业员工")
    private SupplierStaff staffInfo;
    @ApiModelProperty(required = true, value = "资格证书")
    private SupplierCredential credentialsInfo;
    @ApiModelProperty(required = true, value = "近三年经营状况")
    private SupplierFinancial financialInfo;
    @ApiModelProperty(required = true, value = "主要机构")
    private List<SupplierMainOrgan> mainOrgan;
    @ApiModelProperty(required = true, value = "质量体系")
    private SupplierAualityAssurance qualityAssuranceInfo;
    @ApiModelProperty(required = true, value = "工艺路线")
    private String processRoute;
    @ApiModelProperty(required = true, value = "负责人")
    private String responsiblePerson;
    @ApiModelProperty(required = true, value = "供应商填表人")
    private String suppilerPreparer;
    @ApiModelProperty(value = "供应商评价")
    private String evaluation;

}

@Data
class SupplierStaff {

    @ApiModelProperty(required = true, value = "生产人员人数")
    private Integer productionWorkers;
    @ApiModelProperty(required = true, value = "技术人员人数")
    private Integer technicistWorkers;
    @ApiModelProperty(required = true, value = "管理人员人数")
    private Integer managerWorkers;
    @ApiModelProperty(required = true, value = "总人数")
    private Integer totalWorkers;
}

@Data
class SupplierCredential {
    @ApiModelProperty(required = true, value = "营业执照")
    private Boolean charter;
    @ApiModelProperty(required = true, value = "税务证书")
    private Boolean tax;
    @ApiModelProperty(required = true, value = "法人代码")
    private Boolean legalPersonCode;
    @ApiModelProperty(required = true, value = "银行开户证明")
    private Boolean bankOpenAccount;
    @ApiModelProperty(required = true, value = "银行资信证明")
    private Boolean credibilityLetter;
    @ApiModelProperty(required = true, value = "制造商授权书")
    private Boolean manufacturerAuthorization;
    @ApiModelProperty(required = true, value = "产品鉴定书")
    private Boolean productCertification;
    @ApiModelProperty(required = true, value = "生产许可")
    private Boolean productPermit;
    @ApiModelProperty(required = true, value = "进出口资格证书")
    private Boolean importAndExportCertification;
    @ApiModelProperty(required = true, value = "相关体系认证")
    private Boolean otherCertification;

}

@Data
class SupplierFinancial {
    @ApiModelProperty(required = true, value = "企业净值")
    private Integer netWorth;
    @ApiModelProperty(required = true, value = "负债")
    private Integer liabilities;
    @ApiModelProperty(required = true, value = "资产")
    private Integer asset;
    @ApiModelProperty(required = true, value = "经营状况")
    private List<BusinessState> businessStateList;

}

@Data
class BusinessState {
    @ApiModelProperty(required = true, value = "年度")
    private String year;
    @ApiModelProperty(required = true, value = "销售额")
    private Integer sale;
    @ApiModelProperty(required = true, value = "利润")
    private Integer profit;
    @ApiModelProperty(required = true, value = "经营状况描述")
    private String desc;
}


@Data
class SupplierMainOrgan {
    @ApiModelProperty(required = true, value = "部门")
    private String department;
    @ApiModelProperty(required = true, value = "负责人")
    private String leader;
    @ApiModelProperty(required = true, value = "电话")
    private String phone;
    @ApiModelProperty(required = true, value = "传真")
    private String fax;


}

@Data
class SupplierAualityAssurance {
    @ApiModelProperty(required = true, value = "是否构建质量保证体系")
    private Boolean buildQualitySystem;
    @ApiModelProperty(required = true, value = "是否通过第三方认证")
    private Boolean passThirdAttestation;
    @ApiModelProperty(required = true, value = "第二方确认单位")
    private String secondConfirm;

}

