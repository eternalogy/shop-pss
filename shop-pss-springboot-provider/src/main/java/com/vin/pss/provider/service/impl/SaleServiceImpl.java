package com.vin.pss.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vin.pss.provider.dao.ProductDao;
import com.vin.pss.provider.dao.SaleDao;
import com.vin.pss.provider.dao.StockDao;
import com.vin.pss.provider.dao.StockModifyRecordDao;
import com.vin.pss.provider.model.Sale;
import com.vin.pss.provider.model.Stock;
import com.vin.pss.provider.model.StockModifyRecord;
import com.vin.pss.provider.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description TODO
 * @Author Vincent Chiu
 * @Date 2020-10-21 15:22
 */
@Service
@org.springframework.stereotype.Service
public class SaleServiceImpl implements SaleService {
    @Override
    public PageInfo<Sale> getAll(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Sale> sales = saleDao.selectAll();
        return new PageInfo<>(sales);
    }

    @Override
    public PageInfo<Sale> getSalesByProductName(String productName, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Sale> sales = saleDao.selectByProductName(productName);
        return new PageInfo<>(sales);
    }

    @Override
    public Integer sale(Sale sale) {
        if (productDao.selectProductByBarCode(sale.getProductBarCode()) == null) {
            //返回找不到此商品
            return 1;
        } else {
            //查出这个商品的库存
            Integer stockCount = stockDao.selectByPrimaryKey(sale.getProductBarCode()).getStockCount();
            //如果销售数量小于等于库存
            if (sale.getSaleCount() <= stockCount) {
                //添加销售记录
                saleDao.insert(sale);
                //计算变更总量总量，并添加变更记录
                StockModifyRecord stockModifyRecord = new StockModifyRecord();
                stockModifyRecord.setModifyType("销售");
                stockModifyRecord.setModifyCount(sale.getSaleCount());
                stockModifyRecord.setProductBarCode(sale.getProductBarCode());
                stockModifyRecordDao.insert(stockModifyRecord);
                //修改库存
                //查出旧库存
                Integer oldStockCount = stockDao.selectByPrimaryKey(sale.getProductBarCode()).getStockCount();
                //计算新库存
                Integer newStockCount = oldStockCount - sale.getSaleCount();
                //封装成新库存对象，写入库存表
                Stock newStock = new Stock();
                newStock.setProductBarCode(sale.getProductBarCode());
                newStock.setStockCount(newStockCount);
                stockDao.updateByPrimaryKey(newStock);
            } else {
                return 2;
            }
        }
        return 0;
    }

    @Autowired
    private SaleDao saleDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private StockDao stockDao;
    @Autowired
    private StockModifyRecordDao stockModifyRecordDao;
}
