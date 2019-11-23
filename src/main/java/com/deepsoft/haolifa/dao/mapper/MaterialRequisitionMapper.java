package com.deepsoft.haolifa.dao.mapper;

import com.deepsoft.haolifa.model.domain.MaterialRequisition;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.deepsoft.haolifa.model.vo.PreOutMaterialPageVo;
import com.deepsoft.haolifa.model.vo.PreOutMaterialVo;

import java.util.List;

/**
 * <p>
 * 领料单表 Mapper 接口
 * </p>
 *
 * @author murphy.he
 * @since 2019-11-23
 */
public interface MaterialRequisitionMapper extends BaseMapper<MaterialRequisition> {

    List<PreOutMaterialVo> pagePreOutMaterial(PreOutMaterialPageVo vo);
}
