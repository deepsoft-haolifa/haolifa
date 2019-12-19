package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.vo.PreOutMaterialPageVo;
import com.deepsoft.haolifa.model.vo.PreOutMaterialVo;

import java.util.List;

/**
 * 通用Mapper
 *
 * @author murphy.he
 **/
public interface CommonExtendMapper {

    List<PreOutMaterialVo> pagePreOutMaterial(PreOutMaterialPageVo vo);
}
