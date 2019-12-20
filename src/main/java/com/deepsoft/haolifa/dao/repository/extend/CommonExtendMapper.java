package com.deepsoft.haolifa.dao.repository.extend;

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
    @Select("SELECT IFNULL(sum(delivery_number),0)  from `inspect_item` where purchase_no=#{purchaseNo} and material_graph_no=#{graphNo}")
    int sumDeliveryInspectItem(@Param("purchaseNo") String purchaseNo, @Param("graphNo") String graphNo);
}
