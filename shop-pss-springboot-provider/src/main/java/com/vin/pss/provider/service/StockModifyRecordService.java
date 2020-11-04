package com.vin.pss.provider.service;

import com.github.pagehelper.PageInfo;
import com.vin.pss.provider.model.StockModifyRecord;

import java.util.List;

/**
 * @Description TODO
 * @Author Vincent Chiu
 * @Date 2020-10-21 16:12
 */
public interface StockModifyRecordService {
    /**
     * 查询所有库存修改记录
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<StockModifyRecord> getAll(Integer pageNo, Integer pageSize);

    /**
     * 根据商品名称模糊查询库存修改记录
     * @param productName
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<StockModifyRecord> getStockModifyRecordsByProductName(String productName, Integer pageNo, Integer pageSize);

    /**
     * 新增库存修改记录
     * @param stockModifyRecord
     * @return
     */
    Integer addStockModifyRecord(StockModifyRecord stockModifyRecord);
}
