package com.deepsoft.haolifa.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.InvoiceMapper;
import com.deepsoft.haolifa.model.domain.Invoice;
import com.deepsoft.haolifa.model.domain.InvoiceExample;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.service.InvoiceService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class InvoiceServiceImpl extends BaseService implements InvoiceService {

    @Autowired
    InvoiceMapper invoiceMapper;

    @Override
    public ResultBean save(InvoiceCreateDTO model) {
        if (validateIsEmpty(model)) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        Map<String, Object> result = new HashMap<>(8);
        Invoice invoice = new Invoice();
        invoice.setStatus(model.getStatus().byteValue());
        invoice.setType(model.getType().byteValue());
        invoice.setOrderNo(model.getOrderNo());
        invoice.setRemark(model.getRemark());
        invoice.setTotalAmount(new BigDecimal(model.getTotalAmount()));
        invoice.setId(model.getId());
        invoice.setInvoiceNo(model.getInvoiceNo());
        invoice.setCreateUserId(getLoginUserId());
        invoice.setInvoiceCompany(model.getInvoiceCompany());
        invoice.setInvoiceIssuing(model.getInvoiceIssuing());
        invoice.setInvoiceDate(model.getInvoiceDate());
        if (model.getType() == 1) {
            invoice.setConstractParty(model.getInvoiceCompany());
        } else {
            invoice.setConstractParty(model.getInvoiceIssuing());
        }
        if (invoice.getId() != null) {
            invoiceMapper.updateByPrimaryKeySelective(invoice);
        } else {
            invoiceMapper.insertSelective(invoice);
            result.put("formId", invoice.getId());
            result.put("formNo", invoice.getInvoiceNo());
        }
        return ResultBean.success(result);
    }

    private boolean validateIsEmpty(InvoiceCreateDTO model) {
        if (StringUtils.isEmpty(model.getOrderNo())) {
            return true;
        }
        if (model.getTotalAmount() == null || model.getTotalAmount() == 0) {
            return true;
        }
        if (model.getType() == null) {
            return true;
        }
        return false;

    }

    @Override
    public ResultBean delete(int id) {
        invoiceMapper.deleteByPrimaryKey(id);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean update(InvoiceDTO model) {
        Invoice invoice = new Invoice();
        BeanUtils.copyProperties(model, invoice);
        invoice.setTotalAmount(new BigDecimal(model.getTotalAmount()));
        int update = invoiceMapper.updateByPrimaryKeySelective(invoice);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean updateInvoiceNo(InvoiceStatusDTO statusDTO) {
        Invoice invoice = new Invoice();
        invoice.setInvoiceNo(statusDTO.getInvoiceNo());
        invoice.setId(statusDTO.getId());
        invoice.setStatus((byte) 2);// 已开票
        invoice.setInvoiceDate(statusDTO.getInvoiceDate());// 开票日期
        invoiceMapper.updateByPrimaryKeySelective(invoice);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getList(int origin, InvoiceListDTO modelList) {
        if (modelList.getPageNum() == null || modelList.getPageNum() == 0) {
            modelList.setPageNum(1);
        }
        if (modelList.getPageSize() == null || modelList.getPageSize() == 0) {
            modelList.setPageSize(10);
        }
        InvoiceExample invoiceExample = new InvoiceExample();
        InvoiceExample.Criteria criteria = invoiceExample.createCriteria();
//    if(origin == 0) {
////      经管申请
//      criteria.andCreateUserIdEqualTo(getLoginUserId());
//    }
        if (StringUtils.isNotEmpty(modelList.getOrderNo())) {
            criteria.andOrderNoLike("%" + modelList.getOrderNo() + "%");
        }
        if (modelList.getStatus() > -1) {
            criteria.andStatusEqualTo(modelList.getStatus());
        }
        if (CollectionUtil.isNotEmpty(modelList.getStatusList())) {
            criteria.andStatusIn(modelList.getStatusList());
        }
        if (StringUtils.isNotEmpty(modelList.getConstractParty())) {
            criteria.andConstractPartyLike("%" + modelList.getConstractParty() + "%");
        }
        if (modelList.getType() != 0) {
            criteria.andTypeEqualTo(modelList.getType().byteValue());
        }
        // 开票日期
        if (ObjectUtil.isNotNull(modelList.getInvoiceDate())) {
            // 获取一个月的开始，一个月的结束
            DateTime beginOfMonth = DateUtil.beginOfMonth(modelList.getInvoiceDate());
            DateTime endOfMonth = DateUtil.endOfMonth(modelList.getInvoiceDate());
            criteria.andInvoiceDateGreaterThanOrEqualTo(beginOfMonth);
            criteria.andInvoiceDateLessThanOrEqualTo(endOfMonth);
        }
        criteria.andIsDeleteEqualTo(CommonEnum.Consts.NO.code);
        Page<Invoice> pageData = PageHelper.startPage(modelList.getPageNum(), modelList.getPageSize(), "create_time desc")
            .doSelectPage(() -> invoiceMapper.selectByExample(invoiceExample));
        PageDTO<Invoice> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(pageData.getResult());
        return ResultBean.success(pageDTO);
    }

    public static void main(String[] args) {
        DateTime beginOfMonth = DateUtil.beginOfMonth(new Date());
        DateTime endOfMonth = DateUtil.endOfMonth(new Date());

        System.out.println(beginOfMonth);
        System.out.println(endOfMonth);
    }

    @Override
    public ResultBean info(Integer id) {
        return ResultBean.success(invoiceMapper.selectByPrimaryKey(id));
    }

    @Override
    public int updateStatus(InvoiceStatusDTO statusDTO) {
        Invoice invoice = new Invoice();
        invoice.setId(statusDTO.getId());
        invoice.setStatus(statusDTO.getStatus());
        return invoiceMapper.updateByPrimaryKeySelective(invoice);
    }

    @Override
    public BigDecimal getTotalAmount(String orderNo) {
        InvoiceExample invoiceExample = new InvoiceExample();
        InvoiceExample.Criteria criteria = invoiceExample.createCriteria();
        criteria.andIsDeleteEqualTo(CommonEnum.Consts.NO.code);
        criteria.andOrderNoEqualTo(orderNo);
        List<Invoice> invoices = invoiceMapper.selectByExample(invoiceExample);
        return invoices.stream().map(Invoice::getTotalAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
