package com.vin.pss.provider.service;

import com.vin.pss.provider.model.Sale;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SaleServiceTest {

    @Test
    public void getAll() {
    }

    @Test
    public void getSalesByProductName() {
    }

    @Test
    public void sale() {
        Sale sale = new Sale();
        sale.setProductBarCode("6936983800013");
        sale.setSaleCount(20);
        sale.setSaleDate(new Date());
        sale.setSalePrice(BigDecimal.valueOf(20));
        sale.setSaleAmount(BigDecimal.valueOf(400));
        saleService.sale(sale);
    }

    @Autowired
    private SaleService saleService;
}
