package com.vin.pss.provider.dao;

import com.vin.pss.provider.model.Supplier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SupplierDaoTest {

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void logicDeleteByPrimaryKey() {
    }

    @Test
    public void insert() {
        Supplier supplier = new Supplier();
        supplier.setAddress("山东青岛");
        supplier.setTel("18888888888");
        supplier.setContactsName("quping");
        supplier.setSupplierName("青岛aa批发公司");
        supplierDao.insert(supplier);
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void selectBySupplierName() {
        List<Supplier> suppliers = supplierDao.selectBySupplierName("广州");
        for (Supplier supplier : suppliers) {
            System.out.println(supplier);
        }
    }

    @Test
    public void selectAll() {
        List<Supplier> suppliers = supplierDao.selectAll();
        for (Supplier supplier : suppliers) {
            System.out.println(supplier);
        }
    }

    @Autowired
    private SupplierDao supplierDao;
}
