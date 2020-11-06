package com.vin.pss.provider.dao;

import com.vin.pss.provider.model.Stock;

import java.util.List;

public interface StockDao {
    int deleteByPrimaryKey(String productBarCode);

    /**
     * 新增
     * @param record
     * @return
     */
    int insert(Stock record);

    int insertSelective(Stock record);

    Stock selectByPrimaryKey(String productBarCode);

    int updateByPrimaryKeySelective(Stock record);

    /**
     * 修改库存
     * @param record
     * @return
     */
    int updateByPrimaryKey(Stock record);

    /**
     * 查所有
     * @return
     */
    List<Stock> selectAll();

    /**
     * 模糊查询
     * @return
     */
    List<Stock> selectByProductName(String productName);
}
