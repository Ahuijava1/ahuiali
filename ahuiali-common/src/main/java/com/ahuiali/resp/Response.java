package com.ahuiali.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * 公共返回类
 * @author ZhengChaoHui
 * @Date 2020/9/19 22:16
 */
@Data
public class Response<T> implements Serializable {

    final static String SUCCESS = "200";
    final static String SUCCESS_MESSAGE = "success";

    private String code;
    private String message;

    private T data;

    public static <T> Response<T> success(){
        Response<T> response = new Response<>();
        response.setCode(SUCCESS);
        response.setMessage(SUCCESS_MESSAGE);
        return response;
    }

    public Response() {
        super();
    }

    public Response(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Response(Result result) {
        this.code = result.getCode();
        this.message = result.getMessage();
    }

    public static <T> Response<T> result(Result result) {
        return new Response<T>(result);
    }

    public static Response<?> result(Response<?> response, Result result){
        response.setCode(result.getCode());
        response.setMessage(result.getMessage());
        return response;
    }

    public void putResult(Result result, Response<T> response) {
        response.setCode(result.getCode());
        response.setMessage(result.getMessage());
    }

    public void putResult(Result result) {
        this.setCode(result.getCode());
        this.setMessage(result.getMessage());
    }

    public static Boolean isSuccess(Response<?> response){
        return  SUCCESS.equals(response.getCode());
    }

}
