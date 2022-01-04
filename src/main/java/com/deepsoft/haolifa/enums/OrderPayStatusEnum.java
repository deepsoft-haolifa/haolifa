package com.deepsoft.haolifa.enums;

import java.util.Arrays;

public enum OrderPayStatusEnum {

    // 1 未付款 2 部分付款 3 付款完成
    un_pay("1", "未付款"),
    partial_pay("2", "部分付款"),
    all_pay("3", "付款完成");

    private String code;
    private String desc;


    public static OrderPayStatusEnum valueOfCode(String code) {
        OrderPayStatusEnum orderPayStatusEnum = Arrays.stream(OrderPayStatusEnum.values())
            .filter(e -> e.code==code)
            .findFirst()
            .orElse(null);
        if (orderPayStatusEnum == null) {
            throw new RuntimeException();
        }
        return orderPayStatusEnum;
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

    OrderPayStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
