package com.vin.pss.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.vin.pss.consumer.response.ResponseEnum;
import com.vin.pss.consumer.response.ResponseResult;
import com.vin.pss.provider.model.Sale;
import com.vin.pss.provider.model.Stock;
import com.vin.pss.provider.service.StockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 库存管理接口
 * @Author Vincent Chiu
 * @Date 2020-10-21 17:15
 */
@RestController
@RequestMapping("/api/v2/stock")
@Api("库存管理接口")
@Slf4j
public class StockController {
    @ApiOperation("查询所有库存记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "当前页"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数")
    })
    @GetMapping("")
    public ResponseResult<PageInfo<Stock>> getAll(Integer pageNo, Integer pageSize) {
        PageInfo<Stock> stocks = stockService.getAll(pageNo, pageSize);
        return new ResponseResult<PageInfo<Stock>>(ResponseEnum.SUCCESS, stocks);
    }
    @ApiOperation("通过商品名称模糊查询库存记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productName", value = "商品名称"),
            @ApiImplicitParam(name = "pageNo", value = "当前页"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数")
    })
    @GetMapping("search")
    public ResponseResult<PageInfo<Stock>> getSalesByProductName(String productName, Integer pageNo, Integer pageSize){
        PageInfo<Stock> sales = stockService.getStocksByProductName(productName, pageNo, pageSize);
        return new ResponseResult<PageInfo<Stock>>(ResponseEnum.SUCCESS, sales);
    }
    @Reference
    private StockService stockService;
}
