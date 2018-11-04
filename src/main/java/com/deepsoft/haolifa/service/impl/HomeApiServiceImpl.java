package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.FlowMapper;
import com.deepsoft.haolifa.dao.repository.extend.FlowInstanceHistoryMapper;
import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.model.vo.QuickStartVO;
import com.deepsoft.haolifa.model.vo.TodoItemVO;
import com.deepsoft.haolifa.service.HomeApiService;
import com.deepsoft.haolifa.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeApiServiceImpl implements HomeApiService {

    @Autowired
    private SysUserService userService;
    @Autowired
    private FlowInstanceHistoryMapper flowInstanceHistoryMapper;
    @Autowired
    private FlowMapper flowMapper;

    @Override
    public List<QuickStartVO> getQuickStartMenu() {
        CustomUser customUser = userService.selectLoginUser();
        if("admin".equals(customUser.getUsername())){
            return flowMapper.selectByExample(null).stream().map(flow -> {
                QuickStartVO quickStartVO = new QuickStartVO();
                quickStartVO.setFlowId(flow.getId());
                quickStartVO.setName(flow.getName());
                quickStartVO.setDescription(flow.getDescription());
                return quickStartVO;
            }).collect(Collectors.toList());
        }
        return flowInstanceHistoryMapper.selectFlowByUserRoles(customUser.getId());
    }

    @Override
    public List<TodoItemVO> getTodoItems() {
        return flowInstanceHistoryMapper.selectToDoItems(userService.selectLoginUser().getId());
    }
}
