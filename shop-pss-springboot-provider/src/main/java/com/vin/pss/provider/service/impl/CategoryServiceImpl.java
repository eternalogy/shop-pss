package com.vin.pss.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vin.pss.provider.dao.CategoryDao;
import com.vin.pss.provider.model.Category;
import com.vin.pss.provider.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description 品类Service实现类
 * @Author Vincent Chiu
 * @Date 2020-10-21 14:05
 */
@Service
@org.springframework.stereotype.Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public PageInfo<Category> getAllForPage(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Category> categories = categoryDao.selectAll();
        return new PageInfo<>(categories);
    }


    @Override
    public Integer logicDeleteCategoryByCategoryId(Integer id) {
        return categoryDao.logicDeleteByPrimaryKey(id);
    }

    @Override
    public Integer modifyCategoryByCategoryId(Category category) {
        return categoryDao.updateByPrimaryKey(category);
    }

    @Override
    public PageInfo<Category> getCategoriesByCategoryNameForPage(String categoryName, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Category> categories = categoryDao.selectByCategoryName(categoryName);
        return new PageInfo<>(categories);
    }

    @Override
    public Integer addCategory(Category category) {
        return categoryDao.insert(category);
    }

    @Autowired
    private CategoryDao categoryDao;

}
