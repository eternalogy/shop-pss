package com.vin.pss.provider.dao;

import com.vin.pss.provider.model.Stock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StockDaoTest {

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
        Stock stock = new Stock();
        stock.setProductBarCode("6936983800067");
        stock.setStockCount(500);
        stockDao.insert(stock);
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
        List<Stock> stocks = stockDao.selectAll();
        for (Stock stock : stocks) {
            System.out.println(stock);
        }
    }

    @Test
    public void selectByProductName() {
        List<Stock> stocks = stockDao.selectByProductName("完美");
        for (Stock stock : stocks) {
            System.out.println(stock);
        }
    }
    @Autowired
    private StockDao stockDao;
}
