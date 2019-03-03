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
    }
    /**
     * 成品质量检验失败列表
     */
    public static final String INSPECT_UNQUALIFIED_REASON = "扭矩超,尺寸超差,调试不到位,标牌问题,表面处理不到位,铸字问题,砂眼冷隔,打磨不到位,磕碰掉漆,零部件缺陷,安装不到位,外观不良,标牌孔问题,缺少零件或标识,订单错误,投料错误,技术清单错误,违规操作";
    /**
     * 压力质检不合格失败列表
     */
    public static final String PRESSURE_UNQUALIFIED_REASON = "阀门内泄,阀门端径泄露,阀门内圆泄露,阀板漏水";

    /**
     * 订单状态描述
     */
    public static final String ORDER_STATUS_DESC = "0:创建;1:审批中;2:核料中;3.替换料审批中；4.核料完成；5:待生产;6:待领料;7:生产中;8:生产暂停;9:生产完成;10:质检中;11:已入库;12：申请发货；13：已发货;14:审核不通过";

}
