package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.AllotPersonsDTO;
import com.deepsoft.haolifa.model.dto.AllotRolesDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;

public interface FlowService {

  ResultBean list();

  ResultBean steps(int flowId);

  ResultBean allotRoles(AllotRolesDTO model);

  ResultBean allotPersons(AllotPersonsDTO model);

  ResultBean roles();

  ResultBean users(int roleId);
}
