package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum.ResponseEnum;
import com.deepsoft.haolifa.dao.repository.SprayColorRelationMapper;
import com.deepsoft.haolifa.model.domain.SprayColorRelation;
import com.deepsoft.haolifa.model.domain.SprayColorRelationExample;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.spraycolor.SprayColorDto;
import com.deepsoft.haolifa.service.SprayColorService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SprayColorServiceImpl extends BaseService implements SprayColorService {

  @Autowired
  private SprayColorRelationMapper colorRelationMapper;

  @Override
  public ResultBean save(SprayColorDto dto) {
    if (StringUtils.isAnyBlank(dto.getColor(), dto.getColorNo())) {
      throw new BaseException(ResponseEnum.PARAM_ERROR);
    }
    SprayColorRelation relation = new SprayColorRelation();
    relation.setColor(dto.getColor());
    relation.setRelationNo(dto.getColorNo());
    colorRelationMapper.insertSelective(relation);
    return ResultBean.success(relation.getId());
  }

  @Override
  public ResultBean delete(Integer id) {
    return ResultBean.success(colorRelationMapper.deleteByPrimaryKey(id));
  }

  @Override
  public ResultBean getAll() {
    return ResultBean.success(colorRelationMapper.selectByExample(new SprayColorRelationExample()));
  }

  @Override
  public ResultBean getList(Integer pageNum, Integer pageSize) {
    Page<SprayColorRelation> page = PageHelper.startPage(pageNum, pageSize)
        .doSelectPage(() -> colorRelationMapper.selectByExample(new SprayColorRelationExample()));
    PageDTO<SprayColorRelation> pageDTO = new PageDTO<>();
    BeanUtils.copyProperties(page, pageDTO);
    pageDTO.setList(page.getResult());
    return ResultBean.success(pageDTO);
  }
}
