package com.example.demo.service.impl;

import com.example.demo.DTO.CartDTO;
import com.example.demo.dataObject.ProductInfo;
import com.example.demo.enums.ProductStatusEnums;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.SellException;
import com.example.demo.repository.ProductInfoRepostory;
import com.example.demo.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductInfoServiceImpl implements  ProductInfoService{
    @Autowired
    private ProductInfoRepostory productInfoRepostory;

    @Override
    public ProductInfo findOne(String producrId) {
        return productInfoRepostory.findOne(producrId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepostory.findByProductStatus(ProductStatusEnums.UP.getProductStatus());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepostory.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepostory.save(productInfo);
    }


    //增加库存
    @Override
    @Transactional
    public void IncreaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO:cartDTOList){
            ProductInfo productInfo = productInfoRepostory.findOne(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //剩余库存= 现库存 - 该商品订单数量
            Integer productNum = productInfo.getProductStock() + cartDTO.getProductQuantity();
            if (productNum < 0) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //更新库存
            productInfo.setProductStock(productNum);
            productInfoRepostory.save(productInfo);
        }
    }
    //扣除库存
    @Override
    @Transactional
    public void DecreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO:cartDTOList) {
          ProductInfo productInfo = productInfoRepostory.findOne(cartDTO.getProductId());
          if (productInfo == null) {
              throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
          }
          //剩余库存= 现库存 - 该商品订单数量
          Integer productNum = productInfo.getProductStock() - cartDTO.getProductQuantity();
          if (productNum < 0) {
              throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
          }
          //更新库存
          productInfo.setProductStock(productNum);
          productInfoRepostory.save(productInfo);
        }
    }



}