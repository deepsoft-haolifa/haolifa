package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.SupplierListDTO;
import com.deepsoft.haolifa.model.dto.SupplierRequestDTO;

public interface SupplierService {

  /**
   * 保存供应商信息
   */
  ResultBean saveInfo(SupplierRequestDTO model);

  /**
   * 更新供应商信息
   */
  ResultBean updateInfo(SupplierRequestDTO model);

  /**
   * 删除供应商
   */
  ResultBean deleteInfo(Integer id);

  /**
   * 获取供应商详情
   */
  ResultBean getInfo(Integer id);

  /**
   * 获取供应商列表
   */
  ResultBean getList(SupplierListDTO model);

  /**
   * 通过名称查询
   * @return
   */
  ResultBean listByName();

  ResultBean approve(String supplierNo);
}
