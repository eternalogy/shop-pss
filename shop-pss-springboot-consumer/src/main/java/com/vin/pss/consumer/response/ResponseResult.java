package com.vin.pss.consumer.response;

import lombok.Data;

/**
 * @Description TODO
 * @Author Vincent Chiu
 * @Date 2020-10-28 15:03
 */
@Data
public class ResponseResult<T> {

    public ResponseResult(ResponseEnum responseEnum, T data) {
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
        this.data = data;
    }

    public ResponseResult(ResponseEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }

    private String code;
    private String message;
    private T data;
}
