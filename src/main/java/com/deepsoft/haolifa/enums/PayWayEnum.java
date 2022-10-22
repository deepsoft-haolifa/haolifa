package com.deepsoft.haolifa.enums;


import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/***
 * //现金记账    现金                 100
 * //银行记账    支票|汇款【下拉式】    100
 * //其它货币    承兑|汇票【下拉式】    100
 */
public enum PayWayEnum {

    cash_pay("cash_pay", "现金",BookingTypeEnum.cash_bill),
    check_pay("check_pay", "支票",BookingTypeEnum.bank_bill),
    remittance_pay("remittance_pay", "汇款",BookingTypeEnum.bank_bill),
    acceptance_pay("acceptance_pay", "承兑",BookingTypeEnum.other_bill),
    money_order_pay("money_oder_pay", "汇票",BookingTypeEnum.other_bill);

    private String code;
    private String desc;
    private BookingTypeEnum bookingTypeEnum;

    PayWayEnum(String code, String desc, BookingTypeEnum bookingTypeEnum) {
        this.code = code;
        this.desc = desc;
        this.bookingTypeEnum = bookingTypeEnum;
    }

    public static PayWayEnum valueOfCode(String code) {
        PayWayEnum bookingTypeEnum = Arrays.stream(PayWayEnum.values())
            .filter(e -> e.code.equalsIgnoreCase(code))
            .findFirst()
            .orElse(null);
        return bookingTypeEnum;
    }


    public BookingTypeEnum getBookingTypeEnum() {
        return bookingTypeEnum;
    }

    public void setBookingTypeEnum(BookingTypeEnum bookingTypeEnum) {
        this.bookingTypeEnum = bookingTypeEnum;
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

        List<PayWayEnum> collect = Arrays.stream(PayWayEnum.values()).collect(Collectors.toList());

        System.out.println(JSON.toJSONString(collect));
        System.out.println(JSON.toJSON(PayWayEnum.cash_pay));
    }
}
