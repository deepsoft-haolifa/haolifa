package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.EntrustGraphNoRelationMapper;
import com.deepsoft.haolifa.model.domain.EntrustGraphNoRelation;
import com.deepsoft.haolifa.model.domain.EntrustGraphNoRelationExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.entrust.EntrustRelationDto;
import com.deepsoft.haolifa.service.EntrustRelationService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EntrustRelationServiceImpl extends BaseService implements EntrustRelationService {

  @Autowired
  private EntrustGraphNoRelationMapper entrustRelationMapper;

  @Override
  public ResultBean save(EntrustRelationDto dto) {
    EntrustGraphNoRelation graphNoRelation = new EntrustGraphNoRelation();
    graphNoRelation.setMaterialName(dto.getMaterialName());
    graphNoRelation.setOriginalGraphNo(dto.getOriginalGraphNo());
    graphNoRelation.setProcessedGraphNo(dto.getProcessedGraphNo());
    entrustRelationMapper.insertSelective(graphNoRelation);
    return ResultBean.success(graphNoRelation.getId());
  }

  @Override
  public ResultBean delete(Integer id) {
    return ResultBean.success(entrustRelationMapper.deleteByPrimaryKey(id));
  }

  @Override
  public ResultBean getRelations(String originalGraphNo) {
    EntrustGraphNoRelationExample relationExample = new EntrustGraphNoRelationExample();
    relationExample.createCriteria().andOriginalGraphNoEqualTo(originalGraphNo);
    return ResultBean.success(entrustRelationMapper.selectByExample(relationExample));
  }

  @Override
  public ResultBean getList(Integer pageNum, Integer pageSize) {
    Page<EntrustGraphNoRelation> page = PageHelper.startPage(pageNum, pageSize)
        .doSelectPage(() -> entrustRelationMapper.selectByExample(new EntrustGraphNoRelationExample()));
    PageDTO<EntrustGraphNoRelation> pageDTO = new PageDTO<>();
    BeanUtils.copyProperties(page, pageDTO);
    pageDTO.setList(page.getResult());
    return ResultBean.success(pageDTO);
  }
}
