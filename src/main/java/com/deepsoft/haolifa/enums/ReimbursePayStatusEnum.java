package com.deepsoft.haolifa.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public enum ReimbursePayStatusEnum {

    // 1 未付款 2 部分付款 3 付款完成
    un_pay("1", "未付款"),
    partial_pay("2", "部分付款"),
    all_pay("3", "付款完成");

    private String code;
    private String desc;


    public static ReimbursePayStatusEnum valueOfCode(String code) {
        ReimbursePayStatusEnum orderPayStatusEnum = Arrays.stream(ReimbursePayStatusEnum.values())
            .filter(e -> StringUtils.equalsIgnoreCase(e.code,code))
            .findFirst()
            .orElse(null);
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

    ReimbursePayStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}