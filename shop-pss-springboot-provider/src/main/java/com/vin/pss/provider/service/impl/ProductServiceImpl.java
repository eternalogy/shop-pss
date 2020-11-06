package com.vin.pss.provider.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vin.pss.provider.dao.ProductDao;
import com.vin.pss.provider.model.Product;
import com.vin.pss.provider.service.ProductService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description 商品Service实现类
 * @Author Vincent Chiu
 * @Date 2020-10-21 15:19
 */
@DubboService
@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public PageInfo<Product> getAll(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Product> products = productDao.selectAll();
        return new PageInfo<>(products);
    }

    @Override
    public Integer modifyProductByProductId(Product product) {
        return productDao.updateByPrimaryKey(product);
    }

    @Override
    public PageInfo<Product> getProductsByProductName(String productName, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Product> products = productDao.selectByProductName(productName);
        return new PageInfo<>(products);
    }

    @Override
    public Integer logicDeleteProductByBarCode(String barCode) {
        return productDao.logicDeleteByBarCode(barCode);
    }

    @Override
    public Product getProductByBarCode(String barCode) {
        return productDao.selectProductByBarCode(barCode);
    }

    @Autowired
    private ProductDao productDao;
}
