package com.deepsoft.haolifa.service.impl.finance;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.BizAssetsMapper;
import com.deepsoft.haolifa.dao.repository.SysDepartmentMapper;
import com.deepsoft.haolifa.enums.DictEnum;
import com.deepsoft.haolifa.enums.PayApplyPayStatusEnum;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.assets.AssetsAddDTO;
import com.deepsoft.haolifa.model.dto.finance.assets.AssetsRQDTO;
import com.deepsoft.haolifa.model.dto.finance.assets.AssetsRSDTO;
import com.deepsoft.haolifa.model.dto.finance.assets.AssetsUpDTO;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyRSDTO;
import com.deepsoft.haolifa.model.dto.finance.payplan.BizPayPlanSummaryRSDTO;
import com.deepsoft.haolifa.service.DepartmentService;
import com.deepsoft.haolifa.service.SysDictService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.AssetsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AssetsServiceImpl implements AssetsService {

    @Autowired
    private SysDepartmentMapper departmentMapper;

    @Resource
    private BizAssetsMapper bizAssetsMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private SysDictService sysDictService;

    @Override
    public ResultBean save(AssetsAddDTO model) {

        ResultBean<Object> PARAM_ERROR = validate(model);
        if (PARAM_ERROR != null) return PARAM_ERROR;

        BizAssets bizAssets = new BizAssets();
        BeanUtils.copyProperties(model, bizAssets);
        bizAssets.setStatus("0");
        bizAssets.setCreateTime(new Date());
        bizAssets.setUpdateTime(new Date());
        bizAssets.setUpdateBy(sysUserService.selectLoginUser().getId().toString());
        bizAssets.setCreateBy(sysUserService.selectLoginUser().getId().toString());
        int insertId = bizAssetsMapper.insertSelective(bizAssets);
        return ResultBean.success(insertId);
    }

    private ResultBean<Object> validate(AssetsAddDTO model) {
        if (StringUtils.isEmpty(model.getName())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"设备名称不能为空");
        }
        if (StringUtils.isEmpty(model.getBh())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"设备编号不能为空");
        }

        if (StringUtils.isEmpty(model.getType())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"类别名称不能为空");
        }

        if (StringUtils.isEmpty(model.getNum())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"设备数量不能为空");
        }

        if (StringUtils.isEmpty(model.getDeptId())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"部门不能为空");
        }

        if (StringUtils.isEmpty(model.getAddType())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"增加方式不能为空");
        }
        return null;
    }

    @Override
    public ResultBean delete(int id) {
        int i = bizAssetsMapper.deleteByPrimaryKey((long) id);
        return ResultBean.success(i);
    }

    @Override
    public ResultBean update(AssetsUpDTO assetsUpDTO) {

        if (StringUtils.isEmpty(assetsUpDTO.getName())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"设备名称不能为空");
        }
        if (StringUtils.isEmpty(assetsUpDTO.getBh())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"设备编号不能为空");
        }

        if (StringUtils.isEmpty(assetsUpDTO.getType())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"类别名称不能为空");
        }

        if (StringUtils.isEmpty(assetsUpDTO.getNum())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"设备数量不能为空");
        }

        if (StringUtils.isEmpty(assetsUpDTO.getDeptId())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"部门不能为空");
        }

        if (StringUtils.isEmpty(assetsUpDTO.getAddType())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"增加方式不能为空");
        }

        BizAssets bizAssets = new BizAssets();
        BeanUtils.copyProperties(assetsUpDTO, bizAssets);
        bizAssets.setUpdateTime(new Date());
        bizAssets.setUpdateBy(sysUserService.selectLoginUser().getId().toString());
        int i = bizAssetsMapper.updateByPrimaryKey(bizAssets);
        return ResultBean.success(i);
    }

    @Override
    public ResultBean<PageDTO<AssetsRSDTO>> getList(AssetsRQDTO model) {

        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }
        BizAssetsExample bizAssetsExample = new BizAssetsExample();
        BizAssetsExample.Criteria criteria = bizAssetsExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);

        if (StringUtils.isNotEmpty(model.getName())) {
            criteria.andNameEqualTo("%" + model.getName() + "%");
        }
        if (StringUtils.isNotEmpty(model.getBh())) {
            criteria.andBhEqualTo("%" + model.getBh() + "%");
        }
        if (StringUtils.isNotEmpty(model.getType())) {
            criteria.andTypeEqualTo(model.getType());
        }
        if (StringUtils.isNotEmpty(model.getDeptId())) {
            criteria.andDeptIdEqualTo(model.getDeptId());
        }
        if (StringUtils.isNotEmpty(model.getUserName())) {
            criteria.andUserNameEqualTo("%" + model.getUserName() + "%");
        }
        if (StringUtils.isNotEmpty(model.getAddType())) {
            criteria.andAddTypeEqualTo(model.getAddType());
        }
        if (StringUtils.isNotEmpty(model.getEquipmentState())) {
            criteria.andEquipmentStateEqualTo(model.getEquipmentState());
        }
        // 状态 ==
        if (StringUtils.isNotEmpty(model.getStatus())) {
            criteria.andStatusEqualTo(model.getStatus());
        }
        bizAssetsExample.setOrderByClause("id desc");

        Page<BizAssets> pageData = PageHelper
            .startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> {
                bizAssetsMapper.selectByExample(bizAssetsExample);
            });

        List<SysDepartment> sysDepartments = departmentMapper.selectByExample(new SysDepartmentExample());
        Map<Integer, SysDepartment> sysDepartmentMap = sysDepartments.stream().collect(Collectors.toMap(SysDepartment::getId, Function.identity()));
        Map<String, String> assets_type_map = sysDictService.getSysDictByTypeCode(DictEnum.ASSETS_TYPE.getCode()).stream()
            .collect(Collectors.toMap(SysDict::getCode, SysDict::getName, (a, b) -> a));
        Map<String, String> assets_add_type_map = sysDictService.getSysDictByTypeCode(DictEnum.ASSETS_ADD_TYPE.getCode()).stream()
            .collect(Collectors.toMap(SysDict::getCode, SysDict::getName, (a, b) -> a));

        List<AssetsRSDTO> assetsRSDTOList = pageData.getResult().stream()
            .map(assets -> {
                AssetsRSDTO assetsRSDTO = new AssetsRSDTO();
                BeanUtils.copyProperties(assets, assetsRSDTO);
                SysDepartment department = sysDepartmentMap.getOrDefault(Integer.valueOf(assetsRSDTO.getDeptId()), null);
                if (ObjectUtil.isNotNull(department)){
                    assetsRSDTO.setDeptName(department.getDeptName());
                }
                String typeName = assets_type_map.getOrDefault(assetsRSDTO.getType(), "");
                assetsRSDTO.setTypeCN(typeName);
                String addTypeCN = assets_add_type_map.getOrDefault(assetsRSDTO.getAddType(), "");
                assetsRSDTO.setAddTypeCN(addTypeCN);
               String statusCN =  StringUtils.equalsIgnoreCase("0",assets.getStatus())? "正常":"停用";
                assetsRSDTO.setStatusCN(statusCN);
                return assetsRSDTO;
            })
            .collect(Collectors.toList());

        PageDTO<AssetsRSDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(assetsRSDTOList);
        return ResultBean.success(pageDTO);
    }
}
