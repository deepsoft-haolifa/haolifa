package com.deepsoft.haolifa.service.impl.finance;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.BizCompanyMapper;
import com.deepsoft.haolifa.dao.repository.SysDepartmentMapper;
import com.deepsoft.haolifa.model.domain.BizCompany;
import com.deepsoft.haolifa.model.domain.BizCompanyExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.company.CompanyAddDTO;
import com.deepsoft.haolifa.model.dto.finance.company.CompanyRQDTO;
import com.deepsoft.haolifa.model.dto.finance.company.CompanyRSDTO;
import com.deepsoft.haolifa.model.dto.finance.company.CompanyUpDTO;
import com.deepsoft.haolifa.service.DepartmentService;
import com.deepsoft.haolifa.service.SysDictService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.CompanyService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {


    @Autowired
    private SysDepartmentMapper departmentMapper;

    @Resource
    private BizCompanyMapper bizCompanyMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private SysDictService sysDictService;


    @Override
    public ResultBean save(CompanyAddDTO model) {

        ResultBean<Object> PARAM_ERROR = validate(model);
        if (PARAM_ERROR != null) {
            return PARAM_ERROR;
        }

        BizCompany bizCompany = new BizCompany();
        BeanUtils.copyProperties(model, bizCompany);


        bizCompany.setStatus("1");
        bizCompany.setCreateTime(new Date());
        bizCompany.setUpdateTime(new Date());
        bizCompany.setUpdateBy(sysUserService.selectLoginUser().getId().toString());
        bizCompany.setCreateBy(sysUserService.selectLoginUser().getId().toString());
        int insertId = bizCompanyMapper.insertSelective(bizCompany);
        return ResultBean.success(insertId);
    }

    @Override
    public ResultBean delete(int id) {
        int i = bizCompanyMapper.deleteByPrimaryKey((long) id);
        return ResultBean.success(i);
    }

    @Override
    public ResultBean update(CompanyUpDTO assetsUpDTO) {

        if (StringUtils.isEmpty(assetsUpDTO.getName())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "单位code");
        }
        if (StringUtils.isEmpty(assetsUpDTO.getCode())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "单位名称");
        }

        BizCompany bizCompany = new BizCompany();
        BeanUtils.copyProperties(assetsUpDTO, bizCompany);
        bizCompany.setUpdateTime(new Date());
        bizCompany.setUpdateBy(sysUserService.selectLoginUser().getId().toString());
        int i = bizCompanyMapper.updateByPrimaryKeySelective(bizCompany);
        return ResultBean.success(i);
    }

    @Override
    public ResultBean<PageDTO<CompanyRSDTO>> getList(CompanyRQDTO model) {

        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }
        BizCompanyExample bizCompanyExample = new BizCompanyExample();
        BizCompanyExample.Criteria criteria = bizCompanyExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);

        if (StringUtils.isNotEmpty(model.getName())) {
            criteria.andNameLike("%" + model.getName() + "%");
        }
        if (StringUtils.isNotEmpty(model.getCode())) {
            criteria.andCodeLike("%" + model.getCode() + "%");
        }

        Page<BizCompany> pageData = PageHelper
            .startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> {
                bizCompanyMapper.selectByExample(bizCompanyExample);
            });


        List<CompanyRSDTO> assetsRSDTOList = pageData.getResult().stream()
            .map(assets -> {
                CompanyRSDTO assetsRSDTO = new CompanyRSDTO();
                BeanUtils.copyProperties(assets, assetsRSDTO);
                return assetsRSDTO;
            })
            .collect(Collectors.toList());

        PageDTO<CompanyRSDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(assetsRSDTOList);
        return ResultBean.success(pageDTO);
    }


    private ResultBean<Object> validate(CompanyAddDTO model) {
        if (StringUtils.isEmpty(model.getName())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "单位code");
        }
        if (StringUtils.isEmpty(model.getCode())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "单位名称");
        }
        return null;
    }


}
