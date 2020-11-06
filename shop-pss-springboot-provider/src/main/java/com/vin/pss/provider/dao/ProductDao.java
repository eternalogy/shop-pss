package com.vin.pss.provider.dao;

import com.vin.pss.provider.model.Product;

import java.util.List;

public interface ProductDao {
    int deleteByPrimaryKey(Integer id);

    /**
     * 通过商品编号逻辑删除商品
     * @param id
     * @return
     */
    int logicDeleteByPrimaryKey(Integer id);

    /**
     * 通过条码逻辑删除商品
     * @param barCode
     * @return
     */
    int logicDeleteByBarCode(String barCode);

    /**
     * 增加
     * @param record
     * @return
     */
    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    /**
     * 改
     * @param record
     * @return
     */
    int updateByPrimaryKey(Product record);

    /**
     * 查所有
     * @return
     */
    List<Product> selectAll();

    /**
     * 模糊查
     * @return
     */
    List<Product> selectByProductName(String productName);

    /**
     * 根据条码查商品
     * @param barCode
     * @return
     */
    Product selectProductByBarCode(String barCode);
}
