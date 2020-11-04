package com.vin.pss.provider.dao;

import com.vin.pss.provider.model.StockModifyRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StockModifyRecordDaoTest {

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
        StockModifyRecord stockModifyRecord = new StockModifyRecord();
        stockModifyRecord.setProductBarCode("6936983800024");
        stockModifyRecord.setModifyCount(100);
        stockModifyRecord.setOperatorId(1);
        stockModifyRecord.setModifyType("进货");
        stockModifyRecordDao.insert(stockModifyRecord);
    }

    @Test
    public void selectAll() {
        List<StockModifyRecord> stockModifyRecords = stockModifyRecordDao.selectAll();
        for (StockModifyRecord stockModifyRecord : stockModifyRecords) {
            System.out.println(stockModifyRecord);
        }
    }

    @Test
    public void selectByProductName() {
        List<StockModifyRecord> stockModifyRecords = stockModifyRecordDao.selectByProductName("完美");
        for (StockModifyRecord stockModifyRecord : stockModifyRecords) {
            System.out.println(stockModifyRecord);
        }
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
    @Autowired
    private StockModifyRecordDao stockModifyRecordDao;
}
