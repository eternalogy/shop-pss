package com.vin.pss.provider.service;

import com.github.pagehelper.PageInfo;
import com.vin.pss.provider.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Test
    public void getAll() {
        PageInfo<Product> all = productService.getAll(1, 10);
        System.out.println(all);
    }

    @Test
    public void modifyProductByProductId() {
        Product product = new Product();
        product.setId(22);
        product.setBarCode("12121212");
        product.setSupplierId(1);
        product.setCategoryId(2);
        product.setProductName("232323");
        product.setSalePrice(BigDecimal.valueOf(233.2));
        productService.modifyProductByProductId(product);
    }

    @Test
    public void getProductsByProductName() {
        PageInfo<Product> products = productService.getProductsByProductName("完美", 1, 10);
        System.out.println(products);
    }

    @Test
    public void logicDeleteProductByBarCode() {
        productService.logicDeleteProductByBarCode("12121212");
    }

    @Autowired
    private ProductService productService;
}
