package com.vin.pss.consumer.controller;

import cn.hutool.core.date.DateUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.vin.pss.consumer.response.ResponseEnum;
import com.vin.pss.consumer.response.ResponseResult;
import com.vin.pss.provider.model.Purchase;
import com.vin.pss.provider.model.Sale;
import com.vin.pss.provider.service.SaleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Description 销售接口
 * @Author Vincent Chiu
 * @Date 2020-10-21 17:14
 */
@RestController
@RequestMapping("/api/v2//sale")
@Api("销售接口")
@Slf4j
public class SaleController {
    @ApiOperation("查询所有销售记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "当前页"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数")
    })
    @GetMapping("")
    public ResponseResult<PageInfo<Sale>> getAll(Integer pageNo, Integer pageSize) {
        PageInfo<Sale> sales = saleService.getAll(pageNo, pageSize);
        return new ResponseResult<>(ResponseEnum.SUCCESS, sales);
    }
    @ApiOperation("通过商品名称模糊查询销售记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productName", value = "商品名称"),
            @ApiImplicitParam(name = "pageNo", value = "当前页"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数")
    })
    @GetMapping("search")
    public ResponseResult<PageInfo<Sale>> getSalesByProductName(String productName, Integer pageNo, Integer pageSize){
        PageInfo<Sale> sales = saleService.getSalesByProductName(productName, pageNo, pageSize);
        return new ResponseResult<>(ResponseEnum.SUCCESS, sales);
    }
    @ApiOperation("执行进货操作")
    @PostMapping("")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "barCode", value = "商品条码"),
            @ApiImplicitParam(name = "salePrice", value = "商品销售单价"),
            @ApiImplicitParam(name = "saleDate", value = "商品销售日期"),
            @ApiImplicitParam(name = "saleCount", value = "商品销售数量")
    })
    public ResponseResult<Integer> sale(String barCode, String salePrice, String saleDate, String saleCount){
        Sale sale = new Sale();
        sale.setProductBarCode(barCode);
        sale.setSalePrice(new BigDecimal(salePrice));
        sale.setSaleDate(DateUtil.parseDate(saleDate));
        sale.setSaleCount(Integer.parseInt(saleCount));
        sale.setSaleAmount(new BigDecimal(salePrice).multiply(new BigDecimal(saleCount)));
        Integer row = saleService.sale(sale);
        return new ResponseResult<>(ResponseEnum.SUCCESS, row);
    }
    @DubboReference
    private SaleService saleService;
}
