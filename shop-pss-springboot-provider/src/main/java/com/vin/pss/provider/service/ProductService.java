package com.vin.pss.provider.service;

import com.github.pagehelper.PageInfo;
import com.vin.pss.provider.model.Product;

import java.util.List;
import java.util.Map;

/**
 * @Description 商品Service接口
 * @Author Vincent Chiu
 * @Date 2020-10-21 15:19
 */
public interface ProductService {
    /**
     * 查询所有商品
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<Product> getAll(Integer pageNo, Integer pageSize);

    /**
     * 修改商品
     * @param product
     * @return
     */
    Integer modifyProductByProductId(Product product);

    /**
     * 模糊查询商品
     * @param productName
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<Product> getProductsByProductName(String productName,Integer pageNo, Integer pageSize);

    /**
     * 通过条码逻辑删除商品
     * @param barCode
     * @return
     */
    Integer logicDeleteProductByBarCode(String barCode);

    /**
     * 通过条码查询商品
     * @param barCode
     * @return
     */
    Product getProductByBarCode(String barCode);
}
