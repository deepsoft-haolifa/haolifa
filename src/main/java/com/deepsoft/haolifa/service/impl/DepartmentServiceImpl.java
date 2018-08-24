package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.SysDepartmentMapper;
import com.deepsoft.haolifa.model.domain.SysDepartment;
import com.deepsoft.haolifa.model.dto.DepartmentDTO;
import com.deepsoft.haolifa.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private SysDepartmentMapper departmentMapper;

    @Override
    public int insertDepartment(DepartmentDTO departmentDTO) {
        SysDepartment sysDepartment = new SysDepartment();
        BeanUtils.copyProperties(departmentDTO, sysDepartment);
        return departmentMapper.insertSelective(sysDepartment);
    }
}
