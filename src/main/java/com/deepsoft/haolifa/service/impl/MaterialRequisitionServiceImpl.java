//package com.deepsoft.haolifa.service.impl;
//
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.deepsoft.haolifa.constant.CommonEnum;
//import com.deepsoft.haolifa.dao.mapper.MaterialRequisitionMapper;
//import com.deepsoft.haolifa.model.domain.MaterialRequisition;
//import com.deepsoft.haolifa.model.dto.BaseException;
//import com.deepsoft.haolifa.model.vo.PreOutMaterialPageVo;
//import com.deepsoft.haolifa.model.vo.PreOutMaterialVo;
//import com.deepsoft.haolifa.service.MaterialRequisitionService;
//import com.deepsoft.haolifa.service.MaterialService;
//import com.deepsoft.haolifa.util.RandomUtils;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.List;
//
///**
// * <p>
// * 领料单表 服务实现类
// * </p>
// *
// * @author murphy.he
// * @since 2019-11-23
// */
//@Service
//public class MaterialRequisitionServiceImpl extends ServiceImpl<MaterialRequisitionMapper, MaterialRequisition> implements MaterialRequisitionService {
//
//    @Resource
//    private MaterialService materialService;
//
//    @Resource
//    private MaterialRequisitionMapper materialRequisitionMapper;
//
//    @Override
//    public boolean addBatch(List<MaterialRequisition> list) {
//        // 判断图号是否在图号库中
//        for (MaterialRequisition materialRequisition : list) {
//            materialRequisition.setRequisitionNo("ll_" + RandomUtils.orderNoStr());
//            String graphNo = materialRequisition.getGraphNo();
//            boolean existsGraphNo = materialService.existsGraphNo(graphNo);
//            if (!existsGraphNo) {
//                throw new BaseException(CommonEnum.ResponseEnum.MATERIAL_GRAPH_NO_NOT_EXIST_1, (Object) graphNo);
//            }
//        }
//        return this.saveBatch(list);
//    }
//
//    @Override
//    public IPage<PreOutMaterialVo> preOutMaterialPage(PreOutMaterialPageVo vo) {
//        materialRequisitionMapper.pagePreOutMaterial(vo);
//        return null;
//    }
//
//
//}
