package com.example.demo.service.impl;

import com.example.demo.dataObject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {
    @Autowired
    private  ProductInfoServiceImpl productInfoService;

    @Test
    public void findOne() throws Exception {
        ProductInfo productInfo = productInfoService.findOne("10001");
        Assert.assertEquals("10001",productInfo.getProductId());
    }
    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> list = productInfoService.findUpAll();
        Assert.assertNotEquals(0,list.size());
    }
    @Test
    public void findAll() throws Exception {
        PageRequest request = new PageRequest(0,2);
        Page<ProductInfo> productInfoPage = productInfoService.findAll(request);
        System.out.println(productInfoPage.getTotalElements());
    }
    @Test
    public void save() throws Exception {
        ProductInfo productInfo =  new ProductInfo();
        productInfo.setProductId("10002");
        productInfo.setProductName("玉米香甜粥");
        productInfo.setProductDescription("好吃不贵");
        productInfo.setProductIcon("http://xxxx.com");
        productInfo.setProductPrice(new BigDecimal(3.5));
        productInfo.setCategoryType(1);
        productInfo.setProductStatus(0);
        productInfo.setProductStock(100);
        ProductInfo result = productInfoService.save(productInfo);
        Assert.assertNotNull(result);
    }

}