package com.deepsoft.haolifa.enums;


import java.util.Arrays;

/***
 * 记账方式
 */
public enum BookingTypeEnum {

        bill("1", "现金日记账"),
        bank_bill("2", "银行日记账"),
        other_bill("3", "其他货币日记账");

    private String code;
    private String desc;




    public static BookingTypeEnum valueOfCode(String code) {
        BookingTypeEnum bookingTypeEnum = Arrays.stream(BookingTypeEnum.values())
            .filter(e -> e.code.equalsIgnoreCase(code))
            .findFirst()
            .orElse(null);
        if (bookingTypeEnum == null){
            throw  new RuntimeException();
        }
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

    BookingTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
