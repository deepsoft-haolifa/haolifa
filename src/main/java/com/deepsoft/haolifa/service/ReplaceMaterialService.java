package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.ReplaceMaterial;
import com.deepsoft.haolifa.model.dto.replaceMaterial.ReplaceMaterialAuditDTO;
import com.deepsoft.haolifa.model.dto.replaceMaterial.ReplaceMaterialDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.replaceMaterial.ReplaceMaterialConditionDTO;

public interface ReplaceMaterialService {

    /**
     * 车间主任添加更换料请求
     *
     * @param model
     * @return
     */
    ResultBean save(ReplaceMaterialDTO model);

    /**
     * 获取更换料详情
     *
     * @return
     */
    ReplaceMaterial getInfoById(int id);

    /**
     * 车间主任更新更换料请求
     *
     * @param model
     * @return
     */
    ResultBean update(ReplaceMaterialDTO model);

    /**
     * 车间主任删除
     *
     * @return
     */
    ResultBean delete(int id);

    /**
     * 更换料列表
     *
     * @param conditionDTO
     * @return
     */
    ResultBean pageInfo(ReplaceMaterialConditionDTO conditionDTO);

    /**
     * 审核更换料
     *
     * @return
     */
    ResultBean checkReplaceMaterial(ReplaceMaterialAuditDTO replaceMaterialAuditDTO);


}
