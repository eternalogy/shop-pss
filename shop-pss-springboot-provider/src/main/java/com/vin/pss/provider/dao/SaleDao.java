package com.vin.pss.provider.dao;

import com.vin.pss.provider.model.Sale;

import java.util.List;

public interface SaleDao {
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增
     *
     * @param record
     * @return
     */
    int insert(Sale record);

    int insertSelective(Sale record);

    Sale selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sale record);

    int updateByPrimaryKey(Sale record);

    /**
     * 查所有
     *
     * @return
     */
    List<Sale> selectAll();

    /**
     * 模糊查
     *
     * @param productName
     * @return
     */
    List<Sale> selectByProductName(String productName);
}
