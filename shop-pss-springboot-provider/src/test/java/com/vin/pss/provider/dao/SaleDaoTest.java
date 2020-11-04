package com.vin.pss.provider.dao;

import com.vin.pss.provider.model.Sale;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SaleDaoTest {

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
        Sale sale = new Sale();
        sale.setProductBarCode("6936983800011");
        sale.setSalePrice(BigDecimal.valueOf(100));
        sale.setSaleCount(200);
        sale.setSaleAmount(BigDecimal.valueOf(100).multiply(BigDecimal.valueOf(200)));
        sale.setSaleDate(new Date());
        saleDao.insert(sale);
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
        List<Sale> sales = saleDao.selectAll();
        for (Sale sale : sales) {
            System.out.println(sale);
        }
    }

    @Test
    public void selectByProductName() {
        List<Sale> sales = saleDao.selectByProductName("完美");
        for (Sale sale : sales) {
            System.out.println(sale);
        }
    }

    @Autowired
    SaleDao saleDao;
}
