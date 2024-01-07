package com.parkh.cleancode.ch09.product;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductMapperImpl implements ProductMapper {
    @Override
    public List<Product> getProducts(){
        return List.of(
                new Product("1", "진짜 상품A", 1000)
        );
    };
}
