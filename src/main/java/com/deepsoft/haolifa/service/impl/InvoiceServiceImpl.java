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

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class InvoiceServiceImpl extends BaseService implements InvoiceService {

    @Autowired
    InvoiceMapper invoiceMapper;

    @Override
    public ResultBean save(InvoiceDTO model) {
        if (StringUtils.isAnyEmpty(model.getOrderNo(),model.getCompany(),model.getLinkman(),model.getMialingAddress())
                || model.getTotalAmount() == null || model.getTotalAmount() == 0
                || (model.getType() == 1 && StringUtils.isEmpty(model.getInvoiceNo()))) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        Invoice invoice = new Invoice();
        BeanUtils.copyProperties(model, invoice);
        invoice.setTotalAmount(new BigDecimal(model.getTotalAmount()));
        invoice.setCreateUserId(getLoginUserId());
        invoiceMapper.insertSelective(invoice);
        Map<String,Object> result = new HashMap<>(8);
        result.put("formId",invoice.getId());
        result.put("formNo",invoice.getInvoiceNo());
        result.put("formType",CommonEnum.FormType.INVOICE_TYPE.code);
        return ResultBean.success(result);
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
        Invoice invoice = new Invoice();
        BeanUtils.copyProperties(model, invoice);
        invoice.setTotalAmount(new BigDecimal(model.getTotalAmount()));
        int update = invoiceMapper.updateByPrimaryKeySelective(invoice);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean updateInvoiceNo(Integer id, String invoiceNo) {
        Invoice invoice = new Invoice();
        invoice.setInvoiceNo(invoiceNo);
        invoice.setId(id);
        invoiceMapper.updateByPrimaryKeySelective(invoice);
        return ResultBean.success(1);
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
