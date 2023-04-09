package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.OrderProductAssociate;
import com.deepsoft.haolifa.model.domain.OrderTechnicalDetailedRel;
import com.deepsoft.haolifa.model.dto.Accessory;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.receivable.ReceivableOrderRQDTO;
import com.deepsoft.haolifa.model.dto.finance.receivable.ReceivableOrderRSDTO;
import com.deepsoft.haolifa.model.dto.order.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

public interface OrderProductService {

    /**
     * 上传订单excel
     */
    ResultBean generateOrder(GenerateOrderDTO generateOrderDTO);

    /**
     * 上传订单excel
     */
    ResultBean uploadOrderProduct(OrderUploadDTO OrderUploadDTO);


    /**
     * 上传多个订单附件文件
     */
    ResultBean uploadOrderFiles(String orderNo, List<OrderUploadDTO> orderUploadDTOs);

    /**
     * 删除订单附件文件
     */
    ResultBean delOrderFiles(int fileId);

    /**
     * 获取订单附件文件列表
     */
    ResultBean getOrderFiles(String orderNo);


    /**
     * 添加order信息 { "orderContractNo": "HX1811001-XXX-H-ST", "orderContractUrl": "http://12dfsadflsd.xls",
     * "orderProductAssociates": [ { "materialDescription": "球铁体，304SS板，EPDM座，2Cr13轴，常温，水，RAL5010高光，配国产220V
     * 普通开关型无源触点电执行器",
     * "productModel": "270D97A1XP-16Q", "productName": "无头蝶阀", "productNumber": 1, "productRemark": "线下执行",
     * "specifications": "DN65" }, { "materialDescription": "球铁体，304SS板，EPDM座，2Cr13轴，常温，水，RAL5010高光，配国产220V
     * 普通开关型无源触点电执行器",
     * "productModel": "270D97A1XP-16Q", "productName": "无头蝶阀", "productNumber": 2, "productRemark": "线下执行",
     * "specifications": "DN100" }, { "materialDescription": "球铁体，304SS板，EPDM座，2Cr13轴，常温，水，RAL5010高光，配国产220V
     * 普通开关型无源触点电执行器",
     * "productModel": "270D37A1XH-16Q", "productName": "蜗轮蝶阀", "productNumber": 5, "productRemark": "线下执行",
     * "specifications": "DN100" } ]
     * <p>
     * }
     */
    ResultBean saveOrderProductInfo(OrderProductDTO order);

    /**
     * 更新订单相关信息
     */
    ResultBean updateOrderInfo(OrderUpdateDTO orderUpdateDTO);

    /**
     * 删除订单信息
     */
    ResultBean deleteOrderInfo(int id);

    /**
     * 修改订单状态
     */
    int updateOrderProductStatus(String orderNo, byte status);

    /**
     * 修改订单的领料单生成状态
     */
    int updateGenPickList(String orderNo, byte status);

    /**
     * 获取订单详情
     */
    OrderProductDTO getOrderProductInfo(String orderNo);

    /**
     * 获取订单产品列表(只包含产品列表)
     */
    List<OrderProductAssociate> getOrderProductList(String orderNo);

    /**
     * 获取订单分页列表
     */
    ResultBean pageOrderProduct(OrderConditionDTO model);

    /**
     * 获取核料订单产品列表(包含需要选择的阀体，阀座等)
     */
    List<ProductCheckMaterialListDTO> getCheckOrderProductList(String orderNo);

    /**
     * 获取 订单列表
     */
    public ResultBean<PageDTO<ReceivableOrderRSDTO>> receivableOrderList(ReceivableOrderRQDTO model);

    ResultBean<BigDecimal> receivableOrderListSummary(ReceivableOrderRQDTO model);

    /**
     * 核料（将前端提交过来的零件，进行核料）
     */
    List<OrderCheckMaterialDTO> checkMaterial(String orderNo,
                                              List<ProductCheckMaterialListDTO> productCheckMaterialListDTOList);

//    /**
//     * 替换料再次核料
//     *
//     * @param orderCheckMaterialDTOS
//     * @return
//     */
//    List<OrderCheckMaterialDTO> checkReplaceMaterial(String orderNo, List<OrderCheckMaterialDTO>
//    orderCheckMaterialDTOS);

    /**
     * 核料成功（下一步）
     */
    int checkPass(List<OrderCheckMaterialDTO> orderCheckMaterialDTOS);

    /**
     * 根据订单号，将核完的料释放
     */
    int releaseMaterial(String orderNo);

    /**
     * 获取订单的零件列表
     */
    List<OrderMaterialDTO> listOrderMaterial(String orderNo);

    /**
     * 根据状态获取订单No列表
     */
    List<String> listOrderNo(String orderStatus);

    /**
     * 根订单No获取替换料列表
     */
    List<OrderMaterialDTO> listReplaceMaterial(String orderNo);

    /**
     * 根据id获取替换料详情
     */
    OrderMaterialDTO infoReplaceMaterial(int id);

    /**
     * 替换料审核完成
     */
    int auditReplaceMaterial(CheckReplaceMaterialAuditDTO model);

    ResultBean updateOrderDeliverStatus(String orderNo, int status, Integer number);

    /**
     * 成品出库，更新订单状态和数量
     */
    void finishedGoodsDelivery(String orderNo);

    ResultBean uploadAccessory(String orderNo, List<Accessory> orderUploadDTOs);

    ResultBean getAccessory(String orderNo);

    ResultBean updateOrderDemand(String orderNo, String demandName);

    /**
     * 根据状态查询订单号列表
     *
     * @param type
     * @param status
     * @param orderNo
     * @return
     */
    ResultBean getOrderNoListByquery(Integer type, Integer status, String orderNo);

    /**
     * 更新生产订单的详情数据（单价+数量）
     * @param model
     */
    int updateAssociateInfo(List<OrderProductAssociateUpdateDTO> model);

    /**
     * 更新生产订单的合同url
     * @param dto
     */
    int updateContractUrl(OrderContractUpdateDTO dto);

    /**
     * 更新生产订单的任务状态
     * @param status
     * @param orderNo
     */
    void updateOrderTaskStatus(String orderNo, int status);


    /**
     * 获取订单的技术清单（核料规则获取）
     * @param dto
     */
    List<OrderTechnicalDetailedRel> getTechnicalDetailed(OrderSimpleDTO dto);

    /**
     * 添加订单的技术清单
     * @param dto
     */
    int addTechnicalDetailed(List<OrderTechnicalDetailedRel> dto);

    /**
     * 删除订单的技术清单
     * @param id
     */
    int delTechnicalDetailed(int id);


}
