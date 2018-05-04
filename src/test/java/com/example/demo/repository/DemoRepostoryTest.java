package com.example.demo.repository;

import com.example.demo.dataObject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoRepostoryTest {
    @Autowired
    private DemoRepostory demoRepostory;

    @Test
    public  void findone(){
        ProductCategory  productCategory = demoRepostory.findOne(1);
        System.out.println(productCategory.toString());
    }
    @Test
    public void save(){
        ProductCategory  productCategory = demoRepostory.findOne(2);
        productCategory.setCategoryName("王磊");
        demoRepostory.save(productCategory);
    }
    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(1,2);
        List<ProductCategory> list1 =  demoRepostory.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,list1.size());

    }


}