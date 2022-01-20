package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.PayWagesSearchMapper;
import com.deepsoft.haolifa.model.domain.PayWagesSearch;
import com.deepsoft.haolifa.model.domain.PayWagesSearchExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.request.PayWagesSearchReqVO;
import com.deepsoft.haolifa.model.dto.pay.response.PayWagesSearchResVO;
import com.deepsoft.haolifa.service.PayWagesSearchService;
import com.deepsoft.haolifa.util.BeanCopyUtils;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author liuyaofei
 * @Date create in 下午4:51 2021/9/11
 * @description 考核指标
 */
@Service
@Slf4j
public class PayWagesSearchServiceImpl extends BaseService implements PayWagesSearchService {
    @Resource
    private PayWagesSearchMapper payWagesSearchMapper;

    @Override
    public ResultBean pageInfo(PayWagesSearchReqVO payWagesSearchReqVO) {
        PayWagesSearchExample example = new PayWagesSearchExample();
        PayWagesSearchExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(payWagesSearchReqVO.getDepartment())) {
            criteria.andDepartmentLike("%" + payWagesSearchReqVO.getDepartment() + "%");
        }
        if (StringUtils.isNotBlank(payWagesSearchReqVO.getUserName())) {
            criteria.andUserNameLike("%" + payWagesSearchReqVO.getUserName() + "%");
        }
        if (StringUtils.isNotEmpty(payWagesSearchReqVO.getWagesMonth())) {
            criteria.andWagesMonthEqualTo(payWagesSearchReqVO.getWagesMonth());
        }
        if (StringUtils.isNotEmpty(payWagesSearchReqVO.getWagesYear())) {
            criteria.andWagesYearEqualTo(payWagesSearchReqVO.getWagesYear());
        }
        example.setOrderByClause("id desc");
        Page<PayWagesSearch> payWagesSearches = PageHelper.startPage(payWagesSearchReqVO.getPageNum(), payWagesSearchReqVO.getPageSize())
            .doSelectPage(() -> payWagesSearchMapper.selectByExample(example));
        PageDTO<PayWagesSearchResVO> pageDTO = new PageDTO<>();
        List<PayWagesSearchResVO> payWagesSearchResVOList = BeanCopyUtils.copyPropertiesForNewList(payWagesSearches, () -> new PayWagesSearchResVO());
        pageDTO.setList(payWagesSearchResVOList);
        return ResultBean.success(pageDTO);
    }

}
