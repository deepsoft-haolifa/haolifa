package com.deepsoft.haolifa.enums;

public enum PayStatusEnum {

    //1 待审批 2 审批中 3 付款中 4 审批不通过 5 付款完成
    PENDING_APPROVAL("1", "待审批"),
    UNDER_APPROVAL("2", "审批中"),
    IN_PAYMENT("3", "付款中"),
    APPROVAL_FAILED("4", "审批不通过"),
    PAYMENT_COMPLETED("5", "付款完成");

    private String code;
    private String desc;

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

     PayStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
