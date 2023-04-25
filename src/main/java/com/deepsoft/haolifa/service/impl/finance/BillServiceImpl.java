package com.deepsoft.haolifa.service.impl.finance;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.constant.Constant;
import com.deepsoft.haolifa.dao.repository.BizBillMapper;
import com.deepsoft.haolifa.dao.repository.BizProjectBudgetMapper;
import com.deepsoft.haolifa.dao.repository.BizSubjectsMapper;
import com.deepsoft.haolifa.dao.repository.SysDepartmentMapper;
import com.deepsoft.haolifa.enums.DictEnum;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.model.dto.finance.bill.BizBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.bill.BizBillRQDTO;
import com.deepsoft.haolifa.model.dto.finance.bill.BizBillRSDTO;
import com.deepsoft.haolifa.model.dto.finance.bill.BizBillUpDTO;
import com.deepsoft.haolifa.service.SysDictService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.BillService;
import com.deepsoft.haolifa.service.finance.SubjectBalanceService;
import com.deepsoft.haolifa.service.impl.finance.helper.BillHelper;
import com.deepsoft.haolifa.util.DateUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BillServiceImpl implements BillService {
    @Resource
    private SysDepartmentMapper departmentMapper;

    @Resource
    private BizBillMapper bizBillMapper;
    @Resource
    private SysUserService sysUserService;
    @Resource
    private SubjectBalanceService subjectBalanceService;
    @Resource
    private BillHelper billHelper;
    @Resource
    private BizProjectBudgetMapper bizProjectBudgetMapper;
    @Resource
    private SysDictService sysDictService;
    @Resource
    private BizSubjectsMapper bizSubjectsMapper;

    @Override
    public ResultBean save(BizBillAddDTO model) {
        log.info("BizBill saveInfo start|{}", JSONObject.toJSON(model));
        if (StringUtils.isAnyBlank()) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        if (model.getDeptId() == null) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"部门必填");
        }

        CustomUser customUser = sysUserService.selectLoginUser();

        BizBill bizBill = new BizBill();
        BeanUtils.copyProperties(model, bizBill);

        // 设置余额 start
        // 查找最新一条记录的余额
        BizBill lastRecord = bizBillMapper.getLastRecord();
        BigDecimal lastBalance = lastRecord == null || lastRecord.getBalance() == null
            ? BigDecimal.ZERO : lastRecord.getBalance();
        // 设置上月结转
        bizBill.setPreMonthMoney(lastRecord == null || lastRecord.getPreMonthMoney() == null ? BigDecimal.ZERO : lastRecord.getPreMonthMoney());

        // 收款，上次余额 + 本次收款
        if (StringUtils.isNotEmpty(bizBill.getCollectionType())) {
            BigDecimal collectionMoney = bizBill.getCollectionMoney();
            BigDecimal add = collectionMoney.add(lastBalance);
            bizBill.setBalance(add);
        } else if (StringUtils.isNotEmpty(bizBill.getPaymentType())) {
            if (null == model.getPayment()) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"付款必填");
            }

            // 付款 , 上次余额 - 本次付款
            BigDecimal payment = bizBill.getPayment();
            BigDecimal subtract = lastBalance.subtract(payment);
            if (subtract.compareTo(BigDecimal.ZERO) < 0) {
                throw new BaseException("现金余额不足以付款");
            }
            bizBill.setBalance(subtract);

            //
            if (ObjectUtil.isNotNull(model.getProjectCode()) && ObjectUtil.isNotNull(model.getSubject())){
                ResultBean<Object> PARAM_ERROR = billHelper.decreact(model.getProjectCode(),Integer.parseInt(model.getDeptId()),model.getSubject(),
                    model.getRemark(),model.getCertificateNumber(), model.getPayment());
                if (PARAM_ERROR != null) {
                    return PARAM_ERROR;
                }
            }

        }
        // 设置余额 end

        bizBill.setCreateTime(new Date());
        bizBill.setUpdateTime(new Date());
        bizBill.setCreateUser(customUser.getId());
        bizBill.setUpdateUser(customUser.getId());
        int insertId = bizBillMapper.insertSelective(bizBill);

        // 存入余额 费用 借款 货款
        // 1
        //2
        //3
        if (StringUtils.isNotEmpty(bizBill.getCollectionType()) && "123".contains(model.getCollectionType())) {
            subjectBalanceService.increaseAmountBatch(model.getCollectionMoney());
        } else if (StringUtils.isNotEmpty(bizBill.getPaymentType())) {
            // 批量扣减知道怎么做
            //subjectBalanceService.decreaseAmountBatch(model.getCollectionMoney());
        }

        return ResultBean.success(insertId);
    }

    @Override
    public ResultBean savePreMonthMoney() {

        BizBill bizBill = new BizBill();
        // 设置余额 start
        // 查找最新一条记录的余额
        BizBill lastRecord = bizBillMapper.getLastRecord();
        BigDecimal lastBalance = lastRecord == null || lastRecord.getBalance() == null
            ? BigDecimal.ZERO : lastRecord.getBalance();

        bizBill.setD(new Date());
        bizBill.setString1(Constant.company);
        bizBill.setString1(Constant.company);
        // 设置上月结转
        bizBill.setPreMonthMoney(lastBalance);
        bizBill.setBalance(lastBalance);
        bizBill.setRemark(DateUtils.getDate()+"月结");
        bizBill.setCreateTime(new Date());
        bizBill.setUpdateTime(new Date());
        int insertId = bizBillMapper.insertSelective(bizBill);
        return ResultBean.success(insertId);
    }

    @Override
    public ResultBean delete(Integer id) {
//        int delete = bizBillMapper.deleteByPrimaryKey(id);
//        return ResultBean.success(delete);
        BizBill bizBill = new BizBill();
        bizBill.setId(id);
        bizBill.setDelFlag("1");
        bizBill.setUpdateTime(new Date());
        bizBill.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizBillMapper.updateByPrimaryKeySelective(bizBill);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean update(BizBillUpDTO bizBillUpDTO) {
        BizBill bizBill = new BizBill();
        BeanUtils.copyProperties(bizBillUpDTO,bizBill);
        BizBill selectByPrimaryKey = bizBillMapper.selectByPrimaryKey(bizBillUpDTO.getId());

        BigDecimal divide = bizBill.getPayment().subtract(selectByPrimaryKey.getPayment());
        BigDecimal bigDecimal = selectByPrimaryKey.getBalance().add(divide);
        bizBill.setBalance(bigDecimal);

        bizBill.setUpdateTime(new Date());
        bizBill.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizBillMapper.updateByPrimaryKeySelective(bizBill);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean getInfo(Integer id) {
        BizBill bizBill = bizBillMapper.selectByPrimaryKey(id);
        return ResultBean.success(bizBill);
    }

    @Override
    public ResultBean<PageDTO<BizBillRSDTO>> getList(BizBillRQDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }
        BizBillExample bizBillExample = new BizBillExample();
        BizBillExample.Criteria criteria = bizBillExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);
        // 凭证号 ==
        if (StringUtils.isNotEmpty(model.getCertificateNumber())) {
            criteria.andCertificateNumberEqualTo(model.getCertificateNumber());
        }
        // 付款类型 ==
        if (StringUtils.isNotEmpty(model.getPaymentType())) {
            criteria.andPaymentTypeEqualTo(model.getPaymentType());
        }
        //  收款单位 like
        if (StringUtils.isNotEmpty(model.getPaymentType())) {
            criteria.andPaymentTypeEqualTo(model.getPaymentType());
        }
        // 付款单位 like
        if (StringUtils.isNotEmpty(model.getCollectionCompany())) {
            criteria.andString2Like(model.getCollectionCompany());
        }
        // 部门 like
        if (StringUtils.isNotEmpty(model.getDeptName())) {
            SysDepartmentExample departmentExample = new SysDepartmentExample();
            SysDepartmentExample.Criteria departmentExampleCriteria = departmentExample.createCriteria();
            departmentExampleCriteria.andDeptNameLike(model.getDeptName());
            List<String> deparList = departmentMapper.selectByExample(departmentExample).stream()
                .map(department -> department.getId() + "")
                .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(deparList)) {
                criteria.andDeptIdIn(deparList);
            }
        }


        // 凭证号 付款类别 收款单位 付款单位 部门
        bizBillExample.setOrderByClause("id desc");
        Page<BizBill> pageData = PageHelper
            .startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> {
                bizBillMapper.selectByExample(bizBillExample);
            });


        List<Integer> departIdList = pageData.getResult().stream()
            .filter(bizBill -> StringUtils.isNotEmpty(bizBill.getDeptId()))
            .map(bizBill -> Integer.parseInt(bizBill.getDeptId()))
            .distinct()
            .collect(Collectors.toList());

        Map<Integer, DepartmentDTO> departmentMap = new HashMap<>();
        // 查询部门
        if (CollectionUtils.isNotEmpty(departIdList)) {
            SysDepartmentExample departmentExample = new SysDepartmentExample();
            SysDepartmentExample.Criteria departmentExampleCriteria = departmentExample.createCriteria();
            departmentExampleCriteria.andIdIn(departIdList);
            departmentMap = departmentMapper.selectByExample(departmentExample).stream()
                .map(sysDepartment -> {
                    DepartmentDTO departmentDTO = new DepartmentDTO();
                    BeanUtils.copyProperties(sysDepartment, departmentDTO);
                    return departmentDTO;
                })
                .collect(Collectors.toMap(DepartmentDTO::getId, Function.identity(), (a, b) -> a));
        }


        List<String> projectCodeList = pageData.getResult().stream()
            .map(BizBill::getProjectCode)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
        Map<String, String> projectCodeMap = new HashMap<>();
        if (CollectionUtil.isNotEmpty(projectCodeList)) {
            BizProjectBudgetExample bizProjectBudgetExample = new BizProjectBudgetExample();
            BizProjectBudgetExample.Criteria criteriaBizProjectBudgetExample = bizProjectBudgetExample.createCriteria();
            criteriaBizProjectBudgetExample.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);
            criteriaBizProjectBudgetExample.andCodeIn(projectCodeList);
            projectCodeMap = bizProjectBudgetMapper.selectByExample(bizProjectBudgetExample)
                .stream()
                .collect(Collectors.toMap(BizProjectBudget::getCode, BizProjectBudget::getName,
                    (a, b) -> a));
        }

        Map<String, String> finalProjectCodeMap = projectCodeMap;


        Map<String, String> subjects_type_map = sysDictService.getSysDictByTypeCode(
                DictEnum.SUBJECTS_TYPE.getCode()).stream()
            .collect(Collectors.toMap(SysDict::getCode, SysDict::getName, (a, b) -> a));


        Map<Integer, DepartmentDTO> finalDepartmentMap = departmentMap;
        List<BizBillRSDTO> bizBillDTOS = pageData.getResult().stream()
            .map(bizBill -> {
                BizBillRSDTO bizBillDTO = new BizBillRSDTO();
                BeanUtils.copyProperties(bizBill, bizBillDTO);
                bizBillDTO.setCollectionCompany(bizBill.getString1());
                bizBillDTO.setPaymentCompany(bizBill.getString2());
                DepartmentDTO departmentDTO = finalDepartmentMap.get(StringUtils.isNotEmpty(bizBill.getDeptId()) ? Integer.parseInt(bizBill.getDeptId()) : -1);
                bizBillDTO.setDepartmentDTO(departmentDTO);

                BizSubjects bizSubjects = bizSubjectsMapper.selectByPrimaryKey(
                    bizBill.getSubject());

                bizBillDTO.setSubjectType(bizSubjects != null ? bizSubjects.getType() : "");
                bizBillDTO.setSubjectTypeName(bizSubjects != null ? subjects_type_map.get(bizSubjects.getType()) : "");

                bizBillDTO.setProjectCodeName(
                    finalProjectCodeMap.getOrDefault(bizBill.getProjectCode(), ""));

                return bizBillDTO;
            })
            .collect(Collectors.toList());

        PageDTO<BizBillRSDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(bizBillDTOS);
        return ResultBean.success(pageDTO);
    }


    @Override
    public ResultBean getBillContractDetailByBillId(int id) {
        BizBill bizBill = bizBillMapper.selectByPrimaryKey(id);

        BizBillRQDTO bizBillDTO = new BizBillRQDTO();
        BeanUtils.copyProperties(bizBill, bizBillDTO);
        // todo 欠缺 销售合同号saleContractNo

        //
        return ResultBean.success(bizBillDTO);
    }
}
