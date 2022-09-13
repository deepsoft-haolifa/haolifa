package com.deepsoft.haolifa.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.SysDepartmentMapper;
import com.deepsoft.haolifa.model.domain.SysDepartment;
import com.deepsoft.haolifa.model.domain.SysDepartmentExample;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.model.dto.sys.DepartmentTree;
import com.deepsoft.haolifa.service.DepartmentService;
import com.deepsoft.haolifa.util.TreeUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sun.javafx.geom.transform.Identity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private SysDepartmentMapper departmentMapper;

    @Override
    public int insertDepartment(DepartmentDTO departmentDTO) {
        String deptNo = departmentDTO.getDeptNo();
        if (StringUtils.isNotBlank(deptNo)) {
            SysDepartmentExample example = new SysDepartmentExample();
            example.or().andDeptNoEqualTo(deptNo);
            List<SysDepartment> sysDepartments = departmentMapper.selectByExample(example);
            if (sysDepartments.size() > 0) {
                throw new BaseException(CommonEnum.ResponseEnum.FAIL.code, "已经存在相同的deptNo,请换个");
            }
        }
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
        SysDepartmentExample example = new SysDepartmentExample();
        String deptNo = departmentDTO.getDeptNo();
        if (StringUtils.isNotBlank(deptNo)) {
            example.or().andDeptNoEqualTo(deptNo);
            List<SysDepartment> sysDepartments = departmentMapper.selectByExample(example);
            if (sysDepartments.size() > 0) {
                SysDepartment sysDepartment = sysDepartments.get(0);
                if (sysDepartment.getId() != departmentDTO.getId()) {
                    throw new BaseException(CommonEnum.ResponseEnum.FAIL.code, "已经存在相同的deptNo,请换个");
                }
            }
        }
        SysDepartment sysDepartment = new SysDepartment();
        BeanUtils.copyProperties(departmentDTO, sysDepartment);
        return departmentMapper.updateByPrimaryKeySelective(sysDepartment);
    }

    @Override
    public int deleteDepartment(Integer id) {
        if (null == id) {
            throw new BaseException(CommonEnum.ResponseEnum.PARAM_ERROR.code, "id不能为空");
        }
        SysDepartmentExample example = new SysDepartmentExample();
        example.or().andPidEqualTo(id);
        List<SysDepartment> sysDepartments = departmentMapper.selectByExample(example);
        if (sysDepartments.size() > 0) {
            throw new BaseException(CommonEnum.ResponseEnum.FAIL.code, "该部门还有子部门,不能删除");
        }
        return departmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public DepartmentDTO selectDepartmentById(Integer id) {
        SysDepartment sysDepartment = departmentMapper.selectByPrimaryKey(id);
        DepartmentDTO departmentDTO = new DepartmentDTO();
        if (sysDepartment != null)
            BeanUtils.copyProperties(sysDepartment, departmentDTO);
        return departmentDTO;
    }

    @Override
    public List<RoleDTO> selectRolesByDepartmentId(Integer id) {

        return null;
    }

    @Override
    public List<DepartmentTree> departmentTree() {
        SysDepartmentExample example = new SysDepartmentExample();
        List<SysDepartment> sysDepartments = departmentMapper.selectByExample(example);
        Map<Integer, SysDepartment> departMap = sysDepartments.stream().collect(Collectors.toMap(SysDepartment::getId, a -> a));

        List<DepartmentTree> departmentTrees = new ArrayList<>();
        sysDepartments.stream().forEach(e -> {
            DepartmentTree departmentTree = new DepartmentTree();
            departmentTree.setId(String.valueOf(e.getId()));
            departmentTree.setName(e.getDeptName());
            departmentTree.setParentId(String.valueOf(e.getPid()));
            departmentTree.setNo(e.getDeptNo());
            departmentTree.setDescription(e.getDescription());
            SysDepartment department = departMap.get(e.getPid());
            if (Objects.nonNull(department)) {
                departmentTree.setParentName(department.getDeptName());
            }
            departmentTrees.add(departmentTree);
        });
        return TreeUtils.getTreeList("0", departmentTrees);
    }

    @Override
    public DepartmentDTO getParentDepartment(Integer id) {
        SysDepartment sysDepartment = departmentMapper.selectByPrimaryKey(id);
        SysDepartment department = departmentMapper.selectByPrimaryKey(sysDepartment.getPid());
        DepartmentDTO departmentDTO = new DepartmentDTO();
        BeanUtil.copyProperties(department, departmentDTO);
        return departmentDTO;
    }
}
