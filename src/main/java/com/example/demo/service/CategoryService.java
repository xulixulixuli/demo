package com.example.demo.service;

import com.example.demo.dataObject.ProductCategory;

import java.util.List;

public interface CategoryService {
     /**通过id查询*/
     ProductCategory findOne(Integer catecoryId);
     /**查询所有*/
     List<ProductCategory> findAll();
     /**根据TYPE查询*/
     List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
     /**增加*/
     ProductCategory save(ProductCategory productCategory);
}
