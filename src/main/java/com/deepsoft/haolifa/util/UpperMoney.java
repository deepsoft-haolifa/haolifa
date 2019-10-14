package com.deepsoft.haolifa.util;

public class UpperMoney {

    public static String upper(String money) {
        if (!money.matches("^[1-9]+[0-9]*$|^[1-9]+[0-9]*.[0-9]+$")) {
            System.out.println("钱数格式错误！");
            return "";
        }
        String[] part = money.split("\\.");
        StringBuffer integer = new StringBuffer();
        for (int i = 0; i < part[0].length(); i++) {
            char perchar = part[0].charAt(i);
            integer.append(upperNumber(perchar));
            integer.append(upperNumber(part[0].length() - i - 1));
        }

        StringBuffer decimal = new StringBuffer();
        if (part.length > 1 && !"00".equals(part[1])) {
            int length = part[1].length() >= 2 ? 2 : part[1].length();
            for (int i = 0; i < length; i++) {
                char perchar = part[1].charAt(i);
                decimal.append(upperNumber(perchar));
                if (i == 0) {
                    decimal.append("角");
                }
                if (i == 1) {
                    decimal.append("分");
                }
            }
        }
        String result = integer.toString() + decimal.toString();
        return dispose(result);
    }

    private static String upperNumber(char number) {
        switch (number) {
            case '0':
                return "零";
            case '1':
                return "壹";
            case '2':
                return "贰";
            case '3':
                return "叁";
            case '4':
                return "肆";
            case '5':
                return "伍";
            case '6':
                return "陆";
            case '7':
                return "柒";
            case '8':
                return "捌";
            case '9':
                return "玖";
        }
        return "";
    }

    private static String upperNumber(int index) {

        switch (index) {
            case 0:
                return "圆";
            case 1:
                return "拾";
            case 2:
                return "佰";
            case 3:
                return "仟";
            case 4:
                return "万";
            case 5:
                return "拾";
            case 6:
                return "佰";
            case 7:
                return "仟";
            case 8:
                return "亿";
            case 9:
                return "拾";
            case 10:
                return "佰";
            case 11:
                return "仟";
        }
        return "";
    }

    private static String dispose(String result) {
        result = result.replaceAll("零仟零佰零拾|零仟零佰|零佰零拾|零仟|零佰|零拾", "零")
            .replaceAll("零+", "零").replace("零亿", "亿");
        result = result.matches("^.*亿零万[^零]仟.*$") ? result.replace("零万", "零")
            : result.replace("零万", "万");
        result = result.replace("亿万", "亿")
            .replace("零圆", "圆").replace("零分", "")
            .replaceAll("圆零角零分|圆零角$|圆$", "圆整");
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(upper("100.00"));
    }
}
