package com.deepsoft.haolifa.util;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * BigDecimal工具类
 * @author
 *
 */
public class BigDecimalUtils {

    //默认除法运算精度
    private static final int DEF_DIV_SCALE = 2;

    //建立货币格式化引用
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();

    //建立百分比格式化引用
    private static final NumberFormat percent = NumberFormat.getPercentInstance();

    /**
     * 加法
     * @param num
     * @param num1
     * @return
     */
    public static BigDecimal add(BigDecimal num, BigDecimal num1) {
        return num.add(num1);
    }


    /**
     * 提供精确的加法运算(默认四舍五入，根据scale保留小数位数)
     * @param num
     * @param num1
     * @param scale
     * @return
     */
    public static BigDecimal add(BigDecimal num, BigDecimal num1, int scale) {
        return num.add(num1).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }


    /**
     * 提供精确的加法运算(默认四舍五入，根据scale保留小数位数)
     * @param add
     * @param add1
     * @param scale
     * @return
     */
    public static BigDecimal add(String add, String add1, int scale) {
        BigDecimal num = new BigDecimal(add);
        BigDecimal num1 = new BigDecimal(add1);
        return num.add(num1).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }


    /**
     * 减法
     * @param num
     * @param num1
     * @return
     */
    public static BigDecimal sub(BigDecimal num, BigDecimal num1) {
        return num.subtract(num1);
    }


    /**
     * 提供精确的减法运算(默认四舍五入，根据scale保留小数位数)
     * @param num
     * @param num1
     * @param scale
     * @return
     */
    public static BigDecimal sub(BigDecimal num, BigDecimal num1, int scale) {
        return num.subtract(num1).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }


    /**
     * 提供精确的减法运算(默认四舍五入，根据scale保留小数位数)
     * @param minus
     * @param minus1
     * @return
     */
    public static BigDecimal sub(String minus, String minus1, int scale) {
        BigDecimal num = new BigDecimal(minus);
        BigDecimal num1 = new BigDecimal(minus1);
        return sub(num, num1, scale);
    }


    /**
     * 乘法
     * @param num
     * @param num1
     * @return
     */
    public static BigDecimal multiply(BigDecimal num, BigDecimal num1) {
        return num.multiply(num1);
    }


    /**
     * 提供精确的乘法运算(默认四舍五入,保留小数位数根据scale决定)
     * @param num
     * @param num1
     * @param scale
     * @return
     */
    public static BigDecimal multiply(String num, String num1, int scale) {
        BigDecimal mul = new BigDecimal(num);
        BigDecimal mul1 = new BigDecimal(num1);
        return multiply(mul, mul1, scale);
    }


    /**
     * 提供精确的乘法运算(默认四舍五入，保留小数位数根据scale确定)
     * @param num
     * @param num1
     * @param scale
     * @return
     */
    public static BigDecimal multiply(BigDecimal num, BigDecimal num1, int scale) {
        return num.multiply(num1).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }


    /**
     * 除法(除法除不尽会抛异常)
     * @param num
     * @param num1
     * @return
     */
    public static BigDecimal divide(BigDecimal num, BigDecimal num1) {
        return num.divide(num1, DEF_DIV_SCALE);
    }


    /**
     * 提供精确的除法运算(默认四舍五入保留两位小数)
     * @param dividend
     * @param divisor
     * @return
     */
    public static BigDecimal divide(BigDecimal dividend, BigDecimal divisor, int scale) {
        return dividend.divide(divisor, scale, BigDecimal.ROUND_HALF_UP);
    }


    /**
     * 提供精确的除法运算(默认四舍五入，保留小数位数根据scale决定)
     * @param dividend
     * @param divisor
     * @param scale
     * @return
     */
    public static BigDecimal divide(String dividend, String divisor, int scale) {
        BigDecimal num = new BigDecimal(dividend);
        BigDecimal num1 = new BigDecimal(divisor);
        return divide(num, num1, scale);
    }


    /**
     * 提供精确的取余数运算(小数保留位数根据scale决定)
     * @param dividend
     * @param divisor
     * @param scale
     * @return
     */
    public static BigDecimal balance(BigDecimal dividend, BigDecimal divisor, int scale) {
        return dividend.remainder(divisor).setScale(scale);
    }


    /**
     * 提供精确的取余数运算(默认保留两位小数)
     * @param dividend
     * @param divisor
     * @param scale
     * @return
     */
    public static BigDecimal balance(BigDecimal dividend, BigDecimal divisor) {
        return dividend.remainder(divisor).setScale(DEF_DIV_SCALE);
    }


    /**
     * 比较BigDecimal,
     * 相等返回0,
     * num>num1返回1,
     * num<num1返回-1
     * @param num
     * @param num1
     * @return
     */
    public static int compareTo(BigDecimal num, BigDecimal num1) {
        return num.compareTo(num1);
    }


    /**
     * BigDecimal货币格式化
     * @param money
     * @return
     */
    public static String currencyFormat(BigDecimal money) {
        return currency.format(money);
    }


    /**
     * BigDecimal百分比格式化
     * @param rate
     * @return
     */
    public static String rateFormat(BigDecimal rate) {
        return percent.format(rate);
    }


    public static void main(String[] args) {
        BigDecimal divide = divide("12", "11", 2);
        System.out.println(divide.doubleValue());

        BigDecimal num1 = new BigDecimal("121");
        BigDecimal num2 = new BigDecimal("122");
        System.out.println(compareTo(num1, num2));

        String currencyFormat = currencyFormat(num2);
        System.out.println(currencyFormat);

        String rateFormat = rateFormat(num2);
        System.out.println(rateFormat);
    }

}
