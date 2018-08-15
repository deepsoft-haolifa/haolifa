package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.ProductPurchaseRecord;
import com.deepsoft.haolifa.model.domain.ProductPurchaseRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductPurchaseRecordMapper {
    long countByExample(ProductPurchaseRecordExample example);

    int deleteByExample(ProductPurchaseRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductPurchaseRecord record);

    int insertSelective(ProductPurchaseRecord record);

    List<ProductPurchaseRecord> selectByExample(ProductPurchaseRecordExample example);

    ProductPurchaseRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductPurchaseRecord record, @Param("example") ProductPurchaseRecordExample example);

    int updateByExample(@Param("record") ProductPurchaseRecord record, @Param("example") ProductPurchaseRecordExample example);

    int updateByPrimaryKeySelective(ProductPurchaseRecord record);

    int updateByPrimaryKey(ProductPurchaseRecord record);

    /**
     * 批量插入采购记录
     * @param productPurchaseRecordList
     */
    void insertProductPurchaseRecordBatch(List<ProductPurchaseRecord> productPurchaseRecordList);
}