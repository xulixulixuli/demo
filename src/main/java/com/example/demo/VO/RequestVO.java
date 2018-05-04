package com.example.demo.VO;

import lombok.Data;

/**
 * HTTP请求返回的最外层对象
 */

@Data
public class RequestVO<T>{
    /**错误码*/
    private Integer code;
    /**提示信息*/
    private String msg;
    /**返回具体内容*/
    private T data;
}
