package com.deepsoft.haolifa.service;


public interface CustomerModelRelationService {

    /**
     * 根据客户代号和型号 获取好利型号
     *
     * @param customerNo
     * @param customerModelNo
     * @return
     */
    String getHaoliGraphNo(String customerNo, String customerModelNo);
}
