package com.deepsoft.haolifa.dao.repository.extend;


import com.deepsoft.haolifa.model.dto.ApplyBuyListDTO;
import java.util.List;
import java.util.Map;

public interface ApplyBuyExtendMapper {

    /**
     * 分组查询
     *
     * @param model
     * @return
     */
    List<Map<String, Object>> selectByGroup(ApplyBuyListDTO model);
}