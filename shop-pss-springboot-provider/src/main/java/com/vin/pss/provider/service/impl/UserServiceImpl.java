package com.vin.pss.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.vin.pss.provider.model.User;
import com.vin.pss.provider.service.UserService;

import java.util.List;

/**
 * @Description 用户Service实现类
 * @Author Vincent Chiu
 * @Date 2020-10-21 15:26
 */
@Service
@org.springframework.stereotype.Service
public class UserServiceImpl implements UserService {
    @Override
    public PageInfo<User> getAll(Integer pageNO, Integer pageSize) {
        return null;
    }

    @Override
    public Integer logicDeleteUserByUserId(Integer userId) {
        return null;
    }


    @Override
    public Integer modifyUserByUserId(Integer userId) {
        return null;
    }

    @Override
    public PageInfo<User> getUsersByUserName(String userName, Integer pageNO, Integer pageSize) {
        return null;
    }

    @Override
    public Integer addUser(User user) {
        return null;
    }
}
