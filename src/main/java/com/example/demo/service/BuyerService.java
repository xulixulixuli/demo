package com.example.demo.service;

import com.example.demo.DTO.OrderDTO;

public interface BuyerService {
    //根据用户id和订单id查询一个订单详情
    OrderDTO findOrderOne(String openid, String orderId);
    //根据用户id和订单id取消一个订单
    OrderDTO cancelOrder(String openid, String orderId);
}
