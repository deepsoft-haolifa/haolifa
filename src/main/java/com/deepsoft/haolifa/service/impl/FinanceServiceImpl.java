package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.FinanceMapper;
import com.deepsoft.haolifa.model.dto.FinanceDTO;
import com.deepsoft.haolifa.model.domain.Finance;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.FinanceService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class FinanceServiceImpl implements FinanceService {

    @Autowired
    FinanceMapper financeMapper;

    @Override
    public ResultBean save(FinanceDTO model) {
        Finance finance = new Finance();
        BeanUtils.copyProperties(model, finance);
        // TODO
        finance.setCreateUserId(1);
        int insert = financeMapper.insertSelective(finance);
        return ResultBean.success(insert);
    }

    @Override
    public ResultBean delete(Integer id) {
        int delete = financeMapper.deleteByPrimaryKey(id);
        return ResultBean.success(delete);
    }

    @Override
    public ResultBean update(FinanceDTO model) {
        Finance finance = new Finance();
        BeanUtils.copyProperties(model, finance);
        int update = financeMapper.updateByPrimaryKeySelective(finance);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean getList(Integer currentPage, Integer pageSize, String orderNo) {
        PageHelper.startPage(currentPage, pageSize);
        Page<Finance> pageData = financeMapper.selectListByPage(orderNo);
        Map<String, Object> result = new HashMap<>(4);
        result.put("totalCount", pageData.getTotal());
        result.put("pageSize", pageData.getPageSize());
        result.put("pages", pageData.getPages());
        result.put("list", pageData.getResult());
        return ResultBean.success(result);
    }
}
