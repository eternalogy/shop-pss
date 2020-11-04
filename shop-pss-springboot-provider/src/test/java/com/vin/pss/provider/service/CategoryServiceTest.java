package com.vin.pss.provider.service;

import com.github.pagehelper.PageInfo;
import com.vin.pss.provider.model.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    @Test
    public void getAllForPage() {
        PageInfo<Category> allForPage = categoryService.getAllForPage(1, 10);
        System.out.println(allForPage);
    }

    @Test
    public void logicDeleteCategoryByCategoryId() {
        Integer integer = categoryService.logicDeleteCategoryByCategoryId(27);
        System.out.println(integer);
    }

    @Test
    public void modifyCategoryByCategoryId() {
        Category category = new Category();
        category.setId(27);
        category.setCategoryName("修改");
        categoryService.modifyCategoryByCategoryId(category);
    }

    @Test
    public void getCategoriesByCategoryNameForPage() {
        PageInfo<Category> categories = categoryService.getCategoriesByCategoryNameForPage("品", 1, 10);
        System.out.println(categories);
    }

    @Test
    public void addCategory() {
        Category category = new Category();
        category.setCategoryName("测测更健康");
        categoryService.addCategory(category);
    }

    @Autowired
    private CategoryService categoryService;

}
