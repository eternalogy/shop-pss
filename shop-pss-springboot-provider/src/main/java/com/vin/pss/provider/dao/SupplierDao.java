package com.vin.pss.provider.dao;

import com.vin.pss.provider.model.Supplier;

import java.util.List;

public interface SupplierDao {
    int deleteByPrimaryKey(Integer id);

    /**
     * 逻辑删除供应商
     * @param id
     * @return
     */
    int logicDeleteByPrimaryKey(Integer id);

    /**
     * 增加供应商
     * @param record
     * @return
     */
    int insert(Supplier record);

    int insertSelective(Supplier record);

    /**
     * 查询一个供应商
     * @param id
     * @return
     */
    Supplier selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Supplier record);

    /**
     * 修改供应商
     * @param record
     * @return
     */
    int updateByPrimaryKey(Supplier record);

    /**
     * 模糊查询供应商
     * @param supplierName
     * @return
     */
    List<Supplier> selectBySupplierName(String supplierName);

    /**
     * 查所有供应商
     * @return
     */
    List<Supplier> selectAll();
}
