package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.dto.InspectItemSumDto;
import com.deepsoft.haolifa.model.vo.DataRepairVO;
import com.deepsoft.haolifa.model.vo.InspectItemQtyVo;
import com.deepsoft.haolifa.model.vo.PreOutMaterialPageVo;
import com.deepsoft.haolifa.model.vo.PreOutMaterialVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 通用Mapper
 *
 * @author murphy.he
 **/
public interface CommonExtendMapper {

    /**
     * 查询零件待出库列表
     *
     * @param vo
     * @return
     */
    List<PreOutMaterialVo> pagePreOutMaterial(PreOutMaterialPageVo vo);


    /**
     * 查询零件送检的总数
     */
    @Select("SELECT IFNULL(sum(delivery_number),0) as deliveryNumber, IFNULL(sum(unqualified_number),0) as unqualifiedNumber from `inspect_item` a where a.purchase_no=#{purchaseNo} and a.material_graph_no=#{graphNo} and a.specification=#{specification}")
    InspectItemSumDto sumDeliveryInspectItem(@Param("purchaseNo") String purchaseNo, @Param("graphNo") String graphNo, @Param("specification") String specification);

    /**
     * 根据采购订单号，分组查询送检数，检验合格数，检验不合格数
     */
    List<InspectItemQtyVo> inspectItemQty(@Param("purchaseNo") String purchaseNo);

    @Select("select graph_no graphNo,sumqty-clq qty from (select  graph_no,current_quantity+lock_quantity clq from material )a,(select material_graph_no ,sum(quantity) sumqty from stock where type=2 and quantity>0 and is_delete=0 group by material_graph_no)b where a.graph_no=b.material_graph_no and clq!=sumqty")
    List<DataRepairVO> checkStock();

}
