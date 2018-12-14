package com.deepsoft.haolifa.service.impl;


import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.FlowHistoryMapper;
import com.deepsoft.haolifa.dao.repository.FlowInstanceMapper;
import com.deepsoft.haolifa.dao.repository.FlowStepMapper;
import com.deepsoft.haolifa.dao.repository.extend.FlowInstanceHistoryMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.service.FlowInstanceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.print.DocFlavor;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class FlowInstanceServiceImpl extends BaseService implements FlowInstanceService {

    @Autowired
    private FlowInstanceMapper instanceMapper;

    @Autowired
    private FlowHistoryMapper historyMapper;

    @Autowired
    private FlowStepMapper flowStepMapper;

    @Autowired
    private FlowInstanceHistoryMapper instanceHistoryMapper;

    @Override
    public ResultBean create(FlowInstanceDTO model) {
        //1、 添加一条初始化历史记录（流程节点表单内容通过单独的接口，前端调用添加）
        //2、添加实例信息，当前节点为初始化后节点
        //3、返回实例id
        FlowStepExample flowStepExample = new FlowStepExample();
        flowStepExample.createCriteria().andFlowIdEqualTo(model.getFlowId());
        List<FlowStep> flowSteps = flowStepMapper.selectByExample(flowStepExample);
        FlowStep initStep = new FlowStep();
        for (int i = 0; i < flowSteps.size(); i++) {
            FlowStep f = flowSteps.get(i);
            if (f.getPrevStepId() == 0) {
                initStep = f;
            }
        }
        // 获取第一个节点
        FlowStep currentStep = new FlowStep();
        for (int i = 0; i < flowSteps.size(); i++) {
            FlowStep f = flowSteps.get(i);
            if (initStep.getConditionTrue() == f.getStepId()) {
                currentStep = f;
            }
        }
        // 添加当前流程实例
        FlowInstance flowInstance = new FlowInstance();
        flowInstance.setCreateUserId(getLoginUserId());
        flowInstance.setFlowId(model.getFlowId());
        flowInstance.setSummary(model.getSummary());
        flowInstance.setUserId(currentStep.getUserId());
        flowInstance.setRoleId(currentStep.getRoleId());
        flowInstance.setCurrentStepId(currentStep.getStepId());
        flowInstance.setFormNo(model.getFormNo());// 流程初始化关联的主表单编号（采购单、生产订单、发票编号、机加工等）
        instanceMapper.insertSelective(flowInstance);
        // 添加初始化流程实例历史（默认第一条已处理）
        FlowHistory flowHistory = new FlowHistory();
        flowHistory.setInstanceId(flowInstance.getId());
        flowHistory.setFormId(model.getFormId());
        flowHistory.setFormNo(model.getFormNo());
        flowHistory.setAuditUserId(getLoginUserId());
        flowHistory.setFormType(model.getFormType().byteValue());
        flowHistory.setAuditResult(CommonEnum.Consts.FLOW_INIT.code);// 流程初始化历史
        flowHistory.setStepId(initStep.getStepId());
        historyMapper.insertSelective(flowHistory);
        Map<String, Object> result = new HashMap<>(4);
        result.put("instanceId", flowInstance.getId());
        return ResultBean.success(result);
    }

    @Override
    public ResultBean handleStep(FlowHandleStepDTO model) {
        // 1、判断传入的处理节点和instance当前要处理的节点是否一致。
        //2、一致：判断审核结果：0 审核不通过 1 通过 2 退回
        // 审核通过：添加历史记录，并更新下一节点信息；终止添加记录，更新实例记录is_over；退回：添加审核记录,更新实例节点状态
        FlowInstance flowInstance = instanceMapper.selectByPrimaryKey(model.getId());
        if (flowInstance.getCurrentStepId() != model.getStepId()) {
            return ResultBean.error(CommonEnum.ResponseEnum.STEP_INCONFORMITY);
        }
        if (flowInstance.getIsOver() == 1) {
            return ResultBean.error(CommonEnum.ResponseEnum.FLOW_IS_OVER);
        }
        // 获取当前待处理节点
        FlowStep currentStep = instanceHistoryMapper.selectFlowStepByStepId(flowInstance.getFlowId(), flowInstance.getCurrentStepId());
        // 添加历史
        FlowHistory flowHistory = new FlowHistory();
        flowHistory.setAuditUserId(getLoginUserId());
        flowHistory.setAuditInfo(model.getAuditInfo());
        flowHistory.setFormId(model.getFormId() == null ? 0 : model.getFormId());
        flowHistory.setFormType(model.getFormType().byteValue());
        flowHistory.setAllotUserId(model.getAllotUserId() == null ? 0 : model.getAllotUserId());
        flowHistory.setInstanceId(model.getId());
        flowHistory.setStepId(model.getStepId());
        // 更新实例
        FlowInstance updateInstance = new FlowInstance();
        updateInstance.setId(model.getId());
        // 默认实例 退回标志位false
        updateInstance.setIsBack(CommonEnum.Consts.NO.code);
        if (model.getAuditResult() == 0) {
            // 审核不通过
            flowHistory.setAuditResult(CommonEnum.Consts.AUDIT_NO_PASS.code);
            // is_over 1 结束
            updateInstance.setIsOver(CommonEnum.Consts.YES.code);
        } else {
            if (model.getAuditResult() == 1) {
                // 通过
                flowHistory.setAuditResult(CommonEnum.Consts.AUDIT_PASS.code);
                // 判断流程是否结束
                if ((model.getCondition() && currentStep.getConditionTrue() == 0)
                        || (!model.getCondition() && currentStep.getConditionFalse() == 0)) {
                    // 流程结束
                    updateInstance.setIsOver(CommonEnum.Consts.YES.code);
                } else {
                    // 流程实例更新
                    // 获取孩子节点
                    FlowStep nextStep = new FlowStep();
                    if (model.getCondition()) {
                        updateInstance.setCurrentStepId(currentStep.getConditionTrue());
                        nextStep = instanceHistoryMapper.selectFlowStepByStepId(flowInstance.getFlowId(), currentStep.getConditionTrue());
                    } else {
                        updateInstance.setCurrentStepId(currentStep.getConditionFalse());
                        nextStep = instanceHistoryMapper.selectFlowStepByStepId(flowInstance.getFlowId(), currentStep.getConditionTrue());
                    }
                    updateInstance.setRoleId(nextStep.getRoleId());
                    // 特殊化处理:采购流程最后一个节点指向发起人
                    if(flowInstance.getFlowId() == 2 && nextStep.getConditionTrue()==0 && nextStep.getConditionFalse()==0) {
                        updateInstance.setUserId(flowInstance.getCreateUserId().toString());
                    } else {
                        updateInstance.setUserId(model.getAllotUserId() == null ? nextStep.getUserId() : model.getAllotUserId().toString());
                    }
                }
            } else {
                // 退回
                flowHistory.setAuditResult(CommonEnum.Consts.AUDIT_BACK.code);
                if (currentStep.getPrevStepId() == 0) { // 如果上一节点为0 表示不可再退回
                    return ResultBean.error(CommonEnum.ResponseEnum.STEP_BACK_ERROR);
                }
                // 是否指定了退回节点
                if (model.getBackStepId() == null) {
                    return ResultBean.error(CommonEnum.ResponseEnum.BACK_STEP_NOT_EXIST);
                }
                // 实例退回至指定节点:currentStep = backStep
                FlowStep currentBackStep = instanceHistoryMapper.selectFlowStepByStepId(flowInstance.getFlowId(), model.getBackStepId());
                updateInstance.setCurrentStepId(currentBackStep.getStepId());
                updateInstance.setRoleId(currentBackStep.getRoleId());
                // 实例退回标示 变为true
                updateInstance.setIsBack(CommonEnum.Consts.YES.code);
                // 获取上一节点的审核人//可能存在指定分配，所以从历史中查询审核人
                FlowHistoryExample flowHistoryExample = new FlowHistoryExample();
                flowHistoryExample.createCriteria().andInstanceIdEqualTo(flowInstance.getId()).andStepIdEqualTo(currentBackStep.getStepId());
                FlowHistory flowHistorySwap = historyMapper.selectByExample(flowHistoryExample).get(0);
                updateInstance.setUserId(flowHistorySwap.getAuditUserId().toString());
            }
        }
        // 添加审核历史
        historyMapper.insertSelective(flowHistory);
        // 更新实例
        instanceMapper.updateByPrimaryKeySelective(updateInstance);
        Map<String, Object> result = new HashMap<>();
        result.put("instanceId", model.getId());
        return ResultBean.success(result);
    }

    @Override
    public ResultBean flowInstanceHistory(Integer instanceId) {
        InstanceRecordDTO instanceRecordDTO = new InstanceRecordDTO();
        // 1、返回实例的历史审核信息
        HistoryInfo historyInfo = new HistoryInfo();
        historyInfo.setInstanceId(instanceId);
        List<HistoryInfo> historyInfos = instanceHistoryMapper.selectInstanceHistory(historyInfo);

        // 2、返回当前要处理的节点
        FlowInstanceWrapper flowInstance = instanceHistoryMapper.selectByPrimaryKey(instanceId);
        // 3、获取FlowStep详情
        FlowStep flowStep = instanceHistoryMapper.selectFlowStepByStepId(flowInstance.getFlowId(), flowInstance.getCurrentStepId());
        List<String> userIds = Arrays.asList(flowInstance.getUserId().split(","));
        if (userIds.contains(getLoginUserId()) && flowInstance.getIsOver() == 0) {
            // 当前查看用户是该节点的处理人 并且流程未结束
            // 如果当前实例的退回标示为true，则查询当前节点的审核历史，供审核人重新审核
            HistoryInfo dealStep = new HistoryInfo();
            if (flowInstance.getIsBack().intValue() == 1) {
                // 如果是被退回至当前节点，则查询最晚的一次审核信息
                historyInfo.setStepId(flowInstance.getCurrentStepId());
                List<HistoryInfo> historyInfoOlds = instanceHistoryMapper.selectInstanceHistory(historyInfo);
                dealStep = historyInfoOlds.get(historyInfoOlds.size() - 1);
            } else {
                flowInstance.getCurrentStepId();
                dealStep.setInstanceId(instanceId);
                dealStep.setStepId(flowInstance.getCurrentStepId());
            }
            // 获取要展示的表单
            String formStepIds = flowStep.getFormShowStepId();
            List<Integer> stepIds = new ArrayList<>();
            if (StringUtils.isNotEmpty(formStepIds)) {
                stepIds = CollectionUtils.arrayToList(formStepIds.split(","));
            }
            if (stepIds.size() == 0) {
                dealStep.setForms(new ArrayList<>());
            } else {
                FlowHistoryExample flowHistoryExample = new FlowHistoryExample();
                flowHistoryExample.createCriteria().andInstanceIdEqualTo(flowInstance.getId()).andStepIdIn(stepIds);
                List<FlowHistory> flowHistories = historyMapper.selectByExample(flowHistoryExample);
                List<Map<String, Integer>> forms = flowHistories.stream().filter(f -> f.getFormId() != 0).map(f -> {
                    Map<String, Integer> map = new HashMap<>();
                    map.put("formId", f.getFormId());
                    map.put("formType", f.getFormType().intValue());
                    return map;
                }).distinct().collect(Collectors.toList());
                dealStep.setForms(forms);
            }
            instanceRecordDTO.setDealStep(dealStep);

        }
        // 当前节点处理人不是当前用户，只返回历史
        instanceRecordDTO.setHistoryInfos(historyInfos);
        instanceRecordDTO.setInitUserId(flowInstance.getInitUserId());
        instanceRecordDTO.setInitUserName(flowInstance.getInitUserName());
        instanceRecordDTO.setInstanceId(flowInstance.getId());
        instanceRecordDTO.setCreateTime(flowInstance.getCreateTime());
        return ResultBean.success(instanceRecordDTO);
    }

    @Override
    public ResultBean backSteps(Integer instanceId) {
        // 获取当前节点之前的前驱节点集合
        FlowInstance flowInstance = instanceMapper.selectByPrimaryKey(instanceId);
        List<BackStepDTO> backStepDTOS = instanceHistoryMapper.selectBackStepsByFlowId(flowInstance.getFlowId());
        Map<Integer, List<BackStepDTO>> backStepSwap = backStepDTOS.stream().collect(Collectors.groupingBy(f -> f.getStepId()));
        int preStepId = 0;
        for (int i = 0; i < backStepDTOS.size(); i++) {
            BackStepDTO backStepDTO = backStepDTOS.get(i);
            if (backStepDTO.getStepId() == flowInstance.getCurrentStepId()) {
                preStepId = backStepDTO.getPrevStepId();
                break;
            }
        }
        List<BackStepDTO> result = new ArrayList<>();
        while (preStepId != 0) {
            BackStepDTO back = backStepSwap.get(preStepId).get(0);
            result.add(back);
            preStepId = back.getPrevStepId();
        }
        return ResultBean.success(result);
    }
}