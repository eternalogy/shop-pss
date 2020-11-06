package com.vin.pss.provider.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vin.pss.provider.dao.StockModifyRecordDao;
import com.vin.pss.provider.model.StockModifyRecord;
import com.vin.pss.provider.service.StockModifyRecordService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 库存修改记录Service实现类
 * @Author Vincent Chiu
 * @Date 2020-10-21 16:12
 */
@DubboService
@Service
public class StockModifyRecordServiceImpl implements StockModifyRecordService {
    @Override
    public PageInfo<StockModifyRecord> getAll(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<StockModifyRecord> stockModifyRecords = stockModifyRecordDao.selectAll();
        return new PageInfo<>(stockModifyRecords);
    }

    @Override
    public PageInfo<StockModifyRecord> getStockModifyRecordsByProductName(String productName, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<StockModifyRecord> stockModifyRecords = stockModifyRecordDao.selectByProductName(productName);
        return new PageInfo<>(stockModifyRecords);
    }

    @Override
    public Integer addStockModifyRecord(StockModifyRecord stockModifyRecord) {
        return stockModifyRecordDao.insert(stockModifyRecord);
    }

    @Autowired
    private StockModifyRecordDao stockModifyRecordDao;
}
