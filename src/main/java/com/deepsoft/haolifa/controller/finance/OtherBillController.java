package com.deepsoft.haolifa.controller.finance;


import cn.hutool.core.util.ObjectUtil;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.domain.BizOtherBill;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.otherbill.BizOtherBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.otherbill.BizOtherBillDTO;
import com.deepsoft.haolifa.model.dto.finance.otherbill.BizOtherBillRSDTO;
import com.deepsoft.haolifa.model.dto.finance.otherbill.BizOtherBillUpDTO;
import com.deepsoft.haolifa.service.finance.OtherBillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 其他货币资金日记账
 */
@RestController
@RequestMapping("/finance/otherbill")
@Api(tags = {"好利财务-其他货币资金日记账管理"})
public class OtherBillController {
    @Autowired
    private OtherBillService otherBillService;


    @ApiOperation("添加节点")
    @PostMapping("/save")
    public ResultBean save(@RequestBody BizOtherBillAddDTO model) {
        if (model.getType().equals("2")) {
            if (StringUtils.isEmpty(model.getProjectCode())) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"项目编号必填");
            }
            if (ObjectUtil.isEmpty(model.getOperateDate())) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"日期必填");
            }
            if (StringUtils.isEmpty(model.getCollectCompany())) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"收款单位必填");
            }
            if (StringUtils.isEmpty(model.getPayWay())) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"付款方式必填");
            }
            if (StringUtils.isEmpty(model.getPayAccount())) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"付款账户必填");
            }
            if (ObjectUtil.isEmpty(model.getSubject())) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"科目必填");
            }
            if (StringUtils.isEmpty(model.getPaymentType())) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"付款类别必填");
            }
            if (null == model.getPayment()) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"付款必填");
            }
        }


        return otherBillService.save(model);
    }

    @ApiOperation("删除节点")
    @GetMapping("/delete/{otherBillId}")
    public ResultBean delete(@PathVariable("otherBillId") int id) {
        return otherBillService.delete(id);
    }

    @ApiOperation("更新节点")
    @PostMapping("/updateOtherBill")
    public ResultBean updateOtherBill(@RequestBody BizOtherBillUpDTO otherBillUpDTO) {
        return otherBillService.update(otherBillUpDTO);
    }

    @ApiOperation("获取节点列表")
    @PostMapping("/getOtherBillList")
    public ResultBean<PageDTO<BizOtherBillRSDTO>> getOtherBillList(@RequestBody BizOtherBillDTO otherBillDTO) {
        return otherBillService.getList(otherBillDTO);
    }


}
