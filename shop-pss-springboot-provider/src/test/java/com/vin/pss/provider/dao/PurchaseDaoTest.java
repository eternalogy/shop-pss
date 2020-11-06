package com.vin.pss.provider.dao;

import com.vin.pss.provider.model.Purchase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PurchaseDaoTest {

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
        Purchase purchase = new Purchase();
        purchase.setProductId(15);
        purchase.setPurchaseCount(100);
        purchase.setPurchasePrice(BigDecimal.valueOf(200));
        purchase.setPurchaseAmount(BigDecimal.valueOf(100).multiply(BigDecimal.valueOf(200)));
        purchase.setPurchaseDate(new Date());
        purchase.setExpDate(new Date());
        purchase.setProDate(new Date());
        purchaseDao.insert(purchase);
    }

    @Test
    public void insertSelective() {

    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void selectAll() {
        List<Purchase> purchases = purchaseDao.selectAll();
        for (Purchase purchase : purchases) {
            System.out.println(purchase);
        }
    }

    @Test
    public void selectByProductName() {
        List<Purchase> purchases = purchaseDao.selectByProductName("完美");
        for (Purchase purchase : purchases) {
            System.out.println(purchase);
        }
    }

    @Autowired
    private PurchaseDao purchaseDao;
}
