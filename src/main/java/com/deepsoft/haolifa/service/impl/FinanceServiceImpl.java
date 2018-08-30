package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.FinanceMapper;
import com.deepsoft.haolifa.model.domain.FinanceExample;
import com.deepsoft.haolifa.model.dto.FinanceDTO;
import com.deepsoft.haolifa.model.domain.Finance;
import com.deepsoft.haolifa.model.dto.FinanceListDTO;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.FinanceService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class FinanceServiceImpl extends BaseService implements FinanceService {

    @Autowired
    FinanceMapper financeMapper;

    @Override
    public ResultBean save(FinanceDTO model) {
        if (StringUtils.isAnyEmpty(model.getOrderNo()) || model.getStatus() == null || model.getType() == null
                || model.getTotalAmount() == null || model.getTotalAmount() == 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        Finance finance = new Finance();
        BeanUtils.copyProperties(model, finance);
        finance.setCreateUserId(getLoginUserId());
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
        if (StringUtils.isAnyEmpty(model.getOrderNo()) || model.getStatus() == null || model.getType() == null
                || model.getTotalAmount() == null || model.getTotalAmount() == 0 || model.getId() == null || model.getId() == 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        Finance finance = new Finance();
        BeanUtils.copyProperties(model, finance);
        int update = financeMapper.updateByPrimaryKeySelective(finance);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean getList(FinanceListDTO modelList) {
        if (modelList.getPageNum() == null || modelList.getPageNum() == 0) {
            modelList.setPageNum(1);
        }
        if (modelList.getPageSize() == null || modelList.getPageSize() == 0) {
            modelList.setPageSize(10);
        }
        FinanceExample financeExample = new FinanceExample();
        FinanceExample.Criteria criteria = financeExample.createCriteria();
        if (modelList.getOrderStatus() != null) {
            criteria.andStatusEqualTo(modelList.getOrderStatus().byteValue());
        }
        if (modelList.getOrderType() != null) {
            criteria.andTypeEqualTo(modelList.getOrderType().byteValue());
        }
        if (StringUtils.isNotEmpty(modelList.getOrderNo())) {
            criteria.andOrderNoLike("%" + modelList.getOrderNo() + "%");
        }
        criteria.andIsDeleteEqualTo(CommonEnum.Consts.NO.code);
        Page<Finance> pageData = PageHelper.startPage(modelList.getPageNum(), modelList.getPageSize())
                .doSelectPage(() -> financeMapper.selectByExample(financeExample));
        PageDTO<Finance> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(pageData.getResult());
        return ResultBean.success(pageDTO);
    }
}
