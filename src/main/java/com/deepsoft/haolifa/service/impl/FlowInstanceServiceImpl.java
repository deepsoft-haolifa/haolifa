package com.deepsoft.haolifa.service.impl;


import com.deepsoft.haolifa.dao.repository.FlowHistoryMapper;
import com.deepsoft.haolifa.dao.repository.FlowInstanceMapper;
import com.deepsoft.haolifa.dao.repository.FlowStepMapper;
import com.deepsoft.haolifa.model.domain.FlowInstance;
import com.deepsoft.haolifa.model.domain.FlowStep;
import com.deepsoft.haolifa.model.domain.FlowStepExample;
import com.deepsoft.haolifa.model.dto.FlowHandleStepDTO;
import com.deepsoft.haolifa.model.dto.FlowInstanceDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.FlowInstanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

@Slf4j
@Service
public class FlowInstanceServiceImpl implements FlowInstanceService {

    @Autowired
    private FlowInstanceMapper instanceMapper;

    @Autowired
    private FlowHistoryMapper historyMapper;

    @Autowired
    private FlowStepMapper flowStepMapper;

    @Override
    public ResultBean create(FlowInstanceDTO model) {
        //1、 添加一条初始化历史记录（流程节点表单内容通过单独的接口，前端调用添加）
        //2、添加实例信息，当前节点为初始化后节点
        //3、返回实例id
        FlowStepExample flowStepExample = new FlowStepExample();
        flowStepExample.createCriteria().andFlowIdEqualTo(model.getFlowId());
        List<FlowStep> flowSteps = flowStepMapper.selectByExample(flowStepExample);
        FlowInstance flowInstance = new FlowInstance();

        return null;
    }

    @Override
    public ResultBean handleStep(FlowHandleStepDTO model) {
        // 1、判断传入的处理节点和instance当前要处理的节点是否一致。
        //2、一致：判断审核结果：0 终止 1 通过 2 退回
        // 审核通过：添加历史记录，并更新下一节点信息；终止、退回，添加记录，更新实例记录is_over；
        return null;
    }

    @Override
    public ResultBean flowInstanceHistory(Integer instaceId) {
        // 1、返回实例的历史审核信息，以及当前要处理的节点
        return null;
    }
}
