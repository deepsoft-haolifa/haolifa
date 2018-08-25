package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.DepartmentDTO;
import com.deepsoft.haolifa.model.dto.PageDTO;

import java.util.List;

public interface DepartmentService {

    int insertDepartment(DepartmentDTO departmentDTO);

    List<DepartmentDTO> getDepartments();

    int updateDepartment(DepartmentDTO departmentDTO);

    int deleteDepartment(Integer id);

}
