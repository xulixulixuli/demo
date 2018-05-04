package com.example.demo.enums;
import lombok.Getter;

@Getter
public enum  ProductStatusEnums {
    UP(0,"上架"),
    DOWN(1,"下架");

    private Integer productStatus;
    private String message;

    ProductStatusEnums(Integer productStatus,String message) {
        this.productStatus = productStatus;
        this.message = message;
    }
}
