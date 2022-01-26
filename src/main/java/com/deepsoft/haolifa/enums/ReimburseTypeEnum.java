package com.deepsoft.haolifa.enums;

import java.util.Arrays;

public enum ReimburseTypeEnum {
    travle("1", "差旅报销"),
    cost("2", "费用报销");

    private String code;
    private String desc;

    ReimburseTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ReimburseTypeEnum valueOfCode(String code) {
        ReimburseTypeEnum bookingTypeEnum = Arrays.stream(ReimburseTypeEnum.values())
            .filter(e -> e.code.equalsIgnoreCase(code))
            .findFirst()
            .orElse(null);
        return bookingTypeEnum;
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


}
