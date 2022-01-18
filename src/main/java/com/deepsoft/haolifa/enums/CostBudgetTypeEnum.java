package com.deepsoft.haolifa.enums;

import java.util.Arrays;

public enum CostBudgetTypeEnum {
    //
    dept("0", "部门预算"),
    subjects("1", "科目预算");

    private String code;
    private String desc;

    public static CostBudgetTypeEnum valueOfCode(String code) {
        CostBudgetTypeEnum billTypeEnum = Arrays.stream(CostBudgetTypeEnum.values())
            .filter(e -> e.code.equalsIgnoreCase(code))
            .findFirst()
            .orElse(null);
        if (billTypeEnum == null) {
            throw new RuntimeException();
        }
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

    CostBudgetTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
