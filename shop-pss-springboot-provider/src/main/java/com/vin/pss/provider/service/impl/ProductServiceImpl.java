package com.vin.pss.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vin.pss.provider.dao.ProductDao;
import com.vin.pss.provider.model.Product;
import com.vin.pss.provider.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author Vincent Chiu
 * @Date 2020-10-21 15:19
 */
@Service
@org.springframework.stereotype.Service
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
