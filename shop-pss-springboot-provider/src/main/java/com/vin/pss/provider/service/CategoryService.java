package com.vin.pss.provider.service;

import com.github.pagehelper.PageInfo;
import com.vin.pss.provider.model.Category;

import java.util.List;

/**
 * @Description 品类Service接口
 * @Author Vincent Chiu
 * @Date 2020-10-21 14:02
 */
public interface CategoryService {

    /**
     * 列出所有品类
     * @param pageNo
     * @param pageSize
     * @return PageInfo<Category>
     */
    PageInfo<Category> getAllForPage(Integer pageNo, Integer pageSize);

    /**
     * 逻辑删除品类
     *
     * @param id
     * @return
     */
    Integer logicDeleteCategoryByCategoryId(Integer id);

    /**
     * 修改商品品类
     *
     * @param category
     * @return
     */
    Integer modifyCategoryByCategoryId(Category category);

    /**
     * 模糊查询商品品类
     *
     * @param categoryName
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<Category> getCategoriesByCategoryNameForPage(String categoryName, Integer pageNo, Integer pageSize);

    /**
     * 添加品类
     *
     * @param category
     * @return
     */
    Integer addCategory(Category category);

}
