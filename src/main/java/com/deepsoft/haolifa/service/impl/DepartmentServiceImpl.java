package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.SysDepartmentMapper;
import com.deepsoft.haolifa.model.domain.SysDepartment;
import com.deepsoft.haolifa.model.domain.SysDepartmentExample;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.dto.DepartmentDTO;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.RoleDTO;
import com.deepsoft.haolifa.service.DepartmentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private SysDepartmentMapper departmentMapper;

    @Override
    public int insertDepartment(DepartmentDTO departmentDTO) {
        SysDepartment sysDepartment = new SysDepartment();
        BeanUtils.copyProperties(departmentDTO, sysDepartment);
        return departmentMapper.insertSelective(sysDepartment);
    }

    @Override
    public List<DepartmentDTO> getDepartments() {
        return departmentMapper.selectByExample(new SysDepartmentExample())
        .stream().map(d -> {
            DepartmentDTO departmentDTO = new DepartmentDTO();
            BeanUtils.copyProperties(d, departmentDTO);
            return departmentDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public int updateDepartment(DepartmentDTO departmentDTO) {
        SysDepartment sysDepartment = new SysDepartment();
        BeanUtils.copyProperties(departmentDTO, sysDepartment);
        return departmentMapper.updateByPrimaryKeySelective(sysDepartment);
    }

    @Override
    public int deleteDepartment(Integer id) {
        if(null == id){
            throw new BaseException(CommonEnum.ResponseEnum.PARAM_ERROR.code, "id不能为空");
        }
        return departmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public DepartmentDTO selectDepartmentById(Integer id) {
        SysDepartment sysDepartment = departmentMapper.selectByPrimaryKey(id);
        DepartmentDTO departmentDTO = new DepartmentDTO();
        if(sysDepartment!=null)
            BeanUtils.copyProperties(sysDepartment, departmentDTO);
        return departmentDTO;
    }

    @Override
    public List<RoleDTO> selectRolesByDepartmentId(Integer id) {

        return null;
    }
}
