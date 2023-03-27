package com.deepsoft.haolifa.service.impl.finance;

import com.deepsoft.haolifa.dao.repository.PurchaseOrderMapper;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.sum.ProcurementSummaryRSDTO;
import com.deepsoft.haolifa.model.dto.finance.sum.SaleSummaryRQDTO;
import com.deepsoft.haolifa.model.dto.finance.sum.SaleSummaryRSDTO;
import com.deepsoft.haolifa.model.dto.finance.sum.SummaryRQDTO;
import com.deepsoft.haolifa.service.finance.SumService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SumServiceImpl implements SumService {


    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;


    @Override
    public ResultBean<PageDTO<ProcurementSummaryRSDTO>> selectProcurementSummary(SummaryRQDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }

        Page<ProcurementSummaryRSDTO> purchaseOrderList = PageHelper.startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> purchaseOrderMapper.selectProcurementSummary(model));
        List<ProcurementSummaryRSDTO> purchaseOrderRSDTOList = purchaseOrderList.getResult().stream()
            .map(purchaseOrder -> {
                ProcurementSummaryRSDTO purchaseOrderRSDTO = new ProcurementSummaryRSDTO();
                BeanUtils.copyProperties(purchaseOrder, purchaseOrderRSDTO);
                // -- 入账欠款(入账额-已付款)
                //        round(c.entryAmount - c.paidAmount, 2) entryOweAmount,
                //        -- 回票欠款(回票额-已付款）
                //        round(0 - c.paidAmount, 2) needInvoiceAmount,
                //        -- 入账欠票（入账额-已开票）
                //        round(c.entryAmount - c.invoicedAmount, 2) entryOweInvoiceAmount
                //
                purchaseOrderRSDTO.setEntryOweAmount(purchaseOrder.getEntryAmount()-purchaseOrder.getPaidAmount());
                purchaseOrderRSDTO.setNeedInvoiceAmount(0.0-purchaseOrder.getPaidAmount());
                purchaseOrderRSDTO.setEntryOweInvoiceAmount(purchaseOrder.getEntryAmount()-purchaseOrder.getInvoicedAmount());
                return purchaseOrderRSDTO;
            })
            .collect(Collectors.toList());

        PageDTO<ProcurementSummaryRSDTO> purchaseOrderPageDTO = new PageDTO<>();
        BeanUtils.copyProperties(purchaseOrderList, purchaseOrderPageDTO);
        purchaseOrderPageDTO.setList(purchaseOrderRSDTOList);
        return ResultBean.success(purchaseOrderPageDTO);
    }

    @Override
    public ResultBean<PageDTO<SaleSummaryRSDTO>> selectSaleContractSummary(SaleSummaryRQDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }

        Page<SaleSummaryRSDTO> purchaseOrderList = PageHelper.startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> purchaseOrderMapper.selectSaleContractSummary(model));
        List<SaleSummaryRSDTO> purchaseOrderRSDTOList = purchaseOrderList.getResult().stream()
            .map(purchaseOrder -> {
                SaleSummaryRSDTO purchaseOrderRSDTO = new SaleSummaryRSDTO();
                BeanUtils.copyProperties(purchaseOrder, purchaseOrderRSDTO);
                purchaseOrderRSDTO.setDeliveryNeedCollectAmount(purchaseOrder.getDeliveryAmount()-purchaseOrder.getCollectedAmount());
                purchaseOrderRSDTO.setInvoiceNeedCollectAmount(purchaseOrder.getInvoicedAmount()-purchaseOrder.getCollectedAmount());
                purchaseOrderRSDTO.setNeedInvoiceAmount(purchaseOrder.getDeliveryAmount()-purchaseOrder.getInvoicedAmount());
                return purchaseOrderRSDTO;
            })
            .collect(Collectors.toList());

        PageDTO<SaleSummaryRSDTO> purchaseOrderPageDTO = new PageDTO<>();
        BeanUtils.copyProperties(purchaseOrderList, purchaseOrderPageDTO);
        purchaseOrderPageDTO.setList(purchaseOrderRSDTOList);
        return ResultBean.success(purchaseOrderPageDTO);
    }
}
