package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.FlowMapper;
import com.deepsoft.haolifa.dao.repository.SysRoleMapper;
import com.deepsoft.haolifa.dao.repository.extend.FlowInstanceHistoryMapper;
import com.deepsoft.haolifa.model.domain.SysRoleExample;
import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.RoleDTO;
import com.deepsoft.haolifa.model.vo.DoneItemVO;
import com.deepsoft.haolifa.model.vo.QuickStartVO;
import com.deepsoft.haolifa.model.vo.TodoItemVO;
import com.deepsoft.haolifa.service.HomeApiService;
import com.deepsoft.haolifa.service.RoleService;
import com.deepsoft.haolifa.service.SysUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.PageDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.util.StringUtils;

@Service
public class HomeApiServiceImpl implements HomeApiService {

  @Autowired
  private SysUserService userService;
  @Autowired
  private FlowInstanceHistoryMapper flowInstanceHistoryMapper;
  @Autowired
  private FlowMapper flowMapper;
  @Autowired
  private RoleService roleService;

  @Override
  public List<QuickStartVO> getQuickStartMenu() {
    CustomUser customUser = userService.selectLoginUser();
    List<RoleDTO> rolesByUserId = roleService.getRolesByUserId(customUser.getId());
    for (RoleDTO role : rolesByUserId) {
      if ("ROLE_ADMIN".equals(role.getRoleName())) {
        return flowMapper.selectByExample(null).stream().map(flow -> {
          QuickStartVO quickStartVO = new QuickStartVO();
          quickStartVO.setFlowId(flow.getId());
          quickStartVO.setName(flow.getName());
          quickStartVO.setDescription(flow.getDescription());
          return quickStartVO;
        }).collect(Collectors.toList());
      }
    }
    return flowInstanceHistoryMapper.selectFlowByUserRoles(customUser.getId());
  }

  @Override
  public ResultBean getTodoItems(Integer pageNum, Integer pageSize) {
    CustomUser customUser = userService.selectLoginUser();
    List<RoleDTO> rolesByUserId = roleService.getRolesByUserId(customUser.getId());
    Integer userId = customUser.getId();
    if (rolesByUserId.stream().map(RoleDTO::getRoleName)
        .collect(Collectors.toList()).contains("ROLE_ADMIN")) {
      userId = 0;
    }
    final int tempUserId = userId;
    Page<TodoItemVO> todoItemVOPage = PageHelper.startPage(pageNum, pageSize)
        .setOrderBy("fi.create_time desc")
        .doSelectPage(() -> flowInstanceHistoryMapper.selectToDoItems(tempUserId));
    PageDTO<TodoItemVO> pageDTO = new PageDTO<>();
    BeanUtils.copyProperties(todoItemVOPage, pageDTO);
    pageDTO.setList(todoItemVOPage.getResult());
    return ResultBean.success(pageDTO);
  }

  @Override
  public ResultBean getDoneItems(Integer pageNum, Integer pageSize) {
    CustomUser customUser = userService.selectLoginUser();
    Page<DoneItemVO> doneItemVOPage = PageHelper.startPage(pageNum, pageSize)
        .setOrderBy("fh.create_time desc")
        .doSelectPage(() -> flowInstanceHistoryMapper.selectDoneItems(customUser.getId()));
    PageDTO<DoneItemVO> pageDto = new PageDTO<>();
    BeanUtils.copyProperties(doneItemVOPage, pageDto);
    pageDto.setList(doneItemVOPage.getResult());
    return ResultBean.success(pageDto);
  }
}
