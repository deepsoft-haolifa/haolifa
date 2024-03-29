package com.deepsoft.haolifa.service.finance;

import com.deepsoft.haolifa.model.domain.BizSubjects;
import com.deepsoft.haolifa.model.domain.BizSubjectsBalance;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.subjects.BizSubjectsAddDTO;
import com.deepsoft.haolifa.model.dto.finance.subjects.BizSubjectsRQDTO;
import com.deepsoft.haolifa.model.dto.finance.subjects.BizSubjectsRSDTO;
import com.deepsoft.haolifa.model.dto.finance.subjectsbalance.BizSubjectsBalanceAddDTO;
import com.deepsoft.haolifa.model.dto.finance.subjectsbalance.BizSubjectsBalanceRQDTO;
import com.deepsoft.haolifa.model.dto.finance.subjectsbalance.BizSubjectsBalanceRSDTO;
import com.deepsoft.haolifa.model.dto.finance.subjectsbalance.BizSubjectsBalanceUpDTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SubjectBalanceService {


    /**
     * 添加余额
     * @param
     * @return
     */
    public void increaseAmountBatch( BigDecimal amount) ;


    public void decreaseAmountBatch( BigDecimal amount) ;

    /**
     * 添加余额
     * @param
     * @return
     */
    public ResultBean increaseAmount(BizSubjectsBalanceUpDTO bizSubjects) ;

    /**
     * 减少余额
     * @param
     * @return
     */
    public ResultBean decreaseAmount(BizSubjectsBalanceUpDTO bizSubjects) ;
    /**
     * 获取详情
     * @param
     * @return
     */
    public ResultBean<BizSubjectsBalanceRSDTO> getInfo(Integer deptId,Integer subjectsId) ;

    public Map<String, BigDecimal> getSubjectsBalanceAll();
    /**
     * 获取列表
     * @param model
     * @return
     */
    ResultBean<PageDTO<BizSubjectsBalanceRSDTO>> getList(BizSubjectsBalanceRQDTO model);

    ResultBean<List<BizSubjectsBalanceRSDTO>> getSubjectsListAll();

    ResultBean<BizSubjectsBalanceRSDTO> getCurUserSubjectsBalance(Integer subjectId);
}
