package com.deepsoft.haolifa.service.impl.finance;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.BizCostBudgetMapper;
import com.deepsoft.haolifa.model.domain.BizCostBudget;
import com.deepsoft.haolifa.model.domain.BizCostBudgetExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.costbudget.BizCostBudgetAddDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.BizCostBudgetDTO;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.CostBudgetService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CostBudgetServiceImpl implements CostBudgetService {

    @Autowired
    private BizCostBudgetMapper bizCostBudgetMapper;
    @Autowired
    private SysUserService sysUserService;

    @Override
    public ResultBean save(BizCostBudgetAddDTO model) {
        log.info("CostBudgetService saveInfo start|{}", JSONObject.toJSON(model));
        if (StringUtils.isAnyBlank()) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        BizCostBudget costBudget = new BizCostBudget();
        BeanUtils.copyProperties(model, costBudget);
        costBudget.setCreateTime(new Date());
        costBudget.setUpdateTime(new Date());
        costBudget.setCreateUser(sysUserService.selectLoginUser().getId());
        costBudget.setUpdateUser(sysUserService.selectLoginUser().getId());
        int insertId = bizCostBudgetMapper.insertSelective(costBudget);
        return ResultBean.success(insertId);
    }

    @Override
    public ResultBean delete(Integer id) {
        //int delete = bizCostBudgetMapper.deleteByPrimaryKey(id);

        BizCostBudget costBudget = new BizCostBudget();
        costBudget.setId(id);
        costBudget.setDelFlag("1");
        costBudget.setUpdateTime(new Date());
        costBudget.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizCostBudgetMapper.updateByPrimaryKeySelective(costBudget);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean update(BizCostBudget costBudget) {
        costBudget.setUpdateTime(new Date());
        costBudget.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizCostBudgetMapper.updateByPrimaryKeySelective(costBudget);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean getInfo(Integer id) {
        BizCostBudget costBudget = bizCostBudgetMapper.selectByPrimaryKey(id);
        return ResultBean.success(costBudget);
    }

    @Override
    public ResultBean getList(BizCostBudgetDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }
        BizCostBudgetExample bizCostBudgetExample = new BizCostBudgetExample();
        BizCostBudgetExample.Criteria criteria = bizCostBudgetExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);

        // 名称 like
        if (StringUtils.isNotEmpty(model.getName())) {
            criteria.andNameLike(model.getName());
        }
        //年 ==
        if (StringUtils.isNotEmpty(model.getY())) {
            criteria.andYEqualTo(model.getY());
        }
        //月==
        if (StringUtils.isNotEmpty(model.getM())) {
            criteria.andMEqualTo(model.getM());
        }
        //科目id==
        if (model.getSubjectsId() != null) {
            criteria.andSubjectsIdEqualTo(model.getSubjectsId());
        }

        bizCostBudgetExample.setOrderByClause("id desc");
        Page<BizCostBudget> pageData = PageHelper
            .startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> {
                bizCostBudgetMapper.selectByExample(bizCostBudgetExample);
            });
        PageDTO<BizCostBudget> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(pageData.getResult());
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean deleteBatch(List<Integer> ids) {
        BizCostBudgetExample bizCostBudgetExample = new BizCostBudgetExample();
        BizCostBudgetExample.Criteria criteria = bizCostBudgetExample.createCriteria();
        criteria.andIdIn(ids);

         int c = bizCostBudgetMapper.deleteByExample(bizCostBudgetExample);

//        BizCostBudget costBudget = new BizCostBudget();
//        costBudget.setDelFlag("1");
//        costBudget.setUpdateTime(new Date());
//        //costBudget.setUpdateUser(sysUserService.selectLoginUser().getId());
//        int update = bizCostBudgetMapper.de(costBudget, bizCostBudgetExample);
        return ResultBean.success(c);
    }
}
