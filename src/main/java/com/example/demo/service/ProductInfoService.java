package com.example.demo.service;

import com.example.demo.DTO.CartDTO;
import com.example.demo.dataObject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductInfoService {
    /**根据id查询*/
    ProductInfo findOne(String producrId);
    /**查询所有正在上架的*/
    List<ProductInfo> findUpAll();
    /**分页查询*/
    Page<ProductInfo> findAll(Pageable pageable);
    /**新增**/
    ProductInfo save(ProductInfo productInfo);
    /**加库存**/
    void IncreaseStock(List<CartDTO> cartDTOList);
    /**减库存**/
    void DecreaseStock(List<CartDTO> cartDTOList);
}
