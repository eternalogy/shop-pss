package com.vin.pss.provider.service;

import com.github.pagehelper.PageInfo;
import com.vin.pss.provider.model.Supplier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupplierServiceTest {

    @Test
    public void getAll() {
        PageInfo<Supplier> all = supplierService.getAll(1, 10);
        System.out.println(all);
    }

    @Test
    public void logicDeleteSupplierBySupplierId() {

    }

    @Test
    public void modifySupplierBySupplierId() {

    }

    @Test
    public void getSuppliersBySupplierName() {
    }

    @Test
    public void addSupplier() {
    }

    @Autowired
    private SupplierService supplierService;
}
