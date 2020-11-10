package com.vin.pss.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.vin.pss.consumer.response.ResponseEnum;
import com.vin.pss.consumer.response.ResponseResult;
import com.vin.pss.provider.model.Category;
import com.vin.pss.provider.model.Product;
import com.vin.pss.provider.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @Description 商品管理接口
 * @Author Vincent Chiu
 * @Date 2020-10-21 17:13
 */
@RestController
@RequestMapping("/api/v2/product")
@Api("商品管理接口")
@Slf4j
public class ProductController {
    @ApiOperation("查询所有商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "当前页"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数")
    })
    @GetMapping("")
    public ResponseResult<PageInfo<Product>> getAllForPage(Integer pageNo, Integer pageSize) {
        PageInfo<Product> products = productService.getAll(pageNo, pageSize);
        return new ResponseResult<>(ResponseEnum.SUCCESS, products);
    }

    @ApiOperation(("根据商品名称模糊查询商品"))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productName", value = "商品名称"),
            @ApiImplicitParam(name = "pageNo", value = "当前页"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数")
    })
    @GetMapping("search")
    public ResponseResult<PageInfo<Product>> getProductsByProductNameForPage(String productName, Integer pageNo, Integer pageSize) {
        PageInfo<Product> products = productService.getProductsByProductName(productName, pageNo, pageSize);
        return new ResponseResult<>(ResponseEnum.SUCCESS, products);
    }

    @ApiOperation(("删除商品"))
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "商品编号")})
    @DeleteMapping("{barCode}")
    public ResponseResult<Integer> logicDeleteProduct(@PathVariable String barCode) {
        Integer row = productService.logicDeleteProductByBarCode(barCode);
        return new ResponseResult<>(ResponseEnum.SUCCESS, row);
    }

    @ApiOperation(("修改商品"))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "barCode", value = "商品条码"),
            @ApiImplicitParam(name = "supplierId", value = "供应商编号"),
            @ApiImplicitParam(name = "categoryId", value = "品类编号"),
            @ApiImplicitParam(name = "productName", value = "商品名称"),
            @ApiImplicitParam(name = "salePrice", value = "销售单价")
    })
    @PutMapping("{barCode}")
    public ResponseResult<Integer> modifyProduct(@PathVariable String barCode, String supplierId, String categoryId, String productName, String salePrice) {
        Product product = new Product();
        product.setBarCode(barCode);
        product.setSupplierId(Integer.parseInt(supplierId));
        product.setCategoryId(Integer.parseInt(categoryId));
        product.setProductName(productName);
        product.setSalePrice(BigDecimal.valueOf(Double.parseDouble(salePrice)));
        Integer row = productService.modifyProductByProductId(product);
        return new ResponseResult<>(ResponseEnum.SUCCESS, row);
    }
    @ApiOperation("通过条码查询商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "barCode", value = "商品条码")
    })
    @GetMapping("{barCode}")
    public ResponseResult<Product> getProductByBarCode(@PathVariable String barCode){
        Product product = productService.getProductByBarCode(barCode);
        return new ResponseResult<>(ResponseEnum.SUCCESS, product);
    }
    @DubboReference
    private ProductService productService;
}
