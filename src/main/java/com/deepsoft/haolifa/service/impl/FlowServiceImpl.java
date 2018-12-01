package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.FlowMapper;
import com.deepsoft.haolifa.dao.repository.FlowStepMapper;
import com.deepsoft.haolifa.dao.repository.StepMapper;
import com.deepsoft.haolifa.dao.repository.SysRoleMapper;
import com.deepsoft.haolifa.dao.repository.SysUserMapper;
import com.deepsoft.haolifa.model.domain.Flow;
import com.deepsoft.haolifa.model.domain.FlowExample;
import com.deepsoft.haolifa.model.domain.FlowStep;
import com.deepsoft.haolifa.model.domain.FlowStepExample;
import com.deepsoft.haolifa.model.domain.SysUser;
import com.deepsoft.haolifa.model.domain.SysUserExample;
import com.deepsoft.haolifa.model.dto.AllotPersonsDTO;
import com.deepsoft.haolifa.model.dto.AllotRolesDTO;
import com.deepsoft.haolifa.model.dto.FlowStepListDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.FlowService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlowServiceImpl implements FlowService {

  @Autowired
  private FlowMapper flowMapper;

  @Autowired
  private StepMapper stepMapper;

  @Autowired
  private FlowStepMapper flowStepMapper;

  @Autowired
  private SysRoleMapper sysRoleMapper;

  @Autowired
  private SysUserMapper sysUserMapper;

  @Override
  public ResultBean list() {
    List<Flow> flowList = flowMapper.selectByExample(new FlowExample());
    return ResultBean.success(flowList);
  }

  @Override
  public ResultBean steps(int flowId) {
    FlowStepExample example = new FlowStepExample();
    example.or().andFlowIdEqualTo(flowId);
    List<FlowStep> flowSteps = flowStepMapper.selectByExample(example);
    List<FlowStepListDTO> flowStepListDTOS = new ArrayList<>();
    for (int i = 0; i < flowSteps.size(); i++) {
      FlowStepListDTO flowStepListDTO = new FlowStepListDTO();
      FlowStep flowStep = flowSteps.get(i);
      BeanUtils.copyProperties(flowStep, flowStepListDTO);
      flowStepListDTO.setStepName(stepMapper.selectByPrimaryKey(flowStep.getStepId()).getName());
      if(flowStep.getRoleId() != 0) {
        flowStepListDTO.setRoleName(sysRoleMapper.selectByPrimaryKey(flowStep.getRoleId()).getRoleName());
      }
      SysUserExample sysUserExample = new SysUserExample();
      List<String> userIds = Arrays.asList(flowStep.getUserId().split(","));
      StringBuilder stringBuilder = new StringBuilder("");
      if (userIds != null || userIds.size() > 0) {
        sysUserExample.or().andIdCardIn(userIds);
        List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
        for (SysUser su: sysUsers) {
          stringBuilder.append(su.getRealName()).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
      }
      flowStepListDTO.setUserNames(stringBuilder.toString());
      flowStepListDTOS.add(flowStepListDTO);
    }
    return ResultBean.success(flowStepListDTOS);
  }

  @Override
  public ResultBean allotRoles(AllotRolesDTO model) {
    FlowStep flowStep = new FlowStep();
    flowStep.setRoleId(model.getRoleId());
    FlowStepExample example = new FlowStepExample();
    example.or().andFlowIdEqualTo(model.getFlowId()).andStepIdEqualTo(model.getStepId());
    flowStepMapper.updateByExampleSelective(flowStep, example);
    return ResultBean.success(1);
  }

  @Override
  public ResultBean allotPersons(AllotPersonsDTO model) {
    FlowStep flowStep = new FlowStep();
    flowStep.setUserId(model.getUserIds());
    flowStep.setRoleId(model.getRoleId());
    FlowStepExample example = new FlowStepExample();
    example.or().andFlowIdEqualTo(model.getFlowId()).andStepIdEqualTo(model.getStepId());
    flowStepMapper.updateByExampleSelective(flowStep, example);
    return ResultBean.success(1);
  }
}
