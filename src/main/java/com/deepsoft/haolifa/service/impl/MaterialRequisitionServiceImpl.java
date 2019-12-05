package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.MaterialRequisitionMapper;
import com.deepsoft.haolifa.dao.repository.extend.CommonExtendMapper;
import com.deepsoft.haolifa.model.domain.InspectHistory;
import com.deepsoft.haolifa.model.domain.MaterialRequisition;
import com.deepsoft.haolifa.model.domain.MaterialRequisitionExample;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.vo.PreOutMaterialPageVo;
import com.deepsoft.haolifa.model.vo.PreOutMaterialVo;
import com.deepsoft.haolifa.service.MaterialRequisitionService;
import com.deepsoft.haolifa.service.MaterialService;
import com.deepsoft.haolifa.service.OrderProductService;
import com.deepsoft.haolifa.util.RandomUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 领料单表 服务实现类
 * </p>
 *
 * @author murphy.he
 * @since 2019-11-23
 */
@Service
public class MaterialRequisitionServiceImpl implements MaterialRequisitionService {

    @Resource
    private MaterialService materialService;
    @Resource
    private OrderProductService orderProductService;
    @Resource
    private MaterialRequisitionMapper materialRequisitionMapper;

    @Resource
    private CommonExtendMapper commonExtendMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addBatch(List<MaterialRequisition> list) {
        // 判断图号是否在图号库中
        String orderNo = "";
        for (MaterialRequisition materialRequisition : list) {
            orderNo = materialRequisition.getOrderNo();
            String graphNo = materialRequisition.getGraphNo();
            boolean existsGraphNo = materialService.existsGraphNo(graphNo);
            if (!existsGraphNo) {
                throw new BaseException(CommonEnum.ResponseEnum.MATERIAL_GRAPH_NO_NOT_EXIST_1, (Object) graphNo);
            }
        }
        // 判断是否已经保存过领料单
        MaterialRequisitionExample materialRequisitionExample = new MaterialRequisitionExample();
        materialRequisitionExample.or().andOrderNoEqualTo(orderNo);
        int count = materialRequisitionMapper.countByExample(materialRequisitionExample);
        if (count > 0) {
            throw new BaseException(CommonEnum.ResponseEnum.MATERIAL_REQUISITION_EXIST);
        }

        for (MaterialRequisition materialRequisition : list) {
            materialRequisition.setRequisitionNo("ll_" + RandomUtils.orderNoStr());
            materialRequisition.setOutRoomStatus(CommonEnum.OutRoomStatus.NOT_OUT.type);
            materialRequisitionMapper.insertSelective(materialRequisition);
        }

        // 将订单的 是否生成领料单状态修改
        orderProductService.updateGenPickList(orderNo, CommonEnum.Consts.YES.code);

        return true;
    }

    @Override
    public List<MaterialRequisition> detailList(String orderNo) {
        MaterialRequisitionExample example = new MaterialRequisitionExample();
        example.or().andOrderNoEqualTo(orderNo);
        List<MaterialRequisition> materialRequisitions = materialRequisitionMapper.selectByExample(example);
        return materialRequisitions;
    }

    @Override
    public PageDTO<PreOutMaterialVo> preOutMaterialPage(PreOutMaterialPageVo vo) {
        Page<PreOutMaterialVo> preOutMaterialVos = PageHelper.startPage(vo.getPageNum(), vo.getPageSize())
            .doSelectPage(() -> commonExtendMapper.pagePreOutMaterial(vo));

        PageDTO<PreOutMaterialVo> pageDTO = new PageDTO();
        BeanUtils.copyProperties(preOutMaterialVos, pageDTO);
        pageDTO.setList(preOutMaterialVos);
        return pageDTO;
    }


}
