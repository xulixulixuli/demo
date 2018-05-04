package com.example.demo.utils;

import com.example.demo.VO.RequestVO;

public class ResultVOUtil {
    //成功
    public  static RequestVO success(Object object){
        RequestVO requestVO = new RequestVO();
        requestVO.setCode(0);
        requestVO.setMsg("成功");
        requestVO.setData(object);
        return  requestVO;
    }

    public  static RequestVO success(){
        return  success(null);
    }
    //失败
    public  static RequestVO error (Integer code,String msg){
        RequestVO requestVO = new RequestVO();
        requestVO.setCode(code);
        requestVO.setMsg(msg);
        return  requestVO;
    }
}
