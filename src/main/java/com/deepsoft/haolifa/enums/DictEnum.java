package com.deepsoft.haolifa.enums;


/***
 * 字典表 key
 */
public enum DictEnum {

    BOOKING_TYPE("BOOKING_TYPE", "记账方式"),
    PAY_WAY("PAY_WAY", "付款方式"),
    PAY_ACCOUNT("PAY_ACCOUNT", "付款账号"),
    PAYMENT_TYPE("PAY_ACCOUNT", "付款账号"),
    SUBJECTS_TYPE("SUBJECTS_TYPE", "科目类型"),

    VEHICLE_TYPE("VEHICLE_TYPE", "交通工具"),
    COLLECTION_TYPE("PAYMENT_TYPE", "收款类型"),

    ORDER_WORK_TYPE("ORDER_WORK_TYPE", "装配订单类别"),

    PROJECT_TYPE("PROJECT_TYPE", "报销项目类型"),

    ASSETS_ADD_TYPE("ASSETS_ADD_TYPE", "固定资产增加方式"),
    ASSETS_TYPE("ASSETS_TYPE", "固定资产类别名称"),
    DEPRECIATION_METHOD("DEPRECIATION_METHOD", "折旧方法"),


    ;
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
