package com.vin.pss.provider.service;

import com.github.pagehelper.PageInfo;
import com.vin.pss.provider.model.Supplier;

import java.util.List;

/**
 * @Description 供应商Service接口
 * @Author Vincent Chiu
 * @Date 2020-10-21 15:23
 */
public interface SupplierService{
    /**
     * 查询所有供应商信息
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<Supplier> getAll(Integer pageNo, Integer pageSize);

    /**
     * 通过供应商编号逻辑删除供应商
     * @param id
     * @return
     */
    Integer logicDeleteSupplierBySupplierId(Integer id);

    /**
     * 通过供应商编号修改供应商
     * @param supplier
     * @return
     */
    Integer modifySupplierBySupplierId(Supplier supplier);

    /**
     * 通过供应商姓名模糊查询供应商信息
     * @param supplierName
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<Supplier> getSuppliersBySupplierName(String supplierName,Integer pageNo, Integer pageSize);

    /**
     * 添加供应商
     * @param supplier
     * @return
     */
    Integer addSupplier(Supplier supplier);
}
