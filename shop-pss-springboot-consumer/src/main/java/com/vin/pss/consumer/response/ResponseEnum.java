package com.vin.pss.consumer.response;

import lombok.Getter;

/**
 * @Description 遵循阿里规范
 * @Author Vincent Chiu
 * @Date 2020-10-28 15:02
 */
@Getter
public enum ResponseEnum {
    //系统状态码
    SUCCESS("0", "请求成功"),
    ERROR("-1", "系统错误"),
    //业务状态码
    HAS_USER("A10001", "用户存在"),
    NO_USER("A10002", "用户不存在"),
    NO_LOGIN("A10003", "用户未登陆");

    private final String code;
    private final String message;

    ResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static void main(String[] args) {
        System.out.println(ResponseEnum.SUCCESS.getCode());
        System.out.println(ResponseEnum.SUCCESS.getMessage());
    }
}
