package com.vin.pss.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.vin.pss.consumer.response.ResponseEnum;
import com.vin.pss.consumer.response.ResponseResult;
import com.vin.pss.provider.model.User;
import com.vin.pss.provider.service.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Description 用户接口
 * @Author Vincent Chiu
 * @Date 2020-10-21 17:15
 */
@RestController
@RequestMapping("/api/v2/user")
@Api("用户接口")
@Slf4j
public class UserController {
//    @PostMapping("/login")
//    public ResponseResult<User> login(String loginAccount, String password, HttpSession session){
//        //打印入口日志
//        log.info("request uri: /user/login, request params, loginAccount:{}, password:{}", loginAccount, password);
//        ResponseResult<User> responseResult;
//        User user = userService.login(loginAccount, password);
//        if (user != null && user.getId() > 0) {
//            session.setAttribute("user", user);
//            responseResult = new ResponseResult<>(ResponseEnum.HAS_USER, user);
//        } else {
//            responseResult = new ResponseResult<>(ResponseEnum.NO_USER);
//        }
//        return responseResult;
//    }
//
//    @Reference
//    private UserService userService;
}
