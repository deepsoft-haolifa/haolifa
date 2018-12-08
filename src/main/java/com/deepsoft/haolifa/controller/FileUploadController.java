package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.dto.FileUploadDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.util.QiniuUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags = {"文件上传相关"})
@Controller
@RequestMapping("/file")
public class FileUploadController {


    @ApiOperation("base64文件上传接口，返回文件url")
    @PostMapping("/uploadFileBase64")
    @ResponseBody
    public ResultBean uploadFileBase64(@RequestBody FileUploadDTO fileUploadDTO) {
        if (StringUtils.isAnyBlank(fileUploadDTO.getBase64Source(), fileUploadDTO.getFileName())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        String fileUrl = QiniuUtil.uploadFile(fileUploadDTO.getBase64Source(), fileUploadDTO.getFileName());
        return ResultBean.success(fileUrl);
    }
}
