package com.vin.pss.provider.service;

import com.github.pagehelper.PageInfo;
import com.vin.pss.provider.model.Stock;

import java.util.List;

/**
 * @Description TODO
 * @Author Vincent Chiu
 * @Date 2020-10-21 15:22
 */
public interface StockService{
    /**
     * 查询所有商品库存信息
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<Stock> getAll(Integer pageNo, Integer pageSize);

    /**
     * 通过商品名称模糊查询库存记录
     * @param productName
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<Stock> getStocksByProductName(String productName, Integer pageNo, Integer pageSize);

    /**
     * 新增库存记录
     * @param stock
     * @return
     */
    Integer addStock(Stock stock);

    /**
     * 通过条码获取库存信息
     * @param barCode
     * @return
     */
    Stock getStockByBarCode(String barCode);

    /**
     * 通过条码修改库存信息
     * @param stock
     * @return
     */
    Integer modifyStockByBarCode(Stock stock);

}
