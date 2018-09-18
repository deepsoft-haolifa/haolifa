package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.util.Base64Utils;
import com.deepsoft.haolifa.util.FastDFSClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class FileUpDnController {

    @Value("${project.url}")
    private String CLIENT_IMG_URL;

    @RequestMapping("/pic/upload")
    @ResponseBody
    public ResultBean picUpload(MultipartFile uploadFile) {
        try {
            if (uploadFile == null || uploadFile.isEmpty()) {
                log.error("picUpload error: uploadFile is NULL");
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
            }
            String originalFilename = uploadFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:properties/fdfs_client.conf");
            String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
            String fullUrl = CLIENT_IMG_URL + url;
            Map<String, String> map = new HashMap<>();
            map.put("url", url);
            map.put("fullUrl", fullUrl);
            return ResultBean.success(map);
        } catch (Exception e) {
            log.error("picUpload error: " + String.valueOf(e));
            return ResultBean.error(CommonEnum.ResponseEnum.SYSTEM_ERROR);
        }
    }

    @RequestMapping("/base64/upload")
    @ResponseBody
    public ResultBean base64Upload(String base64Pic) {
        try {
            if (StringUtils.isBlank(base64Pic)) {
                log.error("picUpload error: uploadFile is NULL");
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
            }
            String extName = base64Pic.split(";")[0].split("/")[1];
            if (StringUtils.isBlank(extName)) {
                log.error("picUpload error: extName is NULL");
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
            }
            byte[] bytes = Base64Utils.base64ToByte(base64Pic);
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:properties/fdfs_client.properties");
            String url = fastDFSClient.uploadFile(bytes, extName);
            String fullUrl = CLIENT_IMG_URL + url;
            Map<String, String> map = new HashMap<>();
            map.put("url", url);
            map.put("fullUrl", fullUrl);
            return ResultBean.success(map);
        } catch (Exception e) {
            log.error("base64 error: " + String.valueOf(e));
            return ResultBean.error(CommonEnum.ResponseEnum.SYSTEM_ERROR);
        }
    }

    @RequestMapping(value = "/download")
    public ResponseEntity<byte[]> download(String filePath) {
        try {
            String substr = filePath.substring(filePath.indexOf("group"));
            String group = substr.split("/")[0];
            String remoteFileName = substr.substring(substr.indexOf("/") + 1);
            String specFileName = substr.substring(substr.indexOf("."));
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:properties/fdfs_client.properties");
            return fastDFSClient.downloadFile(group, remoteFileName, specFileName);
        } catch (Exception e) {

        }
        return null;
    }

}
