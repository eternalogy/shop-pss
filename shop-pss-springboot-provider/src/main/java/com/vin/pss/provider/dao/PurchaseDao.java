package com.vin.pss.provider.dao;

import com.vin.pss.provider.model.Purchase;

import java.util.List;

public interface PurchaseDao {
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加进货记录
     * @param record
     * @return
     */
    int insert(Purchase record);

    int insertSelective(Purchase record);

    Purchase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Purchase record);

    int updateByPrimaryKey(Purchase record);

    /**
     * 查所有进货记录
     * @return
     */
    List<Purchase> selectAll();

    /**
     * 模糊查询进货记录
     * @param productName
     * @return
     */
    List<Purchase> selectByProductName(String productName);


}
