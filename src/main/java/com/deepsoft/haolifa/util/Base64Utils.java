package com.deepsoft.haolifa.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;

public class Base64Utils {
    final static Base64.Decoder decoder = Base64.getDecoder();
    final static Base64.Encoder encoder = Base64.getEncoder();

    //base64字符串转化成byte 数组
    public static byte[] base64ToByte(String base64Str) {   //对字节数组字符串进行Base64解码并生成图片
        if (base64Str == null) //图像数据为空
            return null;
        try {
            //Base64解码
            byte[] b = decoder.decode(base64Str);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {//调整异常数据
                    b[i] += 256;
                }
            }
            return b;
        } catch (Exception e) {
            throw new RuntimeException("base64ToByte error.");
        }
    }

    /**
     * 将文件转为base64
     *
     * @param filePath
     * @return
     */
    public static String encryptToBase64(String filePath) {
        if (filePath == null) {
            return null;
        }
        try {
            byte[] b = Files.readAllBytes(Paths.get(filePath));
            return Base64.getEncoder().encodeToString(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将base64转出文件
     *
     * @param base64
     * @param filePath
     * @return
     */
    public String decryptByBase64(String base64, String filePath) {
        if (base64 == null && filePath == null) {
            return "生成文件失败，请给出相应的数据。";
        }
        try {
            Files.write(Paths.get(filePath), Base64.getDecoder().decode(base64), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "指定路径下生成文件成功！";
    }

    public static void main(String[] args) {
        String fileBase64Str = Base64Utils.encryptToBase64("d:\\123.xls");
        System.out.println(fileBase64Str);
    }
}
