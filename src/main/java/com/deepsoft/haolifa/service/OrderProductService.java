package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.model.domain.OrderProductAssociate;

import java.util.List;

public interface OrderProductService {
    /**
     * 上传订单excel
     *
     * @param base64Source base64 excel
     * @return
     */
    ResultBean uploadOrderProductExcel(String base64Source);

    /**
     * 添加order信息
     * {
     *   "orderContractNo": "HX1811001-XXX-H-ST",
     *   "orderContractUrl": "http://12dfsadflsd.xls",
     *   "orderProductAssociates": [
     *     {
     *       "materialDescription": "球铁体，304SS板，EPDM座，2Cr13轴，常温，水，RAL5010高光，配国产220V普通开关型无源触点电执行器",
     *       "productModel": "270D97A1XP-16Q",
     *       "productName": "无头蝶阀",
     *       "productNumber": 1,
     *       "productRemark": "线下执行",
     *       "specifications": "DN65"
     *     },
     * {
     *       "materialDescription": "球铁体，304SS板，EPDM座，2Cr13轴，常温，水，RAL5010高光，配国产220V普通开关型无源触点电执行器",
     *       "productModel": "270D97A1XP-16Q",
     *       "productName": "无头蝶阀",
     *       "productNumber": 2,
     *       "productRemark": "线下执行",
     *       "specifications": "DN100"
     *     },
     * {
     *       "materialDescription": "球铁体，304SS板，EPDM座，2Cr13轴，常温，水，RAL5010高光，配国产220V普通开关型无源触点电执行器",
     *       "productModel": "270D37A1XH-16Q",
     *       "productName": "蜗轮蝶阀",
     *       "productNumber": 5,
     *       "productRemark": "线下执行",
     *       "specifications": "DN100"
     *     }
     *   ]
     *
     * }
     *
     * @param order
     * @return
     */
    ResultBean saveOrderProductInfo(OrderProductDTO order);

    /**
     * 更新订单相关信息
     *
     * @param orderUpdateDTO
     * @return
     */
    ResultBean updateOrderInfo(OrderUpdateDTO orderUpdateDTO);

    /**
     * 修改订单状态
     *
     * @param orderNo
     * @param status
     * @return
     */
    int updateOrderProductStatus(String orderNo, byte status);

    /**
     * 获取订单详情
     *
     * @param orderNo
     * @return
     */
    OrderProductDTO getOrderProductInfo(String orderNo);

    /**
     * 获取订单产品列表(只包含产品列表)
     *
     * @param orderNo
     * @return
     */
    List<OrderProductAssociate> getOrderProductList(String orderNo);

    /**
     * 获取订单分页列表
     *
     * @return
     */
    ResultBean pageOrderProduct(Integer currentPage, Integer pageSize, String orderNo, int orderStatus);

    /**
     * 获取核料订单产品列表(包含需要选择的阀体，阀座等)
     *
     * @param orderNo
     * @return
     */
    List<MaterialTypeListDTO> getCheckOrderProductList(String orderNo);

    /**
     * 核料（将前端提交过来的零件，进行核料）
     *
     * @param orderCheckMaterialDTOS
     * @return
     */
    List<OrderCheckMaterialDTO> checkMaterial(List<OrderCheckMaterialDTO> orderCheckMaterialDTOS);

    /**
     * 核料成功（下一步）
     *
     * @param orderCheckMaterialDTOS
     */
    int checkPass(List<OrderCheckMaterialDTO> orderCheckMaterialDTOS);

    /**
     * 根据订单号，将核完的料释放
     *
     * @param orderNo
     * @return
     */
    int releaseMaterial(String orderNo);

    /**
     * 获取订单的零件列表
     *
     * @param orderNo
     */
    List<OrderMaterialDTO> listOrderMaterial(String orderNo);

    /**
     * 生成领料单
     *
     * @param model
     */
    MaterialRequisitionDTO saveMaterialRequisition(MaterialRequisitionDTO model);

    /**
     * 获取领料单详情
     */
    MaterialRequisitionDTO infoMaterialRequisition(String orderNo, String receiveNo);
}
