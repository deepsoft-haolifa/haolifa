package com.deepsoft.haolifa.enums;

import java.util.Arrays;

public enum BillTypeEnum {
    //
    all("0", "全部"),
    bill("1", "现金"),
    bank_bill("2", "银行"),
    other_bill("3", "其他");

    private String code;
    private String desc;


    public static BillTypeEnum valueOfCode(String code) {
        BillTypeEnum billTypeEnum = Arrays.stream(BillTypeEnum.values())
            .filter(e -> e.code.equalsIgnoreCase(code))
            .findFirst()
            .orElse(null);
        return billTypeEnum;
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

    BillTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
