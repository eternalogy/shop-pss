package com.vin.pss.provider.service;

import com.github.pagehelper.PageInfo;
import com.vin.pss.provider.model.User;

import java.util.List;

/**
 * @Description 用户Service接口
 * @Author Vincent Chiu
 * @Date 2020-10-21 15:26
 */
public interface UserService {
    /**
     * 查询所有用户信息
     * @param pageNO
     * @param pageSize
     * @return
     */
    PageInfo<User> getAll(Integer pageNO, Integer pageSize);

    /**
     * 逻辑删除用户
     * @param userId
     * @return
     */
    Integer logicDeleteUserByUserId(Integer userId);

    /**
     * 修改用户
     * @param userId
     * @return
     */
    Integer modifyUserByUserId(Integer userId);

    /**
     * 根据用户姓名模糊查询用户
     * @param userName
     * @param pageNO
     * @param pageSize
     * @return
     */
    PageInfo<User> getUsersByUserName(String userName, Integer pageNO, Integer pageSize);

    /**
     * 添加用户
     * @param user
     * @return
     */
    Integer addUser(User user);
}
