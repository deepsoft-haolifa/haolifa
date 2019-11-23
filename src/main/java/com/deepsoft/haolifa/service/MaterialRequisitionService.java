package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.MaterialRequisition;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 领料单表 服务类
 * </p>
 *
 * @author murphy.he
 * @since 2019-11-23
 */
public interface MaterialRequisitionService extends IService<MaterialRequisition> {

    /**
     * 核料清单-- 保存领料单
     *
     * @param list
     * @return
     */
    boolean addBatch(List<MaterialRequisition> list);
}
