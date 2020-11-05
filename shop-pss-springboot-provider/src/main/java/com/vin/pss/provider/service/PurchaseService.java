package com.vin.pss.provider.service;

import com.github.pagehelper.PageInfo;
import com.vin.pss.provider.model.Product;
import com.vin.pss.provider.model.Purchase;
import com.vin.pss.provider.model.Sale;
import com.vin.pss.provider.model.StockModifyRecord;

import java.util.List;

/**
 * @Description 进货Service接口
 * @Author Vincent Chiu
 * @Date 2020-10-21 15:21
 */
public interface PurchaseService {
    /**
     * 查询所有进货记录
     *
     * @return
     */
    PageInfo<Purchase> getAll(Integer pageNo, Integer pageSize);

    /**
     * 模糊查询进货记录
     *
     * @param productName
     * @return
     */
    PageInfo<Purchase> getPurchasesByProductName(String productName, Integer pageNo, Integer pageSize);

    /**
     * 新增进货记录
     *
     * @param purchase
     * @return
     */
    Integer addPurchase(Purchase purchase);

    /**
     * 执行进货操作
     *
     * @param purchase
     * @return
     */
    Integer purchase(Purchase purchase, Product product);

}
