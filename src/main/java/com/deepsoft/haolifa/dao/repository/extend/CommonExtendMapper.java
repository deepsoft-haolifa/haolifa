package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.dto.InspectItemSumDto;
import com.deepsoft.haolifa.model.vo.PreOutMaterialPageVo;
import com.deepsoft.haolifa.model.vo.PreOutMaterialVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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
    @Select("SELECT IFNULL(sum(delivery_number),0) as deliveryNumber, IFNULL(sum(unqualified_number),0) as unqualifiedNumber from `inspect_item` a where a.purchase_no=#{purchaseNo} and a.material_graph_no=#{graphNo}")
    InspectItemSumDto sumDeliveryInspectItem(@Param("purchaseNo") String purchaseNo, @Param("graphNo") String graphNo);



}
