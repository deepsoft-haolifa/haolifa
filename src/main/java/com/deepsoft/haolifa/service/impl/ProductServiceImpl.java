package com.deepsoft.haolifa.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.ProductMapper;
import com.deepsoft.haolifa.dao.repository.ProductMaterialMapper;
import com.deepsoft.haolifa.dao.repository.ProductStockLogMapper;
import com.deepsoft.haolifa.dao.repository.extend.ProductMaterialExtendMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.model.dto.product.OutProductDTO;
import com.deepsoft.haolifa.model.dto.product.ProductConditionDTO;
import com.deepsoft.haolifa.model.dto.product.ProductMaterialDTO;
import com.deepsoft.haolifa.model.dto.product.ProductRequestDTO;
import com.deepsoft.haolifa.service.MaterialService;
import com.deepsoft.haolifa.service.ProductMaterialService;
import com.deepsoft.haolifa.service.ProductService;
import com.deepsoft.haolifa.service.SysUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductStockLogMapper productStockLogMapper;
    @Autowired
    private ProductMaterialMapper productMaterialMapper;
    @Autowired
    private SysUserService sysUserService;

    @Override
    @Transactional
    public ResultBean saveInfo(ProductRequestDTO model) {
        String productNo = model.getProductNo();
//        boolean existProductNo = judgeProductNo(productNo, 0);
//        log.info("saveInfo existProductNo productNo:{},result:{}", productNo, existProductNo);
//        if (existProductNo) {
//            return ResultBean.error(CommonEnum.ResponseEnum.PRODUCT_NO_EXISTS);
//        }
        CustomUser customUser = sysUserService.selectLoginUser();
        int createUser = customUser != null ? customUser.getId() : 1;
        Product product = new Product();
        BeanUtils.copyProperties(model, product);
        product.setCreateUser(createUser);
        int insert = productMapper.insertSelective(product);
        if (insert > 0) {

        }
        return ResultBean.success(insert);
    }

    @Override
    @Transactional
    public ResultBean updateInfo(ProductRequestDTO model) {
        if (model.getId() == 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        String productNo = model.getProductNo();
//        // 判断是否存在成品号
//        boolean existProductNo = judgeProductNo(productNo, model.getId());
//        log.info("saveInfo existProductNo productNo:{},result:{}", productNo, existProductNo);
//        if (existProductNo) {
//            return ResultBean.error(CommonEnum.ResponseEnum.PRODUCT_NO_EXISTS);
//        }
//        // 判断是否更改了成品号
//        Product productOrigin = productMapper.selectByPrimaryKey(model.getId());
//        if (null == productOrigin) {
//            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
//        }
//        // 获取更新前的成品号
//        String productNoOrigin = productOrigin.getProductNo();


        Product product = new Product();
        BeanUtils.copyProperties(model, product);
        product.setUpdateTime(new Date());
        CustomUser customUser = sysUserService.selectLoginUser();
        int updateUser = customUser != null ? customUser.getId() : 1;
        product.setUpdateUser(updateUser);
        int update = productMapper.updateByPrimaryKeySelective(product);

        ProductMaterialExample example = new ProductMaterialExample();
        example.or().andProductNoEqualTo(productNo);
        productMaterialMapper.deleteByExample(example);
        // 批量增加成品零件配置
//        List<ProductMaterialDTO> productMaterialList = model.getProductMaterialList();
//        if (null != productMaterialList && productMaterialList.size() > 0) {
//            List<ProductMaterial> list = new ArrayList<>();
//            productMaterialList.forEach(e -> {
//                ProductMaterial productMaterial = new ProductMaterial() {{
//                    setProductNo(productNo);
//                    setProductModel(model.getProductModel());
//                    setSpecification(model.getSpecifications());
//                    setCreateUser(updateUser);
//                    setMaterialGraphNo(e.getMaterialGraphNo());
//                    setMaterialCount(e.getMaterialCount());
//                    if (StringUtils.isNotBlank(e.getReplaceMaterialGraphNo())) {
//                        setReplaceMaterialGraphNos(e.getReplaceMaterialGraphNo());
//                    } else {
//                        setReplaceMaterialGraphNos("");
//                    }
//                }};
//                list.add(productMaterial);
//            });
//            productMaterialExtendMapper.insertBatch(list);
//        }
        return ResultBean.success(update);
    }

    @Override
    @Transactional
    public ResultBean delete(int id, String productNo) {
        if (id == 0 || StringUtils.isBlank(productNo)) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        int delete = productMapper.deleteByPrimaryKey(id);
//        // 删除成功产品后，将管理的零件也删除了
//        ProductMaterialExample example = new ProductMaterialExample();
//        example.or().andProductNoEqualTo(productNo);
//        productMaterialMapper.deleteByExample(example);
        return ResultBean.success(delete);
    }

    @Override
    public Product getInfo(int id) {
        if (id == 0) {
            return null;
        }
        Product product = productMapper.selectByPrimaryKey(id);
        return product;
    }

    @Override
    public Product getInfoByNo(String productNo) {
        if (StringUtils.isBlank(productNo)) {
            return null;
        }
        ProductExample example = new ProductExample();
        example.or().andProductNoEqualTo(productNo);
        List<Product> products = productMapper.selectByExample(example);
        if (products.size() > 0) {
            return products.get(0);
        }
        return null;
    }

    @Override
    public ProductRequestDTO getProductAllInfo(int id) {
        ProductRequestDTO productRequestDTO = new ProductRequestDTO();
        if (id == 0) {
            return null;
        }
        Product product = productMapper.selectByPrimaryKey(id);
        if (product == null) {
            return null;
        }
        BeanUtils.copyProperties(product, productRequestDTO);
//        // 根据产品no 查询管理的零件列表
//        List<ProductMaterial> productMaterials = productMaterialService.getMaterialListByNo(product.getProductNo());
//        List<ProductMaterialDTO> productMaterialDTOList = new ArrayList<>();
//        productMaterials.forEach(e -> {
//            ProductMaterialDTO productMaterialDTO = new ProductMaterialDTO() {{
//                Material infoByGraphNo = materialService.getInfoByGraphNo(e.getMaterialGraphNo());
//                int classifyId = 0;
//                if (infoByGraphNo == null) {
//                    log.error("根据零件图号获取零件信息为空");
//                } else {
//                    classifyId = infoByGraphNo.getMaterialClassifyId();
//                }
//                setMaterialClassifyId(classifyId);
//                setMaterialCount(e.getMaterialCount());
//                setMaterialGraphNo(e.getMaterialGraphNo());
//                setReplaceMaterialGraphNo(e.getReplaceMaterialGraphNos());
//            }};
//            productMaterialDTOList.add(productMaterialDTO);
//        });
        return productRequestDTO;
    }

    @Override
    public ResultBean<PageDTO<Product>> pageInfo(ProductConditionDTO model) {
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(model.getName())) {
            criteria.andNameLike("%" + model.getName() + "%");
        }
        if (StringUtils.isNotBlank(model.getProductNo())) {
            criteria.andProductNoLike("%" + model.getProductNo() + "%");
        }
        if (StringUtils.isNotBlank(model.getProductModel())) {
            criteria.andProductModelLike("%" + model.getProductModel() + "%");
        }
        if (StringUtils.isNotBlank(model.getSpecifications())) {
            criteria.andSpecificationsLike("%" + model.getSpecifications() + "%");
        }
        example.setOrderByClause("id desc");
        Page<Product> products = PageHelper.startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> productMapper.selectByExample(example));

        PageDTO<Product> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(products, pageDTO);
        pageDTO.setList(products);
        return ResultBean.success(pageDTO);
    }

    @Override
    public boolean addOrUpdateProduct(ProductRequestDTO model) {
        String productNo = model.getProductNo();
        String specifications = model.getSpecifications();
        String productModel = model.getProductModel();
        CustomUser customUser = sysUserService.selectLoginUser();
        int createUser = customUser != null ? customUser.getId() : 0;
        // 通过这三个判断，是否有记录
        ProductExample example = new ProductExample();
        example.or().andProductNoEqualTo(productNo)
            .andProductModelEqualTo(productModel)
            .andSpecificationsEqualTo(specifications);
        List<Product> productList = productMapper.selectByExample(example);
        int operate = 0;
        if (CollectionUtil.isNotEmpty(productList)) {
            if (productList.size() == 1) {
                Product product = productList.get(0);
                Product updateProduct = new Product();
                updateProduct.setQty(product.getQty() + model.getQty());
                updateProduct.setId(product.getId());
                updateProduct.setUpdateUser(createUser);
                operate = productMapper.updateByPrimaryKeySelective(updateProduct);
            } else {
                log.error("add or update product record error,size more than 1");
                return false;
            }

        } else {
            Product product = new Product();
            BeanUtil.copyProperties(model, product);
            product.setCreateUser(createUser);
            operate = productMapper.insertSelective(product);
        }
        if (operate > 0) {
            // 添加成品库存日志记录
            ProductStockLog productStockLog = new ProductStockLog();
            BeanUtil.copyProperties(model, productStockLog);
            productStockLog.setCreateUser(createUser);
            productStockLogMapper.insertSelective(productStockLog);
            return true;
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean outProduct(OutProductDTO model) {
        CustomUser customUser = sysUserService.selectLoginUser();
        int createUser = customUser != null ? customUser.getId() : 0;
        Integer id = model.getId();
        Integer qty = model.getQty();
        int reduceQty = Math.abs(qty);
        Product product = productMapper.selectByPrimaryKey(id);
        int resultQty = product.getQty() - reduceQty;
        if (resultQty < 0) {
            throw new BaseException(CommonEnum.ResponseEnum.PRODUCT_COUNT_ERROR);
        }
        Product updateProduct = new Product();
        updateProduct.setId(id);
        updateProduct.setQty(resultQty);
        int update = productMapper.updateByPrimaryKeySelective(updateProduct);
        if (update > 0) {
            // 添加成品库存日志记录
            ProductStockLog productStockLog = new ProductStockLog();
            BeanUtil.copyProperties(product, productStockLog);
            productStockLog.setQty(-reduceQty);
            productStockLog.setCreateUser(createUser);
            productStockLogMapper.insertSelective(productStockLog);
            return true;
        }
        return false;
    }


    /**
     * 判断是否有相同的图号
     *
     * @param productNo
     * @return
     */
    private boolean judgeProductNo(String productNo, int id) {
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andProductNoEqualTo(productNo);
        List<Product> productList = productMapper.selectByExample(example);
        if (productList.size() > 0) {
            // 更新的时候传id，如果查出来的id和传过来的id相同，则返回false
            if (id > 0) {
                Product product = productList.get(0);
                if (product.getId() == id) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
