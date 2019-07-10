package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.proInspect.ProInspectConditionDTO;
import com.deepsoft.haolifa.model.dto.proInspect.ProInspectResDTO;

public interface ProInspectResultService {

    /**
     * 创建成品送检报告
     *
     * @param model
     * @return
     */
    ResultBean save(ProInspectResDTO model);

    /**
     * 删除成品送检报告
     *
     * @param id
     * @return
     */
    ResultBean delete(Integer id);

    /**
     * 更新成品送检报告
     *
     * @param model
     * @return
     */
    ResultBean update(ProInspectResDTO model);

    /**
     * 查询详情
     *
     * @param inspectNo
     * @return
     */
    ResultBean getInfo(String inspectNo);

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
    int updateStorageStatus(String inspectNo, Byte storageStatus);
}
