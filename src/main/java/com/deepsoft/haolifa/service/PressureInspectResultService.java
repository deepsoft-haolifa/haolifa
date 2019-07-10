package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pressureInspect.PressureInspectConditionDTO;
import com.deepsoft.haolifa.model.dto.pressureInspect.PressureInspectResDTO;

public interface PressureInspectResultService {

    /**
     * 创建压力送检报告
     *
     * @param model
     * @return
     */
    ResultBean save(PressureInspectResDTO model);

    /**
     * 删除压力送检报告
     *
     * @param id
     * @return
     */
    ResultBean delete(Integer id);

    /**
     * 更新压力送检报告
     *
     * @param model
     * @return
     */
    ResultBean update(PressureInspectResDTO model);

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
    ResultBean pageInfo(PressureInspectConditionDTO model);

}
