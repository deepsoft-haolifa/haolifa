package com.deepsoft.haolifa.constant;


/**
 * @description: 常量类
 **/
public class Constant {
    public static final String METHOD_POST = "POST";
    public static final String METHOD_GET = "GET";

    public interface SerialNumberPrefix {
        String INSPECT_NO_PREFIX_BJ = "BJ";
        String BATCH_NUMBER_PREFIX_PC = "PC";
        String SPRAY_NO_PREFIX_PT = "PT";
        String ENTRUST_NO_PREFIX_JJ = "JJ";
        String DELIVERY_NO_PREFIX_FHTZD = "FHTZD";
        String REJECT_MATERIAL_NO_PREFIX_BHG = "BHG";
    }

    public interface PurchaseOrderType {
        int ORDER_TYPE_PURCHASE_0 = 0;
        int ORDER_TYPE_ENTRUST_1 = 1;
    }
    /**
     * 成品质量检验失败列表
     */
    public static final String INSPECT_UNQUALIFIED_REASON = "扭距超,标牌歪或铆钉松动,标牌内容错误,磕碰补漆,砂眼,冷隔,调试不到位,出轴或轴方错误,上法兰孔距错误,侧法兰孔距错误,侧法兰断裂,阀座啃坏,阀座裂口,阀座材质错误,阀座端径安装不到位,阀体材质错误,手柄与齿盘安装不到位,手柄断裂,手柄晃动,出轴晃动,打磨不到位,铸字不清,订单错误,技术清单错误,外观不良,阀门关闭后阀板与阀座有缝隙,流向箭头反,阀板材质错,阀板裂纹,裂纹乱扣,驱动装反,驱动螺丝没拧紧,阀座硫化缺陷,手柄皮塞没安装,螺丝垫片多装或少装,擦拭不干净,卡簧安装不到位,";
    /**
     * 压力质检不合格失败列表
     */
    public static final String PRESSURE_UNQUALIFIED_REASON = "阀门内泄,阀门端径泄露,阀门内圆泄露,阀板漏水";

    /**
     * 订单状态描述
     */
    public static final String ORDER_STATUS_DESC = "0:创建;1:审批中;2:核料中;3.替换料审批中；4.核料完成；5:待生产;6:待领料;7:生产中;8:生产暂停;9:生产完成;10:质检中;11:已入库;12：申请发货；13：已发货;14:审核不通过";

    /**
     * 导出数量限制
     */
    public static final Integer EXPORT_MAX_COUNT = 60000;

    /**
     * 阀体的后三位
     */
    public static final String[] FATI_SUFFIX_CHECK = {"00J", "00B", "001", "002", "003", "004", "005", "007", "010", "011" , "012", "014", "015", "016", "017", "021"};

}
