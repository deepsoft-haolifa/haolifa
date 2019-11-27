package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.MaterialRequisition;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.vo.PreOutMaterialPageVo;
import com.deepsoft.haolifa.model.vo.PreOutMaterialVo;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * <p>
 * 领料单表 服务类
 * </p>
 *
 * @author murphy.he
 * @since 2019-11-23
 */
public interface MaterialRequisitionService {

    /**
     * 核料清单-- 保存领料单
     *
     * @param list
     * @return
     */
    boolean addBatch(List<MaterialRequisition> list);

    /**
     * 领料单详情
     * @param orderNo
     * @return
     */
    List<MaterialRequisition> detailList(String orderNo);


    /**
     * 零件待出库分页列表
     *
     * @param vo
     * @return
     */
    PageDTO<PreOutMaterialVo> preOutMaterialPage(PreOutMaterialPageVo vo);
}
