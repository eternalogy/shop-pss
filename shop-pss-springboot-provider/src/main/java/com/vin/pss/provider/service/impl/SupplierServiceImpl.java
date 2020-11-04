package com.vin.pss.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vin.pss.provider.dao.SupplierDao;
import com.vin.pss.provider.model.Supplier;
import com.vin.pss.provider.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description TODO
 * @Author Vincent Chiu
 * @Date 2020-10-21 15:23
 */
@Service
@org.springframework.stereotype.Service
public class SupplierServiceImpl implements SupplierService {
    @Override
    public PageInfo<Supplier> getAll(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Supplier> suppliers = supplierDao.selectAll();
        return new PageInfo<>(suppliers);
    }


    @Override
    public Integer logicDeleteSupplierBySupplierId(Integer id) {
        return supplierDao.logicDeleteByPrimaryKey(id);
    }

    @Override
    public Integer modifySupplierBySupplierId(Supplier supplier) {
        return supplierDao.updateByPrimaryKey(supplier);
    }

    @Override
    public PageInfo<Supplier> getSuppliersBySupplierName(String supplierName, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Supplier> suppliers = supplierDao.selectBySupplierName(supplierName);
        return new PageInfo<>(suppliers);
    }

    @Override
    public Integer addSupplier(Supplier supplier) {
        return supplierDao.insert(supplier);
    }

    @Autowired
    private SupplierDao supplierDao;

}
