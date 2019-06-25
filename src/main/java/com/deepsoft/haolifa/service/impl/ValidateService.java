package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum.ResponseEnum;
import com.deepsoft.haolifa.dao.repository.MaterialMapper;
import com.deepsoft.haolifa.model.domain.Material;
import com.deepsoft.haolifa.model.domain.MaterialExample;
import com.deepsoft.haolifa.model.dto.BaseException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Slf4j
@Service
public class ValidateService {

  @Autowired
  private MaterialMapper materialMapper;

  public void validateIsExistMaterialGraphNo(String materialGraphNo) {
    MaterialExample example = new MaterialExample();
    example.createCriteria().andGraphNoEqualTo(materialGraphNo);
    List<Material> materials = materialMapper.selectByExample(example);
    if(CollectionUtils.isEmpty(materials)) {
      throw new BaseException(ResponseEnum.MATERIAL_HANDLED_GRAPH_NO_NOT_EXIST);
    }
  }

}
