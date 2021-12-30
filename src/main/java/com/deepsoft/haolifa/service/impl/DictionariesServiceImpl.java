package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.vo.DictionariesVo;
import com.deepsoft.haolifa.service.DictionariesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author liuyaofei
 * @Date create in 下午10:46 2021/11/24
 * @description 字典类型
 */
@Service
public class DictionariesServiceImpl implements DictionariesService {
    @Override
    public ResultBean getUserType() {
        List<DictionariesVo> list = new ArrayList<>();
        for (CommonEnum.UserType userType : CommonEnum.UserType.values()) {
            DictionariesVo vo = new DictionariesVo();
            vo.setCode(userType.type);
            vo.setName(userType.name);
            list.add(vo);
        }
        return ResultBean.success(list);
    }

    @Override
    public ResultBean getTypeOfWorkEnum() {
        List<DictionariesVo> list = new ArrayList<>();
        for (CommonEnum.TypeOfWorkEnum type : CommonEnum.TypeOfWorkEnum.values()) {
            DictionariesVo vo = new DictionariesVo();
            vo.setCode(type.code);
            vo.setName(type.name);
            list.add(vo);
        }
        return ResultBean.success(list);
    }


}
