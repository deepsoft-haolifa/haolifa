package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayUserDTO;
import com.deepsoft.haolifa.model.vo.pay.PayUserVO;

import java.util.List;

public interface PayUserService {
    ResultBean pageInfo(PayUserDTO model);

    ResultBean save(PayUserDTO model);

    ResultBean getInfo(Integer userId);

    ResultBean edit(PayUserDTO model);

    ResultBean delete(Integer userId);

    ResultBean saveUserRelationProcedure(Integer userId, List<Integer> procedureId);

    ResultBean getAllList(PayUserVO payUserVO);

    ResultBean getScoreUserList(PayUserDTO model);

    ResultBean syncUser();

}
