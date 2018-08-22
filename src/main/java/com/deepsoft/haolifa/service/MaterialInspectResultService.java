package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.MaterialInspectResDTO;
import com.deepsoft.haolifa.model.dto.MaterialInspectResListDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;

public interface MaterialInspectResultService {
    /**
     * 创建送检报告
     * @param model
     * @return
     */
    ResultBean save(MaterialInspectResDTO model);

    /**
     * 删除送检报告
     * @param id
     * @return
     */
    ResultBean delete(Integer id);

    /**
     * 更新送检报告
     * @param model
     * @return
     */
    ResultBean update(MaterialInspectResDTO model);

    /**
     * 获取详情
     * @param inspectNo
     * @return
     */
    ResultBean getInfo(String inspectNo);

    /**
     * 查询列表
     * @param model
     * @return
     */
    ResultBean getList(MaterialInspectResListDTO model);
}
