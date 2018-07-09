package com.deepsoft.haolifa.utils;




import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * MD5工具类，加盐
 *
 */
public class MD5Util {

    /**
     * 普通MD5
     *
     * @param
     * @return
     * @author daniel
     * @time 2016-6-11 下午8:00:28
     */
    public static String MD5(String input) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            return "check jdk";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        char[] charArray = input.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }


    /**
     * 加盐的md5输出
     *
     * @param input
     */
    public static String getSaltMd5(String input) {
        Random r = new Random();
        String salt = RandomUtil.randomStr(16);
        System.out.println("salt:" + salt);
        String md5Final = MD5(input + salt);
        System.out.println("加盐后的MD5加密:" + MD5(input + salt));
        // 保存盐值 到md5中
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = md5Final.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = md5Final.charAt(i / 3 * 2 + 1);
        }
        String rs = new String(cs);
        return rs;
    }

    /**
     * 加盐的md5验证
     *
     * @param input
     * @param md5str
     * @return
     * @author shizhiguo
     * @date 2017年3月9日 下午2:58:24
     */
    public static boolean verifySaltMd5(String input, String md5str) {
        md5str = md5str.toLowerCase();// 全部转小写
        char[] saltByte = new char[16];
        char[] pwdByte = new char[32];
        for (int i = 0; i < 48; i += 3) {
            pwdByte[i / 3 * 2] = md5str.charAt(i);
            pwdByte[i / 3 * 2 + 1] = md5str.charAt(i + 2);
            saltByte[i / 3] = md5str.charAt(i + 1);
        }
        String salt = new String(saltByte);
        String pwdMd5 = new String(pwdByte);
        if (pwdMd5.equals(MD5(input + salt))) {
            return true;
        }
        return false;
    }

}

