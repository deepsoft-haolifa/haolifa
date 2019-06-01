package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.FileRecordMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.file.FileRecordConditionDTO;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.file.FileRecordDTO;
import com.deepsoft.haolifa.service.FileRecordService;
import com.deepsoft.haolifa.util.QiniuUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FileRecordServiceImpl extends BaseService implements FileRecordService {

  @Autowired
  private FileRecordMapper fileRecordMapper;

  @Override
  public ResultBean save(FileRecordDTO model) {
    if (StringUtils.isAnyBlank(model.getFileName(), model.getFileBase64(), model.getFileNo())) {
      return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
    }
    if (model.getType() == 0) {
      return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
    }
    // 判断文件名是否存在
    FileRecordExample example = new FileRecordExample();
    example.or().andFileNameEqualTo(model.getFileName());
    List<FileRecord> fileRecords = fileRecordMapper.selectByExample(example);
    if (fileRecords.size() > 0) {
      return ResultBean.error(CommonEnum.ResponseEnum.FILE_NAME_EXIST);
    }
    String fileUrl = QiniuUtil.uploadFile(model.getFileBase64(), model.getFileName(), true);
    model.setFileUrl(fileUrl);
    FileRecord fileRecord = new FileRecord();
    BeanUtils.copyProperties(model, fileRecord);
    int insert = fileRecordMapper.insertSelective(fileRecord);
    if (insert > 0) {
      return ResultBean.success(insert);
    } else {
      return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
    }
  }

  @Override
  public ResultBean update(FileRecordDTO model) {
    if (StringUtils.isNotBlank(model.getFileBase64())) {
      String fileUrl = QiniuUtil.uploadFile(model.getFileBase64(), model.getFileName(), true);
      model.setFileUrl(fileUrl);
    }
    FileRecord fileRecord = new FileRecord();
    BeanUtils.copyProperties(model, fileRecord);
    int update = fileRecordMapper.updateByPrimaryKeySelective(fileRecord);
    if (update > 0) {
      return ResultBean.success(update);
    } else {
      return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
    }
  }

  @Override
  public ResultBean delete(int id) {
    int del = fileRecordMapper.deleteByPrimaryKey(id);
    if (del > 0) {
      return ResultBean.success(del);
    } else {
      return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
    }
  }

  @Override
  public FileRecord info(int id) {
    return fileRecordMapper.selectByPrimaryKey(id);
  }

  @Override
  public ResultBean pageInfo(FileRecordConditionDTO conditionDTO) {
    FileRecordExample example = new FileRecordExample();
    FileRecordExample.Criteria criteria = example.createCriteria();
    if (StringUtils.isNotBlank(conditionDTO.getFileName())) {
      criteria.andFileNameLike("%" + conditionDTO.getFileName() + "%");
    }
    if (StringUtils.isNotEmpty(conditionDTO.getFileNo())) {
      criteria.andFileNoLike("%" + conditionDTO.getFileNo() + "%");
    }
    if (conditionDTO.getType() > 0) {
      criteria.andTypeEqualTo(conditionDTO.getType());
    }
    example.setOrderByClause("id desc");
    Page<FileRecord> fileRecordPage = PageHelper.startPage(conditionDTO.getPageNum(), conditionDTO.getPageSize())
        .doSelectPage(() -> fileRecordMapper.selectByExample(example));

    PageDTO<FileRecord> pageDTO = new PageDTO<>();
    BeanUtils.copyProperties(fileRecordPage, pageDTO);
    pageDTO.setList(fileRecordPage);
    return ResultBean.success(pageDTO);
  }
}
