package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.SporadicMaterial;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.SporadicMaterialPageDto;

/**
 * @author murphy.he
 **/
public interface SporadicMaterialService {
    /**
     * 新增零星物资
     */
    void add(SporadicMaterial material);

    /**
     * 编辑零星物资
     */
    void update(SporadicMaterial material);

    /**
     * 零星物资分页列表
     */
    PageDTO<SporadicMaterial> pageList(SporadicMaterialPageDto pageDto);
}
