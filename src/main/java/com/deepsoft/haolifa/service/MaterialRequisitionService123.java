package com.deepsoft.haolifa.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.deepsoft.haolifa.model.domain.MaterialRequisition;
import com.baomidou.mybatisplus.extension.service.IService;
import com.deepsoft.haolifa.model.vo.PreOutMaterialPageVo;
import com.deepsoft.haolifa.model.vo.PreOutMaterialVo;

import java.util.List;

/**
 * <p>
 * 领料单表 服务类
 * </p>
 *
 * @author murphy.he
 * @since 2019-11-23
 */
public interface MaterialRequisitionService123 {

    /**
     * 核料清单-- 保存领料单
     *
     * @param list
     * @return
     */
    boolean addBatch(List<MaterialRequisition> list);


    /**
     * 零件待出库分页列表
     *
     * @param list
     * @return
     */
    IPage<PreOutMaterialVo> preOutMaterialPage(PreOutMaterialPageVo vo);
}
