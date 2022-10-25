package com.deepsoft.haolifa.enums;

import java.util.Arrays;

/***
 * DepreciationMethodEnum 折旧方法
 */
public enum DepreciationMethodEnum {


    // 1 平均年限法
    //2	工作量法
    //3	双倍余额递减法
    //4	年数总和折旧法
    pjnx("1", "平均年限法"),
    gzlf("2", "工作量法"),
    sbyedj("3", "双倍余额递减法"),
    nszhzj("4", "年数总和折旧法"),
    ;

    private String code;
    private String desc;

    public static DepreciationMethodEnum valueOfCode(String code) {
        DepreciationMethodEnum billTypeEnum = Arrays.stream(DepreciationMethodEnum.values())
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

    DepreciationMethodEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
