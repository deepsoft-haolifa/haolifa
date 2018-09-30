package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.InvoiceMapper;
import com.deepsoft.haolifa.model.domain.Invoice;
import com.deepsoft.haolifa.model.domain.InvoiceExample;
import com.deepsoft.haolifa.model.dto.InvoiceDTO;
import com.deepsoft.haolifa.model.dto.InvoiceListDTO;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.InvoiceService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class InvoiceServiceImpl extends BaseService implements InvoiceService {

    @Autowired
    InvoiceMapper invoiceMapper;

    @Override
    public ResultBean save(InvoiceDTO model) {
        if (StringUtils.isAnyEmpty(model.getOrderNo(), model.getInvoiceNo()) || model.getStatus() == null || model.getType() == null
                || model.getTotalAmount() == null || model.getTotalAmount() == 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        Invoice invoice = new Invoice();
        BeanUtils.copyProperties(model, invoice);
        invoice.setTotalAmount(new BigDecimal(model.getTotalAmount()));
        invoice.setCreateUserId(getLoginUserId());
        int insert = invoiceMapper.insertSelective(invoice);
        return ResultBean.success(insert);
    }

    @Override
    public ResultBean delete(Integer id) {
        Invoice invoice = new Invoice();
        invoice.setIsDelete(CommonEnum.Consts.YES.code);
        InvoiceExample invoiceExample = new InvoiceExample();
        invoiceExample.or().andIdEqualTo(id);
        int delete = invoiceMapper.updateByExampleSelective(invoice, invoiceExample);
        return ResultBean.success(delete);
    }

    @Override
    public ResultBean update(InvoiceDTO model) {
        if (StringUtils.isAnyEmpty(model.getOrderNo(), model.getInvoiceNo()) || model.getStatus() == null || model.getType() == null
                || model.getTotalAmount() == null || model.getTotalAmount() == 0 || model.getId() == null || model.getId() == 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        Invoice invoice = new Invoice();
        BeanUtils.copyProperties(model, invoice);
        invoice.setTotalAmount(new BigDecimal(model.getTotalAmount()));
        int update = invoiceMapper.updateByPrimaryKeySelective(invoice);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean getList(InvoiceListDTO modelList) {
        if (modelList.getPageNum() == null || modelList.getPageNum() == 0) {
            modelList.setPageNum(1);
        }
        if (modelList.getPageSize() == null || modelList.getPageSize() == 0) {
            modelList.setPageSize(10);
        }
        InvoiceExample invoiceExample = new InvoiceExample();
        InvoiceExample.Criteria criteria = invoiceExample.createCriteria();
        criteria.andIsDeleteEqualTo(CommonEnum.Consts.NO.code);
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
        Page<Invoice> pageData = PageHelper.startPage(modelList.getPageNum(), modelList.getPageSize())
                .doSelectPage(() -> invoiceMapper.selectByExample(invoiceExample));
        PageDTO<Invoice> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(pageData.getResult());
        return ResultBean.success(pageDTO);
    }
}
