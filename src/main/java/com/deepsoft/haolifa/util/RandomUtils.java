package com.deepsoft.haolifa.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

public class RandomUtils {
    /**
     * 获取固定长度的随机字符串
     *
     * @param length
     * @return
     */
    public static String randomStr(Integer length) {
        String sources = "0123456789abcdefghijklmnopqrstuvwxyz";
        Random rand = new Random();
        StringBuffer flag = new StringBuffer();
        for (int j = 0; j < length; j++) {
            flag.append(sources.charAt(rand.nextInt(36)) + "");
        }
        return flag.toString();
    }

    /**
     * 生成六位随机纯数字
     *
     * @return
     */
    public static String sixRandomNum() {
        int fourBit = (int) Math.random() * 10;
        if (fourBit < 1) {
            fourBit = 1;
        }
        return String.valueOf(fourBit * 100000 + (int) (Math.random() * 10) * 10000 + (int) (Math.random() * 10) * 1000 + (int) (Math.random() * 10) * 100 + (int) (Math.random() * 10) * 10 + (int) (Math.random() * 10));
    }

    /**
     * 生成唯一的随机32位字符串
     *
     * @return
     */
    public static String uuidStr() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString().replace("-", "");
    }

    /**
     * 生成唯一的订单号（时间随机数）
     *
     * @return
     */
    public static String orderNoStr() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return format+sixRandomNum();
    }

    public static void main(String[] args) {
        System.out.println(orderNoStr());
    }
}
