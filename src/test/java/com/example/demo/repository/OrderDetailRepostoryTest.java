package com.example.demo.repository;

import com.example.demo.dataObject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepostoryTest {
    @Autowired
    private OrderDetailRepostory orderDetailRepostory;
    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1234567810");
        orderDetail.setOrderId("11111112");
        orderDetail.setProductIcon("http://xxxx.jpg");
        orderDetail.setProductId("11111112");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(2.2));
        orderDetail.setProductQuantity(3);
        OrderDetail result = orderDetailRepostory.save(orderDetail);
        Assert.assertNotNull(result);
 }
    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> orderDetailList =  orderDetailRepostory.findByOrderId("11111112");
        Assert.assertEquals(1,orderDetailList.size());
    }

}