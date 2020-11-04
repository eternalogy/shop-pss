package com.vin.pss.provider.dao;

import com.vin.pss.provider.model.Category;

import java.util.List;

public interface CategoryDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> selectAll();

    List<Category> selectByCategoryName(String categoryName);

    int logicDeleteByPrimaryKey(Integer id);
}
