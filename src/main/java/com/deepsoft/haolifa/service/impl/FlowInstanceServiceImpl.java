package com.deepsoft.haolifa.service.impl;


import com.alibaba.fastjson.JSON;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.constant.CommonEnum.Consts;
import com.deepsoft.haolifa.constant.CommonEnum.ResponseEnum;
import com.deepsoft.haolifa.constant.CommonEnum.SupplierIsQualified;
import com.deepsoft.haolifa.dao.repository.FlowHistoryMapper;
import com.deepsoft.haolifa.dao.repository.FlowInstanceMapper;
import com.deepsoft.haolifa.dao.repository.FlowStepMapper;
import com.deepsoft.haolifa.dao.repository.StepMapper;
import com.deepsoft.haolifa.dao.repository.SysRoleMapper;
import com.deepsoft.haolifa.dao.repository.extend.FlowInstanceHistoryMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.model.dto.order.CheckReplaceMaterialAuditDTO;
import com.deepsoft.haolifa.service.FlowInstanceService;
import com.deepsoft.haolifa.service.OrderProductService;
import com.deepsoft.haolifa.service.PurcahseOrderService;
import com.deepsoft.haolifa.service.SupplierService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
  private StepMapper stepMapper;

  @Autowired
  private FlowInstanceHistoryMapper instanceHistoryMapper;

  @Autowired
  private SupplierService supplierService;
  @Autowired
  private PurcahseOrderService purcahseOrderService;
  @Autowired
  private OrderProductService orderProductService;

  @Autowired
  private SysRoleMapper sysRoleMapper;

  @Transactional(rollbackFor = Exception.class)
  @Override
  public ResultBean create(FlowInstanceDTO model) {
    // 判断该表单是否存在处于审批中的流程
    FlowInstanceExample preInstanceExample = new FlowInstanceExample();
    FlowInstanceExample.Criteria criteria = preInstanceExample.createCriteria();
    criteria.andIsOverEqualTo(Consts.NO.code).andFlowIdEqualTo(model.getFlowId());
    if (StringUtils.isEmpty(model.getFormNo()) && model.getFormId() == null) {
      throw new BaseException(ResponseEnum.PARAM_ERROR);
    } else if (StringUtils.isNotEmpty(model.getFormNo())) {
      criteria.andFormNoEqualTo(model.getFormNo());
    } else if(model.getFormId() != null) {
      criteria.andFormIdEqualTo(model.getFormId());
    }
    criteria.andFormTypeEqualTo(model.getFormType().byteValue());
    List<FlowInstance> flowInstances = instanceMapper.selectByExample(preInstanceExample);
    if (flowInstances != null && flowInstances.size() > 0) {
      throw new BaseException(ResponseEnum.FLOW_EXIST);
    }
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
    flowInstance.setFormId(model.getFormId());
    flowInstance.setFormType(model.getFormType().byteValue());
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

  @Transactional(rollbackFor = Exception.class)
  @Override
  public ResultBean handleStep(FlowHandleStepDTO model) {
    // 1、判断传入的处理节点和instance当前要处理的节点是否一致。
    //2、一致：判断审核结果：0 审核不通过 1 通过 2 退回
    // 审核通过：添加历史记录，并更新下一节点信息；终止添加记录，更新实例记录is_over；退回：添加审核记录,更新实例节点状态
    FlowInstance flowInstance = instanceMapper.selectByPrimaryKey(model.getId());
    List<Accessory> accessorys = new ArrayList<>();
    if (flowInstance.getCurrentStepId() != model.getStepId()) {
      return ResultBean.error(CommonEnum.ResponseEnum.STEP_INCONFORMITY);
    }
    if (flowInstance.getIsOver() == 1) {
      return ResultBean.error(CommonEnum.ResponseEnum.FLOW_IS_OVER);
    }
    // 获取当前待处理节点
    FlowStep currentStep = instanceHistoryMapper
        .selectFlowStepByStepId(flowInstance.getFlowId(), flowInstance.getCurrentStepId());
    // 添加历史
    FlowHistory flowHistory = new FlowHistory();
    flowHistory.setAccessory(JSON.toJSONString(model.getAccessorys()));
    flowHistory.setAuditUserId(getLoginUserId());
    flowHistory.setAuditInfo(model.getAuditInfo());
    flowHistory.setFormId(model.getFormId() == null ? 0 : model.getFormId());
    flowHistory.setFormType(model.getFormType().byteValue());
    flowHistory.setAllotUserId(model.getAllotUserId() == null ? 0 : model.getAllotUserId());
    flowHistory.setInstanceId(model.getId());
    flowHistory.setStepId(model.getStepId());
    flowHistory.setAccessory(JSON.toJSONString(model.getAccessorys()));
    // 更新实例
    FlowInstance updateInstance = new FlowInstance();
    if (StringUtils.isNotEmpty(flowInstance.getAccessory())) {
      accessorys = JSON.parseArray(flowInstance.getAccessory(), Accessory.class);
    }
    if (model.getAccessorys() != null) {
      accessorys.addAll(model.getAccessorys());
      flowHistory.setAccessory(JSON.toJSONString(model.getAccessorys()));
    }
    updateInstance.setAccessory(JSON.toJSONString(accessorys));
    updateInstance.setId(model.getId());
    // 默认实例 退回标志位false
    updateInstance.setIsBack(CommonEnum.Consts.NO.code);
    if (model.getAuditResult() == 0) {
      // 审核不通过
      flowHistory.setAuditResult(CommonEnum.Consts.AUDIT_NO_PASS.code);
      // is_over 1 结束
      updateInstance.setIsOver(CommonEnum.Consts.YES.code);
      // 更新 业务表单状态
      updateFormStatus(flowInstance.getFlowId(), flowInstance.getFormNo(), flowInstance.getFormId(),
          model.getAuditResult(), flowInstance.getId());
    } else {
      if (model.getAuditResult() == 1) {
        // 通过
        flowHistory.setAuditResult(CommonEnum.Consts.AUDIT_PASS.code);
        // 判断流程是否结束
        if ((model.getCondition() && currentStep.getConditionTrue() == 0)
            || (!model.getCondition() && currentStep.getConditionFalse() == 0)) {
          // 流程结束
          updateInstance.setIsOver(CommonEnum.Consts.YES.code);
          // 更新 业务表单状态
          updateFormStatus(flowInstance.getFlowId(), flowInstance.getFormNo(), flowInstance.getFormId(),
              model.getAuditResult(), flowInstance.getId());
        } else {
          // 流程实例更新
          // 获取孩子节点
          FlowStep nextStep = new FlowStep();
          if (model.getCondition()) {
            updateInstance.setCurrentStepId(currentStep.getConditionTrue());
            nextStep = instanceHistoryMapper
                .selectFlowStepByStepId(flowInstance.getFlowId(), currentStep.getConditionTrue());
          } else {
            updateInstance.setCurrentStepId(currentStep.getConditionFalse());
            nextStep = instanceHistoryMapper
                .selectFlowStepByStepId(flowInstance.getFlowId(), currentStep.getConditionFalse());
          }
          updateInstance.setRoleId(nextStep.getRoleId());
          // 指定人 则填写分配的人，若无，则正常
          updateInstance
              .setUserId(model.getAllotUserId() == null ? nextStep.getUserId() : model.getAllotUserId().toString());

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
        FlowStep currentBackStep = instanceHistoryMapper
            .selectFlowStepByStepId(flowInstance.getFlowId(), model.getBackStepId());
        updateInstance.setCurrentStepId(currentBackStep.getStepId());
        updateInstance.setRoleId(currentBackStep.getRoleId());
        // 实例退回标示 变为true
        updateInstance.setIsBack(CommonEnum.Consts.YES.code);
        // 获取上一节点的审核人//可能存在指定分配，所以从历史中查询审核人
        FlowHistoryExample flowHistoryExample = new FlowHistoryExample();
        flowHistoryExample.createCriteria().andInstanceIdEqualTo(flowInstance.getId())
            .andStepIdEqualTo(currentBackStep.getStepId());
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

  /**
   * 更新业务审批状态： 生产，采购，替换料，供应商
   */
  private void updateFormStatus(Integer flowId, String formNo, Integer formId, Integer auditRes, Integer instanceId) {
    switch (flowId) {
      case 1:
        // 生产
        if (auditRes == 1) {
          // 审核通过
          orderProductService.updateOrderProductStatus(formNo, CommonEnum.OrderStatus.PRODUCTION.code);
        } else if (auditRes == 0) {
          // 审核不通过
          orderProductService.updateOrderProductStatus(formNo,  CommonEnum.OrderStatus.AUDIT_ORDER_CLOSE.code);
          orderProductService.releaseMaterial(formNo);
        }
        break;
        case 6:
            // 不核料生产订单审批
            if (auditRes == 1) {
                // 审核通过
                orderProductService.updateOrderProductStatus(formNo, CommonEnum.OrderStatus.PRODUCTION.code);
            } else if (auditRes == 0) {
                // 审核不通过
                orderProductService.updateOrderProductStatus(formNo,  CommonEnum.OrderStatus.AUDIT_ORDER_CLOSE.code);
                orderProductService.releaseMaterial(formNo);
            }
            break;
      case 2:
        // 采购
        if (auditRes == 1) {
          // 审核通过
          purcahseOrderService.updateOrderStatus(formId, 3);
        } else if (auditRes == 0) {
          // 审核不通过
          purcahseOrderService.updateOrderStatus(formId, 4);
        }
        break;
      case 5:
        // 机加工
        if (auditRes == 1) {
          // 审核通过
          purcahseOrderService.updateOrderStatus(formId, 3);
        } else if (auditRes == 0) {
          // 审核不通过
          purcahseOrderService.updateOrderStatus(formId, 4);
        }
        break;
      case 3:
        // 供应商审批
        if (auditRes == 1) {
          // 审核通过
          supplierService.updateSupplierStatus(formNo, 1, instanceId);
        } else if (auditRes == 0) {
          // 审核不通过
          supplierService.updateSupplierStatus(formNo, 2, instanceId);
        }
        break;
      case 4:
        // 替换料审批
        CheckReplaceMaterialAuditDTO auditDTO = new CheckReplaceMaterialAuditDTO();
        auditDTO.setOrderMaterialId(formId);
        if (auditRes == 1) {
          // 审核通过
          auditDTO.setAuditResult((byte) 1);
        } else if (auditRes == 0) {
          // 审核不通过
          auditDTO.setAuditResult((byte) 2);
        }
        orderProductService.auditReplaceMaterial(auditDTO);
        break;
      default:
        ;
    }
  }

  @Override
  public ResultBean flowInstanceHistory(Integer instanceId) {
    InstanceRecordDTO instanceRecordDTO = new InstanceRecordDTO();
    // 1、返回实例的历史审核信息
    HistoryInfo historyInfo = new HistoryInfo();
    historyInfo.setInstanceId(instanceId);
    List<HistoryInfo> historyInfos = instanceHistoryMapper.selectInstanceHistory(historyInfo);
    historyInfos.forEach(historyInfo1 -> {
      historyInfo1.setAccessories(new ArrayList<>());
      if (!historyInfo1.getAccessory().isEmpty()) {
        historyInfo1.setAccessories(JSON.parseArray(historyInfo1.getAccessory(), Accessory.class));
      }
    });
    // 2、返回当前要处理的节点
    FlowInstanceWrapper flowInstance = instanceHistoryMapper.selectByPrimaryKey(instanceId);
    // 3、获取FlowStep详情
    FlowStep flowStep = instanceHistoryMapper
        .selectFlowStepByStepId(flowInstance.getFlowId(), flowInstance.getCurrentStepId());
    List<String> userIds = Arrays.asList(flowInstance.getUserId().split(","));
    String loginUserId = String.valueOf(getLoginUserId());
    if (userIds.contains(loginUserId) && flowInstance.getIsOver() == 0) {
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
        Step step = stepMapper.selectByPrimaryKey(dealStep.getStepId());
        dealStep.setStepName(step.getName());
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
    instanceRecordDTO.setSummary(flowInstance.getSummary());
    instanceRecordDTO.setFormNo(flowInstance.getFormNo());
    instanceRecordDTO.setFormId(flowInstance.getFormId());
    instanceRecordDTO.setAccessories(flowInstance.getAccessory().isEmpty() ? new ArrayList<>()
        : JSON.parseArray(flowInstance.getAccessory(), Accessory.class));
    return ResultBean.success(instanceRecordDTO);
  }

  @Override
  public ResultBean backSteps(Integer instanceId) {
    // 获取当前节点之前的前驱节点集合
    FlowInstance flowInstance = instanceMapper.selectByPrimaryKey(instanceId);
    List<BackStepDTO> backStepDTOS = instanceHistoryMapper.selectBackStepsByFlowId(flowInstance.getFlowId());
    Map<Integer, List<BackStepDTO>> backStepSwap = backStepDTOS.stream()
        .collect(Collectors.groupingBy(f -> f.getStepId()));
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
    if (result.size() > 0) {
      result.remove(result.size() - 1);
    }
    return ResultBean.success(result);
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public ResultBean flowProgress(String formNo, Integer formId) {
    FlowInstanceExample instanceExample = new FlowInstanceExample();
    if (formId > 0) {
      instanceExample.or().andFormIdEqualTo(formId).andFlowIdEqualTo(4);
      instanceExample.setOrderByClause("create_time desc limit 1");
    } else {
      instanceExample.or().andFormNoEqualTo(formNo);
      instanceExample.setOrderByClause("create_time desc limit 1");
    }
    List<FlowInstance> flowInstances = instanceMapper.selectByExample(instanceExample);
    if (flowInstances == null || flowInstances.size() == 0) {
      return ResultBean.error(ResponseEnum.FLOW_INSTANCE_NOT_EXIST);
    }
    FlowInstance flowInstance = flowInstances.get(0);
    FlowStepExample flowStepExample = new FlowStepExample();
    flowStepExample.or().andFlowIdEqualTo(flowInstance.getFlowId());
    flowStepExample.setOrderByClause("step_order asc");
    List<FlowStep> flowSteps = flowStepMapper.selectByExample(flowStepExample);
    int preStepId = 0;
    List<Integer> existStepId = new ArrayList<>();
    List<FlowProcesserDTO> flowProcesserDTOS = new ArrayList<>();
    Map<Integer, List<FlowStep>> map = flowSteps.stream().collect(Collectors.groupingBy(FlowStep::getStepId));
    for (int i = 0; i < flowSteps.size(); i++) {
      FlowStep flowStep = flowSteps.get(i);
      if (existStepId.contains(flowStep.getStepId())) {
        continue;
      }
      FlowProcesserDTO processerDTO = new FlowProcesserDTO();
      processerDTO.setInstanceId(flowInstance.getId());
      processerDTO.setStepId(flowStep.getStepId());
      processerDTO.setAuditResult(4);// 初始化 未审核
      processerDTO.setRoleId(flowStep.getRoleId());
      processerDTO.setChild(new ArrayList<>());
      existStepId.add(flowStep.getStepId());
      if (flowStep.getPrevStepId() == preStepId) {
        if (flowStep.getConditionFalse() > 0) {
          FlowProcesserDTO childDto = new FlowProcesserDTO();
          childDto.setInstanceId(flowInstance.getId());
          childDto.setStepId(flowStep.getConditionFalse());
          childDto.setAuditResult(4);// 初始化 未审核
          childDto.setRoleId(map.get(flowStep.getConditionFalse()).get(0).getRoleId());
          childDto.setChild(new ArrayList<>());
          processerDTO.setChild(Arrays.asList(childDto));
          existStepId.add(flowStep.getConditionFalse());
        }
        flowProcesserDTOS.add(processerDTO);
        preStepId = flowStep.getStepId();
        continue;
      }
    }
    boolean isAudit = true;
    for (int i = 0; i < flowProcesserDTOS.size(); i++) {
      FlowProcesserDTO processerDTO = flowProcesserDTOS.get(i);
      isAudit = wrapperProcessDto(processerDTO, flowInstance.getCurrentStepId(), isAudit, flowInstance.getId(),
          flowInstance.getIsOver());
    }
    return ResultBean.success(flowProcesserDTOS);
  }

  private boolean wrapperProcessDto(FlowProcesserDTO processerDTO, int currentStepId, boolean isAudit, int instanceId,
      int isOver) {
    int stepId = processerDTO.getStepId();
    if (stepId == currentStepId && isOver == 0) {
      isAudit = false;
    }
    HistoryInfo historyInfo = instanceHistoryMapper.selectHistoryDetails(stepId, instanceId);
    if (isAudit && historyInfo != null) {
      processerDTO.setAuditUserName(historyInfo.getAuditUserName());
      processerDTO.setAuditResult(historyInfo.getAuditResult());
      processerDTO.setAuditTime(historyInfo.getCreateTime());
    } else {
      processerDTO.setAuditUserName("");
    }
    SysRole sysRole = sysRoleMapper.selectByPrimaryKey(processerDTO.getRoleId());
    processerDTO.setRoleName(sysRole.getDescription());
    Step step = stepMapper.selectByPrimaryKey(stepId);
    processerDTO.setStepName(step.getName());
    if (processerDTO.getChild() != null && processerDTO.getChild().size() > 0) {
      wrapperProcessDto(processerDTO.getChild().get(0), currentStepId, isAudit, instanceId, isOver);
    }
    return isAudit;
  }

  @Override
  public ResultBean accessoryInfo(String formNo, Integer formId) {
    FlowInstanceExample example = new FlowInstanceExample();
    FlowInstanceExample.Criteria criteria = example.createCriteria();
    if (formId != 0) {
      criteria.andFormIdEqualTo(formId).andFlowIdEqualTo(4);
    }
    if (StringUtils.isNotEmpty(formNo)) {
      criteria.andFormNoEqualTo(formNo);
    }
    example.setOrderByClause("create_time desc limit 1");
    List<FlowInstance> instances = instanceMapper.selectByExample(example);
    List<Accessory> accessories = new ArrayList<>();
    if (instances != null && instances.size() > 0) {
      String accessorys = instances.get(0).getAccessory();
      if(StringUtils.isNotEmpty(accessorys)) {
        List<Accessory> accessoryList = JSON.parseArray(instances.get(0).getAccessory(), Accessory.class);
        if(accessoryList != null) {
          accessories.addAll(accessoryList);
        }
      }
    }
    return ResultBean.success(accessories);
  }

  @Async("threadPoolTaskExecutor")
  @Override
  public void deleteFlowInstance(String formNo) {
    FlowInstanceExample example = new FlowInstanceExample();
    example.createCriteria().andFormNoEqualTo(formNo);
    instanceMapper.deleteByExample(example);
  }
}
