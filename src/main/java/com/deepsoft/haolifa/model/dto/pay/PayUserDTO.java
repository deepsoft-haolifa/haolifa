package com.deepsoft.haolifa.model.dto.pay;

import com.deepsoft.haolifa.model.dto.BaseCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=true)
@ApiModel(description = "人员信息表")
public class PayUserDTO extends BaseCondition {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "姓名")
    private String userName;
    @ApiModelProperty(value = "曾用名")
    private String onceUserName;
    @ApiModelProperty(value = "性别默认为0， 1：男， 2：女")
    private Byte sex;
    @ApiModelProperty(value = "生日")
    private Date birthday;
    @ApiModelProperty(value = "民族")
    private String nation;
    @ApiModelProperty(value = "籍贯")
    private String nativePlace;
    @ApiModelProperty(value = "政治面貌")
    private String politicalOutlook;
    @ApiModelProperty(value = "血型")
    private String bloodType;
    @ApiModelProperty(value = "健康状况")
    private String health;
    @ApiModelProperty(value = "1:未婚 2:已婚 3:离异 4:丧偶")
    private Byte marryStatus;
    @ApiModelProperty(value = "身份证号")
    private String idCard;
    @ApiModelProperty(value = "户口所在地")
    private String registered;
    @ApiModelProperty(value = "毕业院校")
    private String universityFrom;
    @ApiModelProperty(value = "专业")
    private String major;
    @ApiModelProperty(value = "学历 1:小学、2:初中、3:中专、4:高中、5:大专、6:本科、7:硕士、8:博士")
    private Byte education;
    @ApiModelProperty(value = "毕业时间")
    private Date graduationTime;
    @ApiModelProperty(value = "开始毕业时间")
    private String startGraduationTime;
    @ApiModelProperty(value = "结束毕业时间")
    private String endGraduationTime;
    @ApiModelProperty(value = "参加工作时间")
    private Date workingTime;
    @ApiModelProperty(value = "开始参加工作时间")
    private String startWorkingTime;
    @ApiModelProperty(value = "结束参加工作时间")
    private String endWorkingTime;
    @ApiModelProperty(value = "常用住址")
    private String address;
    @ApiModelProperty(value = "保险基数")
    private BigDecimal insuranceBase;
    @ApiModelProperty(value = "联系方式")
    private String phone;
    @ApiModelProperty(value = "邮箱")
    private String mail;
    @ApiModelProperty(value = "班组id")
    private Integer teamId;
    @ApiModelProperty(value = "班组名称")
    private String teamName;
    @ApiModelProperty(value = "基本工资")
    private BigDecimal basePay;
    @ApiModelProperty(value = "绩效工资")
    private BigDecimal meritPay;
    @ApiModelProperty(value = "岗位id")
    private Integer postId;
    @ApiModelProperty(value = "岗位名称")
    private String postName;
    @ApiModelProperty(value = "部门id")
    private Integer departId;
    @ApiModelProperty(value = "部门名称")
    private String departName;
    @ApiModelProperty(value = "人员类型")
    private String userType;
    @ApiModelProperty(value = "上级ID")
    private Integer superiorId;
    @ApiModelProperty(value = "上级名称")
    private String superiorName;
    @ApiModelProperty(value = "创建人")
    private String createUser;
    @ApiModelProperty(value = "更新人")
    private String updateUser;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "开始创建时间")
    private String startCreateTime;
    @ApiModelProperty(value = "结束创建时间")
    private String endCreateTime;
    @ApiModelProperty(value = "更新日期")
    private Date updateTime;
    @ApiModelProperty(value = "开始更新日期")
    private String startUpdateTime;
    @ApiModelProperty(value = "结束更新日期")
    private String endUpdateTime;
}
