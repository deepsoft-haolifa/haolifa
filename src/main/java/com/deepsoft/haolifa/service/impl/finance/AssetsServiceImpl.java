package com.deepsoft.haolifa.service.impl.finance;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.BizAssetsMapper;
import com.deepsoft.haolifa.dao.repository.SysDepartmentMapper;
import com.deepsoft.haolifa.enums.DepreciationMethodEnum;
import com.deepsoft.haolifa.enums.DictEnum;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.assets.*;
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
import java.util.Date;
import java.util.List;
import java.util.Map;
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
        if (PARAM_ERROR != null) {
            return PARAM_ERROR;
        }

        BizAssets bizAssets = new BizAssets();
        BeanUtils.copyProperties(model, bizAssets);
        bizAssets.setTotalPrice(bizAssets.getPrice().multiply(BigDecimal.valueOf(bizAssets.getNum())));

        // 净残值		自动计算（=采购金额*净残值率）
        bizAssets.setSalvageValue(bizAssets.getTotalPrice().multiply(bizAssets.getOutputRate()).divide(BigDecimal.valueOf(100),2,BigDecimal.ROUND_HALF_UP));


        DepreciationMethodEnum depreciationMethodEnum = DepreciationMethodEnum.valueOfCode(bizAssets.getDepreciationMethod());
        BigDecimal monthDepreciation = BigDecimal.ZERO;
        switch (depreciationMethodEnum){
            // 月折旧额=采购金额*（1－净残值率）/使用年限/12*100%
            case pjnx:{
                // 采购金额
                BigDecimal totalPrice = bizAssets.getTotalPrice();

                // 净残值率
                BigDecimal outputRate = bizAssets.getOutputRate().divide(BigDecimal.valueOf(100));

                // rate
                BigDecimal rate  = BigDecimal.ONE.subtract(outputRate);

                // year
                BigDecimal year = BigDecimal.valueOf(bizAssets.getUseYear());

                // 12
                BigDecimal fullMonth = BigDecimal.valueOf(12);

                monthDepreciation = totalPrice.multiply(rate).divide(year).divide(fullMonth, 2, BigDecimal.ROUND_HALF_UP);
                break;
            }
            // 月折旧额=净值*2/使用年限*100%/12"
//            case sbyedj:{
//
//                // 采购金额
//                BigDecimal totalPrice = bizAssets.getTotalPrice();
//
//                // 净残值率
//                BigDecimal outputRate = bizAssets.getOutputRate().divide(BigDecimal.valueOf(100));
//
//                // rate
//                BigDecimal rate  = BigDecimal.ONE.subtract(outputRate);
//
//                // year
//                BigDecimal year = BigDecimal.valueOf(bizAssets.getUseYear());
//
//                // 12
//                BigDecimal fullMonth = BigDecimal.valueOf(12);
//
//                monthDepreciation = totalPrice.multiply(rate).divide(year).divide(fullMonth, 2, BigDecimal.ROUND_HALF_UP);
//                break;
//            }

        }
        bizAssets.setMonthDepreciation(monthDepreciation);

        // 已计提月份 (自动计算（数据更新系统时间-开始使用时间）)
        Long month = DateUtil.betweenMonth(new Date(), bizAssets.getPurchasingTime(), true);
        bizAssets.setAccruedMonth(month.intValue());

        // 累计折旧 (自动计算（已计提月份*月折旧额）)
        BigDecimal accumulatedDepreciation = bizAssets.getMonthDepreciation().multiply(BigDecimal.valueOf(month));
        bizAssets.setAccumulatedDepreciation(accumulatedDepreciation);

        // 净值 (自动计算（=采购金额-累计折旧额）)
        bizAssets.setNetWorth(bizAssets.getTotalPrice().subtract(accumulatedDepreciation));

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
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "设备名称不能为空");
        }
        if (StringUtils.isEmpty(model.getBh())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "设备编号不能为空");
        }

        if (StringUtils.isEmpty(model.getType())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "类别名称不能为空");
        }

        if (model.getNum() == null) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "设备数量不能为空");
        }

        if (model.getDeptId() == null) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "部门不能为空");
        }

        if (StringUtils.isEmpty(model.getAddType())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "增加方式不能为空");
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
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "设备名称不能为空");
        }
        if (StringUtils.isEmpty(assetsUpDTO.getBh())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "设备编号不能为空");
        }

        if (StringUtils.isEmpty(assetsUpDTO.getType())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "类别名称不能为空");
        }

        if (assetsUpDTO.getNum() == null) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "设备数量不能为空");
        }

        if (assetsUpDTO.getDeptId() == null) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "部门不能为空");
        }


        if (StringUtils.isEmpty(assetsUpDTO.getAddType())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "增加方式不能为空");
        }

        BizAssets bizAssets = new BizAssets();
        BeanUtils.copyProperties(assetsUpDTO, bizAssets);
        bizAssets.setUpdateTime(new Date());
        bizAssets.setUpdateBy(sysUserService.selectLoginUser().getId().toString());
        int i = bizAssetsMapper.updateByPrimaryKeySelective(bizAssets);
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
        BizAssetsExample bizAssetsExample = getBizAssetsExample(model);

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
        Map<String, String> depreciation_method_map = sysDictService.getSysDictByTypeCode(DictEnum.DEPRECIATION_METHOD.getCode()).stream()
            .collect(Collectors.toMap(SysDict::getCode, SysDict::getName, (a, b) -> a));

        List<AssetsRSDTO> assetsRSDTOList = pageData.getResult().stream()
            .map(assets -> {
                AssetsRSDTO assetsRSDTO = new AssetsRSDTO();
                BeanUtils.copyProperties(assets, assetsRSDTO);
                SysDepartment department = sysDepartmentMap.getOrDefault(Integer.valueOf(assetsRSDTO.getDeptId()), null);
                if (ObjectUtil.isNotNull(department)) {
                    assetsRSDTO.setDeptName(department.getDeptName());
                }
                String typeName = assets_type_map.getOrDefault(assetsRSDTO.getType(), "");
                assetsRSDTO.setTypeCN(typeName);
                String addTypeCN = assets_add_type_map.getOrDefault(assetsRSDTO.getAddType(), "");
                assetsRSDTO.setAddTypeCN(addTypeCN);
                String statusCN = StringUtils.equalsIgnoreCase("0", assets.getStatus()) ? "正常" : "停用";
                assetsRSDTO.setStatusCN(statusCN);

                String depreciationMethod = depreciation_method_map.getOrDefault(assetsRSDTO.getDepreciationMethod(), "");
                assetsRSDTO.setDepreciationMethodCN(depreciationMethod);
                return assetsRSDTO;
            })
            .collect(Collectors.toList());

        PageDTO<AssetsRSDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(assetsRSDTOList);
        return ResultBean.success(pageDTO);
    }

    private BizAssetsExample getBizAssetsExample(AssetsRQDTO model) {
        BizAssetsExample bizAssetsExample = new BizAssetsExample();
        BizAssetsExample.Criteria criteria = bizAssetsExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);

        if (StringUtils.isNotEmpty(model.getName())) {
            criteria.andNameLike("%" + model.getName() + "%");
        }
        if (StringUtils.isNotEmpty(model.getBh())) {
            criteria.andBhLike("%" + model.getBh() + "%");
        }
        if (StringUtils.isNotEmpty(model.getType())) {
            criteria.andTypeEqualTo(model.getType());
        }
        if (model.getDeptId() != null) {
            criteria.andDeptIdEqualTo(model.getDeptId());
        }
        if (StringUtils.isNotEmpty(model.getUserName())) {
            criteria.andUserNameLike("%" + model.getUserName() + "%");
        }
        if (StringUtils.isNotEmpty(model.getAddType())) {
            criteria.andAddTypeEqualTo(model.getAddType());
        }

        // 状态 ==
        if (StringUtils.isNotEmpty(model.getStatus())) {
            criteria.andStatusEqualTo(model.getStatus());
        }
        bizAssetsExample.setOrderByClause("id desc");
        return bizAssetsExample;
    }

    @Override
    public ResultBean<AssetsSumDTO> getAssetsSum(AssetsRQDTO assetsRQDTO) {
        BizAssetsExample bizAssetsExample = getBizAssetsExample(assetsRQDTO);
        List<BizAssets> assetsList = bizAssetsMapper.selectByExample(bizAssetsExample);
        BigDecimal totalPrice =  assetsList.stream().map(BizAssets::getTotalPrice).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal accumulatedDepreciation = assetsList.stream().map(BizAssets::getAccumulatedDepreciation).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal netWorth = assetsList.stream().map(BizAssets::getNetWorth).reduce(BigDecimal.ZERO,BigDecimal::add);
        AssetsSumDTO sumDTO = new AssetsSumDTO();
        sumDTO.setTotalPrice(totalPrice);
        sumDTO.setAccumulatedDepreciation(accumulatedDepreciation);
        sumDTO.setNetWorth(netWorth);
        return ResultBean.success(sumDTO);
    }


    @Override
    public void job() {

    }
}
