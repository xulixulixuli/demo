package com.example.demo.service.impl;

import com.example.demo.dataObject.ProductCategory;
import com.example.demo.repository.DemoRepostory;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private DemoRepostory demoRepostory;

    @Override
    public ProductCategory findOne(Integer catecoryId) {
        return demoRepostory.findOne(catecoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return demoRepostory.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return  demoRepostory.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return demoRepostory.save(productCategory);
    }
}
