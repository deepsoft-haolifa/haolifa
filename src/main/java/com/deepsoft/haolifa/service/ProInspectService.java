package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.proInspect.ProInspectConditionDTO;
import com.deepsoft.haolifa.model.dto.proInspect.ProInspectRecordDTO;

public interface ProInspectService {

    /**
     * 创建成品送检报告
     *
     * @param model
     * @return
     */
    ResultBean save(ProInspectRecordDTO model);
    ResultBean update(ProInspectRecordDTO model);


    /**
     * 删除成品送检报告
     *
     * @param id
     * @return
     */
    ResultBean delete(Integer id);

    /**
     * 查询列表
     *
     * @param model
     * @return
     */
    ResultBean pageInfo(ProInspectConditionDTO model);

    /**
     * 更新入库状态
     *
     * @return
     */
    int updateStorageStatus(int id, Byte storageStatus);
}
