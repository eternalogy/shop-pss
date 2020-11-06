package com.vin.pss.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.vin.pss.consumer.response.ResponseEnum;
import com.vin.pss.consumer.response.ResponseResult;
import com.vin.pss.provider.model.Category;
import com.vin.pss.provider.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 品类管理接口
 * @Author Vincent Chiu
 * @Date 2020-10-21 17:13
 */
@RestController
@RequestMapping("/api/v2/category")
@Api("品类管理接口")
@Slf4j
public class CategoryController {
    @ApiOperation("查询所有品类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "当前页"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数")
    })
    @GetMapping("")
    public ResponseResult<PageInfo<Category>> getAllForPage(Integer pageNo, Integer pageSize) {
        PageInfo<Category> categories = categoryService.getAllForPage(pageNo, pageSize);
        return new ResponseResult<>(ResponseEnum.SUCCESS, categories);
    }

    @ApiOperation(("根据品类名称模糊查询品类"))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryName", value = "品类名称"),
            @ApiImplicitParam(name = "pageNo", value = "当前页"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数")
    })
    @GetMapping("search")
    public ResponseResult<PageInfo<Category>> getCategoriesByCategoryNameForPage(String categoryName, Integer pageNo, Integer pageSize) {
        PageInfo<Category> categories = categoryService.getCategoriesByCategoryNameForPage(categoryName, pageNo, pageSize);
        return new ResponseResult<>(ResponseEnum.SUCCESS, categories);
    }

    @ApiOperation(("添加品类"))
    @ApiImplicitParams({@ApiImplicitParam(name = "categoryName", value = "商品名称")})
    @PostMapping("")
    public ResponseResult<Integer> addCategory(String categoryName) {
        Category category = new Category();
        category.setCategoryName(categoryName);
        Integer row = categoryService.addCategory(category);
        return new ResponseResult<>(ResponseEnum.SUCCESS, row);
    }

    @ApiOperation(("删除品类"))
    @ApiImplicitParams({@ApiImplicitParam(name = "categoryId", value = "品类编号")})
    @DeleteMapping("{id}")
    public ResponseResult<Integer> logicDeleteCategory(@PathVariable String id) {
        Integer row = categoryService.logicDeleteCategoryByCategoryId(Integer.parseInt(id));
        return new ResponseResult<>(ResponseEnum.SUCCESS, row);
    }

//    @ApiOperation(("根据id查询品类"))
//    @ApiImplicitParams({@ApiImplicitParam(name = "categoryId", value = "品类编号")})
//    @GetMapping("{id}")
//    public Category getCategoryById(@PathVariable String id) {
//        return categoryService.getCategoryByCategoryId(Integer.parseInt(id));
//    }

    @ApiOperation(("修改品类"))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "品类编号"),
            @ApiImplicitParam(name = "categoryName", value = "品类名称")
    })
    @PutMapping("{id}")
    public ResponseResult<Integer> modifyCategory(@PathVariable String id, String categoryName) {
        Category category = new Category();
        category.setId(Integer.parseInt(id));
        category.setCategoryName(categoryName);
        Integer row = categoryService.modifyCategoryByCategoryId(category);
        return new ResponseResult<>(ResponseEnum.SUCCESS, row);
    }

    @DubboReference
    CategoryService categoryService;
}
