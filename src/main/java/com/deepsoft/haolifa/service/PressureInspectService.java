package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pressureInspect.PressureInspectConditionDTO;
import com.deepsoft.haolifa.model.dto.pressureInspect.PressureInspectRecordDTO;

public interface PressureInspectService {

    /**
     * 创建压力送检报告
     *
     * @param model
     * @return
     */
    ResultBean save(PressureInspectRecordDTO model);

    ResultBean update(PressureInspectRecordDTO model);


    /**
     * 删除压力送检报告
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
    ResultBean pageInfo(PressureInspectConditionDTO model);

}
