package com.vin.pss.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.vin.pss.provider.model.Supplier;
import com.vin.pss.provider.service.SupplierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 供应商管理接口
 * @Author Vincent Chiu
 * @Date 2020-10-21 17:15
 */
@RestController
@RequestMapping("/api/v2/supplier")
@Api("供应商管理接口")
@Slf4j
public class SupplierController {
    @ApiOperation("查询所有供应商")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "当前页"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数")
    })
    @GetMapping("")
    public PageInfo<Supplier> getAllForPage(Integer pageNo, Integer pageSize) {
        return supplierService.getAll(pageNo, pageSize);
    }

    @ApiOperation(("根据供应商名称模糊查询供应商"))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "supplierName", value = "供应商名称"),
            @ApiImplicitParam(name = "pageNo", value = "当前页"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数")
    })
    @GetMapping("search")
    public PageInfo<Supplier> getSuppliersBySupplierNameForPage(String supplierName, Integer pageNo, Integer pageSize) {
        return supplierService.getSuppliersBySupplierName(supplierName, pageNo, pageSize);
    }

    @ApiOperation(("添加供应商"))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "supplierName", value = "供应商名称"),
            @ApiImplicitParam(name = "address", value = "供应商地址"),
            @ApiImplicitParam(name = "contactsName", value = "联系人姓名"),
            @ApiImplicitParam(name = "tel", value = "供应商电话")
    })
    @PostMapping("")
    public Integer addSupplier(String supplierName, String address, String contactsName, String tel) {
        Supplier supplier = new Supplier();
        supplier.setSupplierName(supplierName);
        supplier.setAddress(address);
        supplier.setContactsName(contactsName);
        supplier.setTel(tel);
        return supplierService.addSupplier(supplier);
    }

    @ApiOperation(("删除供应商"))
    @ApiImplicitParams({@ApiImplicitParam(name = "supplierId", value = "供应商编号")})
    @DeleteMapping("{id}")
    public Integer logicDeleteSupplier(@PathVariable String id) {
        return supplierService.logicDeleteSupplierBySupplierId(Integer.parseInt(id));
    }

//    @ApiOperation(("根据id查询供应商"))
//    @ApiImplicitParams({@ApiImplicitParam(name = "supplierId", value = "供应商编号")})
//    @GetMapping("{id}")
//    public Supplier getSupplierById(@PathVariable String id) {
//        return supplierService.getSupplierBySupplierId(Integer.parseInt(id));
//    }

    @ApiOperation(("修改供应商"))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "供应商编号"),
            @ApiImplicitParam(name = "supplierName", value = "供应商名称"),
            @ApiImplicitParam(name = "contactsName", value = "联系人姓名"),
            @ApiImplicitParam(name = "tel", value = "联系人电话"),
            @ApiImplicitParam(name = "address", value = "供应商地址")
    })
    @PutMapping("{id}")
    public Integer modifyCategory(@PathVariable String id, String supplierName, String contactsName, String tel, String address) {
        Supplier supplier = new Supplier();
        supplier.setId(Integer.parseInt(id));
        supplier.setSupplierName(supplierName);
        supplier.setContactsName(contactsName);
        supplier.setTel(tel);
        supplier.setAddress(address);
        return supplierService.modifySupplierBySupplierId(supplier);
    }

    @DubboReference
    SupplierService supplierService;
}
