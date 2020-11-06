package com.vin.pss.provider.service;

import com.vin.pss.provider.dao.ProductDao;
import com.vin.pss.provider.dao.PurchaseDao;
import com.vin.pss.provider.model.Product;
import com.vin.pss.provider.model.Purchase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PurchaseServiceTest {

    @Test
    public void getAll() {
    }

    @Test
    public void getPurchasesByProductName() {
    }

    @Test
    public void addPurchase() {
    }

    @Test
    public void purchase() {
        Purchase purchase = new Purchase();
        purchase.setProductId(productDao.selectProductByBarCode("6936983800013").getId());
        purchase.setPurchaseDate(new Date());
        purchase.setProDate(new Date());
        purchase.setExpDate(new Date());
        purchase.setPurchaseCount(10);
        purchase.setPurchasePrice(BigDecimal.valueOf(100));
        purchase.setPurchaseAmount(BigDecimal.valueOf(1000));
        purchase.setReceiptImg("www.baidu.com");

        Product product = new Product();
        product.setBarCode("6936983800013");
        product.setProductName("佳宝特浓纯牛奶223ml/袋");
        product.setSupplierId(1);
        product.setCategoryId(2);
        product.setSalePrice(BigDecimal.valueOf(20));
        purchaseService.purchase(purchase,product);
    }

    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private ProductDao productDao;
}
