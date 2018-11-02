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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
        List<FlowStep> flowSteps = rangeStepArray(model.getFlowId(), 0, 3);
        // 获取默认初始化节点
        FlowStep prevStep = flowSteps.get(0);
        // 获取当前后节点
        FlowStep currentStep = flowSteps.get(1);
        // 获取下一节点
        FlowStep nextStep = flowSteps.get(2);
        // 添加当前流程实例
        FlowInstance flowInstance = new FlowInstance();
        flowInstance.setCreateUserId(getLoginUserId());
        flowInstance.setFlowId(model.getFlowId());
        flowInstance.setSummary(model.getSummary());
        flowInstance.setUserId(Integer.parseInt(currentStep.getUserId()));
        flowInstance.setRoleId(currentStep.getRoleId());
        flowInstance.setPrevStepId(prevStep.getStepId());
        flowInstance.setCurrentStepId(currentStep.getStepId());
        flowInstance.setNextStepId(nextStep == null ? 0 : nextStep.getStepId()); // 无下个节点
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
        flowHistory.setStepId(prevStep.getStepId());
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
                if (flowInstance.getNextStepId() == 0) {
                    // 流程结束
                    updateInstance.setIsOver(CommonEnum.Consts.YES.code);
                } else {
                    // 流程实例更新
                    // 获取孩子节点以及孙子节点信息
                    List<FlowStep> childFlowStep = new ArrayList<>(rangeStepArray(flowInstance.getFlowId(), flowInstance.getCurrentStepId(), 2));
                    FlowStep nextStep = childFlowStep.get(0);
                    FlowStep grandStep = childFlowStep.get(1);
                    updateInstance.setPrevStepId(flowInstance.getCurrentStepId());
                    updateInstance.setCurrentStepId(flowInstance.getNextStepId());
                    updateInstance.setRoleId(nextStep.getRoleId());
                    updateInstance.setUserId(model.getAllotUserId() == null ? Integer.parseInt(nextStep.getUserId()) : model.getAllotUserId());
                    updateInstance.setNextStepId(grandStep.getStepId() == null ? 0 : grandStep.getStepId());//最后一个节点无下一个节点
                }
            } else {
                // 退回
                flowHistory.setAuditResult(CommonEnum.Consts.AUDIT_BACK.code);
                if (flowInstance.getPrevStepId() == 0) { // 如果上一节点为0 表示不可再退回
                    return ResultBean.error(CommonEnum.ResponseEnum.STEP_BACK_ERROR);
                }
                // 是否指定了退回节点
                if (model.getBackStepId() == null) {
                    return ResultBean.error(CommonEnum.ResponseEnum.BACK_STEP_NOT_EXIST);
                }
                // 实例退回至指定节点:currentStep = backStep
                FlowStepExample flowStepExample = new FlowStepExample();
                FlowStepExample.Criteria criteria = flowStepExample.createCriteria();
                criteria.andFlowIdEqualTo(flowInstance.getFlowId()).andStepIdEqualTo(model.getBackStepId());
                FlowStep currentStep = flowStepMapper.selectByExample(flowStepExample).get(0);
                List<FlowStep> fatherFlowStep = new ArrayList<>(rangeStepArray(flowInstance.getFlowId(), model.getBackStepId(), -1));
                List<FlowStep> childFolwStep = new ArrayList<>(rangeStepArray(flowInstance.getFlowId(), model.getBackStepId(), 1));

                FlowStep prevStep = fatherFlowStep.get(0);
                FlowStep nextStep = childFolwStep.get(0);
                updateInstance.setCurrentStepId(currentStep.getStepId());
                updateInstance.setPrevStepId(prevStep.getStepId() == null ? 0 : prevStep.getStepId());// 初始化节点无上一个节点
                updateInstance.setNextStepId(nextStep.getStepId());
                updateInstance.setRoleId(nextStep.getRoleId());
                // 实例退回标示 变为true
                updateInstance.setIsBack(CommonEnum.Consts.YES.code);
                // 获取上一节点的审核人//可能存在指定分配，所以从历史中查询审核人
                FlowHistoryExample flowHistoryExample = new FlowHistoryExample();
                flowHistoryExample.createCriteria().andInstanceIdEqualTo(flowInstance.getId()).andStepIdEqualTo(currentStep.getStepId());
                FlowHistory flowHistorySwap = historyMapper.selectByExample(flowHistoryExample).get(0);
                updateInstance.setUserId(flowHistorySwap.getAuditUserId());
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

    /**
     * 获取有序节点列表指定位置，向前或向后若干范围内的子序列（不包含自身）。若range=0 ,则返回完整列表
     *
     * @param flowId
     * @param stepId
     * @param range
     * @return
     */
    private List<FlowStep> rangeStepArray(Integer flowId, Integer stepId, Integer range) {
        // 查询结果按照step_order升序
        FlowStepExample flowStepExample = new FlowStepExample();
        FlowStepExample.Criteria criteria = flowStepExample.createCriteria();
        criteria.andFlowIdEqualTo(flowId);
        flowStepExample.setOrderByClause("step_order asc");
        List<FlowStep> flowSteps = flowStepMapper.selectByExample(flowStepExample);
        int beginIdx = 0;
        boolean findflag = false;
        for (int i = 0; i < flowSteps.size(); i++) {
            if (stepId == flowSteps.get(i).getStepId()) {
                beginIdx = i;
                findflag  =true;
                break;
            }
        }
        List<FlowStep> result = flowSteps;
        if (range < 0) {
            if (range + beginIdx < 0) {
                result = flowSteps.subList(0, beginIdx);
            } else {
                result = flowSteps.subList(range + beginIdx, beginIdx);
            }
        } else if (range > 0) {
            if (findflag)
                beginIdx += 1;
            if ((beginIdx + range) > flowSteps.size()) {
                result = flowSteps.subList(beginIdx, flowSteps.size());
            } else {
                result = flowSteps.subList(beginIdx, beginIdx + range);
            }
        }
        if (range != 0 && result.size() < Math.abs(range)) {
            final int len = result.size() == 0 ? Math.abs(range) : result.size();
            for (int i = 0; i < len; i++) {
                result.add(new FlowStep());
            }
            if (range < 0) // 保证有序
                Collections.reverse(result);
        }
        return result;
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
        if (getLoginUserId() == flowInstance.getUserId() && flowInstance.getIsOver() == 0) {
            // 当前查看用户是该节点的处理人 并且流程未结束
            // 如果当前实例的退回标示为true，则查询当前节点的审核历史，供审核人重新审核
            if (flowInstance.getIsBack().intValue() == 1) {
                // 如果是被退回至当前节点，则查询最晚的一次审核信息
                historyInfo.setStepId(flowInstance.getCurrentStepId());
                List<HistoryInfo> historyInfoOlds = instanceHistoryMapper.selectInstanceHistory(historyInfo);
                instanceRecordDTO.setDealStep(historyInfoOlds.get(historyInfoOlds.size() - 1));
            } else {
                historyInfo.setStepId(flowInstance.getCurrentStepId());
                instanceRecordDTO.setDealStep(historyInfo);
            }
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
        FlowInstance flowInstance = instanceMapper.selectByPrimaryKey(instanceId);
        List<BackStepDTO> backStepDTOS = instanceHistoryMapper.selectBackStepsByFlowIdAndStepId(flowInstance.getFlowId(), flowInstance
                .getCurrentStepId());
        return ResultBean.success(backStepDTOS);
    }
}
