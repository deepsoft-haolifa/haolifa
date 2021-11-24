package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.BizSubjects;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.BizSubjectsAddDTO;
import com.deepsoft.haolifa.model.dto.finance.BizSubjectsDTO;

public interface SubjectService {
    /**
     * 添加科目
     * @param model
     * @return
     */
    ResultBean save(BizSubjectsAddDTO model);


    /**
     * 删除科目
     * @param id
     * @return
     */
    ResultBean delete(Integer id);

    /**
     * 更新科目
     * @param model
     * @return
     */
    ResultBean update(BizSubjects model);

    /**
     * 获取详情
     * @param id
     * @return
     */
    ResultBean getInfo(Integer id);

    /**
     * 获取列表
     * @param model
     * @return
     */
    ResultBean getList(BizSubjectsDTO model);

}
