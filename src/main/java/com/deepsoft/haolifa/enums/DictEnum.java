package com.deepsoft.haolifa.enums;


/***
 * 字典表 key
 */
public enum DictEnum {

        BOOKING_TYPE("BOOKING_TYPE", "记账方式"),
        PAY_WAY("PAY_WAY", "付款方式"),
        PAY_ACCOUNT("PAY_ACCOUNT", "付款账号"),
        PAYMENT_TYPE("PAY_ACCOUNT", "付款账号"),
        COLLECTION_TYPE("PAYMENT_TYPE", "收款类型");

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

     DictEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
