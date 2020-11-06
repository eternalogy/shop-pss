package com.vin.pss.provider.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vin.pss.provider.dao.StockDao;
import com.vin.pss.provider.model.Stock;
import com.vin.pss.provider.service.StockService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 库存Service实现类
 * @Author Vincent Chiu
 * @Date 2020-10-21 15:22
 */
@DubboService
@Service
public class StockServiceImpl implements StockService {
    @Override
    public PageInfo<Stock> getAll(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Stock> stocks = stockDao.selectAll();
        return new PageInfo<>(stocks);
    }

    @Override
    public PageInfo<Stock> getStocksByProductName(String productName, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Stock> stocks = stockDao.selectByProductName(productName);
        return new PageInfo<>(stocks);
    }

    @Override
    public Integer addStock(Stock stock) {
        return stockDao.insert(stock);
    }

    @Override
    public Stock getStockByBarCode(String barCode) {
        return null;
    }

    @Override
    public Integer modifyStockByBarCode(Stock stock) {
        return stockDao.updateByPrimaryKey(stock);
    }

    @Autowired
    private StockDao stockDao;
}
