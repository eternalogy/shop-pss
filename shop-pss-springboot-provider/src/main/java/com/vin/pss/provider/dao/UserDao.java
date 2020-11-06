package com.vin.pss.provider.dao;

import com.vin.pss.provider.model.User;

import java.util.List;

public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int logicDeleteByPrimaryKey(Integer id);

    List<User> getAll();

    List<User> getUsersByUsername(String username);
}
