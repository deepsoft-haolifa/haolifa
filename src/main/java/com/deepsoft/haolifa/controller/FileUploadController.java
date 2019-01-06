package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.annotation.LogNotPrint;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.domain.FileRecord;
import com.deepsoft.haolifa.model.dto.FileUploadDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.file.FileRecordConditionDTO;
import com.deepsoft.haolifa.model.dto.file.FileRecordDTO;
import com.deepsoft.haolifa.service.FileRecordService;
import com.deepsoft.haolifa.util.QiniuUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"文件上传相关"})
@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Autowired
    FileRecordService fileRecordService;

    @ApiOperation("base64文件上传接口，返回文件url")
    @PostMapping("/uploadFileBase64")
    @LogNotPrint
    public ResultBean uploadFileBase64(@RequestBody FileUploadDTO fileUploadDTO) {
        if (StringUtils.isAnyBlank(fileUploadDTO.getBase64Source(), fileUploadDTO.getFileName())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        String fileUrl = QiniuUtil.uploadFile(fileUploadDTO.getBase64Source(), fileUploadDTO.getFileName());
        return ResultBean.success(fileUrl);
    }

    @ApiOperation("添加文件")
    @PostMapping("/save")
    public ResultBean save(@RequestBody FileRecordDTO model) {
        return fileRecordService.save(model);
    }

    @ApiOperation("編輯文件")
    @PutMapping("/update")
    public ResultBean update(@RequestBody FileRecordDTO model) {
        return fileRecordService.update(model);
    }


    @ApiOperation("文件详情")
    @GetMapping("/info/{id}")
    public ResultBean noticeInfo(@PathVariable("id") int id) {
        return ResultBean.success(fileRecordService.info(id));
    }

    @ApiOperation("删除文件")
    @DeleteMapping("/delete/{id}")
    public ResultBean auditNotice(@PathVariable("id") int id) {
        return fileRecordService.delete(id);
    }

    @ApiOperation("文件列表")
    @PostMapping("/pageInfo")
    public ResultBean noticeList(@RequestBody FileRecordConditionDTO model) {
        return fileRecordService.pageInfo(model);
    }


}
