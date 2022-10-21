package com.deepsoft.haolifa.service.impl;

import cn.hutool.poi.excel.ExcelWriter;
import com.deepsoft.haolifa.dao.repository.PayManagerCalMapper;
import com.deepsoft.haolifa.dao.repository.PayProductionWorkshopMapper;
import com.deepsoft.haolifa.dao.repository.SysDepartmentMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.pay.PayManagerCalDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayManagerCalPageDTO;
import com.deepsoft.haolifa.model.dto.pay.response.PayManagerCalVO;
import com.deepsoft.haolifa.service.PayManagerCalService;
import com.deepsoft.haolifa.util.BeanCopyUtils;
import com.deepsoft.haolifa.util.ExcelUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PayManagerServiceImpl extends BaseService implements PayManagerCalService {

    @Resource
    private PayManagerCalMapper payManagerCalMapper;
    @Resource
    private SysDepartmentMapper sysDepartmentMapper;
    @Resource
    private PayProductionWorkshopMapper payProductionWorkshopMapper;

    @Override
    public ResultBean pageInfo(PayManagerCalPageDTO model) {
        PayManagerCalExample example = new PayManagerCalExample();
        PayManagerCalExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(model.getUserName())) {
            criteria.andUserNameLike("%" + model.getUserName() + "%");
        }
        if (StringUtils.isNotBlank(model.getDept())) {
            SysDepartmentExample sysDepartmentExample = new SysDepartmentExample();
            SysDepartmentExample.Criteria crit = sysDepartmentExample.createCriteria();
            crit.andDeptNameLike("%" + model.getDept() + "%");
            List<SysDepartment> sysDepartments = sysDepartmentMapper.selectByExample(sysDepartmentExample);
            if (CollectionUtils.isNotEmpty(sysDepartments)) {
                List<Integer> collect = sysDepartments.stream().map(ss -> ss.getId()).collect(Collectors.toList());
                criteria.andDepartIdIn(collect);
            }
        }
        if (StringUtils.isNotBlank(model.getPostName())) {
            PayProductionWorkshopExample payProductionWorkshopExample = new PayProductionWorkshopExample();
            PayProductionWorkshopExample.Criteria workCriteria = payProductionWorkshopExample.createCriteria();
            workCriteria.andPostNameLike("%" + model.getPostName() + "%");
            List<PayProductionWorkshop> payProductionWorkshops = payProductionWorkshopMapper.selectByExample(payProductionWorkshopExample);
            if (CollectionUtils.isNotEmpty(payProductionWorkshops)) {
                List<Integer> collect = payProductionWorkshops.stream().map(ss -> ss.getId()).collect(Collectors.toList());
                criteria.andPostIdIn(collect);
            }
        }
        if (StringUtils.isNotBlank(model.getProject())) {
            criteria.andProjectLike("%" + model.getProject() + "%");
        }
        if (StringUtils.isNotBlank(model.getAppModel())) {
            criteria.andAppModelLike("%" + model.getAppModel() + "%");
        }
        if (StringUtils.isNotBlank(model.getAppSpecifications())) {
            criteria.andAppSpecificationsLike("%" + model.getAppSpecifications() + "%");
        }
        if (StringUtils.isNotBlank(model.getWorkType())) {
            criteria.andWorkTypeLike("%" + model.getWorkType() + "%");
        }
        if (StringUtils.isNotBlank(model.getIdCategory())) {
            criteria.andIdCategoryLike("%" + model.getIdCategory() + "%");
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
        SysDepartment sysDepartment = sysDepartmentMapper.selectByPrimaryKey(payManagerCal.getDepartId());
        payManagerCal.setDept(sysDepartment.getDeptName());
        PayProductionWorkshop payProductionWorkshop = payProductionWorkshopMapper.selectByPrimaryKey(payManagerCal.getPostId());
        payManagerCal.setPostName(payProductionWorkshop.getPostName());
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

        SysDepartment sysDepartment = sysDepartmentMapper.selectByPrimaryKey(payManagerCal.getDepartId());
        if (Objects.nonNull(sysDepartment)) {
            payManagerCal.setDept(sysDepartment.getDeptName());
        }
        PayProductionWorkshop payProductionWorkshop = payProductionWorkshopMapper.selectByPrimaryKey(payManagerCal.getPostId());
        if (Objects.nonNull(payProductionWorkshop)) {
            payManagerCal.setPostName(payProductionWorkshop.getPostName());
        }
        PayManagerCalVO payManagerCalVO = BeanCopyUtils.copyProperties(payManagerCal, () -> new PayManagerCalVO());
        return ResultBean.success(payManagerCalVO);
    }

    @Override
    public ResultBean edit(PayManagerCalDTO model) {
        PayManagerCal payManagerCal = new PayManagerCal();
        BeanUtils.copyProperties(model, payManagerCal);
        payManagerCal.setUpdateUser(getLoginUserName());
        payManagerCal.setUpdateTime(new Date());

        SysDepartment sysDepartment = sysDepartmentMapper.selectByPrimaryKey(payManagerCal.getDepartId());
        if (Objects.nonNull(sysDepartment)) {
            payManagerCal.setDept(sysDepartment.getDeptName());
        }
        PayProductionWorkshop payProductionWorkshop = payProductionWorkshopMapper.selectByPrimaryKey(payManagerCal.getPostId());
        if (Objects.nonNull(payProductionWorkshop)) {
            payManagerCal.setPostName(payProductionWorkshop.getPostName());
        }
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
            PayProductionWorkshopExample payProductionWorkshopExample = new PayProductionWorkshopExample();
            PayProductionWorkshopExample.Criteria workCriteria = payProductionWorkshopExample.createCriteria();
            workCriteria.andPostNameLike("%" + payManagerCalDTO.getPostName() + "%");
            List<PayProductionWorkshop> payProductionWorkshops = payProductionWorkshopMapper.selectByExample(payProductionWorkshopExample);
            if (CollectionUtils.isNotEmpty(payProductionWorkshops)) {
                List<Integer> collect = payProductionWorkshops.stream().map(ss -> ss.getId()).collect(Collectors.toList());
                criteria.andPostIdIn(collect);
            }
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

            SysDepartment sysDepartment = sysDepartmentMapper.selectByPrimaryKey(payManagerCal.getDepartId());
            if (Objects.nonNull(sysDepartment)) {
                payManagerCal.setDept(sysDepartment.getDeptName());
            }
            PayProductionWorkshop payProductionWorkshop = payProductionWorkshopMapper.selectByPrimaryKey(payManagerCal.getPostId());
            if (Objects.nonNull(payProductionWorkshop)) {
                payManagerCal.setPostName(payProductionWorkshop.getPostName());
            }
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

    @Async
    @Override
    public void syncData() {
        List<PayManagerCal> payManagerCalList = payManagerCalMapper.selectByExample(new PayManagerCalExample());
        payManagerCalList.stream().forEach(cc -> {
            SysDepartmentExample sysDepartmentExample = new SysDepartmentExample();
            SysDepartmentExample.Criteria crit = sysDepartmentExample.createCriteria();
            crit.andDeptNameEqualTo(cc.getDept());
            List<SysDepartment> sysDepartments = sysDepartmentMapper.selectByExample(sysDepartmentExample);
            if (CollectionUtils.isNotEmpty(sysDepartments)) {
                Integer id = sysDepartments.get(0).getId();
                cc.setDepartId(id);
            }
            PayProductionWorkshopExample payProductionWorkshopExample = new PayProductionWorkshopExample();
            PayProductionWorkshopExample.Criteria workCriteria = payProductionWorkshopExample.createCriteria();
            workCriteria.andPostNameEqualTo(cc.getPostName());
            List<PayProductionWorkshop> payProductionWorkshops = payProductionWorkshopMapper.selectByExample(payProductionWorkshopExample);
            if (CollectionUtils.isNotEmpty(payProductionWorkshops)) {
                Integer id = payProductionWorkshops.get(0).getId();
                cc.setPostId(id);
            }
            payManagerCalMapper.updateByPrimaryKeySelective(cc);
        });
    }
}
