package com.vin.pss.provider.dao;

import com.vin.pss.provider.model.Category;

import java.util.List;

public interface CategoryDao {
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加单个品类
     * @param record
     * @return
     */
    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    /**
     * 修改单个品类
     * @param record
     * @return
     */
    int updateByPrimaryKey(Category record);

    /**
     * 查所有品类
     * @return
     */
    List<Category> selectAll();

    /**
     * 模糊查询品类
     * @param categoryName
     * @return
     */
    List<Category> selectByCategoryName(String categoryName);

    /**
     * 逻辑删除单个品类
     * @param id
     * @return
     */
    int logicDeleteByPrimaryKey(Integer id);
}
