package com.example.demo.repository;

import com.example.demo.dataObject.ProductInfo;
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
public class ProductInfoRepostoryTest {
    @Autowired
    private  ProductInfoRepostory productInfoRepostory;
    @Test
    public void  savaTest(){
        ProductInfo productInfo =  new ProductInfo();
        productInfo.setProductId("10001");
        productInfo.setProductName("皮蛋瘦肉粥");
        productInfo.setProductDescription("好吃不贵");
        productInfo.setProductIcon("http://xxxx.com");
        productInfo.setProductPrice(new BigDecimal(6.9));
        productInfo.setCategoryType(2);
        productInfo.setProductStatus(0);
        productInfo.setProductStock(100);
        ProductInfo result = productInfoRepostory.save(productInfo);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByProductStatusTest(){
        List<ProductInfo> list = productInfoRepostory.findByProductStatus(0);
        Assert.assertNotEquals(0,list.size());
    }



}