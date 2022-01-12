package com.deepsoft.haolifa.enums;

/***
 * 付款计划-确认状态
 */
public enum PayPlanConfirmStatusEnum {

    ZJJL_Confirm("0", "待资金经理确认"),
    CN_Confirm("1", "出纳付款");

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

    PayPlanConfirmStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
