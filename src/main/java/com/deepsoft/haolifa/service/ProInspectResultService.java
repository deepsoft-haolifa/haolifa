package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.MaterialInspectResListDTO;
import com.deepsoft.haolifa.model.dto.ProInspectResDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;

public interface ProInspectResultService {

    /**
     * 创建成品送检报告
     * @param model
     * @return
     */
    ResultBean save(ProInspectResDTO model);

    /**
     * 删除成品送检报告
     * @param id
     * @return
     */
    ResultBean delete(Integer id);

    /**
     * 更新成品送检报告
     * @param model
     * @return
     */
    ResultBean update(ProInspectResDTO model);

    /**
     * 查询详情
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
