package com.deepsoft.haolifa.service.impl;

import cn.hutool.poi.excel.ExcelWriter;
import com.deepsoft.haolifa.dao.repository.PayManagerCalMapper;
import com.deepsoft.haolifa.model.domain.PayHourQuota;
import com.deepsoft.haolifa.model.domain.PayManagerCal;
import com.deepsoft.haolifa.model.domain.PayManagerCalExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.pay.PayManagerCalDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayManagerCalPageDTO;
import com.deepsoft.haolifa.model.dto.pay.response.PayManagerCalVO;
import com.deepsoft.haolifa.model.dto.pay.response.PayWagesSearchResVO;
import com.deepsoft.haolifa.service.PayManagerCalService;
import com.deepsoft.haolifa.util.BeanCopyUtils;
import com.deepsoft.haolifa.util.ExcelUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class PayManagerServiceImpl extends BaseService implements PayManagerCalService {

    @Resource
    private PayManagerCalMapper payManagerCalMapper;

    @Override
    public ResultBean pageInfo(PayManagerCalPageDTO model) {
        PayManagerCalExample example = new PayManagerCalExample();
        PayManagerCalExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(model.getUserName())) {
            criteria.andUserNameLike("%" + model.getUserName() + "%");
        }
        if (StringUtils.isNotBlank(model.getDept())) {
            criteria.andDeptLike("%" + model.getDept() + "%");
        }
        if (StringUtils.isNotBlank(model.getPostName())) {
            criteria.andPostNameLike("%" + model.getPostName() + "%");
        }
        if (StringUtils.isNotBlank(model.getProject())) {
            criteria.andProjectLike("%" + model.getProject() + "%");
        }
        if (StringUtils.isNotBlank(model.getAppModel())) {
            criteria.andAppModelLike("%" + model.getAppModel() + "%");
        }
        if (StringUtils.isNotBlank(model.getAppSpecifications())) {
            criteria.andAppSpecificationsLike(model.getAppSpecifications());
        }
        example.setOrderByClause("id desc");
        Page<PayManagerCal> payManagerCals = PageHelper.startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> payManagerCalMapper.selectByExample(example));
        PageDTO<PayManagerCalVO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(payManagerCals, pageDTO);
        List<PayManagerCalVO> payManagerCalVOList = BeanCopyUtils.copyPropertiesForNewList(payManagerCals, () -> new PayManagerCalVO());
        pageDTO.setList(payManagerCalVOList);
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean save(PayManagerCalDTO model) {
        PayManagerCal payManagerCal = new PayManagerCal();
        BeanUtils.copyProperties(model, payManagerCal);
        payManagerCal.setCreateUser(getLoginUserName());
        payManagerCal.setUpdateUser(getLoginUserName());
        payManagerCal.setCreateTime(new Date());
        payManagerCal.setUpdateTime(new Date());
        payManagerCalMapper.insert(payManagerCal);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getInfo(Integer id) {
        PayManagerCal payManagerCal = payManagerCalMapper.selectByPrimaryKey(id);
        PayManagerCalVO payManagerCalVO = BeanCopyUtils.copyProperties(payManagerCal, () -> new PayManagerCalVO());
        return ResultBean.success(payManagerCalVO);
    }

    @Override
    public ResultBean edit(PayManagerCalDTO model) {
        PayManagerCal payManagerCal = new PayManagerCal();
        BeanUtils.copyProperties(model, payManagerCal);
        payManagerCal.setUpdateUser(getLoginUserName());
        payManagerCal.setUpdateTime(new Date());
        payManagerCalMapper.updateByPrimaryKeySelective(payManagerCal);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean delete(Integer id) {
        return ResultBean.success(payManagerCalMapper.deleteByPrimaryKey(id));

    }

    @Override
    public List<PayManagerCal> getList(PayManagerCalDTO payManagerCalDTO) {
        PayManagerCalExample example  = new PayManagerCalExample();
        PayManagerCalExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(payManagerCalDTO.getPostName())) {
            criteria.andPostNameEqualTo(payManagerCalDTO.getPostName());
        }
        if (StringUtils.isNotEmpty(payManagerCalDTO.getAppModel())) {
            criteria.andAppModelLike("%" + payManagerCalDTO.getAppModel() + "%");
        }
        if (StringUtils.isNotEmpty(payManagerCalDTO.getAppSpecifications())) {
            criteria.andAppSpecificationsEqualTo(payManagerCalDTO.getAppSpecifications());
        }
        List<PayManagerCal> payManagerCals = payManagerCalMapper.selectByExample(example);
        return payManagerCals;
    }

    @Override
    @Transactional
    public ResultBean save(List<PayManagerCalDTO> list) {
        for (PayManagerCalDTO payManagerCalDTO : list) {
            PayManagerCal payManagerCal = new PayManagerCal();
            BeanUtils.copyProperties(payManagerCalDTO, payManagerCal);
            payManagerCal.setCreateUser(getLoginUserName());
            payManagerCal.setUpdateUser(getLoginUserName());
            payManagerCal.setCreateTime(new Date());
            payManagerCal.setUpdateTime(new Date());
            if (Objects.nonNull(payManagerCal.getId())) {
                PayManagerCal managerCal = payManagerCalMapper.selectByPrimaryKey(payManagerCal.getId());
                if (Objects.nonNull(managerCal)) {
                    payManagerCalMapper.updateByPrimaryKey(payManagerCal);
                } else {
                    payManagerCalMapper.insert(payManagerCal);
                }
            } else {
                payManagerCalMapper.insert(payManagerCal);
            }

        }
        return ResultBean.success(1);
    }

    @Override
    public ExcelWriter export(PayManagerCalDTO payManagerCalDTO) {
        List<PayManagerCal> payManagerCals = getList(payManagerCalDTO);
        List<PayManagerCalDTO> payManagerCalDTOS = BeanCopyUtils.copyPropertiesForNewList(payManagerCals, () -> new PayManagerCalDTO());
        ExcelWriter excelWriter = ExcelUtils.exportExcel(payManagerCalDTOS, PayManagerCalDTO.class);
        return excelWriter;
    }
}
