package com.example.demo.exception;

import com.example.demo.enums.ResultEnum;

public class SellException extends RuntimeException {
    private Integer code;
    //构造方法1
    public  SellException(ResultEnum resultEnum){
        super(resultEnum.getMessage());//继承RuntimeException
        this.code = resultEnum.getCode();
    }
    //构造方法2
    public  SellException(Integer code,String message){
        super(message);//继承RuntimeException
        this.code = code;
    }
}
