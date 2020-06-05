package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.FlowHandleStepDTO;
import com.deepsoft.haolifa.model.dto.FlowInstanceDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;

public interface FlowInstanceService {

    /**
     * 初始化流程
     *
     * @param model
     * @return
     */
    ResultBean create(FlowInstanceDTO model);

    /**
     * 节点处理
     *
     * @param model
     * @return
     */
    ResultBean handleStep(FlowHandleStepDTO model);

    /**
     * 获取流程实例审核历史
     *
     * @param instanceId
     * @return
     */
    ResultBean flowInstanceHistory(Integer instanceId);

    /**
     * 获取可退回节点列表
     *
     * @param instanceId
     * @return
     */
    ResultBean backSteps(Integer instanceId);

    ResultBean flowProgress(String formNo, Integer formId);

    ResultBean accessoryInfo(String formNo, Integer formId);

    void deleteFlowInstance(String formNo);

    /**
     * 删除流程历史附件
     *
     * @param historyId
     */
    void removeHistoryAccessory(Integer historyId);
}
