package com.vin.pss.provider.dao;

import com.vin.pss.provider.model.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryDaoTest {

    @Test
    public void deleteByPrimaryKey() {

    }

    @Test
    public void insert() {
        Category category = new Category();
        category.setCategoryName("测试1");
        categoryDao.insert(category);
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
        Category category = new Category();
        category.setId(23);
        category.setCategoryName("kk");
        categoryDao.updateByPrimaryKey(category);
    }

    @Test
    public void selectAll() {
        List<Category> categories = categoryDao.selectAll();
        for (Category category : categories) {
            System.out.println(category);
        }
    }

    @Test
    public void selectByCategoryName() {
        List<Category> categories = categoryDao.selectByCategoryName("品");
        for (Category category : categories) {
            System.out.println(category);
        }
    }

    @Test
    public void logicDeleteByPrimaryKey() {
        categoryDao.logicDeleteByPrimaryKey(26);
    }

    @Autowired
    private CategoryDao categoryDao;
}
