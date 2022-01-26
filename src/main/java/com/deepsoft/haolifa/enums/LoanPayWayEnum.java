package com.deepsoft.haolifa.enums;


import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/***
 */
public enum LoanPayWayEnum {

    cash_pay("1", "现金"),
    check_pay("2", "支票");

    private String code;
    private String desc;

    LoanPayWayEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static LoanPayWayEnum valueOfCode(String code) {
        LoanPayWayEnum bookingTypeEnum = Arrays.stream(LoanPayWayEnum.values())
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

    public static void main(String[] args) {

        List<LoanPayWayEnum> collect = Arrays.stream(LoanPayWayEnum.values()).collect(Collectors.toList());

        System.out.println(JSON.toJSONString(collect));
        System.out.println(JSON.toJSON(LoanPayWayEnum.cash_pay));
    }
}
