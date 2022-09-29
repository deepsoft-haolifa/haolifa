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


    /**
     * 汉语中数字大写
     */
    private static final String[] CN_UPPER_NUMBER = { "零", "壹", "贰", "叁", "肆",
        "伍", "陆", "柒", "捌", "玖" };
    /**
     * 汉语中货币单位大写，这样的设计类似于占位符
     */
    private static final String[] CN_UPPER_MONETRAY_UNIT = { "分", "角", "元",
        "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "兆", "拾",
        "佰", "仟" };
    /**
     * 特殊字符：整
     */
    private static final String CN_FULL = "整";
    /**
     * 特殊字符：负
     */
    private static final String CN_NEGATIVE = "负";
    /**
     * 金额的精度，默认值为2
     */
    private static final int MONEY_PRECISION = 2;
    /**
     * 特殊字符：零元整
     */
    private static final String CN_ZEOR_FULL = "零元" + CN_FULL;

    /**
     * 把输入的金额转换为汉语中人民币的大写
     *
     * @param numberOfMoney
     *            输入的金额
     * @return 对应的汉语大写
     */
    public static String number2CNMontrayUnit(BigDecimal numberOfMoney) {
        StringBuffer sb = new StringBuffer();
        // -1, 0, or 1 as the value of this BigDecimal is negative, zero, or
        // positive.
        int signum = numberOfMoney.signum();
        // 零元整的情况
        if (signum == 0) {
            return CN_ZEOR_FULL;
        }
        // 这里会进行金额的四舍五入
        long number = numberOfMoney.movePointRight(MONEY_PRECISION)
            .setScale(0, 4).abs().longValue();
        // 得到小数点后两位值
        long scale = number % 100;
        int numUnit = 0;
        int numIndex = 0;
        boolean getZero = false;
        // 判断最后两位数，一共有四中情况：00 = 0, 01 = 1, 10, 11
        if (!(scale > 0)) {
            numIndex = 2;
            number = number / 100;
            getZero = true;
        }
        if ((scale > 0) && (!(scale % 10 > 0))) {
            numIndex = 1;
            number = number / 10;
            getZero = true;
        }
        int zeroSize = 0;
        while (true) {
            if (number <= 0) {
                break;
            }
            // 每次获取到最后一个数
            numUnit = (int) (number % 10);
            if (numUnit > 0) {
                if ((numIndex == 9) && (zeroSize >= 3)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[6]);
                }
                if ((numIndex == 13) && (zeroSize >= 3)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[10]);
                }
                sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                sb.insert(0, CN_UPPER_NUMBER[numUnit]);
                getZero = false;
                zeroSize = 0;
            } else {
                ++zeroSize;
                if (!(getZero)) {
                    sb.insert(0, CN_UPPER_NUMBER[numUnit]);
                }
                if (numIndex == 2) {
                    if (number > 0) {
                        sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                    }
                } else if (((numIndex - 2) % 4 == 0) && (number % 1000 > 0)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                }
                getZero = true;
            }
            // 让number每次都去掉最后一个数
            number = number / 10;
            ++numIndex;
        }
        // 如果signum == -1，则说明输入的数字为负数，就在最前面追加特殊字符：负
        if (signum == -1) {
            sb.insert(0, CN_NEGATIVE);
        }
        // 输入的数字小数点后两位为"00"的情况，则要在最后追加特殊字符：整
        if (!(scale > 0)) {
            sb.append(CN_FULL);
        }
        return sb.toString();
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


        NumberFormat instance = NumberFormat.getInstance();
        instance.setGroupingUsed(false);
        double num = 20100104600.01;
        String salary = instance.format(num);
//        String s = upperCase(num);
//        System.out.println("你的工资为："+num+"元(取消科学记数法："+salary+"元)\n大写金额:"+s);

    }

}
