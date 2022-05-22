package com.deepsoft.haolifa.service.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.constant.CommonEnum.ResponseEnum;
import com.deepsoft.haolifa.dao.repository.ExpensesClassifyMapper;
import com.deepsoft.haolifa.dao.repository.ExpensesMapper;
import com.deepsoft.haolifa.dao.repository.extend.EntryOutRecordExtendMapper;
import com.deepsoft.haolifa.dao.repository.extend.ExpensesExtendMapper;
import com.deepsoft.haolifa.model.domain.Expenses;
import com.deepsoft.haolifa.model.domain.ExpensesClassifyExample;
import com.deepsoft.haolifa.model.domain.ExpensesExample;
import com.deepsoft.haolifa.model.domain.ExpensesReport;
import com.deepsoft.haolifa.model.dto.ExpensesDTO;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.expenses.ExpensesConditionDTO;
import com.deepsoft.haolifa.model.dto.export.ExportContractDTO;
import com.deepsoft.haolifa.model.dto.export.ExportSaleMapDTO;
import com.deepsoft.haolifa.model.dto.report.ReportBaseDTO;
import com.deepsoft.haolifa.service.ExpensesService;
import com.deepsoft.haolifa.util.CommonUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ExpensesServiceImpl extends BaseService implements ExpensesService {

    @Autowired
    private ExpensesMapper expensesMapper;
    @Autowired
    private ExpensesExtendMapper expensesExtendMapper;
    @Autowired
    private ExpensesClassifyMapper classifyMapper;
    @Autowired
    private EntryOutRecordExtendMapper entryOutRecordExtendMapper;


    @Override
    public ResultBean save(ExpensesDTO model) {
        if (StringUtils.isAnyBlank(model.getExpensesClassify(), model.getVoucherNo())
            || model.getTotalAmount() == null || model.getTotalAmount() == 0) {
            return ResultBean.error(ResponseEnum.PARAM_ERROR);
        }
        Expenses expenses = new Expenses();
        BeanUtils.copyProperties(model, expenses);
        // 费用年月处理
        if (StringUtils.isNotBlank(model.getDataDate())) {
            String dataYear = model.getDataDate().substring(0, 4);
            expenses.setDataYear(dataYear);
            String dataMonth = model.getDataDate().substring(5, 7);
            expenses.setDataMonth(dataMonth);
            expenses.setDateStr(model.getDataDate());
        }

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
        if (StringUtils.isAnyBlank(model.getExpensesClassify(), model.getVoucherNo())
            || model.getTotalAmount() == null || model.getTotalAmount() == 0) {
            return ResultBean.error(ResponseEnum.PARAM_ERROR);
        }
        Expenses expenses = new Expenses();
        BeanUtils.copyProperties(model, expenses);
        // 费用年月处理
        if (StringUtils.isNotBlank(model.getDataDate())) {
            String dataYear = model.getDataDate().substring(0, 4);
            expenses.setDataYear(dataYear);
            String dataMonth = model.getDataDate().substring(5, 7);
            expenses.setDataMonth(dataMonth);
            expenses.setDateStr(model.getDataDate());
        }
        expenses.setTotalAmount(new BigDecimal(model.getTotalAmount()));
        expensesMapper.updateByPrimaryKeySelective(expenses);
        return ResultBean.success(0);
    }

    @Override
    public ResultBean getList(ExpensesConditionDTO expensesDTO) {
        ExpensesExample expensesExample = new ExpensesExample();
        ExpensesExample.Criteria criteria = expensesExample.createCriteria();
        if (StringUtils.isNotEmpty(expensesDTO.getClassifyName()) && !"全部".equals(expensesDTO.getClassifyName())) {
            criteria.andSecondClassifyLike("%" + expensesDTO.getClassifyName() + "%");
        }
        if (StringUtils.isNotEmpty(expensesDTO.getSecondClassifyName()) && !"全部".equals(expensesDTO.getSecondClassifyName())) {
            criteria.andSecondClassifyLike("%" + expensesDTO.getSecondClassifyName() + "%");
        }
        if (StringUtils.isNotEmpty(expensesDTO.getDepartment())) {
            criteria.andDepartmentLike("%" + expensesDTO.getDepartment() + "%");
        }
        if (StringUtils.isNotEmpty(expensesDTO.getVoucherNo())) {
            criteria.andVoucherNoLike("%" + expensesDTO.getVoucherNo() + "%");
        }
        if (StrUtil.isNotEmpty(expensesDTO.getYear())) {
            criteria.andDataYearEqualTo(expensesDTO.getYear());
        }
        if (StrUtil.isNotEmpty(expensesDTO.getMonth())) {
            criteria.andDataMonthEqualTo(expensesDTO.getMonth());
        }
        if (StrUtil.isNotEmpty(expensesDTO.getStartDate())) {
            criteria.andDateStrGreaterThanOrEqualTo(expensesDTO.getStartDate());
        }
        if (StrUtil.isNotEmpty(expensesDTO.getEndDate())) {
            criteria.andDateStrLessThanOrEqualTo(expensesDTO.getEndDate());
        }
        if (StrUtil.isNotEmpty(expensesDTO.getCommitUser())) {
            criteria.andCommitUserLike("%" + expensesDTO.getCommitUser() + "%");
        }
        criteria.andIsDeleteEqualTo(CommonEnum.Consts.NO.code);
        expensesExample.setOrderByClause("id desc");
        Page<Expenses> page = PageHelper.startPage(expensesDTO.getPageNum(), expensesDTO.getPageSize())
            .doSelectPage(() -> expensesMapper.selectByExample(expensesExample));
        PageDTO<Expenses> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(page, pageDTO);
        pageDTO.setList(page.getResult());
        return ResultBean.success(pageDTO);
    }

    @Override
    public String listSummary(ExpensesConditionDTO expensesDTO) {
        return expensesExtendMapper.listSummary(expensesDTO);
    }

    @Override
    public ResultBean classify(Integer pId) {
        ExpensesClassifyExample classifyExample = new ExpensesClassifyExample();
        classifyExample.createCriteria().andClassifyPidEqualTo(pId);
        return ResultBean.success(classifyMapper.selectByExample(classifyExample));
    }

    @Override
    public ResultBean getClassify(String expensesClassify) {
        return ResultBean.success(expensesExtendMapper.getClassify(expensesClassify));
    }

    @Override
    public ResultBean classifyByDepartment() {
        return ResultBean.success(expensesExtendMapper.classifyByDepartment());
    }

    @Override
    public ResultBean getAllClassify(ExpensesConditionDTO expensesConditionDTO) {
        return ResultBean.success(expensesExtendMapper.getAllClassify(expensesConditionDTO));
    }

    @Override
    public ResultBean classifyByDepartmentAll(ExpensesConditionDTO expensesConditionDTO) {
        return ResultBean.success(expensesExtendMapper.classifyByDepartmentAll(expensesConditionDTO));
    }

    @Override
    public ResultBean getAllClassifyWithDepartment(ExpensesConditionDTO expensesConditionDTO) {
        return ResultBean.success(expensesExtendMapper.getAllClassifyWithDepartment(expensesConditionDTO));
    }

    @Override
    public ResultBean getMonthByDepartment(String department) {
        return ResultBean.success(expensesExtendMapper.getMonthByDepartment(department));
    }

    @Override
    public ResultBean getAllClassifyWithFirstClassify(String classify) {
        return ResultBean.success(expensesExtendMapper.getAllClassifyWithFirstClassify(classify));
    }

    @Override
    public ResultBean expenseTotalByMonth(String year) {
        Set<String> dataMonthSet = new HashSet<>();
        ExpensesConditionDTO expensesConditionDTO = new ExpensesConditionDTO();
        expensesConditionDTO.setYear(year);
        List<ExpensesReport> expensesReports = expensesExtendMapper.expenseTotalByMonth(expensesConditionDTO);
        String lastYear = CommonUtil.getLastYear(year);
        ExpensesConditionDTO lastExpensesConditionDTO = new ExpensesConditionDTO();
        expensesConditionDTO.setYear(lastYear);
        List<ExpensesReport> lastExpensesReports = expensesExtendMapper.expenseTotalByMonth(lastExpensesConditionDTO);

        // 将今年和往年的客户集合起来
        Set<String> dataSet = expensesReports.stream().map(ExpensesReport::getDataMonth).collect(Collectors.toSet());
        Set<String> lastDataSet = lastExpensesReports.stream().map(ExpensesReport::getDataMonth).collect(Collectors.toSet());
        dataMonthSet.addAll(dataSet);
        dataMonthSet.addAll(lastDataSet);

        List<ExportSaleMapDTO> resultList = new ArrayList<>();
        dataMonthSet.forEach((dataMonth) -> {
            ExportSaleMapDTO exportSaleMapDTO = new ExportSaleMapDTO();
            exportSaleMapDTO.setCompanyName(dataMonth);
            List<ExportSaleMapDTO.ValueRespVo> valueRespVoList = new ArrayList<>();
            ExportSaleMapDTO.ValueRespVo valueRespVo = new ExportSaleMapDTO.ValueRespVo();
            valueRespVo.setYear(year);
            BigDecimal yearAmount = expensesReports.stream().filter(e -> e.getDataMonth().equals(dataMonth) && null != e.getTotalAmount()).map(ExpensesReport::getTotalAmount).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
            valueRespVo.setAmount(yearAmount);
            valueRespVoList.add(valueRespVo);

            ExportSaleMapDTO.ValueRespVo valueRespVo1 = new ExportSaleMapDTO.ValueRespVo();
            valueRespVo1.setYear(lastYear);
            BigDecimal lastYearAmount = lastExpensesReports.stream().filter(e -> e.getDataMonth().equals(dataMonth) && null != e.getTotalAmount()).map(ExpensesReport::getTotalAmount).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
            valueRespVo1.setAmount(lastYearAmount);
            valueRespVoList.add(valueRespVo1);

            exportSaleMapDTO.setValue(valueRespVoList);
            resultList.add(exportSaleMapDTO);
        });
        List<ExportSaleMapDTO> collect = resultList.stream().sorted(Comparator.comparing(ExportSaleMapDTO::getCompanyName)).collect(Collectors.toList());
        return ResultBean.success(collect);
    }

    @Override
    public List<ExpensesReport> qualityExpenseTotalByMonth(String year) {
        ExpensesConditionDTO expensesConditionDTO = new ExpensesConditionDTO();
        expensesConditionDTO.setYear(year);
        expensesConditionDTO.setClassifyName("质量费用");
        return expensesExtendMapper.expenseTotalByMonth(expensesConditionDTO);
    }

    @Override
    public List<ExpensesReport> financeExpenseTotalByMonth(String year) {
        ExpensesConditionDTO expensesConditionDTO = new ExpensesConditionDTO();
        expensesConditionDTO.setYear(year);
        expensesConditionDTO.setClassifyName("财务费用");
        return expensesExtendMapper.expenseTotalByMonth(expensesConditionDTO);
    }

    @Override
    public List<ExpensesReport> costMaterialByMonth(String year) {
        List<ExpensesReport> list = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            ExpensesReport report = new ExpensesReport();
            report.setDataYear(year);
            report.setDataMonth(String.valueOf(i));
            Map<String, Object> paramMap = new HashMap<>();
            String month = "";
            if (i < 10) {
                month = "0".concat(String.valueOf(i));
            } else {
                month = String.valueOf(i);
            }
            String yearMonth = year.concat("-").concat(month);
            paramMap.put("startDate", CommonUtil.packYearMonthMapParamStart(yearMonth));
            paramMap.put("endDate", CommonUtil.packYearMonthMapParamEnd(yearMonth));
            report.setTotalAmount(entryOutRecordExtendMapper.costMaterial(paramMap));
            list.add(report);
        }
        return list;
    }

}
