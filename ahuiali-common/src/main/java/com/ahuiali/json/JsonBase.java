package com.ahuiali.json;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * json的公共类
 */
@Component
@Scope("prototype")
@Data
public class JsonBase {

    //返回码
    Integer code;

    //返回信息
    String message;

    //设置信息
    public void create(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
