package com.deepsoft.haolifa.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/***
 * 借款审批-审批状态
 */
public enum ReimburseApplyStatusEnum {

    //1 待审批 2 审批中 3 付款中 4 审批不通过 5 付款完成
    PENDING_APPROVAL("1", "待审批"),
    // 审批中的状态 需要查询到具体哪个环节在审批 先在审批记录里查吧
    UNDER_APPROVAL("2", "审批中"),
    IN_PAYMENT("3", "审批完成"),
    APPROVAL_FAILED("4", "审批不通过");

    private String code;
    private String desc;
    public static ReimburseApplyStatusEnum valueOfCode(String code) {
        ReimburseApplyStatusEnum statusEnum = Arrays.stream(ReimburseApplyStatusEnum.values())
            .filter(e -> StringUtils.equalsIgnoreCase(e.code,code))
            .findFirst()
            .orElse(null);
        return statusEnum;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    ReimburseApplyStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
