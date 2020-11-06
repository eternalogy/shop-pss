package com.vin.pss.provider.dao;

import com.vin.pss.provider.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDaoTest {

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void logicDeleteByPrimaryKey() {
        productDao.logicDeleteByPrimaryKey(22);
    }

    @Test
    public void insert() {
        Product product = new Product();
        product.setBarCode("333");
        product.setProductName("测试商品添加");
        product.setSalePrice(BigDecimal.valueOf(22));
        product.setSupplierId(2);
        product.setCategoryId(1);
        productDao.insert(product);
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
        Product product = productDao.selectByPrimaryKey(21);
        System.out.println(product);
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
        Product product = new Product();
        product.setProductName("测试修改");
        product.setSalePrice(BigDecimal.valueOf(11));
        product.setSupplierId(1);
        product.setCategoryId(2);
        product.setId(21);
        product.setBarCode("22222");
        productDao.updateByPrimaryKey(product);
    }

    @Test
    public void selectAll() {
        List<Product> products = productDao.selectAll();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Test
    public void selectByProductName() {
        List<Product> products = productDao.selectByProductName("完美");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Test
    public void selectProductByBarCode() {
        Product product = productDao.selectProductByBarCode("6936983800023");
        System.out.println(product);
    }

    @Test
    public void logicDeleteByBarCode() {
        productDao.logicDeleteByBarCode("22222");
    }

    @Autowired
    private ProductDao productDao;
}
