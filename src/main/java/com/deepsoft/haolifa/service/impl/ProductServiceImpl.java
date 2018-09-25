package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.ProductMapper;
import com.deepsoft.haolifa.model.domain.Product;
import com.deepsoft.haolifa.model.domain.ProductExample;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.service.ProductService;
import com.deepsoft.haolifa.service.SysUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private SysUserService sysUserService;

    @Override
    public ResultBean saveInfo(ProductRequestDTO model) {
        String productNo = model.getProductNo();
        boolean existProductNo = judgeProductNo(productNo, 0);
        log.info("saveInfo existProductNo productNo:{},result:{}", productNo, existProductNo);
        if (existProductNo) {
            return ResultBean.error(CommonEnum.ResponseEnum.PRODUCT_NO_EXISTS);
        }
        CustomUser customUser = sysUserService.selectLoginUser();
        int createUser = customUser != null ? customUser.getId() : 1;
        Product product = new Product();
        BeanUtils.copyProperties(model, product);
        product.setCreateUser(createUser);
        int insert = productMapper.insertSelective(product);
        return ResultBean.success(insert);
    }

    @Override
    public ResultBean updateInfo(ProductRequestDTO model) {
        if (model.getId() == 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        String productNo = model.getProductNo();
        boolean existProductNo = judgeProductNo(productNo, model.getId());
        log.info("saveInfo existProductNo productNo:{},result:{}", productNo, existProductNo);
        if (existProductNo) {
            return ResultBean.error(CommonEnum.ResponseEnum.PRODUCT_NO_EXISTS);
        }
        Product product = new Product();
        BeanUtils.copyProperties(model, product);
        product.setUpdateTime(new Date());
        CustomUser customUser = sysUserService.selectLoginUser();
        int updateUser = customUser != null ? customUser.getId() : 1;
        product.setUpdateUser(updateUser);
        int update = productMapper.updateByPrimaryKeySelective(product);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean delete(int id) {
        if (id == 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
//        Product record = new Product() {{
//            setId(id);
//            setIsDelete(CommonEnum.Consts.YES.code);
//        }};
        int delete = productMapper.deleteByPrimaryKey(id);
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
    public ResultBean pageInfo(Integer currentPage, Integer pageSize, String nameLike, String productNoLike) {
        currentPage = currentPage == null ? 1 : currentPage;
        pageSize = pageSize == null ? 20 : pageSize;
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeleteEqualTo(CommonEnum.Consts.NO.code);
        if (StringUtils.isNotBlank(nameLike)) {
            criteria.andNameLike("%" + nameLike + "%");
        }
        if (StringUtils.isNotBlank(productNoLike)) {
            criteria.andProductNoLike("%" + productNoLike + "%");
        }
        example.setOrderByClause("create_time desc");
        Page<Product> products = PageHelper.startPage(currentPage, pageSize)
                .doSelectPage(() -> productMapper.selectByExample(example));

        PageDTO<Product> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(products, pageDTO);
        pageDTO.setList(products);
        return ResultBean.success(pageDTO);
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
