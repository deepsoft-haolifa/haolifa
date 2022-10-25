package com.deepsoft.haolifa.enums;

/***
 * 付款计划-付款状态
 */
public enum PayPlanPayStatusEnum {

    //1 待审批 2 审批中 3 付款中 4 审批不通过 5 付款完成
    un_pay("0", "未付款"),
    paid("2", "已付款");

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

    PayPlanPayStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
