package com.example.demo.utils;

import java.util.Random;

public class KeyUtil {
    /**
     * 生成订单id-唯一随机数
     * @return
     */
    //加上一个线程锁关键字，以免并发时重复ID
    public static synchronized String getUniqueKey(){
        Random random =  new Random();
        Integer number = random.nextInt(900000) + 100000;
        //系统毫秒数加上6未随机数
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
