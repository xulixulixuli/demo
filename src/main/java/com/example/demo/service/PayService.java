package com.example.demo.service;

import com.example.demo.DTO.OrderDTO;

public interface PayService {

    void create(OrderDTO orderDTO);
//      PayResponse create(OrderDTO orderDTO);
//
//      PayResponse notify(String notifyData);
//
//    RefundResponse refund(OrderDTO orderDTO);
}
