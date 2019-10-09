package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.constant.CommonEnum.ResponseEnum;
import com.deepsoft.haolifa.dao.repository.ExpensesClassifyMapper;
import com.deepsoft.haolifa.dao.repository.ExpensesMapper;
import com.deepsoft.haolifa.model.domain.Expenses;
import com.deepsoft.haolifa.model.domain.ExpensesClassifyExample;
import com.deepsoft.haolifa.model.domain.ExpensesExample;
import com.deepsoft.haolifa.model.dto.ExpensesDTO;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.ExpensesService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class ExpensesServiceImpl extends BaseService implements ExpensesService {

  @Autowired
  private ExpensesMapper expensesMapper;

  @Autowired
  private ExpensesClassifyMapper classifyMapper;


  @Override
  public ResultBean save(ExpensesDTO model) {
    if (StringUtils.isAnyBlank(model.getExpensesClassify(), model.getSecondClassify(), model.getVoucherNo())
        || model.getTotalAmount() == null || model.getTotalAmount() == 0) {
      return ResultBean.error(ResponseEnum.PARAM_ERROR);
    }
    Expenses expenses = new Expenses();
    BeanUtils.copyProperties(model, expenses);
    expenses.setCreateUserId(getLoginUserId());
    expenses.setTotalAmount(new BigDecimal(model.getTotalAmount()));
    expensesMapper.insertSelective(expenses);
    return ResultBean.success(expenses.getId());
  }

  @Override
  public ResultBean info(Integer id) {
    return ResultBean.success(expensesMapper.selectByPrimaryKey(id));
  }

//  @Override
//  public ResultBean getClassify() {
//    return  ResultBean.success(expensesMapper.getClassify());
//  }
//  @Override
//  public ResultBean classifyByDepartment() {
//    return  ResultBean.success(expensesMapper.classifyByDepartment());
//  }

  @Override
  public ResultBean delete(Integer id) {
    ExpensesExample expensesExample = new ExpensesExample();
    expensesExample.or().andIdEqualTo(id);
    Expenses expenses = new Expenses();
    expenses.setIsDelete(CommonEnum.Consts.YES.code);
    expensesMapper.updateByExampleSelective(expenses, expensesExample);
    return ResultBean.success(0);
  }

  @Override
  public ResultBean update(ExpensesDTO model) {
    if (StringUtils.isAnyBlank(model.getExpensesClassify(), model.getSecondClassify(), model.getVoucherNo())
        || model.getTotalAmount() == null || model.getTotalAmount() == 0) {
      return ResultBean.error(ResponseEnum.PARAM_ERROR);
    }
    Expenses expenses = new Expenses();
    BeanUtils.copyProperties(model, expenses);
    expenses.setTotalAmount(new BigDecimal(model.getTotalAmount()));
    expensesMapper.updateByPrimaryKeySelective(expenses);
    return ResultBean.success(0);
  }

  @Override
  public ResultBean getList(Integer pageNum, Integer pageSize, String classifyName,
      String secondClassifyName, String department, String voucherNo) {
    ExpensesExample expensesExample = new ExpensesExample();
    ExpensesExample.Criteria criteria = expensesExample.createCriteria();
    if (StringUtils.isNotEmpty(classifyName) && !"全部".equals(classifyName)) {
      criteria.andExpensesClassifyEqualTo(classifyName);
    }
    if (StringUtils.isNotEmpty(secondClassifyName) && !"全部".equals(secondClassifyName)) {
      criteria.andSecondClassifyEqualTo(secondClassifyName);
    }
    if (StringUtils.isNotEmpty(department)) {
      criteria.andDepartmentLike("%" + department + "%");
    }
    if (StringUtils.isNotEmpty(voucherNo)) {
      criteria.andVoucherNoLike("%" + voucherNo + "%");
    }
    criteria.andIsDeleteEqualTo(CommonEnum.Consts.NO.code);
    Page<Expenses> page = PageHelper.startPage(pageNum, pageSize)
        .doSelectPage(() -> expensesMapper.selectByExample(expensesExample));
    PageDTO<Expenses> pageDTO = new PageDTO<>();
    BeanUtils.copyProperties(page, pageDTO);
    pageDTO.setList(page.getResult());
    return ResultBean.success(pageDTO);
  }

  @Override
  public ResultBean classify(Integer pId) {
    ExpensesClassifyExample classifyExample = new ExpensesClassifyExample();
    classifyExample.createCriteria().andClassifyPidEqualTo(pId);
    return ResultBean.success(classifyMapper.selectByExample(classifyExample));
  }
  @Override
  public ResultBean getClassify() {
    return  ResultBean.success(expensesMapper.getClassify());
  }
  @Override
  public ResultBean classifyByDepartment() {
    return  ResultBean.success(expensesMapper.classifyByDepartment());
  }

}
