package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.ContractMapper;
import com.deepsoft.haolifa.model.domain.Contract;
import com.deepsoft.haolifa.model.domain.ContractExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.ContractService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractMapper contractMapper;

    @Override
    public ResultBean list(String orderNo, Integer pageNum, Integer pageSize) {
        ContractExample contractExample = new ContractExample();
        ContractExample.Criteria criteria = contractExample.createCriteria();
        criteria.andIsDeleteEqualTo(CommonEnum.Consts.NO.code);
        if (StringUtils.isNotEmpty(orderNo)) {
            criteria.andOrderNoLike("%" + orderNo + "%");
        }
        Page<Contract> page = PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> contractMapper.selectByExample(contractExample));
        PageDTO<Contract> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(page, pageDTO);
        pageDTO.setList(page.getResult());
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean info(String orderNo) {
        ContractExample contractExample = new ContractExample();
        contractExample.or().andIsDeleteEqualTo(CommonEnum.Consts.NO.code)
                .andOrderNoEqualTo(orderNo);
        return ResultBean.success(contractMapper.selectByExample(contractExample));
    }
}
