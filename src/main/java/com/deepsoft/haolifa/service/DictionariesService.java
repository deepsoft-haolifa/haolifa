package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;

public interface DictionariesService {
    /**
     * 获取人员类型
     * @return
     */
    ResultBean getUserType();

    /**
     * 工种类别
     * @return
     */
    ResultBean getTypeOfWorkEnum();


    }
