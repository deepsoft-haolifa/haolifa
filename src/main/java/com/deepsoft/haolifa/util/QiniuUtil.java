package com.deepsoft.haolifa.util;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QiniuUtil {

    private static final Logger logger = LoggerFactory.getLogger(QiniuUtil.class);

    private static final Pattern pattern = Pattern.compile("data:image/(.*);base64,(.*)");

    private static final String QINIU_AK = "eL1I7mEOm1JrlO2BsSs0j0fxXCMFo8J1396Uqq_w";
    private static final String QINIU_SK = "2UeiBk74-o7uE_c2K1nXRyo2eSeb4LgSyctV2Dil";
    private static final String QINIU_URL = "http://d.miaojiebei.com/";
    private static final String QINIU_BUCKET = "haolifa";

    public static Map<String, String> parseFileBase64Str(String base64Str, String originFileName) {
        Matcher matcher = pattern.matcher(base64Str);
        String fileName = originFileName;
        String source = null;
        if (matcher.find()) {
            if (org.apache.commons.lang3.StringUtils.isBlank(originFileName)) {
                fileName = System.currentTimeMillis() + "." + matcher.group(1);
            }
            source = matcher.group(2);
        } else {
            throw new BaseException(CommonEnum.ResponseEnum.UPLOAD_PIC_EXT_ERROR);
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("fileName", fileName);
        map.put("source", source);
        return map;
    }

    public static String uploadFile(byte[] fileBytes, String originFileName) {
        try {
            //构造一个带指定Zone对象的配置类
            Configuration cfg = new Configuration(Zone.zone0());
            UploadManager uploadManager = new UploadManager(cfg);
            //...生成上传凭证，然后准备上传
            Auth auth = Auth.create(QINIU_AK, QINIU_SK);
            String token = auth.uploadToken(QINIU_BUCKET);
            String fileKey = originFileName;
            Response res = uploadManager.put(fileBytes, originFileName, token);
            logger.warn("上传文件 " + originFileName + " 到七牛成功");
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(res.bodyString(), DefaultPutRet.class);
            logger.info("新的文件名==>{}", fileKey);
            return QINIU_URL + fileKey;
        } catch (QiniuException e) {
            logger.error("七牛云上传异常==>", e);
        }
        return null;
    }

    public static String uploadFile(String base64Str, String originFileName) {
        Map<String, String> parse = parseFileBase64Str(base64Str, originFileName);
        base64Str = parse.get("source");
        originFileName = parse.get("fileName");
        byte[] bytes = Base64.decodeBytes(base64Str);
        return uploadFile(bytes, originFileName);
    }

    public static String uploadFile(InputStream inputStream, String originFileName) {
        return uploadFile(getBytes(inputStream), originFileName);
    }

    public static String genFileKey(byte[] bytes, String originFileName) {
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        return MD5Utils.MD5(new String(bytes)) + ext;
    }


    /**
     * 将输入流转为byte[]
     *
     * @return
     */
    public static byte[] getBytes(InputStream inputStream) {
        ByteArrayOutputStream out = null;
        try {
            out = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int i = 0;
            while ((i = inputStream.read(b)) != -1) {

                out.write(b, 0, b.length);
            }
            out.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] s = out.toByteArray();
        return s;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String s = uploadFile(new FileInputStream(new File("d://成品订单合同.xls")), "成品订单合同.xls");
        System.out.println(s);
    }
}
