package com.parkh.cleancode.ch09.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;

    public List<Product> getProducts() {
        return productMapper.getProducts();
    }

}
