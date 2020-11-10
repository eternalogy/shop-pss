package com.vin.pss.consumer.controller;

import cn.hutool.core.date.DateUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.vin.pss.consumer.response.ResponseEnum;
import com.vin.pss.consumer.response.ResponseResult;
import com.vin.pss.provider.model.Product;
import com.vin.pss.provider.model.Purchase;
import com.vin.pss.provider.service.ProductService;
import com.vin.pss.provider.service.PurchaseService;
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
 * @Description 进货接口
 * @Author Vincent Chiu
 * @Date 2020-10-21 17:14
 */
@RestController
@RequestMapping("/api/v2/purchase")
@Api("进货接口")
@Slf4j
public class PurchaseController {
    @ApiOperation("查询所有进货记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "当前页"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数")
    })
    @GetMapping("")
    public ResponseResult<PageInfo<Purchase>> getAll(Integer pageNo, Integer pageSize) {
        PageInfo<Purchase> purchases = purchaseService.getAll(pageNo, pageSize);
        return new ResponseResult<>(ResponseEnum.SUCCESS, purchases);
    }
    @ApiOperation("通过商品名称模糊查询进货记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productName", value = "商品名称"),
            @ApiImplicitParam(name = "pageNo", value = "当前页"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数")
    })
    @GetMapping("search")
    public ResponseResult<PageInfo<Purchase>> getPurchasesByProductName(String productName, Integer pageNo, Integer pageSize){
        PageInfo<Purchase> purchases = purchaseService.getPurchasesByProductName(productName, pageNo, pageSize);
        return new ResponseResult<>(ResponseEnum.SUCCESS, purchases);
    }

    @ApiOperation("执行进货操作")
    @PostMapping("")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "barCode", value = "商品条码"),
            @ApiImplicitParam(name = "productName", value = "商品名称"),
            @ApiImplicitParam(name = "salePrice", value = "商品销售价格"),
            @ApiImplicitParam(name = "supplierId", value = "商品供应商编号"),
            @ApiImplicitParam(name = "categoryId", value = "商品品类编号"),
            @ApiImplicitParam(name = "purchasePrice", value = "商品进货单价"),
            @ApiImplicitParam(name = "purchaseDate", value = "商品进货日期"),
            @ApiImplicitParam(name = "proDate", value = "商品生产日期"),
            @ApiImplicitParam(name = "expDate", value = "商品过期日期"),
            @ApiImplicitParam(name = "count", value = "进货数量"),
            @ApiImplicitParam(name = "netContent", value = "净含量"),
            @ApiImplicitParam(name = "placeOfOrigin", value = "产地"),
            @ApiImplicitParam(name = "storageCondition", value = "储存条件")
    })
    public ResponseResult<Integer> purchase(
            String barCode,
            String productName,
            String purchasePrice,
            String purchaseDate,
            String proDate,
            String expDate,
            String count,
            String salePrice,
            String supplierId,
            String categoryId,
            String netContent,
            String placeOfOrigin,
            String storageCondition) {
        Product product = new Product();
        product.setBarCode(barCode);
        product.setCategoryId(Integer.parseInt(categoryId));
        product.setSupplierId(Integer.parseInt(supplierId));
        product.setProductName(productName);
        product.setSalePrice(new BigDecimal(salePrice));
        product.setNetContent(netContent);
        product.setPlaceOfOrigin(placeOfOrigin);
        product.setStorageCondition(storageCondition);
        Purchase purchase = new Purchase();
        purchase.setPurchasePrice(new BigDecimal(purchasePrice));
        purchase.setPurchaseDate(DateUtil.parseDate(purchaseDate));
        purchase.setProDate(DateUtil.parseDate(proDate));
        purchase.setExpDate(DateUtil.parseDate(expDate));
        purchase.setPurchaseCount(Integer.parseInt(count));
        Integer row = purchaseService.purchase(purchase, product);
        return new ResponseResult<>(ResponseEnum.SUCCESS, row);
    }

    @DubboReference
    private PurchaseService purchaseService;
    @DubboReference
    private ProductService productService;
}
