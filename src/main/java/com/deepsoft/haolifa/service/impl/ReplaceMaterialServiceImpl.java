package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.constant.CommonEnum.ResponseEnum;
import com.deepsoft.haolifa.dao.repository.ReplaceMaterialMapper;
import com.deepsoft.haolifa.model.domain.ReplaceMaterial;
import com.deepsoft.haolifa.model.domain.ReplaceMaterialExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.replaceMaterial.ReplaceMaterialAuditDTO;
import com.deepsoft.haolifa.model.dto.replaceMaterial.ReplaceMaterialDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.replaceMaterial.ReplaceMaterialConditionDTO;
import com.deepsoft.haolifa.service.ReplaceMaterialService;
import com.deepsoft.haolifa.util.RandomUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReplaceMaterialServiceImpl extends BaseService implements ReplaceMaterialService {

  @Autowired
  private ReplaceMaterialMapper replaceMaterialMapper;
  @Autowired
  private ValidateService validateService;

  @Override
  public ResultBean save(ReplaceMaterialDTO model) {
    if (StringUtils.isAnyBlank(model.getOrderNo(), model.getMaterialGraphNo()) || model.getMaterialCount() == null
        || model.getMaterialCount() == 0) {
      return ResultBean.error(ResponseEnum.PARAM_ERROR);
    }
    validateService.validateIsExistMaterialGraphNo(model.getMaterialGraphNo());
    validateService.validateIsExistOrderNo(model.getOrderNo());
    ReplaceMaterial record = new ReplaceMaterial();
    BeanUtils.copyProperties(model, record);
    record.setCreateUserId(getLoginUserId());
    record.setReplaceMaterialNo("rm_" + RandomUtils.orderNoStr());
    int insert = replaceMaterialMapper.insertSelective(record);
    if (insert > 0) {
      return ResultBean.success(insert);
    } else {
      return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
    }
  }

  @Override
  public ReplaceMaterial getInfoById(int id) {
    return replaceMaterialMapper.selectByPrimaryKey(id);
  }

  @Override
  public ResultBean update(ReplaceMaterialDTO model) {
    ReplaceMaterial record = new ReplaceMaterial();
    BeanUtils.copyProperties(model, record);
    int insert = replaceMaterialMapper.updateByPrimaryKeySelective(record);
    if (insert > 0) {
      return ResultBean.success(insert);
    } else {
      return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
    }
  }

  @Override
  public ResultBean delete(int id) {
    return ResultBean.success(replaceMaterialMapper.deleteByPrimaryKey(id));
  }

  @Override
  public ResultBean pageInfo(ReplaceMaterialConditionDTO conditionDTO) {
    ReplaceMaterialExample example = new ReplaceMaterialExample();
    ReplaceMaterialExample.Criteria criteria = example.createCriteria();
    if (StringUtils.isNotBlank(conditionDTO.getOrderNo())) {
      criteria.andOrderNoLike("%" + conditionDTO.getOrderNo() + "%");
    }
    if (StringUtils.isNotBlank(conditionDTO.getReplaceMaterialNo())) {
      criteria.andReplaceMaterialNoLike("%" + conditionDTO.getReplaceMaterialNo() + "%");
    }
    if (conditionDTO != null && conditionDTO.getAuditResult() > -1) {
      criteria.andAuditResultEqualTo(conditionDTO.getAuditResult());
    }

    example.setOrderByClause("id desc");
    Page<ReplaceMaterial> replaceMaterialPage = PageHelper
        .startPage(conditionDTO.getPageNum(), conditionDTO.getPageSize())
        .doSelectPage(() -> replaceMaterialMapper.selectByExample(example));

    PageDTO<ReplaceMaterial> pageDTO = new PageDTO<>();
    BeanUtils.copyProperties(replaceMaterialPage, pageDTO);
    pageDTO.setList(replaceMaterialPage);
    return ResultBean.success(pageDTO);
  }

  @Override
  public ResultBean checkReplaceMaterial(ReplaceMaterialAuditDTO replaceMaterialAuditDTO) {

    if (StringUtils.isBlank(replaceMaterialAuditDTO.getReplaceMaterialNo())
        || replaceMaterialAuditDTO.getAuditResult() < 0) {
      return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
    }
    int update = replaceMaterialMapper.updateByExampleSelective(new ReplaceMaterial() {{
      setAuditInfo(replaceMaterialAuditDTO.getAuditInfo());
      setAuditResult(replaceMaterialAuditDTO.getAuditResult());
      setAuditTime(new Date());
      setAuditUserId(getLoginUserId());
    }}, new ReplaceMaterialExample() {{
      or().andReplaceMaterialNoEqualTo(replaceMaterialAuditDTO.getReplaceMaterialNo());
    }});
    if (update > 0) {
      return ResultBean.success(update);
    } else {
      return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
    }
  }
}
