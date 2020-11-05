package com.vin.pss.provider.service;

import com.github.pagehelper.PageInfo;
import com.vin.pss.provider.model.Sale;

import java.util.List;

/**
 * @Description 销售Service接口
 * @Author Vincent Chiu
 * @Date 2020-10-21 15:22
 */
public interface SaleService {
    /**
     * 列出所有销售记录
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<Sale> getAll(Integer pageNo, Integer pageSize);

    /**
     * 根据商品名称模糊查询销售记录
     * @param productName
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<Sale> getSalesByProductName(String productName, Integer pageNo, Integer pageSize);

    /**
     * 模拟销售
     * @param sale
     * @return
     */
    Integer sale(Sale sale);
}
