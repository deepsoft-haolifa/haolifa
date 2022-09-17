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
     * BigDecimal 转大写
     * @param
     * @return
     */
    public static String upperCase(double money){
        String[] upNum = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
        String[] danwei = {"圆","拾","佰","仟","万","拾","佰","仟","亿","拾","佰","仟"};
        //取消科学记数法
        NumberFormat numFormat = NumberFormat.getInstance();
        numFormat.setMaximumFractionDigits(2);//设置小数位个数
        numFormat.setGroupingUsed(false);//取消科学技术发
        String formatNum = numFormat.format(money);
        String strmoney = formatNum + "";//浮点型转为字符型
        String lastUpNum = "null"; //用于存放上个参数的值
        String result = "";//返回的结果
        String[] split = strmoney.split("\\.");
        String strMoney = split[0];
        String point = "";
        //小数部分取值处理。
        if(split.length>1){
            point = split[1];
            if(point.length()==1){
                point = point.concat("0");
            }
        }else {
            point = "0";
        }
        //大于12位就直接返回。
        int moneyLen = strMoney.length();
        if(money==0){
            return "零圆整";
        }
        if(moneyLen>12){
            return "金额："+money+"元，超出大写转换范围。最大金额：999999999999.99元";
        }
        //整数(integer)部分处理。
        if(!"0".equals(strMoney)){
            for (int i = 0; i < moneyLen; i++) {
                String strNum = strMoney.charAt(i)+"";
                int singleNum = Integer.parseInt(strNum);
                String upSingleNum = upNum[singleNum];
                //上一为不等于0的情况
                if(!"零".equals(lastUpNum)){
                    if(!"零".equals(upSingleNum)){
                        result = result.concat(upSingleNum).concat(danwei[moneyLen-i-1]);
                    }else
                        //为零但是在万、亿位上要加单位 (moneyLen-i)==9 指的是单位：亿。  (moneyLen-i)==5指的是单位：万
                        if( (moneyLen-i)==5 || (moneyLen-i)==9 ){
                            lastUpNum="";
                        }else {
                            result=result.concat(upSingleNum);
                        }
                }
                //上一位为0的情况
                if("零".equals(lastUpNum) && !"零".equals(upSingleNum)){
                    result = result.concat(upSingleNum).concat(danwei[moneyLen-i-1]);
                }
                //捕捉上一位数（lastUpNum）为零的情况做优化。
                if((moneyLen-i)==5 || (moneyLen-i)==9 ){
                    //排除加单位时前面为"零"的情况。如：两百零万
                    if("零".equals(lastUpNum)||"null".equals(lastUpNum)){
                        result = result.substring(0,result.length()-1);
                    }
                    if(!result.endsWith("亿")){
                        result = result.concat(danwei[moneyLen-i-1]);
                    }
                    lastUpNum="";
                }else {
                    //把当前大写数字复制给 lastUpNum 用于下次判断
                    lastUpNum = upSingleNum;
                }
            }
            //对几万元整和几亿元整(result:五万零或者五亿零零)做优化。
            result=result.replaceAll("零零","零");
            if(result.endsWith("零")){
                String substring = result.substring(0,result.length() - 1);
                result = substring;
            }
            result = result.concat("圆");
            result = result.replaceAll("圆圆","圆");
            result = result.replaceAll("万万","万");

        }

        //小数(point)部分处理
        if("0".equals(point)){
            result =  result+"整";
        }else {
            //去 整
//            if(result.endsWith("整")){
//                result = result.substring(0,result.length()-1);
//            }
            if((point.charAt(0)+"").equals("0")){
                result = result.concat(upNum[Integer.parseInt(point.charAt(1)+"")]+"分");
            }else if((point.charAt(1)+"").equals("0")){
                result = result.concat(upNum[Integer.parseInt(point.charAt(0)+"")]+"角");
            }else {
                result = result.concat(upNum[Integer.parseInt(point.charAt(0)+"")]+"角").concat(upNum[Integer.parseInt(point.charAt(1)+"")]+"分");
            }
        }
        return result;
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
        String s = upperCase(num);
        System.out.println("你的工资为："+num+"元(取消科学记数法："+salary+"元)\n大写金额:"+s);

    }

}
