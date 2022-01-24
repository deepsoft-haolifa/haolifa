package com.deepsoft.haolifa.enums;

import java.util.Arrays;

public enum LoanBillTypeEnum {
    //
    bill("1", "现金"),
    bank_bill("2", "银行"),
    other_bill("3", "其他");

    private String code;
    private String desc;


    public static LoanBillTypeEnum valueOfCode(String code) {
        LoanBillTypeEnum billTypeEnum = Arrays.stream(LoanBillTypeEnum.values())
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

    LoanBillTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
