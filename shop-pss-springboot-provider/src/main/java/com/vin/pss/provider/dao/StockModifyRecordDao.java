package com.vin.pss.provider.dao;

import com.vin.pss.provider.model.StockModifyRecord;

import java.util.List;

public interface StockModifyRecordDao {
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增
     * @param record
     * @return
     */
    int insert(StockModifyRecord record);

    /**
     * 查所有
     * @return
     */
    List<StockModifyRecord> selectAll();

    List<StockModifyRecord> selectByProductName(String productName);

    int insertSelective(StockModifyRecord record);

    StockModifyRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StockModifyRecord record);

    int updateByPrimaryKey(StockModifyRecord record);
}
